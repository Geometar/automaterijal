package com.automaterijal.application.services;

import static org.assertj.core.api.Assertions.assertThat;

import com.automaterijal.application.domain.constants.OrderItemSource;
import com.automaterijal.application.domain.entity.weborder.WebOrderHeader;
import com.automaterijal.application.domain.entity.weborder.WebOrderItem;
import java.util.List;
import org.junit.jupiter.api.Test;

class ProviderCallResolverTest {

  @Test
  void returnsFalseForNullHeader() {
    assertThat(ProviderCallResolver.hasProviderCall(null)).isFalse();
  }

  @Test
  void returnsTrueWhenExternalOrderIdExists() {
    WebOrderHeader header = new WebOrderHeader();
    header.setExtOrderId("febi-123");

    assertThat(ProviderCallResolver.hasProviderCall(header)).isTrue();
  }

  @Test
  void returnsTrueWhenProviderItemHasConfirmedQuantity() {
    WebOrderItem item = providerItem();
    item.setPotvrdjenaKolicina(2.0);
    WebOrderHeader header = new WebOrderHeader();
    header.setItems(List.of(item));

    assertThat(ProviderCallResolver.hasProviderCall(header)).isTrue();
  }

  @Test
  void returnsTrueWhenProviderItemHasBackorderFlag() {
    WebOrderItem item = providerItem();
    item.setProviderBackorder(true);
    WebOrderHeader header = new WebOrderHeader();
    header.setItems(List.of(item));

    assertThat(ProviderCallResolver.hasProviderCall(header)).isTrue();
  }

  @Test
  void returnsTrueWhenProviderItemHasProviderMessage() {
    WebOrderItem item = providerItem();
    item.setProviderMessage("Provider unavailable");
    WebOrderHeader header = new WebOrderHeader();
    header.setItems(List.of(item));

    assertThat(ProviderCallResolver.hasProviderCall(header)).isTrue();
  }

  @Test
  void returnsFalseWhenOnlyStockItemsExist() {
    WebOrderItem stock = new WebOrderItem();
    stock.setItemSource(OrderItemSource.STOCK);
    WebOrderHeader header = new WebOrderHeader();
    header.setItems(List.of(stock));

    assertThat(ProviderCallResolver.hasProviderCall(header)).isFalse();
  }

  @Test
  void returnsFalseWhenProviderItemExistsButNoCallSignals() {
    WebOrderItem item = providerItem();
    WebOrderHeader header = new WebOrderHeader();
    header.setItems(List.of(item));

    assertThat(ProviderCallResolver.hasProviderCall(header)).isFalse();
  }

  private static WebOrderItem providerItem() {
    WebOrderItem item = new WebOrderItem();
    item.setItemSource(OrderItemSource.PROVIDER);
    item.setProviderKey("febi-stock");
    return item;
  }
}
