package com.automaterijal.application.controller;

import com.automaterijal.application.domain.constants.RobaKategorije;
import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.model.CurrentUser;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.roba.RobaKategorijeService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
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
public class RobaKategorijeController {

    @NonNull
    final
    RobaKategorijeService kategorijeService;

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
        final Integer iPage = page == null ? 0 : page;
        final Integer iPageSize = pageSize == null ? 10 : pageSize;
        final String iProizvodjac = proizvodjac == null ? null : proizvodjac;
        final Boolean iNaStanju = naStanju == null ? true : naStanju;
        final RobaSortiranjePolja iSortiranjePolja = sortBy == null ? RobaSortiranjePolja.KATBR : sortBy;
        final Sort.Direction iDirection = sortDirection == null ? Sort.Direction.ASC: sortDirection;
        final String iSearchTerm = searchTerm == null ? null : searchTerm.trim().toUpperCase();
        final List<String> iKategorije = kategorija == null ? null : kategorija.getFieldName();

        Partner ulogovaniPartner= null;
        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof CurrentUser) {
            final CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
            ulogovaniPartner = currentUser.vratiPartnera();
        }

        final Page<RobaDto> roba =  kategorijeService.pronadjiRobuIzKategorije(
                popuniParametreZaServis(iPage, iPageSize, iProizvodjac, iNaStanju, iSortiranjePolja, iDirection, iSearchTerm),
                iKategorije,
                ulogovaniPartner
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
