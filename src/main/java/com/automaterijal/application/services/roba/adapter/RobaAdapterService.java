package com.automaterijal.application.services.roba.adapter;

import static com.automaterijal.db.tables.Roba.ROBA;

import com.automaterijal.application.domain.dto.DashboardDto;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.domain.repository.roba.RobaJooqRepository;
import com.automaterijal.application.services.ProizvodjacService;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
import com.automaterijal.application.utils.GeneralUtil;
import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaAdapterService {

  @Autowired RobaJooqRepository robaJooqRepository;

  @Autowired PodGrupaService podGrupaService;

  @Autowired ProizvodjacService proizvodjacService;

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

    magacinDto.setRobaDto(createPageable(roba, parametri.getPageSize(), parametri.getPage()));

    return magacinDto;
  }

  private static <T> Page<T> createPageable(List<T> items, int pageSize, int pageNumber) {
    int start = pageSize * pageNumber;
    int end = Math.min((start + pageSize), items.size());
    return new PageImpl<>(
        items.subList(start, end), PageRequest.of(pageNumber, pageSize), items.size());
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
            Comparator.comparing(RobaDto::getPodGrupaNaziv)
                .thenComparing(robaDto -> robaDto.getStanje() == 0))
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
              .toList();
    }

    if (parametri.getGrupa() != null && !parametri.getGrupa().isEmpty()) {
      roba =
          roba.stream()
              .filter(
                  robaDto ->
                      parametri.getGrupa().stream()
                          .anyMatch(value -> value.equalsIgnoreCase(robaDto.getGrupa())))
              .toList();
    }

    if (parametri.getPodgrupeZaPretragu() != null && !parametri.getPodgrupeZaPretragu().isEmpty()) {
      roba =
          roba.stream()
              .filter(
                  robaDto ->
                      parametri.getPodgrupeZaPretragu().stream()
                          .anyMatch(value -> value.equalsIgnoreCase(robaDto.getPodGrupaNaziv())))
              .toList();
    }
    return roba;
  }

  public MagacinDto vratiArtikleIzTecDoca(
      UniverzalniParametri parametri, Set<String> kataloskiBrojevi) {
    MagacinDto magacinDto = new MagacinDto();
    List<RobaDto> allRoba = new ArrayList<>();

    List<RobaDto> robaKatbr =
        robaJooqRepository.generic(parametri, ROBA.KATBR.in(kataloskiBrojevi));
    allRoba.addAll(robaKatbr);

    Set<String> nadjeniBrojevi =
        robaKatbr.stream().map(RobaDto::getKatbr).collect(Collectors.toSet());
    nadjeniBrojevi.addAll(robaKatbr.stream().map(RobaDto::getKatbrpro).collect(Collectors.toSet()));

    // Fetch podaci za KATBRPRO
    List<RobaDto> robaKatbrpro =
        robaJooqRepository.generic(parametri, ROBA.KATBRPRO.in(nadjeniBrojevi));
    allRoba.addAll(robaKatbrpro);
    allRoba = new ArrayList<>(new HashSet<>(allRoba));

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

    magacinDto.setRobaDto(createPageable(allRoba, parametri.getPageSize(), parametri.getPage()));
    return magacinDto;
  }

  private void sortirajRobuTecDocPoPodgrupi(
      List<RobaDto> robaDtos, UniverzalniParametri parametri) {
    List<RobaDto> pronadjenaTacnaRoba =
        robaDtos.stream()
            .filter(robaDto -> robaDto.getKatbr().equals(parametri.getTrazenaRec()))
            .toList();

    // Ako nema tačnog rezultata, traži približne
    if (pronadjenaTacnaRoba.isEmpty()) {
      pronadjenaTacnaRoba =
          robaDtos.stream()
              .filter(robaDto -> robaDto.getKatbr().contains(parametri.getTrazenaRec()))
              .toList();
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
      String searchTerm,
      UniverzalniParametri parametri,
      Set<String> kataloskiBrojevi,
      Set<Long> robaId) {
    List<RobaDto> roba = robaJooqRepository.pronadjiRobuPoNazivu(searchTerm, parametri);

    List<String> nazivi = new ArrayList<>();
    popuniKolekcije(roba, kataloskiBrojevi, robaId, nazivi);

    return recJeZapravoNaziv(parametri.getTrazenaRec(), nazivi);
  }

  public void pronadjiPoKatBroju(
      String tacnaRecLike,
      Set<String> kataloskiBrojevi,
      Set<Long> robaId,
      UniverzalniParametri parametri) {
    List<String> nazivi = new ArrayList<>();

    List<RobaDto> robaPoKatalaskomBroju =
        robaJooqRepository.generic(parametri, ROBA.KATBR.like(tacnaRecLike));
    popuniKolekcije(robaPoKatalaskomBroju, kataloskiBrojevi, robaId, nazivi);
    List<RobaDto> robaPoKatBrojuProizvodjaca =
        robaJooqRepository.generic(parametri, ROBA.KATBRPRO.like(tacnaRecLike));
    popuniKolekcije(robaPoKatBrojuProizvodjaca, kataloskiBrojevi, robaId, nazivi);

    prodjiIPopraviKatBr(kataloskiBrojevi);
  }

  public void pronadjiPoKatBrojuIn(
      Set<String> kataloskiBrojevi, Set<Long> robaId, UniverzalniParametri parametri) {
    List<String> nazivi = new ArrayList<>();
    List<RobaDto> roba = robaJooqRepository.generic(parametri, ROBA.KATBR.in(kataloskiBrojevi));
    popuniKolekcije(roba, kataloskiBrojevi, robaId, nazivi);
    prodjiIPopraviKatBr(kataloskiBrojevi);
  }

  private static void popuniKolekcije(
      List<RobaDto> roba, Set<String> kataloskiBrojevi, Set<Long> robaId, List<String> nazivi) {
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

  /** Zbog n+1 u hibernate koristimo jooq da vrati svu robu u zavisnosti od podgrupe */
  public Page<Roba> pronadjiSvuRobuPoPodgrupama(
      List<PodGrupa> podGrupaId, boolean naStanju, Pageable pageable) {

    List<Roba> roba = robaJooqRepository.pronadjiRobuPoPodgrupama(podGrupaId, naStanju);

    Page<Roba> result = createPageable(roba, pageable.getPageSize(), pageable.getPageNumber());
    result.forEach(
        rekord ->
            proizvodjacService
                .vratiProizvodjacaPoPk(rekord.getProizvodjac().getProid())
                .ifPresent(rekord::setProizvodjac));
    return result;
  }

  public DashboardDto vracanjePodatakaZaDashboard() {
    List<String> sviProizvodjaci = robaJooqRepository.vratiSveProzivodjace();
    Set<String> jedinstveniProizvodjaci = new HashSet<>(sviProizvodjaci);

    return DashboardDto.builder()
        .brojArtikala(sviProizvodjaci.size())
        .brojProizvodjaca(jedinstveniProizvodjaci.size())
        .build();
  }
}
