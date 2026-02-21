package com.automaterijal.application.services.roba.search;

import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.ArticleAvailabilityStatus;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.ProizvodjacDTO;
import com.automaterijal.application.domain.dto.ProviderAvailabilityDto;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.entity.Partner;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.integration.providers.szakal.SzakalOeSearchService;
import com.automaterijal.application.integration.providers.szakal.SzakalProperties;
import com.automaterijal.application.integration.shared.ProviderRoutingPurpose;
import com.automaterijal.application.services.TecDocService;
import com.automaterijal.application.services.roba.ExternalOfferService;
import com.automaterijal.application.services.roba.ExternalOfferService.ExternalOfferPayload;
import com.automaterijal.application.services.roba.ProviderPricingService;
import com.automaterijal.application.services.roba.RobaEnrichmentService;
import com.automaterijal.application.services.roba.adapter.RobaAdapterService;
import com.automaterijal.application.services.roba.grupe.ArticleSubGroupService;
import com.automaterijal.application.services.roba.sort.RobaSortService;
import com.automaterijal.application.services.tecdoc.TecDocGenericArticleMappingService;
import com.automaterijal.application.tecdoc.*;
import com.automaterijal.application.utils.CatalogNumberUtils;
import com.automaterijal.application.utils.GeneralUtil;
import com.automaterijal.application.utils.PartnerPrivilegeUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.thymeleaf.util.SetUtils;


