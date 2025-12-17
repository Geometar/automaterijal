package com.automaterijal.application.integration.shared;

import java.util.Optional;

public interface InventoryProvider {

  String providerName();

  ProviderCapabilities capabilities();

  boolean supportsBrand(String brand);

  AvailabilityResult checkAvailability(InventoryQuery query);

  /**
   * Optional resolver for mapping TecDoc brand identifiers/names to the internal brand key used by
   * the provider routing (e.g. "FEBI", "BLUE"). Default is empty to keep providers simple.
   */
  default Optional<String> resolveBrandKey(Long tecDocBrandId, String tecDocBrandName) {
    return Optional.empty();
  }
}
