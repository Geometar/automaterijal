package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.ProizvodjacDTO;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.domain.repository.ProizvodjacRepository;
import java.util.*;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class ProizvodjacService {

  @NonNull final ProizvodjacRepository proizvodjacRepository;

  /** Popunjavanje proizvodjaca u zavistosti od kriterijuma */
  public void popuniProizvodjace(
      List<RobaDto> robaDtos, MagacinDto magacinDto, UniverzalniParametri parametri) {
    List<Proizvodjac> proizvodjaci;
    if (parametri.getPodgrupeZaPretragu() == null
        && parametri.getTrazenaRec() == null
        && !parametri.isTecdocPretraga()) {
      proizvodjaci = pronadjiSveProizvodjaceZaVrstu();
    } else {
      Set<String> proizKljuc =
          robaDtos.stream()
              .map(RobaDto::getProizvodjac)
              .map(ProizvodjacDTO::getProid)
              .collect(Collectors.toSet());
      proizvodjaci = proizvodjacRepository.findByProidIn(proizKljuc);
    }
    getPopuniProizvodjaceURobi(robaDtos, proizvodjaci);

    if (parametri.getProizvodjac() != null && !parametri.getProizvodjac().isEmpty()) {
      boolean trazeniProizvodjacPostoji =
          proizvodjaci.stream()
              .anyMatch(
                  proizvodjac ->
                      parametri.getProizvodjac().stream()
                          .anyMatch(value -> value.equals(proizvodjac.getProid())));

      if (!trazeniProizvodjacPostoji) {
        proizvodjacRepository
            .findByProidIn(parametri.getProizvodjac())
            .forEach(proizvodjaci::addFirst);
      }
    }
    magacinDto.setProizvodjaci(proizvodjaci);
  }

  private void getPopuniProizvodjaceURobi(List<RobaDto> robaDtos, List<Proizvodjac> proizvodjaci) {
    for (RobaDto roba : robaDtos) {
      proizvodjaci.stream()
          .filter(proizvodjac -> proizvodjac.getProid().equals(roba.getProizvodjac().getProid()))
          .findFirst()
          .ifPresent(roba::setProizvodjacDto);
    }
  }

  public List<Proizvodjac> pronadjiSveProizvodjaceZaVrstu() {
    return pronadjiSve();
  }

  private List<Proizvodjac> pronadjiSve() {
    return proizvodjacRepository.findAllByOrderByNazivAsc().stream()
        .filter(proizvodjac -> !proizvodjac.getNaziv().equals("0"))
        .toList();
  }

  public Optional<Proizvodjac> vratiProizvodjacaPoPk(String id) {
    return proizvodjacRepository.findById(id);
  }
}
