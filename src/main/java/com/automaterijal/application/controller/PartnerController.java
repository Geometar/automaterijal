package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.PartnerDto;
import com.automaterijal.application.services.UsersService;
import com.automaterijal.application.services.security.UserDetailsService;
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

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/partner")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class PartnerController {

    @NotNull
    final UserDetailsService service;

    @NonNull
    final
    UsersService usersService;

    @GetMapping
    public ResponseEntity<PartnerDto> vratiUlogovanogPartnera() {
        final PartnerDto dto = service.vratiUlogovanogKorisnika();
        if(dto != null) {
            usersService.logovanomUseruPovecajKolikoSePutaLogovao(483);
            return new ResponseEntity(dto, HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
