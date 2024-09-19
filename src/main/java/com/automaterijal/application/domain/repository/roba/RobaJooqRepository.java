package com.automaterijal.application.domain.repository.roba;

import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.db.tables.records.RobaRecord;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.automaterijal.db.tables.Roba.ROBA;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaJooqRepository {

    @Autowired
    DSLContext dslContext;

    @Autowired
    RobaMapper mapper;

    public List<RobaDto> vratiRobuPoRobiId(Set<Long> robaIds) {
        Condition condition = ROBA.ROBAID.in(robaIds.stream().map(Long::intValue).collect(Collectors.toSet()));
        return generic(null, condition);
    }

    public List<RobaDto> pronadjiRobuPoNazivu(String searchTerm, UniverzalniParametri parametri) {
        List<Condition> conditions = Arrays.stream(searchTerm.trim().split("\\s+"))
                .map(word -> ROBA.NAZIV.like("%" + word + "%"))
                .collect(Collectors.toList());
        Condition finalCondition = conditions.stream().reduce(DSL.noCondition(), Condition::and);

        return generic(parametri, finalCondition);
    }

    public List<RobaDto> generic(UniverzalniParametri parametri, Condition condition) {
        // Kreiraj bazni upit
        SelectConditionStep<Record8<Integer, String, String, BigDecimal, String, Integer, String, String>> select = robaSelect()
                .and(condition);

        // Filtriraj po parametrima
        filtrirajPoParametrima(select, parametri);

        // Sortiraj ako su prosleđena polja za sortiranje
            select.orderBy(ROBA.STANJE.desc());

        // Fetch podaci
        return select.fetchStream().map(this::map).collect(Collectors.toList());
    }

    public List<String> vratiSveProzivodjace() {
        return dslContext
                .select()
                .from(ROBA)
                .where(ROBA.STANJE.greaterThan(BigDecimal.ZERO)).fetch(ROBA.PROID);
    }

    public List<Roba> pronadjiRobuPoPodgrupama(List<PodGrupa> podGrupaId, boolean naStanju) {
        SelectConditionStep<RobaRecord> select = dslContext
                .selectFrom(ROBA)
                .where(ROBA.PODGRUPAID.in(
                        podGrupaId.stream().map(PodGrupa::getPodGrupaId).collect(Collectors.toList())));
        if (naStanju) {
            select.and(ROBA.STANJE.greaterThan(BigDecimal.ZERO));
        }
        select.orderBy(ROBA.STANJE.desc());

        return select.fetch().stream().map(mapper::map).collect(Collectors.toList());
    }

    private void filtrirajPoParametrima(SelectConditionStep<?> select, UniverzalniParametri parametri) {
        // Provera za Roba Kategorije
        if (parametri.getRobaKategorije() != null) {
            if (parametri.getRobaKategorije().isGrupaPretraga()) {
                select.and(ROBA.GRUPAID.in(parametri.getRobaKategorije().getFieldName()));
            } else if (parametri.getRobaKategorije().isPodgrupaPretraga()) {
                List<Integer> podgrupeIds = parametri.getPodGrupe().stream()
                        .map(PodGrupa::getPodGrupaId)
                        .collect(Collectors.toList());
                select.and(ROBA.PODGRUPAID.in(podgrupeIds));
            }
        }

        // Provera za Proizvođača
        if (StringUtils.hasText(parametri.getProizvodjac())) {
            select.and(ROBA.PROID.eq(parametri.getProizvodjac()));
        }

        // Provera za Podgrupu pretrage
        if (StringUtils.hasText(parametri.getPodgrupaZaPretragu())) {
            List<Integer> podgrupeZaPretraguIds = parametri.getPodGrupe().stream()
                    .filter(podGrupa -> podGrupa.getNaziv().equalsIgnoreCase(parametri.getPodgrupaZaPretragu()))
                    .map(PodGrupa::getPodGrupaId)
                    .collect(Collectors.toList());

            if (!podgrupeZaPretraguIds.isEmpty()) {
                select.and(ROBA.PODGRUPAID.in(podgrupeZaPretraguIds));
            }
        }

        // Provera za stanje na skladištu
        if (parametri.isNaStanju()) {
            select.and(ROBA.STANJE.greaterThan(BigDecimal.ZERO));
        }
    }

    private SelectConditionStep<Record8<Integer, String, String, BigDecimal, String, Integer, String, String>> robaSelect() {
        return robaSelect(null, null); // Pozivamo metodu sa null vrednošću za trazenaRec
    }

    // Verzija metode sa trazenaRec parametrom
    private SelectConditionStep<Record8<Integer, String, String, BigDecimal, String, Integer, String, String>> robaSelect(
            String trazenaRec, Set<Integer> robaId) {

        SelectJoinStep<Record8<Integer, String, String, BigDecimal, String, Integer, String, String>> select = dslContext
                .selectDistinct(ROBA.ROBAID, ROBA.KATBR, ROBA.NAZIV, ROBA.STANJE, ROBA.GRUPAID, ROBA.PODGRUPAID, ROBA.PROID, ROBA.SLIKA)
                .from(ROBA);

        if (trazenaRec != null) {
            String trazenaRecLike = "%" + trazenaRec + "%";
            return select.where(ROBA.KATBR.like(trazenaRecLike));
        } else if (robaId != null && !robaId.isEmpty()) {
            return select.where(ROBA.ROBAID.in(robaId));
        } else {
            return select.where(DSL.noCondition());
        }
    }

    private RobaDto map(
            Record8<Integer, String, String, BigDecimal, String, Integer, String, String> robaRecord
    ) {
        return  RobaDto
                .builder()
                .robaid(robaRecord.component1().longValue())
                .katbr(robaRecord.component2())
                .naziv(robaRecord.component3())
                .stanje(robaRecord.component4() != null ? robaRecord.component4().doubleValue() : 0)
                .grupa(robaRecord.component5())
                .podGrupa(robaRecord.component6())
                .proizvodjac(Proizvodjac.builder().proid(robaRecord.component7()).build())
                .slika(new SlikaDto(robaRecord.component8()))
                .build();
    }

}
