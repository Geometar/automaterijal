package com.automaterijal.application.domain.repository.roba;

import static com.automaterijal.db.tables.Proizvodjac.PROIZVODJAC;
import static com.automaterijal.db.tables.Roba.ROBA;
import static com.automaterijal.db.tables.RobaKatbrOld.ROBA_KATBR_OLD;

import com.automaterijal.application.domain.cache.RobaCache;
import com.automaterijal.application.domain.dto.ProizvodjacDTO;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.dto.helpper.RobaLightDtoBuilderHelper;
import com.automaterijal.application.domain.model.UniverzalniParametri;
import com.automaterijal.application.utils.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaJooqRepository {

  @Autowired DSLContext dslContext;

  public List<RobaCache> fetchCache() {
    return dslContext
        .select(
            ROBA.ROBAID,
            ROBA.KATBR,
            ROBA.KATBRPRO,
            ROBA.NAZIV,
            PROIZVODJAC.PROID,
            PROIZVODJAC.NAZIV)
        .from(ROBA)
        .join(PROIZVODJAC)
        .on(ROBA.PROID.eq(PROIZVODJAC.PROID))
        .fetchStream()
        .map(this::mapToRobaCache)
        .collect(Collectors.toList());
  }

  private RobaCache mapToRobaCache(Record fields) {
    RobaCache robaCache = new RobaCache();
    robaCache.setRobaid(fields.get(ROBA.ROBAID).longValue());
    robaCache.setKatbr(fields.get(ROBA.KATBR));
    robaCache.setKatbrpro(fields.get(ROBA.KATBRPRO));

    // Populate manufacturer data
    ProizvodjacDTO manufacturer = new ProizvodjacDTO();
    manufacturer.setProid(fields.get(PROIZVODJAC.PROID));
    manufacturer.setNaziv(fields.get(PROIZVODJAC.NAZIV));
    robaCache.setProizvodjac(manufacturer);

    // Build product name, ensuring manufacturer name is included
    String productName = fields.get(ROBA.NAZIV);
    robaCache.setNaziv(buildProductName(manufacturer.getNaziv(), productName));

    return robaCache;
  }

  private String buildProductName(String manufacturerName, String productName) {
    return productName.contains(manufacturerName)
        ? productName
        : manufacturerName + " " + productName;
  }

  public List<RobaLightDto> vratiRobuPoRobiId(Set<Long> robaIds) {
    Condition condition =
        ROBA.ROBAID.in(robaIds.stream().map(Long::intValue).collect(Collectors.toSet()));
    return generic(null, condition);
  }

  public List<RobaLightDto> fetchKatBrOld(Set<String> kataloskiBrojevi) {
    return dslContext
        .selectDistinct(ROBA_KATBR_OLD.KATBR, ROBA_KATBR_OLD.KATBRPRO)
        .from(ROBA_KATBR_OLD)
        .where(
            ROBA_KATBR_OLD
                .KATBR
                .in(kataloskiBrojevi)
                .or(ROBA_KATBR_OLD.KATBRPRO.in(kataloskiBrojevi)))
        .fetchStream()
        .map(
            data ->
                RobaLightDtoBuilderHelper.builder()
                    .katbr(data.component1())
                    .katbrpro(data.component2())
                    .build())
        .toList();
  }

  public List<RobaLightDto> generic(UniverzalniParametri parametri, Condition condition) {
    return generic(parametri, condition, null, null);
  }

  public List<RobaLightDto> generic(
      UniverzalniParametri parametri, Condition condition, Integer limit, Integer offset) {
    // Kreiraj bazni upit
    SelectConditionStep<
            Record9<Integer, String, String, BigDecimal, String, Integer, String, String, String>>
        baseSelect =
            robaSelect()
                .and(
                    CriteriaBuilder.init()
                        .addCondition(condition)
                        .addCondition(filterPoParametrima(parametri))
                        .build());

    SelectLimitStep<
            Record9<Integer, String, String, BigDecimal, String, Integer, String, String, String>>
        ordered = baseSelect.orderBy(ROBA.STANJE.desc());

    if (limit != null && limit > 0) {
      int limitValue = limit;
      if (offset != null && offset >= 0) {
        int offsetValue = offset;
        return ordered.limit(offsetValue, limitValue).fetchStream().map(this::map).toList();
      }
      return ordered.limit(limitValue).fetchStream().map(this::map).toList();
    }

    // Fetch podaci
    return ordered.fetchStream().map(this::map).toList();
  }

  public long count(UniverzalniParametri parametri, Condition condition) {
    Condition combined =
        CriteriaBuilder.init()
            .addCondition(condition)
            .addCondition(filterPoParametrima(parametri))
            .build();

    return dslContext
        .selectCount()
        .from(ROBA)
        .where(combined)
        .fetchOne(0, long.class);
  }

  private Condition filterPoParametrima(UniverzalniParametri parametri) {
    if (parametri == null) {
      return DSL.noCondition(); // Early return for null parameters
    }

    CriteriaBuilder criteriaBuilder = CriteriaBuilder.init();

    // Manufacturer condition (accepts either explicit or mandatory proid list)
    List<String> resolvedProducers = parametri.resolveProizvodjac();
    criteriaBuilder.addConditionIfNotEmpty(
        resolvedProducers, ROBA.PROID.in(resolvedProducers));

    // Categories condition
    criteriaBuilder.addConditionIfNotEmpty(
        parametri.getGrupa(), ROBA.GRUPAID.in(parametri.getGrupa()));

    // Sub-categories condition
    criteriaBuilder.addConditionIfNotEmpty(
        parametri.getPodgrupeZaPretragu(), ROBA.PODGRUPAID.in(parametri.getPodgrupeZaPretragu()));

    // Stock condition
    criteriaBuilder.addConditionIfTrue(
        parametri.isNaStanju(), ROBA.STANJE.greaterThan(BigDecimal.ZERO));

    return criteriaBuilder.build();
  }

  private SelectConditionStep<
          Record9<Integer, String, String, BigDecimal, String, Integer, String, String, String>>
      robaSelect() {
    return robaSelect(null, null); // Pozivamo metodu sa null vrednošću za trazenaRec
  }

  // Verzija metode sa trazenaRec parametrom
  private SelectConditionStep<
          Record9<Integer, String, String, BigDecimal, String, Integer, String, String, String>>
      robaSelect(String trazenaRec, Set<Integer> robaId) {

    SelectJoinStep<
            Record9<Integer, String, String, BigDecimal, String, Integer, String, String, String>>
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
                    ROBA.SLIKA,
                    ROBA.KATBRPRO)
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

  private RobaLightDto map(
      Record9<Integer, String, String, BigDecimal, String, Integer, String, String, String>
          robaRecord) {
    ProizvodjacDTO proizvodjacDTO = new ProizvodjacDTO();
    proizvodjacDTO.setProid(robaRecord.component7());
    return RobaLightDtoBuilderHelper.builder()
        .robaid(robaRecord.component1().longValue())
        .katbr(robaRecord.component2())
        .katbrpro(robaRecord.component9())
        .naziv(robaRecord.component3())
        .stanje(robaRecord.component4() != null ? robaRecord.component4().doubleValue() : 0)
        .grupa(robaRecord.component5())
        .podGrupa(robaRecord.component6())
        .proizvodjac(proizvodjacDTO)
        .slika(new SlikaDto(robaRecord.component8()))
        .build();
  }
}
