package com.automaterijal.application.controller;

import com.automaterijal.application.domain.constants.RobaKategorije;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.services.ProizvodjacService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proizvodjaci")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class ProizvodjacController {

    @NonNull
    final ProizvodjacService proizvodjacService;

    @GetMapping
    public ResponseEntity<List<Proizvodjac>> pronadjiSve() {
        return ResponseEntity.ok(proizvodjacService.pronadjiSveProizvodjace());
    }
    @GetMapping(value = "/filteri")
    public ResponseEntity<List<Proizvodjac>> pronadjiSveProizvodjaceFiltera() {
        return ResponseEntity.ok(proizvodjacService.proizvodjaciFiltera());
    }
    @GetMapping(value = "/akumulatori")
    public ResponseEntity<List<Proizvodjac>> pronadjiSveProizvodjaceAkumulatora() {
        return ResponseEntity.ok(proizvodjacService.proizvodjaciAkumulatora());
    }
    @GetMapping(value = "/ulja/{vrsta}")
    public ResponseEntity<List<Proizvodjac>> pronadjiSveProizvodjaceUlja(
            @PathVariable("vrsta") final String vrstaUlja
    ) {
        return ResponseEntity.ok(proizvodjacService.proizvodjaciUlja(vrstaUlja));
    }
    @GetMapping(value = "/kategorija/{kategorija}")
    public ResponseEntity<List<Proizvodjac>> pronadjiSveProizvodjaceUlja(
            @PathVariable("kategorija") final RobaKategorije kategorija
    ) {
        return ResponseEntity.ok(proizvodjacService.porizvodjacZaKategoriju(kategorija.getFieldName()));
    }
}
