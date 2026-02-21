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
import com.automaterijal.application.integration.shared.InventoryQueryItem;
import com.automaterijal.application.integration.shared.ProviderBulkMode;
import com.automaterijal.application.integration.shared.ProviderRoutingContext;
import com.automaterijal.application.integration.shared.ProviderRoutingPurpose;
import com.automaterijal.application.integration.shared.WarehouseAvailability;
import com.automaterijal.application.utils.CatalogNumberUtils;
import com.automaterijal.application.utils.PartnerPrivilegeUtils;
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

  private static final int MAX_ARTICLES_PER_REQUEST = 20;
  private static final BigDecimal SPEED_PRICE_DELTA_THRESHOLD = new BigDecimal("0.02");

  @NonNull ProviderRegistry providerRegistry;
  @NonNull RobaCeneService priceService;
  @NonNull ProviderPricingService providerPricingService;

  /**
   * Popunjava providerAvailability za artikle sa podržanim proizvođačima.
   * Za artikle koji su lokalno na stanju, kombinacija lokalnog i eksternog izvora je dozvoljena
   * samo kada eksterni provider ima najvisi priority u trenutnom routing kontekstu.
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

    if (!byBrand.isEmpty()) {
      populateAcrossBrands(
          byBrand,
          partner,
          pricingPartner,
          purpose,
          localMatchCount,
          localAvailableCount);
    }

    if (!unresolved.isEmpty()) {
      populateWithoutResolvedBrand(
          unresolved, partner, pricingPartner, purpose, localMatchCount, localAvailableCount);
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

  private void populateAcrossBrands(
      Map<String, List<RobaLightDto>> byBrand,
      Partner requestPartner,
      Partner pricingPartner,
      ProviderRoutingPurpose purpose,
      Integer localMatchCount,
      Integer localAvailableCount) {
    if (byBrand == null || byBrand.isEmpty()) {
      return;
    }

    NavigableSet<Integer> tiers = new TreeSet<>(Comparator.reverseOrder());
    Map<String, BrandExecution> executions =
        buildBrandExecutions(
            byBrand, requestPartner, purpose, localMatchCount, localAvailableCount, tiers);
    if (executions.isEmpty()) {
      return;
    }

    Map<String, ProviderAvailabilityDto> bestByArticle = new HashMap<>();
    for (Integer tier : tiers) {
      if (tier == null) {
        continue;
      }
      Map<String, ProviderAvailabilityDto> tierBest = new HashMap<>();
      Map<String, Integer> tierPriority = buildTierPriority(executions.values(), tier);
      processSameBrandTier(executions.values(), tier, tierBest, tierPriority);
      processMixedBrandTier(executions, tier, tierBest, tierPriority);

      for (Map.Entry<String, ProviderAvailabilityDto> entry : tierBest.entrySet()) {
        bestByArticle.putIfAbsent(entry.getKey(), entry.getValue());
      }

      removeResolvedArticles(executions.values(), bestByArticle);
    }

    applyBestAvailabilityForExecutions(
        executions.values(), bestByArticle, requestPartner, pricingPartner);
  }

  private Map<String, BrandExecution> buildBrandExecutions(
      Map<String, List<RobaLightDto>> byBrand,
      Partner requestPartner,
      ProviderRoutingPurpose purpose,
      Integer localMatchCount,
      Integer localAvailableCount,
      NavigableSet<Integer> tiers) {
    Map<String, BrandExecution> executions = new LinkedHashMap<>();
    for (Map.Entry<String, List<RobaLightDto>> entry : byBrand.entrySet()) {
      String brand = entry.getKey();
      List<RobaLightDto> dtos = entry.getValue();
      if (dtos == null || dtos.isEmpty()) {
        continue;
      }
      ProviderRoutingContext context =
          buildContext(requestPartner, dtos, purpose, localMatchCount, localAvailableCount);
      InventoryQuery selectionQuery = InventoryQuery.builder().brand(brand).build();
      List<InventoryProvider> providers = providerRegistry.findInventoryProviders(selectionQuery, context);
      if (providers.isEmpty()) {
        continue;
      }
      Map<String, Integer> providerPriority =
          resolveProviderPriorityMap(providers, selectionQuery, context);
      List<ProviderPlan> plans = buildProviderPlans(providers, providerPriority, selectionQuery, context);
      plans.stream().map(plan -> plan.priority).forEach(tiers::add);
      Set<String> unresolvedArticleNumbers =
          dtos.stream()
              .flatMap(dto -> collectArticleNumbers(dto).stream())
              .collect(Collectors.toCollection(LinkedHashSet::new));
      if (unresolvedArticleNumbers.isEmpty()) {
        continue;
      }
      executions.put(
          brand, new BrandExecution(brand, dtos, providerPriority, plans, unresolvedArticleNumbers));
    }
    return executions;
  }

  private List<ProviderPlan> buildProviderPlans(
      List<InventoryProvider> providers,
      Map<String, Integer> providerPriority,
      InventoryQuery selectionQuery,
      ProviderRoutingContext context) {
    List<ProviderPlan> plans = new ArrayList<>();
    for (InventoryProvider provider : providers) {
      int priority = providerPriorityFor(providerPriority, provider.providerName());
      ProviderBulkMode bulkMode = providerRegistry.bulkModeFor(provider, selectionQuery, context);
      int maxBatchSize = providerRegistry.maxBatchSizeFor(provider, selectionQuery, context);
      if (maxBatchSize <= 0) {
        maxBatchSize = provider.maxArticlesPerRequest();
      }
      if (maxBatchSize <= 0) {
        maxBatchSize = MAX_ARTICLES_PER_REQUEST;
      }
      plans.add(new ProviderPlan(provider, priority, bulkMode, maxBatchSize));
    }
    return plans;
  }

  private Map<String, Integer> buildTierPriority(Collection<BrandExecution> executions, int tier) {
    Map<String, Integer> tierPriority = new HashMap<>();
    for (BrandExecution execution : executions) {
      for (ProviderPlan plan : execution.providerPlans) {
        if (plan.priority == tier) {
          tierPriority.putIfAbsent(plan.provider.providerName(), tier);
        }
      }
    }
    return tierPriority;
  }

  private void processSameBrandTier(
      Collection<BrandExecution> executions,
      int tier,
      Map<String, ProviderAvailabilityDto> tierBest,
      Map<String, Integer> tierPriority) {
    for (BrandExecution execution : executions) {
      if (execution.unresolvedArticleNumbers.isEmpty()) {
        continue;
      }
      List<ProviderPlan> sameBrandProviders =
          execution.providerPlans.stream()
              .filter(plan -> plan.priority == tier)
              .filter(plan -> plan.bulkMode != ProviderBulkMode.MIXED_BRAND)
              .toList();
      if (sameBrandProviders.isEmpty()) {
        continue;
      }
      List<InventoryProvider> tierProviders =
          sameBrandProviders.stream().map(plan -> plan.provider).toList();
      int chunkSize = resolveChunkSizeForPlans(sameBrandProviders);
      List<String> unresolvedSnapshot = new ArrayList<>(execution.unresolvedArticleNumbers);
      for (int i = 0; i < unresolvedSnapshot.size(); i += chunkSize) {
        List<String> chunk =
            unresolvedSnapshot.subList(i, Math.min(i + chunkSize, unresolvedSnapshot.size()));
        InventoryQuery query =
            InventoryQuery.builder().brand(execution.brand).articleNumbers(chunk).build();
        List<AvailabilityResult> results = providerRegistry.checkAvailability(tierProviders, query);
        mergeResults(tierBest, results, tierPriority, execution.brand);
      }
    }
  }

  private void processMixedBrandTier(
      Map<String, BrandExecution> executions,
      int tier,
      Map<String, ProviderAvailabilityDto> tierBest,
      Map<String, Integer> tierPriority) {
    Map<String, InventoryProvider> mixedProviders = new LinkedHashMap<>();
    Map<String, Integer> mixedBatchSizes = new HashMap<>();
    Map<String, Set<String>> mixedBrands = new HashMap<>();
    for (BrandExecution execution : executions.values()) {
      for (ProviderPlan plan : execution.providerPlans) {
        if (plan.priority != tier || plan.bulkMode != ProviderBulkMode.MIXED_BRAND) {
          continue;
        }
        String providerName = plan.provider.providerName();
        mixedProviders.putIfAbsent(providerName, plan.provider);
        mixedBatchSizes.merge(
            providerName,
            plan.maxBatchSize > 0 ? plan.maxBatchSize : MAX_ARTICLES_PER_REQUEST,
            Math::min);
        mixedBrands.computeIfAbsent(providerName, ignored -> new LinkedHashSet<>()).add(execution.brand);
      }
    }

    for (Map.Entry<String, InventoryProvider> entry : mixedProviders.entrySet()) {
      String providerName = entry.getKey();
      InventoryProvider provider = entry.getValue();
      Set<String> eligibleBrands = mixedBrands.getOrDefault(providerName, Set.of());
      if (eligibleBrands.isEmpty()) {
        continue;
      }
      List<InventoryQueryItem> unresolvedItems =
          collectUnresolvedItemsForBrands(executions, eligibleBrands);
      if (unresolvedItems.isEmpty()) {
        continue;
      }

      int configuredBatch = mixedBatchSizes.getOrDefault(providerName, MAX_ARTICLES_PER_REQUEST);
      int chunkSize = Math.max(1, Math.min(MAX_ARTICLES_PER_REQUEST, configuredBatch));
      for (int i = 0; i < unresolvedItems.size(); i += chunkSize) {
        List<InventoryQueryItem> chunk =
            unresolvedItems.subList(i, Math.min(i + chunkSize, unresolvedItems.size()));
        List<String> chunkArticles =
            chunk.stream()
                .map(InventoryQueryItem::getArticleNumber)
                .filter(StringUtils::hasText)
                .distinct()
                .toList();
        InventoryQuery query = InventoryQuery.builder().items(chunk).articleNumbers(chunkArticles).build();
        List<AvailabilityResult> results = providerRegistry.checkAvailability(List.of(provider), query);
        mergeResults(tierBest, results, tierPriority, null);
      }
    }
  }

  private List<InventoryQueryItem> collectUnresolvedItemsForBrands(
      Map<String, BrandExecution> executions, Set<String> brands) {
    List<InventoryQueryItem> unresolvedItems = new ArrayList<>();
    for (String brand : brands) {
      BrandExecution execution = executions.get(brand);
      if (execution == null || execution.unresolvedArticleNumbers.isEmpty()) {
        continue;
      }
      for (String articleNumber : execution.unresolvedArticleNumbers) {
        unresolvedItems.add(
            InventoryQueryItem.builder().brand(brand).articleNumber(articleNumber).build());
      }
    }
    return unresolvedItems;
  }

  private void removeResolvedArticles(
      Collection<BrandExecution> executions, Map<String, ProviderAvailabilityDto> bestByArticle) {
    for (BrandExecution execution : executions) {
      execution.unresolvedArticleNumbers.removeIf(
          article -> bestByArticle.containsKey(availabilityKey(execution.brand, article)));
    }
  }

  private void applyBestAvailabilityForExecutions(
      Collection<BrandExecution> executions,
      Map<String, ProviderAvailabilityDto> bestByArticle,
      Partner requestPartner,
      Partner pricingPartner) {
    for (BrandExecution execution : executions) {
      for (RobaLightDto dto : execution.dtos) {
        ProviderAvailabilityDto best =
            selectBestForDto(
                dto, execution.brand, bestByArticle, execution.providerPriority);
        applyBestAvailability(
            dto, best, requestPartner, pricingPartner, execution.providerPriority);
      }
    }
  }

  private void populateWithoutResolvedBrand(
      List<RobaLightDto> dtos,
      Partner requestPartner,
      Partner pricingPartner,
      ProviderRoutingPurpose purpose,
      Integer localMatchCount,
      Integer localAvailableCount) {
    if (dtos == null || dtos.isEmpty()) {
      return;
    }

    List<InventoryQueryItem> allQueryItems = collectUnresolvedQueryItems(dtos);
    if (allQueryItems.isEmpty()) {
      return;
    }

    ProviderRoutingContext context =
        buildContext(requestPartner, dtos, purpose, localMatchCount, localAvailableCount);
    InventoryQuery selectionQuery = InventoryQuery.builder().items(allQueryItems).build();
    List<InventoryProvider> providers = providerRegistry.findInventoryProviders(selectionQuery, context);
    if (providers.isEmpty()) {
      return;
    }
    Map<String, Integer> providerPriority =
        resolveProviderPriorityMap(providers, selectionQuery, context);

    List<String> allArticleNumbers =
        dtos.stream().flatMap(dto -> collectArticleNumbers(dto).stream()).distinct().toList();
    if (allArticleNumbers.isEmpty()) {
      return;
    }

    Map<String, ProviderAvailabilityDto> bestByArticle = new HashMap<>();
    NavigableMap<Integer, List<InventoryProvider>> providersByPriority =
        new TreeMap<>(Comparator.reverseOrder());
    for (InventoryProvider provider : providers) {
      int priority = providerPriorityFor(providerPriority, provider.providerName());
      providersByPriority.computeIfAbsent(priority, ignored -> new ArrayList<>()).add(provider);
    }

    Set<String> unresolvedArticleNumbers = new LinkedHashSet<>(allArticleNumbers);
    for (List<InventoryProvider> tierProviders : providersByPriority.values()) {
      if (unresolvedArticleNumbers.isEmpty()) {
        break;
      }
      int chunkSize = resolveTierChunkSize(tierProviders);
      List<InventoryQueryItem> unresolvedSnapshot =
          allQueryItems.stream()
              .filter(Objects::nonNull)
              .filter(item -> StringUtils.hasText(item.getArticleNumber()))
              .filter(item -> unresolvedArticleNumbers.contains(normalize(item.getArticleNumber())))
              .toList();
      for (int i = 0; i < unresolvedSnapshot.size(); i += chunkSize) {
        List<InventoryQueryItem> chunkItems =
            unresolvedSnapshot.subList(
                i, Math.min(i + chunkSize, unresolvedSnapshot.size()));
        List<String> chunkArticleNumbers =
            chunkItems.stream()
                .map(InventoryQueryItem::getArticleNumber)
                .filter(StringUtils::hasText)
                .map(this::normalize)
                .filter(StringUtils::hasText)
                .distinct()
                .toList();
        InventoryQuery query =
            InventoryQuery.builder()
                .items(chunkItems)
                .articleNumbers(chunkArticleNumbers)
                .build();
        List<AvailabilityResult> results = providerRegistry.checkAvailability(tierProviders, query);
        if (CollectionUtils.isEmpty(results)) {
          continue;
        }
        Map<String, ProviderAvailabilityDto> tierBestByArticle = new HashMap<>();
        mergeResults(tierBestByArticle, results, providerPriority, null);
        for (Map.Entry<String, ProviderAvailabilityDto> entry : tierBestByArticle.entrySet()) {
          bestByArticle.putIfAbsent(entry.getKey(), entry.getValue());
        }
        for (String articleNumber : chunkArticleNumbers) {
          if (hasAnyAvailabilityForArticle(bestByArticle, articleNumber)) {
            unresolvedArticleNumbers.remove(articleNumber);
          }
        }
      }
    }

    for (RobaLightDto dto : dtos) {
      ProviderAvailabilityDto best =
          selectBestForDto(dto, null, bestByArticle, providerPriority);
      applyBestAvailability(dto, best, requestPartner, pricingPartner, providerPriority);
    }
  }

  private Map<String, Integer> resolveProviderPriorityMap(
      List<InventoryProvider> providers,
      InventoryQuery selectionQuery,
      ProviderRoutingContext context) {
    if (providers == null || providers.isEmpty()) {
      return Map.of();
    }
    return providers.stream()
        .collect(
            Collectors.toMap(
                InventoryProvider::providerName,
                provider -> providerRegistry.priorityFor(provider, selectionQuery, context),
                (left, right) -> left));
  }

  private ProviderAvailabilityDto selectBestForDto(
      RobaLightDto dto,
      String brand,
      Map<String, ProviderAvailabilityDto> bestByArticle,
      Map<String, Integer> providerPriority) {
    List<String> candidates = collectArticleNumbers(dto);
    ProviderAvailabilityDto best = null;
    Integer bestPriority = null;
    for (String candidate : candidates) {
      List<ProviderAvailabilityDto> mappedCandidates;
      if (StringUtils.hasText(brand)) {
        String key = availabilityKey(brand, candidate);
        ProviderAvailabilityDto mapped = bestByArticle.get(key);
        mappedCandidates = mapped != null ? List.of(mapped) : List.of();
      } else {
        String normalizedCandidate = normalize(candidate);
        if (!StringUtils.hasText(normalizedCandidate)) {
          continue;
        }
        mappedCandidates =
            bestByArticle.entrySet().stream()
                .filter(entry -> normalizedCandidate.equals(articlePartFromAvailabilityKey(entry.getKey())))
                .map(Map.Entry::getValue)
                .toList();
      }
      for (ProviderAvailabilityDto mapped : mappedCandidates) {
        if (mapped == null || !Boolean.TRUE.equals(mapped.getAvailable())) {
          continue;
        }
        int mappedPriority = providerPriorityFor(providerPriority, mapped.getProvider());
        if (best == null || bestPriority == null || mappedPriority > bestPriority) {
          best = mapped;
          bestPriority = mappedPriority;
          continue;
        }
        if (mappedPriority < bestPriority) {
          continue;
        }
        if (shouldReplaceBestForArticle(best, mapped, providerPriority)) {
          best = mapped;
        }
      }
    }
    return best;
  }

  private List<InventoryQueryItem> collectUnresolvedQueryItems(List<RobaLightDto> dtos) {
    if (dtos == null || dtos.isEmpty()) {
      return List.of();
    }
    Map<String, InventoryQueryItem> dedup = new LinkedHashMap<>();
    for (RobaLightDto dto : dtos) {
      if (dto == null) {
        continue;
      }
      List<String> articles = collectArticleNumbers(dto);
      if (articles.isEmpty()) {
        continue;
      }
      Set<String> brands = new LinkedHashSet<>();
      if (dto.getProizvodjac() != null) {
        if (StringUtils.hasText(dto.getProizvodjac().getProid())) {
          brands.add(dto.getProizvodjac().getProid().trim().toUpperCase(Locale.ROOT));
        }
        if (StringUtils.hasText(dto.getProizvodjac().getNaziv())) {
          brands.add(dto.getProizvodjac().getNaziv().trim().toUpperCase(Locale.ROOT));
        }
      }
      for (String brand : brands) {
        if (!StringUtils.hasText(brand)) {
          continue;
        }
        for (String article : articles) {
          String normalizedArticle = normalize(article);
          if (!StringUtils.hasText(normalizedArticle)) {
            continue;
          }
          String key = brand + ":" + normalizedArticle;
          dedup.putIfAbsent(
              key,
              InventoryQueryItem.builder()
                  .brand(brand)
                  .articleNumber(normalizedArticle)
                  .build());
        }
      }
    }
    return List.copyOf(dedup.values());
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
        if (!Boolean.TRUE.equals(mapped.getAvailable())) {
          continue;
        }
        String key;
        if (StringUtils.hasText(normalizedRequestedBrand)) {
          key = availabilityKey(mapped.getBrand(), mapped.getArticleNumber());
        } else {
          String brandForKey = StringUtils.hasText(mapped.getBrand()) ? mapped.getBrand() : null;
          key = availabilityKey(brandForKey, mapped.getArticleNumber());
        }
        ProviderAvailabilityDto existing = bestByArticle.get(key);
        if (shouldReplaceBestForArticle(existing, mapped, providerPriority)) {
          bestByArticle.put(key, mapped);
        }
      }
    }
  }

  private ProviderAvailabilityDto mapItem(
      String provider, AvailabilityItem item, String defaultBrand) {
    WarehouseAvailability bestWarehouse = pickBestWarehouse(item.getWarehouses());
    WarehouseAvailability warehouseForDisplay =
        item.getDisplayWarehouse() != null ? item.getDisplayWarehouse() : bestWarehouse;
    Integer warehouseQuantity =
        item.getDisplayWarehouseQuantity() != null
            ? item.getDisplayWarehouseQuantity()
            : (warehouseForDisplay != null ? warehouseForDisplay.getQuantity() : null);
    return ProviderAvailabilityDto.builder()
        .brand(defaultBrand)
        .provider(provider)
        .articleNumber(item.getArticleNumber())
        .available(isAvailable(item))
        .totalQuantity(item.getTotalQuantity())
        .warehouse(warehouseForDisplay != null ? warehouseForDisplay.getLocation() : null)
        .warehouseName(resolveWarehouseName(warehouseForDisplay))
        .warehouseQuantity(warehouseQuantity)
        .cityBranchAware(item.getCityBranchAware())
        .cityWarehouseQuantity(item.getCityWarehouseQuantity())
        .fallbackDeliveryBusinessDaysMin(item.getFallbackDeliveryBusinessDaysMin())
        .fallbackDeliveryBusinessDaysMax(item.getFallbackDeliveryBusinessDaysMax())
        .purchasePrice(item.getPurchasePrice())
        .price(item.getSellingPrice() != null ? item.getSellingPrice() : item.getPurchasePrice())
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
        .cityBranchAware(availability.getCityBranchAware())
        .cityWarehouseQuantity(availability.getCityWarehouseQuantity())
        .fallbackDeliveryBusinessDaysMin(availability.getFallbackDeliveryBusinessDaysMin())
        .fallbackDeliveryBusinessDaysMax(availability.getFallbackDeliveryBusinessDaysMax())
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

  private void applyBestAvailability(
      RobaLightDto dto,
      ProviderAvailabilityDto best,
      Partner requestPartner,
      Partner pricingPartner,
      Map<String, Integer> providerPriority) {
    if (dto == null || best == null) {
      return;
    }
    if (dto.getStanje() > 0 && !isTopPriorityProvider(best, providerPriority)) {
      dto.setProviderAvailability(null);
      return;
    }
    ProviderAvailabilityDto priced =
        applyPartnerPricing(best, dto, requestPartner, pricingPartner);
    dto.setProviderAvailability(priced);
    if (dto.getRabat() == null) {
      String brandKey = dto.getProizvodjac() != null ? dto.getProizvodjac().getProid() : null;
      dto.setRabat(priceService.vratiRabatPartneraNaArtikal(brandKey, dto.getGrupa(), pricingPartner));
    }
    if (dto.getRobaid() == null && dto.getCena() == null && dto.getProviderAvailability() != null) {
      dto.setCena(dto.getProviderAvailability().getPrice());
    }
  }

  private int providerPriorityFor(Map<String, Integer> priority, String provider) {
    if (priority == null || !StringUtils.hasText(provider)) {
      return 0;
    }
    return priority.getOrDefault(provider, 0);
  }

  private int comparePrice(ProviderAvailabilityDto candidate, ProviderAvailabilityDto existing) {
    BigDecimal candidatePrice = resolveComparablePrice(candidate);
    BigDecimal existingPrice = resolveComparablePrice(existing);
    return comparePriceValues(candidatePrice, existingPrice);
  }

  private int comparePriceValues(BigDecimal candidate, BigDecimal existing) {
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

    Boolean speedOverride = preferFasterDeliveryWhenPriceClose(candidate, currentBest);
    if (speedOverride != null) {
      return speedOverride;
    }

    int priceDecision = comparePrice(candidate, currentBest);
    if (priceDecision < 0) {
      return true;
    }
    if (priceDecision > 0) {
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

  private Boolean preferFasterDeliveryWhenPriceClose(
      ProviderAvailabilityDto candidate, ProviderAvailabilityDto existing) {
    BigDecimal candidatePrice = resolveComparablePrice(candidate);
    BigDecimal existingPrice = resolveComparablePrice(existing);

    if (candidatePrice == null || existingPrice == null) {
      return null;
    }
    if (candidatePrice.compareTo(BigDecimal.ZERO) <= 0 || existingPrice.compareTo(BigDecimal.ZERO) <= 0) {
      return null;
    }

    BigDecimal base = candidatePrice.min(existingPrice);
    BigDecimal deltaPct =
        candidatePrice
            .subtract(existingPrice)
            .abs()
            .divide(base, 4, RoundingMode.HALF_UP);

    if (deltaPct.compareTo(SPEED_PRICE_DELTA_THRESHOLD) >= 0) {
      return null;
    }

    int speedDecision = compareDeliverySpeed(candidate, existing);
    if (speedDecision < 0) {
      return true;
    }
    if (speedDecision > 0) {
      return false;
    }
    return null;
  }

  private BigDecimal resolveComparablePrice(ProviderAvailabilityDto dto) {
    if (dto == null) {
      return null;
    }
    if (dto.getPurchasePrice() != null && dto.getPurchasePrice().compareTo(BigDecimal.ZERO) > 0) {
      return dto.getPurchasePrice();
    }
    return null;
  }

  private int compareDeliverySpeed(
      ProviderAvailabilityDto candidate, ProviderAvailabilityDto existing) {
    Integer candidateDays = resolveDeliveryDays(candidate);
    Integer existingDays = resolveDeliveryDays(existing);
    if (candidateDays == null || existingDays == null) {
      return 0;
    }
    return Integer.compare(candidateDays, existingDays);
  }

  private Integer resolveDeliveryDays(ProviderAvailabilityDto dto) {
    if (dto == null) {
      return null;
    }

    Integer min = dto.getDeliveryToCustomerBusinessDaysMin();
    Integer max = dto.getDeliveryToCustomerBusinessDaysMax();
    if (min != null && min >= 0 && max != null && max >= 0) {
      return min;
    }

    Integer lead = dto.getLeadTimeBusinessDays();
    if (lead != null && lead >= 0) {
      return lead;
    }
    return null;
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

  private String articlePartFromAvailabilityKey(String key) {
    if (!StringUtils.hasText(key)) {
      return "";
    }
    int separator = key.indexOf(':');
    if (separator < 0) {
      return normalize(key);
    }
    return normalize(key.substring(separator + 1));
  }

  private boolean hasAnyAvailabilityForArticle(
      Map<String, ProviderAvailabilityDto> bestByArticle, String articleNumber) {
    if (bestByArticle == null || bestByArticle.isEmpty()) {
      return false;
    }
    String normalizedArticle = normalize(articleNumber);
    if (!StringUtils.hasText(normalizedArticle)) {
      return false;
    }
    return bestByArticle.keySet().stream()
        .filter(StringUtils::hasText)
        .map(this::articlePartFromAvailabilityKey)
        .anyMatch(normalizedArticle::equals);
  }

  private boolean hasInventoryProvider(String brand, ProviderRoutingContext context) {
    InventoryQuery query = InventoryQuery.builder().brand(brand).build();
    return !providerRegistry.findInventoryProviders(query, context).isEmpty();
  }

  private boolean isTopPriorityProvider(
      ProviderAvailabilityDto availability, Map<String, Integer> providerPriority) {
    if (availability == null || providerPriority == null || providerPriority.isEmpty()) {
      return false;
    }
    int highestPriority =
        providerPriority.values().stream()
            .filter(Objects::nonNull)
            .mapToInt(Integer::intValue)
            .max()
            .orElse(0);
    if (highestPriority <= 0) {
      return false;
    }
    return providerPriorityFor(providerPriority, availability.getProvider()) == highestPriority;
  }

  private int resolveTierChunkSize(List<InventoryProvider> providers) {
    if (providers == null || providers.isEmpty()) {
      return MAX_ARTICLES_PER_REQUEST;
    }
    int chunkSize = MAX_ARTICLES_PER_REQUEST;
    for (InventoryProvider provider : providers) {
      if (provider == null) {
        continue;
      }
      int providerLimit = provider.maxArticlesPerRequest();
      if (providerLimit <= 0) {
        continue;
      }
      chunkSize = Math.min(chunkSize, providerLimit);
    }
    return Math.max(1, chunkSize);
  }

  private int resolveChunkSizeForPlans(List<ProviderPlan> plans) {
    if (plans == null || plans.isEmpty()) {
      return MAX_ARTICLES_PER_REQUEST;
    }
    if (plans.stream().anyMatch(plan -> plan != null && plan.bulkMode == ProviderBulkMode.NONE)) {
      return 1;
    }
    int chunkSize = MAX_ARTICLES_PER_REQUEST;
    for (ProviderPlan plan : plans) {
      if (plan == null) {
        continue;
      }
      int providerLimit = plan.maxBatchSize > 0 ? plan.maxBatchSize : MAX_ARTICLES_PER_REQUEST;
      chunkSize = Math.min(chunkSize, providerLimit);
    }
    return Math.max(1, chunkSize);
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

  private static class ProviderPlan {
    private final InventoryProvider provider;
    private final int priority;
    private final ProviderBulkMode bulkMode;
    private final int maxBatchSize;

    private ProviderPlan(
        InventoryProvider provider, int priority, ProviderBulkMode bulkMode, int maxBatchSize) {
      this.provider = provider;
      this.priority = priority;
      this.bulkMode = bulkMode != null ? bulkMode : ProviderBulkMode.SAME_BRAND;
      this.maxBatchSize = maxBatchSize;
    }
  }

  private static class BrandExecution {
    private final String brand;
    private final List<RobaLightDto> dtos;
    private final Map<String, Integer> providerPriority;
    private final List<ProviderPlan> providerPlans;
    private final Set<String> unresolvedArticleNumbers;

    private BrandExecution(
        String brand,
        List<RobaLightDto> dtos,
        Map<String, Integer> providerPriority,
        List<ProviderPlan> providerPlans,
        Set<String> unresolvedArticleNumbers) {
      this.brand = brand;
      this.dtos = dtos;
      this.providerPriority = providerPriority;
      this.providerPlans = providerPlans;
      this.unresolvedArticleNumbers = unresolvedArticleNumbers;
    }
  }
}
