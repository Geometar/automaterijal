package com.automaterijal.application.domain.repository.roba;

import com.automaterijal.application.domain.constants.VrstaRobe;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.utils.GeneralUtil;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    private static final Short PROIZVODJAC_ID = 4;

    /**
     * Ulazna metoda iz glavnog servisa
     */
    public Page<RobaDto> pronadjiPoTrazenojReci(UniverzalniParametri parametri, String trazenaRec) {
        List<RobaDto> roba = vratiArtikleSaPaginacijom(parametri, trazenaRec);
        int start = parametri.getPageSize() * parametri.getPage();
        int end = (start + parametri.getPageSize()) > roba.size() ? roba.size() : (start + parametri.getPageSize());
        return new PageImpl<>(roba.subList(start, end), PageRequest.of(parametri.getPage(), parametri.getPageSize()), roba.size());
    }

    /**
     * Vrati sve artikle po trazenoj reci
     */
    private List<RobaDto> vratiArtikleSaPaginacijom(UniverzalniParametri parametri, String trazenaRec) {
        SelectConditionStep<Record7<Integer, String, String, BigDecimal, String, Integer, String>> select = kreirajSelect(trazenaRec);

        if (!StringUtils.isEmpty(trazenaRec)) {
            standardniUslovi(select, trazenaRec);
        }

        filtrirajPoParametrima(select, parametri);
        sortiranje(select, parametri);

        return robaDtoMapper(select.fetch());
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
        pomocniKveriPoRobi(trazenaRecLike, pregragaPoTacnojReciLike, kataloskiBrojevi, robaId);
        if (kataloskiBrojevi.size() < 30) {
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

    private void pomocniKveriPoRobi(String trazenaRecLike, String tacnaRecLike, Set<String> kataloskiBrojevi, Set<Integer> robaId) {
        dslContext.selectDistinct(ROBA.KATBR, ROBA.KATBRPRO, ROBA.ROBAID)
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
                });
        prodjiIPopraviKatBr(kataloskiBrojevi);

    }

    private void pomocniKveriPoRobiOld(String trazenaRec, Set<String> kataloskiBrojevi) {
        dslContext.selectDistinct(ROBA_KATBR_OLD.KATBR, ROBA_KATBR_OLD.KATBRPRO)
                .from(ROBA_KATBR_OLD)
                .where(
                        ROBA_KATBR_OLD.KATBR.like(trazenaRec)
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
        SelectConditionStep<Record3<String, String, Integer>> selectConditionStep = dslContext.selectDistinct(TD_BROJEVI.BROJ, TD_BROJEVI.BROJSRCH, TD_BROJEVI.ROBAID)
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
            if (record.component3() != null) {
                robaIdIzTd.add(record.component3());
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
        SelectJoinStep<Record2<String, String>> select = dslContext.selectDistinct(TD_BROJEVI.BROJSRCH, TD_BROJEVI.BROJ)
                .from(TD_BROJEVI);
        robaIds.forEach(robaId -> {
            Condition condition1 = TD_BROJEVI.ROBAID.eq(robaId);
            Condition condition2 = TD_BROJEVI.VRSTA.eq(PROIZVODJAC_ID);
            Condition combined = condition1.and(condition2);
            conditions.add(combined);
        });

        if (!conditions.isEmpty()) {
            SelectConditionStep<Record2<String, String>> select2 = select.where(conditions.get(0));
            for (int i = 1; i < conditions.size(); i++) {
                select2.or(conditions.get(i));
            }
        }

        select.fetch().forEach(record -> {
            if (record.component1() != null && !StringUtils.isEmpty(record.component1())) {
                katalskoBrojevi.add(record.component1());
            }
            if (record.component2() != null && !StringUtils.isEmpty(record.component2())) {
                katalskoBrojevi.add(record.component2());
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
        if (!VrstaRobe.SVE.equals(parametri.getVrstaRobe())) {
            switch (parametri.getVrstaRobe()) {
                case OSTALO:
                case ULJA:
                case FILTERI:
                    select.and(ROBA.PODGRUPAID.in(parametri.getPodGrupeId()));
                    break;
                case AKUMULATORI:
                    select.and(ROBA.GRUPAID.in(parametri.getGrupeId()));
                    break;
            }
        }

        if (!StringUtils.isEmpty(parametri.getProizvodjac())) {
            select.and(ROBA.PROID.eq(parametri.getProizvodjac()));
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
}
