package com.automaterijal.application.integration.providers.szakal.order;

import com.automaterijal.application.domain.constants.OrderItemSource;
import com.automaterijal.application.domain.entity.weborder.WebOrderHeader;
import com.automaterijal.application.domain.entity.weborder.WebOrderItem;
import com.automaterijal.application.integration.providers.szakal.SzakalApiClient;
import com.automaterijal.application.integration.providers.szakal.SzakalApiClient.OrderItem;
import com.automaterijal.application.integration.providers.szakal.SzakalApiClient.OrderResponse;
import com.automaterijal.application.integration.providers.szakal.SzakalApiClient.TokenOrderRequest;
import com.automaterijal.application.integration.providers.szakal.SzakalProperties;
import com.automaterijal.application.integration.providers.szakal.SzakalProperties.OrderMode;
import com.automaterijal.application.integration.providers.szakal.SzakalStockCheckService;
import com.automaterijal.application.integration.providers.szakal.SzakalStockCheckService.StockCheckItem;
import com.automaterijal.application.integration.providers.szakal.SzakalStockCheckService.StockCheckResult;
import com.automaterijal.application.integration.shared.ProviderCallStatus;
import com.automaterijal.application.integration.shared.ProviderOrderLineResult;
import com.automaterijal.application.integration.shared.ProviderOrderProvider;
import com.automaterijal.application.integration.shared.ProviderOrderRequest;
import com.automaterijal.application.integration.shared.ProviderOrderResult;
import com.automaterijal.application.integration.shared.exception.ProviderAuthenticationException;
import com.automaterijal.application.integration.shared.exception.ProviderRateLimitException;
import com.automaterijal.application.integration.shared.exception.ProviderUnavailableException;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class SzakalOrderProvider implements ProviderOrderProvider {

  private static final String PROVIDER_NAME = "szakal";
  private static final int MAX_REQUEST_QTY = 50;

  @NonNull SzakalApiClient apiClient;
  @NonNull SzakalProperties properties;
  @NonNull SzakalStockCheckService stockCheckService;

  @Override
  public String providerName() {
    return PROVIDER_NAME;
  }

  @Override
  public boolean isEnabled() {
    return properties.isEnabled() && resolveOrderMode() != OrderMode.DISABLED;
  }

  @Override
  public ProviderOrderResult placeOrder(ProviderOrderRequest request) {
    if (!isEnabled()) {
      return ProviderOrderResult.builder()
          .status(ProviderCallStatus.ERROR)
          .message("Szakal ordering is disabled")
          .build();
    }
    if (request == null || request.getItems() == null || request.getItems().isEmpty()) {
      return ProviderOrderResult.builder()
          .status(ProviderCallStatus.ERROR)
          .message("No items to order")
          .build();
    }
    boolean liveMode = isLiveMode(request.isMock());

    List<WebOrderItem> eligibleItems = filterEligibleItems(request.getItems());
    if (eligibleItems.isEmpty()) {
      return ProviderOrderResult.builder()
          .status(ProviderCallStatus.SUCCESS)
          .message("No eligible Szakal items to order")
          .lineResults(List.of())
          .build();
    }

    List<ProviderOrderLineResult> lineResults = new ArrayList<>();
    String providerOrderId = null;

    int successCount = 0;
    int failedCount = 0;
    boolean rateLimited = false;
    boolean authFailed = false;
    boolean unavailable = false;

    for (WebOrderItem item : eligibleItems) {
      Integer webOrderItemId = item.getId();
      String token = trimToNull(item.getProviderStockToken());
      String glid = trimToNull(item.getProviderProductId());
      Integer requestedQuantity = toRequestedQuantity(item.getKolicina());
      Integer packagingUnit = resolvePackagingUnit(item);

      if (requestedQuantity == null || requestedQuantity <= 0) {
        lineResults.add(failLine(webOrderItemId, "Invalid requested quantity"));
        failedCount++;
        continue;
      }

      if (requestedQuantity > MAX_REQUEST_QTY) {
        lineResults.add(
            failLine(
                webOrderItemId,
                "Requested quantity exceeds Szakal API limit (max " + MAX_REQUEST_QTY + ")"));
        failedCount++;
        continue;
      }

      if (packagingUnit > 1 && requestedQuantity % packagingUnit != 0) {
        lineResults.add(
            failLine(
                webOrderItemId,
                "Requested quantity must be multiple of packaging unit " + packagingUnit));
        failedCount++;
        continue;
      }

      StockCheckResult stockCheck = refreshStock(item, token, glid, requestedQuantity, request);
      if (stockCheck != null) {
        syncSnapshot(item, stockCheck);
      }

      String latestToken =
          stockCheck != null && StringUtils.hasText(stockCheck.stockToken())
              ? stockCheck.stockToken().trim()
              : token;
      if (!StringUtils.hasText(latestToken)) {
        lineResults.add(failLine(webOrderItemId, "Missing Szakal stock token"));
        failedCount++;
        continue;
      }

      if (!liveMode) {
        lineResults.add(
            ProviderOrderLineResult.builder()
                .webOrderItemId(webOrderItemId)
                .confirmedQuantity(requestedQuantity)
                .backorder(false)
                .message("Mock Szakal order")
                .build());
        if (!StringUtils.hasText(providerOrderId)) {
          providerOrderId = buildMockOrderId(request.getHeader());
        }
        successCount++;
        continue;
      }

      try {
        TokenOrderRequest tokenOrderRequest =
            new TokenOrderRequest(latestToken, requestedQuantity, buildOrderNote(request, item));
        OrderResponse response = apiClient.orderByToken(tokenOrderRequest);
        OrderItem order = firstOrder(response);

        if (order == null) {
          lineResults.add(failLine(webOrderItemId, "Szakal returned empty order response"));
          failedCount++;
          continue;
        }

        int confirmedQuantity =
            order.quantity() != null && order.quantity() > 0 ? order.quantity() : requestedQuantity;
        boolean backorder = confirmedQuantity < requestedQuantity;

        String lineOrderId = trimToNull(order.orderId());
        if (!StringUtils.hasText(providerOrderId) && StringUtils.hasText(lineOrderId)) {
          providerOrderId = lineOrderId;
        }

        lineResults.add(
            ProviderOrderLineResult.builder()
                .webOrderItemId(webOrderItemId)
                .confirmedQuantity(confirmedQuantity)
                .backorder(backorder)
                .message(buildLineSuccessMessage(lineOrderId, confirmedQuantity, requestedQuantity))
                .build());
        successCount++;
      } catch (ProviderRateLimitException ex) {
        rateLimited = true;
        lineResults.add(failLine(webOrderItemId, ex.getMessage()));
        failedCount++;
      } catch (ProviderAuthenticationException ex) {
        authFailed = true;
        lineResults.add(failLine(webOrderItemId, ex.getMessage()));
        failedCount++;
      } catch (ProviderUnavailableException ex) {
        unavailable = true;
        lineResults.add(failLine(webOrderItemId, ex.getMessage()));
        failedCount++;
      } catch (RuntimeException ex) {
        log.warn("Unexpected Szakal order error for item {}: {}", webOrderItemId, ex.getMessage());
        lineResults.add(failLine(webOrderItemId, ex.getMessage()));
        failedCount++;
      }
    }

    ProviderCallStatus finalStatus =
        resolveStatus(successCount, failedCount, rateLimited, authFailed, unavailable);

    String summaryMessage =
        successCount == eligibleItems.size()
            ? "Szakal order success: " + successCount + " item(s)"
            : "Szakal order partial: success="
                + successCount
                + ", failed="
                + failedCount;

    return ProviderOrderResult.builder()
        .status(finalStatus)
        .mocked(!liveMode)
        .providerOrderId(providerOrderId)
        .message(summaryMessage)
        .lineResults(lineResults)
        .build();
  }

  private boolean isLiveMode(boolean requestMock) {
    if (requestMock) {
      return false;
    }
    return resolveOrderMode() == OrderMode.LIVE;
  }

  private OrderMode resolveOrderMode() {
    if (properties.getOrder() == null || properties.getOrder().getMode() == null) {
      return OrderMode.DISABLED;
    }
    return properties.getOrder().getMode();
  }

  private List<WebOrderItem> filterEligibleItems(List<WebOrderItem> items) {
    List<WebOrderItem> eligible = new ArrayList<>();
    if (items == null || items.isEmpty()) {
      return eligible;
    }

    for (WebOrderItem item : items) {
      if (item == null || item.getItemSource() != OrderItemSource.PROVIDER) {
        continue;
      }
      String providerKey = trimToNull(item.getProviderKey());
      if (!PROVIDER_NAME.equalsIgnoreCase(providerKey)) {
        continue;
      }
      if (!hasRequestedQuantity(item)) {
        continue;
      }
      eligible.add(item);
    }

    return eligible;
  }

  private boolean hasRequestedQuantity(WebOrderItem item) {
    Integer requested = toRequestedQuantity(item != null ? item.getKolicina() : null);
    return requested != null && requested > 0;
  }

  private Integer toRequestedQuantity(Double quantity) {
    if (quantity == null) {
      return null;
    }
    long rounded = Math.round(quantity);
    if (rounded > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }
    if (rounded < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }
    return (int) rounded;
  }

  private Integer resolvePackagingUnit(WebOrderItem item) {
    if (item == null || item.getProviderPackagingUnit() == null || item.getProviderPackagingUnit() <= 0) {
      return 1;
    }
    return item.getProviderPackagingUnit();
  }

  private StockCheckResult refreshStock(
      WebOrderItem item,
      String token,
      String glid,
      Integer requestedQuantity,
      ProviderOrderRequest request) {
    if (!StringUtils.hasText(token) && !StringUtils.hasText(glid)) {
      return null;
    }
    try {
      return stockCheckService
          .check(
              List.of(new StockCheckItem(token, glid, requestedQuantity, item.getBrand(), null)),
              request != null ? request.getPartner() : null)
          .stream()
          .findFirst()
          .orElse(null);
    } catch (RuntimeException ex) {
      log.warn("Szakal pre-order stock refresh failed for item {}: {}", item.getId(), ex.getMessage());
      return null;
    }
  }

  private void syncSnapshot(WebOrderItem item, StockCheckResult stockCheck) {
    if (item == null || stockCheck == null) {
      return;
    }

    if (StringUtils.hasText(stockCheck.stockToken())) {
      item.setProviderStockToken(stockCheck.stockToken().trim());
    }
    if (StringUtils.hasText(stockCheck.glid())) {
      item.setProviderProductId(stockCheck.glid().trim());
    }
    item.setProviderAvailable(stockCheck.available());
    item.setProviderTotalQuantity(stockCheck.availableQuantity());
    item.setProviderWarehouseQuantity(stockCheck.availableQuantity());
    if (stockCheck.orderQuantum() != null && stockCheck.orderQuantum() > 0) {
      item.setProviderPackagingUnit(stockCheck.orderQuantum());
    }
    item.setProviderNoReturnable(stockCheck.noReturnable());
    if (stockCheck.purchasePrice() != null) {
      item.setProviderPurchasePrice(stockCheck.purchasePrice());
    }
    if (stockCheck.customerPrice() != null) {
      item.setProviderPrice(stockCheck.customerPrice());
    }
    if (StringUtils.hasText(stockCheck.currency())) {
      item.setProviderCurrency(stockCheck.currency());
    }
  }

  private ProviderOrderLineResult failLine(Integer webOrderItemId, String message) {
    return ProviderOrderLineResult.builder()
        .webOrderItemId(webOrderItemId)
        .confirmedQuantity(0)
        .backorder(true)
        .message(StringUtils.hasText(message) ? message : "Szakal order failed")
        .build();
  }

  private String buildOrderNote(ProviderOrderRequest request, WebOrderItem item) {
    List<String> parts = new ArrayList<>();

    WebOrderHeader header = request != null ? request.getHeader() : null;
    if (header != null && header.getOrderId() != null) {
      parts.add("ord. nr: " + header.getOrderId());
    }
    if (item != null && item.getId() != null) {
      parts.add("line: " + item.getId());
    }

    String baseNote =
        header != null && StringUtils.hasText(header.getNapomena()) ? header.getNapomena().trim() : null;
    if (StringUtils.hasText(baseNote)) {
      if (baseNote.length() > 120) {
        parts.add(baseNote.substring(0, 120));
      } else {
        parts.add(baseNote);
      }
    }

    if (parts.isEmpty()) {
      return null;
    }
    return String.join("; ", parts);
  }

  private OrderItem firstOrder(OrderResponse response) {
    if (response == null || response.orders() == null || response.orders().isEmpty()) {
      return null;
    }
    for (OrderItem order : response.orders()) {
      if (order != null) {
        return order;
      }
    }
    return null;
  }

  private String buildLineSuccessMessage(
      String lineOrderId, int confirmedQuantity, int requestedQuantity) {
    if (confirmedQuantity < requestedQuantity) {
      if (StringUtils.hasText(lineOrderId)) {
        return "Partial confirmation "
            + confirmedQuantity
            + "/"
            + requestedQuantity
            + " (order "
            + lineOrderId
            + ")";
      }
      return "Partial confirmation " + confirmedQuantity + "/" + requestedQuantity;
    }
    if (StringUtils.hasText(lineOrderId)) {
      return "Ordered (order " + lineOrderId + ")";
    }
    return "Ordered";
  }

  private ProviderCallStatus resolveStatus(
      int successCount,
      int failedCount,
      boolean rateLimited,
      boolean authFailed,
      boolean unavailable) {
    if (successCount > 0) {
      return ProviderCallStatus.SUCCESS;
    }
    if (rateLimited) {
      return ProviderCallStatus.RATE_LIMITED;
    }
    if (authFailed) {
      return ProviderCallStatus.AUTH_FAILED;
    }
    if (unavailable) {
      return ProviderCallStatus.UNAVAILABLE;
    }
    if (failedCount > 0) {
      return ProviderCallStatus.ERROR;
    }
    return ProviderCallStatus.SUCCESS;
  }

  private String buildMockOrderId(WebOrderHeader header) {
    if (header != null && header.getOrderId() != null) {
      return "mock-szakal-" + header.getOrderId();
    }
    if (header != null && header.getId() != null) {
      return "mock-szakal-" + header.getId();
    }
    return "mock-szakal";
  }

  private String trimToNull(String value) {
    if (!StringUtils.hasText(value)) {
      return null;
    }
    return value.trim();
  }
}
