package com.automaterijal.application.services.roba.cache;

import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.repository.ProizvodjacRepository;
import com.automaterijal.application.domain.repository.ShowcaseRepositoryJooq;
import com.automaterijal.application.services.roba.grupe.ArticleSubGroupService;
import com.automaterijal.application.services.roba.util.RobaHelper;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShowcaseCacheService {

  private final ShowcaseRepositoryJooq repo;
  private final ProizvodjacRepository proizvodjacRepository;
  private final ArticleSubGroupService articleSubGroupService;
  private final RobaHelper robaHelper; // we will call resolveImage here

  private static final String BUCKET_CACHE = "showcaseBucket";
  private static final String SECTIONS_CACHE = "showcaseSections";
  private static final String VER = "v2";
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

    // resolve real image from FS (fills bytes); skip items without bytes
    items.forEach(i -> i.setSlika(robaHelper.resolveImage(i.getRobaid(), i.getSlika())));

    var kept =
        items.stream()
            .filter(ShowcaseCacheService::hasImageBytes) // keep only with bytes
            .limit(KEEP_SIZE)
            .collect(Collectors.toList());

    if (kept.isEmpty()) return kept;

    // enrich names
    var proMap = loadProizvodjacNameMap();
    var pgMap = loadPodgrupaNameMap();

    kept.forEach(
        dto -> {
          var name = proMap.get(dto.getProizvodjac().getProid());
          if (name != null) dto.getProizvodjac().setNaziv(name);
          var pgName = pgMap.get(dto.getPodGrupa());
          if (pgName != null) dto.setPodGrupaNaziv(pgName);
        });

    return kept;
  }

  /** Store whole section (called by scheduler). */
  @CachePut(value = SECTIONS_CACHE, key = "'" + VER + ":' + #name")
  public List<RobaLightDto> storeSection(String name, List<RobaLightDto> data) {
    return data;
  }

  @CacheEvict(value = BUCKET_CACHE, allEntries = true)
  public void evictAllBuckets() {}

  // --- helpers ---

  private static boolean hasImageBytes(RobaLightDto dto) {
    return dto != null
        && dto.getSlika() != null
        && dto.getSlika().getSlikeByte() != null
        && dto.getSlika().getSlikeByte().length > 0;
  }

  private Map<String, String> loadProizvodjacNameMap() {
    return proizvodjacRepository.findAll().stream()
        .filter(p -> p.getProid() != null && p.getNaziv() != null)
        .collect(Collectors.toMap(Proizvodjac::getProid, Proizvodjac::getNaziv, (a, b) -> a));
  }

  private Map<Integer, String> loadPodgrupaNameMap() {
    return articleSubGroupService.findAll().stream()
        .filter(p -> p.getPodGrupaId() != null && p.getNaziv() != null)
        .collect(Collectors.toMap(PodGrupa::getPodGrupaId, PodGrupa::getNaziv, (a, b) -> a));
  }
}
