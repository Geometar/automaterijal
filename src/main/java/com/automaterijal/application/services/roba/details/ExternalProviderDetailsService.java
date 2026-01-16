package com.automaterijal.application.services.roba.details;

import com.automaterijal.application.domain.dto.ArticleAvailabilityStatus;
import com.automaterijal.application.domain.dto.ProizvodjacDTO;
import com.automaterijal.application.domain.dto.ProviderAvailabilityDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaExpandedDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.integration.registry.ProviderDetailsRegistry;
import com.automaterijal.application.integration.shared.ProviderDetailsQuery;
import com.automaterijal.application.integration.shared.ProviderDetailsResult;
import com.automaterijal.application.integration.shared.ProviderRoutingContext;
import com.automaterijal.application.integration.shared.ProviderRoutingPurpose;
import com.automaterijal.application.services.roba.ProviderPricingService;
import com.automaterijal.application.utils.PartnerPrivilegeUtils;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.Locale;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExternalProviderDetailsService {

  @NonNull ProviderDetailsRegistry detailsRegistry;
  @NonNull ProviderPricingService providerPricingService;

  public Optional<RobaExpandedDto> fetchExternalDetails(
      ProviderDetailsQuery query, Partner partner) {
    ProviderRoutingContext context = buildContext(partner);
    return detailsRegistry.fetchDetails(query, context).map(result -> mapToDto(result, partner));
  }

  private ProviderRoutingContext buildContext(Partner partner) {
    return ProviderRoutingContext.builder()
        .partnerId(partner != null ? partner.getPpid() : null)
        .partnerAudit(partner != null ? partner.getAudit() : null)
        .purpose(ProviderRoutingPurpose.DETAILS)
        .localAvailableCount(0)
        .localMatchCount(0)
        .build();
  }

  private RobaExpandedDto mapToDto(ProviderDetailsResult result, Partner partner) {
    RobaExpandedDto dto = new RobaExpandedDto();
    dto.setRobaid(null);
    dto.setTecDocArticleId(null);
    dto.setKatbr(result.getArticleNumber());
    dto.setKatbrpro(null);
    dto.setNaziv(StringUtils.hasText(result.getName()) ? result.getName() : result.getArticleNumber());
    dto.setStanje(0);

    if (StringUtils.hasText(result.getBrand())) {
      ProizvodjacDTO p = new ProizvodjacDTO();
      String brand = result.getBrand().trim().toUpperCase(Locale.ROOT);
      p.setProid(brand);
      p.setNaziv(result.getBrand().trim());
      dto.setProizvodjac(p);
    }

    if (result.getImageUrls() != null && !result.getImageUrls().isEmpty()) {
      String url = result.getImageUrls().get(0);
      if (StringUtils.hasText(url)) {
        SlikaDto slika = new SlikaDto();
        slika.setSlikeUrl(url);
        slika.setUrl(true);
        dto.setSlika(slika);
      }
    }

    if (result.getTechnicalDetails() != null) {
      dto.setTehnickiOpis(result.getTechnicalDetails());
    }

    if (StringUtils.hasText(result.getDescription())) {
      dto.setTekst(result.getDescription());
    }

    if (result.getNumbers() != null) {
      dto.setTdBrojevi(result.getNumbers());
    }

    if (StringUtils.hasText(result.getGroupId())) {
      dto.setGrupa(result.getGroupId());
    }
    if (StringUtils.hasText(result.getGroupName())) {
      dto.setGrupaNaziv(result.getGroupName());
    }
    if (result.getSubGroupId() != null) {
      dto.setPodGrupa(result.getSubGroupId());
    }
    if (StringUtils.hasText(result.getSubGroupName())) {
      dto.setPodGrupaNaziv(result.getSubGroupName());
    }

    ProviderAvailabilityDto availability = result.getAvailability();
    if (availability != null) {
      String brand =
          dto.getProizvodjac() != null ? dto.getProizvodjac().getProid() : null;
      if (!StringUtils.hasText(brand) && StringUtils.hasText(availability.getBrand())) {
        brand = availability.getBrand().trim().toUpperCase(Locale.ROOT);
      }
      String group = dto.getGrupa();
      BigDecimal finalCustomerPrice =
          providerPricingService.calculateCustomerPrice(availability, group, brand, partner);
      boolean exposePurchasePrice = PartnerPrivilegeUtils.isInternal(partner);
      ProviderAvailabilityDto priced =
          ProviderAvailabilityDto.builder()
              .brand(availability.getBrand())
              .provider(availability.getProvider())
              .articleNumber(availability.getArticleNumber())
              .available(availability.getAvailable())
              .totalQuantity(availability.getTotalQuantity())
              .warehouse(availability.getWarehouse())
              .warehouseName(availability.getWarehouseName())
              .warehouseQuantity(availability.getWarehouseQuantity())
              .purchasePrice(exposePurchasePrice ? availability.getPurchasePrice() : null)
              .price(finalCustomerPrice)
              .currency(availability.getCurrency())
              .leadTimeBusinessDays(availability.getLeadTimeBusinessDays())
              .deliveryToCustomerBusinessDaysMin(availability.getDeliveryToCustomerBusinessDaysMin())
              .deliveryToCustomerBusinessDaysMax(availability.getDeliveryToCustomerBusinessDaysMax())
              .nextDispatchCutoff(availability.getNextDispatchCutoff())
              .build();
      dto.setProviderAvailability(priced);
      if (dto.getCena() == null) {
        dto.setCena(priced.getPrice());
      }
      dto.setAvailabilityStatus(
          Boolean.TRUE.equals(availability.getAvailable())
              ? ArticleAvailabilityStatus.AVAILABLE
              : ArticleAvailabilityStatus.OUT_OF_STOCK);
    } else {
      dto.setAvailabilityStatus(ArticleAvailabilityStatus.OUT_OF_STOCK);
    }

    return dto;
  }
}
