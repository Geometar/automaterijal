package com.automaterijal.application.services;

import com.automaterijal.application.domain.dto.ArticleGroupsDto;
import com.automaterijal.application.domain.dto.ArticleSubGroupsDto;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.services.roba.grupe.ArticleGroupService;
import com.automaterijal.application.services.roba.repo.RobaDatabaseService;
import com.automaterijal.application.utils.SlugUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SitemapService {

  @NonNull final ProizvodjacService proizvodjacService;
  @NonNull final ArticleGroupService articleGroupService;
  @NonNull final RobaDatabaseService robaDatabaseService;

  public static final int PRODUCT_SITEMAP_LIMIT = 50_000;

  @Value("${site.base-url}")
  String baseUrl;

  @Value("${sitemap.brand-prefix:/manufacturers}")
  String brandPrefix;

  @Value("${sitemap.category-prefix:/webshop/category}")
  String categoryPrefix;

  public List<String> getAllBrandUrls() {
    return proizvodjacService.pronadjiSve().stream()
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

  // Helpers
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
}
