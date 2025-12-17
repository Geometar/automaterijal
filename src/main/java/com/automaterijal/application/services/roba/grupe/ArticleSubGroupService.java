package com.automaterijal.application.services.roba.grupe;

import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.PodgrupaDto;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.entity.PodGrupa;
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
public class ArticleSubGroupService {

  @NonNull final PodGrupaRepository podGrupaRepository;
  @NonNull final PodgrupeJooqRepository podgrupeJooqRepository;
  public static final String ANONIMNA_GRUPA = "OSTALO";

  /** Start of: Metoda za popunjavanje svih grupa u zavisnosti od kriterijuma */
  public void popuniPodgrupe(MagacinDto magacinDto, List<RobaLightDto> roba) {

    List<PodgrupaDto> podgrupaDtos = fetchFilteredPodgrupe(roba);

    popuniNazivePodgrupa(roba, podgrupaDtos);
    Map<String, List<PodgrupaDto>> grouped = groupByGrupa(podgrupaDtos);
    if (shouldIncludeFallback(roba)) {
      grouped = withFallback(grouped);
    }
    magacinDto.setCategories(grouped);
  }

  private List<PodgrupaDto> fetchFilteredPodgrupe(List<RobaLightDto> roba) {
    Set<Integer> podgrupaIds =
        roba.stream()
            .map(RobaLightDto::getPodGrupa)
            .filter(Objects::nonNull)
            .filter(id -> id != 0)
            .collect(Collectors.toSet());

    List<PodgrupaDto> podgrupaDtos = new ArrayList<>();
    if (!podgrupaIds.isEmpty()) {
      podgrupaDtos.addAll(podgrupeJooqRepository.findAllPodgrupeWithGrupa(podgrupaIds));
    }
    return podgrupaDtos;
  }

  private void popuniNazivePodgrupa(
      List<RobaLightDto> robaLightDtos, List<PodgrupaDto> podgrupaDtos) {
    Map<Integer, String> podgrupaNazivi =
        podgrupaDtos.stream().collect(Collectors.toMap(PodgrupaDto::getId, PodgrupaDto::getNaziv));

    for (RobaLightDto roba : robaLightDtos) {
      roba.setPodGrupaNaziv(podgrupaNazivi.getOrDefault(roba.getPodGrupa(), ANONIMNA_GRUPA));
    }
  }

  private Map<String, List<PodgrupaDto>> groupByGrupa(List<PodgrupaDto> podgrupaDtos) {
    return podgrupaDtos.stream().collect(Collectors.groupingBy(PodgrupaDto::getGrupa));
  }

  public Map<Integer, PodgrupaDto> loadPodgrupeWithGrupa(Set<Integer> podgrupaIds) {
    if (podgrupaIds == null || podgrupaIds.isEmpty()) {
      return Map.of();
    }
    Set<Integer> ids =
        podgrupaIds.stream()
            .filter(Objects::nonNull)
            .filter(id -> id != 0)
            .collect(Collectors.toSet());
    if (ids.isEmpty()) {
      return Map.of();
    }
    return podgrupeJooqRepository.findAllPodgrupeWithGrupa(ids).stream()
        .filter(Objects::nonNull)
        .filter(dto -> dto.getId() != null)
        .collect(Collectors.toMap(PodgrupaDto::getId, dto -> dto, (a, b) -> a));
  }

  public Map<String, List<PodgrupaDto>> buildCategoriesFromPodgrupaIds(Set<Integer> podgrupaIds) {
    Set<Integer> ids = podgrupaIds != null ? podgrupaIds : Set.of();
    boolean includeFallback = ids.contains(0);
    List<PodgrupaDto> podgrupe = new ArrayList<>(loadPodgrupeWithGrupa(ids).values());
    Map<String, List<PodgrupaDto>> grouped = groupByGrupa(podgrupe);
    if (includeFallback) {
      grouped = withFallback(grouped);
    }
    return grouped;
  }

  private boolean shouldIncludeFallback(List<RobaLightDto> roba) {
    if (roba == null || roba.isEmpty()) {
      return false;
    }
    return roba.stream()
        .filter(Objects::nonNull)
        .anyMatch(r -> r.getPodGrupa() == 0 || ANONIMNA_GRUPA.equals(r.getPodGrupaNaziv()));
  }

  private Map<String, List<PodgrupaDto>> withFallback(Map<String, List<PodgrupaDto>> grouped) {
    Map<String, List<PodgrupaDto>> copy = grouped != null ? new HashMap<>(grouped) : new HashMap<>();
    List<PodgrupaDto> list = new ArrayList<>(copy.getOrDefault(ANONIMNA_GRUPA, List.of()));

    boolean exists =
        list.stream().anyMatch(dto -> dto != null && Objects.equals(dto.getId(), 0));
    if (!exists) {
      PodgrupaDto dto = new PodgrupaDto();
      dto.setId(0);
      dto.setNaziv(ANONIMNA_GRUPA);
      dto.setGrupa(ANONIMNA_GRUPA);
      list.add(dto);
    }

    copy.put(ANONIMNA_GRUPA, list);
    return copy;
  }

  /** End of: Metoda za popunjavanje svih grupa u zavisnosti od kriterijuma */
  public Optional<PodGrupa> vratiPodgrupuPoKljucu(int kljuc) {
    return podGrupaRepository.findById(kljuc);
  }

  public List<PodGrupa> vratiPodgrupuPoKljucu(List<Integer> podgrupaKeys) {
    return podGrupaRepository.findByPodGrupaIdIn(podgrupaKeys);
  }

  public List<PodGrupa> findAll() {
    return podGrupaRepository.findAll();
  }
}
