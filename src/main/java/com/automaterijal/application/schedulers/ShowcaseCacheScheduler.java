package com.automaterijal.application.schedulers;

import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.services.roba.cache.ShowcaseCacheService;
import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ShowcaseCacheScheduler {

  private final ShowcaseCacheService cache;

  // how many subgroups to prewarm per group
  private static final int PICK_ADO = 3;
  private static final int PICK_ALATI = 3;
  private static final int PICK_PRI = 3;
  private static final int PICK_MOS = 2;
  private static final int PICK_MPU = 2;

  /** Full reset and warm-up (default every 48h; configurable via property). */
  @Scheduled(fixedRateString = "${showcase.cache.reset.ms:172800000}")
  public void resetAndPrewarm() {
    log.info("[Showcase] Evicting buckets...");
    cache.evictAllBuckets();

    log.info("[Showcase] Prewarming buckets...");
    List<RobaLightDto> maziva =
        Stream.concat(warmGroup("MOS", PICK_MOS).stream(), warmGroup("MPU", PICK_MPU).stream())
            .toList();

    List<RobaLightDto> alati = warmGroup("ALATI", PICK_ALATI);
    List<RobaLightDto> pribor =
        Stream.concat(warmGroup("ADO", PICK_ADO).stream(), warmGroup("PRI", PICK_PRI).stream())
            .toList();

    log.info("[Showcase] Storing sections...");
    cache.storeSection("maziva", maziva);
    cache.storeSection("alati", alati);
    cache.storeSection("pribor", pribor);

    log.info("[Showcase] Warm-up done.");
  }

  /** Picks random subgroups for a group and fills @Cacheable buckets. */
  private List<RobaLightDto> warmGroup(String group, int count) {
    var subs = cache.pickRandomSubgroups(group, count);
    return subs.stream()
        .flatMap(
            sg -> {
              try {
                return cache.top5ForSubgroup(group, sg).stream(); // populates bucket cache
              } catch (Exception e) {
                log.warn("[Showcase] Warm-up failed for {}:{} - {}", group, sg, e.getMessage());
                return Stream.<RobaLightDto>empty();
              }
            })
        .toList();
  }
}
