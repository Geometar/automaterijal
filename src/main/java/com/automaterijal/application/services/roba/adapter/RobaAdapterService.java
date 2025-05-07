package com.automaterijal.application.services.roba.adapter;

import com.automaterijal.application.domain.cache.RobaCache;
import com.automaterijal.application.domain.dto.*;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.domain.repository.roba.RobaJooqRepository;
import com.automaterijal.application.services.ProizvodjacService;
import com.automaterijal.application.services.roba.cache.RobaCacheService;
import com.automaterijal.application.services.roba.filter.RobaFilterService;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
import com.automaterijal.application.services.roba.processor.RobaTecDocProcessor;
import com.automaterijal.application.services.roba.repo.RobaDatabaseService;
import com.automaterijal.application.services.roba.sort.RobaSortService;
import com.automaterijal.application.tecdoc.ArticleRecord;
import com.automaterijal.application.utils.GeneralUtil;
import java.util.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.jooq.impl.DSL;
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
  @Autowired PodGrupaService podGrupaService;
  @Autowired ProizvodjacService proizvodjacService;

  /**
   * Ulazna metoda iz glavnog servisa kad je pretraga po RobaId (za sad to znaci da je pretraga po
   * reci)
   */
  public MagacinDto searchProductsByIds(UniverzalniParametri parametri, Set<Long> robaIds) {
    MagacinDto magacinDto = new MagacinDto();

    List<RobaLightDto> roba = robaJooqRepository.vratiRobuPoRobiId(robaIds);

    podGrupaService.popuniPodgrupe(magacinDto, parametri, roba);
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

    List<RobaLightDto> roba = robaJooqRepository.generic(parametri, DSL.noCondition());

    podGrupaService.popuniPodgrupe(magacinDto, parametri, roba);
    proizvodjacService.popuniProizvodjace(roba, magacinDto, parametri);
    roba = robaFilterService.applyOptionalFilters(parametri, roba);
    roba = robaSortService.sortByGroup(roba);

    magacinDto.setRobaDto(
        GeneralUtil.createPageable(roba, parametri.getPageSize(), parametri.getPage()));

    return magacinDto;
  }

  public MagacinDto fetchSearchResultsByCatalogNumbersAndFilters(
      UniverzalniParametri parametri, Set<String> kataloskiBrojevi) {
    MagacinDto magacinDto = new MagacinDto();
    List<RobaLightDto> allRoba = new ArrayList<>();

    List<RobaCache> robaKatbr = robaCachedService.getAllRobaFilteredByKatBr(kataloskiBrojevi);
    allRoba.addAll(
        robaDatabaseService.pronadjiRobuPoPrimarnomKljucu(
            robaKatbr.stream().map(RobaCache::getRobaId).toList()));

    allRoba = robaFilterService.applyMandatoryFilters(parametri, allRoba);

    // Popuni dodatne podatke za roba (podgrupe, proizvođači itd.)
    podGrupaService.popuniPodgrupe(magacinDto, parametri, allRoba);
    proizvodjacService.popuniProizvodjace(allRoba, magacinDto, parametri);

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

  public boolean searchProductsByName(
      UniverzalniParametri parametri, Set<String> kataloskiBrojevi, Set<Long> robaId) {
    List<RobaCache> roba = robaCachedService.getAllRobaByNaizvLike(parametri.getTrazenaRec());

    List<String> nazivi = new ArrayList<>();
    collectProductData(roba, kataloskiBrojevi, robaId, nazivi);

    return isSearchTermActuallyName(parametri.getTrazenaRec(), nazivi);
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
          if (data.getRobaId() != null) {
            robaId.add(data.getRobaId());
          }

          if (StringUtils.hasText(data.getNaziv())) {
            nazivi.add(data.getNaziv());
          }
        });
  }

  private static boolean isSearchTermActuallyName(String searchTerm, List<String> nazivi) {
    // Clean up the search term by removing '%' and splitting by spaces
    String cleanedSearchTerm = searchTerm.replace("%", "").trim();
    List<String> trazeneReci = Arrays.asList(cleanedSearchTerm.split("\\s+"));

    return nazivi.stream().anyMatch(naziv -> trazeneReci.stream().allMatch(naziv::contains));
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
    List<RobaLightDto> roba =
        robaDatabaseService.pronadjiRobuPoPrimarnomKljucu(
            robaCaches.stream().map(RobaCache::getRobaId).toList());

    robaTecDocProcessor.filterIfNotMatchingMainArticle(roba);
    robaTecDocProcessor.filterIfNotMatchingWithTecDoc(articles, roba);

    // TD Articles
    robaTecDocProcessor.addTecdocArticles(articles, roba);

    // Popuni dodatne podatke za roba (podgrupe, proizvođači itd.)
    podGrupaService.popuniPodgrupe(magacinDto, parametri, roba);
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
}
