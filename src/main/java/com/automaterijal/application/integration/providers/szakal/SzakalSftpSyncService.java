package com.automaterijal.application.integration.providers.szakal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.FileAttributes;
import net.schmizz.sshj.sftp.RemoteResourceInfo;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class SzakalSftpSyncService {
  private static final Set<String> PRICELIST_FILES =
      Set.of(
          "pricelist_0.csv.zip",
          "pricelist_1.csv.zip",
          "pricelist_2.csv.zip",
          "pricelist_3.csv.zip");
  private static final Set<String> WEEKLY_FILES =
      Set.of(
          "products_rs_all.csv.zip",
          "oe_link_all.csv.zip",
          "barcode_all.csv.zip",
          "no_return_all.csv.zip");

  private final SzakalProperties properties;

  public SyncResult syncPricelistsWithRetry() {
    return runWithRetry(this::syncPricelists, "pricelists");
  }

  public SyncResult syncWeeklyWithRetry() {
    return runWithRetry(this::syncWeekly, "weekly");
  }

  private SyncResult runWithRetry(Supplier<SyncResult> action, String label) {
    SzakalProperties.Sync sync = properties.getSync();
    int max = sync != null && sync.getMaxRetries() != null ? sync.getMaxRetries() : 3;
    long backoff =
        sync != null && sync.getRetryBackoffMs() != null ? sync.getRetryBackoffMs() : 2000L;

    for (int attempt = 1; attempt <= max; attempt++) {
      try {
        return action.get();
      } catch (RuntimeException ex) {
        log.warn(
            "Szakal SFTP sync {} attempt {}/{} failed: {}",
            label,
            attempt,
            max,
            ex.getMessage());
        if (attempt >= max) {
          return SyncResult.failed();
        }
        sleep(backoff * attempt);
      }
    }
    return SyncResult.failed();
  }

  private SyncResult syncPricelists() {
    return syncFiles(PRICELIST_FILES);
  }

  private SyncResult syncWeekly() {
    return syncFiles(WEEKLY_FILES);
  }

  private SyncResult syncFiles(Set<String> fileNames) {
    if (fileNames == null || fileNames.isEmpty()) {
      return SyncResult.empty();
    }
    Path base = resolveDataDir();
    if (base == null) {
      log.warn("Szakal sync skipped: data-dir is not configured");
      return SyncResult.empty();
    }
    ensureDirExists(base);

    SzakalProperties.Sftp sftp = properties.getSftp();
    if (sftp == null || !StringUtils.hasText(sftp.getHost())) {
      log.warn("Szakal sync skipped: SFTP host is not configured");
      return SyncResult.empty();
    }
    if (!StringUtils.hasText(sftp.getUsername()) || !StringUtils.hasText(sftp.getPassword())) {
      log.warn("Szakal sync skipped: SFTP credentials are not configured");
      return SyncResult.empty();
    }

    String remoteDir = StringUtils.hasText(sftp.getRemoteDir()) ? sftp.getRemoteDir() : "down";
    List<String> downloaded = new ArrayList<>();
    List<String> missing = new ArrayList<>();
    int skipped = 0;

    try (SSHClient ssh = new SSHClient()) {
      String fingerprint =
          StringUtils.hasText(sftp.getHostKeyFingerprint())
              ? sftp.getHostKeyFingerprint().trim()
              : null;
      if (fingerprint != null) {
        ssh.addHostKeyVerifier(fingerprint);
      } else {
        ssh.addHostKeyVerifier(new PromiscuousVerifier());
      }
      if (sftp.getConnectTimeoutMs() != null) {
        ssh.setConnectTimeout(sftp.getConnectTimeoutMs());
      }
      if (sftp.getReadTimeoutMs() != null) {
        ssh.setTimeout(sftp.getReadTimeoutMs());
      }

      ssh.connect(sftp.getHost(), sftp.getPort() != null ? sftp.getPort() : 22);
      ssh.authPassword(sftp.getUsername(), sftp.getPassword());
      try (SFTPClient client = ssh.newSFTPClient()) {
        Map<String, RemoteResourceInfo> resources = listRemote(client, remoteDir);
        for (String name : fileNames) {
          RemoteResourceInfo info = resources.get(name);
          if (info == null) {
            missing.add(name);
            continue;
          }
          Path localPath = base.resolve(name);
          FileAttributes attrs = info.getAttributes();
          if (!shouldDownload(localPath, attrs)) {
            skipped++;
            continue;
          }
          download(client, remoteDir, name, localPath, attrs);
          downloaded.add(name);
        }
      }
    } catch (IOException ex) {
      throw new RuntimeException("SFTP sync failed: " + ex.getMessage(), ex);
    }

    if (!downloaded.isEmpty() || skipped > 0 || !missing.isEmpty()) {
      log.info(
          "Szakal sync finished. downloaded={}, skipped={}, missing={}",
          downloaded.size(),
          skipped,
          missing.size());
    }
    return new SyncResult(true, downloaded, missing, skipped);
  }

  private Map<String, RemoteResourceInfo> listRemote(SFTPClient client, String remoteDir)
      throws IOException {
    List<RemoteResourceInfo> entries = client.ls(remoteDir);
    Map<String, RemoteResourceInfo> byName = new HashMap<>();
    for (RemoteResourceInfo entry : entries) {
      if (entry == null) {
        continue;
      }
      String name = entry.getName();
      if (!StringUtils.hasText(name)) {
        continue;
      }
      byName.put(name, entry);
    }
    return byName;
  }

  private boolean shouldDownload(Path localPath, FileAttributes attrs) {
    if (localPath == null || attrs == null) {
      return false;
    }
    if (!Files.exists(localPath)) {
      return true;
    }
    try {
      long localSize = Files.size(localPath);
      long remoteSize = attrs.getSize();
      if (localSize != remoteSize) {
        return true;
      }
      long remoteMtimeMs = toMillis(attrs.getMtime());
      long localMtimeMs = Files.getLastModifiedTime(localPath).toMillis();
      return remoteMtimeMs > localMtimeMs + 1000;
    } catch (IOException ex) {
      return true;
    }
  }

  private void download(
      SFTPClient client,
      String remoteDir,
      String name,
      Path target,
      FileAttributes attrs)
      throws IOException {
    String remotePath =
        remoteDir.endsWith("/") ? remoteDir + name : remoteDir + "/" + name;
    Path temp = target.resolveSibling(target.getFileName() + ".part");
    client.get(remotePath, temp.toString());
    moveAtomically(temp, target);
    if (attrs != null) {
      Files.setLastModifiedTime(target, FileTime.fromMillis(toMillis(attrs.getMtime())));
    }
  }

  private void moveAtomically(Path source, Path target) throws IOException {
    try {
      Files.move(source, target, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
    } catch (IOException ex) {
      Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
    }
  }

  private long toMillis(long mtimeSeconds) {
    return Instant.ofEpochSecond(mtimeSeconds).toEpochMilli();
  }

  private Path resolveDataDir() {
    if (!StringUtils.hasText(properties.getDataDir())) {
      return null;
    }
    return Path.of(properties.getDataDir());
  }

  private void ensureDirExists(Path base) {
    try {
      Files.createDirectories(base);
    } catch (IOException ex) {
      log.warn("Unable to create Szakal data dir {}: {}", base, ex.getMessage());
    }
  }

  private void sleep(long ms) {
    if (ms <= 0) {
      return;
    }
    try {
      Thread.sleep(ms);
    } catch (InterruptedException ignored) {
      Thread.currentThread().interrupt();
    }
  }

  public record SyncResult(
      boolean success, List<String> downloaded, List<String> missing, int skipped) {
    public static SyncResult empty() {
      return new SyncResult(false, List.of(), List.of(), 0);
    }

    public static SyncResult failed() {
      return new SyncResult(false, List.of(), List.of(), 0);
    }

    public boolean hasDownloads() {
      return success && downloaded != null && !downloaded.isEmpty();
    }
  }
}
