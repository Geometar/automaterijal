package com.automaterijal.application.domain.repository;

import static com.automaterijal.db.tables.Podgrupa.PODGRUPA;
import static com.automaterijal.db.tables.Roba.ROBA;
import static org.jooq.impl.DSL.rand;

import com.automaterijal.application.domain.dto.ProizvodjacDTO;
import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.dto.helpper.RobaLightDtoBuilderHelper;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ShowcaseRepositoryJooq {

  private final DSLContext dsl;

  // Pick N random subgroups for a given group (only where items have image and stock)
  public List<Integer> pickRandomSubgroups(String group, int count) {
    return dsl.selectDistinct(PODGRUPA.PODGRUPAID)
        .from(PODGRUPA)
        .where(PODGRUPA.GRUPAID.eq(group))
        .orderBy(rand()) // randomize
        .limit(count)
        .fetch(PODGRUPA.PODGRUPAID);
  }

  // Fetch items for a specific group + subgroup
  public List<RobaLightDto> fetchByGroupAndSubgroup(String group, Integer subGroup, int limit) {
    var result =
        dsl.select(
                ROBA.ROBAID,
                ROBA.KATBR,
                ROBA.NAZIV,
                ROBA.STANJE,
                ROBA.GRUPAID,
                ROBA.PODGRUPAID,
                ROBA.PROID,
                ROBA.SLIKA,
                ROBA.KATBRPRO)
            .from(ROBA)
            .where(ROBA.GRUPAID.eq(group))
            .and(ROBA.PODGRUPAID.eq(subGroup))
            .and(ROBA.STANJE.gt(BigDecimal.ZERO))
            .limit(limit)
            .fetch();

    return result.stream()
        .map(
            r ->
                RobaLightDtoBuilderHelper.builder()
                    .robaid(r.get(ROBA.ROBAID).longValue())
                    .katbr(r.get(ROBA.KATBR))
                    .katbrpro(r.get(ROBA.KATBRPRO))
                    .naziv(r.get(ROBA.NAZIV))
                    .stanje(r.get(ROBA.STANJE) != null ? r.get(ROBA.STANJE).doubleValue() : 0d)
                    .grupa(r.get(ROBA.GRUPAID))
                    .podGrupa(r.get(ROBA.PODGRUPAID))
                    .proizvodjac(
                        new ProizvodjacDTO() {
                          {
                            setProid(r.get(ROBA.PROID));
                          }
                        })
                    .slika(new SlikaDto(r.get(ROBA.SLIKA)))
                    .build())
        .toList();
  }
}
