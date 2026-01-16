package com.automaterijal.application.integration.providers.febi.order;

import com.automaterijal.application.domain.constants.OrderItemSource;
import com.automaterijal.application.domain.entity.weborder.WebOrderHeader;
import com.automaterijal.application.domain.entity.weborder.WebOrderItem;
import com.automaterijal.application.integration.providers.febi.FebiAuthClient;
import com.automaterijal.application.integration.providers.febi.order.FebiOrderProperties.OrderMode;
import com.automaterijal.application.integration.providers.febi.order.model.FebiOrderBulkResponse;
import com.automaterijal.application.integration.providers.febi.order.model.FebiOrderRequest;
import com.automaterijal.application.integration.providers.febi.order.model.FebiOrderRequest.CustomerOrder;
import com.automaterijal.application.integration.providers.febi.order.model.FebiOrderRequest.DeliveryParty;
import com.automaterijal.application.integration.providers.febi.order.model.FebiOrderRequest.Header;
import com.automaterijal.application.integration.providers.febi.order.model.FebiOrderRequest.Position;
import com.automaterijal.application.integration.providers.febi.order.model.FebiOrderResponse;
import com.automaterijal.application.integration.providers.febi.price.FebiPriceService;
import com.automaterijal.application.integration.shared.ProviderCallStatus;
import com.automaterijal.application.integration.shared.ProviderOrderLineResult;
import com.automaterijal.application.integration.shared.ProviderOrderProvider;
import com.automaterijal.application.integration.shared.ProviderOrderRequest;
import com.automaterijal.application.integration.shared.ProviderOrderResult;
import com.automaterijal.application.integration.shared.exception.ProviderAuthenticationException;
import com.automaterijal.application.integration.shared.exception.ProviderRateLimitException;
import com.automaterijal.application.integration.shared.exception.ProviderUnavailableException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class FebiOrderProvider implements ProviderOrderProvider {

  private static final String PROVIDER_NAME = "febi-stock";
  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_DATE;
  private static final int BULK_ORDER_THRESHOLD = 100;

  @NonNull FebiAuthClient authClient;
  @NonNull FebiOrderClient orderClient;
  @NonNull FebiOrderProperties orderProperties;
  @NonNull FebiPriceService priceService;
  @NonNull Environment environment;

  @Override
  public String providerName() {
    return PROVIDER_NAME;
  }

  @Override
  public boolean isEnabled() {
    return orderProperties.getMode() != OrderMode.DISABLED;
  }

  @Override
  public ProviderOrderResult placeOrder(ProviderOrderRequest request) {
    if (request == null || request.getItems() == null || request.getItems().isEmpty()) {
      return ProviderOrderResult.builder()
          .status(ProviderCallStatus.ERROR)
          .message("No items to order")
          .build();
    }

    List<WebOrderItem> eligibleItems = filterEligibleItems(request.getItems());
    if (eligibleItems.isEmpty()) {
      return ProviderOrderResult.builder()
          .status(ProviderCallStatus.SUCCESS)
          .message("No eligible Febi items to order")
          .build();
    }

    if (!StringUtils.hasText(orderProperties.getDeliveryParty())
        || !StringUtils.hasText(orderProperties.getShippingCondition())) {
      return ProviderOrderResult.builder()
          .status(ProviderCallStatus.ERROR)
          .message("Missing Febi order configuration (delivery party or shipping condition)")
          .build();
    }

    Map<String, WebOrderItem> itemsByPosition = new HashMap<>();
    FebiOrderRequest orderRequest = buildOrderRequest(request.getHeader(), eligibleItems, itemsByPosition);
    if (orderRequest == null) {
      return ProviderOrderResult.builder()
          .status(ProviderCallStatus.ERROR)
          .message("Failed to build Febi order request")
          .build();
    }

    boolean liveMode = isLiveMode(request.isMock());
    try {
      String token = authClient.getAccessToken();
      if (liveMode) {
        boolean bulkOrder = isBulkOrder(itemsByPosition);
        FebiOrderRequest createRequest = withType(orderRequest, "create");
        if (bulkOrder) {
          FebiOrderBulkResponse response = orderClient.createBulkOrder(createRequest, token);
          return buildBulkResult(response);
        }
        FebiOrderResponse response = orderClient.createOrder(createRequest, token);
        return buildLiveResult(response, itemsByPosition);
      }

      FebiOrderRequest simulateRequest = withType(orderRequest, "simulate");
      FebiOrderResponse response = orderClient.simulateOrder(simulateRequest, token);
      ProviderOrderResult result = buildLiveResult(response, itemsByPosition);
      if (result != null) {
        result.setMocked(true);
      }
      return result;
    } catch (ProviderRateLimitException ex) {
      return ProviderOrderResult.builder()
          .status(ProviderCallStatus.RATE_LIMITED)
          .message(ex.getMessage())
          .build();
    } catch (ProviderAuthenticationException ex) {
      return ProviderOrderResult.builder()
          .status(ProviderCallStatus.AUTH_FAILED)
          .message(ex.getMessage())
          .build();
    } catch (ProviderUnavailableException ex) {
      return ProviderOrderResult.builder()
          .status(ProviderCallStatus.UNAVAILABLE)
          .message(ex.getMessage())
          .build();
    } catch (RuntimeException ex) {
      log.warn("Unexpected Febi order error: {}", ex.getMessage());
      return ProviderOrderResult.builder()
          .status(ProviderCallStatus.ERROR)
          .message(ex.getMessage())
          .build();
    }
  }

  private List<WebOrderItem> filterEligibleItems(List<WebOrderItem> items) {
    List<WebOrderItem> eligible = new ArrayList<>();
    for (WebOrderItem item : items) {
      if (item == null || item.getItemSource() != OrderItemSource.PROVIDER) {
        continue;
      }
      if (!StringUtils.hasText(item.getProviderKey())
          || !PROVIDER_NAME.equalsIgnoreCase(item.getProviderKey().trim())) {
        continue;
      }
      if (!hasRequestedQuantity(item)) {
        continue;
      }
      if (orderProperties.isRequireAvailability()) {
        if (!Boolean.TRUE.equals(item.getProviderAvailable())) {
          continue;
        }
        Integer totalQuantity = item.getProviderTotalQuantity();
        if (totalQuantity != null && totalQuantity <= 0) {
          continue;
        }
      }
      eligible.add(item);
    }
    return eligible;
  }

  private boolean hasRequestedQuantity(WebOrderItem item) {
    if (item == null || item.getKolicina() == null) {
      return false;
    }
    return Math.round(item.getKolicina()) > 0;
  }

  private boolean isLiveMode(boolean requestMock) {
    if (requestMock) {
      return false;
    }
    return orderProperties.getMode() == OrderMode.LIVE;
  }

  private FebiOrderRequest buildOrderRequest(
      WebOrderHeader header,
      List<WebOrderItem> items,
      Map<String, WebOrderItem> itemsByPosition) {
    if (items == null || items.isEmpty()) {
      return null;
    }

    List<Position> positions = new ArrayList<>();
    int index = 1;
    for (WebOrderItem item : items) {
      String articleNumber = resolveArticleNumber(item);
      Integer baseQuantity = toRequestedQuantity(item.getKolicina());
      if (!StringUtils.hasText(articleNumber) || baseQuantity == null || baseQuantity <= 0) {
        continue;
      }
      Integer quantity = applyPackagingUnit(baseQuantity, resolvePackagingUnit(articleNumber));
      if (quantity == null || quantity <= 0) {
        continue;
      }
      String position = String.valueOf(index++);
      positions.add(
          Position.builder()
              .articleNumber(articleNumber)
              .externalOrderPosition(position)
              .requestedQuantity(quantity)
              .build());
      itemsByPosition.put(position, item);
    }

    if (positions.isEmpty()) {
      return null;
    }

    String customerOrderNumber = buildCustomerOrderNumber(header);
    String requestedDate = buildRequestedDate();

    String deliveryPartyCode = resolveDeliveryParty(items);

    Header headerRequest =
        Header.builder()
            .customerOrderNumber(customerOrderNumber)
            .deliveryParty(DeliveryParty.builder().partnerCode(deliveryPartyCode).build())
            .requestedDateOfDelivery(requestedDate)
            .shippingCondition(orderProperties.getShippingCondition())
            .type("create")
            .build();

    CustomerOrder customerOrder =
        CustomerOrder.builder()
            .header(headerRequest)
            .positions(positions)
            .build();

    return FebiOrderRequest.builder().customerOrder(customerOrder).build();
  }

  private FebiOrderRequest withType(FebiOrderRequest request, String type) {
    if (request == null || request.getCustomerOrder() == null || request.getCustomerOrder().getHeader() == null) {
      return request;
    }
    request.getCustomerOrder().getHeader().setType(type);
    return request;
  }

  private ProviderOrderResult buildLiveResult(
      FebiOrderResponse response,
      Map<String, WebOrderItem> itemsByPosition) {
    if (response == null || response.getCustomerOrder() == null) {
      return ProviderOrderResult.builder()
          .status(ProviderCallStatus.ERROR)
          .message("Febi order response was empty")
          .build();
    }

    String providerOrderId =
        response.getCustomerOrder().getHeader() != null
            ? response.getCustomerOrder().getHeader().getErpCustomerOrderNumber()
            : null;

    List<ProviderOrderLineResult> lineResults = new ArrayList<>();
    if (response.getCustomerOrder().getPositions() != null) {
      for (FebiOrderResponse.Position position : response.getCustomerOrder().getPositions()) {
        if (position == null || !StringUtils.hasText(position.getExternalOrderPosition())) {
          continue;
        }
        WebOrderItem item = itemsByPosition.get(position.getExternalOrderPosition());
        if (item == null) {
          continue;
        }
        lineResults.add(
            ProviderOrderLineResult.builder()
                .webOrderItemId(item.getId())
                .confirmedQuantity(position.getConfirmedQuantity())
                .backorder(position.getBackorder())
                .message(firstMessage(position.getMessages()))
                .build());
      }
    }

    return ProviderOrderResult.builder()
        .status(ProviderCallStatus.SUCCESS)
        .providerOrderId(providerOrderId)
        .lineResults(lineResults)
        .build();
  }

  private ProviderOrderResult buildBulkResult(FebiOrderBulkResponse response) {
    if (response == null || !StringUtils.hasText(response.getStatus())) {
      return ProviderOrderResult.builder()
          .status(ProviderCallStatus.ERROR)
          .message("Febi bulk order response was empty")
          .build();
    }

    String status = response.getStatus();
    String message =
        StringUtils.hasText(response.getTimestamp())
            ? status + " at " + response.getTimestamp()
            : status;

    ProviderCallStatus callStatus =
        "accepted".equalsIgnoreCase(status) ? ProviderCallStatus.SUCCESS : ProviderCallStatus.ERROR;

    return ProviderOrderResult.builder()
        .status(callStatus)
        .message(message)
        .build();
  }

  private String resolveArticleNumber(WebOrderItem item) {
    if (item == null) {
      return null;
    }
    if (StringUtils.hasText(item.getProviderArticleNumber())) {
      return item.getProviderArticleNumber();
    }
    return item.getCatalogNumber();
  }

  private Integer toRequestedQuantity(Double quantity) {
    if (quantity == null) {
      return null;
    }
    return Math.toIntExact(Math.round(quantity));
  }

  private int resolvePackagingUnit(String articleNumber) {
    return priceService.findPackagingUnit(articleNumber).orElse(1);
  }

  private Integer applyPackagingUnit(Integer quantity, int packagingUnit) {
    if (quantity == null) {
      return null;
    }
    int multiplier = packagingUnit > 0 ? packagingUnit : 1;
    long result = (long) quantity * (long) multiplier;
    if (result > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }
    return (int) result;
  }

  private String buildCustomerOrderNumber(WebOrderHeader header) {
    String prefix =
        StringUtils.hasText(orderProperties.getCustomerOrderPrefix())
            ? orderProperties.getCustomerOrderPrefix()
            : "";
    Integer orderId = header != null ? header.getOrderId() : null;
    if (orderId != null) {
      return prefix + orderId;
    }
    Integer headerId = header != null ? header.getId() : null;
    return prefix + (headerId != null ? headerId : "UNKNOWN");
  }

  private String buildRequestedDate() {
    return LocalDate.now().format(DATE_FORMAT);
  }

  private boolean isBulkOrder(Map<String, WebOrderItem> itemsByPosition) {
    return itemsByPosition != null && itemsByPosition.size() > BULK_ORDER_THRESHOLD;
  }

  private String resolveDeliveryParty(List<WebOrderItem> items) {
    String candidate = null;
    if (items != null) {
      for (WebOrderItem item : items) {
        if (item == null) {
          continue;
        }
        String code = item.getProviderDeliveryParty();
        if (StringUtils.hasText(code)) {
          candidate = code.trim();
          break;
        }
      }
    }

    if (isAllowedDeliveryParty(candidate)) {
      return candidate.trim();
    }

    return orderProperties.getDeliveryParty();
  }

  private boolean isAllowedDeliveryParty(String code) {
    if (!StringUtils.hasText(code)) {
      return false;
    }
    String trimmed = code.trim();
    if (trimmed.equals(orderProperties.getDeliveryParty())) {
      return true;
    }
    String pickup = orderProperties.getPickupDeliveryParty();
    return StringUtils.hasText(pickup) && trimmed.equals(pickup.trim());
  }

  private String firstMessage(List<FebiOrderResponse.Message> messages) {
    if (messages == null || messages.isEmpty()) {
      return null;
    }
    for (FebiOrderResponse.Message message : messages) {
      if (message != null && StringUtils.hasText(message.getText())) {
        return message.getText();
      }
    }
    return null;
  }
}
