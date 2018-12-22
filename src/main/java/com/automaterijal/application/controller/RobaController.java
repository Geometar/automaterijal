package com.automaterijal.application.controller;

import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.roba.AkumulatoriService;
import com.automaterijal.application.services.roba.FilterService;
import com.automaterijal.application.services.roba.RobaGlavniService;
import com.automaterijal.application.services.roba.UljaService;
import com.automaterijal.application.utils.PartnerStaticUtils;
import com.automaterijal.application.utils.RobaStaticUtils;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roba")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class RobaController {

    @NonNull
    final RobaGlavniService robaGlavniService;
    @NonNull
    final FilterService filterService;
    @NonNull
    final UljaService uljaService;
    @NonNull
    final AkumulatoriService akumulatoriService;

    @GetMapping
    public ResponseEntity<Page<RobaDto>> pronadjiSvuRobu(
            @RequestParam(required = false) final Integer page,
            @RequestParam(required = false) final Integer pageSize,
            @RequestParam(required = false) final RobaSortiranjePolja sortBy,
            @RequestParam(required = false) final Sort.Direction sortDirection,
            @RequestParam(required = false) final String proizvodjac,
            @RequestParam(required = false) final Boolean naStanju,
            @RequestParam(required = false) final String searchTerm,
            final Authentication authentication
    ) {

        final UniverzalniParametri univerzalniParametri = RobaStaticUtils.popuniIVratiGenerickeParametreZaServis(page, pageSize, sortBy, sortBy, proizvodjac, naStanju, sortBy, sortDirection, searchTerm);
        final Partner ulogovaniPartner = PartnerStaticUtils.vratiPartneraIsSesije(authentication);

        final Page<RobaDto> roba = robaGlavniService.pronadjiRobuPoPretrazi(
                univerzalniParametri, ulogovaniPartner
        );

        if (!CollectionUtils.isEmpty(roba.getContent())) {
            return ResponseEntity.ok(roba);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/filteri")
    public ResponseEntity<Page<RobaDto>> pronadjiSveFiltere(
            @RequestParam(required = false) final Integer page,
            @RequestParam(required = false) final Integer pageSize,
            @RequestParam(required = false) final RobaSortiranjePolja sortBy,
            @RequestParam(required = false) final Sort.Direction sortDirection,
            @RequestParam(required = false) final String proizvodjac,
            @RequestParam(required = false) final Boolean naStanju,
            @RequestParam(required = false) final String searchTerm,
            final Authentication authentication
    ) {
        final UniverzalniParametri univerzalniParametri = RobaStaticUtils.popuniIVratiGenerickeParametreZaServis(page, pageSize, sortBy, sortBy, proizvodjac, naStanju, sortBy, sortDirection, searchTerm);
        final Partner ulogovaniPartner = PartnerStaticUtils.vratiPartneraIsSesije(authentication);
        final Page<RobaDto> roba = filterService.pronadjiSveFiltere(
                univerzalniParametri, ulogovaniPartner
        );

        if (!CollectionUtils.isEmpty(roba.getContent())) {
            return ResponseEntity.ok(roba);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/akumulatori")
    public ResponseEntity<Page<RobaDto>> pronadjiSveAkumulatore(
            @RequestParam(required = false) final Integer page,
            @RequestParam(required = false) final Integer pageSize,
            @RequestParam(required = false) final RobaSortiranjePolja sortBy,
            @RequestParam(required = false) final Sort.Direction sortDirection,
            @RequestParam(required = false) final String proizvodjac,
            @RequestParam(required = false) final Boolean naStanju,
            @RequestParam(required = false) final String searchTerm,
            final Authentication authentication
    ) {

        final UniverzalniParametri univerzalniParametri = RobaStaticUtils.popuniIVratiGenerickeParametreZaServis(page, pageSize, sortBy, sortBy, proizvodjac, naStanju, sortBy, sortDirection, searchTerm);
        final Partner ulogovaniPartner = PartnerStaticUtils.vratiPartneraIsSesije(authentication);

        final Page<RobaDto> roba = akumulatoriService.pronadjiSveAkumulatore(
                univerzalniParametri, ulogovaniPartner
        );

        if (!CollectionUtils.isEmpty(roba.getContent())) {
            return ResponseEntity.ok(roba);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/ulja/{vrsta}")
    public ResponseEntity<Page<RobaDto>> pronadjiUlje(
            @PathVariable("vrsta") final String vrstaUlja,
            @RequestParam(required = false) final Integer page,
            @RequestParam(required = false) final Integer pageSize,
            @RequestParam(required = false) final RobaSortiranjePolja sortBy,
            @RequestParam(required = false) final Sort.Direction sortDirection,
            @RequestParam(required = false) final String proizvodjac,
            @RequestParam(required = false) final Boolean naStanju,
            @RequestParam(required = false) final String searchTerm,
            final Authentication authentication
    ) {
        final UniverzalniParametri univerzalniParametri = RobaStaticUtils.popuniIVratiGenerickeParametreZaServis(page, pageSize, sortBy, sortBy, proizvodjac, naStanju, sortBy, sortDirection, searchTerm);
        final Partner ulogovaniPartner = PartnerStaticUtils.vratiPartneraIsSesije(authentication);

        final Page<RobaDto> roba = uljaService.pronadjiSvaUlja(
                univerzalniParametri, vrstaUlja, ulogovaniPartner
        );

        if (!CollectionUtils.isEmpty(roba.getContent())) {
            return ResponseEntity.ok(roba);
        }
        return ResponseEntity.notFound().build();
    }
}
