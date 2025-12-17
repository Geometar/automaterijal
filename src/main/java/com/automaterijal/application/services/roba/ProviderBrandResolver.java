package com.automaterijal.application.services.roba;

import com.automaterijal.application.integration.registry.ProviderRegistry;
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
    String byDb =
        tecDocBrandId != null
            ? tecDocBrandService.findProidByBrandId(tecDocBrandId).orElse(null)
            : null;
    if (StringUtils.hasText(byDb)) {
      String normalized = normalizeBrand(byDb);
      if (hasInventoryProvider(normalized)) {
        return Optional.of(normalized);
      }
    }

    return providerRegistry
        .resolveBrandKey(tecDocBrandId, tecDocBrandName)
        .map(this::normalizeBrand)
        .filter(this::hasInventoryProvider);
  }

  private boolean hasInventoryProvider(String brand) {
    return StringUtils.hasText(brand) && !providerRegistry.findInventoryProviders(brand).isEmpty();
  }

  private String normalizeBrand(String value) {
    return StringUtils.hasText(value) ? value.trim().toUpperCase(Locale.ROOT) : "";
  }
}
