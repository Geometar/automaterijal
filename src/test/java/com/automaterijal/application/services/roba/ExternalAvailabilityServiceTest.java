package com.automaterijal.application.services.roba;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
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
import com.automaterijal.application.integration.shared.ProviderBulkMode;
import com.automaterijal.application.integration.shared.WarehouseAvailability;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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
    service =
        new ExternalAvailabilityService(providerRegistry, robaCeneService, providerPricingService);
    partner = new Partner();
    partner.setPpid(1001);

    when(robaCeneService.resolvePricingPartner(any())).thenReturn(partner);
  }

  @Test
  void localInStockItem_doesNotKeepNonFebiProviderAvailability() {
    InventoryProvider provider = provider("szakal");
    when(providerRegistry.findInventoryProviders(any(), any())).thenReturn(List.of(provider));
    when(providerRegistry.checkAvailability(anyList(), any(InventoryQuery.class)))
        .thenReturn(List.of(availabilityResult("szakal", "BOSCH", "F026402165")));

    RobaLightDto dto = localItem("BOSCH", "F026402165", 4);

    service.populateExternalAvailability(List.of(dto), partner);

    assertThat(dto.getProviderAvailability()).isNull();
  }

  @Test
  void localInStockItem_keepsFebiProviderAvailability() {
    InventoryProvider provider = provider("febi-stock");
    when(providerRegistry.findInventoryProviders(any(), any())).thenReturn(List.of(provider));
    when(providerRegistry.priorityFor(any(), any(), any())).thenReturn(100);
    when(providerRegistry.checkAvailability(anyList(), any(InventoryQuery.class)))
        .thenReturn(List.of(availabilityResult("febi-stock", "FEBI", "101654")));

    RobaLightDto dto = localItem("FEBI", "101654", 3);

    service.populateExternalAvailability(List.of(dto), partner);

    assertThat(dto.getProviderAvailability()).isNotNull();
    assertThat(dto.getProviderAvailability().getProvider()).isEqualTo("febi-stock");
  }

  @Test
  void priceWithinTwoPercent_prefersFasterProviderWhenPrioritiesAreEqual() {
    InventoryProvider gazela = provider("gazela");
    InventoryProvider szakal = provider("szakal");
    when(providerRegistry.findInventoryProviders(any(), any())).thenReturn(List.of(gazela, szakal));
    when(providerRegistry.priorityFor(any(), any(), any())).thenReturn(50);

    when(providerRegistry.checkAvailability(anyList(), any(InventoryQuery.class)))
        .thenReturn(
            List.of(
                availabilityResult("gazela", "BOSCH", "F026402165", "101.90", 0),
                availabilityResult("szakal", "BOSCH", "F026402165", "100.00", 2)));

    RobaLightDto dto = localItem("BOSCH", "F026402165", 0);

    service.populateExternalAvailability(List.of(dto), partner);

    assertThat(dto.getProviderAvailability()).isNotNull();
    assertThat(dto.getProviderAvailability().getProvider()).isEqualTo("gazela");
  }

  @Test
  void higherPriorityProviderWinsWhenBothHaveStock() {
    InventoryProvider gazela = provider("gazela");
    InventoryProvider szakal = provider("szakal");
    when(providerRegistry.findInventoryProviders(any(), any())).thenReturn(List.of(gazela, szakal));
    when(providerRegistry.priorityFor(any(), any(), any()))
        .thenAnswer(
            invocation -> {
              InventoryProvider provider = invocation.getArgument(0);
              return "szakal".equalsIgnoreCase(provider.providerName()) ? 100 : 10;
            });

    when(providerRegistry.checkAvailability(anyList(), any(InventoryQuery.class)))
        .thenAnswer(
            invocation -> {
              List<InventoryProvider> calledProviders = invocation.getArgument(0);
              if (calledProviders.size() == 1
                  && "szakal".equalsIgnoreCase(calledProviders.get(0).providerName())) {
                return List.of(availabilityResult("szakal", "BOSCH", "F026402165", "100.00", 2));
              }
              return List.of(availabilityResult("gazela", "BOSCH", "F026402165", "90.00", 1));
            });

    RobaLightDto dto = localItem("BOSCH", "F026402165", 0);

    service.populateExternalAvailability(List.of(dto), partner);

    assertThat(dto.getProviderAvailability()).isNotNull();
    assertThat(dto.getProviderAvailability().getProvider()).isEqualTo("szakal");
  }

  @Test
  void lowerPriorityFillsWhenHigherPriorityIsUnavailable() {
    InventoryProvider gazela = provider("gazela");
    InventoryProvider szakal = provider("szakal");
    when(providerRegistry.findInventoryProviders(any(), any())).thenReturn(List.of(gazela, szakal));
    when(providerRegistry.priorityFor(any(), any(), any()))
        .thenAnswer(
            invocation -> {
              InventoryProvider provider = invocation.getArgument(0);
              return "szakal".equalsIgnoreCase(provider.providerName()) ? 100 : 10;
            });

    when(providerRegistry.checkAvailability(anyList(), any(InventoryQuery.class)))
        .thenAnswer(
            invocation -> {
              List<InventoryProvider> calledProviders = invocation.getArgument(0);
              if (calledProviders.size() == 1
                  && "szakal".equalsIgnoreCase(calledProviders.get(0).providerName())) {
                return List.of(unavailableAvailabilityResult("szakal", "BOSCH", "F026402165"));
              }
              return List.of(availabilityResult("gazela", "BOSCH", "F026402165", "90.00", 1));
            });

    RobaLightDto dto = localItem("BOSCH", "F026402165", 0);

    service.populateExternalAvailability(List.of(dto), partner);

    assertThat(dto.getProviderAvailability()).isNotNull();
    assertThat(dto.getProviderAvailability().getProvider()).isEqualTo("gazela");
  }

  @Test
  void febiWithHigherPriorityWinsEvenWhenMuchMoreExpensive() {
    InventoryProvider febi = provider("febi-stock");
    InventoryProvider szakal = provider("szakal");
    when(providerRegistry.findInventoryProviders(any(), any())).thenReturn(List.of(febi, szakal));
    when(providerRegistry.priorityFor(any(), any(), any()))
        .thenAnswer(
            invocation -> {
              InventoryProvider provider = invocation.getArgument(0);
              return "febi-stock".equalsIgnoreCase(provider.providerName()) ? 100 : 10;
            });

    when(providerRegistry.checkAvailability(anyList(), any(InventoryQuery.class)))
        .thenAnswer(
            invocation -> {
              List<InventoryProvider> calledProviders = invocation.getArgument(0);
              if (calledProviders.size() == 1
                  && "febi-stock".equalsIgnoreCase(calledProviders.get(0).providerName())) {
                return List.of(
                    availabilityResult("febi-stock", "FEBI", "101654", "300.00", "250.00", 5));
              }
              return List.of(availabilityResult("szakal", "FEBI", "101654", "100.00", "80.00", 1));
            });

    RobaLightDto dto = localItem("FEBI", "101654", 0);

    service.populateExternalAvailability(List.of(dto), partner);

    assertThat(dto.getProviderAvailability()).isNotNull();
    assertThat(dto.getProviderAvailability().getProvider()).isEqualTo("febi-stock");
  }

  @Test
  void comparesProvidersByPurchasePrice() {
    InventoryProvider gazela = provider("gazela");
    InventoryProvider szakal = provider("szakal");
    when(providerRegistry.findInventoryProviders(any(), any())).thenReturn(List.of(gazela, szakal));
    when(providerRegistry.priorityFor(any(), any(), any())).thenReturn(50);

    when(providerRegistry.checkAvailability(anyList(), any(InventoryQuery.class)))
        .thenReturn(
            List.of(
                availabilityResult("gazela", "BOSCH", "F026402165", "180.00", "90.00", 2),
                availabilityResult("szakal", "BOSCH", "F026402165", "100.00", "100.00", 1)));

    RobaLightDto dto = localItem("BOSCH", "F026402165", 0);

    service.populateExternalAvailability(List.of(dto), partner);

    assertThat(dto.getProviderAvailability()).isNotNull();
    assertThat(dto.getProviderAvailability().getProvider()).isEqualTo("gazela");
  }

  @Test
  void lowerPriorityIsCalledOnlyForUnresolvedArticles() {
    InventoryProvider gazela = provider("gazela");
    InventoryProvider szakal = provider("szakal");
    when(providerRegistry.findInventoryProviders(any(), any())).thenReturn(List.of(gazela, szakal));
    when(providerRegistry.priorityFor(any(), any(), any()))
        .thenAnswer(
            invocation -> {
              InventoryProvider provider = invocation.getArgument(0);
              return "gazela".equalsIgnoreCase(provider.providerName()) ? 100 : 50;
            });

    when(providerRegistry.checkAvailability(anyList(), any(InventoryQuery.class)))
        .thenAnswer(
            invocation -> {
              List<InventoryProvider> calledProviders = invocation.getArgument(0);
              InventoryQuery query = invocation.getArgument(1);
              Map<String, AvailabilityResult> byProvider =
                  Map.of(
                      "gazela",
                      AvailabilityResult.builder()
                          .provider("gazela")
                          .items(
                              List.of(
                                  availabilityItem("BOSCH", "A1", AvailabilityStatus.AVAILABLE, "100.00", 1),
                                  availabilityItem("BOSCH", "A2", AvailabilityStatus.NOT_AVAILABLE, "100.00", 1)))
                          .build(),
                      "szakal",
                      AvailabilityResult.builder()
                          .provider("szakal")
                          .items(
                              List.of(
                                  availabilityItem("BOSCH", "A2", AvailabilityStatus.AVAILABLE, "90.00", 2)))
                          .build());
              return calledProviders.stream()
                  .map(InventoryProvider::providerName)
                  .map(name -> byProvider.get(name.toLowerCase()))
                  .filter(result -> result != null)
                  .map(
                      result ->
                          AvailabilityResult.builder()
                              .provider(result.getProvider())
                              .items(
                                  result.getItems().stream()
                                      .filter(item -> query.getArticleNumbers().contains(item.getArticleNumber()))
                                      .collect(Collectors.toList()))
                              .build())
                  .collect(Collectors.toList());
            });

    RobaLightDto dto1 = localItem("BOSCH", "A1", 0);
    RobaLightDto dto2 = localItem("BOSCH", "A2", 0);

    service.populateExternalAvailability(List.of(dto1, dto2), partner);

    assertThat(dto1.getProviderAvailability()).isNotNull();
    assertThat(dto1.getProviderAvailability().getProvider()).isEqualTo("gazela");
    assertThat(dto2.getProviderAvailability()).isNotNull();
    assertThat(dto2.getProviderAvailability().getProvider()).isEqualTo("szakal");

    ArgumentCaptor<List<InventoryProvider>> providersCaptor = ArgumentCaptor.forClass(List.class);
    ArgumentCaptor<InventoryQuery> queryCaptor = ArgumentCaptor.forClass(InventoryQuery.class);
    verify(providerRegistry, atLeast(2))
        .checkAvailability(providersCaptor.capture(), queryCaptor.capture());

    boolean szakalUnresolvedOnly = false;
    for (int i = 0; i < providersCaptor.getAllValues().size(); i++) {
      List<InventoryProvider> calledProviders = providersCaptor.getAllValues().get(i);
      if (!(calledProviders.size() == 1
          && "szakal".equalsIgnoreCase(calledProviders.get(0).providerName()))) {
        continue;
      }
      List<String> numbers = queryCaptor.getAllValues().get(i).getArticleNumbers();
      if (numbers != null && numbers.size() == 1 && "A2".equals(numbers.get(0))) {
        szakalUnresolvedOnly = true;
        break;
      }
    }
    assertThat(szakalUnresolvedOnly).isTrue();
  }

  @Test
  void gazelaUsesSabacWarehouseForEtaAndKeepsAggregatedQuantity() {
    InventoryProvider gazela = provider("gazela");
    when(providerRegistry.findInventoryProviders(any(), any())).thenReturn(List.of(gazela));

    AvailabilityItem item =
        AvailabilityItem.builder()
            .brand("BOSCH")
            .articleNumber("A1")
            .status(AvailabilityStatus.AVAILABLE)
            .totalQuantity(10)
            .sellingPrice(new BigDecimal("100.00"))
            .purchasePrice(new BigDecimal("100.00"))
            .currency("RSD")
            .cityBranchAware(true)
            .cityWarehouseQuantity(2)
            .fallbackDeliveryBusinessDaysMin(1)
            .fallbackDeliveryBusinessDaysMax(2)
            .displayWarehouse(warehouse("9", "Gazela - sabac", 2))
            .displayWarehouseQuantity(2)
            .warehouses(
                List.of(
                    warehouse("3", "Gazela - zemun", 8),
                    warehouse("9", "Gazela - sabac", 2)))
            .build();
    when(providerRegistry.checkAvailability(anyList(), any(InventoryQuery.class)))
        .thenReturn(List.of(AvailabilityResult.builder().provider("gazela").items(List.of(item)).build()));

    RobaLightDto dto = localItem("BOSCH", "A1", 0);

    service.populateExternalAvailability(List.of(dto), partner);

    assertThat(dto.getProviderAvailability()).isNotNull();
    assertThat(dto.getProviderAvailability().getProvider()).isEqualTo("gazela");
    assertThat(dto.getProviderAvailability().getTotalQuantity()).isEqualTo(10);
    assertThat(dto.getProviderAvailability().getWarehouseQuantity()).isEqualTo(2);
    assertThat(dto.getProviderAvailability().getCityBranchAware()).isTrue();
    assertThat(dto.getProviderAvailability().getCityWarehouseQuantity()).isEqualTo(2);
    assertThat(dto.getProviderAvailability().getFallbackDeliveryBusinessDaysMin()).isEqualTo(1);
    assertThat(dto.getProviderAvailability().getFallbackDeliveryBusinessDaysMax()).isEqualTo(2);
    assertThat(dto.getProviderAvailability().getWarehouse()).isEqualTo("9");
    assertThat(dto.getProviderAvailability().getWarehouseName()).isEqualTo("Gazela - sabac");
  }

  @Test
  void mixedBrandProviderBatchesAcrossBrandsWhenConfigured() {
    InventoryProvider gazela = provider("gazela", 20);
    when(providerRegistry.findInventoryProviders(any(), any())).thenReturn(List.of(gazela));
    when(providerRegistry.priorityFor(any(), any(), any())).thenReturn(60);
    when(providerRegistry.bulkModeFor(any(), any(), any())).thenReturn(ProviderBulkMode.MIXED_BRAND);
    when(providerRegistry.maxBatchSizeFor(any(), any(), any())).thenReturn(20);
    when(providerRegistry.checkAvailability(anyList(), any(InventoryQuery.class)))
        .thenAnswer(
            invocation -> {
              return List.of(
                  AvailabilityResult.builder()
                      .provider("gazela")
                      .items(
                          List.of(
                              AvailabilityItem.builder()
                                  .brand("BOSCH")
                                  .articleNumber("A1")
                                  .status(AvailabilityStatus.AVAILABLE)
                                  .totalQuantity(3)
                                  .sellingPrice(new BigDecimal("100.00"))
                                  .purchasePrice(new BigDecimal("100.00"))
                                  .currency("RSD")
                                  .build(),
                              AvailabilityItem.builder()
                                  .brand("MANN")
                                  .articleNumber("B2")
                                  .status(AvailabilityStatus.AVAILABLE)
                                  .totalQuantity(4)
                                  .sellingPrice(new BigDecimal("90.00"))
                                  .purchasePrice(new BigDecimal("90.00"))
                                  .currency("RSD")
                                  .build()))
                      .build());
            });

    RobaLightDto bosch = localItem("BOSCH", "A1", 0);
    RobaLightDto mann = localItem("MANN", "B2", 0);

    service.populateExternalAvailability(List.of(bosch, mann), partner);

    ArgumentCaptor<InventoryQuery> queryCaptor = ArgumentCaptor.forClass(InventoryQuery.class);
    verify(providerRegistry, atLeast(1)).checkAvailability(anyList(), queryCaptor.capture());
    InventoryQuery mixedQuery =
        queryCaptor.getAllValues().stream()
            .filter(q -> q.getItems() != null && !q.getItems().isEmpty())
            .findFirst()
            .orElse(null);

    assertThat(mixedQuery).isNotNull();
    assertThat(mixedQuery.getItems()).hasSize(2);
    assertThat(
            mixedQuery.getItems().stream()
                .map(item -> item.getBrand() + ":" + item.getArticleNumber())
                .collect(Collectors.toSet()))
        .containsExactlyInAnyOrder("BOSCH:A1", "MANN:B2");
    assertThat(bosch.getProviderAvailability()).isNotNull();
    assertThat(mann.getProviderAvailability()).isNotNull();
  }

  @Test
  void respectsProviderMaxBatchSizeWhenChunkingTierRequests() {
    InventoryProvider gazela = provider("gazela", 1);
    when(providerRegistry.findInventoryProviders(any(), any())).thenReturn(List.of(gazela));
    when(providerRegistry.checkAvailability(anyList(), any(InventoryQuery.class)))
        .thenReturn(List.of(availabilityResult("gazela", "BOSCH", "A1", "100.00", 1)));

    RobaLightDto dto1 = localItem("BOSCH", "A1", 0);
    RobaLightDto dto2 = localItem("BOSCH", "A2", 0);
    RobaLightDto dto3 = localItem("BOSCH", "A3", 0);

    service.populateExternalAvailability(List.of(dto1, dto2, dto3), partner);

    ArgumentCaptor<InventoryQuery> queryCaptor = ArgumentCaptor.forClass(InventoryQuery.class);
    verify(providerRegistry, atLeast(3)).checkAvailability(anyList(), queryCaptor.capture());
    assertThat(queryCaptor.getAllValues())
        .allSatisfy(
            query ->
                assertThat(query.getArticleNumbers() != null ? query.getArticleNumbers().size() : 0)
                    .isLessThanOrEqualTo(1));
  }

  @Test
  void bulkModeNoneProcessesOneArticlePerRequest() {
    InventoryProvider gazela = provider("gazela", 20);
    when(providerRegistry.findInventoryProviders(any(), any())).thenReturn(List.of(gazela));
    when(providerRegistry.bulkModeFor(any(), any(), any())).thenReturn(ProviderBulkMode.NONE);
    when(providerRegistry.maxBatchSizeFor(any(), any(), any())).thenReturn(20);
    when(providerRegistry.checkAvailability(anyList(), any(InventoryQuery.class)))
        .thenReturn(List.of(availabilityResult("gazela", "BOSCH", "A1", "100.00", 1)));

    RobaLightDto dto1 = localItem("BOSCH", "A1", 0);
    RobaLightDto dto2 = localItem("BOSCH", "A2", 0);
    RobaLightDto dto3 = localItem("BOSCH", "A3", 0);

    service.populateExternalAvailability(List.of(dto1, dto2, dto3), partner);

    ArgumentCaptor<InventoryQuery> queryCaptor = ArgumentCaptor.forClass(InventoryQuery.class);
    verify(providerRegistry, atLeast(3)).checkAvailability(anyList(), queryCaptor.capture());
    assertThat(queryCaptor.getAllValues())
        .allSatisfy(
            query ->
                assertThat(query.getArticleNumbers() != null ? query.getArticleNumbers().size() : 0)
                    .isLessThanOrEqualTo(1));
  }

  @Test
  void unresolvedBrandFallback_matchesProviderResultByArticleNumber() {
    InventoryProvider gazela = provider("gazela", 20);
    when(providerRegistry.resolveBrandKey(any(), any(), any())).thenReturn(Optional.empty());
    when(providerRegistry.findInventoryProviders(any(InventoryQuery.class), any()))
        .thenAnswer(
            invocation -> {
              InventoryQuery query = invocation.getArgument(0);
              if (query != null && query.getBrand() == null) {
                return List.of(gazela);
              }
              return List.of();
            });
    when(providerRegistry.priorityFor(any(), any(), any())).thenReturn(60);
    when(providerRegistry.checkAvailability(anyList(), any(InventoryQuery.class)))
        .thenReturn(List.of(availabilityResult("gazela", "BOSCH", "A1", "100.00", 1)));

    RobaLightDto unresolved = localItem("UNKNOWN", "A1", 0);

    service.populateExternalAvailability(List.of(unresolved), partner);

    assertThat(unresolved.getProviderAvailability()).isNotNull();
    assertThat(unresolved.getProviderAvailability().getProvider()).isEqualTo("gazela");
    assertThat(unresolved.getProviderAvailability().getArticleNumber()).isEqualTo("A1");
  }

  private InventoryProvider provider(String name) {
    return provider(name, 20);
  }

  private InventoryProvider provider(String name, int maxBatchSize) {
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
      public int maxArticlesPerRequest() {
        return maxBatchSize;
      }

      @Override
      public AvailabilityResult checkAvailability(
          com.automaterijal.application.integration.shared.InventoryQuery query) {
        throw new UnsupportedOperationException("not used in this test");
      }
    };
  }

  private AvailabilityResult availabilityResult(String provider, String brand, String articleNumber) {
    return availabilityResult(provider, brand, articleNumber, "1000.00", 1);
  }

  private AvailabilityResult availabilityResult(
      String provider,
      String brand,
      String articleNumber,
      String sellingPrice,
      Integer leadTimeBusinessDays) {
    return availabilityResult(
        provider, brand, articleNumber, sellingPrice, sellingPrice, leadTimeBusinessDays);
  }

  private AvailabilityResult availabilityResult(
      String provider,
      String brand,
      String articleNumber,
      String sellingPrice,
      String purchasePrice,
      Integer leadTimeBusinessDays) {
    AvailabilityItem item =
        AvailabilityItem.builder()
            .brand(brand)
            .articleNumber(articleNumber)
            .status(AvailabilityStatus.AVAILABLE)
            .totalQuantity(10)
            .sellingPrice(new BigDecimal(sellingPrice))
            .purchasePrice(new BigDecimal(purchasePrice))
            .currency("RSD")
            .leadTimeBusinessDays(leadTimeBusinessDays)
            .deliveryToCustomerBusinessDaysMin(leadTimeBusinessDays)
            .deliveryToCustomerBusinessDaysMax(leadTimeBusinessDays)
            .build();
    return AvailabilityResult.builder().provider(provider).items(List.of(item)).build();
  }

  private AvailabilityResult unavailableAvailabilityResult(
      String provider, String brand, String articleNumber) {
    AvailabilityItem item =
        availabilityItem(brand, articleNumber, AvailabilityStatus.NOT_AVAILABLE, "0.00", null);
    return AvailabilityResult.builder().provider(provider).items(List.of(item)).build();
  }

  private AvailabilityItem availabilityItem(
      String brand,
      String articleNumber,
      AvailabilityStatus status,
      String sellingPrice,
      Integer leadTimeBusinessDays) {
    BigDecimal price = new BigDecimal(sellingPrice);
    int quantity = AvailabilityStatus.AVAILABLE.equals(status) ? 10 : 0;
    return AvailabilityItem.builder()
        .brand(brand)
        .articleNumber(articleNumber)
        .status(status)
        .totalQuantity(quantity)
        .sellingPrice(price)
        .purchasePrice(price)
        .currency("RSD")
        .leadTimeBusinessDays(leadTimeBusinessDays)
        .deliveryToCustomerBusinessDaysMin(leadTimeBusinessDays)
        .deliveryToCustomerBusinessDaysMax(leadTimeBusinessDays)
        .build();
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

  private WarehouseAvailability warehouse(String location, String name, int quantity) {
    return WarehouseAvailability.builder().location(location).name(name).quantity(quantity).build();
  }
}
