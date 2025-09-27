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
import com.automaterijal.application.utils.CriteriaBuilder;
import com.automaterijal.application.utils.GeneralUtil;
import java.math.BigDecimal;
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

    articleSubGroupService.popuniPodgrupe(magacinDto, parametri, roba);
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
    CriteriaBuilder criteriaBuilder = CriteriaBuilder.init();
    criteriaBuilder.addConditionIfTrue(
        parametri.isNaStanju(), ROBA.STANJE.greaterThan(BigDecimal.ZERO));
    Condition condition = criteriaBuilder.build();

    Integer pageSize = parametri.getPageSize();
    Integer page = parametri.getPage();
    boolean hasPageParams = pageSize != null && pageSize > 0 && page != null && page >= 0;
    boolean paged = parametri.isPaged() && hasPageParams;

    int effectivePage = hasPageParams ? Math.max(0, page) : 0;
    int effectivePageSize = hasPageParams ? Math.max(1, pageSize) : 0;

    List<RobaLightDto> roba;
    if (paged) {
      int offset = effectivePage * effectivePageSize;
      roba = robaJooqRepository.generic(parametri, condition, effectivePageSize, offset);
    } else {
      roba = robaJooqRepository.generic(parametri, condition);
    }

    if (!parametri.isShowcase()) {
      articleSubGroupService.popuniPodgrupe(magacinDto, parametri, roba);
      proizvodjacService.popuniProizvodjace(roba, magacinDto, parametri);
    }
    roba = robaFilterService.applyOptionalFilters(parametri, roba);
    roba = robaSortService.sortByGroup(roba);

    long total;
    List<RobaLightDto> pageContent;
    if (paged && !parametri.isShowcase()) {
      total = robaJooqRepository.count(parametri, condition);
      pageContent = roba;
    } else {
      total = roba.size();
      if (effectivePageSize <= 0) {
        effectivePageSize = total == 0 ? 1 : (int) total;
      }
      int fromIndex = Math.min(effectivePage * effectivePageSize, roba.size());
      int toIndex = Math.min(fromIndex + effectivePageSize, roba.size());
      pageContent = roba.subList(fromIndex, toIndex);
    }

    magacinDto.setRobaDto(
        new PageImpl<>(pageContent, PageRequest.of(effectivePage, effectivePageSize), total));

    return magacinDto;
  }

  public MagacinDto fetchSearchResultsByCatalogNumbersAndFilters(
      UniverzalniParametri parametri, Set<String> kataloskiBrojevi) {
    MagacinDto magacinDto = new MagacinDto();
    List<RobaLightDto> allRoba = new ArrayList<>();

    List<RobaCache> robaCache = robaCachedService.getAllRobaFilteredByKatBr(kataloskiBrojevi);
    allRoba.addAll(robaDatabaseService.findByPrimaryKeyFromCache(robaCache));

    allRoba = robaFilterService.applyMandatoryFilters(parametri, allRoba);

    // Popuni dodatne podatke za roba (podgrupe, proizvođači itd.)
    articleSubGroupService.popuniPodgrupe(magacinDto, parametri, allRoba);
    fillResultManufactures(magacinDto, allRoba);

    // Primeni filtere po proizvođaču i grupi ako je potrebno
    allRoba = robaFilterService.applyOptionalFilters(parametri, allRoba);

    // Sortiraj robu po grupi ako kategorija nije zadana
    allRoba = robaSortService.sortByGroup(allRoba);

    // Sortiraj robu po podgrupi
    allRoba = robaSortService.sortByTecDocSubGroup(allRoba, parametri);

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
    articleSubGroupService.popuniPodgrupe(magacinDto, parametri, roba);

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
          String noviBroj =
              GeneralUtil.cyrillicToLatinic(katBrojevi.replace(" ", "").toUpperCase());
          noviKatBrojevi.add(noviBroj);
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
