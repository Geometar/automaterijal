package com.automaterijal.application.services.roba.search;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.ArticleAvailabilityStatus;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.ProizvodjacDTO;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.ExternalOfferService;
import com.automaterijal.application.services.roba.RobaEnrichmentService;
import com.automaterijal.application.services.roba.adapter.RobaAdapterService;
import com.automaterijal.application.services.roba.grupe.ArticleSubGroupService;
import com.automaterijal.application.services.roba.sort.RobaSortService;
import com.automaterijal.application.services.tecdoc.TecDocGenericArticleMappingService;
import com.automaterijal.application.tecdoc.*;
import com.automaterijal.application.utils.CatalogNumberUtils;
import com.automaterijal.application.utils.GeneralUtil;
import java.util.ArrayList;
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
  private static final int MAX_TEC_DOC_RESULTS = 1000;
  private static final int TECDOC_NUMBER_TYPE_ALL = 10;

  @NonNull final RobaAdapterService robaAdapterService;
  @NonNull final TecDocService tecDocService;
  @NonNull final RobaEnrichmentService robaEnrichmentService;
  @NonNull final ExternalOfferService externalOfferService;
  @NonNull final TecDocGenericArticleMappingService tecDocGenericArticleMappingService;
  @NonNull final ArticleSubGroupService articleSubGroupService;
  @NonNull final RobaSortService robaSortService;

  /** Main method for fetching associated articles with TecDoc data. */
  public MagacinDto getAssociatedArticles(
      Integer id,
      String type,
      String assembleGroupId,
      UniverzalniParametri parametri,
      Partner loggedPartner) {

    UniverzalniParametri normalized =
        parametri != null ? parametri.normalizedCopy() : new UniverzalniParametri();

    // Sačuvaj originalni paging/filter vrednosti
    Integer originalPage = normalized.getPage() != null ? normalized.getPage() : 0;
    Integer originalPageSize =
        normalized.getPageSize() != null && normalized.getPageSize() > 0
            ? normalized.getPageSize()
            : Integer.MAX_VALUE;
    List<Integer> requestedSubGroups = normalized.getPodgrupeZaPretragu();
    boolean onlyAvailable = normalized.isDostupno();

    // Izbegni lokalni filter podgrupa dok ne mapiramo TecDoc kategorije
    UniverzalniParametri internalParams = normalized.copy();
    internalParams.setPage(0);
    internalParams.setPageSize(Integer.MAX_VALUE);
    internalParams.setPodgrupeZaPretragu(null);

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
        robaAdapterService.fetchProductsByTecDocArticles(catalogNumbers, internalParams, articles);

    // 4.1 Auto-observation: povezujemo TecDoc genericArticleId sa internim podgrupama kad postoji
    // lokalna roba
    if (magacinDto.getRobaDto() != null && !magacinDto.getRobaDto().isEmpty()) {
      tecDocGenericArticleMappingService.observeFromAssociatedArticles(
          articles, magacinDto.getRobaDto().getContent());
    }

    // 4.2 Primeni filter podgrupe lokalno (pre enrichment-a)
    List<RobaLightDto> items =
        magacinDto.getRobaDto() != null ? magacinDto.getRobaDto().getContent() : List.of();
    if (requestedSubGroups != null && !requestedSubGroups.isEmpty() && !items.isEmpty()) {
      items = items.stream().filter(r -> requestedSubGroups.contains(r.getPodGrupa())).toList();
    }
    List<RobaLightDto> itemsForCatalogKeys = items;

    if (onlyAvailable) {
      // Enrich full filtered set so we can filter by provider-backed availability
      if (!items.isEmpty()) {
        robaEnrichmentService.enrichLightDtos(items, loggedPartner);
        items =
            items.stream()
                .filter(dto -> dto != null && dto.getAvailabilityStatus() != null)
                .filter(
                    dto -> dto.getAvailabilityStatus() != ArticleAvailabilityStatus.OUT_OF_STOCK)
                .toList();
      }

      List<RobaLightDto> localKeyItems =
          itemsForCatalogKeys.stream()
              .filter(Objects::nonNull)
              .filter(r -> r.getRobaid() != null)
              .toList();
      MagacinDto localForKeys = new MagacinDto();
      localForKeys.setRobaDto(GeneralUtil.createPageable(localKeyItems, Integer.MAX_VALUE, 0));
      List<RobaLightDto> externals =
          externalOfferService.buildFromAssociatedTecDocArticles(
              articles, localForKeys, loggedPartner, normalized);

      List<RobaLightDto> combined = new ArrayList<>(items);
      combined.addAll(externals);
      combined = robaSortService.sortByGroup(combined);
      int pageSize = Math.max(1, originalPageSize);
      int page = Math.max(0, originalPage);
      magacinDto.setRobaDto(GeneralUtil.createPageable(combined, pageSize, page));

      // Rebuild categories as union of local + external (internal taxonomy)
      Set<Integer> union = new HashSet<>();
      combined.stream().filter(Objects::nonNull).map(RobaLightDto::getPodGrupa).forEach(union::add);
      magacinDto.setCategories(articleSubGroupService.buildCategoriesFromPodgrupaIds(union));

      magacinDto.setProizvodjaci(buildManufacturersFromItems(combined));
    } else {
      // Page first, then enrich only the returned page
      int pageSize = Math.max(1, originalPageSize);
      int page = Math.max(0, originalPage);
      magacinDto.setRobaDto(GeneralUtil.createPageable(items, pageSize, page));
      if (magacinDto.getRobaDto() != null && !magacinDto.getRobaDto().isEmpty()) {
        robaEnrichmentService.enrichLightDtos(magacinDto.getRobaDto().getContent(), loggedPartner);
      }
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

  public MagacinDto searchProducts(UniverzalniParametri parametri, Partner loggedPartner) {

    UniverzalniParametri normalized =
        parametri != null ? parametri.normalizedCopy() : new UniverzalniParametri();

    Integer originalPage = normalized.getPage() != null ? normalized.getPage() : 0;
    Integer originalPageSize =
        normalized.getPageSize() != null && normalized.getPageSize() > 0
            ? normalized.getPageSize()
            : 10;
    boolean onlyAvailable = normalized.isDostupno();
    boolean hasSearchTerm = StringUtils.hasText(normalized.getTrazenaRec());
    boolean includeExternalOffers = hasSearchTerm;

    if (includeExternalOffers) {
      return searchProductsBySearchTermWithExternalOffers(
          normalized, loggedPartner, originalPage, originalPageSize, onlyAvailable);
    }

    UniverzalniParametri internal = normalized;
    if (onlyAvailable) {
      internal = normalized.copy();
      internal.setPage(0);
      internal.setPageSize(Integer.MAX_VALUE);
      internal.setPaged(false);
      internal.setNaStanju(false);
    }

    MagacinDto magacinDto =
        hasSearchTerm
            ? searchProductsBySearchTerm(internal)
            : robaAdapterService.searchFilteredProductsWithoutSearchTerm(internal);

    List<RobaLightDto> itemsForCatalogKeys =
        magacinDto.getRobaDto() != null ? magacinDto.getRobaDto().getContent() : List.of();

    if (onlyAvailable && magacinDto.getRobaDto() != null) {
      if (!itemsForCatalogKeys.isEmpty()) {
        robaEnrichmentService.applyPriceOnly(itemsForCatalogKeys, loggedPartner);
      }

      List<RobaLightDto> localAvailable =
          magacinDto.getRobaDto().getContent().stream()
              .filter(dto -> dto != null && dto.getAvailabilityStatus() != null)
              .filter(dto -> dto.getAvailabilityStatus() != ArticleAvailabilityStatus.OUT_OF_STOCK)
              .toList();

      List<RobaLightDto> combined = new ArrayList<>(localAvailable);

      combined = robaSortService.sortByGroup(combined);
      magacinDto.setRobaDto(GeneralUtil.createPageable(combined, originalPageSize, originalPage));

      if (magacinDto.getRobaDto() != null && !magacinDto.getRobaDto().isEmpty()) {
        robaEnrichmentService.enrichLightDtos(magacinDto.getRobaDto().getContent(), loggedPartner);
      }

      Set<Integer> union = new HashSet<>();
      combined.stream().filter(Objects::nonNull).map(RobaLightDto::getPodGrupa).forEach(union::add);
      magacinDto.setCategories(articleSubGroupService.buildCategoriesFromPodgrupaIds(union));

      magacinDto.setProizvodjaci(buildManufacturersFromItems(combined));
    } else if (magacinDto.getRobaDto() != null && !magacinDto.getRobaDto().isEmpty()) {
      robaEnrichmentService.enrichLightDtos(magacinDto.getRobaDto().getContent(), loggedPartner);
    }

    return magacinDto;
  }

  private MagacinDto searchProductsBySearchTermWithExternalOffers(
      UniverzalniParametri normalized,
      Partner loggedPartner,
      Integer originalPage,
      Integer originalPageSize,
      boolean onlyAvailable) {
    UniverzalniParametri allLocalParams = normalized.copy();
    allLocalParams.setPage(0);
    allLocalParams.setPageSize(Integer.MAX_VALUE);
    allLocalParams.setPaged(false);

    List<ArticleDirectSearchAllNumbersWithStateRecord> tecDoc =
        tecDocService.tecDocPretragaPoTrazenojReci(
            normalized.getTrazenaRec(), null, TECDOC_NUMBER_TYPE_ALL);

    MagacinDto localAll = searchProductsBySearchTerm(allLocalParams, tecDoc);
    List<RobaLightDto> allLocalItems =
        localAll.getRobaDto() != null ? localAll.getRobaDto().getContent() : List.of();

    List<RobaLightDto> visibleLocalItems = allLocalItems;
    if (onlyAvailable && !allLocalItems.isEmpty()) {
      robaEnrichmentService.applyPriceOnly(allLocalItems, loggedPartner);
      visibleLocalItems =
          allLocalItems.stream()
              .filter(dto -> dto != null && dto.getAvailabilityStatus() != null)
              .filter(dto -> dto.getAvailabilityStatus() != ArticleAvailabilityStatus.OUT_OF_STOCK)
              .toList();
    }

    tecDocGenericArticleMappingService.observeFromDirectSearch(tecDoc, allLocalItems);

    MagacinDto localForKeys = new MagacinDto();
    localForKeys.setRobaDto(GeneralUtil.createPageable(allLocalItems, Integer.MAX_VALUE, 0));

    List<RobaLightDto> externals =
        externalOfferService.buildFromTecDocSearch(tecDoc, localForKeys, loggedPartner, normalized);

    List<RobaLightDto> combined = new ArrayList<>(visibleLocalItems);
    combined.addAll(externals);
    combined = robaSortService.sortByGroup(combined);

    MagacinDto out = new MagacinDto();
    out.setRobaDto(GeneralUtil.createPageable(combined, originalPageSize, originalPage));

    if (out.getRobaDto() != null && !out.getRobaDto().isEmpty()) {
      robaEnrichmentService.enrichLightDtos(out.getRobaDto().getContent(), loggedPartner);
    }

    Set<Integer> union = new HashSet<>();
    combined.stream().filter(Objects::nonNull).map(RobaLightDto::getPodGrupa).forEach(union::add);
    out.setCategories(articleSubGroupService.buildCategoriesFromPodgrupaIds(union));
    out.setProizvodjaci(buildManufacturersFromItems(combined));

    return out;
  }

  private MagacinDto searchProductsBySearchTerm(UniverzalniParametri parametri) {
    if (!StringUtils.hasText(parametri.getTrazenaRec())) {
      return robaAdapterService.searchFilteredProductsWithoutSearchTerm(parametri);
    }

    SearchCandidates candidates = collectSearchCandidates(parametri);
    if (candidates.matchedByName()) {
      return robaAdapterService.searchProductsByIds(parametri, candidates.productIds());
    }

    return robaAdapterService.fetchSearchResultsByCatalogNumbersAndFilters(
        parametri, candidates.catalogNumbers());
  }

  private MagacinDto searchProductsBySearchTerm(
      UniverzalniParametri parametri, List<ArticleDirectSearchAllNumbersWithStateRecord> tecDoc) {
    if (!StringUtils.hasText(parametri.getTrazenaRec())) {
      return robaAdapterService.searchFilteredProductsWithoutSearchTerm(parametri);
    }

    SearchCandidates candidates = collectSearchCandidates(parametri, tecDoc);
    if (candidates.matchedByName()) {
      return robaAdapterService.searchProductsByIds(parametri, candidates.productIds());
    }

    return robaAdapterService.fetchSearchResultsByCatalogNumbersAndFilters(
        parametri, candidates.catalogNumbers());
  }

  private SearchCandidates collectSearchCandidates(UniverzalniParametri parametri) {
    Set<String> catalogNumbers = new HashSet<>();
    Set<Long> productIds = new HashSet<>();

    boolean matchedByName =
        robaAdapterService.searchProductsByName(parametri, catalogNumbers, productIds);
    if (matchedByName) {
      return new SearchCandidates(catalogNumbers, productIds, true);
    }

    collectLocalCatalogNumberCandidates(parametri, catalogNumbers, productIds);
    addTecDocCatalogCandidates(parametri, catalogNumbers);

    return new SearchCandidates(catalogNumbers, productIds, false);
  }

  private SearchCandidates collectSearchCandidates(
      UniverzalniParametri parametri, List<ArticleDirectSearchAllNumbersWithStateRecord> tecDoc) {
    Set<String> catalogNumbers = new HashSet<>();
    Set<Long> productIds = new HashSet<>();

    boolean matchedByName =
        robaAdapterService.searchProductsByName(parametri, catalogNumbers, productIds);
    if (matchedByName) {
      return new SearchCandidates(catalogNumbers, productIds, true);
    }

    collectLocalCatalogNumberCandidates(parametri, catalogNumbers, productIds);
    addTecDocCatalogCandidatesFromResponse(parametri.getTrazenaRec(), tecDoc, catalogNumbers);

    return new SearchCandidates(catalogNumbers, productIds, false);
  }

  private void collectLocalCatalogNumberCandidates(
      UniverzalniParametri parametri, Set<String> catalogNumbers, Set<Long> productIds) {
    robaAdapterService.searchProductsByCatalogNumber(catalogNumbers, productIds, parametri);
    if (catalogNumbers.isEmpty()) {
      return;
    }

    robaAdapterService.fetchByAlternativeCatalogueNumber(catalogNumbers);
    robaAdapterService.searchProductsByCatalogNumbersIn(catalogNumbers, productIds);
  }

  private void addTecDocCatalogCandidates(
      UniverzalniParametri parametri, Set<String> catalogNumbers) {
    String searchTerm = parametri.getTrazenaRec();
    if (!StringUtils.hasText(searchTerm)) {
      return;
    }

    // TecDoc pretraga na osnovu tačne reči, tip pretrage je 10 (trazimo sve)
    List<ArticleDirectSearchAllNumbersWithStateRecord> response =
        tecDocService.tecDocPretragaPoTrazenojReci(searchTerm, null, TECDOC_NUMBER_TYPE_ALL);

    addTecDocCatalogCandidatesFromResponse(searchTerm, response, catalogNumbers);
  }

  private void addTecDocCatalogCandidatesFromResponse(
      String searchTerm,
      List<ArticleDirectSearchAllNumbersWithStateRecord> response,
      Set<String> catalogNumbers) {
    if (!StringUtils.hasText(searchTerm) || catalogNumbers == null) {
      return;
    }

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

  private record SearchCandidates(
      Set<String> catalogNumbers, Set<Long> productIds, boolean matchedByName) {}

  private List<ProizvodjacDTO> buildManufacturersFromItems(List<RobaLightDto> items) {
    if (items == null || items.isEmpty()) {
      return List.of();
    }
    Map<String, ProizvodjacDTO> byId = new java.util.LinkedHashMap<>();
    for (RobaLightDto dto : items) {
      if (dto == null
          || dto.getProizvodjac() == null
          || !StringUtils.hasText(dto.getProizvodjac().getProid())) {
        continue;
      }
      String key = dto.getProizvodjac().getProid();
      byId.putIfAbsent(key, dto.getProizvodjac());
    }
    return new ArrayList<>(byId.values());
  }
}
