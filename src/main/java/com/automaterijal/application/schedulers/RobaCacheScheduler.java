package com.automaterijal.application.schedulers;

import com.automaterijal.application.services.roba.cache.CachedRobaService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RobaCacheScheduler {

  private final CachedRobaService cachedRobaService;

  @Scheduled(fixedRate = 600000) // Every 10 minutes
  public void refreshCache() {
    cachedRobaService.refreshRobaCache();
  }
}
