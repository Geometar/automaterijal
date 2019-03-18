package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.email.PorukaDto;
import com.automaterijal.application.domain.dto.email.RegistracijaDto;
import com.automaterijal.application.domain.dto.email.UpitDto;
import com.automaterijal.application.domain.dto.email.ZaboravljenaSifraDto;
import com.automaterijal.application.services.email.EmailService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSendException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/email")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailController {

    @NonNull
    final EmailService emailService;

    @PostMapping(value = "/registracija")
    public ResponseEntity registracioniMail(@RequestBody final RegistracijaDto dto) {
        emailService.posaljiRegistracioniEmail(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/zaboravljena-sifra")
    public ResponseEntity zaboravljenaSifraMail(@RequestBody final ZaboravljenaSifraDto dto, @RequestHeader final String host) {
        try {
            emailService.posaljiZaboravljenaSifraMail(dto, host);
            return ResponseEntity.ok().build();
        } catch (final MailSendException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(value = "/poruka")
    public ResponseEntity posaljiPorukuMail(@RequestBody final PorukaDto porukaDto) {
        emailService.posaljiPoruku(porukaDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/upit")
    public ResponseEntity upitMail(@RequestBody final UpitDto upitDto) {
        emailService.posaljiUpitMail(upitDto);
        return ResponseEntity.ok().build();
    }
}