@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaSearchService {
  private static final int MAX_TEC_DOC_RESULTS = 1000;
  private static final int TECDOC_NUMBER_TYPE_ALL = 10;
  private static final int MAX_OE_FALLBACK_NUMBERS = 200;
  private static final int MAX_OE_FALLBACK_RESULTS = 50;

  @Value("${roba.search.max-provider-items:20}")
  int maxProviderItems;

  @NonNull final RobaAdapterService robaAdapterService;
  @NonNull final TecDocService tecDocService;
  @NonNull final RobaEnrichmentService robaEnrichmentService;
  @NonNull final ExternalOfferService externalOfferService;
  @NonNull final TecDocGenericArticleMappingService tecDocGenericArticleMappingService;
  @NonNull final ArticleSubGroupService articleSubGroupService;
  @NonNull final RobaSortService robaSortService;
  @NonNull final SzakalOeSearchService szakalOeSearchService;
  @NonNull final SzakalProperties szakalProperties;
  @NonNull final ProviderPricingService providerPricingService;

  /** Main method for fetching associated articles with TecDoc data. */
  public MagacinDto getAssociatedArticles(
      Integer id,
      String type,
      String assembleGroupId,
      UniverzalniParametri parametri,
      Partner loggedPartner) {

    UniverzalniParametri normalized =
        parametri != null ? parametri.normalizedCopy() : new UniverzalniParametri();

    long associatedStartedAt = System.currentTimeMillis();

    // Sačuvaj originalni paging/filter vrednosti
    Integer originalPage = normalized.getPage() != null ? normalized.getPage() : 0;
    Integer originalPageSize =
        normalized.getPageSize() != null && normalized.getPageSize() > 0
            ? normalized.getPageSize()
            : Integer.MAX_VALUE;
    List<Integer> requestedSubGroups = normalized.getPodgrupeZaPretragu();
    boolean filterAvailable = normalized.isNaStanju();

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
    if (filterAvailable && !items.isEmpty()) {
      // Ensure availability filtering sees price-adjusted local stock state.
      robaEnrichmentService.applyPriceOnly(items, loggedPartner, false);
    }
    List<RobaLightDto> itemsForCatalogKeys = items;

    List<RobaLightDto> localKeyItems =
        itemsForCatalogKeys.stream()
            .filter(Objects::nonNull)
            .filter(r -> r.getRobaid() != null)
            .toList();
    MagacinDto localForKeys = new MagacinDto();
    localForKeys.setRobaDto(GeneralUtil.createPageable(localKeyItems, Integer.MAX_VALUE, 0));
    ExternalOfferPayload externalPayload =
        externalOfferService.prepareFromAssociatedTecDocArticles(
            articles, localForKeys, loggedPartner, normalized);

    List<RobaLightDto> providerTargets = collectProviderTargets(items, externalPayload.getProbes());
    ProviderCounts counts = resolveProviderCounts(items);
    if (!providerTargets.isEmpty()) {
      robaEnrichmentService.populateExternalAvailability(
          providerTargets,
          loggedPartner,
          ProviderRoutingPurpose.EXTERNAL_OFFER,
          counts.matchCount(),
          counts.availableCount());
      robaEnrichmentService.refreshAvailabilityStatus(items);
    }

    List<RobaLightDto> externals =
        externalOfferService.materializeExternalOffers(externalPayload, normalized);
    // OE fallback je namerno iskljucen za vehicle/associated tok.
    // Koristi se samo kod explicit search-term pretrage.
    List<RobaLightDto> oeFallback = List.of();

    if (filterAvailable) {
      List<RobaLightDto> filteredItems =
          items.stream()
              .filter(dto -> dto != null && dto.getAvailabilityStatus() != null)
              .filter(dto -> dto.getAvailabilityStatus() != ArticleAvailabilityStatus.OUT_OF_STOCK)
              .toList();

      List<RobaLightDto> combined = new ArrayList<>(filteredItems);
      combined.addAll(externals);
      combined.addAll(oeFallback);
      combined =
          StringUtils.hasText(normalized.getTrazenaRec())
              ? robaSortService.sortByGroupWithExact(combined, normalized.getTrazenaRec())
              : robaSortService.sortByGroup(combined);
      int pageSize = Math.max(1, originalPageSize);
      int page = Math.max(0, originalPage);
      magacinDto.setRobaDto(GeneralUtil.createPageable(combined, pageSize, page));
      if (magacinDto.getRobaDto() != null && !magacinDto.getRobaDto().isEmpty()) {
        robaEnrichmentService.enrichLightDtos(
            magacinDto.getRobaDto().getContent(), loggedPartner, false);
      }

      Set<Integer> union = new HashSet<>();
      combined.stream().filter(Objects::nonNull).map(RobaLightDto::getPodGrupa).forEach(union::add);
      magacinDto.setCategories(articleSubGroupService.buildCategoriesFromPodgrupaIds(union));
      magacinDto.setProizvodjaci(buildManufacturersFromItems(combined));
    } else {
      Set<String> externalKeys = buildExternalKeys(externals);

      List<RobaLightDto> combined =
          new ArrayList<>(
              items.stream()
                  .filter(
                      dto ->
                          dto == null
                              || dto.getRobaid() != null
                              || dto.getProizvodjac() == null
                              || !StringUtils.hasText(dto.getKatbr())
                              || !StringUtils.hasText(dto.getProizvodjac().getProid())
                              || !externalKeys.contains(
                                  dto.getProizvodjac().getProid().trim().toUpperCase(Locale.ROOT)
                                      + ":"
                                      + normalizeCatalog(dto.getKatbr())))
                  .toList());
      combined.addAll(externals);
      combined.addAll(oeFallback);

      combined =
          StringUtils.hasText(normalized.getTrazenaRec())
              ? robaSortService.sortByGroupWithExact(combined, normalized.getTrazenaRec())
              : robaSortService.sortByGroup(combined);

      int pageSize = Math.max(1, originalPageSize);
      int page = Math.max(0, originalPage);
      magacinDto.setRobaDto(GeneralUtil.createPageable(combined, pageSize, page));
      if (magacinDto.getRobaDto() != null && !magacinDto.getRobaDto().isEmpty()) {
        robaEnrichmentService.enrichLightDtos(
            magacinDto.getRobaDto().getContent(), loggedPartner, false);
      }

      Set<Integer> union = new HashSet<>();
      combined.stream().filter(Objects::nonNull).map(RobaLightDto::getPodGrupa).forEach(union::add);
      magacinDto.setCategories(articleSubGroupService.buildCategoriesFromPodgrupaIds(union));
      magacinDto.setProizvodjaci(buildManufacturersFromItems(combined));
    }
    log.info(
        "Roba search perf: flow=associated, page={}, pageSize={}, filterAvailable={}, requestedSubgroups={}, localItems={}, externalItems={}, oeFallbackItems={}, resultItems={}, tookMs={}",
        originalPage,
        originalPageSize,
        filterAvailable,
        requestedSubGroups != null ? requestedSubGroups.size() : 0,
        items != null ? items.size() : 0,
        externals != null ? externals.size() : 0,
        oeFallback != null ? oeFallback.size() : 0,
        magacinDto.getRobaDto() != null ? magacinDto.getRobaDto().getNumberOfElements() : 0,
        System.currentTimeMillis() - associatedStartedAt);

    return magacinDto;
  }

  private String normalizeCatalog(String value) {
    return StringUtils.hasText(value)
        ? CatalogNumberUtils.cleanPreserveSeparators(value.trim())
        : "";
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

  private List<RobaLightDto> buildOeFallbackFromArticles(
      List<ArticleRecord> articles, Partner partner, List<RobaLightDto> existing) {
    if (articles == null || articles.isEmpty()) {
      return List.of();
    }
    List<String> oeNumbers = new ArrayList<>();
    for (ArticleRecord article : articles) {
      if (article == null || article.getOemNumbers() == null) {
        continue;
      }
      for (ArticleRefRecord ref : article.getOemNumbers()) {
        if (ref == null || !StringUtils.hasText(ref.getArticleNumber())) {
          continue;
        }
        String normalized = CatalogNumberUtils.cleanPreserveSeparators(ref.getArticleNumber());
        if (StringUtils.hasText(normalized)) {
          oeNumbers.add(normalized);
        }
      }
    }
    return buildOeFallbackOffers(oeNumbers, partner, existing, Set.of());
  }

  private List<RobaLightDto> buildOeFallbackFromSearchTerm(
      String searchTerm,
      Partner partner,
      List<RobaLightDto> existing,
      Set<String> excludedBrandKeys) {
    if (!looksLikeOe(searchTerm)) {
      return List.of();
    }
    return buildOeFallbackOffers(List.of(searchTerm), partner, existing, excludedBrandKeys);
  }

  private boolean looksLikeOe(String value) {
    if (!StringUtils.hasText(value)) {
      return false;
    }
    String normalized = value.replaceAll("[^A-Za-z0-9]", "");
    if (normalized.length() < 4) {
      return false;
    }
    return normalized.chars().anyMatch(Character::isDigit);
  }

  private boolean shouldUseOeFallbackForSearchTerm(String searchTerm, int availableRegularOffers) {
    int threshold =
        szakalProperties.getSearch() != null
                && szakalProperties.getSearch().getOeFallbackMinAvailable() != null
            ? Math.max(0, szakalProperties.getSearch().getOeFallbackMinAvailable())
            : 2;

    return looksLikeOe(searchTerm) && availableRegularOffers <= threshold;
  }

  private int countAvailableOffers(List<RobaLightDto> localItems, List<RobaLightDto> externalItems) {
    long local =
        localItems == null ? 0 : localItems.stream().filter(this::isAvailable).count();
    long external =
        externalItems == null ? 0 : externalItems.stream().filter(this::isAvailable).count();
    return Math.toIntExact(local + external);
  }

  private List<RobaLightDto> buildOeFallbackOffers(
      List<String> oeNumbers,
      Partner partner,
      List<RobaLightDto> existing,
      Set<String> excludedBrandKeys) {
    if (oeNumbers == null || oeNumbers.isEmpty()) {
      return List.of();
    }
    List<String> limited = new ArrayList<>();
    Set<String> seenNumbers = new HashSet<>();
    for (String oe : oeNumbers) {
      if (!StringUtils.hasText(oe)) {
        continue;
      }
      if (!seenNumbers.add(oe)) {
        continue;
      }
      if (limited.size() >= MAX_OE_FALLBACK_NUMBERS) {
        break;
      }
      limited.add(oe);
    }
    if (limited.isEmpty()) {
      return List.of();
    }

    List<SzakalOeSearchService.OeSearchResult> matches = new ArrayList<>();
    for (String oe : limited) {
      matches.addAll(szakalOeSearchService.searchByOe(oe));
      if (matches.size() >= MAX_OE_FALLBACK_RESULTS) {
        break;
      }
    }

    if (matches.isEmpty()) {
      return List.of();
    }

    List<RobaLightDto> results = new ArrayList<>();
    HashSet<String> seen = new HashSet<>(collectProviderGlids(existing));
    for (SzakalOeSearchService.OeSearchResult match : matches) {
      if (match == null || !StringUtils.hasText(match.glid())) {
        continue;
      }
      if (isExcludedTecDocBrand(match, excludedBrandKeys)) {
        continue;
      }
      if (seen.contains(match.glid())) {
        continue;
      }
      RobaLightDto dto = mapOeFallback(match, partner);
      if (dto != null) {
        results.add(dto);
        seen.add(match.glid());
      }
      if (results.size() >= MAX_OE_FALLBACK_RESULTS) {
        break;
      }
    }
    return results;
  }

  private List<String> collectProviderGlids(List<RobaLightDto> items) {
    if (items == null || items.isEmpty()) {
      return List.of();
    }
    List<String> glids = new ArrayList<>();
    for (RobaLightDto dto : items) {
      if (dto == null || dto.getProviderAvailability() == null) {
        continue;
      }
      String glid = dto.getProviderAvailability().getProviderProductId();
      if (StringUtils.hasText(glid)) {
        glids.add(glid);
      }
    }
    return glids;
  }

  private RobaLightDto mapOeFallback(
      SzakalOeSearchService.OeSearchResult match, Partner partner) {
    if (match == null) {
      return null;
    }
    String name =
        StringUtils.hasText(match.nameRs())
            ? match.nameRs()
            : (StringUtils.hasText(match.nameEn()) ? match.nameEn() : "OE match");

    String brandName =
        StringUtils.hasText(match.brandName())
            ? match.brandName()
            : (StringUtils.hasText(match.maker()) ? match.maker() : "SZAKAL");
    String brandKey = brandName.trim().toUpperCase(Locale.ROOT);

    ProizvodjacDTO manufacturer = new ProizvodjacDTO();
    manufacturer.setProid(brandKey);
    manufacturer.setNaziv(brandName.trim());

    String displayNumber =
        StringUtils.hasText(match.articleCodeNorm())
            ? match.articleCodeNorm()
            : (StringUtils.hasText(match.tecdocArtnrNorm())
                ? match.tecdocArtnrNorm()
                : (StringUtils.hasText(match.oe()) ? match.oe() : match.oeShort()));

    ProviderAvailabilityDto availability =
        ProviderAvailabilityDto.builder()
            .brand(brandKey)
            .provider("szakal")
            .articleNumber(displayNumber)
            .available(true)
            .totalQuantity(match.stock())
            .warehouse(match.listNo() != null ? "PL" + match.listNo() : null)
            .warehouseName(szakalProperties.getWarehouseName())
            .warehouseQuantity(match.stock())
            .purchasePrice(match.unitPrice())
            .currency(szakalProperties.getCurrency())
            .packagingUnit(match.quantum())
            .leadTimeBusinessDays(match.leadTimeDays())
            .deliveryToCustomerBusinessDaysMin(szakalProperties.getDeliveryToCustomerBusinessDaysMin())
            .deliveryToCustomerBusinessDaysMax(szakalProperties.getDeliveryToCustomerBusinessDaysMax())
            .nextDispatchCutoff(match.orderDeadline())
            .providerProductId(match.glid())
            .providerStockToken(match.token())
            .providerNoReturnable(match.notReturnable())
            .build();

    BigDecimal customerPrice =
        providerPricingService.calculateCustomerPrice(availability, null, brandKey, partner);
    availability.setPrice(customerPrice);
    if (!PartnerPrivilegeUtils.isInternal(partner)) {
      availability.setPurchasePrice(null);
    }

    RobaLightDto dto = new RobaLightDto();
    dto.setRobaid(null);
    dto.setKatbr(displayNumber);
    dto.setKatbrpro(null);
    dto.setNaziv(name);
    dto.setProizvodjac(manufacturer);
    dto.setGrupa(ArticleSubGroupService.OE_FALLBACK_GRUPA);
    dto.setGrupaNaziv(ArticleSubGroupService.OE_FALLBACK_GRUPA);
    dto.setPodGrupa(ArticleSubGroupService.OE_FALLBACK_PODGRUPA_ID);
    dto.setPodGrupaNaziv(ArticleSubGroupService.OE_FALLBACK_GRUPA);
    dto.setStanje(0);
    dto.setProviderAvailability(availability);
    dto.setCena(customerPrice);
    dto.setAvailabilityStatus(ArticleAvailabilityStatus.AVAILABLE);
    return dto;
  }

  public MagacinDto searchProducts(
      UniverzalniParametri parametri, Partner loggedPartner, boolean skipProvider) {

    UniverzalniParametri normalized =
        parametri != null ? parametri.normalizedCopy() : new UniverzalniParametri();

    Integer originalPage = normalized.getPage() != null ? normalized.getPage() : 0;
    Integer originalPageSize =
        normalized.getPageSize() != null && normalized.getPageSize() > 0
            ? normalized.getPageSize()
            : 10;
    boolean filterAvailable = normalized.isNaStanju();
    boolean hasSearchTerm = StringUtils.hasText(normalized.getTrazenaRec());
    boolean includeExternalOffers = hasSearchTerm && !skipProvider;

    long regularStartedAt = System.currentTimeMillis();

    if (includeExternalOffers) {
      return searchProductsBySearchTermWithExternalOffers(
          normalized, loggedPartner, originalPage, originalPageSize, filterAvailable);
    }

    UniverzalniParametri internal = normalized;
    if (filterAvailable) {
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

    List<RobaLightDto> items =
        magacinDto.getRobaDto() != null ? magacinDto.getRobaDto().getContent() : List.of();
    if (filterAvailable && !items.isEmpty()) {
      // When filtering by availability, pre-warm price-based stock before status filtering.
      robaEnrichmentService.applyPriceOnly(items, loggedPartner, false);
    }
    ProviderCounts counts = resolveProviderCounts(items);
    if (!skipProvider) {
      List<RobaLightDto> providerTargets = collectProviderTargets(items, List.of());
      if (!providerTargets.isEmpty()) {
        robaEnrichmentService.populateExternalAvailability(
            providerTargets,
            loggedPartner,
            ProviderRoutingPurpose.INVENTORY_ENRICHMENT,
            counts.matchCount(),
            counts.availableCount());
        robaEnrichmentService.refreshAvailabilityStatus(items);
      }
    }

    if (filterAvailable && magacinDto.getRobaDto() != null) {
      List<RobaLightDto> localAvailable =
          items.stream()
              .filter(dto -> dto != null && dto.getAvailabilityStatus() != null)
              .filter(dto -> dto.getAvailabilityStatus() != ArticleAvailabilityStatus.OUT_OF_STOCK)
              .toList();

      List<RobaLightDto> combined = new ArrayList<>(localAvailable);

      combined =
          hasSearchTerm
              ? robaSortService.sortByGroupWithExact(combined, normalized.getTrazenaRec())
              : robaSortService.sortByGroup(combined);
      magacinDto.setRobaDto(GeneralUtil.createPageable(combined, originalPageSize, originalPage));

      if (magacinDto.getRobaDto() != null && !magacinDto.getRobaDto().isEmpty()) {
        robaEnrichmentService.enrichLightDtos(
            magacinDto.getRobaDto().getContent(), loggedPartner, false);
      }

      Set<Integer> union = new HashSet<>();
      combined.stream().filter(Objects::nonNull).map(RobaLightDto::getPodGrupa).forEach(union::add);
      magacinDto.setCategories(articleSubGroupService.buildCategoriesFromPodgrupaIds(union));

      magacinDto.setProizvodjaci(buildManufacturersFromItems(combined));
    } else if (magacinDto.getRobaDto() != null && !magacinDto.getRobaDto().isEmpty()) {
      robaEnrichmentService.enrichLightDtos(
          magacinDto.getRobaDto().getContent(), loggedPartner, false);
    }

    log.info(
        "Roba search perf: flow=regular, hasSearchTerm={}, filterAvailable={}, skipProvider={}, page={}, pageSize={}, localItems={}, resultItems={}, tookMs={}",
        hasSearchTerm,
        filterAvailable,
        skipProvider,
        originalPage,
        originalPageSize,
        items != null ? items.size() : 0,
        magacinDto.getRobaDto() != null ? magacinDto.getRobaDto().getNumberOfElements() : 0,
        System.currentTimeMillis() - regularStartedAt);

    return magacinDto;
  }

  public MagacinDto searchProducts(UniverzalniParametri parametri, Partner loggedPartner) {
    return searchProducts(parametri, loggedPartner, false);
  }

  private MagacinDto searchProductsBySearchTermWithExternalOffers(
      UniverzalniParametri normalized,
      Partner loggedPartner,
      Integer originalPage,
      Integer originalPageSize,
      boolean filterAvailable) {
    UniverzalniParametri allLocalParams = normalized.copy();
    allLocalParams.setPage(0);
    allLocalParams.setPageSize(Integer.MAX_VALUE);
    allLocalParams.setPaged(false);
    boolean hasSearchTerm = StringUtils.hasText(normalized.getTrazenaRec());

    long externalStartedAt = System.currentTimeMillis();

    List<ArticleDirectSearchAllNumbersWithStateRecord> tecDoc =
        tecDocService.tecDocPretragaPoTrazenojReci(
            normalized.getTrazenaRec(), null, TECDOC_NUMBER_TYPE_ALL);
    Set<String> tecDocBrandKeys = resolveTecDocBrandKeys(tecDoc);

    MagacinDto localAll = searchProductsBySearchTerm(allLocalParams, tecDoc);
    List<RobaLightDto> allLocalItems =
        localAll.getRobaDto() != null ? localAll.getRobaDto().getContent() : List.of();
    if (filterAvailable && !allLocalItems.isEmpty()) {
      // Keep naStanju correctness for full-scope local set before provider merge.
      robaEnrichmentService.applyPriceOnly(allLocalItems, loggedPartner, false);
    }

    long localFetchMs = System.currentTimeMillis() - externalStartedAt;

    tecDocGenericArticleMappingService.observeFromDirectSearch(tecDoc, allLocalItems);

    MagacinDto localForKeys = new MagacinDto();
    localForKeys.setRobaDto(GeneralUtil.createPageable(allLocalItems, Integer.MAX_VALUE, 0));

    long providerStageStartedAt = System.currentTimeMillis();

    ExternalOfferPayload externalPayload =
        externalOfferService.prepareFromTecDocSearch(
            tecDoc, localForKeys, loggedPartner, normalized);

    List<RobaLightDto> providerTargets =
        collectProviderTargets(allLocalItems, externalPayload.getProbes());
    ProviderCounts counts = resolveProviderCounts(allLocalItems);
    if (!providerTargets.isEmpty()) {
      robaEnrichmentService.populateExternalAvailability(
          providerTargets,
          loggedPartner,
          ProviderRoutingPurpose.EXTERNAL_OFFER,
          counts.matchCount(),
          counts.availableCount());
      robaEnrichmentService.refreshAvailabilityStatus(allLocalItems);
    }

    long providerStageMs = System.currentTimeMillis() - providerStageStartedAt;

    long mergeStageStartedAt = System.currentTimeMillis();
    List<RobaLightDto> visibleLocalItems = allLocalItems;
    if (filterAvailable) {
      visibleLocalItems =
          allLocalItems.stream()
              .filter(dto -> dto != null && dto.getAvailabilityStatus() != null)
              .filter(dto -> dto.getAvailabilityStatus() != ArticleAvailabilityStatus.OUT_OF_STOCK)
              .toList();
    }

    List<RobaLightDto> externals =
        externalOfferService.materializeExternalOffers(externalPayload, normalized);

    int availableRegularOffers = countAvailableOffers(visibleLocalItems, externals);
    boolean useOeFallback =
        shouldUseOeFallbackForSearchTerm(normalized.getTrazenaRec(), availableRegularOffers);

    List<RobaLightDto> oeFallback =
        useOeFallback
            ? buildOeFallbackFromSearchTerm(
                normalized.getTrazenaRec(), loggedPartner, externals, tecDocBrandKeys)
            : List.of();

    List<RobaLightDto> combined = new ArrayList<>(visibleLocalItems);
    combined.addAll(externals);
    combined.addAll(oeFallback);

    if (useOeFallback && shouldExpandOeFromTecDoc(normalized, tecDoc, combined)) {
      List<RobaLightDto> oeExpansion =
          buildOeExpansionFromTecDoc(
              tecDoc,
              loggedPartner,
              combined,
              szakalProperties.getSearch().getOeExpansionMaxOe(),
              szakalProperties.getSearch().getOeExpansionMaxResults(),
              tecDocBrandKeys);
      combined.addAll(oeExpansion);
    }

    combined =
        StringUtils.hasText(normalized.getTrazenaRec())
            ? robaSortService.sortByGroupWithExact(combined, normalized.getTrazenaRec())
            : robaSortService.sortByGroup(combined);

    MagacinDto out = new MagacinDto();
    out.setRobaDto(GeneralUtil.createPageable(combined, originalPageSize, originalPage));

    long mergeStageMs = System.currentTimeMillis() - mergeStageStartedAt;
    long finalPageEnrichMs = 0L;

    if (out.getRobaDto() != null && !out.getRobaDto().isEmpty()) {
      long finalPageEnrichStartedAt = System.currentTimeMillis();
      robaEnrichmentService.enrichLightDtos(out.getRobaDto().getContent(), loggedPartner, false);
      finalPageEnrichMs = System.currentTimeMillis() - finalPageEnrichStartedAt;
    }

    Set<Integer> union = new HashSet<>();
    combined.stream().filter(Objects::nonNull).map(RobaLightDto::getPodGrupa).forEach(union::add);
    out.setCategories(articleSubGroupService.buildCategoriesFromPodgrupaIds(union));
    out.setProizvodjaci(buildManufacturersFromItems(combined));

    log.info(
        "Roba search perf: flow=external-search, hasSearchTerm={}, filterAvailable={}, page={}, pageSize={}, localItems={}, visibleLocalItems={}, externalItems={}, oeFallbackItems={}, resultItems={}, localFetchMs={}, providerStageMs={}, mergeStageMs={}, finalPageEnrichMs={}, tookMs={}",
        hasSearchTerm,
        filterAvailable,
        originalPage,
        originalPageSize,
        allLocalItems.size(),
        visibleLocalItems.size(),
        externals.size(),
        oeFallback.size(),
        out.getRobaDto() != null ? out.getRobaDto().getNumberOfElements() : 0,
        localFetchMs,
        providerStageMs,
        mergeStageMs,
        finalPageEnrichMs,
        System.currentTimeMillis() - externalStartedAt);

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

  private ProviderCounts resolveProviderCounts(List<RobaLightDto> items) {
    if (items == null || items.isEmpty()) {
      return new ProviderCounts(0, 0);
    }
    int matchCount = items.size();
    int availableCount =
        (int) items.stream().filter(Objects::nonNull).filter(dto -> dto.getStanje() > 0).count();
    return new ProviderCounts(matchCount, availableCount);
  }

  private boolean shouldExpandOeFromTecDoc(
      UniverzalniParametri parametri,
      List<ArticleDirectSearchAllNumbersWithStateRecord> tecDoc,
      List<RobaLightDto> combined) {
    if (!isOeExpansionAllowed(parametri)) {
      return false;
    }
    if (tecDoc == null || tecDoc.isEmpty()) {
      return false;
    }
    if (szakalProperties.getSearch() == null
        || !szakalProperties.getSearch().isOeExpansionEnabled()) {
      return false;
    }
    Integer threshold = szakalProperties.getSearch().getOeExpansionMinAvailable();
    int minAvailable = threshold != null ? threshold : 0;
    return countAvailable(combined) < minAvailable;
  }

  private boolean isOeExpansionAllowed(UniverzalniParametri parametri) {
    if (parametri == null) {
      return false;
    }
    UniverzalniParametri.FilterByType filterByType = parametri.resolveFilterByType();
    if (filterByType != null
        && filterByType != UniverzalniParametri.FilterByType.NONE
        && filterByType != UniverzalniParametri.FilterByType.SEARCH_TERM) {
      return false;
    }
    List<String> manufacturers = parametri.resolveProizvodjac();
    if (manufacturers != null && !manufacturers.isEmpty()) {
      return false;
    }
    if (parametri.getGrupa() != null && !parametri.getGrupa().isEmpty()) {
      return false;
    }
    if (parametri.getPodgrupeZaPretragu() != null && !parametri.getPodgrupeZaPretragu().isEmpty()) {
      return false;
    }
    return true;
  }

  private int countAvailable(List<RobaLightDto> items) {
    if (items == null || items.isEmpty()) {
      return 0;
    }
    int count = 0;
    for (RobaLightDto dto : items) {
      if (isAvailable(dto)) {
        count++;
      }
    }
    return count;
  }

  private boolean isAvailable(RobaLightDto dto) {
    if (dto == null) {
      return false;
    }
    if (dto.getAvailabilityStatus() != null) {
      return dto.getAvailabilityStatus() != ArticleAvailabilityStatus.OUT_OF_STOCK;
    }
    ProviderAvailabilityDto availability = dto.getProviderAvailability();
    if (availability != null) {
      if (Boolean.TRUE.equals(availability.getAvailable())) {
        return true;
      }
      if (availability.getTotalQuantity() != null && availability.getTotalQuantity() > 0) {
        return true;
      }
      if (availability.getWarehouseQuantity() != null && availability.getWarehouseQuantity() > 0) {
        return true;
      }
    }
    return dto.getStanje() > 0;
  }

  private List<RobaLightDto> buildOeExpansionFromTecDoc(
      List<ArticleDirectSearchAllNumbersWithStateRecord> tecDoc,
      Partner partner,
      List<RobaLightDto> existing,
      Integer maxOeNumbers,
      Integer maxResults,
      Set<String> excludedBrandKeys) {
    if (tecDoc == null || tecDoc.isEmpty()) {
      return List.of();
    }
    int oeLimit = maxOeNumbers != null ? maxOeNumbers : 0;
    int resultLimit = maxResults != null ? maxResults : 0;
    if (oeLimit <= 0 || resultLimit <= 0) {
      return List.of();
    }

    List<SzakalOeSearchService.TecdocKey> keys = new ArrayList<>();
    Set<String> seenKeys = new HashSet<>();
    for (ArticleDirectSearchAllNumbersWithStateRecord record : tecDoc) {
      if (record == null) {
        continue;
      }
      String articleNo = record.getArticleNo();
      Long brandNo = record.getBrandNo();
      String normalized =
          StringUtils.hasText(articleNo)
              ? CatalogNumberUtils.cleanPreserveSeparators(articleNo)
              : null;
      if (!StringUtils.hasText(normalized) || brandNo == null) {
        continue;
      }
      String key = brandNo + ":" + normalized;
      if (!seenKeys.add(key)) {
        continue;
      }
      keys.add(new SzakalOeSearchService.TecdocKey(brandNo, normalized));
      if (keys.size() >= MAX_TEC_DOC_RESULTS) {
        break;
      }
    }
    if (keys.isEmpty()) {
      return List.of();
    }

    List<SzakalOeSearchService.OeSearchResult> matches =
        szakalOeSearchService.searchByTecdocKeys(keys, oeLimit, resultLimit);
    if (matches.isEmpty()) {
      return List.of();
    }

    List<RobaLightDto> results = new ArrayList<>();
    HashSet<String> seen = new HashSet<>(collectProviderGlids(existing));
    for (SzakalOeSearchService.OeSearchResult match : matches) {
      if (match == null || !StringUtils.hasText(match.glid())) {
        continue;
      }
      if (isExcludedTecDocBrand(match, excludedBrandKeys)) {
        continue;
      }
      if (seen.contains(match.glid())) {
        continue;
      }
      RobaLightDto dto = mapOeFallback(match, partner);
      if (dto != null) {
        results.add(dto);
        seen.add(match.glid());
      }
      if (results.size() >= resultLimit) {
        break;
      }
    }
    return results;
  }

  private List<RobaLightDto> collectProviderTargets(
      List<RobaLightDto> locals, List<RobaLightDto> externalProbes) {
    List<RobaLightDto> targets = new ArrayList<>();
    if (externalProbes != null) {
      for (RobaLightDto probe : externalProbes) {
        if (probe != null) {
          targets.add(probe);
        }
      }
    }

    int limit = maxProviderItems > 0 ? maxProviderItems : Integer.MAX_VALUE;
    int remaining = limit - targets.size();
    if (remaining <= 0) {
      return targets;
    }

    if (locals != null) {
      for (RobaLightDto dto : locals) {
        if (remaining <= 0) {
          break;
        }
        if (dto == null || dto.getStanje() > 0) {
          continue;
        }
        targets.add(dto);
        remaining--;
      }
      for (RobaLightDto dto : locals) {
        if (remaining <= 0) {
          break;
        }
        if (!shouldIncludeInStockProviderLookup(dto)) {
          continue;
        }
        targets.add(dto);
        remaining--;
      }
    }

    return targets;
  }

  private Set<String> buildExternalKeys(List<RobaLightDto> externals) {
    if (externals == null || externals.isEmpty()) {
      return Set.of();
    }
    Set<String> externalKeys = new HashSet<>();
    for (RobaLightDto dto : externals) {
      if (dto == null || dto.getProizvodjac() == null || !StringUtils.hasText(dto.getKatbr())) {
        continue;
      }
      String brand =
          StringUtils.hasText(dto.getProizvodjac().getProid())
              ? dto.getProizvodjac().getProid().trim().toUpperCase(Locale.ROOT)
              : null;
      if (!StringUtils.hasText(brand)) {
        continue;
      }
      externalKeys.add(brand + ":" + normalizeCatalog(dto.getKatbr()));
    }
    return externalKeys;
  }

  private boolean shouldIncludeInStockProviderLookup(RobaLightDto dto) {
    return dto != null && dto.getStanje() > 0;
  }


  private Set<String> resolveTecDocBrandKeys(
      List<ArticleDirectSearchAllNumbersWithStateRecord> tecDoc) {
    if (tecDoc == null || tecDoc.isEmpty()) {
      return Set.of();
    }
    Set<String> keys = new HashSet<>();
    for (ArticleDirectSearchAllNumbersWithStateRecord record : tecDoc) {
      if (record == null) {
        continue;
      }
      if (record.getBrandNo() != null) {
        TecDocProizvodjaci manufacturer = TecDocProizvodjaci.pronadjiPoKljucu(record.getBrandNo());
        if (manufacturer != null) {
          String enumKey = normalizeBrandKey(manufacturer.getCleanName());
          if (StringUtils.hasText(enumKey)) {
            keys.add(enumKey);
          }
        }
      }
      String byName = normalizeBrandKey(record.getBrandName());
      if (StringUtils.hasText(byName)) {
        keys.add(byName);
      }
    }
    return keys;
  }

  private boolean isExcludedTecDocBrand(
      SzakalOeSearchService.OeSearchResult match, Set<String> excludedBrandKeys) {
    if (match == null || excludedBrandKeys == null || excludedBrandKeys.isEmpty()) {
      return false;
    }
    String brandName = normalizeBrandKey(match.brandName());
    if (StringUtils.hasText(brandName) && excludedBrandKeys.contains(brandName)) {
      return true;
    }
    String makerName = normalizeBrandKey(match.maker());
    return StringUtils.hasText(makerName) && excludedBrandKeys.contains(makerName);
  }

  private String normalizeBrandKey(String value) {
    if (!StringUtils.hasText(value)) {
      return null;
    }
    String normalized = value.replaceAll("[^A-Za-z0-9]", "").toUpperCase(Locale.ROOT);
    return StringUtils.hasText(normalized) ? normalized : null;
  }

  private record ProviderCounts(int matchCount, int availableCount) {}

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
