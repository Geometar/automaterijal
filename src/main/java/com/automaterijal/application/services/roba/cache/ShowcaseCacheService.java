package com.automaterijal.application.services.roba.cache;

import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.repository.ShowcaseRepositoryJooq;
import com.automaterijal.application.services.ImageService;
import com.automaterijal.application.services.roba.RobaEnrichmentService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class ShowcaseCacheService {

  private final ShowcaseRepositoryJooq repo;
  private final RobaEnrichmentService robaEnrichmentService;
  private final ShowcaseLookupService lookupService;
  private final ImageService imageService;

  private static final String BUCKET_CACHE = "showcaseBucket";
  private static final String SECTIONS_CACHE = "showcaseSections";
  private static final String VER = "v3";
  private static final int FETCH_SIZE = 40;
  private static final int KEEP_SIZE = 5;

  public List<Integer> pickRandomSubgroups(String group, int count) {
    return repo.pickRandomSubgroups(group, count);
  }

  /** Cacheable bucket; requires real image bytes. */
  @Cacheable(
      value = BUCKET_CACHE,
      key = "'" + VER + ":' + #group + ':' + #subGroup",
      unless = "#result == null || #result.isEmpty()")
  public List<RobaLightDto> top5ForSubgroup(String group, Integer subGroup) {
    var items = repo.fetchByGroupAndSubgroup(group, subGroup, FETCH_SIZE);
    Map<String, String> categoryNames = lookupService.groupNameMap();
    fillCategorieName(items, categoryNames);

    // resolve real image from FS (fills bytes); skip items without bytes
    items.forEach(i -> i.setSlika(robaEnrichmentService.resolveImage(i.getRobaid(), i.getSlika())));

    var kept =
        items.stream()
            .filter(this::hasRenderableImage) // skip fallback/no-image entries
            .limit(KEEP_SIZE)
            .collect(Collectors.toList());

    if (kept.isEmpty()) return kept;

    // enrich names
    var proMap = lookupService.manufacturerNameMap();
    var pgMap = lookupService.subGroupNameMap();

    kept.forEach(
        dto -> {
          var name = proMap.get(dto.getProizvodjac().getProid());
          if (name != null) dto.getProizvodjac().setNaziv(name);
          var pgName = pgMap.get(dto.getPodGrupa());
          if (pgName != null) dto.setPodGrupaNaziv(pgName);
        });

    return kept;
  }

  private void fillCategorieName(List<RobaLightDto> data, Map<String, String> categories) {
    data.forEach(
        d -> {
          String name = categories.get(d.getGrupa());
          if (name != null) {
            d.setGrupaNaziv(name);
          }
        });
  }

  /** Store whole section (called by scheduler). */
  @CachePut(value = SECTIONS_CACHE, key = "'" + VER + ":' + #name")
  public List<RobaLightDto> storeSection(String name, List<RobaLightDto> data) {
    return data;
  }

  @CacheEvict(value = BUCKET_CACHE, allEntries = true)
  public void evictAllBuckets() {}

  // --- helpers ---

  private boolean hasRenderableImage(RobaLightDto dto) {
    if (dto == null || dto.getSlika() == null) {
      return false;
    }
    if (StringUtils.hasText(dto.getSlika().getRobaSlika())) {
      return true;
    }
    String url = dto.getSlika().getSlikeUrl();
    if (!StringUtils.hasText(url)) {
      return false;
    }
    return !imageService.isFallbackImage(url);
  }

  /** Preload lookup caches so the first warm-up round does not hit the DB repeatedly. */
  public void preloadLookups() {
    lookupService.groupNameMap();
    lookupService.subGroupNameMap();
    lookupService.manufacturerNameMap();
  }
}
