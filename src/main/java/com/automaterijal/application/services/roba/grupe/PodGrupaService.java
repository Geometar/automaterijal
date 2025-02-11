package com.automaterijal.application.services.roba.grupe;

import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.PodgrupaDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.mapper.PodrgrupaMapper;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.domain.repository.PodGrupaRepository;
import com.automaterijal.application.domain.repository.roba.PodgrupeJooqRepository;
import java.util.*;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PodGrupaService {

  @NonNull final PodGrupaRepository podGrupaRepository;
  @NonNull final PodgrupeJooqRepository podgrupeJooqRepository;

  @NonNull final PodrgrupaMapper mapper;
  public static final String NEBITNA_GRUPA = "ZZZ";

  public List<PodgrupaDto> vratiSvePodgrupeZaKljuceve(Set<Integer> podgrupe) {
    return podGrupaRepository.findByPodGrupaIdIn(podgrupe).stream().map(mapper::map).toList();
  }

  public Map<String, List<PodgrupaDto>> vratiSveGrupe() {
    return podgrupeJooqRepository.findAllPodgrupe().stream()
        .collect(Collectors.groupingBy(PodgrupaDto::getGrupa));
  }

  /** Metoda za popunjavanje svih grupa u zavisnosti od kriterijuma */
  public void popuniPodgrupe(
      MagacinDto magacinDto, UniverzalniParametri parametri, List<RobaDto> roba) {
    List<PodgrupaDto> podgrupaDtos;
    if (parametri.getTrazenaRec() == null && parametri.getProizvodjac() == null) {
      podgrupaDtos = podgrupeJooqRepository.findAllPodgrupe();
    } else {
      Set<Integer> sviKljucevi =
          roba.stream().map(RobaDto::getPodGrupa).collect(Collectors.toSet());
      podgrupaDtos = podgrupeJooqRepository.findAllPodgrupeWithGrupa(sviKljucevi);
    }

    popuniSveNazivePodgrupa(roba, podgrupaDtos);
    Map<String, List<PodgrupaDto>> groupedByGrupa =
        podgrupaDtos.stream().collect(Collectors.groupingBy(PodgrupaDto::getGrupa));
    magacinDto.setCategories(groupedByGrupa);
  }

  private void popuniSveNazivePodgrupa(List<RobaDto> robaDtos, List<PodgrupaDto> podgrupaDtos) {
    for (RobaDto roba : robaDtos) {
      podgrupaDtos.stream()
          .filter(
              podgrupa ->
                  podgrupa.getId().intValue() == roba.getPodGrupa() || roba.getPodGrupa() == 0)
          .findFirst()
          .ifPresent(
              podgrupa -> {
                if (roba.getPodGrupa() != 0) {
                  roba.setPodGrupaNaziv(podgrupa.getNaziv());
                } else {
                  roba.setPodGrupaNaziv(NEBITNA_GRUPA);
                }
              });
    }
  }

  public Optional<PodGrupa> vratiPodgrupuPoKljucu(int kljuc) {
    return podGrupaRepository.findById(kljuc);
  }
}
