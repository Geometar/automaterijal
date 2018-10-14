package com.automaterijal.application.controller;

import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.services.constants.ProizvodjacService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/proizvodjaci")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class ProizvodjacController {

    @NonNull
    final ProizvodjacService proizvodjacService;

    @GetMapping
    public ResponseEntity<List<Proizvodjac>> pronadjiSve() {
        return new ResponseEntity(proizvodjacService.getProizvodjaci(), HttpStatus.OK);
    }
}
