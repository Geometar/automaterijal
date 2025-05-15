package com.automaterijal.application.services.roba.cache;

import com.automaterijal.application.domain.cache.RobaCache;
import com.automaterijal.application.domain.repository.roba.RobaJooqRepository;
import java.util.List;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Transactional
public class RobaCachedService {
  @NonNull final RobaJooqRepository robaJooqRepository;

  @Cacheable(value = "robaCache", key = "'allRoba'") // Uses cache if available
  public List<RobaCache> getAllRoba() {
    return robaJooqRepository.fetchCache();
  }

  @CachePut(value = "robaCache", key = "'allRoba'") // Always updates the cache
  public List<RobaCache> refreshRobaCache() {
    return robaJooqRepository.fetchCache();
  }
}
