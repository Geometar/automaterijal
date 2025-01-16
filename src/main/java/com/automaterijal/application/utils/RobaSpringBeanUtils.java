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
      List<String> mandatoryProid,
      Optional<Boolean> naStanju,
      Optional<String> searchTerm,
      List<String> podgrupe) {
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
    Boolean iNaStanju = naStanju.orElse(false);
    List<String> iPodgrupe =
        podgrupe != null
            ? podgrupe.stream().map(String::toUpperCase).map(String::toString).toList()
            : new ArrayList<>();

    String iSearchTerm =
        searchTerm
            .filter(StringUtils::hasText)
            .map(trazenaRec -> trazenaRec.trim().toUpperCase())
            .map(GeneralUtil::cyrillicToLatinic)
            .orElse(null);

    return popuniParametreZaServis(
        iPage, iPageSize, iProizvodjac, iMProid, iNaStanju, iPodgrupe, iSearchTerm);
  }

  private UniverzalniParametri popuniParametreZaServis(
      Integer internalPage,
      Integer internalPageSize,
      List<String> internalProizvodjac,
      List<String> iMProid,
      Boolean internalNaStanju,
      List<String> internaPodgrupe,
      String internalSearchTerm) {
    UniverzalniParametri up = new UniverzalniParametri();
    up.setPage(internalPage);
    up.setPageSize(internalPageSize);
    up.setProizvodjac(internalProizvodjac);
    up.setMandatoryProid(iMProid);
    up.setNaStanju(internalNaStanju);
    up.setTrazenaRec(internalSearchTerm);
    up.setPodgrupeZaPretragu(internaPodgrupe);
    return up;
  }
}
