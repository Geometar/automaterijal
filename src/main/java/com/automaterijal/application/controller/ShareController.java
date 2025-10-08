package com.automaterijal.application.controller;

import com.automaterijal.application.services.share.ProductShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping(value = "/share", produces = MediaType.TEXT_HTML_VALUE)
@RequiredArgsConstructor
public class ShareController {

  private final ProductShareService productShareService;

  @GetMapping("/webshop/{robaId:[0-9]+}")
  @ResponseBody
  public ResponseEntity<String> shareWebshopProduct(@PathVariable Long robaId) {
    return productShareService
        .buildProductSharePage(robaId)
        .map(ResponseEntity::ok)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }
}
