package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.domain.repository.ProizvodjacRepository;
import com.automaterijal.application.services.roba.RobaService;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
  @NonNull final RobaService robaService;

  /** Popunjavanje proizvodjaca u zavistosti od kriterijuma */
  public void popuniProizvodjace(
      List<RobaDto> robaDtos, MagacinDto magacinDto, UniverzalniParametri parametri) {
    List<Proizvodjac> proizvodjaci;
    if (parametri.getPodgrupeZaPretragu() == null && parametri.getTrazenaRec() == null) {
      proizvodjaci = pronadjiSveProizvodjaceZaVrstu(parametri);
    } else {
      Set<String> proizKljuc =
          robaDtos.stream()
              .map(RobaDto::getProizvodjac)
              .map(Proizvodjac::getProid)
              .collect(Collectors.toSet());
      proizvodjaci = proizvodjacRepository.findByProidIn(proizKljuc);
    }
    getPopuniProizvodjaceURobi(robaDtos, proizvodjaci);

    if (parametri.getProizvodjac() != null) {
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
          .ifPresent(roba::setProizvodjac);
    }
  }

  public List<Proizvodjac> pronadjiSveProizvodjaceZaVrstu(UniverzalniParametri parametri) {
    return pronadjiSve();
  }

  private List<Proizvodjac> pronadjiSve() {
    return proizvodjacRepository.findAllByOrderByNazivAsc().stream()
        .filter(proizvodjac -> !proizvodjac.getNaziv().equals("0"))
        .toList();
  }

  public List<Proizvodjac> proizvodjaciKateogrija(List<PodGrupa> podgrupe) {
    Set<String> filterRoba =
        robaService
            .pronadjiSvuRobuPoPodGrupiIdListaSvaStanja(
                podgrupe.stream().map(PodGrupa::getPodGrupaId).toList())
            .stream()
            .map(robaEnitet -> robaEnitet.getProizvodjac().getProid())
            .collect(Collectors.toSet());
    return proizvodjacRepository.findByProidIn(filterRoba).stream()
        .sorted(Comparator.comparing(Proizvodjac::getNaziv))
        .toList();
  }

  public Optional<Proizvodjac> vratiProizvodjacaPoPk(String id) {
    return proizvodjacRepository.findById(id);
  }
}
