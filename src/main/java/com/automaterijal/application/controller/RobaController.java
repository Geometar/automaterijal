package com.automaterijal.application.controller;

import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.AkumulatoriService;
import com.automaterijal.application.services.FilterService;
import com.automaterijal.application.services.RobaGlavniService;
import com.automaterijal.application.services.UljaService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            @RequestParam(required = false) final String searchTerm
    ) {
        final Integer iPage = page == null ? 0 : page;
        final Integer iPageSize = pageSize == null ? 10 : pageSize;
        final String iProizvodjac = proizvodjac == null ? null : proizvodjac;
        final Boolean iNaStanju = naStanju == null ? true : naStanju;
        final RobaSortiranjePolja iSortiranjePolja = sortBy == null ? RobaSortiranjePolja.KATBR : sortBy;
        final Sort.Direction iDirection = sortDirection == null ? Sort.Direction.ASC: sortDirection;
        final String iSearchTerm = searchTerm == null ? null : searchTerm.trim().toUpperCase();
        popuniParametreZaServis(iPage, iPageSize, iProizvodjac, iNaStanju, iSortiranjePolja, iDirection, iSearchTerm);

        final Page<RobaDto> roba = robaGlavniService.pronadjiRobuPoPretrazi(
                popuniParametreZaServis(iPage, iPageSize, iProizvodjac, iNaStanju, iSortiranjePolja, iDirection, iSearchTerm)
        );

        if(!CollectionUtils.isEmpty(roba.getContent())) {
            return new ResponseEntity(roba, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/filteri")
    public ResponseEntity<Page<RobaDto>> pronadjiSveFiltere(
            @RequestParam(required = false) final Integer page,
            @RequestParam(required = false) final Integer pageSize,
            @RequestParam(required = false) final RobaSortiranjePolja sortBy,
            @RequestParam(required = false) final Sort.Direction sortDirection,
            @RequestParam(required = false) final String proizvodjac,
            @RequestParam(required = false) final Boolean naStanju,
            @RequestParam(required = false) final String searchTerm
    ) {
        final Integer iPage = page == null ? 0 : page;
        final Integer iPageSize = pageSize == null ? 10 : pageSize;
        final String iProizvodjac = proizvodjac == null ? null : proizvodjac;
        final Boolean iNaStanju = naStanju == null ? true : naStanju;
        final RobaSortiranjePolja iSortiranjePolja = sortBy == null ? RobaSortiranjePolja.KATBR : sortBy;
        final Sort.Direction iDirection = sortDirection == null ? Sort.Direction.ASC: sortDirection;
        final String iSearchTerm = searchTerm == null ? null : searchTerm.trim().toUpperCase();
        final Page<RobaDto> roba =  filterService.pronadjiSveFiltere(
                popuniParametreZaServis(iPage, iPageSize, iProizvodjac, iNaStanju, iSortiranjePolja, iDirection, iSearchTerm)
        );

        if(!CollectionUtils.isEmpty(roba.getContent())) {
            return new ResponseEntity(roba, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/akumulatori")
    public ResponseEntity<Page<RobaDto>> pronadjiSveAkumulatore(
            @RequestParam(required = false) final Integer page,
            @RequestParam(required = false) final Integer pageSize,
            @RequestParam(required = false) final RobaSortiranjePolja sortBy,
            @RequestParam(required = false) final Sort.Direction sortDirection,
            @RequestParam(required = false) final String proizvodjac,
            @RequestParam(required = false) final Boolean naStanju,
            @RequestParam(required = false) final String searchTerm
    ) {
        final Integer iPage = page == null ? 0 : page;
        final Integer iPageSize = pageSize == null ? 10 : pageSize;
        final String iProizvodjac = proizvodjac == null ? null : proizvodjac;
        final Boolean iNaStanju = naStanju == null ? true : naStanju;
        final RobaSortiranjePolja iSortiranjePolja = sortBy == null ? RobaSortiranjePolja.KATBR : sortBy;
        final Sort.Direction iDirection = sortDirection == null ? Sort.Direction.ASC: sortDirection;
        final String iSearchTerm = searchTerm == null ? null : searchTerm.trim().toUpperCase();

        final Page<RobaDto> roba =  akumulatoriService.pronadjiSveAkumulatore(
                popuniParametreZaServis(iPage, iPageSize, iProizvodjac, iNaStanju, iSortiranjePolja, iDirection, iSearchTerm)
        );


        if(!CollectionUtils.isEmpty(roba.getContent())) {
            return new ResponseEntity(roba, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
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
            @RequestParam(required = false) final String searchTerm
    ) {
        final Integer iPage = page == null ? 0 : page;
        final Integer iPageSize = pageSize == null ? 10 : pageSize;
        final String iProizvodjac = proizvodjac == null ? null : proizvodjac;
        final Boolean iNaStanju = naStanju == null ? true : naStanju;
        final RobaSortiranjePolja iSortiranjePolja = sortBy == null ? RobaSortiranjePolja.KATBR : sortBy;
        final Sort.Direction iDirection = sortDirection == null ? Sort.Direction.ASC: sortDirection;
        final String iSearchTerm = searchTerm == null ? null : searchTerm.trim().toUpperCase();

        final Page<RobaDto> roba =  uljaService.pronadjiSvaUlja(
                popuniParametreZaServis(iPage, iPageSize, iProizvodjac, iNaStanju, iSortiranjePolja, iDirection, iSearchTerm),
                vrstaUlja
        );

        if(!CollectionUtils.isEmpty(roba.getContent())) {
            return new ResponseEntity(roba, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    private UniverzalniParametri popuniParametreZaServis(final Integer internalPage, final Integer internalPageSize, final String internalProizvodjac, final Boolean internalNaStanju, final RobaSortiranjePolja internalSortiranjePolja, final Sort.Direction internalDirection, final String internalSearchTerm) {
        return new UniverzalniParametri(internalPage, internalPageSize, internalProizvodjac, internalNaStanju, internalSortiranjePolja, internalDirection, internalSearchTerm);
    }
}
