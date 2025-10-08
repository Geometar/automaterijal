package com.automaterijal.application.services.share;

import com.automaterijal.application.domain.dto.ProizvodjacDTO;
import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaExpandedDto;
import com.automaterijal.application.services.ImageService;
import com.automaterijal.application.services.roba.details.RobaDetailsService;
import com.automaterijal.application.utils.SlugUtil;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.util.HtmlUtils;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductShareService {

  @NonNull final RobaDetailsService robaDetailsService;
  @NonNull final ImageService imageService;

  @Value("${site.base-url:https://automaterijal.com}")
  String siteBaseUrl;

  private static final String SITE_NAME = "Automaterijal";

  @Transactional(readOnly = true)
  public Optional<String> buildProductSharePage(Long robaId) {
    return robaDetailsService
        .fetchRobaDetails(robaId, null)
        .map(this::buildMetadata)
        .map(this::renderHtml);
  }

  private ProductShareMetadata buildMetadata(RobaExpandedDto roba) {
    String productName = safe(roba.getNaziv());
    String sku = safe(roba.getKatbr());
    String brandName = safe(extractBrandName(roba.getProizvodjac()));
    String title = buildTitle(brandName, productName, sku);
    String description = truncate(chooseDescription(roba, productName), 220);

    String slugSource = productName.isEmpty() ? SITE_NAME : productName;
    String slugPath =
        robaDetailsService
            .findSlugPathById(roba.getRobaid())
            .orElseGet(() -> roba.getRobaid() + "-" + SlugUtil.toSlug(slugSource));
    String productPath = "/webshop/" + slugPath;
    String productUrl = toAbsoluteUrl(productPath);

    String imageUrl = resolveImageUrl(roba.getSlika());
    String canonical = productUrl;

    return new ProductShareMetadata(
        title, description, imageUrl, productUrl, canonical, brandName, sku);
  }

  private String renderHtml(ProductShareMetadata meta) {
    StringBuilder sb = new StringBuilder(512);
    sb.append("<!DOCTYPE html><html lang=\"sr\"><head>");
    sb.append("<meta charset=\"UTF-8\"/>");
    appendTag(sb, "title", meta.title());
    appendMetaProperty(sb, "og:title", meta.title());
    appendMetaProperty(sb, "og:description", meta.description());
    appendMetaProperty(sb, "og:image", meta.imageUrl());
    appendMetaProperty(sb, "og:url", meta.productUrl());
    appendMetaProperty(sb, "og:type", "product");
    appendMetaProperty(sb, "og:site_name", SITE_NAME);
    appendMetaProperty(sb, "og:locale", "sr_RS");
    if (StringUtils.hasText(meta.brandName())) {
      appendMetaProperty(sb, "product:brand", meta.brandName());
    }
    if (StringUtils.hasText(meta.sku())) {
      appendMetaProperty(sb, "product:retailer_item_id", meta.sku());
    }
    appendMetaName(sb, "twitter:card", "summary_large_image");
    appendMetaName(sb, "twitter:title", meta.title());
    appendMetaName(sb, "twitter:description", meta.description());
    appendMetaName(sb, "twitter:image", meta.imageUrl());
    appendLinkRel(sb, "canonical", meta.canonicalUrl());
    appendMetaHttpEquiv(sb, "refresh", "0; url=" + meta.productUrl());
    sb.append("</head><body>");
    sb.append("<p>Redirecting to <a href=\"")
        .append(htmlEscape(meta.productUrl()))
        .append("\">")
        .append(htmlEscape(meta.productUrl()))
        .append("</a>...</p>");
    sb.append("<script>window.location.replace(\"")
        .append(jsEscape(meta.productUrl()))
        .append("\");</script>");
    sb.append("</body></html>");
    return sb.toString();
  }

  private static String buildTitle(String brandName, String productName, String sku) {
    StringBuilder core = new StringBuilder();
    if (StringUtils.hasText(brandName)) {
      core.append(brandName.trim());
    }
    if (StringUtils.hasText(productName)) {
      if (core.length() > 0) {
        core.append(' ');
      }
      core.append(productName.trim());
    }
    if (StringUtils.hasText(sku)) {
      if (core.length() > 0) {
        core.append(' ');
      }
      core.append('(').append(sku.trim()).append(')');
    }
    if (core.length() == 0) {
      core.append(SITE_NAME);
    }
    core.append(" | ").append(SITE_NAME);
    return core.toString();
  }

  private static String chooseDescription(RobaExpandedDto roba, String fallbackName) {
    if (StringUtils.hasText(roba.getTekst())) {
      return normalize(roba.getTekst());
    }
    String specs = summarizeSpecs(roba.getTehnickiOpis());
    if (StringUtils.hasText(specs)) {
      return specs;
    }
    return StringUtils.hasText(fallbackName) ? fallbackName : SITE_NAME;
  }

  private String resolveImageUrl(SlikaDto slikaDto) {
    if (slikaDto != null && StringUtils.hasText(slikaDto.getSlikeUrl())) {
      String url = slikaDto.getSlikeUrl();
      if (!imageService.isFallbackImage(url)) {
        return ensureAbsoluteUrl(url);
      }
    }
    return ensureAbsoluteUrl(imageService.getFallbackImageUrl());
  }

  private static String extractBrandName(ProizvodjacDTO proizvodjac) {
    return proizvodjac == null ? null : proizvodjac.getNaziv();
  }

  private String toAbsoluteUrl(String path) {
    if (!StringUtils.hasText(path)) {
      return ensureAbsoluteUrl("/");
    }
    return ensureAbsoluteUrl(path);
  }

  private String ensureAbsoluteUrl(String value) {
    if (!StringUtils.hasText(value)) {
      return trimmedBaseUrl();
    }
    String trimmed = value.trim();
    if (trimmed.startsWith("http://") || trimmed.startsWith("https://")) {
      return trimmed;
    }
    String base = trimmedBaseUrl();
    if (!StringUtils.hasText(base)) {
      return trimmed.startsWith("/") ? trimmed : "/" + trimmed;
    }
    String normalizedPath = trimmed.startsWith("/") ? trimmed : "/" + trimmed;
    return base + normalizedPath;
  }

  private String trimmedBaseUrl() {
    String base = siteBaseUrl == null ? "" : siteBaseUrl.trim();
    while (base.endsWith("/")) {
      base = base.substring(0, base.length() - 1);
    }
    return base;
  }

  private static String safe(String value) {
    return value == null ? "" : value.trim();
  }

  private static void appendMetaProperty(StringBuilder sb, String property, String content) {
    sb.append("<meta property=\"")
        .append(htmlEscape(property))
        .append("\" content=\"")
        .append(htmlEscape(content))
        .append("\"/>");
  }

  private static void appendMetaName(StringBuilder sb, String name, String content) {
    sb.append("<meta name=\"")
        .append(htmlEscape(name))
        .append("\" content=\"")
        .append(htmlEscape(content))
        .append("\"/>");
  }

  private static void appendMetaHttpEquiv(StringBuilder sb, String httpEquiv, String content) {
    sb.append("<meta http-equiv=\"")
        .append(htmlEscape(httpEquiv))
        .append("\" content=\"")
        .append(htmlEscape(content))
        .append("\"/>");
  }

  private static void appendLinkRel(StringBuilder sb, String rel, String href) {
    sb.append("<link rel=\"")
        .append(htmlEscape(rel))
        .append("\" href=\"")
        .append(htmlEscape(href))
        .append("\"/>");
  }

  private static void appendTag(StringBuilder sb, String tag, String content) {
    sb.append('<')
        .append(tag)
        .append('>')
        .append(htmlEscape(content))
        .append("</")
        .append(tag)
        .append('>');
  }

  private static String htmlEscape(String value) {
    return HtmlUtils.htmlEscape(value == null ? "" : value, StandardCharsets.UTF_8.name());
  }

  private static String jsEscape(String value) {
    if (value == null) {
      return "";
    }
    return value.replace("\\", "\\\\").replace("\"", "\\\"");
  }

  private static String summarizeSpecs(List<RobaTehnickiOpisDto> specs) {
    if (specs == null || specs.isEmpty()) {
      return "";
    }
    return specs.stream()
        .map(ProductShareService::formatSpec)
        .filter(StringUtils::hasText)
        .limit(3)
        .reduce((a, b) -> a + " • " + b)
        .orElse("");
  }

  private static String formatSpec(RobaTehnickiOpisDto spec) {
    if (spec == null) {
      return "";
    }
    String label = safe(spec.getOznaka());
    String value = safe(spec.getVrednost());
    String unit = safe(spec.getJedinica());
    if (!StringUtils.hasText(value)) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    if (StringUtils.hasText(label)) {
      sb.append(label).append(": ");
    }
    sb.append(value);
    if (StringUtils.hasText(unit)) {
      sb.append(' ').append(unit);
    }
    return sb.toString();
  }

  private static String normalize(String text) {
    if (!StringUtils.hasText(text)) {
      return "";
    }
    String noTags = text.replaceAll("(?s)<[^>]*>", " ");
    return collapseWhitespace(noTags);
  }

  private static String collapseWhitespace(String input) {
    return input.replaceAll("\\s+", " ").trim();
  }

  private static String truncate(String value, int maxLength) {
    if (!StringUtils.hasText(value) || value.length() <= maxLength) {
      return safe(value);
    }
    String trimmed = value.substring(0, Math.min(value.length(), maxLength));
    int lastSpace = trimmed.lastIndexOf(' ');
    if (lastSpace > maxLength / 2) {
      trimmed = trimmed.substring(0, lastSpace);
    }
    return trimmed.trim();
  }

  private record ProductShareMetadata(
      String title,
      String description,
      String imageUrl,
      String productUrl,
      String canonicalUrl,
      String brandName,
      String sku) {}
}
