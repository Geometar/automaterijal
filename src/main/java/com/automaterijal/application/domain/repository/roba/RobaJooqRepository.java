package com.automaterijal.application.domain.repository.roba;

import static com.automaterijal.db.tables.Roba.ROBA;
import static com.automaterijal.db.tables.RobaKatbrOld.ROBA_KATBR_OLD;

import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.entity.PodGrupa;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.mapper.RobaMapper;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.utils.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaJooqRepository {

  @Autowired DSLContext dslContext;

  @Autowired RobaMapper mapper;

  public List<RobaDto> vratiRobuPoRobiId(Set<Long> robaIds) {
    Condition condition =
        ROBA.ROBAID.in(robaIds.stream().map(Long::intValue).collect(Collectors.toSet()));
    return generic(null, condition);
  }

  public List<RobaDto> pronadjiRobuPoNazivu(String searchTerm, UniverzalniParametri parametri) {
    List<Condition> conditions =
        Arrays.stream(searchTerm.trim().split("\\s+"))
            .map(word -> ROBA.NAZIV.like("%" + word + "%"))
            .collect(Collectors.toList());
    Condition finalCondition = conditions.stream().reduce(DSL.noCondition(), Condition::and);

    return generic(parametri, finalCondition);
  }

  public List<RobaDto> fetchKatBrOld(Set<String> kataloskiBrojevi) {
    return dslContext
        .selectDistinct(ROBA_KATBR_OLD.KATBR, ROBA_KATBR_OLD.KATBRPRO)
        .from(ROBA_KATBR_OLD)
        .where(
            ROBA_KATBR_OLD
                .KATBR
                .in(kataloskiBrojevi)
                .or(ROBA_KATBR_OLD.KATBRPRO.in(kataloskiBrojevi)))
        .fetchStream()
        .map(data -> RobaDto.builder().katbr(data.component1()).katbrpro(data.component2()).build())
        .toList();
  }

  public List<RobaDto> generic(UniverzalniParametri parametri, Condition condition) {
    // Kreiraj bazni upit
    SelectConditionStep<
            Record8<Integer, String, String, BigDecimal, String, Integer, String, String>>
        select =
            robaSelect()
                .and(
                    CriteriaBuilder.init()
                        .addCondition(condition)
                        .addCondition(filterPoParametrima(parametri))
                        .build());

    // Fetch podaci
    return select.orderBy(ROBA.STANJE.desc()).fetchStream().map(this::map).toList();
  }

  public List<String> vratiSveProzivodjace() {
    return dslContext
        .select()
        .from(ROBA)
        .where(ROBA.STANJE.greaterThan(BigDecimal.ZERO))
        .fetch(ROBA.PROID);
  }

  public List<Roba> pronadjiRobuPoPodgrupama(List<PodGrupa> podGrupaId, boolean naStanju) {
    List<Integer> podgrupe = podGrupaId.stream().map(PodGrupa::getPodGrupaId).toList();
    Condition condition =
        CriteriaBuilder.init()
            .addCondition(ROBA.PODGRUPAID.in(podgrupe))
            .addConditionIfTrue(naStanju, ROBA.STANJE.greaterThan(BigDecimal.ZERO))
            .build();
    return dslContext.selectFrom(ROBA).where(condition).orderBy(ROBA.STANJE.desc()).fetch().stream()
        .map(mapper::map)
        .collect(Collectors.toList());
  }

  private Condition filterPoParametrima(UniverzalniParametri parametri) {
    if (parametri == null) {
      return DSL.noCondition(); // Early return for null parameters
    }

    CriteriaBuilder criteriaBuilder = CriteriaBuilder.init();

    // Manufacturer condition
    criteriaBuilder.addConditionIfNotEmpty(
        parametri.getMandatoryProid(), ROBA.PROID.in(parametri.getMandatoryProid()));

    // Categories condition
    criteriaBuilder.addConditionIfNotEmpty(
        parametri.getGrupa(), ROBA.GRUPAID.in(parametri.getGrupa()));

    // Stock condition
    criteriaBuilder.addConditionIfTrue(
        parametri.isNaStanju(), ROBA.STANJE.greaterThan(BigDecimal.ZERO));

    return criteriaBuilder.build();
  }

  private SelectConditionStep<
          Record8<Integer, String, String, BigDecimal, String, Integer, String, String>>
      robaSelect() {
    return robaSelect(null, null); // Pozivamo metodu sa null vrednošću za trazenaRec
  }

  // Verzija metode sa trazenaRec parametrom
  private SelectConditionStep<
          Record8<Integer, String, String, BigDecimal, String, Integer, String, String>>
      robaSelect(String trazenaRec, Set<Integer> robaId) {

    SelectJoinStep<Record8<Integer, String, String, BigDecimal, String, Integer, String, String>>
        select =
            dslContext
                .selectDistinct(
                    ROBA.ROBAID,
                    ROBA.KATBR,
                    ROBA.NAZIV,
                    ROBA.STANJE,
                    ROBA.GRUPAID,
                    ROBA.PODGRUPAID,
                    ROBA.PROID,
                    ROBA.SLIKA)
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
      Record8<Integer, String, String, BigDecimal, String, Integer, String, String> robaRecord) {
    return RobaDto.builder()
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
