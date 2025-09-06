package com.automaterijal.application.services.roba.util;

import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaExpandedDto;
import com.automaterijal.application.domain.entity.Grupa;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.roba.RobaCene;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.services.ImageService;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.RobaCeneService;
import com.automaterijal.application.services.roba.grupe.ArticleGroupService;
import com.automaterijal.application.services.tecdoc.TecDocAttributeService;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaHelper {

  @NonNull final RobaCeneService priceService;
  @NonNull final ImageService imageService;
  @NonNull final TecDocService tecDocService;
  @NonNull final TecDocAttributeService tecDocAttributeService;
  @NonNull final ArticleGroupService articleGroupService;

  public void setupForTable(List<RobaLightDto> items, Partner partner) {
    List<Long> itemIds = items.stream().map(RobaLightDto::getRobaid).toList();
    List<TecDocAtributi> allAttributes = tecDocService.vratiTecDocAtributePrekoRobeIds(itemIds);
    List<RobaCene> allPrices = priceService.pronadjiCeneZaRobuBatch(itemIds);
    List<Grupa> groups = articleGroupService.findAll();

    for (RobaLightDto dto : items) {
      if (dto.getRobaid() == null) continue;

      List<TecDocAtributi> attributes =
          allAttributes.stream()
              .filter(attr -> Objects.equals(attr.getRobaId(), dto.getRobaid()))
              .collect(Collectors.toList());

      setupTechnicalAttributesForTable(attributes, dto);
      tecDocAttributeService.addManualTehnicalDetails(dto, attributes);

      setupPrice(dto, allPrices, partner);

      groups.stream()
          .filter(g -> g.getGrupaid().equals(dto.getGrupa()))
          .findFirst()
          .ifPresent(d -> dto.setGrupaNaziv(d.getNaziv()));
      dto.setSlika(resolveImage(dto.getRobaid(), dto.getSlika()));
    }
  }

  public void setupTechnicalAttributesForTable(List<TecDocAtributi> attributes, RobaLightDto dto) {
    List<RobaTehnickiOpisDto> result = extractTechnicalAttributes(attributes, true);
    dto.setTehnickiOpis(result);

    attributes.stream()
        .filter(attr -> attr.getDokumentId() != null)
        .findFirst()
        .ifPresent(
            attr -> {
              dto.setDokumentSlikaId(attr.getDokumentId());
              dto.setDokument(attr.getDokument());
            });
  }

  public void setupTechnicalAttributesForDetails(
      List<TecDocAtributi> attributes, RobaExpandedDto dto) {
    dto.setTehnickiOpis(extractTechnicalAttributes(attributes, false));
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
        .collect(Collectors.toList());
  }

  // u RobaHelper
  public void setupPriceOnly(List<RobaLightDto> items, Partner partner) {
    if (items == null || items.isEmpty()) return;

    var ids = items.stream().map(RobaLightDto::getRobaid).toList();
    var allPrices = priceService.pronadjiCeneZaRobuBatch(ids);

    for (var dto : items) {
      setupPrice(dto, allPrices, partner);
    }
  }

  private void setupPrice(RobaLightDto dto, List<RobaCene> allPrices, Partner partner) {
    RobaCene price =
        allPrices.stream()
            .filter(p -> p.getRobaid().equals(dto.getRobaid()))
            .findFirst()
            .orElse(null);

    dto.setCena(
        priceService.vratiCenuRobeBatch(
            price, dto.getGrupa(), dto.getProizvodjac().getProid(), partner));
    dto.setRabat(
        priceService.vratiRabatPartneraNaArtikal(
            dto.getProizvodjac().getProid(), dto.getGrupa(), partner));
  }

  public SlikaDto resolveImage(Long robaId, SlikaDto existing) {
    String url =
        (existing != null && existing.getRobaSlika() != null && !existing.getRobaSlika().isEmpty())
            ? existing.getRobaSlika()
            : robaId.toString();
    return imageService.fetchImageFromFileSystem(url);
  }
}
