package com.automaterijal.application.services.roba;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.automaterijal.application.domain.dto.ProviderAvailabilityDto;
import com.automaterijal.application.domain.entity.Partner;
import java.math.BigDecimal;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProviderPricingServiceTest {

  @Mock private RobaCeneService robaCeneService;

  private ProviderPricingProperties pricingProperties;
  private ProviderPricingService service;

  @BeforeEach
  void setUp() {
    pricingProperties = new ProviderPricingProperties();

    ProviderPricingProperties.ProviderMargin szakal = new ProviderPricingProperties.ProviderMargin();
    szakal.setDefaultPercent(new BigDecimal("0.40"));
    szakal.setByGroup(Map.of("TRIP", new BigDecimal("0.20")));

    pricingProperties.getMargin().setByProvider(Map.of("SZAKAL", szakal));
    pricingProperties.getMargin().setByGroup(Map.of("TRIP", new BigDecimal("0.30")));
    pricingProperties.getMargin().setDefaultPercent(new BigDecimal("0.65"));

    service = new ProviderPricingService(robaCeneService, pricingProperties);
  }

  @Test
  void usesProviderGroupMarginWhenPurchasePriceExists() {
    ProviderAvailabilityDto availability =
        ProviderAvailabilityDto.builder()
            .provider("szakal")
            .purchasePrice(new BigDecimal("100.00"))
            .price(new BigDecimal("999.99"))
            .build();
    when(robaCeneService.resolvePartnerPriceMultiplier("TRIP", "BOSCH", null)).thenReturn(1.10);

    BigDecimal result = service.calculateCustomerPrice(availability, "TRIP", "BOSCH", null);

    // 100 * (1 + 0.20) * 1.20 * 1.10 = 158.40
    assertThat(result).isEqualByComparingTo("158.40");
  }

  @Test
  void fallsBackToAvailabilityPriceWhenPurchaseMissing() {
    ProviderAvailabilityDto availability =
        ProviderAvailabilityDto.builder()
            .provider("szakal")
            .purchasePrice(null)
            .price(new BigDecimal("200.00"))
            .build();
    when(robaCeneService.resolvePartnerPriceMultiplier("TRIP", "BOSCH", null)).thenReturn(1.00);

    BigDecimal result = service.calculateCustomerPrice(availability, "TRIP", "BOSCH", null);

    assertThat(result).isEqualByComparingTo("240.00");
  }

  @Test
  void usesGlobalGroupMarginWhenProviderConfigMissing() {
    ProviderAvailabilityDto availability =
        ProviderAvailabilityDto.builder()
            .provider("febi-stock")
            .purchasePrice(new BigDecimal("100.00"))
            .build();
    when(robaCeneService.resolvePartnerPriceMultiplier("TRIP", "FEBI", null)).thenReturn(1.00);

    BigDecimal result = service.calculateCustomerPrice(availability, "TRIP", "FEBI", null);

    // 100 * (1 + 0.30) * 1.20 = 156.00
    assertThat(result).isEqualByComparingTo("156.00");
  }

  @Test
  void returnsNullWhenNoBasePriceCanBeResolved() {
    ProviderAvailabilityDto availability =
        ProviderAvailabilityDto.builder().provider("szakal").purchasePrice(null).price(null).build();
    Partner partner = new Partner();
    when(robaCeneService.resolvePartnerPriceMultiplier(null, null, partner)).thenReturn(1.0);

    BigDecimal result = service.calculateCustomerPrice(availability, null, null, partner);

    assertThat(result).isNull();
  }
}
