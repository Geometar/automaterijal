package com.automaterijal.application.exception;

import com.automaterijal.application.domain.dto.checkout.CheckoutConflictDetailsDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Getter
public class CheckoutConflictException extends ResponseStatusException {

  private final CheckoutConflictDetailsDto details;

  public CheckoutConflictException(String reason, CheckoutConflictDetailsDto details) {
    super(HttpStatus.CONFLICT, reason);
    this.details = details;
  }
}
