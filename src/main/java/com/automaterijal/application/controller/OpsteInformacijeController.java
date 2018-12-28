package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.ValueHelpDto;
import com.automaterijal.application.services.OpsteInformacijeService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/informacije")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class OpsteInformacijeController {

    @NonNull
    final OpsteInformacijeService opsteInformacijeService;

    @GetMapping(value = "/placanje")
    public ResponseEntity<List<ValueHelpDto>> vratiNacinePlacanja() {
        return ResponseEntity.ok(opsteInformacijeService.vratiSveNacinePlacanja());
    }

    @GetMapping(value = "/prevoz")
    public ResponseEntity<List<ValueHelpDto>> vratiNacinPrevoza() {
        return ResponseEntity.ok(opsteInformacijeService.vratiSveNacinePrevoza());
    }

}
