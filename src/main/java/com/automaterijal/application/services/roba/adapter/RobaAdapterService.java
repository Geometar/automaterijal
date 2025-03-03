package com.automaterijal.application.services.roba.adapter;

import com.automaterijal.application.domain.cache.RobaCache;
import com.automaterijal.application.domain.constants.TecDocProizvodjaci;
import com.automaterijal.application.domain.dto.*;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.domain.repository.roba.RobaJooqRepository;
import com.automaterijal.application.services.ProizvodjacService;
import com.automaterijal.application.services.SlikeService;
import com.automaterijal.application.services.roba.RobaService;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
import com.automaterijal.application.tecdoc.ArticleRecord;
import com.automaterijal.application.utils.GeneralUtil;
import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;
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

  @Autowired RobaService robaService;

  @Autowired RobaJooqRepository robaJooqRepository;

  @Autowired PodGrupaService podGrupaService;

  @Autowired ProizvodjacService proizvodjacService;

  @Autowired SlikeService slikeService;

  /**
   * Ulazna metoda iz glavnog servisa kad je pretraga po RobaId (za sad to znaci da je pretraga po
   * reci)
   */
  public MagacinDto pronadjiPoRobaId(UniverzalniParametri parametri, Set<Long> robaIds) {
    MagacinDto magacinDto = new MagacinDto();

    List<RobaDto> roba = robaJooqRepository.vratiRobuPoRobiId(robaIds);

    podGrupaService.popuniPodgrupe(magacinDto, parametri, roba);
    proizvodjacService.popuniProizvodjace(roba, magacinDto, parametri);

    int start = parametri.getPageSize() * parametri.getPage();
    int end = Math.min((start + parametri.getPageSize()), roba.size());

    // Primeni filtere po proizvođaču i grupi ako je potrebno
    roba = robaFilterPoParametrima(parametri, roba);

    // Sortiraj robu po grupi ako kategorija nije zadana
    roba = sortirajPoGrupi(roba);

    magacinDto.setRobaDto(
        new PageImpl<>(
            roba.subList(start, end),
            PageRequest.of(parametri.getPage(), parametri.getPageSize()),
            roba.size()));

    return magacinDto;
  }

  /** Ulazna metoda iz glavnog servisa */
  public MagacinDto vratiRobuFiltriranuBezPretrage(UniverzalniParametri parametri) {
    MagacinDto magacinDto = new MagacinDto();

    List<RobaDto> roba = robaJooqRepository.generic(parametri, DSL.noCondition());

    podGrupaService.popuniPodgrupe(magacinDto, parametri, roba);
    proizvodjacService.popuniProizvodjace(roba, magacinDto, parametri);
    roba = robaFilterPoParametrima(parametri, roba);
    roba = sortirajPoGrupi(roba);

    magacinDto.setRobaDto(
        GeneralUtil.createPageable(roba, parametri.getPageSize(), parametri.getPage()));

    return magacinDto;
  }

  private List<RobaDto> sortirajPoGrupi(List<RobaDto> roba) {
    return roba.stream()
        .map(
            robaDto -> {
              if (robaDto.getPodGrupaNaziv() == null) {
                robaDto.setPodGrupaNaziv("ZZZ");
              }
              return robaDto;
            })
        .sorted(
            Comparator.comparing(
                    (RobaDto robaDto) ->
                        robaDto.getStanje() == 0) // Artikli sa stanjem > 0 idu pre stanja 0
                .thenComparing(robaDto -> robaDto.getPodGrupa() == 0) // Podgrupa ID 0 ide na kraj
                .thenComparing(Comparator.comparing(RobaDto::getStanje).reversed())
                .thenComparing(
                    RobaDto
                        ::getPodGrupaNaziv) // Unutar grupe sortiranje po nazivu) // Sortiranje po
            // nazivu grupe
            )
        .collect(Collectors.toList());
  }

  private List<RobaDto> robaFilterPoParametrima(
      UniverzalniParametri parametri, List<RobaDto> roba) {
    if (parametri.getProizvodjac() != null && !parametri.getProizvodjac().isEmpty()) {
      roba =
          roba.stream()
              .filter(
                  robaDto ->
                      parametri.getProizvodjac().stream()
                          .anyMatch(
                              value -> value.equalsIgnoreCase(robaDto.getProizvodjac().getProid())))
              .collect(Collectors.toList());
    }

    if (parametri.getGrupa() != null && !parametri.getGrupa().isEmpty()) {
      roba =
          roba.stream()
              .filter(
                  robaDto ->
                      parametri.getGrupa().stream()
                          .anyMatch(value -> value.equalsIgnoreCase(robaDto.getGrupa())))
              .collect(Collectors.toList());
    }

    if (parametri.getPodgrupeZaPretragu() != null && !parametri.getPodgrupeZaPretragu().isEmpty()) {
      roba =
          roba.stream()
              .filter(
                  robaDto ->
                      parametri.getPodgrupeZaPretragu().stream()
                          .anyMatch(value -> value == robaDto.getPodGrupa()))
              .collect(Collectors.toList());
    }

    if (parametri.isNaStanju()) {
      roba = roba.stream().filter(robaDto -> robaDto.getStanje() > 0).collect(Collectors.toList());
    }

    return roba;
  }

  public MagacinDto vratiArtikleIzTecDoca(
      UniverzalniParametri parametri, Set<String> kataloskiBrojevi) {
    MagacinDto magacinDto = new MagacinDto();
    List<RobaDto> allRoba = new ArrayList<>();

    List<RobaCache> robaKatbr = robaService.getAllRobaFilteredByKatBr(kataloskiBrojevi);
    allRoba.addAll(
        robaService.pronadjiRobuPoPrimarnomKljucu(
            robaKatbr.stream().map(RobaCache::getRobaId).toList()));

    // Popuni dodatne podatke za roba (podgrupe, proizvođači itd.)
    podGrupaService.popuniPodgrupe(magacinDto, parametri, allRoba);
    proizvodjacService.popuniProizvodjace(allRoba, magacinDto, parametri);

    // Primeni filtere po proizvođaču i grupi ako je potrebno
    allRoba = robaFilterPoParametrima(parametri, allRoba);

    // Sortiraj robu po grupi ako kategorija nije zadana
    allRoba = sortirajPoGrupi(allRoba);

    // Sortiraj robu po podgrupi
    sortirajRobuTecDocPoPodgrupi(allRoba, parametri);

    // Paginacija rezultata

    magacinDto.setRobaDto(
        GeneralUtil.createPageable(allRoba, parametri.getPageSize(), parametri.getPage()));
    return magacinDto;
  }

  private void sortirajRobuTecDocPoPodgrupi(
      List<RobaDto> robaDtos, UniverzalniParametri parametri) {
    List<RobaDto> pronadjenaTacnaRoba =
        robaDtos.stream()
            .filter(robaDto -> robaDto.getKatbr().equals(parametri.getTrazenaRec()))
            .collect(Collectors.toList());

    // Ako nema tačnog rezultata, traži približne
    if (pronadjenaTacnaRoba.isEmpty()) {
      pronadjenaTacnaRoba =
          robaDtos.stream()
              .filter(robaDto -> robaDto.getKatbr().contains(parametri.getTrazenaRec()))
              .collect(Collectors.toList());
    }

    // Ako su pronađeni podaci
    if (!pronadjenaTacnaRoba.isEmpty()) {
      int podGrupa = pronadjenaTacnaRoba.get(0).getPodGrupa();

      // Sortiranje korišćenjem Comparator-a
      robaDtos.sort(
          Comparator.comparing((RobaDto robaDto) -> robaDto.getStanje() > 0)
              .reversed() // Da osiguramo da `stanje > 0` ide ispred
              .thenComparing(
                  robaDto -> podGrupa == robaDto.getPodGrupa() ? -1 : 1)); // Podgrupa prioritet
    }
  }

  public boolean pronadjiPoNazivu(
      UniverzalniParametri parametri, Set<String> kataloskiBrojevi, Set<Long> robaId) {
    List<RobaCache> roba = robaService.getAllRobaByNaizvLike(parametri.getTrazenaRec());

    List<String> nazivi = new ArrayList<>();
    popuniKolekcije(roba, kataloskiBrojevi, robaId, nazivi);

    return recJeZapravoNaziv(parametri.getTrazenaRec(), nazivi);
  }

  public void pronadjiPoKatBroju(
      Set<String> kataloskiBrojevi, Set<Long> robaId, UniverzalniParametri parametri) {
    List<String> nazivi = new ArrayList<>();

    List<RobaCache> robaPoKatalaskomBroju =
        robaService.getAllRobaFilteredByKatBr(parametri.getTrazenaRec());
    popuniKolekcije(robaPoKatalaskomBroju, kataloskiBrojevi, robaId, nazivi);

    prodjiIPopraviKatBr(kataloskiBrojevi);
  }

  public void pronadjiPoKatBrojuIn(Set<String> kataloskiBrojevi, Set<Long> robaId) {
    List<String> nazivi = new ArrayList<>();
    List<RobaCache> roba = robaService.getAllRobaByKatBrIn(kataloskiBrojevi);
    popuniKolekcije(roba, kataloskiBrojevi, robaId, nazivi);
    prodjiIPopraviKatBr(kataloskiBrojevi);
  }

  private static void popuniKolekcije(
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

  private static boolean recJeZapravoNaziv(String searchTerm, List<String> nazivi) {
    // Clean up the search term by removing '%' and splitting by spaces
    String cleanedSearchTerm = searchTerm.replace("%", "").trim();
    List<String> trazeneReci = Arrays.asList(cleanedSearchTerm.split("\\s+"));

    return nazivi.stream().anyMatch(naziv -> trazeneReci.stream().allMatch(naziv::contains));
  }

  public void pomocniKveriPoRobiOld(Set<String> kataloskiBrojevi) {
    List<RobaDto> roba = robaJooqRepository.fetchKatBrOld(kataloskiBrojevi);
    roba.forEach(
        data -> {
          if (StringUtils.hasText(data.getKatbr())) {
            kataloskiBrojevi.add(data.getKatbr());
          }
          if (StringUtils.hasText(data.getKatbrpro())) {
            kataloskiBrojevi.add(data.getKatbrpro());
          }
        });
    prodjiIPopraviKatBr(kataloskiBrojevi);
  }

  private void prodjiIPopraviKatBr(Set<String> retVal) {
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

  public DashboardDto vracanjePodatakaZaDashboard() {
    List<String> sviProizvodjaci = robaJooqRepository.vratiSveProzivodjace();
    Set<String> jedinstveniProizvodjaci = new HashSet<>(sviProizvodjaci);

    return DashboardDto.builder()
        .brojArtikala(sviProizvodjaci.size())
        .brojProizvodjaca(jedinstveniProizvodjaci.size())
        .build();
  }

  public MagacinDto fetchRobaByTecDocArticles(
      Set<String> articleNumbers, UniverzalniParametri parametri, List<ArticleRecord> articles) {
    MagacinDto magacinDto = new MagacinDto();

    List<RobaCache> robaCaches = robaService.getAllRobaFilteredByKatBr(articleNumbers);
    List<RobaDto> roba =
        robaService.pronadjiRobuPoPrimarnomKljucu(
            robaCaches.stream().map(RobaCache::getRobaId).toList());

    filterIfNotMatchingMainArticle(roba);
    filterIfNotMatchingWithTecDoc(articles, roba);

    // TD Articles
    addTecdocArticles(articles, roba);

    // Popuni dodatne podatke za roba (podgrupe, proizvođači itd.)
    podGrupaService.popuniPodgrupe(magacinDto, parametri, roba);
    proizvodjacService.popuniProizvodjace(roba, magacinDto, parametri);

    // Primeni filtere po proizvođaču i grupi ako je potrebnoroba =
    roba = robaFilterPoParametrima(parametri, roba);

    // Sortiraj robu po grupi ako kategorija nije zadana
    roba = sortirajPoGrupi(roba);

    magacinDto.setRobaDto(
        GeneralUtil.createPageable(roba, parametri.getPageSize(), parametri.getPage()));

    return magacinDto;
  }

  private void addTecdocArticles(List<ArticleRecord> articles, List<RobaDto> roba) {
    List<RobaDto> tdArticles =
        articles.stream()
            .map(
                articleRecord -> {
                  TecDocProizvodjaci tecDocProizvodjaci =
                      TecDocProizvodjaci.pronadjiPoKljucu(articleRecord.getDataSupplierId());
                  String katBr =
                      TecDocProizvodjaci.generateAlternativeCatalogNumber(
                          articleRecord.getArticleNumber(), tecDocProizvodjaci);

                  boolean articleInDB =
                      roba.stream()
                          .anyMatch(
                              robaDto ->
                                  robaDto
                                          .getProizvodjac()
                                          .getProid()
                                          .equals(tecDocProizvodjaci.name())
                                      && robaDto.getKatbr().equals(katBr));

                  return articleInDB
                      ? null
                      : RobaDto.fromTecdocArticle(articleRecord, tecDocProizvodjaci, slikeService);
                })
            .filter(Objects::nonNull)
            .collect(Collectors.toList());

    roba.addAll(tdArticles);
  }

  private void filterIfNotMatchingWithTecDoc(List<ArticleRecord> articles, List<RobaDto> robaDtos) {
    List<RobaDto> removable =
        robaDtos.stream()
            .filter(robaDto -> isNotMatchingWithTecDoc(articles, robaDto))
            .collect(Collectors.toList());

    if (!removable.isEmpty()) {
      log.error("Ne podudaraju se artikli sa TecDoc-om");
    }

    robaDtos.removeAll(removable);
  }

  private boolean isNotMatchingWithTecDoc(List<ArticleRecord> articles, RobaDto robaDto) {
    TecDocProizvodjaci tecDocProizvodjaci =
        TecDocProizvodjaci.findByName(robaDto.getProizvodjac().getProid());

    if (tecDocProizvodjaci == null) {
      return false; // If not a TecDoc article, allow it for further alternative checks
    }

    String katBr =
        TecDocProizvodjaci.restoreOriginalCatalogNumber(robaDto.getKatbr(), tecDocProizvodjaci);

    return articles.stream()
        .noneMatch(
            articleRecord ->
                articleRecord.getArticleNumber().equals(katBr)
                    && articleRecord.getDataSupplierId() == tecDocProizvodjaci.getTecDocId());
  }

  private void filterIfNotMatchingMainArticle(List<RobaDto> robaDtos) {
    // Partition RobaDtos into TecDoc-mapped and non-TecDoc-mapped lists
    Map<Boolean, List<RobaDto>> partitioned =
        robaDtos.stream()
            .collect(
                Collectors.partitioningBy(
                    robaDto ->
                        TecDocProizvodjaci.findByName(robaDto.getProizvodjac().getProid())
                            != null));

    List<RobaDto> tdRoba = partitioned.get(true); // TecDoc-mapped items
    List<RobaDto> notTdRoba = partitioned.get(false); // Items not mapped to TecDoc

    // Remove items that do not match a valid TecDoc-mapped alternative
    List<RobaDto> removable =
        notTdRoba.stream()
            .filter(robaDto -> isNotMatchingMainArticle(tdRoba, robaDto))
            .collect(Collectors.toList());

    // Remove if its not found by original number
    removable =
        removable.stream()
            .filter(robaDto -> !robaDto.getKatbr().contains("-OE"))
            .collect(Collectors.toList());

    if (!removable.isEmpty()) {
      log.error("Ne podudaraju se artikli sa TecDoc alternativom");
    }

    robaDtos.removeAll(removable);
  }

  private boolean isNotMatchingMainArticle(List<RobaDto> tdRoba, RobaDto robaDto) {
    // Get all matching TecDoc-mapped items that have the same alternative catalog number
    List<RobaDto> matchedTdRoba =
        tdRoba.stream()
            .filter(
                data ->
                    data.getKatbrpro().equals(robaDto.getKatbr())
                        || data.getKatbr().equals(robaDto.getKatbr()))
            .collect(Collectors.toList());

    // If no matches, reject this alternative item
    if (matchedTdRoba.isEmpty()) {
      return true;
    }

    // Check if multiple different TecDoc manufacturers exist
    Set<String> distinctManufacturers =
        matchedTdRoba.stream()
            .map(data -> data.getProizvodjac().getProid())
            .collect(Collectors.toSet());

    if (distinctManufacturers.size() > 1) {
      log.warn(
          "Alternative catalog number {} matches multiple TecDoc manufacturers: {}",
          robaDto.getKatbr(),
          distinctManufacturers);
      return true; // Reject because it's ambiguous
    }

    // Ensure that at least one mapped TecDoc product has the same PodGrupa
    return matchedTdRoba.stream().noneMatch(data -> data.getPodGrupa() == robaDto.getPodGrupa());
  }
}
