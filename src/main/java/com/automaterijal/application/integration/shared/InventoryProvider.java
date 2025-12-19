package com.automaterijal.application.integration.shared;

import java.util.Optional;

public interface InventoryProvider {

  String providerName();

  /**
   * Higher value means higher priority in routing when multiple providers match.
   */
  default int priority() {
    return 0;
  }

  ProviderCapabilities capabilities();

  boolean supportsBrand(String brand);

  default boolean supports(InventoryQuery query, ProviderRoutingContext context) {
    return supportsBrand(query != null ? query.getBrand() : null);
  }

  AvailabilityResult checkAvailability(InventoryQuery query);

  /**
   * Optional resolver for mapping TecDoc brand identifiers/names to the internal brand key used by
   * the provider routing (e.g. "FEBI", "BLUE"). Default is empty to keep providers simple.
   */
  default Optional<String> resolveBrandKey(Long tecDocBrandId, String tecDocBrandName) {
    return Optional.empty();
  }
}
