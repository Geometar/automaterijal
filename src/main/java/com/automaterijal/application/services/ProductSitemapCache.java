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
 * Pre-generates product sitemap XML once per schedule and serves it from memory for fast responses.
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@Slf4j
public class ProductSitemapCache {

  static final String EMPTY_SITEMAP_XML =
      "<?xml version=\"1.0\" encoding=\"UTF-8\"?><urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\"></urlset>";

  @NonNull SitemapService sitemapService;

  final AtomicReference<List<String>> cachedPages = new AtomicReference<>(List.of());
  final AtomicReference<OffsetDateTime> lastRefresh =
      new AtomicReference<>(OffsetDateTime.of(1970, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC));

  @EventListener(ApplicationReadyEvent.class)
  public void warmupCache() {
    refreshCacheSafely();
  }

  @Scheduled(cron = "${sitemap.products.refresh-cron:0 0 2 * * *}")
  public void scheduledRefresh() {
    refreshCacheSafely();
  }

  /**
   * Returns cached XML for requested page (1-based). Falls back to an empty sitemap when missing.
   */
  public String getPage(int page) {
    List<String> pages = cachedPages.get();
    if (page < 1 || page > pages.size()) {
      return EMPTY_SITEMAP_XML;
    }
    return pages.get(page - 1);
  }

  /** Returns the timestamp of the last successful refresh (UTC). */
  public OffsetDateTime getLastRefreshTime() {
    return lastRefresh.get();
  }

  private void refreshCacheSafely() {
    try {
      doRefresh();
    } catch (Exception ex) {
      log.error("Failed to refresh product sitemap cache", ex);
    }
  }

  private void doRefresh() {
    List<List<String>> urlPages = sitemapService.getProductUrlsTwoPages();
    OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

    if (urlPages.isEmpty()) {
      cachedPages.set(List.of());
      lastRefresh.set(now);
      return;
    }

    List<String> xmlPages = new ArrayList<>(urlPages.size());
    for (List<String> urls : urlPages) {
      xmlPages.add(buildXml(urls, now));
    }

    cachedPages.set(List.copyOf(xmlPages));
    lastRefresh.set(now);
    log.info("Product sitemap cache refreshed with {} page(s)", xmlPages.size());
  }

  private static String buildXml(List<String> urls, OffsetDateTime lastmod) {
    StringBuilder sb = new StringBuilder();
    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
    sb.append("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">\n");
    for (String url : urls) {
      sb.append("  <url><loc>")
          .append(url)
          .append("</loc><lastmod>")
          .append(lastmod)
          .append("</lastmod></url>\n");
    }
    sb.append("</urlset>");
    return sb.toString();
  }
}
