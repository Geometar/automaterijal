package com.automaterijal.application.controller;

import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.constants.VrstaRobe;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaDetaljiDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.roba.RobaGlavniService;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import com.automaterijal.application.utils.RobaSpringBeanUtils;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    final PartnerSpringBeanUtils partnerSpringBeanUtils;
    @NonNull
    final RobaSpringBeanUtils robaSpringBeanUtils;

    @GetMapping
    public ResponseEntity<Page<RobaDto>> pronadjiSvuRobu(
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> pageSize,
            @RequestParam(required = false) Optional<String> proizvodjac,
            @RequestParam(required = false) Optional<Boolean> naStanju,
            @RequestParam(required = false) Optional<String> searchTerm,
            @RequestParam(required = false) RobaSortiranjePolja sortBy,
            @RequestParam(required = false) Sort.Direction sortDirection,
            Authentication authentication
    ) {

        var univerzalniParametri = robaSpringBeanUtils.popuniIVratiGenerickeParametreZaServis(
                page, pageSize, proizvodjac, naStanju, sortBy, sortDirection, searchTerm, VrstaRobe.SVE, null, null
        );
        var uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);

        Page<RobaDto> roba = robaGlavniService.pronadjiRobuPoPretrazi(
                univerzalniParametri, uPartner
        );

        if (!CollectionUtils.isEmpty(roba.getContent())) {
            return ResponseEntity.ok().headers(createHeaders(uPartner)).body(roba);
        }
        return ResponseEntity.notFound().headers(createHeaders(uPartner)).build();
    }

    @GetMapping(value = "/{robaID}")
    public ResponseEntity<RobaDetaljiDto> vratiRobuPojedinacno(@PathVariable("robaID") Long robaId, Authentication authentication) {
        var uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
        return robaGlavniService.pronadjiRobuPoRobaId(robaId, uPartner)
                .map(roba -> ResponseEntity.ok(roba))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/filteri")
    public ResponseEntity<Page<RobaDto>> pronadjiSveFiltere(
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> pageSize,
            @RequestParam(required = false) RobaSortiranjePolja sortBy,
            @RequestParam(required = false) Sort.Direction sortDirection,
            @RequestParam(required = false) Optional<String> proizvodjac,
            @RequestParam(required = false) Optional<Boolean> naStanju,
            @RequestParam(required = false) Optional<String> searchTerm,
            Authentication authentication
    ) {
        UniverzalniParametri univerzalniParametri = robaSpringBeanUtils.popuniIVratiGenerickeParametreZaServis(
                page, pageSize, proizvodjac, naStanju, sortBy, sortDirection, searchTerm, VrstaRobe.FILTERI, null, null
        );
        Partner uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);

        Page<RobaDto> roba = robaGlavniService.pronadjiRobuPoPretrazi(
                univerzalniParametri, uPartner
        );

        if (!CollectionUtils.isEmpty(roba.getContent())) {
            return ResponseEntity.ok().headers(createHeaders(uPartner)).body(roba);
        }

        return ResponseEntity.notFound().headers(createHeaders(uPartner)).build();
    }

    @GetMapping(value = "/akumulatori")
    public ResponseEntity<Page<RobaDto>> pronadjiSveAkumulatore(
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> pageSize,
            @RequestParam(required = false) Optional<String> proizvodjac,
            @RequestParam(required = false) Optional<Boolean> naStanju,
            @RequestParam(required = false) Optional<String> searchTerm,
            @RequestParam(required = false) RobaSortiranjePolja sortBy,
            @RequestParam(required = false) Sort.Direction sortDirection,
            Authentication authentication
    ) {

        var univerzalniParametri = robaSpringBeanUtils.popuniIVratiGenerickeParametreZaServis(
                page, pageSize, proizvodjac, naStanju, sortBy, sortDirection, searchTerm, VrstaRobe.AKUMULATORI, null, null
        );
        var uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);


        Page<RobaDto> roba = robaGlavniService.pronadjiRobuPoPretrazi(
                univerzalniParametri, uPartner
        );

        if (!CollectionUtils.isEmpty(roba.getContent())) {
            return ResponseEntity.ok().headers(createHeaders(uPartner)).body(roba);
        }
        return ResponseEntity.notFound().headers(createHeaders(uPartner)).build();
    }

    @GetMapping(value = "/ulja/{vrsta}")
    public ResponseEntity<Page<RobaDto>> pronadjiUlje(
            @PathVariable("vrsta") String vrstaUlja,
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> pageSize,
            @RequestParam(required = false) Optional<String> proizvodjac,
            @RequestParam(required = false) Optional<Boolean> naStanju,
            @RequestParam(required = false) Optional<String> searchTerm,
            @RequestParam(required = false) RobaSortiranjePolja sortBy,
            @RequestParam(required = false) Sort.Direction sortDirection,
            Authentication authentication
    ) {
        var univerzalniParametri = robaSpringBeanUtils.popuniIVratiGenerickeParametreZaServis(page, pageSize, proizvodjac, naStanju, sortBy, sortDirection, searchTerm, VrstaRobe.ULJA, vrstaUlja, null);
        var uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);

        Page<RobaDto> roba = robaGlavniService.pronadjiRobuPoPretrazi(
                univerzalniParametri, uPartner
        );

        if (!CollectionUtils.isEmpty(roba.getContent())) {
            return ResponseEntity.ok().headers(createHeaders(uPartner)).body(roba);
        }
        return ResponseEntity.notFound().headers(createHeaders(uPartner)).build();
    }

    private HttpHeaders createHeaders(Partner partner) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("AuthenticatedUser", partner != null ? "true" : "false");
        headers.add("Access-Control-Expose-Headers", "AuthenticatedUser");
        return headers;
    }
}
