package com.automaterijal.application.schedulers;

import com.automaterijal.application.services.roba.cache.RobaCachedService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RobaCacheScheduler {

  private final RobaCachedService robaCachedService;

  @Scheduled(fixedRate = 600000) // Every 10 minutes
  public void refreshCache() {
    robaCachedService.refreshRobaCache();
  }
}
