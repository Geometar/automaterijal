package com.automaterijal.application.services;

import com.automaterijal.application.domain.constants.OrderItemSource;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.entity.weborder.WebOrderHeader;
import com.automaterijal.application.domain.entity.weborder.WebOrderItem;
import com.automaterijal.application.integration.registry.ProviderOrderRegistry;
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
    if (header == null || partner == null) {
      return;
    }

    List<WebOrderItem> items = header.getItems() != null ? header.getItems() : List.of();
    Map<String, List<WebOrderItem>> itemsByProvider = groupByProvider(items);
    if (itemsByProvider.isEmpty()) {
      return;
    }

    boolean mock = false;
    boolean internalUser = PartnerPrivilegeUtils.isInternal(partner);

    for (Map.Entry<String, List<WebOrderItem>> entry : itemsByProvider.entrySet()) {
      String providerKey = entry.getKey();
      ProviderOrderProvider provider = providerOrderRegistry.findByName(providerKey).orElse(null);
      if (provider == null) {
        log.warn("No ordering provider found for {}", providerKey);
        continue;
      }
      if (!provider.isEnabled()) {
        log.info("Ordering disabled for provider {}", providerKey);
        continue;
      }

      ProviderOrderRequest request =
          ProviderOrderRequest.builder()
              .header(header)
              .partner(partner)
              .items(entry.getValue())
              .mock(mock)
              .build();

      ProviderOrderResult result = provider.placeOrder(request);
      applyResult(header, entry.getValue(), result, providerKey, internalUser);
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
    if (header == null || result == null) {
      return;
    }

    if (StringUtils.hasText(result.getProviderOrderId()) && !StringUtils.hasText(header.getExtOrderId())) {
      header.setExtOrderId(result.getProviderOrderId());
    }

    if (items == null || items.isEmpty() || result.getLineResults() == null) {
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
        continue;
      }

      Integer confirmed = lineResult.getConfirmedQuantity();
      Boolean backorder = lineResult.getBackorder();

      if (confirmed != null) {
        item.setPotvrdjenaKolicina(confirmed.doubleValue());
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

      if (lineResult.getMessage() != null) {
        item.setProviderMessage(normalizeLineMessage(lineResult, providerKey, internalUser));
      }
    }
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
