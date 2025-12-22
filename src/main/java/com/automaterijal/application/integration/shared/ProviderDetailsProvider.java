package com.automaterijal.application.integration.shared;

import java.util.Optional;

public interface ProviderDetailsProvider {

  String providerName();

  default int priority() {
    return 0;
  }

  default boolean isEnabled() {
    return true;
  }

  default boolean supports(ProviderDetailsQuery query, ProviderRoutingContext context) {
    return true;
  }

  Optional<ProviderDetailsResult> fetchDetails(ProviderDetailsQuery query);
}
