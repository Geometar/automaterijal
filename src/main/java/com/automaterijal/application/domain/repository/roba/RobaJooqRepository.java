package com.automaterijal.application.domain.repository.roba;

import com.automaterijal.application.domain.constants.VrstaRobe;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record8;
import org.jooq.Result;
import org.jooq.SelectConditionStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
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

    private static final Short PROIZVODJAC_ID = 4;

    /**
     * Ulazna metoda iz glavnog servisa
     */
    public Page<RobaDto> pronadjiPoTrazenojReci(UniverzalniParametri parametri, String trazenaRec) {
        List<RobaDto> roba = vratiArtikleSaPaginacijom(parametri, trazenaRec);
        int start = parametri.getPageSize() * parametri.getPage();
        int end = (start + parametri.getPageSize()) > roba.size() ? roba.size() : (start + parametri.getPageSize());
        return new PageImpl<RobaDto>(roba.subList(start, end), PageRequest.of(parametri.getPage(), parametri.getPageSize()), roba.size());
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
        sortiranje(select, parametri);

        return robaDtoMapper(select.fetch());
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
                .join(PROIZVODJAC).using(ROBA.PROID)
                .where("1=1");
    }


    /**
     * Standardni uslovi
     */
    private void standardniUslovi(SelectConditionStep<?> select, String trazenaRec) {
        String trazenaRecLike = "%" + trazenaRec + "%";
        Set<String> sveKombinacijaKataloskihBrojeva = vratiSvePomocneKataloskeBrojeve(trazenaRec, trazenaRecLike);
        select.and(ROBA.KATBR.in(sveKombinacijaKataloskihBrojeva))
                .or(ROBA.KATBRPRO.in(sveKombinacijaKataloskihBrojeva))
                .or(ROBA.NAZIV.like(trazenaRecLike))
                .or(PROIZVODJAC.NAZIV.like(trazenaRecLike));
    }

    /**
     * Pomocni sql kveri za pretragu svih sifara u raznim tabelama
     */
    private Set<String> vratiSvePomocneKataloskeBrojeve(String trazenaRec, String trazenaRecLike) {
        Set<String> kataloskiBrojevi = new HashSet<>();
        Set<Integer> robaId = new HashSet<>();
        dslContext.selectDistinct(ROBA.KATBR, ROBA.KATBRPRO, ROBA_KATBR_OLD.KATBRPRO, ROBA.ROBAID)
                .from(ROBA)
                .leftJoin(ROBA_KATBR_OLD).using(ROBA.ROBAID)
                .leftJoin(TD_BROJEVI).using(ROBA.ROBAID)
                .where(
                        ROBA.KATBR.like(trazenaRecLike)
                                .or(ROBA.KATBRPRO.like(trazenaRecLike))
                                .or(ROBA_KATBR_OLD.KATBR.like(trazenaRecLike))
                                .or(ROBA_KATBR_OLD.KATBRPRO.like(trazenaRecLike))
                                .or(TD_BROJEVI.BROJ.eq(trazenaRec))
                                .or(TD_BROJEVI.BROJSRCH.eq(trazenaRec))
                                .or(TD_BROJEVI.FABRBROJ.eq(trazenaRec))
                                .or(TD_BROJEVI.NADJENPREKO.eq(trazenaRec)))
                .fetch().stream()
                .forEach(rekord -> {

                    if (rekord.component1() != null && !StringUtils.isEmpty(rekord.component1())) {
                        kataloskiBrojevi.add(rekord.component1());
                    }

                    if (rekord.component2() != null && !StringUtils.isEmpty(rekord.component2())) {
                        kataloskiBrojevi.add(rekord.component2());
                    }

                    if (rekord.component3() != null && !StringUtils.isEmpty(rekord.component3())) {
                        kataloskiBrojevi.add(rekord.component3());
                    }

                    if (rekord.component4() != null) {
                        robaId.add(rekord.component4());
                    }
                });
        prodjiIPopraviKatBr(kataloskiBrojevi);
        drugiPomocniKveri(kataloskiBrojevi, robaId);
        return kataloskiBrojevi;
    }

    private void drugiPomocniKveri(Set<String> katalskoBrojevi, Set<Integer> robaIds) {
        dslContext.selectDistinct(TD_BROJEVI.BROJ, TD_BROJEVI.BROJSRCH)
                .from(TD_BROJEVI)
                .where(TD_BROJEVI.ROBAID.in(robaIds))
                .and(TD_BROJEVI.VRSTA.eq(PROIZVODJAC_ID))
                .fetch().stream().forEach(record -> {
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
            String noviBroj = katBrojevi.replace(" ", "").toUpperCase();
            noviKatBrojevi.add(noviBroj);
        });
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
            select.and(PROIZVODJAC.PROID.eq(parametri.getProizvodjac()));
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
