package com.automaterijal.application.integration.providers.szakal;

import com.automaterijal.application.domain.dto.ProviderAvailabilityDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.integration.providers.szakal.SzakalApiClient.StockInfoItem;
import com.automaterijal.application.integration.providers.szakal.SzakalApiClient.StockInfoRequest;
import com.automaterijal.application.integration.providers.szakal.SzakalApiClient.StockInfoResponse;
import com.automaterijal.application.integration.providers.szakal.SzakalApiClient.StockInfoTokenRequest;
import com.automaterijal.application.services.roba.ProviderPricingService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class SzakalStockCheckService {
  private static final String SEARCH_ORDER = "fastest_first";
  private static final int MAX_REQUEST_QTY = 50;

  private final SzakalApiClient apiClient;
  private final SzakalProperties properties;
  private final ProviderPricingService providerPricingService;
  private final ConcurrentHashMap<String, CacheEntry> cache = new ConcurrentHashMap<>();

  public List<StockCheckResult> check(List<StockCheckItem> items, Partner partner) {
    if (CollectionUtils.isEmpty(items)) {
      return List.of();
    }
    List<StockCheckResult> results = new ArrayList<>();
    for (StockCheckItem item : items) {
      if (item == null) {
        continue;
      }
      String key = cacheKey(item, partner);
      CacheEntry cached = key != null ? cache.get(key) : null;
      long now = System.currentTimeMillis();
      if (cached != null && cached.expiresAt() > now) {
        results.add(cached.result());
        continue;
      }

      StockCheckResult result = fetch(item, partner);
      if (key != null) {
        cache.put(key, new CacheEntry(result, now + resolveCacheTtlMs()));
      }
      results.add(result);
    }
    return results;
  }

  public List<StockCheckResult> check(List<StockCheckItem> items) {
    return check(items, null);
  }

  private StockCheckResult fetch(StockCheckItem item, Partner partner) {
    String token = trimToNull(item.token());
    String glid = trimToNull(item.glid());
    int quantity = normalizeQuantity(item.quantity());

    if (StringUtils.hasText(token)) {
      StockInfoTokenRequest request =
          new StockInfoTokenRequest(token, quantity, SEARCH_ORDER, false, false);
      StockInfoResponse response = apiClient.stockByToken(request);
      return toResult(item, response, partner);
    }

    if (StringUtils.hasText(glid)) {
      StockInfoRequest request =
          new StockInfoRequest(glid, quantity, SEARCH_ORDER, false, false);
      StockInfoResponse response = apiClient.stockByGlid(request);
      return toResult(item, response, partner);
    }

    return new StockCheckResult(
        item.token(),
        item.glid(),
        quantity,
        false,
        0,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        properties.getCurrency());
  }

  private StockCheckResult toResult(
      StockCheckItem item, StockInfoResponse response, Partner partner) {
    int requested = normalizeQuantity(item.quantity());
    List<StockInfoItem> stocks = response != null ? response.stocks() : List.of();
    if (stocks == null || stocks.isEmpty()) {
      return new StockCheckResult(
          item.token(),
          item.glid(),
          requested,
          false,
          0,
          null,
          null,
          null,
          null,
          null,
          null,
          null,
          null,
          properties.getCurrency());
    }

    List<StockInfoItem> available =
        stocks.stream()
            .filter(Objects::nonNull)
            .filter(stock -> stock.quantity() != null && stock.quantity() > 0)
            .toList();

    int maxQty =
        available.stream()
            .map(StockInfoItem::quantity)
            .filter(Objects::nonNull)
            .max(Comparator.naturalOrder())
            .orElse(0);

    StockInfoItem best =
        available.stream()
            .filter(stock -> stock.quantity() != null && stock.quantity() >= requested)
            .findFirst()
            .orElse(available.isEmpty() ? stocks.get(0) : available.get(0));

    Integer orderQuantum = best != null ? best.orderQuantum() : null;
    Integer moq = best != null ? best.moq() : null;
    boolean availableFlag = maxQty >= requested && maxQty > 0;
    if (moq != null && moq > 0 && maxQty < moq) {
      availableFlag = false;
    }
    Integer chosenQuantum =
        orderQuantum != null && orderQuantum > 0 ? orderQuantum : moq;
    Boolean noReturnable = best != null ? best.noReturnable() : null;
    String stockToken = best != null ? best.stockOrderToken() : null;
    BigDecimal unitPrice = best != null ? best.unitPrice() : null;
    BigDecimal coreCharge = best != null ? best.coreCharge() : null;
    String expectedDelivery = best != null ? best.expectedDelivery() : null;
    BigDecimal customerPrice =
        unitPrice != null ? computeCustomerPrice(unitPrice, item, partner) : null;

    return new StockCheckResult(
        item.token(),
        item.glid(),
        requested,
        availableFlag,
        maxQty,
        chosenQuantum,
        moq,
        noReturnable,
        stockToken,
        unitPrice,
        customerPrice,
        expectedDelivery,
        coreCharge,
        properties.getCurrency());
  }

  private BigDecimal computeCustomerPrice(BigDecimal unitPrice, StockCheckItem item, Partner partner) {
    if (unitPrice == null) {
      return null;
    }
    ProviderAvailabilityDto availability =
        ProviderAvailabilityDto.builder()
            .provider("szakal")
            .purchasePrice(unitPrice)
            .currency(properties.getCurrency())
            .build();
    return providerPricingService.calculateCustomerPrice(
        availability, item.group(), item.brand(), partner);
  }

  private int normalizeQuantity(Integer quantity) {
    int q = quantity != null ? quantity : 1;
    if (q < 1) {
      q = 1;
    }
    if (q > MAX_REQUEST_QTY) {
      q = MAX_REQUEST_QTY;
    }
    return q;
  }

  private long resolveCacheTtlMs() {
    SzakalProperties.Api api = properties.getApi();
    Long ttl = api != null ? api.getCacheTtlMs() : null;
    return ttl != null && ttl > 0 ? ttl : 120_000L;
  }

  private String cacheKey(StockCheckItem item, Partner partner) {
    if (item == null) {
      return null;
    }
    String token = trimToNull(item.token());
    String glid = trimToNull(item.glid());
    int qty = normalizeQuantity(item.quantity());
    String partnerKey = partner != null ? String.valueOf(partner.getPpid()) : "anon";
    if (StringUtils.hasText(token)) {
      return "token:" + token + ":" + qty + ":" + partnerKey;
    }
    if (StringUtils.hasText(glid)) {
      return "glid:" + glid + ":" + qty + ":" + partnerKey;
    }
    return null;
  }

  private String trimToNull(String value) {
    if (!StringUtils.hasText(value)) {
      return null;
    }
    return value.trim();
  }

  private record CacheEntry(StockCheckResult result, long expiresAt) {}

  public record StockCheckItem(
      String token, String glid, Integer quantity, String brand, String group) {}

  public record StockCheckResult(
      String token,
      String glid,
      Integer requestedQuantity,
      boolean available,
      Integer availableQuantity,
      Integer orderQuantum,
      Integer moq,
      Boolean noReturnable,
      String stockToken,
      BigDecimal purchasePrice,
      BigDecimal customerPrice,
      String expectedDelivery,
      BigDecimal coreCharge,
      String currency) {}
}
