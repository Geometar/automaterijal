package com.automaterijal.application.domain.dto;

import com.automaterijal.application.tecdoc.CriteriaRecord;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaTehnickiOpisDto {
  String type;
  String oznaka;
  String vrednost;
  String jedinica;

  public static List<RobaTehnickiOpisDto> fromArticleCriteria(
      List<CriteriaRecord> criteriaRecords) {
    return criteriaRecords.stream()
        .filter(
            criteria ->
                "A".equals(criteria.getCriteriaType()) || "N".equals(criteria.getCriteriaType()))
        .map(
            criteria -> {
              RobaTehnickiOpisDto opisDto = new RobaTehnickiOpisDto();
              opisDto.setType(criteria.getCriteriaType());
              opisDto.setOznaka(criteria.getCriteriaDescription());
              opisDto.setJedinica(criteria.getCriteriaUnitDescription());
              opisDto.setVrednost(criteria.getFormattedValue());
              return opisDto;
            })
        .collect(Collectors.toList());
  }
}
