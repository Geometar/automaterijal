package com.automaterijal.application.integration.providers.szakal;

import com.automaterijal.application.integration.providers.szakal.SzakalSftpSyncService.SyncResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
@Slf4j
public class SzakalSyncScheduler {

  private final SzakalProperties properties;
  private final SzakalSftpSyncService syncService;
  private final SzakalImportService importService;

  @EventListener(ApplicationReadyEvent.class)
  public void onStartup() {
    Readiness readiness = readiness();
    if (!readiness.ready()) {
      log.info("Szakal sync not ready on startup: {}", readiness.reason());
      return;
    }

    log.info("Szakal sync is ready.");

    SzakalProperties.Sync sync = properties.getSync();
    if (sync == null || !sync.isRunOnStart()) {
      return;
    }

    SyncResult pricelists = syncService.syncPricelistsWithRetry();
    if (pricelists != null && pricelists.hasDownloads()) {
      importService.importPriceListsOnly();
    }

    if (sync.isRunWeeklyOnStart()) {
      SyncResult weekly = syncService.syncWeeklyWithRetry();
      if (weekly != null && weekly.hasDownloads()) {
        importService.importMasterOnly();
        importService.importOeOnly();
        importService.importBarcodesOnly();
      }
    }
  }

  @Scheduled(cron = "${integration.szakal.sync.cron-pricelists:0 0 5 * * *}")
  public void syncPricelists() {
    if (!shouldRun()) {
      return;
    }
    SyncResult result = syncService.syncPricelistsWithRetry();
    if (result != null && result.hasDownloads()) {
      importService.importPriceListsOnly();
    }
  }

  @Scheduled(cron = "${integration.szakal.sync.cron-weekly:0 0 4 * * SUN}")
  public void syncWeekly() {
    if (!shouldRun()) {
      return;
    }
    SyncResult result = syncService.syncWeeklyWithRetry();
    if (result != null && result.hasDownloads()) {
      importService.importMasterOnly();
      importService.importOeOnly();
      importService.importBarcodesOnly();
    }
  }

  private boolean shouldRun() {
    Readiness readiness = readiness();
    if (!readiness.ready()) {
      log.warn("Szakal sync skipped: {}", readiness.reason());
      return false;
    }
    return true;
  }

  private Readiness readiness() {
    SzakalProperties.Sync sync = properties.getSync();
    if (sync == null || !sync.isEnabled()) {
      return new Readiness(false, "sync disabled");
    }
    if (!StringUtils.hasText(properties.getDataDir())) {
      return new Readiness(false, "data-dir is not configured");
    }
    SzakalProperties.Sftp sftp = properties.getSftp();
    if (sftp == null || !StringUtils.hasText(sftp.getHost())) {
      return new Readiness(false, "SFTP host is not configured");
    }
    if (!StringUtils.hasText(sftp.getUsername()) || !StringUtils.hasText(sftp.getPassword())) {
      return new Readiness(false, "SFTP credentials are not configured");
    }
    return new Readiness(true, "ready");
  }

  private record Readiness(boolean ready, String reason) {}
}
