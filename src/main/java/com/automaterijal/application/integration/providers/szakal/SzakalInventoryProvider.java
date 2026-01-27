package com.automaterijal.application.integration.providers.szakal;

import com.automaterijal.application.integration.providers.szakal.model.SzakalMasterProduct;
import com.automaterijal.application.integration.providers.szakal.model.SzakalPriceListItem;
import com.automaterijal.application.integration.shared.AvailabilityItem;
import com.automaterijal.application.integration.shared.AvailabilityResult;
import com.automaterijal.application.integration.shared.AvailabilityStatus;
import com.automaterijal.application.integration.shared.InventoryProvider;
import com.automaterijal.application.integration.shared.InventoryQuery;
import com.automaterijal.application.integration.shared.ProviderCallStatus;
import com.automaterijal.application.integration.shared.ProviderCapabilities;
import com.automaterijal.application.integration.shared.WarehouseAvailability;
import com.automaterijal.application.services.tecdoc.TecDocBrandService;
import com.automaterijal.application.utils.CatalogNumberUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
@Slf4j
public class SzakalInventoryProvider implements InventoryProvider {
  private static final String PROVIDER_NAME = "szakal";

  private final SzakalProperties properties;
  private final SzakalMasterProductRepository masterRepository;
  private final SzakalPriceListItemRepository priceListRepository;
  private final TecDocBrandService tecDocBrandService;

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
    return StringUtils.hasText(brand);
  }

  @Override
  public AvailabilityResult checkAvailability(InventoryQuery query) {
    if (query == null || CollectionUtils.isEmpty(query.getArticleNumbers())) {
      throw new IllegalArgumentException("InventoryQuery with article numbers is required");
    }

    Long dlnr = resolveTecDocBrandId(query.getBrand());
    if (dlnr == null) {
      return AvailabilityResult.builder()
          .provider(providerName())
          .providerType("inventory")
          .status(ProviderCallStatus.SUCCESS)
          .items(List.of())
          .build();
    }

    List<String> normalizedArticles = normalizeArticles(query.getArticleNumbers());
    if (normalizedArticles.isEmpty()) {
      return AvailabilityResult.builder()
          .provider(providerName())
          .providerType("inventory")
          .status(ProviderCallStatus.SUCCESS)
          .items(List.of())
          .build();
    }

    List<SzakalMasterProduct> master =
        masterRepository.findByTecdocDlnrAndTecdocArtnrNormIn(dlnr, normalizedArticles);
    if (master == null || master.isEmpty()) {
      return AvailabilityResult.builder()
          .provider(providerName())
          .providerType("inventory")
          .status(ProviderCallStatus.SUCCESS)
          .items(List.of())
          .build();
    }

    Map<String, SzakalMasterProduct> byArtnr = new HashMap<>();
    for (SzakalMasterProduct product : master) {
      if (product == null || !StringUtils.hasText(product.getTecdocArtnrNorm())) {
        continue;
      }
      byArtnr.putIfAbsent(product.getTecdocArtnrNorm(), product);
    }

    Set<String> glids =
        master.stream()
            .map(SzakalMasterProduct::getGlid)
            .filter(StringUtils::hasText)
            .collect(Collectors.toSet());
    if (glids.isEmpty()) {
      return AvailabilityResult.builder()
          .provider(providerName())
          .providerType("inventory")
          .status(ProviderCallStatus.SUCCESS)
          .items(List.of())
          .build();
    }

    List<SzakalPriceListItem> priceItems = priceListRepository.findByGlidIn(glids);
    Map<String, SzakalPriceListItem> bestByGlid = selectFastest(priceItems);

    List<AvailabilityItem> items = new ArrayList<>();
    for (String article : normalizedArticles) {
      SzakalMasterProduct product = byArtnr.get(article);
      if (product == null || !StringUtils.hasText(product.getGlid())) {
        continue;
      }
      SzakalPriceListItem best = bestByGlid.get(product.getGlid());
      if (best == null || best.getStock() == null || best.getStock() <= 0) {
        continue;
      }
      items.add(mapItem(query.getBrand(), product, best));
    }

    return AvailabilityResult.builder()
        .provider(providerName())
        .providerType("inventory")
        .status(ProviderCallStatus.SUCCESS)
        .items(items)
        .build();
  }

  private AvailabilityItem mapItem(String brand, SzakalMasterProduct product, SzakalPriceListItem best) {
    Integer stock = best.getStock();
    int listNo = best.getListNo() != null ? best.getListNo() : 0;
    List<WarehouseAvailability> warehouses =
        List.of(
            WarehouseAvailability.builder()
                .location("PL" + listNo)
                .name(properties.getWarehouseName())
                .quantity(stock)
                .build());

    return AvailabilityItem.builder()
        .brand(brand != null ? brand.trim().toUpperCase(Locale.ROOT) : null)
        .articleNumber(product.getTecdocArtnrNorm())
        .status(stock != null && stock > 0 ? AvailabilityStatus.AVAILABLE : AvailabilityStatus.NOT_AVAILABLE)
        .totalQuantity(stock)
        .warehouses(warehouses)
        .purchasePrice(best.getUnitPrice())
        .sellingPrice(null)
        .currency(properties.getCurrency())
        .packagingUnit(best.getQuantum() != null && best.getQuantum() > 0 ? best.getQuantum() : null)
        .leadTimeBusinessDays(resolveLeadTime(listNo))
        .deliveryToCustomerBusinessDaysMin(properties.getDeliveryToCustomerBusinessDaysMin())
        .deliveryToCustomerBusinessDaysMax(properties.getDeliveryToCustomerBusinessDaysMax())
        .nextDispatchCutoff(best.getOrderDeadline())
        .providerProductId(product.getGlid())
        .providerStockToken(best.getToken())
        .providerNoReturnable(best.getNotReturnable())
        .build();
  }

  private Map<String, SzakalPriceListItem> selectFastest(List<SzakalPriceListItem> items) {
    Map<String, SzakalPriceListItem> best = new HashMap<>();
    if (items == null || items.isEmpty()) {
      return best;
    }

    items.stream()
        .filter(Objects::nonNull)
        .filter(item -> item.getStock() != null && item.getStock() > 0)
        .sorted(Comparator.comparingInt(item -> item.getListNo() != null ? item.getListNo() : 9))
        .forEach(
            item -> {
              String glid = item.getGlid();
              if (!StringUtils.hasText(glid)) {
                return;
              }
              if (best.containsKey(glid)) {
                return;
              }
              best.put(glid, item);
            });
    return best;
  }

  private List<String> normalizeArticles(List<String> articleNumbers) {
    if (articleNumbers == null) {
      return List.of();
    }
    List<String> normalized = new ArrayList<>();
    for (String article : articleNumbers) {
      if (!StringUtils.hasText(article)) {
        continue;
      }
      String cleaned = CatalogNumberUtils.cleanPreserveSeparators(article);
      if (StringUtils.hasText(cleaned)) {
        normalized.add(cleaned);
      }
    }
    return normalized;
  }

  private Long resolveTecDocBrandId(String brand) {
    if (!StringUtils.hasText(brand)) {
      return null;
    }
    return tecDocBrandService.findById(brand.trim().toUpperCase(Locale.ROOT))
        .map(b -> b.getBrandId())
        .orElse(null);
  }

  private Integer resolveLeadTime(int listNo) {
    return switch (listNo) {
      case 0 -> properties.getLeadTimeList0();
      case 1 -> properties.getLeadTimeList1();
      case 2 -> properties.getLeadTimeList2();
      case 3 -> properties.getLeadTimeList3();
      default -> properties.getLeadTimeList3();
    };
  }
}
