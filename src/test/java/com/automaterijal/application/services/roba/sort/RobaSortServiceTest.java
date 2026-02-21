package com.automaterijal.application.services.roba.sort;

import static org.assertj.core.api.Assertions.assertThat;

import com.automaterijal.application.domain.dto.ArticleAvailabilityStatus;
import com.automaterijal.application.domain.dto.ProviderAvailabilityDto;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.integration.registry.ProviderRoutingProperties;
import java.util.List;
import org.junit.jupiter.api.Test;

class RobaSortServiceTest {

  private final RobaSortService service = new RobaSortService(providerRoutingProperties());

  @Test
  void availableProvidersAreSortedWithFebiBeforeOthers() {
    RobaLightDto szakal = buildAvailableProvider("Szakal item", "szakal");
    RobaLightDto febi = buildAvailableProvider("Febi item", "febi-stock");

    List<RobaLightDto> sorted = service.sortByGroup(List.of(szakal, febi));

    assertThat(sorted).extracting(RobaLightDto::getNaziv).containsExactly("Febi item", "Szakal item");
  }

  @Test
  void availableProvidersAreSortedByConfiguredPriority() {
    RobaLightDto szakal = buildAvailableProvider("Szakal item", "szakal");
    RobaLightDto gazela = buildAvailableProvider("Gazela item", "gazela");
    RobaLightDto febi = buildAvailableProvider("Febi item", "febi-stock");

    List<RobaLightDto> sorted = service.sortByGroup(List.of(szakal, gazela, febi));

    assertThat(sorted)
        .extracting(RobaLightDto::getNaziv)
        .containsExactly("Febi item", "Gazela item", "Szakal item");
  }

  @Test
  void inStockThenAvailableThenOutOfStockOrderingIsKept() {
    RobaLightDto inStock = new RobaLightDto();
    inStock.setNaziv("In stock");
    inStock.setStanje(5);
    inStock.setAvailabilityStatus(ArticleAvailabilityStatus.IN_STOCK);
    inStock.setPodGrupa(1);
    inStock.setPodGrupaNaziv("A");

    RobaLightDto febi = buildAvailableProvider("Febi item", "febi-stock");
    RobaLightDto out = new RobaLightDto();
    out.setNaziv("Out");
    out.setStanje(0);
    out.setAvailabilityStatus(ArticleAvailabilityStatus.OUT_OF_STOCK);
    out.setPodGrupa(1);
    out.setPodGrupaNaziv("A");

    List<RobaLightDto> sorted = service.sortByGroup(List.of(out, febi, inStock));

    assertThat(sorted)
        .extracting(RobaLightDto::getNaziv)
        .containsExactly("In stock", "Febi item", "Out");
  }

  private RobaLightDto buildAvailableProvider(String name, String providerKey) {
    ProviderAvailabilityDto providerAvailability =
        ProviderAvailabilityDto.builder()
            .provider(providerKey)
            .available(true)
            .warehouseQuantity(5)
            .totalQuantity(5)
            .build();
    RobaLightDto dto = new RobaLightDto();
    dto.setNaziv(name);
    dto.setStanje(0);
    dto.setAvailabilityStatus(ArticleAvailabilityStatus.AVAILABLE);
    dto.setProviderAvailability(providerAvailability);
    dto.setPodGrupa(1);
    dto.setPodGrupaNaziv("A");
    return dto;
  }

  private static ProviderRoutingProperties providerRoutingProperties() {
    ProviderRoutingProperties properties = new ProviderRoutingProperties();

    ProviderRoutingProperties.Rule febiRule = new ProviderRoutingProperties.Rule();
    febiRule.setProvider("febi-stock");
    febiRule.setPriority(100);

    ProviderRoutingProperties.Rule gazelaRule = new ProviderRoutingProperties.Rule();
    gazelaRule.setProvider("gazela");
    gazelaRule.setPriority(60);

    ProviderRoutingProperties.Rule szakalRule = new ProviderRoutingProperties.Rule();
    szakalRule.setProvider("szakal");
    szakalRule.setPriority(50);

    properties.setRules(List.of(febiRule, gazelaRule, szakalRule));
    return properties;
  }
}
