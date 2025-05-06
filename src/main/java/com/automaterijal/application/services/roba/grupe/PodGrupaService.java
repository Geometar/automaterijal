package com.automaterijal.application.services.roba.grupe;

import com.automaterijal.application.domain.constants.GlobalConstants;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.PodgrupaDto;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.domain.repository.PodGrupaRepository;
import com.automaterijal.application.domain.repository.roba.PodgrupeJooqRepository;
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
public class PodGrupaService {

  @NonNull final PodGrupaRepository podGrupaRepository;
  @NonNull final PodgrupeJooqRepository podgrupeJooqRepository;
  public static final String NEBITNA_GRUPA = "ZZZ";

  /** Start of: Metoda za popunjavanje svih grupa u zavisnosti od kriterijuma */
  public void popuniPodgrupe(
      MagacinDto magacinDto, UniverzalniParametri parametri, List<RobaLightDto> roba) {
    boolean parametriRequiresFiltering =
        parametri.getTrazenaRec() != null
            || parametri.getProizvodjac() != null
            || parametri.isTecdocPretraga();

    List<PodgrupaDto> podgrupaDtos =
        parametriRequiresFiltering
            ? fetchFilteredPodgrupe(roba)
            : podgrupeJooqRepository.findAllPodgrupe();

    popuniNazivePodgrupa(roba, podgrupaDtos);
    magacinDto.setCategories(groupByGrupa(podgrupaDtos));
  }

  private List<PodgrupaDto> fetchFilteredPodgrupe(List<RobaLightDto> roba) {
    Set<Integer> podgrupaIds =
        roba.stream()
            .map(RobaLightDto::getPodGrupa)
            .filter(id -> id != 0)
            .collect(Collectors.toSet());

    List<PodgrupaDto> podgrupaDtos = new ArrayList<>();
    if (!podgrupaIds.isEmpty()) {
      podgrupaDtos.addAll(podgrupeJooqRepository.findAllPodgrupeWithGrupa(podgrupaIds));
    }

    if (roba.stream()
        .map(RobaLightDto::getPodGrupa)
        .anyMatch(id -> id.equals(GlobalConstants.TECDOC_PODGRUPA_KEY))) {
      PodgrupaDto dto = new PodgrupaDto();
      dto.setId(GlobalConstants.TECDOC_PODGRUPA_KEY);
      dto.setNaziv(GlobalConstants.TECDOC_PODGRUPA_VALUE);
      dto.setGrupa("Dodatno");
      podgrupaDtos.add(dto);
    }
    return podgrupaDtos;
  }

  private void popuniNazivePodgrupa(
      List<RobaLightDto> robaLightDtos, List<PodgrupaDto> podgrupaDtos) {
    Map<Integer, String> podgrupaNazivi =
        podgrupaDtos.stream().collect(Collectors.toMap(PodgrupaDto::getId, PodgrupaDto::getNaziv));

    for (RobaLightDto roba : robaLightDtos) {
      roba.setPodGrupaNaziv(podgrupaNazivi.getOrDefault(roba.getPodGrupa(), NEBITNA_GRUPA));
    }
  }

  private Map<String, List<PodgrupaDto>> groupByGrupa(List<PodgrupaDto> podgrupaDtos) {
    return podgrupaDtos.stream().collect(Collectors.groupingBy(PodgrupaDto::getGrupa));
  }

  /** End of: Metoda za popunjavanje svih grupa u zavisnosti od kriterijuma */
  public Optional<PodGrupa> vratiPodgrupuPoKljucu(int kljuc) {
    return podGrupaRepository.findById(kljuc);
  }

  public List<PodGrupa> vratiPodgrupuPoKljucu(List<Integer> podgrupaKeys) {
    return podGrupaRepository.findByPodGrupaIdIn(podgrupaKeys);
  }
}
