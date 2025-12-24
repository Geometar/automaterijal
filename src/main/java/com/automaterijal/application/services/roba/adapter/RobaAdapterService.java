package com.automaterijal.application.services.roba.adapter;

import static com.automaterijal.db.tables.Roba.ROBA;

import com.automaterijal.application.domain.cache.RobaCache;
import com.automaterijal.application.domain.dto.*;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.domain.repository.roba.RobaJooqRepository;
import com.automaterijal.application.services.ProizvodjacService;
import com.automaterijal.application.services.roba.cache.RobaCacheService;
import com.automaterijal.application.services.roba.filter.RobaFilterService;
import com.automaterijal.application.services.roba.grupe.ArticleSubGroupService;
import com.automaterijal.application.services.roba.processor.RobaTecDocProcessor;
import com.automaterijal.application.services.roba.repo.RobaDatabaseService;
import com.automaterijal.application.services.roba.sort.RobaSortService;
import com.automaterijal.application.tecdoc.ArticleRecord;
import com.automaterijal.application.utils.CatalogNumberUtils;
import com.automaterijal.application.utils.CriteriaBuilder;
import com.automaterijal.application.utils.GeneralUtil;
import java.text.Normalizer;
import java.util.*;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaAdapterService {

  // Database services
  @Autowired RobaDatabaseService robaDatabaseService;
  @Autowired RobaCacheService robaCachedService;
  @Autowired RobaJooqRepository robaJooqRepository;

  // Roba services
  @Autowired RobaTecDocProcessor robaTecDocProcessor;
  @Autowired RobaSortService robaSortService;
  @Autowired RobaFilterService robaFilterService;

  // Misc
  @Autowired ArticleSubGroupService articleSubGroupService;
  @Autowired ProizvodjacService proizvodjacService;

  /**
   * Ulazna metoda iz glavnog servisa kad je pretraga po RobaId (za sad to znaci da je pretraga po
   * reci)
   */
  public MagacinDto searchProductsByIds(UniverzalniParametri parametri, Set<Long> robaIds) {
    MagacinDto magacinDto = new MagacinDto();

    List<RobaLightDto> roba = robaJooqRepository.vratiRobuPoRobiId(robaIds);

    articleSubGroupService.popuniPodgrupe(magacinDto, roba);
    proizvodjacService.popuniProizvodjace(roba, magacinDto, parametri);

    // Primeni filtere po proizvođaču i grupi ako je potrebno
    roba = robaFilterService.applyOptionalFilters(parametri, roba);

    // Sortiraj robu po grupi ako kategorija nije zadana
    roba = robaSortService.sortByGroup(roba);

    int start = parametri.getPageSize() * parametri.getPage();
    int end = Math.min((start + parametri.getPageSize()), roba.size());

    magacinDto.setRobaDto(
        new PageImpl<>(
            roba.subList(start, end),
            PageRequest.of(parametri.getPage(), parametri.getPageSize()),
            roba.size()));

    return magacinDto;
  }

  /** Ulazna metoda iz glavnog servisa */
  public MagacinDto searchFilteredProductsWithoutSearchTerm(UniverzalniParametri parametri) {
    MagacinDto magacinDto = new MagacinDto();
    Condition condition = buildBaseCondition(parametri);
    PagingContext paging = PagingContext.from(parametri);
    boolean showcase = parametri.isShowcase();

    List<RobaLightDto> roba = fetchProducts(parametri, condition, paging);

    if (!showcase) {
      populateGroupsAndManufacturers(magacinDto, parametri, roba);
    }

    roba = prepareRoba(parametri, roba);

    if (showcase) {
      proizvodjacService.popuniProizvodjace(roba, magacinDto, parametri);
    }

    PageImpl<RobaLightDto> page = buildPage(parametri, condition, paging, roba, showcase);
    magacinDto.setRobaDto(page);

    return magacinDto;
  }

  private Condition buildBaseCondition(UniverzalniParametri parametri) {
    CriteriaBuilder criteriaBuilder = CriteriaBuilder.init();
    return criteriaBuilder.build();
  }

  private List<RobaLightDto> fetchProducts(
      UniverzalniParametri parametri, Condition condition, PagingContext paging) {
    if (paging.enabled()) {
      return robaJooqRepository.generic(parametri, condition, paging.pageSize(), paging.offset());
    }
    return robaJooqRepository.generic(parametri, condition);
  }

  private void populateGroupsAndManufacturers(
      MagacinDto magacinDto, UniverzalniParametri parametri, List<RobaLightDto> roba) {
    articleSubGroupService.popuniPodgrupe(magacinDto, roba);
    proizvodjacService.popuniProizvodjace(roba, magacinDto, parametri);
  }

  private List<RobaLightDto> prepareRoba(UniverzalniParametri parametri, List<RobaLightDto> roba) {
    List<RobaLightDto> filtered = robaFilterService.applyOptionalFilters(parametri, roba);
    return robaSortService.sortByGroup(filtered);
  }

  private PageImpl<RobaLightDto> buildPage(
      UniverzalniParametri parametri,
      Condition condition,
      PagingContext paging,
      List<RobaLightDto> roba,
      boolean showcase) {
    if (paging.enabled() && !showcase) {
      long total = robaJooqRepository.count(parametri, condition);
      return new PageImpl<>(roba, PageRequest.of(paging.page(), paging.pageSize()), total);
    }

    long total = roba.size();
    int pageSize = paging.resolvePageSize(total);
    int fromIndex = Math.min(paging.page() * pageSize, roba.size());
    int toIndex = Math.min(fromIndex + pageSize, roba.size());
    List<RobaLightDto> pageContent = roba.subList(fromIndex, toIndex);

    return new PageImpl<>(pageContent, PageRequest.of(paging.page(), pageSize), total);
  }

  public MagacinDto fetchSearchResultsByCatalogNumbersAndFilters(
      UniverzalniParametri parametri, Set<String> kataloskiBrojevi) {
    MagacinDto magacinDto = new MagacinDto();
    List<RobaLightDto> allRoba = new ArrayList<>();

    List<RobaCache> robaCache = robaCachedService.getAllRobaFilteredByKatBr(kataloskiBrojevi);
    allRoba.addAll(robaDatabaseService.findByPrimaryKeyFromCache(robaCache));

    allRoba = robaFilterService.applyMandatoryFilters(parametri, allRoba);

    // Popuni dodatne podatke za roba (podgrupe, proizvođači itd.)
    articleSubGroupService.popuniPodgrupe(magacinDto, allRoba);
    fillResultManufactures(magacinDto, allRoba);

    // Primeni filtere po proizvođaču i grupi ako je potrebno
    allRoba = robaFilterService.applyOptionalFilters(parametri, allRoba);

    // Sortiraj robu po grupi uz prioritet tačnog kataloškog broja (ako postoji).
    allRoba =
        StringUtils.hasText(parametri.getTrazenaRec())
            ? robaSortService.sortByGroupWithExact(allRoba, parametri.getTrazenaRec())
            : robaSortService.sortByGroup(allRoba);

    // Paginacija rezultata
    magacinDto.setRobaDto(
        GeneralUtil.createPageable(allRoba, parametri.getPageSize(), parametri.getPage()));
    return magacinDto;
  }

  private void fillResultManufactures(MagacinDto magacinDto, List<RobaLightDto> data) {
    magacinDto.setProizvodjaci(
        data.stream().map(RobaLightDto::getProizvodjac).collect(Collectors.toSet()).stream()
            .toList());
  }

  public boolean searchProductsByName(
      UniverzalniParametri parameters, Set<String> catalogNumbers, Set<Long> productIds) {

    String searchTerm = parameters.getTrazenaRec();

    // Retrieve products by manufacturer or by name
    List<RobaCache> products = robaCachedService.getAllRobaByNazivLike(searchTerm);

    // Collect product names
    List<String> productNames =
        products.stream().map(RobaCache::getNaziv).collect(Collectors.toList());

    // Collect product data (catalog numbers, product IDs, and names)
    collectProductData(products, catalogNumbers, productIds, productNames);

    // Check if the search term actually matches the name
    return isSearchTermActuallyName(searchTerm, productNames);
  }

  public void searchProductsByCatalogNumber(
      Set<String> kataloskiBrojevi, Set<Long> robaId, UniverzalniParametri parametri) {
    List<String> nazivi = new ArrayList<>();

    List<RobaCache> robaPoKatalaskomBroju =
        robaCachedService.getAllRobaFilteredByKatBr(parametri.getTrazenaRec());
    collectProductData(robaPoKatalaskomBroju, kataloskiBrojevi, robaId, nazivi);

    normalizeCatalogNumbers(kataloskiBrojevi);
  }

  public void searchProductsByCatalogNumbersIn(Set<String> kataloskiBrojevi, Set<Long> robaId) {
    List<String> nazivi = new ArrayList<>();
    List<RobaCache> roba = robaCachedService.getAllRobaByKatBrIn(kataloskiBrojevi);
    collectProductData(roba, kataloskiBrojevi, robaId, nazivi);
    normalizeCatalogNumbers(kataloskiBrojevi);
  }

  private static void collectProductData(
      List<RobaCache> roba, Set<String> kataloskiBrojevi, Set<Long> robaId, List<String> nazivi) {
    roba.forEach(
        data -> {
          if (StringUtils.hasText(data.getKatbr())) {
            kataloskiBrojevi.add(data.getKatbr());
          }
          if (StringUtils.hasText(data.getKatbrpro())) {
            kataloskiBrojevi.add(data.getKatbrpro());
          }
          if (data.getRobaid() != null) {
            robaId.add(data.getRobaid());
          }

          if (StringUtils.hasText(data.getNaziv())) {
            nazivi.add(data.getNaziv());
          }
        });
  }

  private static boolean isSearchTermActuallyName(String searchTerm, List<String> nazivi) {
    // Clean up the search term by removing '%' and splitting by spaces
    if (!StringUtils.hasText(searchTerm) || nazivi == null || nazivi.isEmpty()) {
      return false;
    }

    String cleanedSearchTerm = normalizeName(searchTerm.replace("%", "").trim());
    List<String> trazeneReci =
        Arrays.stream(cleanedSearchTerm.split("\\s+")).filter(StringUtils::hasText).toList();

    if (trazeneReci.isEmpty()) {
      return false;
    }

    return nazivi.stream()
        .filter(StringUtils::hasText)
        .map(RobaAdapterService::normalizeName)
        .anyMatch(naziv -> trazeneReci.stream().allMatch(trazenaRec -> naziv.contains(trazenaRec)));
  }

  public void fetchByAlternativeCatalogueNumber(Set<String> kataloskiBrojevi) {
    List<RobaLightDto> roba = robaJooqRepository.fetchKatBrOld(kataloskiBrojevi);
    roba.forEach(
        data -> {
          if (StringUtils.hasText(data.getKatbr())) {
            kataloskiBrojevi.add(data.getKatbr());
          }
          if (StringUtils.hasText(data.getKatbrpro())) {
            kataloskiBrojevi.add(data.getKatbrpro());
          }
        });
    normalizeCatalogNumbers(kataloskiBrojevi);
  }

  public MagacinDto fetchProductsByTecDocArticles(
      Set<String> articleNumbers, UniverzalniParametri parametri, List<ArticleRecord> articles) {
    MagacinDto magacinDto = new MagacinDto();

    List<RobaCache> robaCaches = robaCachedService.getAllRobaFilteredByKatBr(articleNumbers);
    List<RobaLightDto> roba = robaDatabaseService.findByPrimaryKeyFromCache(robaCaches);

    robaTecDocProcessor.filterIfNotMatchingMainArticle(roba);
    robaTecDocProcessor.filterIfNotMatchingWithTecDoc(articles, roba);

    // TD Articles
    robaTecDocProcessor.addTecdocArticles(articles, roba);

    // Popuni dodatne podatke za roba (podgrupe, proizvođači itd.)
    articleSubGroupService.popuniPodgrupe(magacinDto, roba);

    // CAUTION: if you change this search by vehicle won't work correctly
    proizvodjacService.popuniProizvodjace(roba, magacinDto, parametri);

    // Primeni filtere po proizvođaču i grupi ako je potrebnoroba =
    roba = robaFilterService.applyOptionalFilters(parametri, roba);

    // Sortiraj robu po grupi ako kategorija nije zadana
    roba = robaSortService.sortByGroup(roba);

    magacinDto.setRobaDto(
        GeneralUtil.createPageable(roba, parametri.getPageSize(), parametri.getPage()));

    robaTecDocProcessor.enrichRobaDtoWithLinkageCriteria(
        magacinDto.getRobaDto().getContent(), articles);

    return magacinDto;
  }

  private void normalizeCatalogNumbers(Set<String> retVal) {
    Set<String> noviKatBrojevi = new HashSet<>();
    retVal.forEach(
        katBrojevi -> {
          String cleaned = CatalogNumberUtils.cleanPreserveSeparators(katBrojevi);
          if (!StringUtils.hasText(cleaned)) {
            return;
          }

          String latinic = GeneralUtil.cyrillicToLatinic(cleaned);
          if (StringUtils.hasText(latinic)) {
            noviKatBrojevi.add(latinic);
          }
        });
    retVal.clear();
    retVal.addAll(noviKatBrojevi);
  }

  private static String normalizeName(String value) {
    if (!StringUtils.hasText(value)) {
      return "";
    }

    String latinic = GeneralUtil.cyrillicToLatinic(value);
    String normalized =
        Normalizer.normalize(latinic, Normalizer.Form.NFD)
            .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
            .toLowerCase();

    return normalized;
  }
}

final class PagingContext {
  private final boolean enabled;
  private final int page;
  private final int pageSize;

  private PagingContext(boolean enabled, int page, int pageSize) {
    this.enabled = enabled;
    this.page = page;
    this.pageSize = pageSize;
  }

  static PagingContext from(UniverzalniParametri parametri) {
    Integer pageSize = parametri.getPageSize();
    Integer page = parametri.getPage();
    boolean hasPageParams = pageSize != null && pageSize > 0 && page != null && page >= 0;
    boolean paged = parametri.isPaged() && hasPageParams;

    int effectivePage = hasPageParams ? Math.max(0, page) : 0;
    int effectivePageSize = hasPageParams ? Math.max(1, pageSize) : 0;

    return new PagingContext(paged, effectivePage, effectivePageSize);
  }

  boolean enabled() {
    return enabled;
  }

  int page() {
    return page;
  }

  int pageSize() {
    return pageSize;
  }

  int offset() {
    return page * pageSize;
  }

  int resolvePageSize(long fallbackTotal) {
    if (pageSize > 0) {
      return pageSize;
    }
    if (fallbackTotal <= 0) {
      return 1;
    }
    return (int) Math.min(Integer.MAX_VALUE, fallbackTotal);
  }
}
