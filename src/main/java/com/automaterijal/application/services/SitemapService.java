package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.ArticleGroupsDto;
import com.automaterijal.application.domain.dto.ArticleSubGroupsDto;
import com.automaterijal.application.domain.dto.tecdoc.Manufcatures;
import com.automaterijal.application.domain.dto.tecdoc.Model;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.repository.blog.BlogPostRepository;
import com.automaterijal.application.services.roba.grupe.ArticleGroupService;
import com.automaterijal.application.services.roba.repo.RobaDatabaseService;
import com.automaterijal.application.tecdoc.LinkageTargetDetails;
import com.automaterijal.application.tecdoc.LinkageTargetEngine;
import com.automaterijal.application.utils.SlugUtil;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class SitemapService {

  private static final List<String> BRAND_DETAIL_SLUGS =
      List.of(
          "shell",
          "lukoil",
          "fuchs",
          "valvoline",
          "febi",
          "bilstein",
          "blue-print",
          "hi-q",
          "mahle",
          "fleetguard",
          "victor-reinz",
          "pierburg",
          "kolbenschmidt",
          "magneti-marelli",
          "bottari",
          "energizer");

  @NonNull final ProizvodjacService proizvodjacService;
  @NonNull final ArticleGroupService articleGroupService;
  @NonNull final RobaDatabaseService robaDatabaseService;
  @NonNull final BlogPostRepository blogPostRepository;
  @NonNull final TecDocService tecDocService;

  public static final int PRODUCT_SITEMAP_LIMIT = 50_000;

  @Value("${site.base-url}")
  String baseUrl;

  @Value("${sitemap.brand-prefix:/manufacturers}")
  String brandPrefix;

  @Value("${sitemap.brand-details-prefix:/brendovi}")
  String brandDetailsPrefix;

  @Value("${sitemap.category-prefix:/webshop/category}")
  String categoryPrefix;

  @Value("${sitemap.blog-prefix:/blog}")
  String blogPrefix;

  @Value("${sitemap.vehicles.prefix:/webshop/vozila}")
  String vehiclesPrefix;

  @Value("${sitemap.vehicles.linking-target-type:PO}")
  String vehiclesLinkingTargetType;

  @Value("${sitemap.vehicles.include-details:false}")
  boolean includeVehicleDetails;

  @Value("${sitemap.vehicles.manufacturer-ids:}")
  String vehicleManufacturerIdsRaw;

  @Value("${sitemap.vehicles.model-end-cutoff-year:1995}")
  int vehicleModelEndCutoffYear;

  public List<String> getAllBrandUrls() {
    return proizvodjacService.findAll().stream()
        .map(Proizvodjac::getNaziv)
        .filter(n -> n != null && !n.isBlank())
        .map(SlugUtil::toSlug)
        .distinct()
        .sorted(String.CASE_INSENSITIVE_ORDER)
        .map(this::brandToUrlFromSlug)
        .toList();
  }

  private String brandToUrlFromSlug(String brandSlug) {
    String normalizedBase = stripTrailingSlash(baseUrl);
    String normalizedPrefix = ensureLeadingSlash(brandPrefix);
    return normalizedBase + normalizedPrefix + "/" + brandSlug;
  }

  // ostaviš ako ti treba i varijanta sa nazivom:
  private String brandToUrl(String brandName) {
    return brandToUrlFromSlug(SlugUtil.toSlug(brandName));
  }

  public List<String> getAllBrandDetailUrls() {
    String normalizedBase = stripTrailingSlash(baseUrl);
    String prefix = ensureLeadingSlash(brandDetailsPrefix);
    return BRAND_DETAIL_SLUGS.stream()
        .map(slug -> normalizedBase + prefix + "/" + slug)
        .toList();
  }

  public List<String> getAllCategoryUrls() {
    List<ArticleGroupsDto> groups = articleGroupService.fetchAllGroupsWithSubgroups();
    String normalizedBase = stripTrailingSlash(baseUrl);
    String prefix = ensureLeadingSlash(categoryPrefix);

    return groups.stream()
        .map(ArticleGroupsDto::name)
        .filter(Objects::nonNull)
        .map(String::trim)
        .filter(s -> !s.isBlank())
        .map(SlugUtil::toSlug)
        .distinct()
        .sorted()
        .map(slug -> normalizedBase + prefix + "/" + slug)
        .toList();
  }

  /** /webshop/category/:name/:subcategory + landing za :name */
  public List<String> getAllCategorySubcategoryUrls() {
    List<ArticleGroupsDto> groups = articleGroupService.fetchAllGroupsWithSubgroups();
    String normalizedBase = stripTrailingSlash(baseUrl);
    String prefix = ensureLeadingSlash(categoryPrefix);

    List<String> urls = new ArrayList<>(groups.size() * 8);
    for (ArticleGroupsDto g : groups) {
      String groupName = safe(g.name());
      if (groupName.isEmpty()) continue;
      String groupSlug = SlugUtil.toSlug(groupName);

      // landing kategorije
      urls.add(normalizedBase + prefix + "/" + groupSlug);

      List<ArticleSubGroupsDto> subs = g.articleSubGroups();
      if (subs == null || subs.isEmpty()) continue;

      for (ArticleSubGroupsDto s : subs) {
        String subName = safe(s.name());
        if (subName.isEmpty()) continue;
        String subSlug = SlugUtil.toSlug(subName);
        urls.add(normalizedBase + prefix + "/" + groupSlug + "/" + subSlug);
      }
    }
    return urls;
  }

  public List<String> getAllCategoryUrlsCombined() {
    var set = new java.util.LinkedHashSet<String>();
    set.addAll(getAllCategoryUrls());
    set.addAll(getAllCategorySubcategoryUrls());
    return List.copyOf(set);
  }

  public List<List<String>> getProductUrlsTwoPages() {
    List<String> all =
        robaDatabaseService.findAll().stream()
            .filter(roba -> !ArticleGroupService.FORBIDDEN_CATEGORIES.contains(roba.getGrupaid()))
            .sorted(Comparator.comparing(Roba::getRobaid).reversed())
            .map(this::buildProductUrl)
            .toList();

    int total = all.size();
    if (total <= PRODUCT_SITEMAP_LIMIT) {
      return List.of(all); // samo 1 fajl
    }
    if (total > 2 * PRODUCT_SITEMAP_LIMIT) {
      throw new IllegalStateException(
          "Imaš više od 100k proizvoda — za 2 fajla bi prešlo 50k limit po fajlu.");
    }

    int perPage = (int) Math.ceil(total / 2.0); // podela na ~jednake 2 strane (<=50k svaka)
    return List.of(all.subList(0, perPage), all.subList(perPage, total));
  }

  public List<BlogSitemapEntry> getBlogSitemapEntries() {
    String normalizedBase = stripTrailingSlash(baseUrl);
    String prefix = ensureLeadingSlash(blogPrefix);

    List<BlogSitemapEntry> entries = new ArrayList<>(512);
    try (var stream = blogPostRepository.streamPublishedOrdered()) {
      stream.forEach(
          post -> {
            String slug = safe(post.getSlug());
            if (!StringUtils.hasText(slug)) {
              return;
            }
            String url = normalizedBase + prefix + "/" + slug;
            entries.add(new BlogSitemapEntry(url, toUtcOffset(post.getPublishedAt())));
          });
    }
    return List.copyOf(entries);
  }

  public Optional<OffsetDateTime> getLatestBlogLastmod() {
    try (var stream = blogPostRepository.streamLatestPublishedAt()) {
      return stream.findFirst().map(SitemapService::toUtcOffset);
    }
  }

  public List<VehicleSitemapEntry> getVehicleSitemapEntries() {
    String normalizedBase = stripTrailingSlash(baseUrl);
    String prefix = ensureLeadingSlash(vehiclesPrefix);
    Set<Long> allowedManufacturers = allowedVehicleManufacturerIds();

    List<VehicleSitemapEntry> entries = new ArrayList<>();
    String rootUrl = normalizedBase + prefix;
    entries.add(new VehicleSitemapEntry(rootUrl, "weekly", "0.8"));

    List<Manufcatures> manufacturers =
        Optional.ofNullable(tecDocService.getAllManufactures(vehiclesLinkingTargetType))
            .orElse(List.of());

    for (Manufcatures manufacturer : manufacturers) {
      Long manufacturerId = manufacturer.id();
      if (manufacturerId == null) {
        continue;
      }

      if (!allowedManufacturers.isEmpty() && !allowedManufacturers.contains(manufacturerId)) {
        continue;
      }

      String manufacturerSlug =
          SlugUtil.slugifyWithFallback(manufacturer.name(), "manufacturer-" + manufacturerId);
      String manufacturerUrl = rootUrl + "/" + manufacturerSlug;
      entries.add(new VehicleSitemapEntry(manufacturerUrl, "weekly", "0.7"));

      List<Model> models =
          Optional.ofNullable(
                  tecDocService.getModelsForModeId(
                      manufacturerId.intValue(), vehiclesLinkingTargetType))
              .orElse(List.of());

      for (Model model : models) {
        Long modelId = model.modelId();
        if (modelId == null) {
          continue;
        }

        if (shouldSkipModel(model)) {
          continue;
        }

        String modelSlug = SlugUtil.slugifyWithFallback(model.name(), "model-" + modelId);
        String modelUrl = manufacturerUrl + "/" + modelSlug;
        entries.add(new VehicleSitemapEntry(modelUrl, "weekly", "0.6"));

        if (!includeVehicleDetails) {
          continue;
        }

        List<LinkageTargetDetails> vehicles =
            Optional.ofNullable(
                    tecDocService.getModelSubTypes(
                        manufacturerId.intValue(), modelId.intValue(), vehiclesLinkingTargetType))
                .orElse(List.of());

        for (LinkageTargetDetails vehicle : vehicles) {
          String vehicleSlug = buildVehicleSlug(vehicle);
          if (vehicleSlug.isEmpty()) {
            continue;
          }
          entries.add(new VehicleSitemapEntry(modelUrl + "/" + vehicleSlug, "weekly", "0.6"));
        }
      }
    }

    LinkedHashMap<String, VehicleSitemapEntry> unique = new LinkedHashMap<>();
    for (VehicleSitemapEntry entry : entries) {
      unique.putIfAbsent(entry.url(), entry);
    }
    return List.copyOf(unique.values());
  }

  // Helpers
  private String buildVehicleSlug(LinkageTargetDetails vehicle) {
    if (vehicle == null || vehicle.getLinkageTargetId() <= 0) {
      return "";
    }

    String type = safe(vehicle.getLinkageTargetType()).toLowerCase(Locale.ROOT);
    String identifierSource =
        (type.isBlank() ? "vehicle" : type) + "-" + vehicle.getLinkageTargetId();
    String identifierPart = SlugUtil.slugifyWithFallback(identifierSource, identifierSource);

    String description =
        firstNonBlank(
            safe(vehicle.getDescription()),
            safe(vehicle.getVehicleSalesDescription()),
            safe(vehicle.getSalesDescription()));
    String detailSlug = buildVehicleDetailSlug(vehicle, description);

    return identifierPart + "-" + detailSlug;
  }

  private String buildVehicleDetailSlug(LinkageTargetDetails vehicle, String description) {
    List<String> parts = new ArrayList<>();

    if (StringUtils.hasText(description)) {
      parts.add(description);
    }

    String powerLabel =
        formatPowerLabel(
            firstNonNull(vehicle.getKiloWattsFrom(), vehicle.getKiloWattsTo()),
            firstNonNull(vehicle.getHorsePowerFrom(), vehicle.getHorsePowerTo()));
    if (StringUtils.hasText(powerLabel)) {
      parts.add(powerLabel);
    }

    String yearRange = formatYearRange(vehicle.getBeginYearMonth(), vehicle.getEndYearMonth());
    if (StringUtils.hasText(yearRange)) {
      parts.add(yearRange);
    }

    String engineCodes = mergeEngineCodes(vehicle.getEngines());
    if (StringUtils.hasText(engineCodes)) {
      parts.add(engineCodes);
    }

    String engineType = safe(vehicle.getEngineType());
    if (StringUtils.hasText(engineType)
        && (description.isEmpty() || !containsIgnoreCase(description, engineType))) {
      parts.add(engineType);
    }

    String fuelType = safe(vehicle.getFuelType());
    if (StringUtils.hasText(fuelType) && !fuelType.equalsIgnoreCase(engineType)) {
      parts.add(fuelType);
    }

    String joined = String.join(" ", parts);
    return SlugUtil.slugifyWithFallback(joined, "detalji");
  }

  private static String formatPowerLabel(Integer kw, Integer hp) {
    if (kw == null && hp == null) {
      return "";
    }
    if (kw != null && hp != null) {
      return kw + " kw " + hp + " hp";
    }
    if (kw != null) {
      return kw + " kw";
    }
    return hp + " hp";
  }

  private static String formatYearRange(String begin, String end) {
    String from = digitsAndDash(begin);
    String to = digitsAndDash(end);
    if (!from.isBlank() && !to.isBlank()) {
      return from + "-" + to;
    }
    if (!from.isBlank()) {
      return from;
    }
    return to;
  }

  private static String digitsAndDash(String value) {
    if (value == null || value.isBlank()) {
      return "";
    }
    return value.replaceAll("[^0-9-]", "");
  }

  private static String mergeEngineCodes(List<LinkageTargetEngine> engines) {
    if (engines == null || engines.isEmpty()) {
      return "";
    }
    return engines.stream()
        .map(LinkageTargetEngine::getCode)
        .map(SitemapService::safe)
        .filter(s -> !s.isBlank())
        .distinct()
        .collect(Collectors.joining(" "));
  }

  private static <T> T firstNonNull(T first, T second) {
    return first != null ? first : second;
  }

  private static String firstNonBlank(String... values) {
    for (String value : values) {
      if (StringUtils.hasText(value)) {
        return value.trim();
      }
    }
    return "";
  }

  private static boolean containsIgnoreCase(String haystack, String needle) {
    if (!StringUtils.hasText(haystack) || !StringUtils.hasText(needle)) {
      return false;
    }
    return haystack.toLowerCase(Locale.ROOT).contains(needle.toLowerCase(Locale.ROOT));
  }

  private String buildProductUrl(Roba roba) {
    String normalizedBase = stripTrailingSlash(baseUrl);
    String prefix = "/webshop";

    String brand = safe(roba.getProizvodjac() != null ? roba.getProizvodjac().getNaziv() : "");
    String name = safe(roba.getNaziv());
    String katbr = safe(roba.getKatbr());
    String id = roba.getRobaid() != null ? roba.getRobaid().toString() : "";

    String slug =
        SlugUtil.toSlug(
            String.join(
                " ",
                List.of(brand, name, katbr).stream()
                    .filter(s -> s != null && !s.isBlank())
                    .toList()));

    return slug.isBlank()
        ? normalizedBase + prefix + "/" + id
        : normalizedBase + prefix + "/" + id + "-" + slug;
  }

  private static String stripTrailingSlash(String s) {
    return (s != null && s.endsWith("/")) ? s.substring(0, s.length() - 1) : s;
  }

  private static String ensureLeadingSlash(String s) {
    if (s == null || s.isBlank()) return "";
    return s.startsWith("/") ? s : "/" + s;
  }

  private static String safe(String s) {
    return s == null ? "" : s.trim();
  }

  private static OffsetDateTime toUtcOffset(LocalDateTime time) {
    return time == null ? null : time.atOffset(ZoneOffset.UTC);
  }

  private boolean shouldSkipModel(Model model) {
    Integer toYear = parseYear(model.constructedTo());
    if (toYear != null && toYear < vehicleModelEndCutoffYear) {
      return true; // production ended before cutoff year
    }
    return false; // keep everything produced during/after cutoff (or unknown end)
  }

  private static Integer parseYear(Integer value) {
    if (value == null) {
      return null;
    }
    int val = Math.abs(value);
    if (val == 0) {
      return null;
    }
    if (val >= 10000) { // formats like yyyymm
      return val / 100;
    }
    if (val >= 1000) { // plain year
      return val;
    }
    return null;
  }

  private Set<Long> allowedVehicleManufacturerIds() {
    if (!StringUtils.hasText(vehicleManufacturerIdsRaw)) {
      return Set.of();
    }
    return Arrays.stream(vehicleManufacturerIdsRaw.split(","))
        .map(String::trim)
        .filter(s -> !s.isEmpty())
        .map(SitemapService::parseLongSafe)
        .filter(Objects::nonNull)
        .collect(Collectors.toCollection(LinkedHashSet::new));
  }

  private static Long parseLongSafe(String value) {
    try {
      return Long.valueOf(value);
    } catch (NumberFormatException ex) {
      return null;
    }
  }

  public record VehicleSitemapEntry(String url, String changefreq, String priority) {}
  public record BlogSitemapEntry(String url, OffsetDateTime lastmod) {}
}
