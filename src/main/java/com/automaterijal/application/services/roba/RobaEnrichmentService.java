package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.dto.ArticleAvailabilityStatus;
import com.automaterijal.application.domain.dto.robadetalji.RobaExpandedDto;
import com.automaterijal.application.domain.entity.Grupa;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.roba.RobaCene;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.services.ImageService;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.grupe.ArticleGroupService;
import com.automaterijal.application.services.tecdoc.TecDocAttributeService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RobaEnrichmentService {

  @NonNull RobaCeneService priceService;
  @NonNull ImageService imageService;
  @NonNull TecDocService tecDocService;
  @NonNull TecDocAttributeService tecDocAttributeService;
  @NonNull ArticleGroupService articleGroupService;
  @NonNull ExternalAvailabilityService externalAvailabilityService;

  /** Core enrichment for light DTOs used by both list and detail flows. */
  public void enrichDetails(RobaExpandedDto robaExpandedDto, Partner partner) {
    enrichLightDtos(List.of(robaExpandedDto), partner);
  }

  public void enrichLightDtos(List<? extends RobaLightDto> items, Partner partner) {
    if (items == null || items.isEmpty()) {
      return;
    }

    List<RobaLightDto> valid =
        items.stream()
            .filter(Objects::nonNull)
            .filter(dto -> dto.getRobaid() != null)
            .map(dto -> (RobaLightDto) dto)
            .collect(Collectors.toCollection(ArrayList::new));
    if (valid.isEmpty()) {
      return;
    }

    tecDocService.batchVracanjeICuvanjeTDAtributa(valid);

    List<Long> itemIds = valid.stream().map(RobaLightDto::getRobaid).toList();
    Map<Long, List<TecDocAtributi>> attributesByRobaId =
        mapAttributesByRobaId(tecDocService.vratiTecDocAtributePrekoRobeIds(itemIds));
    Map<Long, RobaCene> pricesByRobaId =
        mapPricesByRobaId(priceService.pronadjiCeneZaRobuBatch(itemIds));
    Map<String, String> groupNames = mapGroupNames(articleGroupService.findAll());

    for (RobaLightDto dto : valid) {
      List<TecDocAtributi> attributes = attributesByRobaId.getOrDefault(dto.getRobaid(), List.of());

      ensureTechList(dto);
      if (dto.getTehnickiOpis().isEmpty()) {
        applyTecDocTechnical(attributes, dto);
      }

      tecDocAttributeService.addManualTechnicalDetails(dto, attributes);
      applyDocumentAttributes(attributes, dto);

      setupPrice(dto, pricesByRobaId, partner);
      dto.setGrupaNaziv(groupNames.get(dto.getGrupa()));
      dto.setSlika(resolveImage(dto.getRobaid(), dto.getSlika()));
    }

    externalAvailabilityService.populateExternalAvailability(valid, partner);
    applyAvailabilityStatus(valid);
  }

  /** Lightweight enrichment for prewarmed sections that only needs price/rabat/out-of-stock. */
  public void applyPriceOnly(List<RobaLightDto> items, Partner partner) {
    if (items == null || items.isEmpty()) {
      return;
    }

    List<Long> ids =
        items.stream()
            .filter(Objects::nonNull)
            .map(RobaLightDto::getRobaid)
            .filter(Objects::nonNull)
            .toList();
    Map<Long, RobaCene> pricesByRobaId =
        mapPricesByRobaId(priceService.pronadjiCeneZaRobuBatch(ids));

    for (RobaLightDto dto : items) {
      setupPrice(dto, pricesByRobaId, partner);
    }

    externalAvailabilityService.populateExternalAvailability(items, partner);
    applyAvailabilityStatus(items);
  }

  private void applyAvailabilityStatus(List<? extends RobaLightDto> items) {
    for (RobaLightDto dto : items) {
      if (dto == null) {
        continue;
      }
      if (dto.getStanje() > 0) {
        dto.setAvailabilityStatus(ArticleAvailabilityStatus.IN_STOCK);
      } else if (dto.getProviderAvailability() != null
          && Boolean.TRUE.equals(dto.getProviderAvailability().getAvailable())) {
        dto.setAvailabilityStatus(ArticleAvailabilityStatus.AVAILABLE);
      } else {
        dto.setAvailabilityStatus(ArticleAvailabilityStatus.OUT_OF_STOCK);
      }
    }
  }

  public SlikaDto resolveImage(Long robaId, SlikaDto existing) {
    SlikaDto primary = tryResolve(robaId != null ? robaId.toString() : null);
    if (!isFallback(primary)) {
      return primary;
    }

    String preferred =
        existing != null && StringUtils.hasText(existing.getRobaSlika())
            ? existing.getRobaSlika()
            : null;

    SlikaDto secondary = tryResolve(preferred);
    if (!isFallback(secondary)) {
      return secondary;
    }

    return primary;
  }

  private void applyTecDocTechnical(List<TecDocAtributi> attributes, RobaLightDto dto) {
    if (attributes == null || attributes.isEmpty()) {
      return;
    }

    List<RobaTehnickiOpisDto> tech = extractTechnicalAttributes(attributes, true);
    if (tech.isEmpty()) {
      tech = extractTechnicalAttributes(attributes, false);
    }
    dto.setTehnickiOpis(tech);
  }

  private List<RobaTehnickiOpisDto> extractTechnicalAttributes(
      List<TecDocAtributi> attributes, boolean onlyNandA) {
    return attributes.stream()
        .filter(attr -> attr.getTecDocArticleId() != null)
        .filter(attr -> attr.getDokumentId() == null)
        .filter(
            attr -> !onlyNandA || "N".equals(attr.getAttrType()) || "A".equals(attr.getAttrType()))
        .map(
            attr -> {
              RobaTehnickiOpisDto dto = new RobaTehnickiOpisDto();
              dto.setType(attr.getAttrType());
              dto.setOznaka(attr.getAttrShortName());
              dto.setJedinica(attr.getAttrUnit());
              dto.setVrednost(attr.getAttrValue());
              return dto;
            })
        .sorted(
            Comparator.comparing(
                RobaTehnickiOpisDto::getType, Comparator.nullsFirst(Comparator.naturalOrder())))
        .collect(Collectors.toCollection(ArrayList::new));
  }

  private void setupPrice(RobaLightDto dto, Map<Long, RobaCene> pricesByRobaId, Partner partner) {
    if (dto == null || dto.getRobaid() == null) {
      return;
    }

    RobaCene price = pricesByRobaId.get(dto.getRobaid());

    dto.setCena(
        priceService.vratiCenuRobeBatch(
            price, dto.getGrupa(), dto.getProizvodjac().getProid(), partner));
    dto.setRabat(
        priceService.vratiRabatPartneraNaArtikal(
            dto.getProizvodjac().getProid(), dto.getGrupa(), partner));
    markOutOfStockIfPriceMissing(dto);
  }

  /** Ako je cena null ili 0 za kupca, tretiraj kao da nema na stanju. */
  private void markOutOfStockIfPriceMissing(RobaLightDto dto) {
    if (dto == null) {
      return;
    }

    BigDecimal cena = dto.getCena();
    if (cena == null || cena.compareTo(BigDecimal.ZERO) <= 0) {
      dto.setStanje(0);
    }
  }

  private void applyDocumentAttributes(List<TecDocAtributi> attributes, RobaLightDto dto) {
    if (dto == null || attributes == null) {
      return;
    }

    if (dto.getDokumentSlikaId() != null && dto.getDokument() != null) {
      return;
    }

    attributes.stream()
        .filter(attr -> attr.getDokumentId() != null)
        .findFirst()
        .ifPresent(
            attr -> {
              dto.setDokumentSlikaId(attr.getDokumentId());
              dto.setDokument(attr.getDokument());
            });
  }

  private Map<Long, List<TecDocAtributi>> mapAttributesByRobaId(List<TecDocAtributi> attributes) {
    if (attributes == null || attributes.isEmpty()) {
      return Map.of();
    }

    return attributes.stream()
        .filter(Objects::nonNull)
        .filter(attr -> attr.getRobaId() != null)
        .collect(Collectors.groupingBy(TecDocAtributi::getRobaId));
  }

  private Map<Long, RobaCene> mapPricesByRobaId(List<RobaCene> prices) {
    if (prices == null || prices.isEmpty()) {
      return Map.of();
    }

    return prices.stream()
        .filter(Objects::nonNull)
        .filter(price -> price.getRobaid() != null)
        .collect(Collectors.toMap(RobaCene::getRobaid, price -> price, (left, right) -> left));
  }

  private Map<String, String> mapGroupNames(List<Grupa> groups) {
    if (groups == null || groups.isEmpty()) {
      return Map.of();
    }

    return groups.stream()
        .filter(Objects::nonNull)
        .collect(Collectors.toMap(Grupa::getGrupaid, Grupa::getNaziv, (left, right) -> left));
  }

  private void ensureTechList(RobaLightDto dto) {
    if (dto.getTehnickiOpis() == null) {
      dto.setTehnickiOpis(new ArrayList<>());
      return;
    }
    if (!(dto.getTehnickiOpis() instanceof ArrayList)) {
      dto.setTehnickiOpis(new ArrayList<>(dto.getTehnickiOpis()));
    }
  }

  public void addManualDocuments(RobaExpandedDto dto) {
    if (dto == null || dto.getRobaid() == null) {
      return;
    }
    List<TecDocAtributi> attributes = tecDocService.vratiTecDocAtributePrekoRobeId(dto.getRobaid());
    tecDocAttributeService.addManualDocuments(dto, attributes);
  }

  private SlikaDto tryResolve(String baseName) {
    if (!StringUtils.hasText(baseName)) {
      return imageService.fetchImageFromFileSystem(null);
    }
    return imageService.fetchImageFromFileSystem(baseName);
  }

  private boolean isFallback(SlikaDto slika) {
    if (slika == null || !StringUtils.hasText(slika.getSlikeUrl())) {
      return true;
    }
    return imageService.isFallbackImage(slika.getSlikeUrl());
  }
}
