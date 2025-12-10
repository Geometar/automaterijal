package com.automaterijal.application.integration.registry;

import com.automaterijal.application.integration.shared.AvailabilityResult;
import com.automaterijal.application.integration.shared.InventoryProvider;
import com.automaterijal.application.integration.shared.InventoryQuery;
import com.automaterijal.application.integration.shared.ProviderCallStatus;
import com.automaterijal.application.integration.shared.exception.ProviderAuthenticationException;
import com.automaterijal.application.integration.shared.exception.ProviderRateLimitException;
import com.automaterijal.application.integration.shared.exception.ProviderUnavailableException;
import java.util.Collections;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProviderRegistry {

  @NonNull private final List<InventoryProvider> inventoryProviders;

  public List<InventoryProvider> findInventoryProviders(String brand) {
    if (inventoryProviders == null || inventoryProviders.isEmpty()) {
      return Collections.emptyList();
    }

    return inventoryProviders.stream()
        .filter(provider -> provider.capabilities().isEnabled())
        .filter(provider -> provider.capabilities().isInventory())
        .filter(provider -> provider.supportsBrand(brand))
        .toList();
  }

  public List<AvailabilityResult> checkAvailability(String brand, InventoryQuery query) {
    return findInventoryProviders(brand).stream()
        .map(provider -> invokeSafe(provider, query))
        .toList();
  }

  private AvailabilityResult invokeSafe(InventoryProvider provider, InventoryQuery query) {
    try {
      AvailabilityResult result = provider.checkAvailability(query);
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
