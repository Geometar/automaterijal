package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.dto.ProviderAvailabilityDto;
import com.automaterijal.application.domain.entity.Partner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Map;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProviderPricingService {

  private static final BigDecimal VAT_FACTOR = new BigDecimal("1.20");

  @NonNull RobaCeneService priceService;
  @NonNull ProviderPricingProperties pricingProperties;

  public BigDecimal calculateCustomerPrice(
      ProviderAvailabilityDto availability, String groupId, String brand, Partner partner) {
    BigDecimal baseSellingPrice =
        resolveBaseSellingPrice(
            availability, groupId, availability != null ? availability.getProvider() : null);
    if (baseSellingPrice == null) {
      return null;
    }

    double multiplier = priceService.resolvePartnerPriceMultiplier(groupId, brand, partner);
    return baseSellingPrice
        .multiply(VAT_FACTOR)
        .multiply(BigDecimal.valueOf(multiplier))
        .setScale(2, RoundingMode.HALF_UP);
  }

  private BigDecimal resolveBaseSellingPrice(
      ProviderAvailabilityDto availability, String groupId, String provider) {
    if (availability == null) {
      return null;
    }
    BigDecimal purchase = availability.getPurchasePrice();
    if (purchase != null && purchase.compareTo(BigDecimal.ZERO) > 0) {
      BigDecimal marginPercent = resolveMarginPercent(groupId, provider);
      return purchase.multiply(BigDecimal.ONE.add(marginPercent));
    }
    return availability.getPrice();
  }

  private BigDecimal resolveMarginPercent(String groupId, String provider) {
    ProviderPricingProperties.Margin margin =
        pricingProperties != null ? pricingProperties.getMargin() : null;
    BigDecimal globalDefault =
        margin != null && margin.getDefaultPercent() != null
            ? margin.getDefaultPercent()
            : BigDecimal.ZERO;

    ProviderPricingProperties.ProviderMargin providerMargin =
        resolveProviderMargin(margin, provider);
    boolean hasProviderConfig =
        providerMargin != null
            && (providerMargin.getDefaultPercent() != null
                || (providerMargin.getByGroup() != null && !providerMargin.getByGroup().isEmpty()));

    if (hasProviderConfig) {
      BigDecimal providerDefault =
          providerMargin.getDefaultPercent() != null
              ? providerMargin.getDefaultPercent()
              : globalDefault;
      BigDecimal groupPercent = resolveGroupPercent(providerMargin.getByGroup(), groupId);
      return groupPercent != null ? groupPercent : providerDefault;
    }

    BigDecimal groupPercent =
        resolveGroupPercent(margin != null ? margin.getByGroup() : null, groupId);
    return groupPercent != null ? groupPercent : globalDefault;
  }

  private ProviderPricingProperties.ProviderMargin resolveProviderMargin(
      ProviderPricingProperties.Margin margin, String provider) {
    if (margin == null || !StringUtils.hasText(provider)) {
      return null;
    }
    Map<String, ProviderPricingProperties.ProviderMargin> byProvider = margin.getByProvider();
    if (byProvider == null || byProvider.isEmpty()) {
      return null;
    }
    String normalized = provider.trim().toUpperCase(Locale.ROOT);
    return byProvider.get(normalized);
  }

  private BigDecimal resolveGroupPercent(Map<String, BigDecimal> byGroup, String groupId) {
    if (byGroup == null || byGroup.isEmpty() || !StringUtils.hasText(groupId)) {
      return null;
    }
    String normalized = groupId.trim().toUpperCase(Locale.ROOT);
    return byGroup.get(normalized);
  }
}
