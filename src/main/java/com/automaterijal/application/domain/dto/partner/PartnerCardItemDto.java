package com.automaterijal.application.domain.dto.partner;

import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PartnerCardItemDto {

  String tip;
  String nazivDok;
  String brojDokumenta;
  String datum;
  String datumRoka;
  BigDecimal duguje;
  BigDecimal potrazuje;
  BigDecimal stanje;
}

