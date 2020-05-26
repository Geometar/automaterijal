package com.automaterijal.application.controller;

import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.constants.VrstaRobe;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaDetaljiDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.roba.RobaTekst;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.roba.RobaGlavniService;
import com.automaterijal.application.services.roba.RobaTekstService;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import com.automaterijal.application.utils.RobaSpringBeanUtils;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
    final RobaTekstService robaTekstService;
    @NonNull
    final PartnerSpringBeanUtils partnerSpringBeanUtils;
    @NonNull
    final RobaSpringBeanUtils robaSpringBeanUtils;

    @GetMapping
    public ResponseEntity<MagacinDto> pronadjiSvuRobu(
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> pageSize,
            @RequestParam(required = false) Optional<String> proizvodjac,
            @RequestParam(required = false) Optional<Boolean> naStanju,
            @RequestParam(required = false) Optional<String> grupa,
            @RequestParam(required = false) Optional<String> searchTerm,
            @RequestParam(required = false) RobaSortiranjePolja sortBy,
            @RequestParam(required = false) Sort.Direction sortDirection,
            Authentication authentication
    ) {

        var univerzalniParametri = robaSpringBeanUtils.popuniIVratiGenerickeParametreZaServis(
                page, pageSize, proizvodjac, naStanju, grupa, sortBy, sortDirection, searchTerm, VrstaRobe.SVE, null, null
        );
        var uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);

        MagacinDto magacinDto = robaGlavniService.pronadjiRobuPoPretrazi(
                univerzalniParametri, uPartner
        );

        return ResponseEntity.ok().headers(createHeaders(uPartner)).body(magacinDto);
    }

    @GetMapping(value = "/{robaID}")
    public ResponseEntity<RobaDetaljiDto> vratiRobuPojedinacno(@PathVariable("robaID") Long robaId, Authentication authentication) {
        var uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
        return robaGlavniService.pronadjiRobuPoRobaId(robaId, uPartner)
                .map(roba -> ResponseEntity.ok(roba))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/{robaID}")
    public ResponseEntity sacuvajTekst(
            @PathVariable("robaID") Long robaId,
            @RequestBody(required = false) String tekst,
            Authentication authentication) {
        var uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);
        if (uPartner != null && uPartner.getPrivilegije() == 2047) {
            log.info("Sacuvan tekst za robu {}", robaId);
            robaTekstService.sacuvajTekst(new RobaTekst(robaId, tekst));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            log.error("Odbijen zahtev da sacuva tekst za robu {}", robaId);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping(value = "/filteri")
    public ResponseEntity<MagacinDto> pronadjiSveFiltere(
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
                page, pageSize, proizvodjac, naStanju, Optional.empty(), sortBy, sortDirection, searchTerm, VrstaRobe.FILTERI, null, null
        );
        Partner uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);

        MagacinDto magacinDto = robaGlavniService.pronadjiRobuPoPretrazi(
                univerzalniParametri, uPartner
        );

        if (!CollectionUtils.isEmpty(magacinDto.getRobaDto().getContent())) {
            return ResponseEntity.ok().headers(createHeaders(uPartner)).body(magacinDto);
        }

        return ResponseEntity.notFound().headers(createHeaders(uPartner)).build();
    }

    @GetMapping(value = "/akumulatori")
    public ResponseEntity<MagacinDto> pronadjiSveAkumulatore(
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
                page, pageSize, proizvodjac, naStanju, Optional.empty(), sortBy, sortDirection, searchTerm, VrstaRobe.AKUMULATORI, null, null
        );
        var uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);


        MagacinDto magacinDto = robaGlavniService.pronadjiRobuPoPretrazi(
                univerzalniParametri, uPartner
        );

        if (!CollectionUtils.isEmpty(magacinDto.getRobaDto().getContent())) {
            return ResponseEntity.ok().headers(createHeaders(uPartner)).body(magacinDto);
        }
        return ResponseEntity.notFound().headers(createHeaders(uPartner)).build();
    }

    @GetMapping(value = "/ulja/{vrsta}")
    public ResponseEntity<MagacinDto> pronadjiUlje(
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
        var univerzalniParametri = robaSpringBeanUtils.popuniIVratiGenerickeParametreZaServis(page, pageSize, proizvodjac, naStanju, Optional.empty(), sortBy, sortDirection, searchTerm, VrstaRobe.ULJA, vrstaUlja, null);
        var uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);

        MagacinDto magacinDto = robaGlavniService.pronadjiRobuPoPretrazi(
                univerzalniParametri, uPartner
        );

        if (!CollectionUtils.isEmpty(magacinDto.getRobaDto().getContent())) {
            return ResponseEntity.ok().headers(createHeaders(uPartner)).body(magacinDto);
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
