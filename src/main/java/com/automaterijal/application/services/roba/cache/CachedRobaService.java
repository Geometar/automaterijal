package com.automaterijal.application.services.roba.cache;

import com.automaterijal.application.domain.cache.RobaCache;
import com.automaterijal.application.domain.repository.roba.RobaRepository;
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
public class CachedRobaService {
  @NonNull final RobaRepository robaRepository;

  @Cacheable(value = "robaCache", key = "'allRoba'") // Uses cache if available
  public List<RobaCache> getAllRoba() {
    return robaRepository.findAll().stream()
        .map(
            roba ->
                new RobaCache(
                    roba.getRobaid(), roba.getKatbr(), roba.getKatbrpro(), roba.getNaziv()))
        .toList();
  }

  @CachePut(value = "robaCache", key = "'allRoba'") // Always updates the cache
  public List<RobaCache> refreshRobaCache() {
    return robaRepository.findAll().stream()
        .map(
            roba ->
                new RobaCache(
                    roba.getRobaid(), roba.getKatbr(), roba.getKatbrpro(), roba.getNaziv()))
        .toList();
  }
}
