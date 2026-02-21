package com.automaterijal.application.integration.registry;

import com.automaterijal.application.integration.shared.AvailabilityResult;
import com.automaterijal.application.integration.shared.InventoryProvider;
import com.automaterijal.application.integration.shared.InventoryQuery;
import com.automaterijal.application.integration.shared.ProviderBulkMode;
import com.automaterijal.application.integration.shared.ProviderCallStatus;
import com.automaterijal.application.integration.shared.exception.ProviderAuthenticationException;
import com.automaterijal.application.integration.shared.exception.ProviderRateLimitException;
import com.automaterijal.application.integration.shared.exception.ProviderUnavailableException;
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

@Component
@RequiredArgsConstructor
@Slf4j
public class ProviderRegistry {

  @NonNull private final List<InventoryProvider> inventoryProviders;
  @NonNull private final ProviderRoutingPolicy routingPolicy;

  public List<InventoryProvider> findInventoryProviders(String brand) {
    InventoryQuery query = InventoryQuery.builder().brand(brand).build();
    return findInventoryProviders(query, null);
  }

  public List<AvailabilityResult> checkAvailability(String brand, InventoryQuery query) {
    InventoryQuery effectiveQuery =
        query != null ? query : InventoryQuery.builder().brand(brand).build();
    if (effectiveQuery.getBrand() == null && brand != null) {
      effectiveQuery.setBrand(brand);
    }
    return checkAvailability(effectiveQuery, null);
  }

  public List<InventoryProvider> findInventoryProviders(
      InventoryQuery query, ProviderRoutingContext context) {
    return orderedProviders(query, context).stream()
        .filter(provider -> provider.capabilities() != null && provider.capabilities().isEnabled())
        .filter(provider -> provider.capabilities().isInventory())
        .filter(provider -> safeAllows(provider, query, context))
        .filter(provider -> safeSupports(provider, query, context))
        .toList();
  }

  public List<AvailabilityResult> checkAvailability(
      InventoryQuery query, ProviderRoutingContext context) {
    return findInventoryProviders(query, context).stream()
        .map(provider -> invokeSafe(provider, query))
        .toList();
  }

  public List<AvailabilityResult> checkAvailability(
      List<InventoryProvider> providers, InventoryQuery query) {
    if (providers == null || providers.isEmpty()) {
      return Collections.emptyList();
    }
    return providers.stream()
        .filter(Objects::nonNull)
        .map(provider -> invokeSafe(provider, query))
        .toList();
  }

  public Optional<String> resolveBrandKey(Long tecDocBrandId, String tecDocBrandName) {
    return resolveBrandKey(tecDocBrandId, tecDocBrandName, null);
  }

  public Optional<String> resolveBrandKey(
      Long tecDocBrandId, String tecDocBrandName, ProviderRoutingContext context) {
    if (inventoryProviders == null || inventoryProviders.isEmpty()) {
      return Optional.empty();
    }

    for (InventoryProvider provider : orderedProviders(null, context)) {
      if (provider == null
          || provider.capabilities() == null
          || !provider.capabilities().isEnabled()
          || !provider.capabilities().isInventory()) {
        continue;
      }

      Optional<String> resolved;
      try {
        resolved = provider.resolveBrandKey(tecDocBrandId, tecDocBrandName);
      } catch (RuntimeException ex) {
        log.warn(
            "Provider {} failed while resolving brand key for tecDocBrandId={} tecDocBrandName='{}': {}",
            provider.providerName(),
            tecDocBrandId,
            tecDocBrandName,
            ex.getMessage());
        continue;
      }
      if (resolved != null && resolved.isPresent()) {
        if (context == null) {
          return resolved;
        }
        InventoryQuery query = InventoryQuery.builder().brand(resolved.get()).build();
        if (safeAllows(provider, query, context) && safeSupports(provider, query, context)) {
          return resolved;
        }
      }
    }

    return Optional.empty();
  }

