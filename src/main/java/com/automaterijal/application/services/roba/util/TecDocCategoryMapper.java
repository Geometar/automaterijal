package com.automaterijal.application.services.roba.util;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.PodgrupaDto;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.tecdoc.ArticleRecord;
import com.automaterijal.application.tecdoc.ArticleRefRecord;
import com.automaterijal.application.tecdoc.GenericArticleRecord;
import com.automaterijal.application.tecdoc.TradeNumberDetailsRecord;
import com.automaterijal.application.utils.CatalogNumberUtils;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.springframework.util.StringUtils;

/** Helper for mapping TecDoc generic articles to grupa/podgrupa in MagacinDto. */
public final class TecDocCategoryMapper {

  private TecDocCategoryMapper() {}

  public static void apply(
      MagacinDto magacinDto,
      List<ArticleRecord> articles,
      List<ArticleRecord> categoriesSourceArticles) {
    if (magacinDto == null
        || magacinDto.getRobaDto() == null
        || magacinDto.getRobaDto().getContent().isEmpty()
        || articles == null
        || articles.isEmpty()) {
      return;
    }

    CategoryIndex categoryIndex = buildCategoryIndex(articles);
    if (categoryIndex.isEmpty()) {
      return;
    }

    Set<CategoryInfo> usedCategories = new LinkedHashSet<>();
    magacinDto
        .getRobaDto()
        .getContent()
        .forEach(
            robaDto -> {
              CategoryInfo category = resolveCategoryForProduct(robaDto, categoryIndex);
              if (category == null) {
                return;
              }
              applyCategory(robaDto, category);
              usedCategories.add(category);
            });

    Set<CategoryInfo> availableCategories =
        extractCategories(
            categoriesSourceArticles != null && !categoriesSourceArticles.isEmpty()
                ? categoriesSourceArticles
                : articles);

    if (availableCategories.isEmpty()) {
      availableCategories = usedCategories;
    }

    if (!availableCategories.isEmpty()) {
      magacinDto.setCategories(buildCategoryMap(availableCategories));
    }
  }

  public static void apply(MagacinDto magacinDto, List<ArticleRecord> articles) {
    apply(magacinDto, articles, null);
  }

  private static CategoryIndex buildCategoryIndex(List<ArticleRecord> articles) {
    Map<String, CategoryInfo> byManufacturer = new LinkedHashMap<>();
    Map<String, CategoryInfo> byNumberOnly = new LinkedHashMap<>();

    for (ArticleRecord article : articles.stream().filter(Objects::nonNull).toList()) {
      CategoryInfo category = extractCategory(article);
      if (category == null) {
        continue;
      }

      TecDocProizvodjaci manufacturer =
          TecDocProizvodjaci.pronadjiPoKljucu(article.getDataSupplierId());

      addNumber(
          byManufacturer,
          byNumberOnly,
          manufacturer,
          category,
          TecDocProizvodjaci.generateAlternativeCatalogNumber(
              article.getArticleNumber(), article.getDataSupplierId()));

      if (manufacturer != null && manufacturer.isUseTradeNumber()) {
        List<TradeNumberDetailsRecord> tradeDetails = article.getTradeNumbersDetails();
        if (tradeDetails != null) {
          tradeDetails.stream()
              .filter(Objects::nonNull)
              .filter(TradeNumberDetailsRecord::isIsImmediateDisplay)
              .map(TradeNumberDetailsRecord::getTradeNumber)
              .forEach(
                  tradeNumber ->
                      addNumber(
                          byManufacturer,
                          byNumberOnly,
                          manufacturer,
                          category,
                          TecDocProizvodjaci.generateAlternativeCatalogNumber(
                              tradeNumber, article.getDataSupplierId())));
        }
      }

      List<ArticleRefRecord> oemNumbers = article.getOemNumbers();
      if (oemNumbers != null) {
        oemNumbers.stream()
            .filter(Objects::nonNull)
            .map(ArticleRefRecord::getArticleNumber)
            .filter(StringUtils::hasText)
            .map(CatalogNumberUtils::cleanPreserveSeparators)
            .map(oe -> oe.concat("-OE"))
            .forEach(
                oeNumber ->
                    addNumber(byManufacturer, byNumberOnly, manufacturer, category, oeNumber));
      }
    }

    return new CategoryIndex(byManufacturer, byNumberOnly);
  }

  private static Set<CategoryInfo> extractCategories(List<ArticleRecord> articles) {
    if (articles == null || articles.isEmpty()) {
      return Set.of();
    }

    Set<CategoryInfo> categories = new LinkedHashSet<>();
    articles.stream()
        .filter(Objects::nonNull)
        .map(TecDocCategoryMapper::extractCategory)
        .filter(Objects::nonNull)
        .forEach(categories::add);

    return categories;
  }

