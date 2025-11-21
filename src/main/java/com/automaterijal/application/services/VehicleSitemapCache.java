package com.automaterijal.application.services;

import static lombok.AccessLevel.PRIVATE;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Pre-generates vehicle sitemap XML once per schedule and serves it from memory for fast responses.
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@Slf4j
public class VehicleSitemapCache {

  private static final int VEHICLE_SITEMAP_LIMIT = 50_000;

  @NonNull SitemapService sitemapService;

  final AtomicReference<List<String>> cachedPages = new AtomicReference<>(List.of());
  final AtomicReference<OffsetDateTime> lastRefresh =
      new AtomicReference<>(OffsetDateTime.of(1970, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC));

  @EventListener(ApplicationReadyEvent.class)
  public void warmupCache() {
    refreshCacheSafely();
  }

  @Scheduled(cron = "${sitemap.vehicles.refresh-cron:0 30 3 * * *}")
  public void scheduledRefresh() {
    refreshCacheSafely();
  }

  /** Returns cached XML for requested page (1-based). */
  public String getPage(int page) {
    List<String> pages = cachedPages.get();
    if (page < 1 || page > pages.size()) {
      return ProductSitemapCache.EMPTY_SITEMAP_XML;
    }
    return pages.get(page - 1);
  }

  /** Returns the timestamp of the last successful refresh (UTC). */
  public OffsetDateTime getLastRefreshTime() {
    return lastRefresh.get();
  }

  public int getPageCount() {
    return cachedPages.get().size();
  }

  private void refreshCacheSafely() {
    try {
      doRefresh();
    } catch (Exception ex) {
      log.error("Failed to refresh vehicle sitemap cache", ex);
    }
  }

  private void doRefresh() {
    List<SitemapService.VehicleSitemapEntry> entries = sitemapService.getVehicleSitemapEntries();
    OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

    if (entries.isEmpty()) {
      cachedPages.set(List.of());
      lastRefresh.set(now);
      return;
    }

    long modelCount =
        entries.stream().filter(e -> "0.6".equals(e.priority())).count(); // models have 0.6
    log.info(
        "Vehicle sitemap entries total={}, models={}",
        entries.size(),
        modelCount);

    List<String> xmlPages = new ArrayList<>();
    for (int start = 0; start < entries.size(); start += VEHICLE_SITEMAP_LIMIT) {
      int end = Math.min(entries.size(), start + VEHICLE_SITEMAP_LIMIT);
      xmlPages.add(buildXml(entries.subList(start, end), now));
    }

    cachedPages.set(List.copyOf(xmlPages));
    lastRefresh.set(now);
    log.info("Vehicle sitemap cache refreshed with {} page(s)", xmlPages.size());
  }

  private static String buildXml(List<SitemapService.VehicleSitemapEntry> urls, OffsetDateTime lastmod) {
    StringBuilder sb = new StringBuilder();
    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
    sb.append("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">\n");
    for (SitemapService.VehicleSitemapEntry entry : urls) {
      sb.append("  <url><loc>")
          .append(entry.url())
          .append("</loc><lastmod>")
          .append(lastmod)
          .append("</lastmod><changefreq>")
          .append(entry.changefreq())
          .append("</changefreq><priority>")
          .append(entry.priority())
          .append("</priority></url>\n");
    }
    sb.append("</urlset>");
    return sb.toString();
  }
}
