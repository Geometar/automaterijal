package com.automaterijal.application.integration.providers.gazela;

import com.automaterijal.application.integration.providers.gazela.GazelaApiClient.GazelaAvailabilityArticle;
import com.automaterijal.application.integration.providers.gazela.GazelaApiClient.GazelaAvailabilityArticleRequest;
import com.automaterijal.application.integration.providers.gazela.GazelaApiClient.GazelaAvailabilityResponse;
import com.automaterijal.application.integration.providers.gazela.GazelaApiClient.GazelaBrand;
import com.automaterijal.application.integration.providers.gazela.GazelaApiClient.GazelaWarehouseStock;
import com.automaterijal.application.integration.shared.AvailabilityItem;
import com.automaterijal.application.integration.shared.AvailabilityResult;
import com.automaterijal.application.integration.shared.AvailabilityStatus;
import com.automaterijal.application.integration.shared.InventoryProvider;
import com.automaterijal.application.integration.shared.InventoryQuery;
import com.automaterijal.application.integration.shared.InventoryQueryItem;
import com.automaterijal.application.integration.shared.ProviderCallStatus;
import com.automaterijal.application.integration.shared.ProviderCapabilities;
import com.automaterijal.application.integration.shared.ProviderRoutingContext;
import com.automaterijal.application.integration.shared.WarehouseAvailability;
import com.automaterijal.application.utils.CatalogNumberUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
@Slf4j
public class GazelaInventoryProvider implements InventoryProvider {

  private static final String PROVIDER_NAME = "gazela";
  private static final int API_MAX_ITEMS = 40;

  private final GazelaProperties properties;
  private final GazelaApiClient apiClient;
  private final GazelaReferenceDataService referenceDataService;

  @Override
  public String providerName() {
    return PROVIDER_NAME;
  }

  @Override
  public ProviderCapabilities capabilities() {
    return ProviderCapabilities.builder()
        .inventory(true)
        .ordering(false)
        .orderHistory(false)
        .enabled(properties.isEnabled())
        .build();
  }

  @Override
  public int maxArticlesPerRequest() {
    return resolveBatchSize();
  }

  @Override
  public boolean supportsBrand(String brand) {
    if (!StringUtils.hasText(brand)) {
      return false;
    }
    return referenceDataService.findBrand(brand).isPresent();
  }

  @Override
  public boolean supports(InventoryQuery query, ProviderRoutingContext context) {
    if (query != null && query.getItems() != null && !query.getItems().isEmpty()) {
      Set<String> brands =
          query.getItems().stream()
              .filter(Objects::nonNull)
              .map(InventoryQueryItem::getBrand)
              .filter(StringUtils::hasText)
              .map(String::trim)
              .map(value -> value.toUpperCase(Locale.ROOT))
              .collect(java.util.stream.Collectors.toSet());
      return brands.stream().anyMatch(this::supportsBrand);
    }
    return InventoryProvider.super.supports(query, context);
  }

  @Override
  public Optional<String> resolveBrandKey(Long tecDocBrandId, String tecDocBrandName) {
    return referenceDataService.resolveBrandKey(tecDocBrandName);
  }

