package com.automaterijal.application.services.roba.showcase;

import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.dto.showcase.ShowcaseResponseDTO;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.services.roba.RobaEnrichmentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShowcaseService {

  private static final String SECTIONS_CACHE = "showcaseSections";
  private static final String VER = "v3";

  private final CacheManager cacheManager;
  private final RobaEnrichmentService robaEnrichmentService;

  /** Read-only: uses prewarmed sections; computes prices/discounts per partner at runtime. */
  public ShowcaseResponseDTO buildShowcase(Partner partner) {
    List<RobaLightDto> maziva = getSection("maziva");
    List<RobaLightDto> alati = getSection("alati");
    List<RobaLightDto> pribor = getSection("pribor");

    robaEnrichmentService.applyPriceOnly(maziva, partner);
    robaEnrichmentService.applyPriceOnly(alati, partner);
    robaEnrichmentService.applyPriceOnly(pribor, partner);

    return new ShowcaseResponseDTO(List.of(), maziva, alati, pribor);
  }

  @SuppressWarnings("unchecked")
  private List<RobaLightDto> getSection(String name) {
    Cache cache = cacheManager.getCache(SECTIONS_CACHE);
    if (cache == null) return List.of();
    List<RobaLightDto> data = cache.get(VER + ":" + name, List.class);
    return data != null ? data : List.of();
  }
}
