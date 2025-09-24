package com.automaterijal.application.services.roba.cache;

import com.automaterijal.application.domain.cache.RobaCache;
import com.automaterijal.application.domain.repository.roba.RobaJooqRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Transactional
public class RobaCachedService {
  @NonNull final RobaJooqRepository robaJooqRepository;

  final AtomicReference<RobaCacheIndex> cacheRef = new AtomicReference<>();

  @PostConstruct
  public void preload() {
    refreshRobaCache();
  }

  public List<RobaCache> getAllRoba() {
    return currentIndex().all();
  }

  public RobaCacheIndex currentIndex() {
    RobaCacheIndex index = cacheRef.get();
    if (index != null) {
      return index;
    }
    synchronized (cacheRef) {
      index = cacheRef.get();
      if (index == null) {
        index = RobaCacheIndex.build(robaJooqRepository.fetchCache());
        cacheRef.set(index);
      }
      return index;
    }
  }

  public List<RobaCache> refreshRobaCache() {
    List<RobaCache> data = robaJooqRepository.fetchCache();
    cacheRef.set(RobaCacheIndex.build(data));
    return cacheRef.get().all();
  }
}
