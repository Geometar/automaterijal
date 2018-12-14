package com.automaterijal.application.controller;

import com.automaterijal.application.domain.dto.FakturaDto;
import com.automaterijal.application.domain.model.CurrentUser;
import com.automaterijal.application.services.FakturaService;
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

    @GetMapping(value = "/{ppid}")
    public ResponseEntity<Page<FakturaDto>> vratiSveFaktureKorisnika(
            @RequestParam(required = false) final Integer page,
            @RequestParam(required = false) final Integer pageSize,
            @PathVariable(name = "ppid") final Integer ppid,
            final Authentication authentication
    ) {
        final Integer iPage = page == null ? 0 : page;
        final Integer iPageSize = pageSize == null ? 10 : pageSize;

        if (authentication == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        final CurrentUser user = (CurrentUser) authentication.getPrincipal();

        if (ppid != null && ppid.intValue() != user.getId().intValue()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        final Page<FakturaDto> fakture = fakturaService.vratiSveFaktureUlogovanogKorisnika(user.vratiPartnera(), iPage, iPageSize);
        return new ResponseEntity<>(fakture, HttpStatus.OK);
    }

    @GetMapping(value = "/{ppid}/{id}")
    public ResponseEntity<FakturaDto> vratiFakturu(
            @PathVariable(name = "ppid") final Integer ppid,
            @PathVariable(name = "id") final Integer id,
            final Authentication authentication
    ) {
        if (authentication == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        final CurrentUser user = (CurrentUser) authentication.getPrincipal();

        if (ppid != null && ppid.intValue() != user.getId().intValue()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        final FakturaDto fakture = fakturaService.vratiFakuturuPojedinacno(user.vratiPartnera(), id);
        if(fakture != null) {
            return new ResponseEntity<>(fakture, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
