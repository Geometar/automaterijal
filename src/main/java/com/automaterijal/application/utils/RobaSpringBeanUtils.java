package com.automaterijal.application.utils;

import com.automaterijal.application.domain.model.UniverzalniParametri;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
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

  public UniverzalniParametri popuniIVratiGenerickeParametreZaServis(
      Optional<Integer> page,
      Optional<Integer> pageSize,
      List<String> proizvodjac,
      List<String> mandatoryGrupe,
      List<String> mandatoryProid,
      Optional<Boolean> naStanju,
      Optional<Boolean> dostupno,
      Optional<String> searchTerm,
      List<Integer> podgrupe,
      boolean tecdocPretaga,
      Optional<String> filterBy,
      boolean paged,
      boolean showcase) {
    Integer iPage = page.orElse(0);
    Integer iPageSize = pageSize.orElse(10);
    List<String> iProizvodjac =
        proizvodjac != null
            ? proizvodjac.stream().map(String::toUpperCase).map(String::toString).toList()
            : new ArrayList<>();
    List<String> iMProid =
        mandatoryProid != null
            ? mandatoryProid.stream().map(String::toUpperCase).map(String::toString).toList()
            : new ArrayList<>();

    List<String> IMGrrupe =
        mandatoryGrupe != null
            ? mandatoryGrupe.stream().map(String::toUpperCase).map(String::toString).toList()
            : new ArrayList<>();

    Boolean iNaStanju = naStanju.orElse(false);
    Boolean iDostupno = dostupno.orElse(false);

    List<Integer> iPodgrupe = podgrupe;

    String iSearchTerm =
        searchTerm
            .filter(StringUtils::hasText)
            .map(trazenaRec -> trazenaRec.trim().toUpperCase())
            .map(GeneralUtil::cyrillicToLatinic)
            .orElse(null);
    String iFilterBy =
        filterBy.filter(StringUtils::hasText)
            .map(String::trim)
            .map(String::toLowerCase)
            .orElse(null);

    return popuniParametreZaServis(
        iPage,
        iPageSize,
        iProizvodjac,
        IMGrrupe,
        iMProid,
        iNaStanju,
        iDostupno,
        iPodgrupe,
        iSearchTerm,
        tecdocPretaga,
        iFilterBy,
        paged,
        showcase);
  }

  private UniverzalniParametri popuniParametreZaServis(
      Integer internalPage,
      Integer internalPageSize,
      List<String> internalProizvodjac,
      List<String> IMGrupe,
      List<String> iMProid,
      Boolean internalNaStanju,
      Boolean internalDostupno,
      List<Integer> internaPodgrupe,
      String internalSearchTerm,
      boolean tecdocPretraga,
      String filterBy,
      boolean paged,
      boolean showcase) {
    UniverzalniParametri up = new UniverzalniParametri();
    up.setPage(internalPage);
    up.setPageSize(internalPageSize);
    up.setProizvodjac(internalProizvodjac);
    up.setGrupa(IMGrupe);
    up.setMandatoryProid(iMProid);
    up.setNaStanju(internalNaStanju);
    up.setDostupno(Boolean.TRUE.equals(internalDostupno));
    up.setTrazenaRec(internalSearchTerm);
    up.setPodgrupeZaPretragu(internaPodgrupe);
    up.setTecdocPretraga(tecdocPretraga);
    up.setFilterBy(filterBy);
    up.setPaged(paged);
    up.setShowcase(showcase);
    return up;
  }
}
