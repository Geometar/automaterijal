package com.automaterijal.application.domain.repository.roba;

import com.automaterijal.application.domain.constants.VrstaRobe;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.model.UniverzalniParametri;
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

import static com.automaterijal.db.tables.Proizvodjac.PROIZVODJAC;
import static com.automaterijal.db.tables.Roba.ROBA;
import static com.automaterijal.db.tables.RobaKatbrOld.ROBA_KATBR_OLD;
import static com.automaterijal.db.tables.TdBrojevi.TD_BROJEVI;

@Repository
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaJooqRepository {

    @Autowired
    DSLContext dslContext;

    /**
     * Ulazna metoda iz glavnog servisa
     */
    public Page<RobaDto> pronadjiPoTrazenojReci(UniverzalniParametri parametri, String trazenaRec) {
        long ukupnoArtikala = brojPogodaka(parametri, trazenaRec);
        List<RobaDto> roba = ukupnoArtikala > 0 ? vratiArtikleSaPaginacijom(parametri, trazenaRec) : new ArrayList<>();
        return new PageImpl<>(roba, PageRequest.of(parametri.getPage(), parametri.getPageSize()), ukupnoArtikala);
    }

    /**
     * Vrati sve artikle po trazenoj reci
     */
    private List<RobaDto> vratiArtikleSaPaginacijom(UniverzalniParametri parametri, String trazenaRec) {
        SelectConditionStep<Record8<Integer, String, String, BigDecimal, String, Integer, String, String>> select = kreirajSelect();

        if (!StringUtils.isEmpty(trazenaRec)) {
            standardniUslovi(select, trazenaRec);
        }

        filtrirajPoParametrima(select, parametri);
        paginacijaISortiranje(select, parametri);

        return robaDtoMapper(select.fetch());
    }

    /**
     * Metoda sluzi za racunanje broja pogodaka sql kverija
     */
    private long brojPogodaka(UniverzalniParametri parametri, String trazenaRec) {
        SelectConditionStep<?> select = kreirajSelect();
        if (!StringUtils.isEmpty(trazenaRec)) {
            standardniUslovi(select, trazenaRec);
        }
        filtrirajPoParametrima(select, parametri);
        return dslContext.fetchCount(select);
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
                        .podGrupa(robaRecord.component6().toString())
                        .proizvodjac(new Proizvodjac(robaRecord.component7(), robaRecord.component8()))
                        .build()
                ).collect(Collectors.toList());
    }

    /**
     * Keriranje selekta za robu
     */
    private SelectConditionStep<Record8<Integer, String, String, BigDecimal, String, Integer, String, String>> kreirajSelect() {
        return dslContext.selectDistinct(
                ROBA.ROBAID, ROBA.KATBR, ROBA.NAZIV, ROBA.STANJE, ROBA.GRUPAID, ROBA.PODGRUPAID,
                PROIZVODJAC.PROID, PROIZVODJAC.NAZIV.as("proizvodjacNaziv")
        )
                .from(ROBA)
                .leftJoin(PROIZVODJAC).using(ROBA.PROID)
                .where("1=1");
    }


    /**
     * Standardni uslovi
     */
    private void standardniUslovi(SelectConditionStep<?> select, String trazenaRec) {
        String trazenaRecLike = "%" + trazenaRec + "%";
        Set<String> sveKombinacijaKataloskihBrojeva = vratiSvePomocneKataloskeBrojeve(trazenaRec, trazenaRecLike);
        select.and(
                ROBA.KATBRPRO.like(trazenaRecLike)
                        .or(ROBA.KATBR.in(sveKombinacijaKataloskihBrojeva))
                        .or(ROBA.KATBRPRO.in(sveKombinacijaKataloskihBrojeva))
                        .or(ROBA.NAZIV.like(trazenaRecLike)));
    }

    /**
     * Pomocni sql kveri za pretragu svih sifara u raznim tabelama
     */
    private Set<String> vratiSvePomocneKataloskeBrojeve(String trazenaRec, String trazenaRecLike) {
        Set<String> retVal = new HashSet<>();
        dslContext.select(ROBA.KATBR, ROBA.KATBRPRO, ROBA_KATBR_OLD.KATBR, ROBA_KATBR_OLD.KATBRPRO, TD_BROJEVI.NADJENPREKO)
                .from(ROBA)
                .leftJoin(ROBA_KATBR_OLD).using(ROBA.ROBAID)
                .leftJoin(TD_BROJEVI).using(ROBA.ROBAID)
                .where(
                        ROBA.KATBR.like(trazenaRecLike)
                                .or(ROBA.KATBRPRO.like(trazenaRecLike))
                                .or(ROBA_KATBR_OLD.KATBR.like(trazenaRecLike))
                                .or(ROBA_KATBR_OLD.KATBRPRO.like(trazenaRecLike))
                                .or(TD_BROJEVI.BROJ.eq(trazenaRec))
                                .or(TD_BROJEVI.BROJSRCH.eq(trazenaRec)))
                .fetch().stream()
                .forEach(rekord -> {
                    procesuirajRekorde(retVal, rekord);
                });
        prodjiIPopraviKatBr(retVal);
        drugiPomocniKveri(retVal);
        return retVal;
    }

    private void drugiPomocniKveri(Set<String> katalskoBrojevi) {
        dslContext.selectDistinct(ROBA.KATBR, ROBA.KATBRPRO, ROBA_KATBR_OLD.KATBR)
                .from(ROBA)
                .leftJoin(ROBA_KATBR_OLD).using(ROBA.ROBAID)
                .where(ROBA.KATBRPRO.in(katalskoBrojevi))
                .or(ROBA_KATBR_OLD.KATBR.in(katalskoBrojevi))
                .or(ROBA_KATBR_OLD.KATBRPRO.in(katalskoBrojevi))
                .fetch().stream().forEach(rekordi -> {
            katalskoBrojevi.add(rekordi.component1());
            katalskoBrojevi.add(rekordi.component2());
            katalskoBrojevi.add(rekordi.component3());
        });
    }

    private void prodjiIPopraviKatBr(Set<String> retVal) {
        Set<String> noviKatBrojevi = new HashSet<>();
        retVal.forEach(katBrojevi -> {
            String noviBroj = katBrojevi.replace(" ", "").toUpperCase();
            noviKatBrojevi.add(noviBroj);
        });
        retVal.addAll(noviKatBrojevi);
    }

    /**
     * Procesuiramo pomocni kveri i stavljamo samo razlicite kataloske brojeve
     */
    private void procesuirajRekorde(Set<String> lista, Record5 record) {
        if (record.component1() != null && !StringUtils.isEmpty(record.component1().toString())) {
            lista.add(record.component1().toString());
        }
        if (record.component2() != null && !StringUtils.isEmpty(record.component2().toString())) {
            lista.add(record.component2().toString());
        }
        if (record.component3() != null && !StringUtils.isEmpty(record.component3().toString())) {
            lista.add(record.component3().toString());
        }
        if (record.component4() != null && !StringUtils.isEmpty(record.component4().toString())) {
            lista.add(record.component4().toString());
        }
        if (record.component5() != null && !StringUtils.isEmpty(record.component5().toString())) {
            lista.add(record.component5().toString());
        }
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
            select.and(PROIZVODJAC.PROID.eq(parametri.getProizvodjac()));
        }

        if (parametri.isNaStanju()) {
            select.and(ROBA.STANJE.greaterThan(new BigDecimal(0)));
        } else {
            select.and(ROBA.STANJE.greaterOrEqual(new BigDecimal(0)));
        }
    }

    /**
     * Limitiranje pogodataka zbog paginacije
     */
    private void paginacijaISortiranje(SelectConditionStep<?> select, UniverzalniParametri parametri) {
        select.limit(parametri.getPageSize()).offset(parametri.getPage());
        select.orderBy(ROBA.STANJE.desc());
    }
}
