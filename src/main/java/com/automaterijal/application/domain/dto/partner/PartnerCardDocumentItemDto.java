package com.automaterijal.application.domain.dto.partner;

import com.automaterijal.application.domain.dto.SlikaDto;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PartnerCardDocumentItemDto {

  Integer id;
  Long stavkaId;
  Long robaId;
  BigDecimal kolicina;
  BigDecimal nabavnaCena;
  BigDecimal prodajnaCena;
  BigDecimal prodajnaCenaBezPdv;
  BigDecimal prodajnaCenaSaPdv;
  BigDecimal rabat;
  BigDecimal porez;
  String naziv;
  String robaNaziv;
  String katbr;
  String katbrPro;
  String barkod;

  SlikaDto slika;

  BigDecimal cenaPartneraBezPdv;
  BigDecimal cenaPartneraSaPdv;
  BigDecimal punaCenaBezPdv;
  BigDecimal punaCenaSaPdv;

  BigDecimal cenaPartnera;
  BigDecimal cenaPartneraUkupno;
  BigDecimal punaCena;
  BigDecimal punaCenaUkupno;
}
