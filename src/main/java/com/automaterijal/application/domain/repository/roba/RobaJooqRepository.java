package com.automaterijal.application.domain.repository.roba;

import static com.automaterijal.db.tables.Roba.ROBA;
import static com.automaterijal.db.tables.RobaKatbrOld.ROBA_KATBR_OLD;

import com.automaterijal.application.client.TecDocClient;
import com.automaterijal.application.domain.dto.DashboardDto;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.services.ProizvodjacService;
import com.automaterijal.application.services.roba.RobaService;
import com.automaterijal.application.services.roba.grupe.PodGrupaService;
import com.automaterijal.application.utils.GeneralUtil;
import com.automaterijal.db.tables.records.RobaRecord;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record8;
import org.jooq.Result;
import org.jooq.SelectConditionStep;
import org.jooq.SelectJoinStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaJooqRepository {

  @Autowired
  DSLContext dslContext;

  @Autowired
  RobaService robaService;

  @Autowired
  PodGrupaService podGrupaService;

  @Autowired
  ProizvodjacService proizvodjacService;

  @Autowired
  RobaMapper mapper;

  @Autowired
  TecDocClient tecDocClient;

  /**
   * Ulazna metoda iz glavnog servisa kad je pretraga po RobaId (za sad to znaci da je pretraga po
   * reci)
   */
  public MagacinDto pronadjiPoRobaId(UniverzalniParametri parametri, Set<Long> robaIds) {
    MagacinDto magacinDto = new MagacinDto();

    List<RobaDto> roba = robaDtoMapper(
        kreirajSelect(null,
            robaIds.stream().map(Long::intValue).collect(
                Collectors.toSet())).orderBy(ROBA.STANJE.desc()
            )
            .fetch());

    podGrupaService.popuniPodgrupe(magacinDto, parametri, roba);
    proizvodjacService.popuniProizvodjace(roba, magacinDto, parametri);

    int start = parametri.getPageSize() * parametri.getPage();
    int end = (start + parametri.getPageSize()) > roba.size() ? roba.size()
        : (start + parametri.getPageSize());
    magacinDto.setRobaDto(new PageImpl<>(roba.subList(start, end),
        PageRequest.of(parametri.getPage(), parametri.getPageSize()), roba.size()));

    return magacinDto;
  }

  /**
   * Ulazna metoda iz glavnog servisa
   */
  public MagacinDto pronadjiPoTrazenojReci(UniverzalniParametri parametri, String trazenaRec) {
    MagacinDto magacinDto = new MagacinDto();

    List<RobaDto> roba = vratiArtikle(parametri, trazenaRec);
    podGrupaService.popuniPodgrupe(magacinDto, parametri, roba);
    proizvodjacService.popuniProizvodjace(roba, magacinDto, parametri);
    if (parametri.getProizvodjac() != null && parametri.getGrupa() != null) {
      roba = filtriIVratiRobu(parametri, roba);
    }

    if (parametri.getRobaKategorije() == null) {
      roba = sortirajPoGrupi(roba);
    }
    int start = parametri.getPageSize() * parametri.getPage();
    int end = (start + parametri.getPageSize()) > roba.size() ? roba.size()
        : (start + parametri.getPageSize());
    magacinDto.setRobaDto(new PageImpl<>(roba.subList(start, end),
        PageRequest.of(parametri.getPage(), parametri.getPageSize()), roba.size()));

    return magacinDto;
  }

  private List<RobaDto> sortirajPoGrupi(List<RobaDto> roba) {
    List<RobaDto> retVal = roba.stream()
        .filter(robaDto -> robaDto.getStanje() > 0)
        .map(robaDto -> {
          if (robaDto.getPodGrupaNaziv() == null) {
            robaDto.setPodGrupaNaziv("ZZZ");
          }
          return robaDto;
        })
        .sorted(Comparator.comparing(RobaDto::getPodGrupaNaziv))
        .collect(Collectors.toList());

    roba.stream()
        .filter(robaDto -> robaDto.getStanje() == 0)
        .map(robaDto -> {
          if (robaDto.getPodGrupaNaziv() == null) {
            robaDto.setPodGrupaNaziv("ZZZ");
          }
          return robaDto;
        })
        .sorted(Comparator.comparing(RobaDto::getPodGrupaNaziv)).forEach(retVal::add);
    return retVal;
  }

  private List<RobaDto> filtriIVratiRobu(UniverzalniParametri parametri, List<RobaDto> roba) {
    return roba.stream()
        .filter(robaDto -> robaDto.getProizvodjac().getProid().equals(parametri.getProizvodjac()))
        .collect(Collectors.toList());
  }

  /**
   * Vrati sve artikle po trazenoj reci
   */
  private List<RobaDto> vratiArtikle(UniverzalniParametri parametri, String trazenaRec) {
    SelectConditionStep<Record8<Integer, String, String, BigDecimal, String, Integer, String, String>> select = kreirajSelect(
        trazenaRec, null);

    if (!StringUtils.isEmpty(trazenaRec)) {
      standardniUslovi(select, trazenaRec, parametri);
    }

    filtrirajPoParametrima(select, parametri);
    sortiranje(select);

    return robaDtoMapper(select.fetch());
  }

  public MagacinDto vratiArtikleIzTecDoca(UniverzalniParametri parametri,
      Set<String> kataloskiBrojevi) {
    MagacinDto magacinDto = new MagacinDto();
    SelectConditionStep<Record8<Integer, String, String, BigDecimal, String, Integer, String, String>> select = kreirajSelect(
        null, null);

    Condition conditionPoslednji;
    Condition condition1 = ROBA.KATBR.in(kataloskiBrojevi);
    Condition condition2 = ROBA.KATBRPRO.in(kataloskiBrojevi);
    conditionPoslednji = condition1.or(condition2);

    select.and(conditionPoslednji);
    filtrirajPoParametrima(select, parametri);
    sortiranje(select);

    List<RobaDto> roba = robaDtoMapper(select.fetch());

    podGrupaService.popuniPodgrupe(magacinDto, parametri, roba);
    proizvodjacService.popuniProizvodjace(roba, magacinDto, parametri);
    if (parametri.getProizvodjac() != null && parametri.getGrupa() != null) {
      roba = filtriIVratiRobu(parametri, roba);
    }

    if (parametri.getRobaKategorije() == null) {
      roba = sortirajPoGrupi(roba);
    }
    sortirajRobuTecDocPoPodgrupi(roba, parametri);
    int start = parametri.getPageSize() * parametri.getPage();
    int end = (start + parametri.getPageSize()) > roba.size() ? roba.size()
        : (start + parametri.getPageSize());
    magacinDto.setRobaDto(new PageImpl<>(roba.subList(start, end),
        PageRequest.of(parametri.getPage(), parametri.getPageSize()), roba.size()));

    return magacinDto;

  }

  private void sortirajRobuTecDocPoPodgrupi(List<RobaDto> robaDtos,
      UniverzalniParametri parametri) {
    List<RobaDto> pronadjenaTacnaRoba = robaDtos.stream()
        .filter(robaDto -> robaDto.getKatbr().equals(parametri.getTrazenaRec()))
        .collect(Collectors.toList());
    if (pronadjenaTacnaRoba.isEmpty()) {
      pronadjenaTacnaRoba = robaDtos.stream()
          .filter(robaDto -> robaDto.getKatbr().contains(parametri.getTrazenaRec()))
          .collect(Collectors.toList());
    }

    if (!pronadjenaTacnaRoba.isEmpty()) {
      int podGrupa = pronadjenaTacnaRoba.get(0).getPodGrupa();
      robaDtos.sort((o1, o2) -> {
        if (o1.getStanje() > 0 && o2.getStanje() > 0) {
          if (podGrupa == o1.getPodGrupa() && podGrupa != o2.getPodGrupa()) {
            return -1;
          } else if (podGrupa != o1.getPodGrupa() && podGrupa == o2.getPodGrupa()) {
            return 1;
          } else {
            return 0;
          }
        } else if (o1.getStanje() == 0 && o2.getStanje() == 0) {
          if (podGrupa == o1.getPodGrupa() && podGrupa != o2.getPodGrupa()) {
            return -1;
          } else if (podGrupa != o1.getPodGrupa() && podGrupa == o2.getPodGrupa()) {
            return 1;
          } else {
            return 0;
          }
        } else {
          return 0;
        }
      });
    }
  }

  /**
   * Mapiranje u dto robe
   */
  private List<RobaDto> robaDtoMapper(
      Result<Record8<Integer, String, String, BigDecimal, String, Integer, String, String>> robaRecords
  ) {
    return robaRecords.stream()
        .map(robaRecord -> RobaDto
            .builder()
            .robaid(robaRecord.component1().longValue())
            .katbr(robaRecord.component2())
            .naziv(robaRecord.component3())
            .stanje(robaRecord.component4() != null ? robaRecord.component4().doubleValue() : 0)
            .grupa(robaRecord.component5())
            .podGrupa(robaRecord.component6())
            .proizvodjac(Proizvodjac.builder().proid(robaRecord.component7()).build())
            .slika(new SlikaDto(robaRecord.component8()))
            .build()
        ).collect(Collectors.toList());
  }

  /**
   * Keriranje selekta za robu
   */
  private SelectConditionStep<Record8<Integer, String, String, BigDecimal, String, Integer, String, String>> kreirajSelect(
      String trazenaRec, Set<Integer> robaId) {
    String trazenaRecLike = "%" + trazenaRec + "%";
    SelectJoinStep<Record8<Integer, String, String, BigDecimal, String, Integer, String, String>> select = dslContext.selectDistinct(
        ROBA.ROBAID, ROBA.KATBR, ROBA.NAZIV, ROBA.STANJE, ROBA.GRUPAID, ROBA.PODGRUPAID, ROBA.PROID,
        ROBA.SLIKA
    ).from(ROBA);
    if (trazenaRec != null) {
      return select.where(ROBA.KATBR.like(trazenaRecLike));
    } else if (robaId != null && !robaId.isEmpty()) {
      return select.where(ROBA.ROBAID.in(robaId));
    } else {
      return select.where("1=1");
    }
  }


  /**
   * Standardni uslovi
   */
  private void standardniUslovi(SelectConditionStep<?> select, String trazenaRec,
      UniverzalniParametri parametri) {
    String pregragaPoTacnojReciLike = "%" + trazenaRec + "%";
    String trazenaRecLike = "%" + trazenaRec.replaceAll("\\s+", "") + "%";

//        Pomocni kveri
    boolean daLiJePetragaPoReci = false;

    Set<String> kataloskiBrojevi = new HashSet<>();
    Set<Long> robaId = new HashSet<>();

    boolean pretragaJePoRecima = pomocniKveriPoRobi(trazenaRecLike, pregragaPoTacnojReciLike,
        kataloskiBrojevi, robaId, parametri);

    if (!pretragaJePoRecima) {
      pomocniKveriPoRobiOld(trazenaRec, kataloskiBrojevi);
    } else {
      daLiJePetragaPoReci = true;
    }
//        Kraj pomocnog kverija

    Condition conditionPoslednji;
    if (daLiJePetragaPoReci) {
      conditionPoslednji = ROBA.KATBR.in(kataloskiBrojevi);
    } else {
      Condition condition1 = ROBA.KATBR.in(kataloskiBrojevi);
      Condition condition2 = ROBA.KATBRPRO.in(kataloskiBrojevi);
      conditionPoslednji = condition1.or(condition2);
    }

    select.or(conditionPoslednji);
    if (!daLiJePetragaPoReci) {
      select.or(ROBA.NAZIV.like(trazenaRecLike));
    }
  }

  public boolean pomocniKveriPoRobi(String trazenaRecLike, String tacnaRecLike,
      Set<String> kataloskiBrojevi, Set<Long> robaId, UniverzalniParametri parametri) {
    List<String> nazivi = new ArrayList<>();
    var select = dslContext.selectDistinct(ROBA.KATBR, ROBA.KATBRPRO, ROBA.ROBAID, ROBA.NAZIV)
        .from(ROBA)
        .where(
            ROBA.KATBR.like(trazenaRecLike)
                .or(ROBA.KATBRPRO.like(trazenaRecLike))
                .or(ROBA.NAZIV.like(tacnaRecLike)));

    if (StringUtils.hasText(parametri.getProizvodjac())) {
      select.and(ROBA.PROID.eq(parametri.getProizvodjac()));
    }

    if (parametri.isNaStanju()) {
      select.and(ROBA.STANJE.gt(BigDecimal.ZERO));
    }
    select.fetch().stream()
        .forEach(rekord -> {

          if (rekord.component1() != null && !StringUtils.isEmpty(rekord.component1())) {
            kataloskiBrojevi.add(rekord.component1());
          }

          if (rekord.component2() != null && !StringUtils.isEmpty(rekord.component2())) {
            kataloskiBrojevi.add(rekord.component2());
          }

          if (rekord.component3() != null) {
            robaId.add(rekord.component3().longValue());
          }

          if (rekord.component4() != null) {
            nazivi.add(rekord.component4());
          }
        });
    prodjiIPopraviKatBr(kataloskiBrojevi);
    boolean pretragaJePoRecima = true;
    String pretragaNaziv = tacnaRecLike.replace("%", "");
    if (!nazivi.isEmpty()) {
      for (String naziv : nazivi) {
        if (!naziv.contains(pretragaNaziv)) {
          pretragaJePoRecima = false;
        } else {
          pretragaJePoRecima = true;
          break;
        }
      }
    } else {
      pretragaJePoRecima = false;
    }
    return pretragaJePoRecima;
  }

  public void pomocniKveriPoRobiOld(String trazenaRec, Set<String> kataloskiBrojevi) {
    dslContext.selectDistinct(ROBA_KATBR_OLD.KATBR, ROBA_KATBR_OLD.KATBRPRO)
        .from(ROBA_KATBR_OLD)
        .where(
            ROBA_KATBR_OLD.KATBR.like(trazenaRec)
                .or(ROBA_KATBR_OLD.KATBR.in(kataloskiBrojevi))
                .or(ROBA_KATBR_OLD.KATBRPRO.like(trazenaRec))
                .or(ROBA_KATBR_OLD.KATBRPRO.in(kataloskiBrojevi)))
        .fetch().stream()
        .forEach(rekord -> {

          if (rekord.component1() != null && !StringUtils.isEmpty(rekord.component1())) {
            kataloskiBrojevi.add(rekord.component1());
          }

          if (rekord.component2() != null && !StringUtils.isEmpty(rekord.component2())) {
            kataloskiBrojevi.add(rekord.component2());
          }
        });
    prodjiIPopraviKatBr(kataloskiBrojevi);
  }

  private void prodjiIPopraviKatBr(Set<String> retVal) {
    Set<String> noviKatBrojevi = new HashSet<>();
    retVal.forEach(katBrojevi -> {
      String noviBroj = GeneralUtil.cyrillicToLatinic(katBrojevi.replace(" ", "").toUpperCase());
      noviKatBrojevi.add(noviBroj);
    });
    retVal.clear();
    retVal.addAll(noviKatBrojevi);
  }

  /**
   * Upiti u slucaju da se trazi specificna grupa
   */
  private void filtrirajPoParametrima(SelectConditionStep<?> select,
      UniverzalniParametri parametri) {
    if (parametri.getRobaKategorije() != null
        && parametri.getRobaKategorije().isGrupaPretraga()) {
      select.and(ROBA.GRUPAID.in(parametri.getRobaKategorije().getFieldName()));
    } else if (parametri.getRobaKategorije() != null
        && parametri.getRobaKategorije().isPodgrupaPretraga()) {
      select.and(ROBA.PODGRUPAID.in(parametri.getPodGrupe().stream().map(PodGrupa::getPodGrupaId)
          .collect(Collectors.toList())));
    }

    if (!StringUtils.isEmpty(parametri.getProizvodjac())) {
      select.and(ROBA.PROID.eq(parametri.getProizvodjac()));
    }

    if (!StringUtils.isEmpty(parametri.getPodgrupaZaPretragu())) {
      List<Integer> podgrupe = parametri.getPodGrupe().stream().filter(
              podGrupa -> podGrupa.getNaziv().equalsIgnoreCase(parametri.getPodgrupaZaPretragu()))
          .map(PodGrupa::getPodGrupaId).collect(Collectors.toList());
      if (!podgrupe.isEmpty()) {
        select.and(ROBA.PODGRUPAID.in(podgrupe));
      }
    }
    if (parametri.isNaStanju()) {
      select.and(ROBA.STANJE.greaterThan(new BigDecimal(0)));
    }
  }

  /**
   * Limitiranje pogodataka zbog paginacije
   */
  private void sortiranje(SelectConditionStep<?> select) {
    select.orderBy(ROBA.STANJE.desc());
  }

  /**
   * Zbog n+1 u hibernate koristimo jooq da vrati svu robu u zavisnosti od podgrupe
   */
  public Page<Roba> pronadjiSvuRobuPoPodgrupama(List<PodGrupa> podGrupaId, boolean naStanju,
      Pageable pageable) {
    SelectConditionStep<RobaRecord> select = dslContext
        .selectFrom(ROBA)
        .where(ROBA.PODGRUPAID.in(
            podGrupaId.stream().map(PodGrupa::getPodGrupaId).collect(Collectors.toList())));
    if (naStanju) {
      select.and(ROBA.STANJE.greaterThan(BigDecimal.ZERO));
    }
    select.orderBy(ROBA.STANJE.desc());

    List<Roba> roba = select.fetch().stream().map(mapper::map).collect(Collectors.toList());
    int start = pageable.getPageSize() * pageable.getPageNumber();
    int end = (start + pageable.getPageSize()) > roba.size() ? roba.size()
        : (start + pageable.getPageSize());
    List<Roba> retVal = roba.subList(start, end);

    retVal.forEach(rekord ->
        proizvodjacService.vratiProizvodjacaPoPk(rekord.getProizvodjac().getProid())
            .ifPresent(rekord::setProizvodjac)
    );

    return new PageImpl<>(retVal, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()),
        roba.size());
  }

  public DashboardDto vracanjePodatakaZaDashboard() {
    DashboardDto dashboardDto = new DashboardDto();
    List<String> svProizvodjaci = dslContext
        .select()
        .from(ROBA)
        .where(ROBA.STANJE.greaterThan(BigDecimal.ZERO)).fetch(ROBA.PROID);
    dashboardDto.setBrojArtikala(svProizvodjaci.size());
    Set<String> proizvodjaciSet = new HashSet<>(svProizvodjaci);
    dashboardDto.setBrojProizvodjaca(new ArrayList(proizvodjaciSet).size());
    return dashboardDto;
  }
}
