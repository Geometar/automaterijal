package com.automaterijal.application.domain.repository.roba;

import com.automaterijal.application.client.TecDocClient;
import com.automaterijal.application.domain.dto.DashboardDto;
import com.automaterijal.application.domain.dto.MagacinDto;
import com.automaterijal.application.domain.dto.RobaDto;
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
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.*;
import java.util.stream.Collectors;

import static com.automaterijal.db.tables.Roba.ROBA;
import static com.automaterijal.db.tables.RobaKatbrOld.ROBA_KATBR_OLD;
import static com.automaterijal.db.tables.TdBrojevi.TD_BROJEVI;

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

    private static final Short PROIZVODJAC_ID = 4;

    /**
     * Ulazna metoda iz glavnog servisa
     */
    public MagacinDto pronadjiPoTrazenojReci(UniverzalniParametri parametri, String trazenaRec) {
        MagacinDto magacinDto = new MagacinDto();

        List<RobaDto> roba = vratiArtikle(parametri, trazenaRec);
        podGrupaService.popuniPodgrupe(magacinDto, parametri, roba);
        proizvodjacService.popuniProizvodjace(roba, magacinDto, parametri);
        if (parametri.getProizvodjac() != null && parametri.getGrupa() != null) {
            roba = filtriIVratiRobu(parametri, magacinDto, roba);
        }

        if (parametri.getRobaKategorije() == null) {
            roba = sortirajPoGrupi(roba);
        }
        int start = parametri.getPageSize() * parametri.getPage();
        int end = (start + parametri.getPageSize()) > roba.size() ? roba.size() : (start + parametri.getPageSize());
        magacinDto.setRobaDto(new PageImpl<>(roba.subList(start, end), PageRequest.of(parametri.getPage(), parametri.getPageSize()), roba.size()));

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

    private List<RobaDto> filtriIVratiRobu(UniverzalniParametri parametri, MagacinDto magacinDto, List<RobaDto> roba) {
        return roba.stream()
                .filter(robaDto -> robaDto.getProizvodjac().getProid().equals(parametri.getProizvodjac()))
                .collect(Collectors.toList());
    }

    /**
     * Vrati sve artikle po trazenoj reci
     */
    private List<RobaDto> vratiArtikle(UniverzalniParametri parametri, String trazenaRec) {
        SelectConditionStep<Record7<Integer, String, String, BigDecimal, String, Integer, String>> select = kreirajSelect(trazenaRec);

        if (!StringUtils.isEmpty(trazenaRec)) {
            standardniUslovi(select, trazenaRec);
        }

        filtrirajPoParametrima(select, parametri);
        sortiranje(select, parametri);

        return robaDtoMapper(select.fetch());
    }

    public MagacinDto vratiArtikleIzTecDoca(UniverzalniParametri parametri, Set<String> kataloskiBrojevi, String trazenaRecLike) {
        MagacinDto magacinDto = new MagacinDto();
        SelectConditionStep<Record7<Integer, String, String, BigDecimal, String, Integer, String>> select = kreirajSelect(null);


        Condition conditionPoslednji;
        Condition condition1 = ROBA.KATBR.in(kataloskiBrojevi);
        Condition condition2 = ROBA.KATBRPRO.in(kataloskiBrojevi);
        conditionPoslednji = condition1.or(condition2);

        select.and(conditionPoslednji);
        filtrirajPoParametrima(select, parametri);
        sortiranje(select, parametri);

        filtrirajPoParametrima(select, parametri);
        sortiranje(select, parametri);

        List<RobaDto> roba = robaDtoMapper(select.fetch());

        podGrupaService.popuniPodgrupe(magacinDto, parametri, roba);
        proizvodjacService.popuniProizvodjace(roba, magacinDto, parametri);
        if (parametri.getProizvodjac() != null && parametri.getGrupa() != null) {
            roba = filtriIVratiRobu(parametri, magacinDto, roba);
        }

        if (parametri.getRobaKategorije() == null) {
            roba = sortirajPoGrupi(roba);
            sortirajRobuTecDocPoPodgrupi(roba, parametri);
        }
        int start = parametri.getPageSize() * parametri.getPage();
        int end = (start + parametri.getPageSize()) > roba.size() ? roba.size() : (start + parametri.getPageSize());
        magacinDto.setRobaDto(new PageImpl<>(roba.subList(start, end), PageRequest.of(parametri.getPage(), parametri.getPageSize()), roba.size()));

        return magacinDto;

    }

    private void sortirajRobuTecDocPoPodgrupi(List<RobaDto> robaDtos, UniverzalniParametri parametri) {
        List<RobaDto> pronadjenaTacnaRoba = robaDtos.stream().filter(robaDto -> robaDto.getKatbr().equals(parametri.getTrazenaRec())).collect(Collectors.toList());
        if (pronadjenaTacnaRoba.isEmpty()) {
            pronadjenaTacnaRoba = robaDtos.stream().filter(robaDto -> robaDto.getKatbr().contains(parametri.getTrazenaRec())).collect(Collectors.toList());
        }

        if (!pronadjenaTacnaRoba.isEmpty()) {
            RobaDto robaDto = pronadjenaTacnaRoba.get(0);
            robaDtos.sort((o1, o2) -> {
                if (o1.getStanje() > 0 && o2.getStanje() > 0 && o1.getPodGrupa().equals(robaDto.getPodGrupa()) && !o2.getPodGrupa().equals(robaDto.getPodGrupa())) {
                    return -1;
                } else if (o1.getStanje() == 0 && o2.getStanje() == 0 && o1.getPodGrupa().equals(robaDto.getPodGrupa()) && !o2.getPodGrupa().equals(robaDto.getPodGrupa())) {
                    return -1;
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
            Result<Record7<Integer, String, String, BigDecimal, String, Integer, String>> robaRecords
    ) {
        return robaRecords.stream()
                .map(robaRecord -> RobaDto
                        .builder()
                        .robaid(robaRecord.component1().longValue())
                        .katbr(robaRecord.component2())
                        .naziv(robaRecord.component3())
                        .stanje(robaRecord.component4() != null ? robaRecord.component4().doubleValue() : 0)
                        .grupa(robaRecord.component5())
                        .podGrupa(robaRecord.component6().toString())
                        .proizvodjac(Proizvodjac.builder().proid(robaRecord.component7()).build())
                        .build()
                ).collect(Collectors.toList());
    }

    /**
     * Keriranje selekta za robu
     */
    private SelectConditionStep<Record7<Integer, String, String, BigDecimal, String, Integer, String>> kreirajSelect(String trazenaRec) {
        String trazenaRecLike = "%" + trazenaRec + "%";
        SelectJoinStep<Record7<Integer, String, String, BigDecimal, String, Integer, String>> select = dslContext.selectDistinct(
                ROBA.ROBAID, ROBA.KATBR, ROBA.NAZIV, ROBA.STANJE, ROBA.GRUPAID, ROBA.PODGRUPAID, ROBA.PROID
        ).from(ROBA);
        if (trazenaRec != null) {
            return select.where(ROBA.KATBR.like(trazenaRecLike));
        } else {
            return select.where("1=1");
        }
    }


    /**
     * Standardni uslovi
     */
    private void standardniUslovi(SelectConditionStep<?> select, String trazenaRec) {
        String pregragaPoTacnojReciLike = "%" + trazenaRec + "%";
        String trazenaRecLike = "%" + trazenaRec.replaceAll("\\s+", "") + "%";

//        Pomocni kveri
        boolean daLiJePetragaPoReci = false;

        Set<String> kataloskiBrojevi = new HashSet<>();
        Set<Integer> robaId = new HashSet<>();

        boolean pretragaJePoRecima = pomocniKveriPoRobi(trazenaRecLike, pregragaPoTacnojReciLike, kataloskiBrojevi, robaId);

        if (!pretragaJePoRecima) {
            pomocniKveriPoRobiOld(trazenaRec, kataloskiBrojevi);
            drugiPomocniKveri(kataloskiBrojevi, robaId, trazenaRec);
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

    public boolean pomocniKveriPoRobi(String trazenaRecLike, String tacnaRecLike, Set<String> kataloskiBrojevi, Set<Integer> robaId) {
        List<String> nazivi = new ArrayList<>();
        dslContext.selectDistinct(ROBA.KATBR, ROBA.KATBRPRO, ROBA.ROBAID, ROBA.NAZIV)
                .from(ROBA)
                .where(
                        ROBA.KATBR.like(trazenaRecLike)
                                .or(ROBA.KATBRPRO.like(trazenaRecLike))
                                .or(ROBA.NAZIV.like(tacnaRecLike)))
                .fetch().stream()
                .forEach(rekord -> {

                    if (rekord.component1() != null && !StringUtils.isEmpty(rekord.component1())) {
                        kataloskiBrojevi.add(rekord.component1());
                    }

                    if (rekord.component2() != null && !StringUtils.isEmpty(rekord.component2())) {
                        kataloskiBrojevi.add(rekord.component2());
                    }

                    if (rekord.component3() != null) {
                        robaId.add(rekord.component3());
                    }

                    if (rekord.component4() != null) {
                        nazivi.add(rekord.component4());
                    }
                });
        prodjiIPopraviKatBr(kataloskiBrojevi);
        boolean pretragaJePoRecima = true;
        String pretragaNaziv = tacnaRecLike.replace("%", "");
        if (nazivi != null && !nazivi.isEmpty()) {
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

    private void drugiPomocniKveri(Set<String> katalskoBrojevi, Set<Integer> robaIds, String trazenaRec) {
        Set<Integer> robaIdIzTd = new HashSet<>();
        SelectConditionStep<Record4<String, String, String, Integer>> selectConditionStep = dslContext.selectDistinct(TD_BROJEVI.BROJ, TD_BROJEVI.BROJSRCH, TD_BROJEVI.FABRBROJ, TD_BROJEVI.ROBAID)
                .from(TD_BROJEVI)
                .where(TD_BROJEVI.NADJENPREKO.eq(trazenaRec))
                .or(TD_BROJEVI.BROJ.eq(trazenaRec))
                .or(TD_BROJEVI.FABRBROJ.eq(trazenaRec))
                .or(TD_BROJEVI.NADJENPREKO.eq(trazenaRec))
                .or(TD_BROJEVI.BROJSRCH.eq(trazenaRec.replaceAll("\\s+", "")));

        katalskoBrojevi.stream().filter(ktBr -> !ktBr.equals(trazenaRec)).forEach(kBroj -> {
            selectConditionStep.or(TD_BROJEVI.FABRBROJ.eq(kBroj))
                    .or(TD_BROJEVI.NADJENPREKO.eq(kBroj))
                    .or(TD_BROJEVI.BROJ.eq(kBroj))
                    .or(TD_BROJEVI.BROJSRCH.eq(kBroj));
        });

        robaIds.forEach(robaId -> {
            Condition condition1 = TD_BROJEVI.ROBAID.eq(robaId);
            Condition condition2 = (TD_BROJEVI.VRSTA.eq(PROIZVODJAC_ID));
            Condition conditionCombined = condition1.and(condition2);
            selectConditionStep.or(conditionCombined);
        });

        selectConditionStep.fetch().stream().forEach(record -> {
            if (record.component1() != null && !StringUtils.isEmpty(record.component1())) {
                katalskoBrojevi.add(record.component1());
            }
            if (record.component2() != null && !StringUtils.isEmpty(record.component2())) {
                katalskoBrojevi.add(record.component2());
            }
            if (record.component3() != null && !StringUtils.isEmpty(record.component3())) {
                katalskoBrojevi.add(record.component3());
            }
            if (record.component4() != null) {
                robaIdIzTd.add(record.component4());
            }
        });
        boolean robaPostojalaUTD = false;
        for (Integer id : robaIdIzTd) {
            if (robaIds.contains(id)) {
                robaPostojalaUTD = true;
            }
        }

        if (!robaIdIzTd.isEmpty() && (robaIds.isEmpty() || !robaPostojalaUTD)) {
            pomocniKveri3(robaIdIzTd, katalskoBrojevi);
        }
        prodjiIPopraviKatBr(katalskoBrojevi);
    }

    private void pomocniKveri3(Set<Integer> robaIds, Set<String> katalskoBrojevi) {
        List<Condition> conditions = new ArrayList<>();
        SelectJoinStep<Record1<String>> select = dslContext.selectDistinct(TD_BROJEVI.BROJSRCH)
                .from(TD_BROJEVI);
        robaIds.forEach(robaId -> {
            Condition condition1 = TD_BROJEVI.ROBAID.eq(robaId);
            Condition condition2 = TD_BROJEVI.VRSTA.eq(PROIZVODJAC_ID);
            Condition combined = condition1.and(condition2);
            conditions.add(combined);
        });

        if (!conditions.isEmpty()) {
            SelectConditionStep<Record1<String>> select2 = select.where(conditions.get(0));
            for (int i = 1; i < conditions.size(); i++) {
                select2.or(conditions.get(i));
            }
        }

        select.fetch().forEach(record -> {
            if (record.component1() != null && !StringUtils.isEmpty(record.component1())) {
                katalskoBrojevi.add(record.component1());
            }
        });
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
    private void filtrirajPoParametrima(SelectConditionStep<?> select, UniverzalniParametri parametri) {
        if (parametri.getRobaKategorije() != null && parametri.getRobaKategorije().isGrupaPretraga() == true) {
            select.and(ROBA.GRUPAID.in(parametri.getRobaKategorije().getFieldName()));
        } else if (parametri.getRobaKategorije() != null && parametri.getRobaKategorije().isPodgrupaPretraga() == true) {
            select.and(ROBA.PODGRUPAID.in(parametri.getPodGrupe().stream().map(PodGrupa::getPodGrupaId).collect(Collectors.toList())));
        }

        if (!StringUtils.isEmpty(parametri.getProizvodjac())) {
            select.and(ROBA.PROID.eq(parametri.getProizvodjac()));
        }

        if (!StringUtils.isEmpty(parametri.getPodgrupaZaPretragu())) {
            List<Integer> podgrupe = parametri.getPodGrupe().stream().filter(podGrupa -> podGrupa.getNaziv().equalsIgnoreCase(parametri.getPodgrupaZaPretragu())).map(PodGrupa::getPodGrupaId).collect(Collectors.toList());
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
    private void sortiranje(SelectConditionStep<?> select, UniverzalniParametri parametri) {
        select.orderBy(ROBA.STANJE.desc());
    }

    /**
     * Zbog n+1 u hibernate koristimo jooq da vrati svu robu u zavisnosti od podgrupe
     */
    public Page<Roba> pronadjiSvuRobuPoPodgrupama(List<PodGrupa> podGrupaId, boolean naStanju, Pageable pageable) {
        SelectConditionStep<RobaRecord> select = dslContext
                .selectFrom(ROBA)
                .where(ROBA.PODGRUPAID.in(podGrupaId.stream().map(PodGrupa::getPodGrupaId).collect(Collectors.toList())));
        if (naStanju) {
            select.and(ROBA.STANJE.greaterThan(BigDecimal.ZERO));
        }
        select.orderBy(ROBA.STANJE.desc());

        List<Roba> roba = select.fetch().stream().map(mapper::map).collect(Collectors.toList());
        int start = pageable.getPageSize() * pageable.getPageNumber();
        int end = (start + pageable.getPageSize()) > roba.size() ? roba.size() : (start + pageable.getPageSize());
        List<Roba> retVal = roba.subList(start, end);

        retVal.forEach(rekord -> {
            proizvodjacService.vratiProizvodjacaPoPk(rekord.getProizvodjac().getProid()).ifPresent(proizvodjac -> rekord.setProizvodjac(proizvodjac));
        });

        return new PageImpl<>(retVal, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()), roba.size());
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
