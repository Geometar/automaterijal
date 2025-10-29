package com.automaterijal.application.domain.dto.partner;

import java.math.BigDecimal;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PartnerCardGroupDto {

  String tip;
  BigDecimal totalDuguje;
  BigDecimal totalPotrazuje;
  BigDecimal totalStanje;
  List<PartnerCardItemDto> stavke;
}
