package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.FakturaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.services.FakturaService;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fakture")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class FakturaController {

    @NonNull
    final FakturaService fakturaService;
    @NonNull
    final PartnerSpringBeanUtils partnerSpringBeanUtils;

    @GetMapping(value = "/{ppid}")
    public ResponseEntity<Page<FakturaDto>> vratiSveFaktureKorisnika(
            @RequestParam(required = false) final Integer page,
            @RequestParam(required = false) final Integer pageSize,
            @PathVariable(name = "ppid") final Integer ppid,
            final Authentication authentication
    ) {
        final Integer iPage = page == null ? 0 : page;
        final Integer iPageSize = pageSize == null ? 10 : pageSize;

        final Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
        if(partner == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else if (ppid != null && ppid.intValue() != partner.getPpid().intValue()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        final Page<FakturaDto> fakture = fakturaService.vratiSveFaktureUlogovanogKorisnika(partner, iPage, iPageSize);
        return ResponseEntity.ok(fakture);
    }

    @PostMapping
    public ResponseEntity<FakturaDto> podnesiFakturu(@RequestBody final FakturaDto fakturaDto, final Authentication authentication) {
        final Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);

        if(partner == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        final FakturaDto response = fakturaService.sacuvajFakturu(fakturaDto, partner);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{ppid}/{id}")
    public ResponseEntity<FakturaDto> vratiFakturu(
            @PathVariable(name = "ppid") final Integer ppid,
            @PathVariable(name = "id") final Integer id,
            final Authentication authentication
    ) {
        final Partner partner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);

        if(partner == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else if (ppid != null && ppid.intValue() != partner.getPpid().intValue()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        final FakturaDto fakture = fakturaService.vratiFakuturuPojedinacno(partner, id);
        if (fakture != null) {
            return ResponseEntity.ok(fakture);
        }
        return ResponseEntity.notFound().build();
    }
}
