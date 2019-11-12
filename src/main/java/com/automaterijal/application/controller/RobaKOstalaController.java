package com.automaterijal.application.controller;

import com.automaterijal.application.domain.constants.RobaKategorije;
import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.constants.VrstaRobe;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.roba.RobaGlavniService;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import com.automaterijal.application.utils.RobaSpringBeanUtils;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping
    public List<String> vratiSveKategorije() {
        return Arrays.stream(RobaKategorije.values()).map(RobaKategorije::name).collect(Collectors.toList());
    }

    @GetMapping(value = "/{kategorija}")
    public ResponseEntity<Page<RobaDto>> vratiRobuIzKategorije(
            @PathVariable("kategorija") final RobaKategorije kategorija,
            @RequestParam(required = false) final Optional<Integer> page,
            @RequestParam(required = false) final  Optional<Integer> pageSize,
            @RequestParam(required = false) final  Optional<String> proizvodjac,
            @RequestParam(required = false) final  Optional<Boolean> naStanju,
            @RequestParam(required = false) final  Optional<String> searchTerm,
            @RequestParam(required = false) final RobaSortiranjePolja sortBy,
            @RequestParam(required = false) final Sort.Direction sortDirection,
            final Authentication authentication
    ) {

        final List<String> iKategorije = kategorija == null ? null : kategorija.getFieldName();
        final UniverzalniParametri univerzalniParametri = robaSpringBeanUtils.popuniIVratiGenerickeParametreZaServis(page, pageSize, sortBy, sortBy, proizvodjac, naStanju, sortBy, sortDirection, searchTerm, VrstaRobe.OSTALO, null, iKategorije);
        final Partner uPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);


        final Page<RobaDto> roba = robaGlavniService.pronadjiRobuPoPretrazi(
                univerzalniParametri, uPartner
        );

        if (!CollectionUtils.isEmpty(roba.getContent())) {
            return ResponseEntity.ok().headers(createHeaders(uPartner)).body(roba);
        }
        return ResponseEntity.notFound().headers(createHeaders(uPartner)).build();
    }

    private HttpHeaders createHeaders(final Partner partner) {
        final HttpHeaders headers = new HttpHeaders();
        headers.add("AuthenticatedUser", partner != null ? "true" : "false");
        headers.add("Access-Control-Expose-Headers", "AuthenticatedUser");
        return headers;
    }
}
