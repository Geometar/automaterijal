package com.automaterijal.application.services.roba.cache;

import com.automaterijal.application.domain.cache.RobaCache;
import java.util.List;
import java.util.Set;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaCacheService {
  @NonNull final RobaCachedService robaCachedService;

  public List<RobaCache> getAllRobaFilteredByKatBr(String searchTerm) {
    return robaCachedService.currentIndex().searchByCatalogTerm(searchTerm);
  }

  public List<RobaCache> getAllRobaByNazivLike(String searchTerm) {
    return robaCachedService.currentIndex().searchByName(searchTerm);
  }

  public List<RobaCache> getAllRobaByKatBrIn(Set<String> katBr) {
    return robaCachedService.currentIndex().searchByPrimaryCatalog(katBr);
  }

  public List<RobaCache> getAllRobaFilteredByKatBr(Set<String> katBr) {
    return robaCachedService.currentIndex().searchByCatalogTerms(katBr);
  }
}
