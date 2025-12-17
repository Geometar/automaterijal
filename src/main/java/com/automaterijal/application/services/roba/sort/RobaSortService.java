package com.automaterijal.application.services.roba.sort;

import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.roba.grupe.ArticleSubGroupService;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class RobaSortService {

  public List<RobaLightDto> sortByGroup(List<RobaLightDto> roba) {
    return roba.stream()
        .peek(
            robaDto -> {
              if (robaDto.getPodGrupaNaziv() == null) {
                robaDto.setPodGrupaNaziv(ArticleSubGroupService.ANONIMNA_GRUPA);
              }
            })
        .sorted(getGroupComparator())
        .collect(Collectors.toList());
  }

  private Comparator<RobaLightDto> getGroupComparator() {
    return Comparator.comparingInt(this::availabilityRank)
        .thenComparing(robaDto -> robaDto.getPodGrupa() == 0) // Podgrupa ID 0 na kraj
        .thenComparing(Comparator.comparing(RobaLightDto::getStanje).reversed())
        .thenComparing(
            RobaLightDto::getPodGrupaNaziv, Comparator.nullsLast(String::compareTo)); // po nazivu
  }

  private int availabilityRank(RobaLightDto dto) {
    if (dto == null) {
      return 99;
    }

    if (dto.getAvailabilityStatus() != null) {
      return switch (dto.getAvailabilityStatus()) {
        case IN_STOCK -> 0;
        case AVAILABLE -> 1;
        case OUT_OF_STOCK -> 2;
      };
    }

    if (dto.getStanje() > 0) {
      return 0;
    }

    if (dto.getProviderAvailability() != null
        && Boolean.TRUE.equals(dto.getProviderAvailability().getAvailable())) {
      return 1;
    }

    return 2;
  }

  /** Sortira robu TecDoc po podgrupi. */
  public List<RobaLightDto> sortByTecDocSubGroup(
      List<RobaLightDto> robaLightDtos, UniverzalniParametri parametri) {
    List<RobaLightDto> pronadjenaTacnaRoba =
        robaLightDtos.stream()
            .filter(robaDto -> robaDto.getKatbr().equals(parametri.getTrazenaRec()))
            .collect(Collectors.toList());

    // Ako nema tačnog rezultata, traži približne
    if (pronadjenaTacnaRoba.isEmpty()) {
      pronadjenaTacnaRoba =
          robaLightDtos.stream()
              .filter(robaDto -> robaDto.getKatbr().contains(parametri.getTrazenaRec()))
              .collect(Collectors.toList());
    }

    // Ako su pronađeni podaci
    if (!pronadjenaTacnaRoba.isEmpty()) {
      int podGrupa = pronadjenaTacnaRoba.get(0).getPodGrupa();

      // Sortiranje korišćenjem Comparator-a
      robaLightDtos.sort(
          Comparator.comparing((RobaLightDto robaLightDto) -> robaLightDto.getStanje() > 0)
              .reversed() // Da osiguramo da `stanje > 0` ide ispred
              .thenComparing(
                  robaDto -> podGrupa == robaDto.getPodGrupa() ? -1 : 1)); // Podgrupa prioritet
    }

    return robaLightDtos;
  }
}
