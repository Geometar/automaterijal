package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.PartnerDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.services.PartnerService;
import com.automaterijal.application.services.security.UserDetailsService;
import com.automaterijal.application.services.security.UsersService;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
    final UsersService usersService;

    @NonNull
    final PartnerService partnerService;

    @NonNull
    final PartnerSpringBeanUtils partnerSpringBeanUtils;

    @GetMapping
    public ResponseEntity<PartnerDto> vratiUlogovanogPartnera(final Authentication authentication) {
        final PartnerDto dto = service.vratiUlogovanogKorisnika(authentication);
        if(dto != null) {
            usersService.logovanomUseruPovecajKolikoSePutaLogovao(dto.getPpid());
            return ResponseEntity.ok(dto);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<PartnerDto> updejtujPartnera(@RequestBody final PartnerDto partnerDto, final Authentication authentication) {
        final Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
        if(partner.getPpid().intValue() != partnerDto.getPpid().intValue()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if(partnerDto.getWebKorisnik() != null
                && !partnerDto.getWebKorisnik().equals(partner.getWebKorisnik())
                && partnerService.daLiPostojiVecZauzetaRegistracije(partnerDto)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }
        final PartnerDto response = partnerService.updejtPartnera(partnerDto, authentication);
        if(response == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(response);
    }
}
