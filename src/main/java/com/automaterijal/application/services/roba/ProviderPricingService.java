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
    BigDecimal baseSellingPrice = resolveBaseSellingPrice(availability, groupId);
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
      ProviderAvailabilityDto availability, String groupId) {
    if (availability == null) {
      return null;
    }
    BigDecimal purchase = availability.getPurchasePrice();
    if (purchase != null && purchase.compareTo(BigDecimal.ZERO) > 0) {
      BigDecimal marginPercent = resolveMarginPercent(groupId);
      return purchase.multiply(BigDecimal.ONE.add(marginPercent));
    }
    return availability.getPrice();
  }

  private BigDecimal resolveMarginPercent(String groupId) {
    BigDecimal defaultPercent =
        pricingProperties != null
            && pricingProperties.getMargin() != null
            && pricingProperties.getMargin().getDefaultPercent() != null
            ? pricingProperties.getMargin().getDefaultPercent()
            : BigDecimal.ZERO;
    if (!StringUtils.hasText(groupId)) {
      return defaultPercent;
    }
    String normalized = groupId.trim().toUpperCase(Locale.ROOT);
    Map<String, BigDecimal> byGroup =
        pricingProperties != null && pricingProperties.getMargin() != null
            ? pricingProperties.getMargin().getByGroup()
            : null;
    if (byGroup == null || byGroup.isEmpty()) {
      return defaultPercent;
    }
    BigDecimal groupPercent = byGroup.get(normalized);
    return groupPercent != null ? groupPercent : defaultPercent;
  }
}
