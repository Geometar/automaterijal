package com.automaterijal.application.utils;


import com.automaterijal.application.domain.constants.GrupeKonstante;
import com.automaterijal.application.domain.constants.RobaSortiranjePolja;
import com.automaterijal.application.domain.constants.VrstaRobe;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.roba.grupe.GrupaService;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RobaSpringBeanUtils {

    @NonNull
    GrupaService grupaService;
    @NonNull
    PodGrupaService podGrupaService;

    public UniverzalniParametri popuniIVratiGenerickeParametreZaServis(
            final Optional<Integer> page,
            final Optional<Integer> pageSize,
            final Optional<String> proizvodjac,
            final Optional<Boolean> naStanju,
            final RobaSortiranjePolja sortBy,
            final Sort.Direction sortDirection,
            final Optional<String> searchTerm,
            final VrstaRobe vrstaRobe,
            final String vrstaUlja,
            final List<String> iKategorije) {
        final Integer iPage = page.isPresent() ? page.get() : 10;
        final Integer iPageSize = pageSize.isPresent() ? pageSize.get() : 10;
        final String iProizvodjac = proizvodjac.filter(StringUtils::hasText).map(String::toString).orElse(null);
        final Boolean iNaStanju = naStanju.isPresent() ? naStanju.get() : false;
        final RobaSortiranjePolja iSortiranjePolja = sortBy == null ? RobaSortiranjePolja.STANJE : sortBy;
        final Sort.Direction iDirection = sortDirection == null ? Sort.Direction.DESC : sortDirection;
        final String iSearchTerm = searchTerm.filter(StringUtils::hasText).map(trazenaRec -> trazenaRec.trim().toUpperCase()).orElse(null);
        return popuniParametreZaServis(iPage, iPageSize, iProizvodjac, iNaStanju, iSortiranjePolja, iDirection, iSearchTerm, vrstaRobe, vrstaUlja, iKategorije);
    }

    private UniverzalniParametri popuniParametreZaServis(
            final Integer internalPage,
            final Integer internalPageSize,
            final String internalProizvodjac,
            final Boolean internalNaStanju,
            final RobaSortiranjePolja internalSortiranjePolja,
            final Sort.Direction internalDirection,
            final String internalSearchTerm,
            final VrstaRobe vrstaRobe,
            final String vrstaUlja,
            final List<String> iKategorije) {
        final UniverzalniParametri up = new UniverzalniParametri();
        up.setPage(internalPage);
        up.setPageSize(internalPageSize);
        up.setProizvodjac(internalProizvodjac);
        up.setNaStanju(internalNaStanju);
        up.setSortiranjePolja(internalSortiranjePolja);
        up.setDirection(internalDirection);
        up.setTrazenaRec(internalSearchTerm);
        up.setVrstaRobe(vrstaRobe);
        setujFilterpPolja(up, vrstaRobe, vrstaUlja, iKategorije);
        return up;
    }

    private void setujFilterpPolja(final UniverzalniParametri up, final VrstaRobe vrstaRobe, final String vrstaUlja, final List<String> iKategorije) {
        switch (vrstaRobe) {
            case FILTERI:
                up.setPodGrupeId(podGrupaService.vratiSvePodGrupeIdPoNazivu(GrupeKonstante.FILTER));
                break;
            case AKUMULATORI:
                up.setGrupeId(grupaService.vratiSveIdGrupePoNazivu(GrupeKonstante.AKUMULATOR));
                break;
            case ULJA:
                final List<Integer> filter = new ArrayList<>();
                pronadjiSvePodGrupeUZavisnostiOdVrste(filter, vrstaUlja);
                up.setPodGrupeId(filter);
                break;
            case OSTALO:
                up.setPodGrupeId(podGrupaService.vratiSvePodGrupePoNazivima(iKategorije));
                break;
        }
    }

    private void pronadjiSvePodGrupeUZavisnostiOdVrste(final List<Integer> svePodGrupeUlja, final String vrstaUlja) {
        final String[] vrsteUlja = RobaStaticUtils.pronadjiSveVrsteUlja(vrstaUlja);
        Arrays.stream(vrsteUlja)
                .filter(str -> str != null)
                .forEach(vrsta -> svePodGrupeUlja.addAll(podGrupaService.vratiSvePodGrupeIdPoNazivu(vrsta)));
    }
}
