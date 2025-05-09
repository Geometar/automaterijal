package com.automaterijal.application.services.roba.search;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.adapter.RobaAdapterService;
import com.automaterijal.application.services.roba.util.RobaHelper;
import com.automaterijal.application.tecdoc.*;
import com.automaterijal.application.utils.GeneralUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.SetUtils;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaSearchService {
  @NonNull final RobaAdapterService robaAdapter;
  @NonNull final TecDocService tecDocService;
  @NonNull final RobaHelper robaHelper;
  @NonNull final RobaAdapterService robaAdapterService;

  /** Main method for fetching associated articles with TecDoc data. */
  public MagacinDto getAssociatedArticles(
      Integer id,
      String type,
      String assembleGroupId,
      UniverzalniParametri parametri,
      Partner loggedPartner) {

    // 1. Fetch articles from TecDoc
    List<ArticleRecord> articles = fetchArticlesFromTecDoc(id, type, assembleGroupId);

    // 2. Generate all possible catalog numbers
    Set<String> catalogNumbers = generateCatalogNumbers(articles);

    // 3. Process trade numbers and OEM numbers
    processTradeNumbers(articles, catalogNumbers);
    processOemNumbers(articles, catalogNumbers);

    // 4. Fetch products using generated catalog numbers
    MagacinDto magacinDto =
        robaAdapterService.fetchProductsByTecDocArticles(catalogNumbers, parametri, articles);

    // 5. Apply TecDoc attributes to the fetched products
    if (!magacinDto.getRobaDto().isEmpty()) {
      applyTecDocAttributes(magacinDto, articles, loggedPartner);
    }

    return magacinDto;
  }

  /** Fetches articles from TecDoc API based on ID, type, and assembly group. */
  private List<ArticleRecord> fetchArticlesFromTecDoc(
      Integer id, String type, String assembleGroupId) {
    return tecDocService.getAssociatedArticles(id, type, assembleGroupId).getArticles().stream()
        .peek(
            article ->
                article.setArticleNumber(
                    GeneralUtil.cleanArticleNumber(article.getArticleNumber())))
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
    articles.forEach(
        article -> {
          if (!TecDocProizvodjaci.pronadjiPoKljucu(article.getDataSupplierId())
              .isUseTradeNumber()) {
            return;
          }

          Set<TradeNumberDetailsRecord> tradeRecords =
              article.getTradeNumbersDetails().stream()
                  .filter(TradeNumberDetailsRecord::isIsImmediateDisplay)
                  .collect(Collectors.toSet());

          if (SetUtils.isEmpty(tradeRecords)) return;

          tradeRecords.forEach(
              tradeNumber -> {
                String tradeNumberValue = tradeNumber.getTradeNumber();
                String generatedNumber =
                    TecDocProizvodjaci.generateAlternativeCatalogNumber(
                        tradeNumberValue, article.getDataSupplierId());
                catalogNumbers.add(generatedNumber);
              });
        });
  }

  /** Processes OEM numbers from TecDoc articles. */
  private void processOemNumbers(List<ArticleRecord> articles, Set<String> catalogNumbers) {
    articles.forEach(
        article ->
            catalogNumbers.addAll(
                article.getOemNumbers().stream()
                    .map(ArticleRefRecord::getArticleNumber)
                    .map(GeneralUtil::cleanArticleNumber)
                    .map(oe -> oe.concat("-OE"))
                    .collect(Collectors.toSet())));
  }

  /** Applies TecDoc attributes to the fetched products for the final response. */
  private void applyTecDocAttributes(
      MagacinDto magacinDto, List<ArticleRecord> articles, Partner loggedPartner) {
    tecDocService.batchVracanjeICuvanjeTDAtributa(magacinDto.getRobaDto().getContent());
    robaHelper.setupForTable(magacinDto.getRobaDto().getContent(), loggedPartner);
  }

  public MagacinDto searchProducts(UniverzalniParametri parametri, Partner ulogovaniPartner) {

    MagacinDto magacinDto =
        parametri.getTrazenaRec() != null
            ? searchProductsBySearchTerm(parametri)
            : robaAdapter.searchFilteredProductsWithoutSearchTerm(parametri);

    if (!magacinDto.getRobaDto().isEmpty()) {
      tecDocService.batchVracanjeICuvanjeTDAtributa(magacinDto.getRobaDto().getContent());
      robaHelper.setupForTable(magacinDto.getRobaDto().getContent(), ulogovaniPartner);
    }

    return magacinDto;
  }

  private MagacinDto searchProductsBySearchTerm(UniverzalniParametri parametri) {
    final Set<String> catalogNumbers = new HashSet<>();
    Set<Long> robaId = new HashSet<>();

    robaAdapter.searchProductsByCatalogNumber(catalogNumbers, robaId, parametri);
    if (!catalogNumbers.isEmpty()) {
      robaAdapter.fetchByAlternativeCatalogueNumber(catalogNumbers);
      robaAdapter.searchProductsByCatalogNumbersIn(catalogNumbers, robaId);
    }

    // Pokusaj pretrage pomocu naziva
    if (catalogNumbers.isEmpty()) {
      boolean found = robaAdapter.searchProductsByName(parametri, catalogNumbers, robaId);
      if (found) {
        return robaAdapter.searchProductsByIds(parametri, robaId);
      }
    }

    // Ukljucujemo tecdoc u pretragu
    searchUsingTecDoc(parametri, catalogNumbers);

    return robaAdapter.fetchSearchResultsByCatalogNumbersAndFilters(parametri, catalogNumbers);
  }

  private void searchUsingTecDoc(UniverzalniParametri parametri, Set<String> catalogNumbers) {

    // TecDoc pretraga na osnovu tačne reči, tip pretrage je 10 (trazimo sve)
    List<ArticleDirectSearchAllNumbersWithStateRecord> response =
        tecDocService.tecDocPretragaPoTrazenojReci(parametri.getTrazenaRec(), null, 10);

    // Process TecDoc search results
    catalogNumbers.addAll(
        generateAlternativeCatalogNumbers(
            response,
            ArticleDirectSearchAllNumbersWithStateRecord::getArticleNo,
            ArticleDirectSearchAllNumbersWithStateRecord::getBrandNo));

    // Dodavanje tačne tražene reči kao kataloškog broja
    catalogNumbers.add(parametri.getTrazenaRec());
  }

  /** Generic method to process article records and extract catalog numbers. */
  private <T> Set<String> generateAlternativeCatalogNumbers(
      List<T> records, Function<T, String> getArticleNo, Function<T, Long> getBrandNo) {
    return records.stream()
        .map(
            record -> {
              String katBr = getArticleNo.apply(record);
              return TecDocProizvodjaci.generateAlternativeCatalogNumber(
                  katBr, getBrandNo.apply(record));
            })
        .collect(Collectors.toSet());
  }

  private <T> Set<String> generateAlternativeCatalogNumbers(
      List<T> records, String articleNo, Long getBrandNo) {
    return records.stream()
        .map(
            record -> {
              return TecDocProizvodjaci.generateAlternativeCatalogNumber(articleNo, getBrandNo);
            })
        .collect(Collectors.toSet());
  }
}
