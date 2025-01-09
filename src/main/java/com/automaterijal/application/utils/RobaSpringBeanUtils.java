package com.automaterijal.application.utils;

import com.automaterijal.application.domain.constants.RobaKategorije;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.roba.grupe.GrupaService;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RobaSpringBeanUtils {

  @NonNull GrupaService grupaService;
  @NonNull PodGrupaService podGrupaService;

  public UniverzalniParametri popuniIVratiGenerickeParametreZaServis(
      Optional<Integer> page,
      Optional<Integer> pageSize,
      Optional<String> proizvodjac,
      Optional<Boolean> naStanju,
      Optional<String> searchTerm,
      List<String> grupe,
      RobaKategorije robaKategorije) {
    Integer iPage = page.orElse(0);
    Integer iPageSize = pageSize.orElse(10);
    String iProizvodjac =
        proizvodjac.filter(StringUtils::hasText).map(String::toString).orElse(null);
    Boolean iNaStanju = naStanju.orElse(false);
    List<String> iGrupe =
        grupe != null
            ? grupe.stream().map(String::toUpperCase).map(String::toString).toList()
            : new ArrayList<>();

    String iSearchTerm =
        searchTerm
            .filter(StringUtils::hasText)
            .map(trazenaRec -> trazenaRec.trim().toUpperCase())
            .map(GeneralUtil::cyrillicToLatinic)
            .orElse(null);

    return popuniParametreZaServis(
        iPage, iPageSize, iProizvodjac, iNaStanju, iGrupe, iSearchTerm, robaKategorije);
  }

  private UniverzalniParametri popuniParametreZaServis(
      Integer internalPage,
      Integer internalPageSize,
      String internalProizvodjac,
      Boolean internalNaStanju,
      List<String> internaGrupe,
      String internalSearchTerm,
      RobaKategorije robaKategorije) {
    UniverzalniParametri up = new UniverzalniParametri();
    up.setPage(internalPage);
    up.setPageSize(internalPageSize);
    up.setProizvodjac(internalProizvodjac);
    up.setNaStanju(internalNaStanju);
    up.setTrazenaRec(internalSearchTerm);
    up.setPodgrupeZaPretragu(internaGrupe);
    if (robaKategorije != null) {
      if (robaKategorije.isPodgrupaPretraga()) {
        up.setPodGrupe(pronadjiSvePodGrupeUZavisnostiOdVrste(robaKategorije.getFieldName()));
      } else {
        up.setGrupa(List.of(robaKategorije.getFieldName().get(0)));
        up.setPodGrupe(podGrupaService.vratiSvePodGrupePoGrupeIn(up.getGrupa()));
      }
      up.setRobaKategorije(robaKategorije);
    } else {
      up.setPodGrupe(podGrupaService.vratiSvePodgrupe());
    }
    return up;
  }

  // iskoristi
  private List<PodGrupa> pronadjiSvePodGrupeUZavisnostiOdVrste(List<String> naziviPodGrupa) {
    List<PodGrupa> podGrupe = new ArrayList<>();
    naziviPodGrupa.stream()
        .filter(Objects::nonNull)
        .forEach(vrsta -> podGrupe.addAll(podGrupaService.vratiSvePodGrupePoNazivu(vrsta)));
    return podGrupe;
  }
}
