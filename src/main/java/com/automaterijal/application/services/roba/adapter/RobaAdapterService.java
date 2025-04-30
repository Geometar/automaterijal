package com.automaterijal.application.services.roba.adapter;

import com.automaterijal.application.domain.cache.RobaCache;
import com.automaterijal.application.domain.dto.*;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.domain.repository.roba.RobaJooqRepository;
import com.automaterijal.application.services.ProizvodjacService;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
import com.automaterijal.application.services.roba.processor.RobaTecDocProcessor;
import com.automaterijal.application.services.roba.repo.RobaRepositoryService;
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

  @Autowired RobaRepositoryService robaRepositoryService;

  @Autowired RobaJooqRepository robaJooqRepository;

  @Autowired PodGrupaService podGrupaService;

  @Autowired ProizvodjacService proizvodjacService;

  @Autowired RobaTecDocProcessor robaTecDocProcessor;

  /**
   * Ulazna metoda iz glavnog servisa kad je pretraga po RobaId (za sad to znaci da je pretraga po
   * reci)
   */
  public MagacinDto pronadjiPoRobaId(UniverzalniParametri parametri, Set<Long> robaIds) {
    MagacinDto magacinDto = new MagacinDto();

    List<RobaDto> roba = robaJooqRepository.vratiRobuPoRobiId(robaIds);

    podGrupaService.popuniPodgrupe(magacinDto, parametri, roba);
    proizvodjacService.popuniProizvodjace(roba, magacinDto, parametri);

    // Primeni filtere po proizvođaču i grupi ako je potrebno
    roba = robaFilterPoParametrima(parametri, roba);

    // Sortiraj robu po grupi ako kategorija nije zadana
    roba = sortirajPoGrupi(roba);

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

  private List<RobaDto> mandatoryFiltering(UniverzalniParametri parametri, List<RobaDto> roba) {
    if (parametri.getMandatoryProid() != null && !parametri.getMandatoryProid().isEmpty()) {
      roba =
          roba.stream()
              .filter(
                  robaDto ->
                      parametri.getMandatoryProid().stream()
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

    if (parametri.isNaStanju()) {
      roba = roba.stream().filter(robaDto -> robaDto.getStanje() > 0).collect(Collectors.toList());
    }

    return roba;
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
    if (parametri.getMandatoryProid() != null && !parametri.getMandatoryProid().isEmpty()) {
      roba =
          roba.stream()
              .filter(
                  robaDto ->
                      parametri.getMandatoryProid().stream()
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

    List<RobaCache> robaKatbr = robaRepositoryService.getAllRobaFilteredByKatBr(kataloskiBrojevi);
    allRoba.addAll(
        robaRepositoryService.pronadjiRobuPoPrimarnomKljucu(
            robaKatbr.stream().map(RobaCache::getRobaId).toList()));

    allRoba = mandatoryFiltering(parametri, allRoba);

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
    List<RobaCache> roba = robaRepositoryService.getAllRobaByNaizvLike(parametri.getTrazenaRec());

    List<String> nazivi = new ArrayList<>();
    popuniKolekcije(roba, kataloskiBrojevi, robaId, nazivi);

    return recJeZapravoNaziv(parametri.getTrazenaRec(), nazivi);
  }

  public void pronadjiPoKatBroju(
      Set<String> kataloskiBrojevi, Set<Long> robaId, UniverzalniParametri parametri) {
    List<String> nazivi = new ArrayList<>();

    List<RobaCache> robaPoKatalaskomBroju =
        robaRepositoryService.getAllRobaFilteredByKatBr(parametri.getTrazenaRec());
    popuniKolekcije(robaPoKatalaskomBroju, kataloskiBrojevi, robaId, nazivi);

    prodjiIPopraviKatBr(kataloskiBrojevi);
  }

  public void pronadjiPoKatBrojuIn(Set<String> kataloskiBrojevi, Set<Long> robaId) {
    List<String> nazivi = new ArrayList<>();
    List<RobaCache> roba = robaRepositoryService.getAllRobaByKatBrIn(kataloskiBrojevi);
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

  public MagacinDto fetchRobaByTecDocArticles(
      Set<String> articleNumbers, UniverzalniParametri parametri, List<ArticleRecord> articles) {
    MagacinDto magacinDto = new MagacinDto();

    List<RobaCache> robaCaches = robaRepositoryService.getAllRobaFilteredByKatBr(articleNumbers);
    List<RobaDto> roba =
        robaRepositoryService.pronadjiRobuPoPrimarnomKljucu(
            robaCaches.stream().map(RobaCache::getRobaId).toList());

    robaTecDocProcessor.filterIfNotMatchingMainArticle(roba);
    robaTecDocProcessor.filterIfNotMatchingWithTecDoc(articles, roba);

    // TD Articles
    robaTecDocProcessor.addTecdocArticles(articles, roba);

    // Popuni dodatne podatke za roba (podgrupe, proizvođači itd.)
    podGrupaService.popuniPodgrupe(magacinDto, parametri, roba);
    proizvodjacService.popuniProizvodjace(roba, magacinDto, parametri);

    // Primeni filtere po proizvođaču i grupi ako je potrebnoroba =
    roba = robaFilterPoParametrima(parametri, roba);

    // Sortiraj robu po grupi ako kategorija nije zadana
    roba = sortirajPoGrupi(roba);

    magacinDto.setRobaDto(
        GeneralUtil.createPageable(roba, parametri.getPageSize(), parametri.getPage()));

    robaTecDocProcessor.enrichRobaDtoWithLinkageCriteria(magacinDto.getRobaDto().getContent(), articles);

    return magacinDto;
  }
}
