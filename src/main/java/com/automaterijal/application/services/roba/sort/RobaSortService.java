package com.automaterijal.application.services.roba.sort;

import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.integration.registry.ProviderRoutingProperties;
import com.automaterijal.application.services.roba.grupe.ArticleSubGroupService;
import com.automaterijal.application.utils.CatalogNumberUtils;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class RobaSortService {
  private final ProviderRoutingProperties providerRoutingProperties;

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

  public List<RobaLightDto> sortByGroupWithExact(List<RobaLightDto> roba, String searchTerm) {
    String wanted = normalizeCatalog(searchTerm);
    Integer exactPodgrupa = null;
    if (StringUtils.hasText(wanted)) {
      for (RobaLightDto dto : roba) {
        if (isExactMatch(dto, wanted)) {
          exactPodgrupa = dto != null ? dto.getPodGrupa() : null;
          break;
        }
      }
    }

    Integer exactPodgrupaFinal = exactPodgrupa;
    return roba.stream()
        .peek(
            robaDto -> {
              if (robaDto.getPodGrupaNaziv() == null) {
                robaDto.setPodGrupaNaziv(ArticleSubGroupService.ANONIMNA_GRUPA);
              }
            })
        .sorted(getGroupComparator(wanted, exactPodgrupaFinal))
        .collect(Collectors.toList());
  }

  private Comparator<RobaLightDto> getGroupComparator() {
    return getGroupComparator(null, null);
  }

  private Comparator<RobaLightDto> getGroupComparator(String wanted, Integer exactPodgrupa) {
    return Comparator.<RobaLightDto>comparingInt(dto -> exactMatchRankIfAvailable(dto, wanted))
        .thenComparingInt(this::availabilityRank)
        .thenComparingInt(this::providerPriorityRank)
        .thenComparing(dto -> dto == null || dto.getRobaid() == null) // TecDoc-only na kraj
        .thenComparing(robaDto -> robaDto.getPodGrupa() == 0) // Podgrupa ID 0 na kraj
        .thenComparingInt(dto -> samePodgrupaRank(dto, exactPodgrupa))
        .thenComparing(Comparator.comparing(RobaLightDto::getStanje).reversed())
        .thenComparing(
            RobaLightDto::getPodGrupaNaziv, Comparator.nullsLast(String::compareTo)); // po nazivu
  }

  private int exactMatchRank(RobaLightDto dto, String wanted) {
    if (!StringUtils.hasText(wanted)) {
      return 1;
    }
    return isExactMatch(dto, wanted) ? 0 : 1;
  }

  private int exactMatchRankIfAvailable(RobaLightDto dto, String wanted) {
    if (availabilityRank(dto) >= 2) {
      return 1;
    }
    return exactMatchRank(dto, wanted);
  }

  private boolean isExactMatch(RobaLightDto dto, String wanted) {
    if (dto == null || !StringUtils.hasText(wanted)) {
      return false;
    }
    String katbr = normalizeCatalog(dto.getKatbr());
    if (StringUtils.hasText(katbr) && katbr.equalsIgnoreCase(wanted)) {
      return true;
    }
    String katbrpro = normalizeCatalog(dto.getKatbrpro());
    return StringUtils.hasText(katbrpro) && katbrpro.equalsIgnoreCase(wanted);
  }

  private int samePodgrupaRank(RobaLightDto dto, Integer exactPodgrupa) {
    if (dto == null || exactPodgrupa == null) {
      return 1;
    }
    return dto.getPodGrupa() == exactPodgrupa ? 0 : 1;
  }

  private String normalizeCatalog(String value) {
    return StringUtils.hasText(value)
        ? CatalogNumberUtils.cleanPreserveSeparators(value.trim())
        : "";
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

  private int providerPriorityRank(RobaLightDto dto) {
    if (availabilityRank(dto) != 1
        || dto == null
        || dto.getProviderAvailability() == null
        || !Boolean.TRUE.equals(dto.getProviderAvailability().getAvailable())) {
      return 9;
    }
    String provider = dto.getProviderAvailability().getProvider();
    if (!StringUtils.hasText(provider)) {
      return 8;
    }
    int providerPriority = resolveConfiguredProviderPriority(provider.trim().toLowerCase(Locale.ROOT));
    // Comparator sorts ascending, so we invert priority: larger priority should come first.
    return -providerPriority;
  }

  private int resolveConfiguredProviderPriority(String provider) {
    if (!StringUtils.hasText(provider)) {
      return 0;
    }
    if (providerRoutingProperties == null || providerRoutingProperties.getRules() == null) {
      return 0;
    }

    int configured =
        providerRoutingProperties.getRules().stream()
            .filter(Objects::nonNull)
            .filter(rule -> rule.getEnabled() == null || rule.getEnabled())
            .filter(rule -> StringUtils.hasText(rule.getProvider()))
            .filter(rule -> provider.equalsIgnoreCase(rule.getProvider().trim()))
            .map(ProviderRoutingProperties.Rule::getPriority)
            .filter(Objects::nonNull)
            .mapToInt(Integer::intValue)
            .max()
            .orElse(Integer.MIN_VALUE);

    if (configured != Integer.MIN_VALUE) {
      return configured;
    }
    return 0;
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
