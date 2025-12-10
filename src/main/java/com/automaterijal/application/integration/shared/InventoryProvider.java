package com.automaterijal.application.integration.shared;

public interface InventoryProvider {

  String providerName();

  ProviderCapabilities capabilities();

  boolean supportsBrand(String brand);

  AvailabilityResult checkAvailability(InventoryQuery query);
}