  private boolean safeAllows(
      InventoryProvider provider, InventoryQuery query, ProviderRoutingContext context) {
    try {
      return routingPolicy.allows(provider, query, context);
    } catch (RuntimeException ex) {
      log.warn(
          "Routing policy check failed for provider {} and brand {}: {}",
          provider != null ? provider.providerName() : "n/a",
          query != null ? query.getBrand() : "n/a",
          ex.getMessage());
      return false;
    }
  }

  private boolean safeSupports(
      InventoryProvider provider, InventoryQuery query, ProviderRoutingContext context) {
    try {
      return provider != null && provider.supports(query, context);
    } catch (RuntimeException ex) {
      log.warn(
          "Provider {} failed during supports() for brand {}: {}",
          provider != null ? provider.providerName() : "n/a",
          query != null ? query.getBrand() : "n/a",
          ex.getMessage());
      return false;
    }
  }

  public int priorityFor(
      InventoryProvider provider, InventoryQuery query, ProviderRoutingContext context) {
    return routingPolicy.priorityFor(provider, query, context);
  }

  public ProviderBulkMode bulkModeFor(
      InventoryProvider provider, InventoryQuery query, ProviderRoutingContext context) {
    return routingPolicy.bulkModeFor(provider, query, context);
  }

  public int maxBatchSizeFor(
      InventoryProvider provider, InventoryQuery query, ProviderRoutingContext context) {
    return routingPolicy.maxBatchSizeFor(provider, query, context);
  }

  private List<InventoryProvider> orderedProviders(
      InventoryQuery query, ProviderRoutingContext context) {
    if (inventoryProviders == null || inventoryProviders.isEmpty()) {
      return Collections.emptyList();
    }

    return inventoryProviders.stream()
        .filter(Objects::nonNull)
        .sorted(
            Comparator.comparingInt(
                    (InventoryProvider provider) -> routingPolicy.priorityFor(provider, query, context))
                .reversed()
                .thenComparing(InventoryProvider::providerName, String.CASE_INSENSITIVE_ORDER))
        .toList();
  }

  private AvailabilityResult invokeSafe(InventoryProvider provider, InventoryQuery query) {
    try {
      AvailabilityResult result = provider.checkAvailability(query);
      if (result == null) {
        return failure(provider, query, ProviderCallStatus.ERROR, "Provider returned null result");
      }
      if (result.getStatus() == null) {
        result.setStatus(ProviderCallStatus.SUCCESS);
      }
      return result;
    } catch (ProviderRateLimitException ex) {
      log.warn("Inventory provider {} rate limited: {}", provider.providerName(), ex.getMessage());
      return failure(provider, query, ProviderCallStatus.RATE_LIMITED, ex.getMessage());
    } catch (ProviderAuthenticationException ex) {
      log.warn("Inventory provider {} auth failed: {}", provider.providerName(), ex.getMessage());
      return failure(provider, query, ProviderCallStatus.AUTH_FAILED, ex.getMessage());
    } catch (ProviderUnavailableException ex) {
      log.warn("Inventory provider {} unavailable: {}", provider.providerName(), ex.getMessage());
      return failure(provider, query, ProviderCallStatus.UNAVAILABLE, ex.getMessage());
    } catch (RuntimeException ex) {
      log.warn(
          "Inventory provider {} failed for brand {} with message {}",
          provider.providerName(),
          query != null ? query.getBrand() : "n/a",
          ex.getMessage());
      return failure(provider, query, ProviderCallStatus.ERROR, ex.getMessage());
    }
  }

  private AvailabilityResult failure(
      InventoryProvider provider, InventoryQuery query, ProviderCallStatus status, String message) {
    return AvailabilityResult.builder()
        .provider(provider.providerName())
        .providerType("inventory")
        .destinationCountry(query != null ? query.getDestinationCountry() : null)
        .status(status)
        .errorMessage(message)
        .items(Collections.emptyList())
        .build();
  }
}