  @Override
  public AvailabilityResult checkAvailability(InventoryQuery query) {
    if (query == null
        || (CollectionUtils.isEmpty(query.getArticleNumbers())
            && CollectionUtils.isEmpty(query.getItems()))) {
      throw new IllegalArgumentException("InventoryQuery with article numbers is required");
    }

    String requestedBrand = query.getBrand();
    List<GazelaAvailabilityArticleRequest> requestArticles;
    Map<String, String> requestBrandsByKey = new HashMap<>();

    if (!CollectionUtils.isEmpty(query.getItems())) {
      requestArticles = buildMixedBrandRequests(query.getItems(), requestBrandsByKey);
      requestedBrand = null;
    } else {
      Optional<GazelaBrand> brand = referenceDataService.findBrand(requestedBrand);
      if (brand.isEmpty() || brand.get().dlNr() == null) {
        return emptyResult();
      }

      List<String> normalizedArticles = normalizeArticles(query.getArticleNumbers());
      if (normalizedArticles.isEmpty()) {
        return emptyResult();
      }

      requestArticles =
          normalizedArticles.stream()
              .map(article -> new GazelaAvailabilityArticleRequest(null, article, brand.get().dlNr()))
              .toList();
      for (String article : normalizedArticles) {
        requestBrandsByKey.put(requestKey(brand.get().dlNr(), article), normalizeBrand(requestedBrand));
      }
    }

    if (requestArticles.isEmpty()) {
      return emptyResult();
    }

    int batchSize = resolveBatchSize();
    List<AvailabilityItem> merged = new ArrayList<>();

    for (int i = 0; i < requestArticles.size(); i += batchSize) {
      List<GazelaAvailabilityArticleRequest> batch =
          requestArticles.subList(i, Math.min(i + batchSize, requestArticles.size()));

      GazelaAvailabilityResponse response = apiClient.fetchAvailability(batch);
      if (response == null || CollectionUtils.isEmpty(response.artikli())) {
        continue;
      }

      for (GazelaAvailabilityArticle article : response.artikli()) {
        String brandForArticle = resolveBrandForArticle(article, requestedBrand, requestBrandsByKey);
        AvailabilityItem mapped = mapItem(article, brandForArticle);
        if (mapped != null) {
          merged.add(mapped);
        }
      }
    }

    return AvailabilityResult.builder()
        .provider(providerName())
        .providerType("inventory")
        .status(ProviderCallStatus.SUCCESS)
        .items(merged)
        .build();
  }

  private List<GazelaAvailabilityArticleRequest> buildMixedBrandRequests(
      List<InventoryQueryItem> items, Map<String, String> requestBrandsByKey) {
    if (items == null || items.isEmpty()) {
      return List.of();
    }

    Map<String, GazelaAvailabilityArticleRequest> dedup = new LinkedHashMap<>();
    for (InventoryQueryItem item : items) {
      if (item == null || !StringUtils.hasText(item.getArticleNumber()) || !StringUtils.hasText(item.getBrand())) {
        continue;
      }
      Optional<GazelaBrand> brand = referenceDataService.findBrand(item.getBrand());
      if (brand.isEmpty() || brand.get().dlNr() == null) {
        continue;
      }
      String article = normalizeArticle(item.getArticleNumber());
      if (!StringUtils.hasText(article)) {
        continue;
      }
      String key = requestKey(brand.get().dlNr(), article);
      dedup.putIfAbsent(
          key, new GazelaAvailabilityArticleRequest(null, article, brand.get().dlNr()));
      requestBrandsByKey.putIfAbsent(key, normalizeBrand(item.getBrand()));
    }
    return List.copyOf(dedup.values());
  }

  private AvailabilityResult emptyResult() {
    return AvailabilityResult.builder()
        .provider(providerName())
        .providerType("inventory")
        .status(ProviderCallStatus.SUCCESS)
        .items(List.of())
        .build();
  }

