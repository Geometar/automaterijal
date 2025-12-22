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
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ProviderOrderService {

  @NonNull ProviderOrderRegistry providerOrderRegistry;
  @NonNull Environment environment;

  public void placeOrders(WebOrderHeader header, Partner partner) {
    if (header == null || partner == null) {
      return;
    }

    List<WebOrderItem> items = header.getItems() != null ? header.getItems() : List.of();
    Map<String, List<WebOrderItem>> itemsByProvider = groupByProvider(items);
    if (itemsByProvider.isEmpty()) {
      return;
    }

    boolean mock = !isProdProfile();
    for (Map.Entry<String, List<WebOrderItem>> entry : itemsByProvider.entrySet()) {
      String providerKey = entry.getKey();
      ProviderOrderProvider provider =
          providerOrderRegistry.findByName(providerKey).orElse(null);
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
      applyResult(header, entry.getValue(), result);
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
      ProviderOrderResult result) {
    if (header == null || result == null) {
      return;
    }

    if (StringUtils.hasText(result.getProviderOrderId())
        && !StringUtils.hasText(header.getExtOrderId())) {
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
      if (lineResult.getConfirmedQuantity() != null) {
        item.setPotvrdjenaKolicina(lineResult.getConfirmedQuantity().doubleValue());
      }
      if (lineResult.getBackorder() != null) {
        item.setProviderBackorder(lineResult.getBackorder());
      }
      if (lineResult.getMessage() != null) {
        item.setProviderMessage(lineResult.getMessage());
      }
    }
  }

  private boolean isProdProfile() {
    String[] profiles = environment.getActiveProfiles();
    if (profiles == null) {
      return false;
    }
    for (String profile : profiles) {
      if ("prod".equalsIgnoreCase(profile)) {
        return true;
      }
    }
    return false;
  }
}
