package com.automaterijal.application.domain.dto.partner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PartnerCardExternalItemDto {

  @JsonProperty("TIP")
  String tip;

  @JsonProperty("NAZIVDOK")
  String nazivDok;

  @JsonProperty("VRDOK")
  String vrDok;

  @JsonProperty("BRDOK")
  String brDok;

  @JsonProperty("DATUM")
  String datum;

  @JsonProperty("DATROKA")
  String datRoka;

  @JsonProperty("DUGUJE")
  BigDecimal duguje;

  @JsonProperty("POTRAZUJE")
  BigDecimal potrazuje;

  @JsonProperty("STANJE")
  BigDecimal stanje;

  public boolean isTotal() {
    return "Total".equalsIgnoreCase(tip) || "UKUPNO:".equalsIgnoreCase(nazivDok);
  }
}
