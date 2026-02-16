package com.automaterijal.application.services.roba;

import com.automaterijal.application.domain.dto.ProviderAvailabilityDto;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.integration.registry.ProviderRegistry;
import com.automaterijal.application.integration.shared.AvailabilityItem;
import com.automaterijal.application.integration.shared.AvailabilityResult;
import com.automaterijal.application.integration.shared.AvailabilityStatus;
import com.automaterijal.application.integration.shared.InventoryProvider;
import com.automaterijal.application.integration.shared.InventoryQuery;
import com.automaterijal.application.integration.shared.ProviderRoutingContext;
import com.automaterijal.application.integration.shared.ProviderRoutingPurpose;
import com.automaterijal.application.integration.shared.WarehouseAvailability;
import com.automaterijal.application.utils.CatalogNumberUtils;
import com.automaterijal.application.utils.PartnerPrivilegeUtils;
import java.math.BigDecimal;
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
  private static final String FEBI_PROVIDER_KEY = "febi-stock";

  @NonNull ProviderRegistry providerRegistry;
  @NonNull RobaCeneService priceService;
  @NonNull ProviderPricingService providerPricingService;

  /**
   * Popunjava providerAvailability za artikle sa podržanim proizvođačima.
   * Za artikle koji su lokalno na stanju, kombinacija lokalnog i eksternog izvora je dozvoljena
   * samo kada je eksterni provider FEBI.
   */
  public void populateExternalAvailability(List<? extends RobaLightDto> items, Partner partner) {
    populateExternalAvailability(
        items, partner, ProviderRoutingPurpose.INVENTORY_ENRICHMENT, null, null);
  }

  public void populateExternalAvailability(
      List<? extends RobaLightDto> items,
      Partner partner,
      ProviderRoutingPurpose purpose,
      Integer localMatchCount,
      Integer localAvailableCount) {
    if (items == null || items.isEmpty()) {
      return;
    }
    Partner pricingPartner = priceService.resolvePricingPartner(partner);

    Map<String, List<RobaLightDto>> byBrand = new HashMap<>();
    List<RobaLightDto> unresolved = new ArrayList<>();

    for (RobaLightDto dto : items) {
      if (dto == null || dto.getProizvodjac() == null) {
        continue;
      }
      ProviderRoutingContext context =
          buildContext(partner, dto, purpose, localMatchCount, localAvailableCount);
      String resolvedBrand = resolveBrandKey(dto, context);
      if (resolvedBrand != null) {
        byBrand.computeIfAbsent(resolvedBrand, ignored -> new ArrayList<>()).add(dto);
      } else {
        unresolved.add(dto);
      }
    }

    for (Map.Entry<String, List<RobaLightDto>> entry : byBrand.entrySet()) {
      populateForBrand(
          entry.getKey(),
          entry.getValue(),
          partner,
          pricingPartner,
          purpose,
          localMatchCount,
          localAvailableCount);
    }

    if (!unresolved.isEmpty()) {
      populateForBrand(
          null, unresolved, partner, pricingPartner, purpose, localMatchCount, localAvailableCount);
    }
  }

  private String resolveBrandKey(RobaLightDto dto, ProviderRoutingContext context) {
    if (dto == null || dto.getProizvodjac() == null) {
      return null;
    }

    String rawProid =
        StringUtils.hasText(dto.getProizvodjac().getProid())
            ? dto.getProizvodjac().getProid().trim().toUpperCase(Locale.ROOT)
            : null;
    if (StringUtils.hasText(rawProid) && hasInventoryProvider(rawProid, context)) {
      return rawProid;
    }

    // Try routing by manufacturer name (useful for TecDoc placeholders like "BLUE PRINT").
    String rawName =
        StringUtils.hasText(dto.getProizvodjac().getNaziv())
            ? dto.getProizvodjac().getNaziv().trim()
            : null;
    String byName = providerRegistry.resolveBrandKey(null, rawName, context).orElse(null);
    if (StringUtils.hasText(byName)) {
      String normalized = byName.trim().toUpperCase(Locale.ROOT);
      if (hasInventoryProvider(normalized, context)) {
        return normalized;
      }
    }

    // Last resort: try routing by the raw proid as a name.
    String byProidAsName = providerRegistry.resolveBrandKey(null, rawProid, context).orElse(null);
    if (StringUtils.hasText(byProidAsName)) {
      String normalized = byProidAsName.trim().toUpperCase(Locale.ROOT);
      if (hasInventoryProvider(normalized, context)) {
        return normalized;
      }
    }

    return null;
  }

  private void populateForBrand(
      String brand,
      List<RobaLightDto> dtos,
      Partner requestPartner,
      Partner pricingPartner,
      ProviderRoutingPurpose purpose,
      Integer localMatchCount,
      Integer localAvailableCount) {
    if (dtos == null || dtos.isEmpty()) {
      return;
    }

    ProviderRoutingContext context =
        buildContext(requestPartner, dtos, purpose, localMatchCount, localAvailableCount);
    InventoryQuery selectionQuery = InventoryQuery.builder().brand(brand).build();
    List<InventoryProvider> providers = providerRegistry.findInventoryProviders(selectionQuery, context);
    if (providers.isEmpty()) {
      return;
    }
    Map<String, Integer> providerPriority =
        providers.stream()
            .collect(
                Collectors.toMap(
                    InventoryProvider::providerName,
                    provider -> providerRegistry.priorityFor(provider, selectionQuery, context),
                    (left, right) -> left));

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
      List<AvailabilityResult> results = providerRegistry.checkAvailability(query, context);
      mergeResults(bestByArticle, results, providerPriority, brand);
    }

    for (RobaLightDto dto : dtos) {
      List<String> candidates = collectArticleNumbers(dto);
      ProviderAvailabilityDto best = null;
      for (String candidate : candidates) {
        String key = availabilityKey(brand, candidate);
        ProviderAvailabilityDto mapped = bestByArticle.get(key);
        if (mapped == null || !Boolean.TRUE.equals(mapped.getAvailable())) {
          continue;
        }
        if (shouldReplaceBestForArticle(best, mapped, providerPriority)) {
          best = mapped;
        }
      }

      if (best != null) {
        if (dto.getStanje() > 0 && !isFebiProvider(best)) {
          dto.setProviderAvailability(null);
          continue;
        }
        ProviderAvailabilityDto priced =
            applyPartnerPricing(best, dto, requestPartner, pricingPartner);
        dto.setProviderAvailability(priced);
        if (dto.getRabat() == null) {
          String brandKey =
              dto.getProizvodjac() != null ? dto.getProizvodjac().getProid() : null;
          dto.setRabat(
              priceService.vratiRabatPartneraNaArtikal(
                  brandKey, dto.getGrupa(), pricingPartner));
        }
        if (dto.getRobaid() == null && dto.getCena() == null && dto.getProviderAvailability() != null) {
          dto.setCena(dto.getProviderAvailability().getPrice());
        }
      }
    }
  }

  private void mergeResults(
      Map<String, ProviderAvailabilityDto> bestByArticle,
      List<AvailabilityResult> results,
      Map<String, Integer> providerPriority,
      String requestedBrand) {
    if (bestByArticle == null || CollectionUtils.isEmpty(results)) {
      return;
    }

    String normalizedRequestedBrand = normalizeBrand(requestedBrand);

    for (AvailabilityResult result : results) {
      if (result == null || CollectionUtils.isEmpty(result.getItems())) {
        continue;
      }

      for (AvailabilityItem item : result.getItems()) {
        if (item == null || !StringUtils.hasText(item.getArticleNumber())) {
          continue;
        }
        String itemBrand = normalizeBrand(item.getBrand());
        if (StringUtils.hasText(normalizedRequestedBrand)
            && StringUtils.hasText(itemBrand)
            && !normalizedRequestedBrand.equals(itemBrand)) {
          continue;
        }

        String defaultBrand =
            StringUtils.hasText(itemBrand) ? itemBrand : normalizedRequestedBrand;
        ProviderAvailabilityDto mapped = mapItem(result.getProvider(), item, defaultBrand);
        String key;
        if (StringUtils.hasText(normalizedRequestedBrand)) {
          key = availabilityKey(mapped.getBrand(), mapped.getArticleNumber());
        } else {
          String brandForKey = StringUtils.hasText(mapped.getBrand()) ? mapped.getBrand() : null;
          key = availabilityKey(brandForKey, mapped.getArticleNumber());
        }
        ProviderAvailabilityDto existing = bestByArticle.get(key);
        if (existing == null) {
          bestByArticle.put(key, mapped);
          continue;
        }

        Integer existingQty = existing.getTotalQuantity();
        Integer newQty = mapped.getTotalQuantity();
        Integer existingProviderPriority = providerPriorityFor(providerPriority, existing.getProvider());
        Integer newProviderPriority = providerPriorityFor(providerPriority, mapped.getProvider());
        boolean takeNew =
            Boolean.TRUE.equals(mapped.getAvailable())
                && !Boolean.TRUE.equals(existing.getAvailable());
        if (!takeNew) {
          boolean availabilityEqual = Objects.equals(mapped.getAvailable(), existing.getAvailable());
          if (availabilityEqual) {
            if (newProviderPriority > existingProviderPriority) {
              takeNew = true;
            } else if (newProviderPriority.equals(existingProviderPriority)) {
              int priceDecision = comparePrice(mapped.getPrice(), existing.getPrice());
              if (priceDecision < 0) {
                takeNew = true;
              } else if (priceDecision == 0) {
                boolean qtyBetter = newQty != null && (existingQty == null || newQty > existingQty);
                if (qtyBetter) {
                  takeNew = true;
                }
              }
            }
          }
        }
        if (takeNew) {
          bestByArticle.put(key, mapped);
        }
      }
    }
  }

  private ProviderAvailabilityDto mapItem(
      String provider, AvailabilityItem item, String defaultBrand) {
    WarehouseAvailability bestWarehouse = pickBestWarehouse(item.getWarehouses());
    return ProviderAvailabilityDto.builder()
        .brand(defaultBrand)
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
        .packagingUnit(item.getPackagingUnit())
        .leadTimeBusinessDays(item.getLeadTimeBusinessDays())
        .deliveryToCustomerBusinessDaysMin(item.getDeliveryToCustomerBusinessDaysMin())
        .deliveryToCustomerBusinessDaysMax(item.getDeliveryToCustomerBusinessDaysMax())
        .nextDispatchCutoff(item.getNextDispatchCutoff())
        .providerProductId(item.getProviderProductId())
        .providerStockToken(item.getProviderStockToken())
        .providerNoReturnable(item.getProviderNoReturnable())
        .build();
  }

  private ProviderAvailabilityDto applyPartnerPricing(
      ProviderAvailabilityDto availability,
      RobaLightDto dto,
      Partner requestPartner,
      Partner pricingPartner) {
    if (availability == null) {
      return null;
    }

    boolean exposePurchasePrice = PartnerPrivilegeUtils.isInternal(requestPartner);
    Integer packagingUnit = availability.getPackagingUnit();
    String brand =
        dto != null && dto.getProizvodjac() != null ? dto.getProizvodjac().getProid() : null;
    String group = dto != null ? dto.getGrupa() : null;
    BigDecimal finalCustomerPrice =
        providerPricingService.calculateCustomerPrice(availability, group, brand, pricingPartner);

    return ProviderAvailabilityDto.builder()
        .brand(availability.getBrand())
        .provider(availability.getProvider())
        .articleNumber(availability.getArticleNumber())
        .available(availability.getAvailable())
        .totalQuantity(availability.getTotalQuantity())
        .warehouse(availability.getWarehouse())
        .warehouseName(availability.getWarehouseName())
        .warehouseQuantity(availability.getWarehouseQuantity())
        .purchasePrice(exposePurchasePrice ? availability.getPurchasePrice() : null)
        .price(finalCustomerPrice)
        .currency(availability.getCurrency())
        .packagingUnit(packagingUnit)
        .leadTimeBusinessDays(availability.getLeadTimeBusinessDays())
        .deliveryToCustomerBusinessDaysMin(availability.getDeliveryToCustomerBusinessDaysMin())
        .deliveryToCustomerBusinessDaysMax(availability.getDeliveryToCustomerBusinessDaysMax())
        .nextDispatchCutoff(availability.getNextDispatchCutoff())
        .providerProductId(availability.getProviderProductId())
        .providerStockToken(availability.getProviderStockToken())
        .providerNoReturnable(availability.getProviderNoReturnable())
        .build();
  }

  private int providerPriorityFor(Map<String, Integer> priority, String provider) {
    if (priority == null || !StringUtils.hasText(provider)) {
      return 0;
    }
    return priority.getOrDefault(provider, 0);
  }

  private int comparePrice(BigDecimal candidate, BigDecimal existing) {
    if (candidate == null && existing == null) {
      return 0;
    }
    if (candidate == null) {
      return 1;
    }
    if (existing == null) {
      return -1;
    }
    return candidate.compareTo(existing);
  }

  private boolean shouldReplaceBestForArticle(
      ProviderAvailabilityDto currentBest,
      ProviderAvailabilityDto candidate,
      Map<String, Integer> providerPriority) {
    if (candidate == null) {
      return false;
    }
    if (currentBest == null) {
      return true;
    }

    boolean candidateAvailable = Boolean.TRUE.equals(candidate.getAvailable());
    boolean currentAvailable = Boolean.TRUE.equals(currentBest.getAvailable());
    if (candidateAvailable && !currentAvailable) {
      return true;
    }
    if (!candidateAvailable && currentAvailable) {
      return false;
    }

    int candidatePriority = providerPriorityFor(providerPriority, candidate.getProvider());
    int currentPriority = providerPriorityFor(providerPriority, currentBest.getProvider());
    if (candidatePriority > currentPriority) {
      return true;
    }
    if (candidatePriority < currentPriority) {
      return false;
    }

    int priceDecision = comparePrice(candidate.getPrice(), currentBest.getPrice());
    if (priceDecision < 0) {
      return true;
    }
    if (priceDecision > 0) {
      return false;
    }

    Integer candidateQty = candidate.getTotalQuantity();
    Integer currentQty = currentBest.getTotalQuantity();
    if (candidateQty == null) {
      return false;
    }
    if (currentQty == null) {
      return true;
    }
    return candidateQty > currentQty;
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

  private String normalizeBrand(String value) {
    return StringUtils.hasText(value) ? value.trim().toUpperCase(Locale.ROOT) : "";
  }

  private String availabilityKey(String brand, String article) {
    String normalizedArticle = normalize(article);
    if (!StringUtils.hasText(normalizedArticle)) {
      return "";
    }
    String normalizedBrand = normalizeBrand(brand);
    return StringUtils.hasText(normalizedBrand)
        ? normalizedBrand + ":" + normalizedArticle
        : normalizedArticle;
  }

  private boolean hasInventoryProvider(String brand, ProviderRoutingContext context) {
    InventoryQuery query = InventoryQuery.builder().brand(brand).build();
    return !providerRegistry.findInventoryProviders(query, context).isEmpty();
  }

  private boolean isFebiProvider(ProviderAvailabilityDto availability) {
    if (availability == null || !StringUtils.hasText(availability.getProvider())) {
      return false;
    }
    return FEBI_PROVIDER_KEY.equalsIgnoreCase(availability.getProvider().trim());
  }

  private ProviderRoutingContext buildContext(
      Partner partner,
      RobaLightDto dto,
      ProviderRoutingPurpose purpose,
      Integer localMatchCount,
      Integer localAvailableCount) {
    int matchCount = localMatchCount != null ? localMatchCount : (dto != null ? 1 : 0);
    int availableCount =
        localAvailableCount != null ? localAvailableCount : computeAvailableCount(dto);
    return ProviderRoutingContext.builder()
        .partnerId(partner != null ? partner.getPpid() : null)
        .partnerAudit(partner != null ? partner.getAudit() : null)
        .purpose(purpose != null ? purpose : ProviderRoutingPurpose.INVENTORY_ENRICHMENT)
        .localAvailableCount(availableCount)
        .localMatchCount(matchCount)
        .groups(collectGroups(dto))
        .build();
  }

  private ProviderRoutingContext buildContext(
      Partner partner,
      List<RobaLightDto> dtos,
      ProviderRoutingPurpose purpose,
      Integer localMatchCount,
      Integer localAvailableCount) {
    int matchCount = localMatchCount != null ? localMatchCount : (dtos != null ? dtos.size() : 0);
    int availableCount =
        localAvailableCount != null ? localAvailableCount : computeAvailableCount(dtos);
    return ProviderRoutingContext.builder()
        .partnerId(partner != null ? partner.getPpid() : null)
        .partnerAudit(partner != null ? partner.getAudit() : null)
        .purpose(purpose != null ? purpose : ProviderRoutingPurpose.INVENTORY_ENRICHMENT)
        .localAvailableCount(availableCount)
        .localMatchCount(matchCount)
        .groups(collectGroups(dtos))
        .build();
  }

  private int computeAvailableCount(RobaLightDto dto) {
    return dto != null && dto.getStanje() > 0 ? 1 : 0;
  }

  private int computeAvailableCount(List<RobaLightDto> dtos) {
    if (dtos == null || dtos.isEmpty()) {
      return 0;
    }
    int count = 0;
    for (RobaLightDto dto : dtos) {
      if (dto != null && dto.getStanje() > 0) {
        count++;
      }
    }
    return count;
  }

  private Set<String> collectGroups(RobaLightDto dto) {
    if (dto == null || !StringUtils.hasText(dto.getGrupa())) {
      return Collections.emptySet();
    }
    return Set.of(dto.getGrupa().trim());
  }

  private Set<String> collectGroups(List<RobaLightDto> dtos) {
    if (dtos == null || dtos.isEmpty()) {
      return Collections.emptySet();
    }
    Set<String> groups = new HashSet<>();
    for (RobaLightDto dto : dtos) {
      if (dto == null || !StringUtils.hasText(dto.getGrupa())) {
        continue;
      }
      groups.add(dto.getGrupa().trim());
    }
    return groups;
  }
}
