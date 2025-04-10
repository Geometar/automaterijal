package com.automaterijal.application.domain.dto.email;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegistracijaDto {

  public static final String NASLOV = "Registracija korisnika";
  public static final String TEMPLATE = "registracioniTemplate";
  // Pravno Lice
  String nazivFirme;
  String pib;
  // Fizicko Lice
  String imeIPrezime;

  // Zajednicki sadrzilac
  String grad;
  String adresa;
  String email;
  String kontaktTelefon;
  Boolean daLiJePravnoLice;
}
