package com.automaterijal.application.services;

import com.automaterijal.application.domain.constants.OrderItemSource;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.weborder.WebOrderHeader;
import com.automaterijal.application.domain.entity.weborder.WebOrderItem;
import com.automaterijal.application.integration.registry.ProviderOrderRegistry;
import com.automaterijal.application.integration.shared.ProviderCallStatus;
import com.automaterijal.application.integration.shared.ProviderOrderLineResult;
import com.automaterijal.application.integration.shared.ProviderOrderProvider;
import com.automaterijal.application.integration.shared.ProviderOrderRequest;
import com.automaterijal.application.integration.shared.ProviderOrderResult;
import com.automaterijal.application.utils.PartnerPrivilegeUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ProviderOrderService {

  private static final String SZAKAL_PROVIDER_KEY = "szakal";

  @NonNull ProviderOrderRegistry providerOrderRegistry;

  public void placeOrders(WebOrderHeader header, Partner partner) {
    placeOrdersInternal(header, partner, false);
  }

  public void preflightOrders(WebOrderHeader header, Partner partner) {
    placeOrdersInternal(header, partner, true);
  }

  public void clearProcessingMarkers(WebOrderHeader header) {
    if (header == null || header.getItems() == null || header.getItems().isEmpty()) {
      return;
    }
    for (WebOrderItem item : header.getItems()) {
      if (item == null || item.getItemSource() != OrderItemSource.PROVIDER) {
        continue;
      }
      item.setPotvrdjenaKolicina(0.0);
      item.setProviderBackorder(null);
      item.setProviderMessage(null);
    }
    header.setExtOrderId(null);
  }

  private void placeOrdersInternal(WebOrderHeader header, Partner partner, boolean mock) {
    if (header == null || partner == null) {
      return;
    }

    List<WebOrderItem> items = header.getItems() != null ? header.getItems() : List.of();
    Map<String, List<WebOrderItem>> itemsByProvider = groupByProvider(items);
    if (itemsByProvider.isEmpty()) {
      return;
    }

    boolean internalUser = PartnerPrivilegeUtils.isInternal(partner);

    for (Map.Entry<String, List<WebOrderItem>> entry : itemsByProvider.entrySet()) {
      String providerKey = entry.getKey();
      List<WebOrderItem> providerItems = entry.getValue();
      List<WebOrderItem> pendingItems = resolvePendingItems(providerItems);
      if (pendingItems.isEmpty()) {
        log.info(
            "Skipping duplicate provider submit for {} (webOrderId={}, mock={})",
            providerKey,
            header.getId(),
            mock);
        continue;
      }

      ProviderOrderProvider provider = providerOrderRegistry.findByName(providerKey).orElse(null);
      if (provider == null) {
        log.warn("No ordering provider found for {}", providerKey);
        markMissingProvider(pendingItems, internalUser);
        continue;
      }
      if (!provider.isEnabled()) {
        log.info("Ordering disabled for provider {}", providerKey);
        markProviderFailure(pendingItems, "Provider ordering is disabled", internalUser, providerKey);
        continue;
      }

      ProviderOrderRequest request =
          ProviderOrderRequest.builder()
              .header(header)
              .partner(partner)
              .items(pendingItems)
              .mock(mock)
              .build();

      ProviderOrderResult result = provider.placeOrder(request);
      applyResult(header, pendingItems, result, providerKey, internalUser);
    }
  }

  private Map<String, List<WebOrderItem>> groupByProvider(List<WebOrderItem> items) {
    Map<String, List<WebOrderItem>> grouped = new HashMap<>();
    if (items == null || items.isEmpty()) {
      return grouped;
    }
    for (WebOrderItem item : items) {
      if (item == null || item.getItemSource() != OrderItemSource.PROVIDER) {
        continue;
      }
      if (!StringUtils.hasText(item.getProviderKey())) {
        continue;
      }
      String providerKey = item.getProviderKey().trim();
      grouped.computeIfAbsent(providerKey, ignored -> new ArrayList<>()).add(item);
    }
    return grouped;
  }

  private void applyResult(
      WebOrderHeader header,
      List<WebOrderItem> items,
      ProviderOrderResult result,
      String providerKey,
      boolean internalUser) {
    if (header == null || items == null || items.isEmpty()) {
      return;
    }

    if (result == null) {
      markProviderFailure(items, "Provider order response was empty", internalUser, providerKey);
      return;
    }

    if (!result.isMocked()
        && StringUtils.hasText(result.getProviderOrderId())
        && !StringUtils.hasText(header.getExtOrderId())) {
      header.setExtOrderId(result.getProviderOrderId());
    }

    ProviderCallStatus status = result.getStatus();
    boolean failMissingLines =
        status != ProviderCallStatus.SUCCESS
            || (result.getLineResults() != null && !result.getLineResults().isEmpty());

    if (result.getLineResults() == null || result.getLineResults().isEmpty()) {
      if (status == ProviderCallStatus.SUCCESS) {
        if (isNoEligibleSuccess(result)) {
          markProviderFailure(
              items,
              "Eksterni magacin nije potvrdio trazene stavke.",
              internalUser,
              providerKey);
          return;
        }
        markConfirmedWithoutLineResults(items, result.getMessage(), internalUser, providerKey);
        return;
      }
      String message =
          StringUtils.hasText(result.getMessage()) ? result.getMessage() : "Provider order failed";
      markProviderFailure(items, message, internalUser, providerKey);
      return;
    }

    Map<Integer, ProviderOrderLineResult> byItemId = new HashMap<>();
    for (ProviderOrderLineResult lineResult : result.getLineResults()) {
      if (lineResult != null && lineResult.getWebOrderItemId() != null) {
        byItemId.put(lineResult.getWebOrderItemId(), lineResult);
      }
    }

    for (WebOrderItem item : items) {
      if (item == null || item.getId() == null) {
        continue;
      }
      ProviderOrderLineResult lineResult = byItemId.get(item.getId());
      if (lineResult == null) {
        if (failMissingLines) {
          markLineFailure(item, "Nije dobijena potvrda za stavku iz eksternog magacina.", internalUser, providerKey);
        }
        continue;
      }

      Integer confirmed = lineResult.getConfirmedQuantity();
      Boolean backorder = lineResult.getBackorder();
      int requested = toRequestedQuantity(item.getKolicina());

      if (confirmed != null) {
        item.setPotvrdjenaKolicina(confirmed.doubleValue());
      }
      if (backorder == null && confirmed != null) {
        backorder = confirmed < requested;
      }
      if (backorder != null) {
        item.setProviderBackorder(backorder);
      }

      if (confirmed != null && confirmed <= 0 && Boolean.TRUE.equals(backorder)) {
        // Keep item in cart/order, but clearly mark it unavailable for re-check/UX.
        item.setProviderAvailable(false);
        item.setProviderTotalQuantity(0);
        item.setProviderWarehouseQuantity(0);
      }

      String message = normalizeLineMessage(lineResult, providerKey, internalUser);
      if (StringUtils.hasText(message)) {
        item.setProviderMessage(message);
      } else if (confirmed != null && confirmed < requested) {
        handlePartialConfirmation(item, confirmed, providerKey, internalUser);
      }
    }
  }

  private boolean isNoEligibleSuccess(ProviderOrderResult result) {
    if (result == null || result.getStatus() != ProviderCallStatus.SUCCESS) {
      return false;
    }
    String message = result.getMessage();
    if (!StringUtils.hasText(message)) {
      return false;
    }
    String normalized = message.trim().toLowerCase();
    return normalized.contains("no eligible");
  }

  private void markConfirmedWithoutLineResults(
      List<WebOrderItem> items, String message, boolean internalUser, String providerKey) {
    if (items == null || items.isEmpty()) {
      return;
    }
    for (WebOrderItem item : items) {
      if (item == null) {
        continue;
      }
      int requested = toRequestedQuantity(item.getKolicina());
      item.setPotvrdjenaKolicina((double) requested);
      item.setProviderBackorder(false);
      if (!StringUtils.hasText(message)) {
        continue;
      }
      ProviderOrderLineResult syntheticLine =
          ProviderOrderLineResult.builder()
              .webOrderItemId(item.getId())
              .confirmedQuantity(requested)
              .backorder(false)
              .message(message)
              .build();
      String normalizedMessage = normalizeLineMessage(syntheticLine, providerKey, internalUser);
      if (StringUtils.hasText(normalizedMessage)) {
        item.setProviderMessage(normalizedMessage);
      }
    }
  }

  private List<WebOrderItem> resolvePendingItems(List<WebOrderItem> items) {
    if (items == null || items.isEmpty()) {
      return List.of();
    }
    List<WebOrderItem> pending = new ArrayList<>();
    for (WebOrderItem item : items) {
      if (item == null) {
        continue;
      }
      if (!hasProcessingMarker(item)) {
        pending.add(item);
      }
    }
    return pending;
  }

  private boolean hasProcessingMarker(WebOrderItem item) {
    if (item == null) {
      return false;
    }
    if (toRequestedQuantity(item.getPotvrdjenaKolicina()) > 0) {
      return true;
    }
    if (item.getProviderBackorder() != null) {
      return true;
    }
    return StringUtils.hasText(item.getProviderMessage());
  }

  private void handlePartialConfirmation(
      WebOrderItem item, Integer confirmed, String providerKey, boolean internalUser) {
    if (item == null) {
      return;
    }
    int safeConfirmed = confirmed != null ? Math.max(0, confirmed) : 0;
    item.setPotvrdjenaKolicina((double) safeConfirmed);
    item.setProviderBackorder(true);
    if (safeConfirmed <= 0) {
      item.setProviderAvailable(false);
      item.setProviderTotalQuantity(0);
      item.setProviderWarehouseQuantity(0);
    }
    ProviderOrderLineResult fallback =
        ProviderOrderLineResult.builder()
            .webOrderItemId(item.getId())
            .confirmedQuantity(safeConfirmed)
            .backorder(true)
            .message("Trazeni broj komada nije trenutno dostupan u eksternom magacinu.")
            .build();
    item.setProviderMessage(normalizeLineMessage(fallback, providerKey, internalUser));
  }

  private void markMissingProvider(List<WebOrderItem> items, boolean internalUser) {
    markProviderFailure(items, "Eksterni magacin trenutno nije dostupan za porucivanje.", internalUser, null);
  }

  private void markProviderFailure(
      List<WebOrderItem> items, String message, boolean internalUser, String providerKey) {
    if (items == null || items.isEmpty()) {
      return;
    }
    for (WebOrderItem item : items) {
      markLineFailure(item, message, internalUser, providerKey);
    }
  }

  private void markLineFailure(
      WebOrderItem item, String message, boolean internalUser, String providerKey) {
    if (item == null) {
      return;
    }
    item.setPotvrdjenaKolicina(0.0);
    item.setProviderBackorder(true);
    item.setProviderAvailable(false);
    item.setProviderTotalQuantity(0);
    item.setProviderWarehouseQuantity(0);
    ProviderOrderLineResult lineResult =
        ProviderOrderLineResult.builder()
            .webOrderItemId(item.getId())
            .confirmedQuantity(0)
            .backorder(true)
            .message(message)
            .build();
    item.setProviderMessage(normalizeLineMessage(lineResult, providerKey, internalUser));
  }

  private int toRequestedQuantity(Double quantity) {
    if (quantity == null || !Double.isFinite(quantity)) {
      return 0;
    }
    return (int) Math.ceil(Math.max(0d, quantity));
  }

  private String normalizeLineMessage(
      ProviderOrderLineResult lineResult,
      String providerKey,
      boolean internalUser) {
    String rawMessage = lineResult != null ? lineResult.getMessage() : null;
    if (!StringUtils.hasText(rawMessage)) {
      return rawMessage;
    }

    if (internalUser || !SZAKAL_PROVIDER_KEY.equalsIgnoreCase(providerKey)) {
      return rawMessage;
    }

    Integer confirmed = lineResult.getConfirmedQuantity();
    Boolean backorder = lineResult.getBackorder();

    if (confirmed != null && confirmed > 0 && Boolean.TRUE.equals(backorder)) {
      return "Delimicno potvrdjeno iz eksternog magacina.";
    }
    if (confirmed != null && confirmed > 0) {
      return "Porudzbina je potvrdjena iz eksternog magacina.";
    }
    if (Boolean.TRUE.equals(backorder)) {
      return "Artikal trenutno nije dostupan u eksternom magacinu.";
    }

    return "Provera eksternog magacina nije uspela. Pokusajte ponovo.";
  }
}
