package com.automaterijal.application.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
@Slf4j
public class GlobalControllerAdvice {

  @ExceptionHandler(ClientAbortException.class)
  public ResponseEntity<String> handleClientAbortException(ClientAbortException ex) {
    log.error("Client disconnected before response completed: ", ex);
    return ResponseEntity.noContent().build();
  }

  /** Handle UnauthorizedException globally. */
  @ExceptionHandler(ResponseStatusException.class)
  public ResponseEntity<Object> handleResponseStatusException(
      ResponseStatusException ex, WebRequest request) {
    Map<String, Object> body = new HashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("status", ex.getStatusCode());
    body.put("error", ex.getReason());
    body.put("message", ex.getMessage());
    body.put("path", request.getDescription(false));

    log.error("Exception caught: ", ex);
    return new ResponseEntity<>(body, ex.getStatusCode());
  }

  /** Handle bad request errors (e.g., validation errors). */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
    Map<String, Object> body = new HashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("status", HttpStatus.BAD_REQUEST.value());
    body.put("error", "Validation Error");

    // Collect field validation errors
    Map<String, String> fieldErrors = new HashMap<>();
    ex.getBindingResult()
        .getFieldErrors()
        .forEach(error -> fieldErrors.put(error.getField(), error.getDefaultMessage()));

    body.put("fieldErrors", fieldErrors);
    log.error("Exception caught: ", ex);
    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }

  /** Handle generic exceptions (catch-all for runtime errors). */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
    Map<String, Object> body = new HashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
    body.put("error", "Internal Server Error");
    body.put("message", ex.getMessage());
    body.put("path", request.getDescription(false));

    log.error("Exception caught: ", ex);
    return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
