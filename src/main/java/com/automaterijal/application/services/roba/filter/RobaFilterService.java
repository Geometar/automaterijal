package com.automaterijal.application.services.roba.filter;

import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class RobaFilterService {

  /** Applies all mandatory filters to the list of RobaLightDto based on given parameters. */
  public List<RobaLightDto> applyMandatoryFilters(
      UniverzalniParametri parametri, List<RobaLightDto> roba) {
    roba = filterByMandatoryManufacturer(parametri.getMandatoryProid(), roba);
    return roba;
  }

  /** Applies all optional filters to the list of RobaLightDto based on given parameters. */
  public List<RobaLightDto> applyOptionalFilters(
      UniverzalniParametri parametri, List<RobaLightDto> roba) {
    roba = filterByManufacturer(parametri.getProizvodjac(), roba);
    roba = filterByGroup(parametri.getGrupa(), roba);
    roba = filterBySubGroup(parametri.getPodgrupeZaPretragu(), roba);
    roba = filterByStock(parametri.isNaStanju(), roba);
    return roba;
  }

  /** Filters the list by manufacturer (proizvodjac). */
  public List<RobaLightDto> filterByManufacturer(
      List<String> manufacturers, List<RobaLightDto> roba) {
    if (manufacturers == null || manufacturers.isEmpty()) {
      return roba;
    }
    return roba.stream()
        .filter(robaDto -> manufacturers.contains(robaDto.getProizvodjac().getProid()))
        .collect(Collectors.toList());
  }

  /** Filters the list by mandatory manufacturer (mandatoryProid). */
  public List<RobaLightDto> filterByMandatoryManufacturer(
      List<String> mandatoryManufacturers, List<RobaLightDto> roba) {
    if (mandatoryManufacturers == null || mandatoryManufacturers.isEmpty()) {
      return roba;
    }
    return roba.stream()
        .filter(robaDto -> mandatoryManufacturers.contains(robaDto.getProizvodjac().getProid()))
        .collect(Collectors.toList());
  }

  /** Filters the list by group. */
  public List<RobaLightDto> filterByGroup(List<String> groups, List<RobaLightDto> roba) {
    if (groups == null || groups.isEmpty()) {
      return roba;
    }
    return roba.stream()
        .filter(robaDto -> groups.contains(robaDto.getGrupa()))
        .collect(Collectors.toList());
  }

  /** Filters the list by sub-group (podgrupa). */
  public List<RobaLightDto> filterBySubGroup(List<Integer> subGroups, List<RobaLightDto> roba) {
    if (subGroups == null || subGroups.isEmpty()) {
      return roba;
    }
    return roba.stream()
        .filter(robaDto -> subGroups.contains(robaDto.getPodGrupa()))
        .collect(Collectors.toList());
  }

  /** Filters the list by stock availability (stanje). */
  public List<RobaLightDto> filterByStock(boolean inStock, List<RobaLightDto> roba) {
    if (!inStock) {
      return roba;
    }
    return roba.stream().filter(robaDto -> robaDto.getStanje() > 0).collect(Collectors.toList());
  }
}
