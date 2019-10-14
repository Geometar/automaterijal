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
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailPreparationException;
import org.springframework.mail.MailSendException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/email")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class EmailController {

    @NonNull
    final EmailService emailService;

    @PostMapping(value = "/registracija")
    public ResponseEntity registracioniMail(@RequestBody final RegistracijaDto dto) {
        log.info("Registracija mail podaci: email =  {}, firma = {}, imeIPrezime = {}",
                dto.getEmail(),
                dto.getNazivFirme(),
                dto.getImeIPrezime());

        emailService.posaljiRegistracioniEmail(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/zaboravljena-sifra")
    public ResponseEntity zaboravljenaSifraMail(@RequestBody final ZaboravljenaSifraDto dto, @RequestHeader final String host) {
        log.info("Zaboravljena Sifra mail: email ili username = {}", dto.getEmail());
        try {
            emailService.posaljiZaboravljenaSifraMail(dto, host);
            return ResponseEntity.ok().build();
        } catch (final MailSendException ex) {
            return ResponseEntity.badRequest().build();
        } catch(final MailPreparationException ex) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @PostMapping(value = "/poruka")
    public ResponseEntity posaljiPorukuMail(@RequestBody final PorukaDto dto) {
        log.info("Poruka mail: ime = {}, poruka = {}", dto.getIme(),  dto.getPoruka());
        emailService.posaljiPoruku(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/upit")
    public ResponseEntity upitMail(@RequestBody final UpitDto dto) {
        log.info("Upit mail: upit za = {}", dto.getInteresujeMe());
        emailService.posaljiUpitMail(dto);
        return ResponseEntity.ok().build();
    }
}
