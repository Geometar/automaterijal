package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.ProizvodjacDTO;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.mapper.ManufacturerMapper;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.domain.repository.ProizvodjacRepository;
import com.automaterijal.application.utils.SlugUtil;
import java.util.*;
import java.util.function.Function;
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
  @NonNull final ManufacturerMapper mapper;

  /** Popunjavanje proizvodjaca u zavistosti od kriterijuma */
  public void popuniProizvodjace(
      List<RobaLightDto> robaLightDtos, MagacinDto magacinDto, UniverzalniParametri parametri) {
    List<Proizvodjac> proizvodjaci = resolveRelevantManufacturers(robaLightDtos);
    Map<String, Proizvodjac> proizvodjaciPoIdu = indexManufacturersById(proizvodjaci);

    assignManufacturersToProducts(robaLightDtos, proizvodjaciPoIdu);
    ensureRequestedManufacturersPresent(parametri, proizvodjaci, proizvodjaciPoIdu);

    magacinDto.setProizvodjaci(mapper.map(proizvodjaci));
  }

  public Optional<Proizvodjac> vratiProizvodjacaPoPk(String id) {
    return proizvodjacRepository.findById(id);
  }

  public Map<String, Proizvodjac> vratiProizvodjacePoId(Collection<String> ids) {
    if (ids == null || ids.isEmpty()) {
      return Collections.emptyMap();
    }
    return proizvodjacRepository.findByProidIn(ids).stream()
        .filter(Objects::nonNull)
        .collect(
            Collectors.toMap(Proizvodjac::getProid, Function.identity(), (left, right) -> left));
  }

  public List<Proizvodjac> findAll() {
    return proizvodjacRepository.findAllByOrderByNazivAsc().stream()
        .filter(proizvodjac -> !proizvodjac.getNaziv().equals("0"))
        .toList();
  }

  public List<ProizvodjacDTO> fetchAll() {
    return findAll().stream().map(mapper::map).collect(Collectors.toList());
  }

  public Optional<ProizvodjacDTO> findBySlug(String slug) {
    return proizvodjacRepository.findAll().stream()
        .filter(p -> SlugUtil.toSlug(p.getNaziv()).equals(slug))
        .findFirst()
        .map(this::mapToDto);
  }

  private ProizvodjacDTO mapToDto(Proizvodjac proizvodjac) {
    ProizvodjacDTO retval = new ProizvodjacDTO();
    retval.setProizvodjac(proizvodjac);
    return retval;
  }

  private List<Proizvodjac> resolveRelevantManufacturers(List<RobaLightDto> robaLightDtos) {
    Set<String> manufacturerIds = manufacturerIdsFromProducts(robaLightDtos);
    if (manufacturerIds.isEmpty()) {
      return new LinkedList<>();
    }

    return new LinkedList<>(proizvodjacRepository.findByProidIn(manufacturerIds));
  }

  private Map<String, Proizvodjac> indexManufacturersById(List<Proizvodjac> proizvodjaci) {
    return proizvodjaci.stream()
        .collect(
            Collectors.toMap(
                Proizvodjac::getProid,
                Function.identity(),
                (left, right) -> left,
                LinkedHashMap::new));
  }

  private void assignManufacturersToProducts(
      List<RobaLightDto> robaLightDtos, Map<String, Proizvodjac> proizvodjaciPoIdu) {
    for (RobaLightDto roba : robaLightDtos) {
      ProizvodjacDTO proizvodjac = roba.getProizvodjac();
      if (proizvodjac == null || proizvodjac.getProid() == null) {
        continue;
      }

      Proizvodjac pronadjeni = proizvodjaciPoIdu.get(proizvodjac.getProid());
      if (pronadjeni != null) {
        roba.setProizvodjacDto(pronadjeni);
      }
    }
  }

  private void ensureRequestedManufacturersPresent(
      UniverzalniParametri parametri,
      List<Proizvodjac> proizvodjaci,
      Map<String, Proizvodjac> proizvodjaciPoIdu) {

    List<String> requested = parametri.getProizvodjac();
    if (requested == null || requested.isEmpty()) {
      return;
    }

    Set<String> missingManufacturerIds =
        requested.stream()
            .filter(Objects::nonNull)
            .filter(id -> !proizvodjaciPoIdu.containsKey(id))
            .collect(Collectors.toCollection(LinkedHashSet::new));

    if (missingManufacturerIds.isEmpty()) {
      return;
    }

    List<Proizvodjac> fetched = proizvodjacRepository.findByProidIn(missingManufacturerIds);
    for (Proizvodjac dodatni : fetched) {
      String manufacturerId = dodatni.getProid();
      if (manufacturerId == null || proizvodjaciPoIdu.containsKey(manufacturerId)) {
        continue;
      }

      proizvodjaci.add(0, dodatni);
      proizvodjaciPoIdu.put(manufacturerId, dodatni);
    }
  }

  private Set<String> manufacturerIdsFromProducts(List<RobaLightDto> robaLightDtos) {
    return robaLightDtos.stream()
        .map(RobaLightDto::getProizvodjac)
        .filter(Objects::nonNull)
        .map(ProizvodjacDTO::getProid)
        .filter(Objects::nonNull)
        .collect(Collectors.toCollection(LinkedHashSet::new));
  }
}
