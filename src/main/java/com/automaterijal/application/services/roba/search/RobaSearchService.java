package com.automaterijal.application.services.roba.search;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.dto.PodgrupaDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.RobaEnrichmentService;
import com.automaterijal.application.services.roba.adapter.RobaAdapterService;
import com.automaterijal.application.services.roba.util.TecDocCategoryMapper;
import com.automaterijal.application.tecdoc.*;
import com.automaterijal.application.utils.CatalogNumberUtils;
import com.automaterijal.application.utils.GeneralUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
  @NonNull final RobaEnrichmentService robaEnrichmentService;

  /** Main method for fetching associated articles with TecDoc data. */
  public MagacinDto getAssociatedArticles(
      Integer id,
      String type,
      String assembleGroupId,
      UniverzalniParametri parametri,
      Partner loggedPartner) {

    // Sačuvaj originalni paging/filter vrednosti
    Integer originalPage = parametri.getPage() != null ? parametri.getPage() : 0;
    Integer originalPageSize =
        parametri.getPageSize() != null && parametri.getPageSize() > 0
            ? parametri.getPageSize()
            : Integer.MAX_VALUE;
    List<Integer> requestedSubGroups = parametri.getPodgrupeZaPretragu();

    // Izbegni lokalni filter podgrupa dok ne mapiramo TecDoc kategorije
    parametri.setPage(0);
    parametri.setPageSize(Integer.MAX_VALUE);
    parametri.setPodgrupeZaPretragu(null);

    // 1. Fetch TecDoc response (bez genericArticleIds da uzmemo sve kategorije)
    ArticlesResponse response = tecDocService.getAssociatedArticles(id, type, assembleGroupId);
    List<ArticleRecord> articles = extractArticles(response);

    // 2. Generate all possible catalog numbers
    Set<String> catalogNumbers = generateCatalogNumbers(articles);

    // 3. Process trade numbers and OEM numbers
    processTradeNumbers(articles, catalogNumbers);
    processOemNumbers(articles, catalogNumbers);

    // 4. Fetch products using generated catalog numbers
    MagacinDto magacinDto =
        robaAdapterService.fetchProductsByTecDocArticles(catalogNumbers, parametri, articles);

    // 4.1 Overwrite group/subgroup using TecDoc categories (only for this API)
    TecDocCategoryMapper.apply(magacinDto, articles);

    // 4.2 Izgradi kategorije iz TecDoc genericArticle faceta (flat pod jednom grupom)
    magacinDto.setCategories(buildCategoriesFromFacets(response));

    // 4.2 Primeni filter podgrupe lokalno nakon mapiranja i vrati paging
    if (magacinDto.getRobaDto() != null) {
      List<RobaLightDto> items = magacinDto.getRobaDto().getContent();

      if (requestedSubGroups != null && !requestedSubGroups.isEmpty()) {
        items =
            items.stream()
                .filter(r -> requestedSubGroups.contains(r.getPodGrupa()))
                .toList();
      }

      int pageSize = Math.max(1, originalPageSize);
      int page = Math.max(0, originalPage);
      magacinDto.setRobaDto(GeneralUtil.createPageable(items, pageSize, page));
    }

    // 5. Apply TecDoc attributes to the fetched products
    if (!magacinDto.getRobaDto().isEmpty()) {
      applyTecDocAttributes(magacinDto, loggedPartner);
    }

    return magacinDto;
  }

  private List<ArticleRecord> extractArticles(ArticlesResponse response) {
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
    robaEnrichmentService.enrichLightDtos(magacinDto.getRobaDto().getContent(), loggedPartner);
  }

  private Map<String, List<PodgrupaDto>> buildCategoriesFromFacets(ArticlesResponse response) {
    GenericArticleFacetCounts facets =
        response != null ? response.getGenericArticleFacets() : null;
    if (facets == null || facets.getCounts() == null) {
      return Map.of();
    }

    List<PodgrupaDto> subGroups =
        facets.getCounts().stream()
            .filter(Objects::nonNull)
            .map(
                count -> {
                  PodgrupaDto dto = new PodgrupaDto();
                  dto.setId(count.getGenericArticleId());
                  dto.setNaziv(count.getGenericArticleDescription());
                  dto.setGrupa("SVE");
                  return dto;
                })
            .collect(Collectors.toList());

    return Map.of("SVE", subGroups);
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
      applyTecDocAttributes(magacinDto, ulogovaniPartner);
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
