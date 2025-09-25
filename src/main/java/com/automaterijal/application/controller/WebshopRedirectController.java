package com.automaterijal.application.controller;

import com.automaterijal.application.services.roba.details.RobaDetailsService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/webshop")
@RequiredArgsConstructor
public class WebshopRedirectController {

  private final RobaDetailsService robaDetailsService;

  @GetMapping("/{robaId:[0-9]+}")
  public ResponseEntity<Void> redirectById(@PathVariable Long robaId) {
    String slugPath =
        robaDetailsService
            .findSlugPathById(robaId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    URI uri = URI.create("/webshop/" + slugPath);
    return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).location(uri).build();
  }
}
