package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.dto.ProviderAvailabilityDto;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.integration.registry.ProviderRegistry;
import com.automaterijal.application.integration.shared.AvailabilityItem;
import com.automaterijal.application.integration.shared.AvailabilityResult;
import com.automaterijal.application.integration.shared.AvailabilityStatus;
import com.automaterijal.application.integration.shared.InventoryQuery;
import com.automaterijal.application.integration.shared.WarehouseAvailability;
import com.automaterijal.application.utils.CatalogNumberUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ExternalAvailabilityService {

  private static final int MAX_ARTICLES_PER_REQUEST = 50;
  private static final BigDecimal VAT_FACTOR = new BigDecimal("1.20");

  @NonNull ProviderRegistry providerRegistry;
  @NonNull RobaCeneService priceService;

  /**
   * Popunjava providerAvailability za artikle koji nisu na stanju (stanje <= 0) i pripadaju
   * proizvođačima za koje postoji uključen inventory provider.
   */
  public void populateExternalAvailability(List<? extends RobaLightDto> items, Partner partner) {
    if (items == null || items.isEmpty()) {
      return;
    }

    Map<String, List<RobaLightDto>> byBrand =
        items.stream()
            .filter(Objects::nonNull)
            .filter(dto -> dto.getProizvodjac() != null)
            .filter(dto -> dto.getStanje() <= 0)
            .map(dto -> (RobaLightDto) dto)
            .map(
                dto -> {
                  String resolvedBrand = resolveBrandKey(dto);
                  return resolvedBrand != null ? new AbstractMap.SimpleEntry<>(resolvedBrand, dto) : null;
                })
            .filter(Objects::nonNull)
            .collect(
                Collectors.groupingBy(
                    Map.Entry::getKey,
                    Collectors.mapping(Map.Entry::getValue, Collectors.toList())));

    for (Map.Entry<String, List<RobaLightDto>> entry : byBrand.entrySet()) {
      populateForBrand(entry.getKey(), entry.getValue(), partner);
    }
  }

  private String resolveBrandKey(RobaLightDto dto) {
    if (dto == null || dto.getProizvodjac() == null) {
      return null;
    }

    String rawProid =
        StringUtils.hasText(dto.getProizvodjac().getProid())
            ? dto.getProizvodjac().getProid().trim().toUpperCase(Locale.ROOT)
            : null;
    if (StringUtils.hasText(rawProid) && !providerRegistry.findInventoryProviders(rawProid).isEmpty()) {
      return rawProid;
    }

    // Try routing by manufacturer name (useful for TecDoc placeholders like "BLUE PRINT").
    String rawName =
        StringUtils.hasText(dto.getProizvodjac().getNaziv())
            ? dto.getProizvodjac().getNaziv().trim()
            : null;
    String byName = providerRegistry.resolveBrandKey(null, rawName).orElse(null);
    if (StringUtils.hasText(byName)) {
      String normalized = byName.trim().toUpperCase(Locale.ROOT);
      if (!providerRegistry.findInventoryProviders(normalized).isEmpty()) {
        return normalized;
      }
    }

    // Last resort: try routing by the raw proid as a name.
    String byProidAsName = providerRegistry.resolveBrandKey(null, rawProid).orElse(null);
    if (StringUtils.hasText(byProidAsName)) {
      String normalized = byProidAsName.trim().toUpperCase(Locale.ROOT);
      if (!providerRegistry.findInventoryProviders(normalized).isEmpty()) {
        return normalized;
      }
    }

    return null;
  }

  private void populateForBrand(String brand, List<RobaLightDto> dtos, Partner partner) {
    if (!StringUtils.hasText(brand) || dtos == null || dtos.isEmpty()) {
      return;
    }

    if (providerRegistry.findInventoryProviders(brand).isEmpty()) {
      return;
    }

    List<String> allArticleNumbers =
        dtos.stream().flatMap(dto -> collectArticleNumbers(dto).stream()).distinct().toList();
    if (allArticleNumbers.isEmpty()) {
      return;
    }

    Map<String, ProviderAvailabilityDto> bestByArticle = new HashMap<>();

    for (int i = 0; i < allArticleNumbers.size(); i += MAX_ARTICLES_PER_REQUEST) {
      List<String> chunk =
          allArticleNumbers.subList(
              i, Math.min(i + MAX_ARTICLES_PER_REQUEST, allArticleNumbers.size()));
      InventoryQuery query = InventoryQuery.builder().brand(brand).articleNumbers(chunk).build();
      List<AvailabilityResult> results = providerRegistry.checkAvailability(brand, query);
      mergeResults(bestByArticle, results);
    }

    for (RobaLightDto dto : dtos) {
      List<String> candidates = collectArticleNumbers(dto);
      ProviderAvailabilityDto best = null;
      for (String candidate : candidates) {
        ProviderAvailabilityDto mapped = bestByArticle.get(normalize(candidate));
        if (mapped == null || !Boolean.TRUE.equals(mapped.getAvailable())) {
          continue;
        }
        if (best == null
            || (mapped.getTotalQuantity() != null
                && (best.getTotalQuantity() == null
                    || mapped.getTotalQuantity() > best.getTotalQuantity()))) {
          best = mapped;
        }
      }

      if (best != null) {
        dto.setProviderAvailability(applyPartnerPricing(best, dto, partner));
        if (dto.getRabat() == null) {
          String brandKey =
              dto.getProizvodjac() != null ? dto.getProizvodjac().getProid() : null;
          dto.setRabat(priceService.vratiRabatPartneraNaArtikal(brandKey, dto.getGrupa(), partner));
        }
        if (dto.getRobaid() == null && dto.getCena() == null && dto.getProviderAvailability() != null) {
          dto.setCena(dto.getProviderAvailability().getPrice());
        }
      }
    }
  }

  private void mergeResults(
      Map<String, ProviderAvailabilityDto> bestByArticle, List<AvailabilityResult> results) {
    if (bestByArticle == null || CollectionUtils.isEmpty(results)) {
      return;
    }

    for (AvailabilityResult result : results) {
      if (result == null || CollectionUtils.isEmpty(result.getItems())) {
        continue;
      }

      for (AvailabilityItem item : result.getItems()) {
        if (item == null || !StringUtils.hasText(item.getArticleNumber())) {
          continue;
        }
        ProviderAvailabilityDto mapped = mapItem(result.getProvider(), item);
        String key = normalize(mapped.getArticleNumber());
        ProviderAvailabilityDto existing = bestByArticle.get(key);
        if (existing == null) {
          bestByArticle.put(key, mapped);
          continue;
        }

        Integer existingQty = existing.getTotalQuantity();
        Integer newQty = mapped.getTotalQuantity();
        boolean takeNew =
            Boolean.TRUE.equals(mapped.getAvailable())
                && !Boolean.TRUE.equals(existing.getAvailable());
        if (!takeNew) {
          takeNew = newQty != null && (existingQty == null || newQty > existingQty);
        }
        if (takeNew) {
          bestByArticle.put(key, mapped);
        }
      }
    }
  }

  private ProviderAvailabilityDto mapItem(String provider, AvailabilityItem item) {
    WarehouseAvailability bestWarehouse = pickBestWarehouse(item.getWarehouses());
    return ProviderAvailabilityDto.builder()
        .provider(provider)
        .articleNumber(item.getArticleNumber())
        .available(isAvailable(item))
        .totalQuantity(item.getTotalQuantity())
        .warehouse(bestWarehouse != null ? bestWarehouse.getLocation() : null)
        .warehouseName(resolveWarehouseName(bestWarehouse))
        .warehouseQuantity(bestWarehouse != null ? bestWarehouse.getQuantity() : null)
        .purchasePrice(item.getPurchasePrice())
        .price(item.getSellingPrice())
        .currency(item.getCurrency())
        .leadTimeBusinessDays(item.getLeadTimeBusinessDays())
        .deliveryToCustomerBusinessDaysMin(item.getDeliveryToCustomerBusinessDaysMin())
        .deliveryToCustomerBusinessDaysMax(item.getDeliveryToCustomerBusinessDaysMax())
        .nextDispatchCutoff(item.getNextDispatchCutoff())
        .build();
  }

  private ProviderAvailabilityDto applyPartnerPricing(
      ProviderAvailabilityDto availability, RobaLightDto dto, Partner partner) {
    if (availability == null) {
      return null;
    }

    BigDecimal finalCustomerPrice = calculateCustomerPrice(availability.getPrice(), dto, partner);

    return ProviderAvailabilityDto.builder()
        .provider(availability.getProvider())
        .articleNumber(availability.getArticleNumber())
        .available(availability.getAvailable())
        .totalQuantity(availability.getTotalQuantity())
        .warehouse(availability.getWarehouse())
        .warehouseName(availability.getWarehouseName())
        .warehouseQuantity(availability.getWarehouseQuantity())
        .purchasePrice(availability.getPurchasePrice())
        .price(finalCustomerPrice)
        .currency(availability.getCurrency())
        .leadTimeBusinessDays(availability.getLeadTimeBusinessDays())
        .deliveryToCustomerBusinessDaysMin(availability.getDeliveryToCustomerBusinessDaysMin())
        .deliveryToCustomerBusinessDaysMax(availability.getDeliveryToCustomerBusinessDaysMax())
        .nextDispatchCutoff(availability.getNextDispatchCutoff())
        .build();
  }

  private BigDecimal calculateCustomerPrice(
      BigDecimal baseSellingPrice, RobaLightDto dto, Partner partner) {
    if (baseSellingPrice == null) {
      return null;
    }
    String brand =
        dto != null && dto.getProizvodjac() != null ? dto.getProizvodjac().getProid() : null;
    String group = dto != null ? dto.getGrupa() : null;
    double multiplier = priceService.resolvePartnerPriceMultiplier(group, brand, partner);

    return baseSellingPrice
        .multiply(BigDecimal.valueOf(multiplier))
        .multiply(VAT_FACTOR)
        .setScale(2, RoundingMode.HALF_UP);
  }

  private String resolveWarehouseName(WarehouseAvailability warehouse) {
    if (warehouse == null) {
      return null;
    }
    if (StringUtils.hasText(warehouse.getName())) {
      return warehouse.getName();
    }
    return warehouse.getLocation();
  }

  private WarehouseAvailability pickBestWarehouse(List<WarehouseAvailability> warehouses) {
    if (warehouses == null || warehouses.isEmpty()) {
      return null;
    }
    return warehouses.stream()
        .filter(Objects::nonNull)
        .max(
            (a, b) ->
                Integer.compare(
                    a.getQuantity() != null ? a.getQuantity() : 0,
                    b.getQuantity() != null ? b.getQuantity() : 0))
        .orElse(null);
  }

  private boolean isAvailable(AvailabilityItem item) {
    if (item == null) {
      return false;
    }
    boolean statusAvailable = AvailabilityStatus.AVAILABLE.equals(item.getStatus());
    boolean hasQty = item.getTotalQuantity() != null && item.getTotalQuantity() > 0;
    return statusAvailable || hasQty;
  }

  private List<String> collectArticleNumbers(RobaLightDto dto) {
    if (dto == null) {
      return List.of();
    }
    Set<String> numbers = new HashSet<>();
    Stream.of(dto.getKatbr(), dto.getKatbrpro())
        .filter(StringUtils::hasText)
        .map(String::trim)
        .map(CatalogNumberUtils::cleanPreserveSeparators)
        .forEach(numbers::add);
    return new ArrayList<>(numbers);
  }

  private String normalize(String value) {
    return StringUtils.hasText(value)
        ? CatalogNumberUtils.cleanPreserveSeparators(value.trim())
        : "";
  }
}
