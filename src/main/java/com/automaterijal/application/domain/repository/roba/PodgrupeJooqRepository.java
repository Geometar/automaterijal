package com.automaterijal.application.domain.repository.roba;

import static com.automaterijal.db.tables.Grupa.GRUPA;
import static com.automaterijal.db.tables.Podgrupa.PODGRUPA;

import com.automaterijal.application.domain.dto.PodgrupaDto;
import com.automaterijal.application.utils.CriteriaBuilder;
import java.util.List;
import java.util.Set;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PodgrupeJooqRepository {

  @Autowired DSLContext dslContext;

  public List<PodgrupaDto> findAllPodgrupe() {
    return fetchPodgrupe(null);
  }

  public List<PodgrupaDto> findAllPodgrupeWithGrupa(Set<Integer> sviKljucevi) {
    return fetchPodgrupe(sviKljucevi);
  }

  private List<PodgrupaDto> fetchPodgrupe(Set<Integer> sviKljucevi) {
    var whereClause =
        dslContext
            .select(PODGRUPA.PODGRUPAID, PODGRUPA.NAZIV, GRUPA.NAZIV)
            .from(PODGRUPA)
            .join(GRUPA)
            .on(PODGRUPA.GRUPAID.eq(GRUPA.GRUPAID));

    // Build the condition based on the input
    Condition condition = buildCondition(sviKljucevi);

    return whereClause
        .where(condition)
        .fetchStream()
        .map(
            data -> {
              PodgrupaDto result = new PodgrupaDto();
              result.setId(data.value1());
              result.setNaziv(data.value2());
              result.setGrupa(data.value3());
              return result;
            })
        .toList();
  }

  private Condition buildCondition(Set<Integer> sviKljucevi) {
    CriteriaBuilder criteriaBuilder = CriteriaBuilder.init();
    return criteriaBuilder
        .addConditionIfNotEmpty(sviKljucevi, PODGRUPA.PODGRUPAID.in(sviKljucevi))
        .build();
  }
}
