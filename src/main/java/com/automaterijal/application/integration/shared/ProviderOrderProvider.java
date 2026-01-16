package com.automaterijal.application.integration.shared;

public interface ProviderOrderProvider {

  String providerName();

  default boolean isEnabled() {
    return true;
  }

  ProviderOrderResult placeOrder(ProviderOrderRequest request);
}
