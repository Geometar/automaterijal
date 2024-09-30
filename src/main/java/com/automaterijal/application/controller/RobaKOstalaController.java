package com.automaterijal.application.controller;

import com.automaterijal.application.domain.constants.RobaKategorije;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.LogWebService;
import com.automaterijal.application.services.roba.RobaGlavniService;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import com.automaterijal.application.utils.RobaSpringBeanUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kategorije")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaKOstalaController {

    @NonNull
    final PartnerSpringBeanUtils partnerSpringBeanUtils;

    @NonNull
    final RobaSpringBeanUtils robaSpringBeanUtils;

    @NonNull
    final RobaGlavniService robaGlavniService;

    @NonNull
    final LogWebService logWebService;

    @GetMapping
    public List<String> vratiSveKategorije() {
        return Arrays.stream(RobaKategorije.values()).map(RobaKategorije::name).toList();
    }

    @GetMapping(value = "/{kategorija}")
    public ResponseEntity<MagacinDto> vratiRobuIzKategorije(
            @PathVariable("kategorija") String nazivKategorije,
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> pageSize,
            @RequestParam(required = false) Optional<String> proizvodjac,
            @RequestParam(required = false) Optional<Boolean> naStanju,
            @RequestParam(required = false) Optional<String> searchTerm,
            @RequestParam(required = false) Optional<String> grupa,
            Authentication authentication
    ) {
        RobaKategorije kategorija = RobaKategorije.pronadjiPoNazivu(nazivKategorije.replace(" ", "_").toUpperCase());
        UniverzalniParametri univerzalniParametri = robaSpringBeanUtils.popuniIVratiGenerickeParametreZaServis(page, pageSize, proizvodjac, naStanju, searchTerm, grupa, kategorija);
        Partner uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);


        logWebService.log(uPartner, kategorija.getFieldName().get(0), univerzalniParametri.getProizvodjac(), univerzalniParametri.getTrazenaRec());
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
