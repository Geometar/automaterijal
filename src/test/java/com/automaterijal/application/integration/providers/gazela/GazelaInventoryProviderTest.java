package com.automaterijal.application.integration.providers.gazela;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.automaterijal.application.integration.providers.gazela.GazelaApiClient.GazelaAvailabilityArticle;
import com.automaterijal.application.integration.providers.gazela.GazelaApiClient.GazelaAvailabilityArticleRequest;
import com.automaterijal.application.integration.providers.gazela.GazelaApiClient.GazelaAvailabilityResponse;
import com.automaterijal.application.integration.providers.gazela.GazelaApiClient.GazelaBrand;
import com.automaterijal.application.integration.providers.gazela.GazelaApiClient.GazelaWarehouseStock;
import com.automaterijal.application.integration.shared.AvailabilityItem;
import com.automaterijal.application.integration.shared.AvailabilityResult;
import com.automaterijal.application.integration.shared.AvailabilityStatus;
import com.automaterijal.application.integration.shared.InventoryQuery;
import com.automaterijal.application.integration.shared.InventoryQueryItem;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GazelaInventoryProviderTest {

  @Mock private GazelaApiClient apiClient;
  @Mock private GazelaReferenceDataService referenceDataService;

  private GazelaProperties properties;
  private GazelaInventoryProvider provider;

  @BeforeEach
  void setUp() {
    properties = new GazelaProperties();
    properties.setEnabled(true);
    properties.getDeliveryProfile().setCityWarehouseIds(List.of(9));
    properties.getDeliveryProfile().setDefaultDeliveryBusinessDaysMin(1);
    properties.getDeliveryProfile().setDefaultDeliveryBusinessDaysMax(2);
    properties.getApi().setMaxBatchSize(20);
    provider = new GazelaInventoryProvider(properties, apiClient, referenceDataService);
  }

  @Test
  void checkAvailability_parses4PlusAndUsesCityWarehouseForSameDayEta() {
    when(referenceDataService.findBrand("BOSCH")).thenReturn(Optional.of(brand(30, "BOSCH")));
    when(apiClient.fetchAvailability(anyList()))
        .thenReturn(
            response(
                article(
                    "GK-1",
                    "03L115466",
                    30,
                    "100.00",
                    warehouse(9, "sabac", "4+"),
                    warehouse(3, "zemun", "2"),
                    warehouse(10, "valjevo", "0"))));

    InventoryQuery query =
        InventoryQuery.builder().brand("BOSCH").articleNumbers(List.of("03L 115 466")).build();

    AvailabilityResult result = provider.checkAvailability(query);

    assertThat(result.getItems()).hasSize(1);
    AvailabilityItem item = result.getItems().get(0);
    assertThat(item.getStatus()).isEqualTo(AvailabilityStatus.AVAILABLE);
    assertThat(item.getArticleNumber()).isEqualTo("03L115466");
    assertThat(item.getTotalQuantity()).isEqualTo(6);
    assertThat(item.getLeadTimeBusinessDays()).isZero();
    assertThat(item.getDeliveryToCustomerBusinessDaysMin()).isZero();
    assertThat(item.getDeliveryToCustomerBusinessDaysMax()).isZero();
    assertThat(item.getCityBranchAware()).isTrue();
    assertThat(item.getCityWarehouseQuantity()).isEqualTo(4);
    assertThat(item.getFallbackDeliveryBusinessDaysMin()).isEqualTo(1);
    assertThat(item.getFallbackDeliveryBusinessDaysMax()).isEqualTo(2);
    assertThat(item.getDisplayWarehouse()).isNotNull();
    assertThat(item.getDisplayWarehouse().getLocation()).isEqualTo("9");
    assertThat(item.getDisplayWarehouseQuantity()).isEqualTo(4);
    assertThat(item.getWarehouses()).hasSize(2);
    assertThat(item.getWarehouses()).allMatch(w -> w.getName() != null && w.getName().startsWith("Gazela - "));

    ArgumentCaptor<List<GazelaAvailabilityArticleRequest>> requestCaptor =
        ArgumentCaptor.forClass(List.class);
    verify(apiClient, times(1)).fetchAvailability(requestCaptor.capture());
    assertThat(requestCaptor.getValue()).hasSize(1);
    assertThat(requestCaptor.getValue().get(0).artNr()).isEqualTo("03L115466");
    assertThat(requestCaptor.getValue().get(0).dlNr()).isEqualTo(30);
  }

  @Test
  void checkAvailability_usesFallbackDeliveryWindowWhenCityWarehouseHasNoStock() {
    when(referenceDataService.findBrand("BOSCH")).thenReturn(Optional.of(brand(30, "BOSCH")));
    when(apiClient.fetchAvailability(anyList()))
        .thenReturn(
            response(
                article(
                    "GK-2",
                    "A2",
                    30,
                    "99.99",
                    warehouse(9, "sabac", "0"),
                    warehouse(3, "zemun", "3"))));

    AvailabilityResult result =
        provider.checkAvailability(InventoryQuery.builder().brand("BOSCH").articleNumbers(List.of("A2")).build());

    assertThat(result.getItems()).hasSize(1);
    AvailabilityItem item = result.getItems().get(0);
    assertThat(item.getStatus()).isEqualTo(AvailabilityStatus.AVAILABLE);
    assertThat(item.getTotalQuantity()).isEqualTo(3);
    assertThat(item.getLeadTimeBusinessDays()).isEqualTo(1);
    assertThat(item.getDeliveryToCustomerBusinessDaysMin()).isEqualTo(1);
    assertThat(item.getDeliveryToCustomerBusinessDaysMax()).isEqualTo(2);
    assertThat(item.getCityBranchAware()).isTrue();
    assertThat(item.getCityWarehouseQuantity()).isZero();
    assertThat(item.getDisplayWarehouse()).isNull();
    assertThat(item.getDisplayWarehouseQuantity()).isZero();
    assertThat(item.getWarehouses()).extracting("location").containsExactly("3");
  }

  @Test
  void checkAvailability_mixedBrandBatchesAndDeduplicatesByConfiguredBatchSize() {
    properties.getApi().setMaxBatchSize(2);

    when(referenceDataService.findBrand("BOSCH")).thenReturn(Optional.of(brand(30, "BOSCH")));
    when(referenceDataService.findBrand("MANN")).thenReturn(Optional.of(brand(89, "MANN")));
    when(apiClient.fetchAvailability(anyList()))
        .thenReturn(
            response(
                article("GK-1", "A1", 30, "100.00", warehouse(9, "sabac", "1")),
                article("GK-2", "B2", 89, "90.00", warehouse(9, "sabac", "1"))))
        .thenReturn(response(article("GK-3", "B3", 89, "95.00", warehouse(9, "sabac", "1"))));

    InventoryQuery query =
        InventoryQuery.builder()
            .items(
                List.of(
                    InventoryQueryItem.builder().brand("BOSCH").articleNumber("A1").build(),
                    InventoryQueryItem.builder().brand("bosch").articleNumber("a1").build(),
                    InventoryQueryItem.builder().brand("MANN").articleNumber("B2").build(),
                    InventoryQueryItem.builder().brand("MANN").articleNumber("B3").build()))
            .build();

    AvailabilityResult result = provider.checkAvailability(query);

    assertThat(result.getItems()).hasSize(3);
    Set<String> keys =
        result.getItems().stream()
            .map(item -> item.getBrand() + ":" + item.getArticleNumber())
            .collect(Collectors.toSet());
    assertThat(keys).containsExactlyInAnyOrder("BOSCH:A1", "MANN:B2", "MANN:B3");

    ArgumentCaptor<List<GazelaAvailabilityArticleRequest>> requestCaptor =
        ArgumentCaptor.forClass(List.class);
    verify(apiClient, times(2)).fetchAvailability(requestCaptor.capture());
    assertThat(requestCaptor.getAllValues()).hasSize(2);
    assertThat(requestCaptor.getAllValues()).allSatisfy(batch -> assertThat(batch.size()).isLessThanOrEqualTo(2));
  }

  private GazelaBrand brand(int dlNr, String name) {
    return new GazelaBrand(null, dlNr, null, name);
  }

  private GazelaAvailabilityResponse response(GazelaAvailabilityArticle... articles) {
    return new GazelaAvailabilityResponse(null, List.of(articles), null);
  }

  private GazelaAvailabilityArticle article(
      String katBr,
      String artNr,
      Integer dlNr,
      String vpCena,
      GazelaWarehouseStock... warehouses) {
    return new GazelaAvailabilityArticle(
        katBr, artNr, dlNr, new BigDecimal(vpCena), List.of(warehouses), null);
  }

  private GazelaWarehouseStock warehouse(Integer id, String name, String stanje) {
    return new GazelaWarehouseStock(id, name, stanje, null);
  }
}