  private AvailabilityItem mapItem(GazelaAvailabilityArticle article, String requestedBrand) {
    if (article == null) {
      return null;
    }

    String articleNumber = normalizeArticle(article.artNr());
    if (!StringUtils.hasText(articleNumber)) {
      return null;
    }

    List<WarehouseAvailability> warehouses = mapWarehouses(article.magacini());
    int totalQuantity =
        warehouses.stream()
            .map(WarehouseAvailability::getQuantity)
            .filter(Objects::nonNull)
            .mapToInt(Integer::intValue)
            .sum();

    Set<String> cityWarehouseIds = cityWarehouseIds();
    int cityWarehouseQuantity = resolveCityWarehouseQuantity(warehouses, cityWarehouseIds);
    WarehouseAvailability cityWarehouse = resolveCityWarehouse(warehouses, cityWarehouseIds);
    boolean cityAvailable =
        !cityWarehouseIds.isEmpty()
            && cityWarehouseQuantity > 0;

    int fallbackMin = properties.defaultDeliveryBusinessDaysMin();
    int fallbackMax = properties.defaultDeliveryBusinessDaysMax();
    int leadTime = cityAvailable ? 0 : fallbackMin;
    int deliveryMin = cityAvailable ? 0 : fallbackMin;
    int deliveryMax = cityAvailable ? 0 : fallbackMax;
    boolean cityBranchAware = properties.cityBranchAwareEnabled();

    return AvailabilityItem.builder()
        .brand(
            StringUtils.hasText(requestedBrand)
                ? requestedBrand.trim().toUpperCase(Locale.ROOT)
                : null)
        .articleNumber(articleNumber)
        .status(totalQuantity > 0 ? AvailabilityStatus.AVAILABLE : AvailabilityStatus.NOT_AVAILABLE)
        .totalQuantity(totalQuantity)
        .warehouses(warehouses)
        .purchasePrice(article.vpCena())
        .sellingPrice(article.vpCena())
        .currency(properties.getCurrency())
        .leadTimeBusinessDays(leadTime)
        .deliveryToCustomerBusinessDaysMin(deliveryMin)
        .deliveryToCustomerBusinessDaysMax(deliveryMax)
        .cityBranchAware(cityBranchAware)
        .cityWarehouseQuantity(cityWarehouseQuantity)
        .fallbackDeliveryBusinessDaysMin(fallbackMin)
        .fallbackDeliveryBusinessDaysMax(fallbackMax)
        .displayWarehouse(cityBranchAware ? cityWarehouse : null)
        .displayWarehouseQuantity(cityBranchAware ? cityWarehouseQuantity : null)
        .providerProductId(StringUtils.hasText(article.katBr()) ? article.katBr().trim() : null)
        .nextDispatchCutoff(null)
        .providerStockToken(null)
        .providerNoReturnable(null)
        .build();
  }

  private Set<String> cityWarehouseIds() {
    return properties.cityWarehouseIds().stream()
        .filter(Objects::nonNull)
        .map(String::valueOf)
        .map(String::trim)
        .collect(java.util.stream.Collectors.toSet());
  }

  private int resolveCityWarehouseQuantity(
      List<WarehouseAvailability> warehouses, Set<String> cityWarehouseIds) {
    if (warehouses == null || warehouses.isEmpty() || cityWarehouseIds == null || cityWarehouseIds.isEmpty()) {
      return 0;
    }
    int quantity = 0;
    for (WarehouseAvailability warehouse : warehouses) {
      if (!isCityWarehouse(warehouse, cityWarehouseIds)) {
        continue;
      }
      quantity += warehouse.getQuantity() != null ? Math.max(warehouse.getQuantity(), 0) : 0;
    }
    return quantity;
  }

  private WarehouseAvailability resolveCityWarehouse(
      List<WarehouseAvailability> warehouses, Set<String> cityWarehouseIds) {
    if (warehouses == null || warehouses.isEmpty() || cityWarehouseIds == null || cityWarehouseIds.isEmpty()) {
      return null;
    }
    for (WarehouseAvailability warehouse : warehouses) {
      if (isCityWarehouse(warehouse, cityWarehouseIds)) {
        return warehouse;
      }
    }
    return null;
  }

  private boolean isCityWarehouse(WarehouseAvailability warehouse, Set<String> cityWarehouseIds) {
    return warehouse != null
        && StringUtils.hasText(warehouse.getLocation())
        && cityWarehouseIds.contains(warehouse.getLocation().trim());
  }

