package com.automaterijal.application.integration.registry;

import com.automaterijal.application.integration.shared.ProviderOrderProvider;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class ProviderOrderRegistry {

  @NonNull private final List<ProviderOrderProvider> orderProviders;

  public Optional<ProviderOrderProvider> findByName(String providerName) {
    if (!StringUtils.hasText(providerName) || orderProviders == null || orderProviders.isEmpty()) {
      return Optional.empty();
    }
    String normalized = providerName.trim().toUpperCase(Locale.ROOT);
    return orderProviders.stream()
        .filter(Objects::nonNull)
        .filter(provider -> StringUtils.hasText(provider.providerName()))
        .filter(
            provider ->
                provider.providerName().trim().toUpperCase(Locale.ROOT).equals(normalized))
        .findFirst();
  }
}
