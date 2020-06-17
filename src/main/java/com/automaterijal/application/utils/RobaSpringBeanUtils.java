package com.automaterijal.application.utils;


import com.automaterijal.application.domain.constants.RobaKategorije;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.roba.grupe.GrupaService;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
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
            Optional<String> searchTerm,
            Optional<String> grupa,
            RobaKategorije robaKategorije
    ) {
        Integer iPage = page.isPresent() ? page.get() : 0;
        Integer iPageSize = pageSize.isPresent() ? pageSize.get() : 10;
        String iProizvodjac = proizvodjac.filter(StringUtils::hasText).filter(naziv -> !naziv.equals("Svi proizvodjači")).map(String::toString).orElse(null);
        Boolean iNaStanju = naStanju.isPresent() ? naStanju.get() : false;
        String iGrupa = grupa.filter(StringUtils::hasText).filter(naziv -> !naziv.equals("Sve Kategorije")).map(String::toString).orElse(null);
        String iSearchTerm = searchTerm.filter(StringUtils::hasText)
                .map(trazenaRec -> trazenaRec.trim().toUpperCase())
                .map(trazenaRec -> GeneralUtil.cyrillicToLatinic(trazenaRec))
                .orElse(null);

        return popuniParametreZaServis(iPage, iPageSize, iProizvodjac, iNaStanju, iGrupa, iSearchTerm, robaKategorije);
    }

    private UniverzalniParametri popuniParametreZaServis(
            Integer internalPage,
            Integer internalPageSize,
            String internalProizvodjac,
            Boolean internalNaStanju,
            String internaGrupa,
            String internalSearchTerm,
            RobaKategorije robaKategorije) {
        UniverzalniParametri up = new UniverzalniParametri();
        up.setPage(internalPage);
        up.setPageSize(internalPageSize);
        up.setProizvodjac(internalProizvodjac);
        up.setNaStanju(internalNaStanju);
        up.setGrupa(internaGrupa);
        up.setTrazenaRec(internalSearchTerm);
        up.setRobaKategorije(robaKategorije);
        if (robaKategorije != null) {
            up.setPodGrupe(pronadjiSvePodGrupeUZavisnostiOdVrste(robaKategorije.getFieldName()));
        } else {
            up.setPodGrupe(podGrupaService.vratiSvePodgrupe());
        }
        return up;
    }

    // iskoristi
    private List<PodGrupa> pronadjiSvePodGrupeUZavisnostiOdVrste(List<String> naziviPodGrupa) {
        List<PodGrupa> podGrupe = new ArrayList<>();
        naziviPodGrupa.stream()
                .filter(str -> str != null)
                .forEach(vrsta -> podGrupe.addAll(podGrupaService.vratiSvePodGrupePoNazivu(vrsta)));
        return podGrupe;
    }
}
