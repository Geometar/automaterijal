package com.automaterijal.application.services.roba;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.automaterijal.application.domain.dto.ProviderAvailabilityDto;
import com.automaterijal.application.domain.dto.ProizvodjacDTO;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.integration.registry.ProviderRegistry;
import com.automaterijal.application.integration.shared.AvailabilityItem;
import com.automaterijal.application.integration.shared.AvailabilityResult;
import com.automaterijal.application.integration.shared.AvailabilityStatus;
import com.automaterijal.application.integration.shared.InventoryProvider;
import com.automaterijal.application.integration.shared.InventoryQuery;
import com.automaterijal.application.integration.shared.ProviderRoutingContext;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExternalAvailabilityServiceTest {

  @Mock private ProviderRegistry providerRegistry;
  @Mock private RobaCeneService robaCeneService;
  @Mock private ProviderPricingService providerPricingService;

  private ExternalAvailabilityService service;
  private Partner partner;

  @BeforeEach
  void setUp() {
    service = new ExternalAvailabilityService(providerRegistry, robaCeneService, providerPricingService);
    partner = new Partner();
    partner.setPpid(1001);

    when(robaCeneService.resolvePricingPartner(any())).thenReturn(partner);
  }

  @Test
  void localInStockItem_doesNotKeepNonFebiProviderAvailability() {
    InventoryProvider provider = provider("szakal");
    when(providerRegistry.findInventoryProviders(any(), any())).thenReturn(List.of(provider));
    when(providerRegistry.checkAvailability(any(InventoryQuery.class), any(ProviderRoutingContext.class)))
        .thenReturn(List.of(availabilityResult("szakal", "BOSCH", "F026402165")));

    RobaLightDto dto = localItem("BOSCH", "F026402165", 4);

    service.populateExternalAvailability(List.of(dto), partner);

    assertThat(dto.getProviderAvailability()).isNull();
  }

  @Test
  void localInStockItem_keepsFebiProviderAvailability() {
    InventoryProvider provider = provider("febi-stock");
    when(providerRegistry.findInventoryProviders(any(), any())).thenReturn(List.of(provider));
    when(providerRegistry.checkAvailability(any(InventoryQuery.class), any(ProviderRoutingContext.class)))
        .thenReturn(List.of(availabilityResult("febi-stock", "FEBI", "101654")));

    RobaLightDto dto = localItem("FEBI", "101654", 3);

    service.populateExternalAvailability(List.of(dto), partner);

    assertThat(dto.getProviderAvailability()).isNotNull();
    assertThat(dto.getProviderAvailability().getProvider()).isEqualTo("febi-stock");
  }

  private InventoryProvider provider(String name) {
    return new InventoryProvider() {
      @Override
      public String providerName() {
        return name;
      }

      @Override
      public com.automaterijal.application.integration.shared.ProviderCapabilities capabilities() {
        return com.automaterijal.application.integration.shared.ProviderCapabilities.inventoryOnly();
      }

      @Override
      public boolean supportsBrand(String brand) {
        return true;
      }

      @Override
      public AvailabilityResult checkAvailability(
          com.automaterijal.application.integration.shared.InventoryQuery query) {
        throw new UnsupportedOperationException("not used in this test");
      }
    };
  }

  private AvailabilityResult availabilityResult(String provider, String brand, String articleNumber) {
    AvailabilityItem item =
        AvailabilityItem.builder()
            .brand(brand)
            .articleNumber(articleNumber)
            .status(AvailabilityStatus.AVAILABLE)
            .totalQuantity(10)
            .sellingPrice(new BigDecimal("1000.00"))
            .currency("RSD")
            .build();
    return AvailabilityResult.builder().provider(provider).items(List.of(item)).build();
  }

  private RobaLightDto localItem(String proid, String katbr, double stanje) {
    ProizvodjacDTO proizvodjac = new ProizvodjacDTO();
    proizvodjac.setProid(proid);
    proizvodjac.setNaziv(proid);

    RobaLightDto dto = new RobaLightDto();
    dto.setRobaid(123L);
    dto.setProizvodjac(proizvodjac);
    dto.setKatbr(katbr);
    dto.setStanje(stanje);
    dto.setGrupa("FILPUT");
    dto.setRabat(0.0);
    dto.setProviderAvailability(
        ProviderAvailabilityDto.builder().provider("placeholder").available(true).build());
    return dto;
  }
}
