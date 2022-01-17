package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.tecdoc.Dokument;
import com.automaterijal.application.services.TecDocService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tecdoc")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class TecDocController {


    @NonNull
    final TecDocService tecDocService;

    /**
     * Sa dobijenim dokument id-jem, vracamo nazamo byte[] dokument
     */
    @GetMapping(value = "dokument/{dokumentId}")
    public ResponseEntity<Dokument> vratiRobuPojedinacno(@PathVariable("dokumentId") String dokumentId) {
        return ResponseEntity.ok(new Dokument(tecDocService.vratiDokument(dokumentId, 0)));
    }
}
