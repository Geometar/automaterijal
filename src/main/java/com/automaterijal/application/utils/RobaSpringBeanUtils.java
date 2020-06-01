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
            Optional<Integer> page,
            Optional<Integer> pageSize,
            Optional<String> proizvodjac,
            Optional<Boolean> naStanju,
            Optional<String> grupa,
            RobaSortiranjePolja sortBy,
            Sort.Direction sortDirection,
            Optional<String> searchTerm,
            VrstaRobe vrstaRobe,
            String vrstaUlja,
            List<String> iKategorije) {
        Integer iPage = page.isPresent() ? page.get() : 0;
        Integer iPageSize = pageSize.isPresent() ? pageSize.get() : 10;
        String iProizvodjac = proizvodjac.filter(StringUtils::hasText).filter(naziv -> !naziv.equals("Svi proizvodjači")).map(String::toString).orElse(null);
        Boolean iNaStanju = naStanju.isPresent() ? naStanju.get() : false;
        String iGrupa = grupa.filter(StringUtils::hasText).filter(naziv -> !naziv.equals("Sve Kategorije")).map(String::toString).orElse(null);
        RobaSortiranjePolja iSortiranjePolja = sortBy == null ? RobaSortiranjePolja.STANJE : sortBy;
        Sort.Direction iDirection = sortDirection == null ? Sort.Direction.DESC : sortDirection;
        String iSearchTerm = searchTerm.filter(StringUtils::hasText)
                .map(trazenaRec -> trazenaRec.trim().toUpperCase())
                .map(trazenaRec -> GeneralUtil.cyrillicToLatinic(trazenaRec))
                .orElse(null);

        return popuniParametreZaServis(iPage, iPageSize, iProizvodjac, iNaStanju, iGrupa, iSortiranjePolja, iDirection, iSearchTerm, vrstaRobe, vrstaUlja, iKategorije);
    }

    private UniverzalniParametri popuniParametreZaServis(
            Integer internalPage,
            Integer internalPageSize,
            String internalProizvodjac,
            Boolean internalNaStanju,
            String internaGrupa,
            RobaSortiranjePolja internalSortiranjePolja,
            Sort.Direction internalDirection,
            String internalSearchTerm,
            VrstaRobe vrstaRobe,
            String vrstaUlja,
            List<String> iKategorije) {
        UniverzalniParametri up = new UniverzalniParametri();
        up.setPage(internalPage);
        up.setPageSize(internalPageSize);
        up.setProizvodjac(internalProizvodjac);
        up.setNaStanju(internalNaStanju);
        up.setGrupa(internaGrupa);
        up.setSortiranjePolja(internalSortiranjePolja);
        up.setDirection(internalDirection);
        up.setTrazenaRec(internalSearchTerm);
        up.setVrstaRobe(vrstaRobe);
        up.setVrstaUlja(vrstaUlja);
        up.setNaziviGrupe(iKategorije);
        setujFilterpPolja(up, vrstaRobe, vrstaUlja, iKategorije);
        return up;
    }

    private void setujFilterpPolja(UniverzalniParametri up, VrstaRobe vrstaRobe, String vrstaUlja, List<String> iKategorije) {
        switch (vrstaRobe) {
            case FILTERI:
                up.setPodGrupeId(podGrupaService.vratiSvePodGrupeIdPoNazivu(GrupeKonstante.FILTER));
                break;
            case AKUMULATORI:
                up.setGrupeId(grupaService.vratiSveIdGrupePoNazivu(GrupeKonstante.AKUMULATOR));
                break;
            case ULJA:
                List<Integer> filter = new ArrayList<>();
                pronadjiSvePodGrupeUZavisnostiOdVrste(filter, vrstaUlja);
                up.setPodGrupeId(filter);
                break;
            case OSTALO:
                up.setPodGrupeId(podGrupaService.vratiSvePodGrupePoNazivima(iKategorije));
                break;
        }
    }

    private void pronadjiSvePodGrupeUZavisnostiOdVrste(List<Integer> svePodGrupeUlja, String vrstaUlja) {
        RobaStaticUtils.pronadjiSveVrsteUlja(vrstaUlja).stream()
                .filter(str -> str != null)
                .forEach(vrsta -> svePodGrupeUlja.addAll(podGrupaService.vratiSvePodGrupeIdPoNazivu(vrsta)));
    }
}
