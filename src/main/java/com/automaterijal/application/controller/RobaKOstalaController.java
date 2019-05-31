package com.automaterijal.application.controller;

import com.automaterijal.application.domain.constants.RobaKategorije;
import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.roba.RobaKategorijeService;
import com.automaterijal.application.utils.PartnerSpringBeanUtils;
import com.automaterijal.application.utils.RobaStaticUtils;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/kategorije")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaKOstalaController {

    @NonNull
    final
    RobaKategorijeService kategorijeService;

    @NonNull
    final PartnerSpringBeanUtils partnerSpringBeanUtils;

    @GetMapping
    public List<String> vratiSveKategorije() {
        return Arrays.stream(RobaKategorije.values()).map(RobaKategorije::name).collect(Collectors.toList());
    }

    @GetMapping(value = "/{kategorija}")
    public ResponseEntity<Page<RobaDto>> vratiRobuIzKategorije(
            @PathVariable("kategorija") final RobaKategorije kategorija,
            @RequestParam(required = false) final Integer page,
            @RequestParam(required = false) final Integer pageSize,
            @RequestParam(required = false) final RobaSortiranjePolja sortBy,
            @RequestParam(required = false) final Sort.Direction sortDirection,
            @RequestParam(required = false) final String proizvodjac,
            @RequestParam(required = false) final Boolean naStanju,
            @RequestParam(required = false) final String searchTerm,
            final Authentication authentication
    ) {

        final UniverzalniParametri parametri = RobaStaticUtils.popuniIVratiGenerickeParametreZaServis(page, pageSize, sortBy, sortBy, proizvodjac, naStanju, sortBy, sortDirection, searchTerm);
        final List<String> iKategorije = kategorija == null ? null : kategorija.getFieldName();
        final Partner ulogovaniPartner = partnerSpringBeanUtils.vratiPartneraIsSesije(authentication);

        final Page<RobaDto> roba = kategorijeService.pronadjiRobuIzKategorije(
                parametri,
                iKategorije,
                ulogovaniPartner
        );

        if (!CollectionUtils.isEmpty(roba.getContent())) {
            return ResponseEntity.ok(roba);
        }
        return ResponseEntity.notFound().build();
    }
}
