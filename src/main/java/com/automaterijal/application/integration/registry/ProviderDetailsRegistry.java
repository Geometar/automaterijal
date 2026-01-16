package com.automaterijal.application.integration.registry;

import com.automaterijal.application.integration.shared.ProviderDetailsProvider;
import com.automaterijal.application.integration.shared.ProviderDetailsQuery;
import com.automaterijal.application.integration.shared.ProviderDetailsResult;
import com.automaterijal.application.integration.shared.ProviderRoutingContext;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProviderDetailsRegistry {

  @NonNull private final List<ProviderDetailsProvider> detailsProviders;
  @NonNull private final ProviderRoutingPolicy routingPolicy;

  public Optional<ProviderDetailsResult> fetchDetails(
      ProviderDetailsQuery query, ProviderRoutingContext context) {
    for (ProviderDetailsProvider provider : orderedProviders(query, context)) {
      if (provider == null || !provider.isEnabled()) {
        continue;
      }
      if (!routingPolicy.allows(provider.providerName(), query != null ? query.getBrand() : null, context)) {
        continue;
      }
      if (!provider.supports(query, context)) {
        continue;
      }
      try {
        Optional<ProviderDetailsResult> result = provider.fetchDetails(query);
        if (result != null && result.isPresent()) {
          return result;
        }
      } catch (RuntimeException ex) {
        log.warn(
            "Provider details {} failed for article {} with message {}",
            provider.providerName(),
            query != null ? query.getArticleNumber() : "n/a",
            ex.getMessage());
      }
    }

    return Optional.empty();
  }

  private List<ProviderDetailsProvider> orderedProviders(
      ProviderDetailsQuery query, ProviderRoutingContext context) {
    if (detailsProviders == null || detailsProviders.isEmpty()) {
      return Collections.emptyList();
    }

    String requestedProvider = query != null ? query.getProvider() : null;
    String brand = query != null ? query.getBrand() : null;

    return detailsProviders.stream()
        .filter(Objects::nonNull)
        .filter(provider -> isRequestedProvider(provider, requestedProvider))
        .sorted(
            Comparator.comparingInt(
                    (ProviderDetailsProvider provider) ->
                        routingPolicy.priorityFor(
                            provider.providerName(), provider.priority(), brand, context))
                .reversed()
                .thenComparing(ProviderDetailsProvider::providerName, String.CASE_INSENSITIVE_ORDER))
        .toList();
  }

  private boolean isRequestedProvider(ProviderDetailsProvider provider, String requestedProvider) {
    if (!StringUtils.hasText(requestedProvider)) {
      return true;
    }
    if (provider == null || !StringUtils.hasText(provider.providerName())) {
      return false;
    }
    return provider
        .providerName()
        .trim()
        .equalsIgnoreCase(requestedProvider.trim());
  }
}