  private static void addNumber(
      Map<String, CategoryInfo> byManufacturer,
      Map<String, CategoryInfo> byNumberOnly,
      TecDocProizvodjaci manufacturer,
      CategoryInfo category,
      String rawNumber) {
    String cleaned = CatalogNumberUtils.cleanPreserveSeparators(rawNumber);
    if (!StringUtils.hasText(cleaned)) {
      return;
    }

    byNumberOnly.putIfAbsent(cleaned, category);
    if (manufacturer != null) {
      String key = buildKey(manufacturer.getCleanName(), cleaned);
      byManufacturer.putIfAbsent(key, category);
    }
  }

  private static CategoryInfo extractCategory(ArticleRecord article) {
    List<GenericArticleRecord> genericArticles = article.getGenericArticles();
    if (genericArticles == null || genericArticles.isEmpty()) {
      return null;
    }

    GenericArticleRecord primary = genericArticles.get(0);
    if (primary == null) {
      return null;
    }

    String groupName =
        StringUtils.hasText(primary.getAssemblyGroupName())
            ? primary.getAssemblyGroupName()
            : "TecDoc";
    String subGroupName = firstNonBlank(primary.getGenericArticleDescription());

    if (!StringUtils.hasText(subGroupName)) {
      return null;
    }

    return new CategoryInfo(groupName, primary.getGenericArticleId(), subGroupName);
  }

  private static CategoryInfo resolveCategoryForProduct(RobaLightDto robaDto, CategoryIndex index) {
    if (robaDto == null) {
      return null;
    }

    TecDocProizvodjaci manufacturer =
        TecDocProizvodjaci.findByName(
            robaDto.getProizvodjac() != null ? robaDto.getProizvodjac().getProid() : null);

    CategoryInfo byKatBr = index.find(manufacturer, robaDto.getKatbr());
    if (byKatBr != null) {
      return byKatBr;
    }

    return index.find(manufacturer, robaDto.getKatbrpro());
  }

  private static void applyCategory(RobaLightDto robaDto, CategoryInfo category) {
    robaDto.setGrupa(category.getGroupName());
    robaDto.setGrupaNaziv(category.getGroupName());
    robaDto.setPodGrupa(category.getSubGroupId());
    robaDto.setPodGrupaNaziv(category.getSubGroupName());
  }

  private static Map<String, List<PodgrupaDto>> buildCategoryMap(Set<CategoryInfo> usedCategories) {
    Map<String, List<PodgrupaDto>> categories = new LinkedHashMap<>();

    for (CategoryInfo category : usedCategories) {
      List<PodgrupaDto> subGroups =
          categories.computeIfAbsent(category.getGroupName(), key -> new java.util.ArrayList<>());

      boolean exists =
          subGroups.stream().anyMatch(dto -> Objects.equals(dto.getId(), category.getSubGroupId()));

      if (!exists) {
        PodgrupaDto dto = new PodgrupaDto();
        dto.setId(category.getSubGroupId());
        dto.setNaziv(category.getSubGroupName());
        dto.setGrupa(category.getGroupName());
        subGroups.add(dto);
      }
    }

    return categories;
  }

  private static String firstNonBlank(String... values) {
    if (values == null) {
      return null;
    }
    for (String value : values) {
      if (StringUtils.hasText(value)) {
        return value;
      }
    }
    return null;
  }

  private static String buildKey(String manufacturer, String number) {
    return manufacturer + "|" + number;
  }

  private static final class CategoryInfo {
    private final String groupName;
    private final Integer subGroupId;
    private final String subGroupName;

    CategoryInfo(String groupName, Integer subGroupId, String subGroupName) {
      this.groupName = groupName;
      this.subGroupId = subGroupId;
      this.subGroupName = subGroupName;
    }

    public String getGroupName() {
      return groupName;
    }

    public Integer getSubGroupId() {
      return subGroupId;
    }

    public String getSubGroupName() {
      return subGroupName;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      CategoryInfo that = (CategoryInfo) o;
      return Objects.equals(groupName, that.groupName)
          && Objects.equals(subGroupId, that.subGroupId)
          && Objects.equals(subGroupName, that.subGroupName);
    }

    @Override
    public int hashCode() {
      return Objects.hash(groupName, subGroupId, subGroupName);
    }
  }

  private static final class CategoryIndex {
    private final Map<String, CategoryInfo> byManufacturer;
    private final Map<String, CategoryInfo> byNumberOnly;

    CategoryIndex(
        Map<String, CategoryInfo> byManufacturer, Map<String, CategoryInfo> byNumberOnly) {
      this.byManufacturer = byManufacturer;
      this.byNumberOnly = byNumberOnly;
    }

    boolean isEmpty() {
      return byManufacturer.isEmpty() && byNumberOnly.isEmpty();
    }

    CategoryInfo find(TecDocProizvodjaci manufacturer, String number) {
      String cleaned = CatalogNumberUtils.cleanPreserveSeparators(number);
      if (!StringUtils.hasText(cleaned)) {
        return null;
      }

      if (manufacturer != null) {
        CategoryInfo scoped =
            byManufacturer.get(manufacturer.getCleanName().concat("|").concat(cleaned));
        if (scoped != null) {
          return scoped;
        }
      }

      return byNumberOnly.get(cleaned);
    }
  }
}
