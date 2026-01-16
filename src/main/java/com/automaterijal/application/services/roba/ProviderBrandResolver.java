package com.automaterijal.application.services.roba;

import com.automaterijal.application.integration.registry.ProviderRegistry;
import com.automaterijal.application.integration.shared.InventoryQuery;
import com.automaterijal.application.integration.shared.ProviderRoutingContext;
import com.automaterijal.application.services.tecdoc.TecDocBrandService;
import java.util.Locale;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProviderBrandResolver {

  @NonNull ProviderRegistry providerRegistry;
  @NonNull TecDocBrandService tecDocBrandService;

  /**
   * Resolves TecDoc brand identifiers/names to internal provider brand keys (proid) only when an
   * inventory provider exists for that brand.
   */
  public Optional<String> resolveInventoryBrand(Long tecDocBrandId, String tecDocBrandName) {
    return resolveInventoryBrand(tecDocBrandId, tecDocBrandName, null);
  }

  public Optional<String> resolveInventoryBrand(
      Long tecDocBrandId, String tecDocBrandName, ProviderRoutingContext context) {
    String byDb =
        tecDocBrandId != null
            ? tecDocBrandService.findProidByBrandId(tecDocBrandId).orElse(null)
            : null;
    if (StringUtils.hasText(byDb)) {
      String normalized = normalizeBrand(byDb);
      if (hasInventoryProvider(normalized, context)) {
        return Optional.of(normalized);
      }
    }

    return providerRegistry
        .resolveBrandKey(tecDocBrandId, tecDocBrandName, context)
        .map(this::normalizeBrand)
        .filter(brand -> hasInventoryProvider(brand, context));
  }

  private boolean hasInventoryProvider(String brand, ProviderRoutingContext context) {
    if (!StringUtils.hasText(brand)) {
      return false;
    }
    InventoryQuery query = InventoryQuery.builder().brand(brand).build();
    return !providerRegistry.findInventoryProviders(query, context).isEmpty();
  }

  private String normalizeBrand(String value) {
    return StringUtils.hasText(value) ? value.trim().toUpperCase(Locale.ROOT) : "";
  }
}
