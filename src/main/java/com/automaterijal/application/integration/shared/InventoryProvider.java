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

  /**
   * Maximum number of article numbers this provider should receive in one availability request.
   * Router can use this to chunk requests without hardcoded provider-name checks.
   */
  default int maxArticlesPerRequest() {
    return 20;
  }

  default ProviderBulkMode bulkMode() {
    return ProviderBulkMode.SAME_BRAND;
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
