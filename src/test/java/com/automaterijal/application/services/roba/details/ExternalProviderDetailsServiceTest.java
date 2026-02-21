package com.automaterijal.application.services.roba.details;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.automaterijal.application.domain.dto.ArticleAvailabilityStatus;
import com.automaterijal.application.domain.dto.ProviderAvailabilityDto;
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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExternalProviderDetailsServiceTest {

  @Mock private ProviderDetailsRegistry detailsRegistry;
  @Mock private ProviderPricingService providerPricingService;

  private ExternalProviderDetailsService service;

  @BeforeEach
  void setUp() {
    service = new ExternalProviderDetailsService(detailsRegistry, providerPricingService);
  }

  @Test
  void fetchExternalDetails_mapsCityAwareFieldsAndHidesPurchasePriceForExternalPartner() {
    Partner partner = new Partner();
    partner.setPpid(1001);
    partner.setAudit(7);
    partner.setPrivilegije(1);

    ProviderAvailabilityDto availability =
        ProviderAvailabilityDto.builder()
            .brand("BOSCH")
            .provider("gazela")
            .articleNumber("A-100")
            .available(true)
            .totalQuantity(10)
            .warehouse("9")
            .warehouseName("Gazela - sabac")
            .warehouseQuantity(2)
            .cityBranchAware(true)
            .cityWarehouseQuantity(2)
            .fallbackDeliveryBusinessDaysMin(1)
            .fallbackDeliveryBusinessDaysMax(2)
            .purchasePrice(new BigDecimal("80.00"))
            .currency("RSD")
            .build();

    ProviderDetailsResult details =
        ProviderDetailsResult.builder()
            .provider("gazela")
            .brand("BOSCH")
            .articleNumber("A-100")
            .name("Test detalj")
            .groupId("FILPUT")
            .availability(availability)
            .build();

    when(detailsRegistry.fetchDetails(any(), any())).thenReturn(Optional.of(details));
    when(providerPricingService.calculateCustomerPrice(availability, "FILPUT", "BOSCH", partner))
        .thenReturn(new BigDecimal("120.00"));

    ProviderDetailsQuery query =
        ProviderDetailsQuery.builder().brand("BOSCH").articleNumber("A-100").build();
    Optional<RobaExpandedDto> maybeDto = service.fetchExternalDetails(query, partner);

    assertThat(maybeDto).isPresent();
    RobaExpandedDto dto = maybeDto.orElseThrow();
    assertThat(dto.getAvailabilityStatus()).isEqualTo(ArticleAvailabilityStatus.AVAILABLE);
    assertThat(dto.getCena()).isEqualByComparingTo("120.00");
    assertThat(dto.getProviderAvailability()).isNotNull();
    assertThat(dto.getProviderAvailability().getCityBranchAware()).isTrue();
    assertThat(dto.getProviderAvailability().getCityWarehouseQuantity()).isEqualTo(2);
    assertThat(dto.getProviderAvailability().getFallbackDeliveryBusinessDaysMin()).isEqualTo(1);
    assertThat(dto.getProviderAvailability().getFallbackDeliveryBusinessDaysMax()).isEqualTo(2);
    assertThat(dto.getProviderAvailability().getPurchasePrice()).isNull();
    assertThat(dto.getProviderAvailability().getPrice()).isEqualByComparingTo("120.00");

    ArgumentCaptor<ProviderRoutingContext> contextCaptor = ArgumentCaptor.forClass(ProviderRoutingContext.class);
    verify(detailsRegistry).fetchDetails(any(), contextCaptor.capture());
    assertThat(contextCaptor.getValue().getPurpose()).isEqualTo(ProviderRoutingPurpose.DETAILS);
    assertThat(contextCaptor.getValue().getPartnerId()).isEqualTo(1001);
    assertThat(contextCaptor.getValue().getPartnerAudit()).isEqualTo(7);
  }

  @Test
  void fetchExternalDetails_exposesPurchasePriceForInternalPartner() {
    Partner partner = new Partner();
    partner.setPpid(PartnerPrivilegeUtils.SUPER_ADMIN_PPID);
    partner.setPrivilegije(PartnerPrivilegeUtils.ADMIN_PRIVILEGIJE);

    ProviderAvailabilityDto availability =
        ProviderAvailabilityDto.builder()
            .brand("BOSCH")
            .provider("gazela")
            .articleNumber("A-100")
            .available(true)
            .purchasePrice(new BigDecimal("80.00"))
            .build();

    ProviderDetailsResult details =
        ProviderDetailsResult.builder()
            .provider("gazela")
            .brand("BOSCH")
            .articleNumber("A-100")
            .name("Test detalj")
            .groupId("FILPUT")
            .availability(availability)
            .build();

    when(detailsRegistry.fetchDetails(any(), any())).thenReturn(Optional.of(details));
    when(providerPricingService.calculateCustomerPrice(availability, "FILPUT", "BOSCH", partner))
        .thenReturn(new BigDecimal("120.00"));

    Optional<RobaExpandedDto> maybeDto =
        service.fetchExternalDetails(
            ProviderDetailsQuery.builder().brand("BOSCH").articleNumber("A-100").build(), partner);

    assertThat(maybeDto).isPresent();
    assertThat(maybeDto.orElseThrow().getProviderAvailability().getPurchasePrice())
        .isEqualByComparingTo("80.00");
  }
}
