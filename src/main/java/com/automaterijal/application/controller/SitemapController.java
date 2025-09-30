package com.automaterijal.application.controller;

import static lombok.AccessLevel.PRIVATE;

import com.automaterijal.application.services.ProductSitemapCache;
import com.automaterijal.application.services.SitemapService;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_XML_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE)
public class SitemapController {

  @NonNull final SitemapService sitemapService;
  @NonNull final ProductSitemapCache productSitemapCache;

  @Value("${site.base-url}")
  String baseUrl;

  // ─────────────────────────────────────────────────────────────────────────────
  // Index
  // ─────────────────────────────────────────────────────────────────────────────
  @GetMapping("/sitemap.xml")
  public String sitemapIndex() {
    String now = nowIsoUtc();
    StringBuilder sb = new StringBuilder();
    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
    sb.append("<sitemapindex xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">\n");
    sb.append("  <sitemap><loc>")
        .append(baseUrl)
        .append("/sitemap-static.xml</loc><lastmod>")
        .append(now)
        .append("</lastmod></sitemap>\n");
    sb.append("  <sitemap><loc>")
        .append(baseUrl)
        .append("/sitemap-categories.xml</loc><lastmod>")
        .append(now)
        .append("</lastmod></sitemap>\n");
    sb.append("  <sitemap><loc>")
        .append(baseUrl)
        .append("/sitemap-brands.xml</loc><lastmod>")
        .append(now)
        .append("</lastmod></sitemap>\n");
    String blogLastmod = isoUtc(sitemapService.getLatestBlogLastmod().orElse(null));
    sb.append("  <sitemap><loc>")
        .append(baseUrl)
        .append("/sitemap-blog.xml</loc><lastmod>")
        .append(blogLastmod)
        .append("</lastmod></sitemap>\n");
    String productLastmod = isoUtc(productSitemapCache.getLastRefreshTime());
    sb.append("  <sitemap><loc>")
        .append(baseUrl)
        .append("/sitemap-products-1.xml</loc><lastmod>")
        .append(productLastmod)
        .append("</lastmod></sitemap>\n");
    sb.append("  <sitemap><loc>")
        .append(baseUrl)
        .append("/sitemap-products-2.xml</loc><lastmod>")
        .append(productLastmod)
        .append("</lastmod></sitemap>\n");
    sb.append("</sitemapindex>");
    return sb.toString();
  }

  // ─────────────────────────────────────────────────────────────────────────────
  // Static pages
  // ─────────────────────────────────────────────────────────────────────────────
  @GetMapping("/sitemap-static.xml")
  public String sitemapStatic() {
    String now = nowIsoUtc();
    StringBuilder sb = new StringBuilder();
    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
    sb.append("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">\n");
    sb.append("  <url><loc>")
        .append(baseUrl)
        .append("/</loc><lastmod>")
        .append(now)
        .append("</lastmod><changefreq>daily</changefreq><priority>1.0</priority></url>\n");
    sb.append("  <url><loc>")
        .append(baseUrl)
        .append("/blog</loc><lastmod>")
        .append(now)
        .append("</lastmod><changefreq>daily</changefreq><priority>0.9</priority></url>\n");
    sb.append("  <url><loc>")
        .append(baseUrl)
        .append("/home</loc><lastmod>")
        .append(now)
        .append("</lastmod><changefreq>weekly</changefreq><priority>0.9</priority></url>\n");
    sb.append("  <url><loc>")
        .append(baseUrl)
        .append("/onama</loc><lastmod>")
        .append(now)
        .append("</lastmod><changefreq>monthly</changefreq><priority>0.7</priority></url>\n");
    sb.append("  <url><loc>")
        .append(baseUrl)
        .append("/kontakt</loc><lastmod>")
        .append(now)
        .append("</lastmod><changefreq>monthly</changefreq><priority>0.6</priority></url>\n");
    sb.append("  <url><loc>")
        .append(baseUrl)
        .append("/webshop</loc><lastmod>")
        .append(now)
        .append("</lastmod><changefreq>daily</changefreq><priority>0.9</priority></url>\n");
    sb.append("</urlset>");
    return sb.toString();
  }

  // ─────────────────────────────────────────────────────────────────────────────
  // Brands
  // ─────────────────────────────────────────────────────────────────────────────
  @GetMapping("/sitemap-brands.xml")
  public String sitemapBrands() {
    String now = nowIsoUtc();
    List<String> brandUrls = sitemapService.getAllBrandUrls();

    StringBuilder sb = new StringBuilder();
    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
    sb.append("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">\n");
    for (String url : brandUrls) {
      sb.append("  <url><loc>")
          .append(url)
          .append("</loc><lastmod>")
          .append(now)
          .append("</lastmod></url>\n");
    }
    sb.append("</urlset>");
    return sb.toString();
  }

  // ─────────────────────────────────────────────────────────────────────────────
  // Blog
  // ─────────────────────────────────────────────────────────────────────────────
  @GetMapping("/sitemap-blog.xml")
  public String sitemapBlog() {
    List<SitemapService.BlogSitemapEntry> entries = sitemapService.getBlogSitemapEntries();
    StringBuilder sb = new StringBuilder();
    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
    sb.append("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">\n");
    for (SitemapService.BlogSitemapEntry entry : entries) {
      sb.append("  <url><loc>")
          .append(entry.url())
          .append("</loc><lastmod>")
          .append(isoUtc(entry.lastmod()))
          .append("</lastmod></url>\n");
    }
    sb.append("</urlset>");
    return sb.toString();
  }

  // ─────────────────────────────────────────────────────────────────────────────
  // Categories
  // ─────────────────────────────────────────────────────────────────────────────
  @GetMapping("/sitemap-categories.xml")
  public String sitemapCategories() {
    String now = nowIsoUtc();
    List<String> categoryUrls = sitemapService.getAllCategoryUrlsCombined();

    StringBuilder sb = new StringBuilder();
    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
    sb.append("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">\n");
    for (String url : categoryUrls) {
      sb.append("  <url><loc>")
          .append(url)
          .append("</loc><lastmod>")
          .append(now)
          .append("</lastmod></url>\n");
    }
    sb.append("</urlset>");
    return sb.toString();
  }

  // ─────────────────────────────────────────────────────────────────────────────
  // Products pages
  // ─────────────────────────────────────────────────────────────────────────────
  @GetMapping("/sitemap-products-{page}.xml")
  public String sitemapProductsPage(@PathVariable int page) {
    return productSitemapCache.getPage(page);
  }

  // ─────────────────────────────────────────────────────────────────────────────
  // Helper
  // ─────────────────────────────────────────────────────────────────────────────
  private String nowIsoUtc() {
    return OffsetDateTime.now(ZoneOffset.UTC).toString(); // ISO-8601
  }

  private String isoUtc(OffsetDateTime time) {
    if (time == null) {
      return nowIsoUtc();
    }
    return time.withOffsetSameInstant(ZoneOffset.UTC).toString();
  }
}
