package com.automaterijal.application.integration.providers.febi;

import com.automaterijal.application.integration.providers.febi.model.FebiStockRequest;
import com.automaterijal.application.integration.providers.febi.model.FebiStockResponse;
import com.automaterijal.application.integration.providers.febi.model.FebiStockResponseItem;
import com.automaterijal.application.integration.providers.febi.model.FebiWarehouse;
import com.automaterijal.application.integration.providers.febi.price.FebiPriceService;
import com.automaterijal.application.integration.shared.AvailabilityItem;
import com.automaterijal.application.integration.shared.AvailabilityResult;
import com.automaterijal.application.integration.shared.AvailabilityStatus;
import com.automaterijal.application.integration.shared.InventoryProvider;
import com.automaterijal.application.integration.shared.InventoryQuery;
import com.automaterijal.application.integration.shared.ProviderCallStatus;
import com.automaterijal.application.integration.shared.ProviderCapabilities;
import com.automaterijal.application.integration.shared.WarehouseAvailability;
import com.automaterijal.application.integration.shared.exception.ProviderAuthenticationException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Inventory provider for FEBI/Bilstein stock API v2.
 *
 * <p>Uses client-credentials token from {@link FebiAuthClient}, batches article numbers, and always
 * sends the configured default destination country (no per-request override). Availability is
 * marked AVAILABLE when any warehouse reports quantity > 0.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class FebiInventoryProvider implements InventoryProvider {

  private static final String PROVIDER_NAME = "febi-stock";

  private final FebiAuthClient authClient;
  private final FebiStockClient stockClient;
  private final FebiProperties properties;
  private final FebiPriceService priceService;

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
  public boolean supportsBrand(String brand) {
    if (!StringUtils.hasText(brand)) {
      return false;
    }

    return properties.getSupportedBrands().stream()
        .anyMatch(b -> b != null && b.equalsIgnoreCase(brand));
  }

  @Override
  public Optional<String> resolveBrandKey(Long tecDocBrandId, String tecDocBrandName) {
    if (tecDocBrandId == null) {
      return Optional.empty();
    }

    String mapped =
        properties.getSupportedTecDocBrands() != null
            ? properties.getSupportedTecDocBrands().get(tecDocBrandId)
            : null;
    if (StringUtils.hasText(mapped) && supportsBrand(mapped)) {
      return Optional.of(mapped.trim().toUpperCase(Locale.ROOT));
    }

    // Fallback: if TecDoc name contains a supported brand key, route to that key.
    if (StringUtils.hasText(tecDocBrandName) && properties.getSupportedBrands() != null) {
      String normalized = tecDocBrandName.trim().toUpperCase(Locale.ROOT);
      for (String candidate : properties.getSupportedBrands()) {
        if (!StringUtils.hasText(candidate)) {
          continue;
        }
        String key = candidate.trim().toUpperCase(Locale.ROOT);
        if (normalized.contains(key)) {
          return Optional.of(key);
        }
      }
    }

    return Optional.empty();
  }

  @Override
  public AvailabilityResult checkAvailability(InventoryQuery query) {
    if (query == null || query.getArticleNumbers() == null || query.getArticleNumbers().isEmpty()) {
      throw new IllegalArgumentException("InventoryQuery with article numbers is required");
    }

    String destination =
        StringUtils.hasText(properties.getDefaultDestinationCountry())
            ? properties.getDefaultDestinationCountry()
            : "RS";

    FebiStockRequest request =
        FebiStockRequest.builder()
            .destinationCountry(destination)
            .items(query.getArticleNumbers())
            .bypassArticleErrors(properties.isBypassArticleErrors())
            .build();

    try {
      String token = authClient.getAccessToken();
      FebiStockResponse response = stockClient.fetchStock(request, token);
      return mapToResult(response, destination);
    } catch (ProviderAuthenticationException ex) {
      // Token might be expired; refresh once and retry
      String token = authClient.refreshTokenNow();
      FebiStockResponse response = stockClient.fetchStock(request, token);
      return mapToResult(response, destination);
    }
  }

  private AvailabilityResult mapToResult(FebiStockResponse response, String requestedDestination) {
    List<AvailabilityItem> mapped =
        response != null && response.getItems() != null
            ? response.getItems().stream().map(this::mapItem).toList()
            : Collections.emptyList();

    return AvailabilityResult.builder()
        .provider(providerName())
        .providerType("inventory")
        .status(ProviderCallStatus.SUCCESS)
        .destinationCountry(
            response != null && StringUtils.hasText(response.getDestinationCountry())
                ? response.getDestinationCountry()
                : requestedDestination)
        .items(mapped)
        .build();
  }

  private AvailabilityItem mapItem(FebiStockResponseItem item) {
    if (item == null) {
      return AvailabilityItem.builder()
          .status(AvailabilityStatus.UNKNOWN)
          .warehouses(Collections.emptyList())
          .totalQuantity(0)
          .build();
    }

    List<WarehouseAvailability> warehouses =
        item.getWarehouses() != null
            ? item.getWarehouses().stream().map(this::mapWarehouse).toList()
            : Collections.emptyList();

    int totalQuantity =
        warehouses.stream()
            .map(WarehouseAvailability::getQuantity)
            .filter(Objects::nonNull)
            .mapToInt(Integer::intValue)
            .sum();

    AvailabilityStatus status =
        totalQuantity > 0 ? AvailabilityStatus.AVAILABLE : AvailabilityStatus.NOT_AVAILABLE;

    var price =
        priceService
            .findPrice(item.getArticleNumber())
            .orElse(null);

    return AvailabilityItem.builder()
        .articleNumber(item.getArticleNumber())
        .status(status)
        .totalQuantity(totalQuantity)
        .warehouses(warehouses)
        .purchasePrice(price != null ? price.purchasePrice() : null)
        .sellingPrice(price != null ? price.sellingPrice() : null)
        .currency(price != null ? price.currency() : null)
        .leadTimeBusinessDays(properties.getLeadTimeBusinessDays())
        .deliveryToCustomerBusinessDaysMin(properties.getDeliveryToCustomerBusinessDaysMin())
        .deliveryToCustomerBusinessDaysMax(properties.getDeliveryToCustomerBusinessDaysMax())
        .nextDispatchCutoff(properties.getDispatchCutoff())
        .build();
  }

  private WarehouseAvailability mapWarehouse(FebiWarehouse warehouse) {
    if (warehouse == null) {
      return WarehouseAvailability.builder().build();
    }

    return WarehouseAvailability.builder()
        .location(warehouse.getLocation())
        .name(properties.getWarehouseName())
        .quantity(warehouse.getQuantity())
        .build();
  }
}
