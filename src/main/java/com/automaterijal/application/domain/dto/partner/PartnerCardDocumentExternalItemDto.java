package com.automaterijal.application.domain.dto.partner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PartnerCardDocumentExternalItemDto {

  Integer id;

  @JsonProperty("stavkaid")
  Long stavkaId;

  @JsonProperty("robaid")
  Long robaId;

  @JsonProperty("kolicina")
  BigDecimal kolicina;

  @JsonProperty("nabavna_cena")
  BigDecimal nabavnaCena;

  @JsonProperty("prodajna_cena")
  BigDecimal prodajnaCena;

  @JsonProperty("rabat")
  BigDecimal rabat;

  @JsonProperty("naziv")
  String naziv;

  @JsonProperty("roba_naziv")
  String robaNaziv;

  @JsonProperty("katbr")
  String katbr;

  @JsonProperty("katbrpro")
  String katbrPro;

  @JsonProperty("barkod")
  String barkod;

  @JsonProperty("prodajna_cena_bez_pdv")
  BigDecimal prodajnaCenaBezPdv;

  @JsonProperty("prodajna_cena_sa_pdv")
  BigDecimal prodajnaCenaSaPdv;

  @JsonProperty("porez")
  BigDecimal porez;
}
