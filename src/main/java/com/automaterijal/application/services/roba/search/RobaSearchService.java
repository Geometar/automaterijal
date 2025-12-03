package com.automaterijal.application.services.roba.search;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.adapter.RobaAdapterService;
import com.automaterijal.application.services.roba.util.TecDocCategoryMapper;
import com.automaterijal.application.services.roba.util.RobaHelper;
import com.automaterijal.application.tecdoc.*;
import com.automaterijal.application.utils.CatalogNumberUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.thymeleaf.util.SetUtils;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaSearchService {
  private static final int MAX_TEC_DOC_RESULTS = 500;

  @NonNull final RobaAdapterService robaAdapterService;
  @NonNull final TecDocService tecDocService;
  @NonNull final RobaHelper robaHelper;

  /** Main method for fetching associated articles with TecDoc data. */
  public MagacinDto getAssociatedArticles(
      Integer id,
      String type,
      String assembleGroupId,
      UniverzalniParametri parametri,
      Partner loggedPartner) {

    List<Integer> genericArticleIds = parametri.getPodgrupeZaPretragu();
    boolean hasSubGroupFilter = genericArticleIds != null && !genericArticleIds.isEmpty();

    // 1. Fetch TecDoc articles: full set for categories, filtered set for products
    List<ArticleRecord> categoryArticles =
        fetchArticlesFromTecDoc(id, type, assembleGroupId, null);
    List<ArticleRecord> articles =
        hasSubGroupFilter
            ? fetchArticlesFromTecDoc(id, type, assembleGroupId, genericArticleIds)
            : categoryArticles;

    // 2. Generate all possible catalog numbers
    Set<String> catalogNumbers = generateCatalogNumbers(articles);

    // 3. Process trade numbers and OEM numbers
    processTradeNumbers(articles, catalogNumbers);
    processOemNumbers(articles, catalogNumbers);

    // 3.1 Avoid local sub-group filtering; rely on TecDoc genericArticleIds for this endpoint
    parametri.setPodgrupeZaPretragu(null);

    // 4. Fetch products using generated catalog numbers
    MagacinDto magacinDto =
        robaAdapterService.fetchProductsByTecDocArticles(catalogNumbers, parametri, articles);

    // 4.1 Overwrite group/subgroup using TecDoc categories (only for this API)
    TecDocCategoryMapper.apply(magacinDto, articles, categoryArticles);

    // 5. Apply TecDoc attributes to the fetched products
    if (!magacinDto.getRobaDto().isEmpty()) {
      applyTecDocAttributes(magacinDto, loggedPartner);
    }

    return magacinDto;
  }

  /** Fetches articles from TecDoc API based on ID, type, and assembly group. */
  private List<ArticleRecord> fetchArticlesFromTecDoc(
      Integer id, String type, String assembleGroupId, List<Integer> genericArticleIds) {
    var response = tecDocService.getAssociatedArticles(id, type, assembleGroupId, genericArticleIds);
    if (response == null || response.getArticles() == null) {
      return List.of();
    }

    return response.getArticles().stream()
        .filter(article -> article != null && article.getArticleNumber() != null)
        .peek(
            article ->
                article.setArticleNumber(
                    CatalogNumberUtils.cleanPreserveSeparators(article.getArticleNumber())))
        .collect(Collectors.toList());
  }

  /** Generates catalog numbers for the given articles. */
  private Set<String> generateCatalogNumbers(List<ArticleRecord> articles) {
    return articles.stream()
        .map(
            article ->
                TecDocProizvodjaci.generateAlternativeCatalogNumber(
                    article.getArticleNumber(), article.getDataSupplierId()))
        .collect(Collectors.toSet());
  }

  /** Processes trade numbers (alternative numbers) from TecDoc articles. */
  private void processTradeNumbers(List<ArticleRecord> articles, Set<String> catalogNumbers) {
    articles.stream()
        .filter(Objects::nonNull)
        .forEach(
            article -> {
              var manufacturer = TecDocProizvodjaci.pronadjiPoKljucu(article.getDataSupplierId());
              if (manufacturer == null || !manufacturer.isUseTradeNumber()) {
                return;
              }

              var tradeDetails = article.getTradeNumbersDetails();
              if (tradeDetails == null || tradeDetails.isEmpty()) {
                return;
              }

              Set<TradeNumberDetailsRecord> tradeRecords =
                  tradeDetails.stream()
                      .filter(record -> record != null && record.isIsImmediateDisplay())
                      .collect(Collectors.toSet());

              if (SetUtils.isEmpty(tradeRecords)) {
                return;
              }

              tradeRecords.stream()
                  .map(TradeNumberDetailsRecord::getTradeNumber)
                  .filter(StringUtils::hasText)
                  .map(
                      number ->
                          TecDocProizvodjaci.generateAlternativeCatalogNumber(
                              number, article.getDataSupplierId()))
                  .forEach(catalogNumbers::add);
            });
  }

  /** Processes OEM numbers from TecDoc articles. */
  private void processOemNumbers(List<ArticleRecord> articles, Set<String> catalogNumbers) {
    articles.stream()
        .filter(article -> article != null && article.getOemNumbers() != null)
        .forEach(
            article ->
                article.getOemNumbers().stream()
                    .filter(Objects::nonNull)
                    .map(ArticleRefRecord::getArticleNumber)
                    .filter(StringUtils::hasText)
                    .map(CatalogNumberUtils::cleanPreserveSeparators)
                    .map(oe -> oe.concat("-OE"))
                    .forEach(catalogNumbers::add));
  }

  /** Applies TecDoc attributes to the fetched products for the final response. */
  private void applyTecDocAttributes(MagacinDto magacinDto, Partner loggedPartner) {
    tecDocService.batchVracanjeICuvanjeTDAtributa(magacinDto.getRobaDto().getContent());
    robaHelper.setupForTable(magacinDto.getRobaDto().getContent(), loggedPartner);
  }

  public MagacinDto searchProducts(UniverzalniParametri parametri, Partner ulogovaniPartner) {

    String rawSearchTerm = parametri.getTrazenaRec();
    if (StringUtils.hasText(rawSearchTerm)) {
      parametri.setTrazenaRec(rawSearchTerm.trim());
    }

    MagacinDto magacinDto =
        StringUtils.hasText(parametri.getTrazenaRec())
            ? searchProductsBySearchTerm(parametri)
            : robaAdapterService.searchFilteredProductsWithoutSearchTerm(parametri);

    if (!magacinDto.getRobaDto().isEmpty()) {
      tecDocService.batchVracanjeICuvanjeTDAtributa(magacinDto.getRobaDto().getContent());
      robaHelper.setupForTable(magacinDto.getRobaDto().getContent(), ulogovaniPartner);
    }


    return magacinDto;
  }

  private MagacinDto searchProductsBySearchTerm(UniverzalniParametri parametri) {
    if (!StringUtils.hasText(parametri.getTrazenaRec())) {
      return robaAdapterService.searchFilteredProductsWithoutSearchTerm(parametri);
    }

    final Set<String> catalogNumbers = new HashSet<>();
    Set<Long> robaId = new HashSet<>();

    boolean found = robaAdapterService.searchProductsByName(parametri, catalogNumbers, robaId);
    if (found) {
      return robaAdapterService.searchProductsByIds(parametri, robaId);
    }

    robaAdapterService.searchProductsByCatalogNumber(catalogNumbers, robaId, parametri);
    if (!catalogNumbers.isEmpty()) {
      robaAdapterService.fetchByAlternativeCatalogueNumber(catalogNumbers);
      robaAdapterService.searchProductsByCatalogNumbersIn(catalogNumbers, robaId);
    }

    // Ukljucujemo tecdoc u pretragu
    searchUsingTecDoc(parametri, catalogNumbers);
    return robaAdapterService.fetchSearchResultsByCatalogNumbersAndFilters(parametri, catalogNumbers);
  }

  private void searchUsingTecDoc(UniverzalniParametri parametri, Set<String> catalogNumbers) {
    String searchTerm = parametri.getTrazenaRec();
    if (!StringUtils.hasText(searchTerm)) {
      return;
    }


    // TecDoc pretraga na osnovu tačne reči, tip pretrage je 10 (trazimo sve)
    List<ArticleDirectSearchAllNumbersWithStateRecord> response =
        tecDocService.tecDocPretragaPoTrazenojReci(searchTerm, null, 10);

    // Process TecDoc search results
    Set<String> tecDocNumbers =
        generateAlternativeCatalogNumbers(
            response,
            ArticleDirectSearchAllNumbersWithStateRecord::getArticleNo,
            ArticleDirectSearchAllNumbersWithStateRecord::getBrandNo);
    addWithLimit(catalogNumbers, tecDocNumbers);

    if (catalogNumbers.size() < MAX_TEC_DOC_RESULTS) {
      catalogNumbers.add(searchTerm);
    }

  }

  /** Generic method to process article records and extract catalog numbers. */
  private <T> Set<String> generateAlternativeCatalogNumbers(
      List<T> records, Function<T, String> getArticleNo, Function<T, Long> getBrandNo) {
    if (records == null || records.isEmpty()) {
      return Set.of();
    }

    return records.stream()
        .filter(Objects::nonNull)
        .map(
            record -> {
              String katBr = getArticleNo.apply(record);
              Long brandId = getBrandNo.apply(record);
              if (!StringUtils.hasText(katBr) || brandId == null) {
                return null;
              }
              return TecDocProizvodjaci.generateAlternativeCatalogNumber(katBr, brandId);
            })
        .filter(StringUtils::hasText)
        .collect(Collectors.toSet());
  }

  private void addWithLimit(Set<String> target, Set<String> additions) {
    if (additions == null || additions.isEmpty()) {
      return;
    }

    int allowed = MAX_TEC_DOC_RESULTS - target.size();
    if (allowed <= 0) {
      return;
    }

    for (String value : additions) {
      if (!StringUtils.hasText(value)) {
        continue;
      }
      target.add(value);
      if (--allowed <= 0) {
        break;
      }
    }
  }
}
