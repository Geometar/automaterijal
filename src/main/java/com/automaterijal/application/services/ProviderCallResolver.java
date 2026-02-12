package com.automaterijal.application.services;

import com.automaterijal.application.domain.constants.OrderItemSource;
import com.automaterijal.application.domain.entity.weborder.WebOrderHeader;
import com.automaterijal.application.domain.entity.weborder.WebOrderItem;
import java.util.List;
import java.util.Optional;
import org.springframework.util.StringUtils;

public final class ProviderCallResolver {

  private ProviderCallResolver() {}

  public static boolean hasProviderCall(WebOrderHeader header) {
    if (header == null) {
      return false;
    }

    if (StringUtils.hasText(header.getExtOrderId())) {
      return true;
    }

    List<WebOrderItem> items = Optional.ofNullable(header.getItems()).orElse(List.of());
    for (WebOrderItem item : items) {
      if (item == null || item.getItemSource() != OrderItemSource.PROVIDER) {
        continue;
      }
      if (toRequestedQuantity(item.getPotvrdjenaKolicina()) > 0) {
        return true;
      }
      if (item.getProviderBackorder() != null) {
        return true;
      }
      if (StringUtils.hasText(item.getProviderMessage())) {
        return true;
      }
    }

    return false;
  }

  private static int toRequestedQuantity(Double quantity) {
    if (quantity == null || !Double.isFinite(quantity)) {
      return 0;
    }
    return (int) Math.ceil(Math.max(0d, quantity));
  }
}