  private List<String> normalizeArticles(List<String> articleNumbers) {
    LinkedHashSet<String> normalized = new LinkedHashSet<>();
    if (articleNumbers == null || articleNumbers.isEmpty()) {
      return List.of();
    }

    for (String article : articleNumbers) {
      String cleaned = normalizeArticle(article);
      if (StringUtils.hasText(cleaned)) {
        normalized.add(cleaned);
      }
    }
    return List.copyOf(normalized);
  }

  private String normalizeArticle(String article) {
    if (!StringUtils.hasText(article)) {
      return "";
    }
    return CatalogNumberUtils.cleanPreserveSeparators(article.trim());
  }

  private String normalizeBrand(String brand) {
    return StringUtils.hasText(brand) ? brand.trim().toUpperCase(Locale.ROOT) : null;
  }

  private String resolveBrandForArticle(
      GazelaAvailabilityArticle article, String requestedBrand, Map<String, String> requestBrandsByKey) {
    if (StringUtils.hasText(requestedBrand)) {
      return normalizeBrand(requestedBrand);
    }
    if (article == null) {
      return null;
    }
    String articleNumber = normalizeArticle(article.artNr());
    String key = requestKey(article.dlNr(), articleNumber);
    String mapped = requestBrandsByKey.get(key);
    if (StringUtils.hasText(mapped)) {
      return mapped;
    }
    return referenceDataService.resolveBrandKeyByDlNr(article.dlNr()).orElse(null);
  }

  private String requestKey(Integer dlNr, String articleNumber) {
    String normalizedArticle = normalizeArticle(articleNumber);
    if (!StringUtils.hasText(normalizedArticle)) {
      return "";
    }
    return (dlNr != null ? dlNr : 0) + ":" + normalizedArticle;
  }

  private int resolveBatchSize() {
    GazelaProperties.Api api = properties.getApi();
    Integer configured = api != null ? api.getMaxBatchSize() : null;
    int batchSize = configured != null && configured > 0 ? configured : 20;
    return Math.max(1, Math.min(batchSize, API_MAX_ITEMS));
  }

  private List<WarehouseAvailability> mapWarehouses(List<GazelaWarehouseStock> warehouses) {
    if (warehouses == null || warehouses.isEmpty()) {
      return List.of();
    }

    List<WarehouseAvailability> mapped = new ArrayList<>();
    for (GazelaWarehouseStock warehouse : warehouses) {
      if (warehouse == null || warehouse.id() == null) {
        continue;
      }
      int quantity = parseQuantity(warehouse.stanje());
      if (quantity <= 0) {
        continue;
      }

      mapped.add(
          WarehouseAvailability.builder()
              .location(String.valueOf(warehouse.id()))
              .name(buildWarehouseName(warehouse))
              .quantity(quantity)
              .build());
    }

    mapped.sort(
        Comparator.comparingInt(
                (WarehouseAvailability warehouse) ->
                    warehouse != null && warehouse.getQuantity() != null
                        ? warehouse.getQuantity()
                        : 0)
            .reversed());

    return mapped;
  }

  private String buildWarehouseName(GazelaWarehouseStock warehouse) {
    if (warehouse == null) {
      return null;
    }
    String suffix =
        StringUtils.hasText(warehouse.ime())
            ? warehouse.ime().trim()
            : (warehouse.id() != null ? String.valueOf(warehouse.id()) : null);
    if (!StringUtils.hasText(suffix)) {
      return "Gazela";
    }
    return "Gazela - " + suffix;
  }

  private int parseQuantity(String rawStock) {
    if (!StringUtils.hasText(rawStock)) {
      return 0;
    }
    String value = rawStock.trim();
    if (value.endsWith("+")) {
      value = value.substring(0, value.length() - 1).trim();
    }
    try {
      int quantity = Integer.parseInt(value);
      return Math.max(quantity, 0);
    } catch (NumberFormatException ex) {
      log.debug("Unable to parse Gazela stock quantity from '{}'", rawStock);
      return 0;
    }
  }
}
