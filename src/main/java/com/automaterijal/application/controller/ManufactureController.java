package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.ProizvodjacDTO;
import com.automaterijal.application.services.ProizvodjacService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/manufactures")
@RequiredArgsConstructor
public class ManufactureController {

  private final ProizvodjacService proizvodjacService;

  @GetMapping("/{slug}")
  public ResponseEntity<ProizvodjacDTO> getBySlug(@PathVariable String slug) {
    return proizvodjacService
        .findBySlug(slug)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }
}
