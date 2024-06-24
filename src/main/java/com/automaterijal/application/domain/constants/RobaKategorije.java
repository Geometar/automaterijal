package com.automaterijal.application.domain.constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum RobaKategorije {

  DVOTAKTOL(List.of("MOTO PROGRAM"), false, true),
  MOTORNA_ULJA(List.of("MOTORNO ULjE"), false, true),
  PUTNICKI_PROGRAM(List.of("MPU"), true, false),
  TERETNI_PROGRAM(List.of("MTR"), true, false),
  MENJACKA_ULJA(List.of("MENJAČKO ULjE"), false, true),
  KOCIONO_ULJE(List.of("KOČIONO ULjE"), false, true),
  ANTIFRIZ(List.of("ANTIFRIZ"), false, true),
  INDUSTRIJSKA_ULJA(
      List.of("MIZ"
      ), true, false),
  ELEKTRIKA(List.of("ELEKTRIKA"), false, true),
  ŠAMPONI(List.of("SAMPON"), false, true),
  POLIR_PASTE(List.of("POLIR PASTA"), false, true),
  SUNDJERI(List.of("SUNĐER"), false, true),
  KRPE(List.of("KRPA"), false, true),
  POKRIVAČI(List.of("POKRIVKA ZA AUTO"), false, true),
  PATOSNICE(List.of("PATOSNICE"), false, true),
  PRESVLAKE(List.of("PRESVLAKE"), false, true),
  OBLOGE(List.of("OBLOGE"), false, true),
  DRZAC(List.of("DRŽAČ"), false, true),
  PUNJACI(List.of("PUNJAČI"), false, true),
  JASTUCI(List.of("JASTUCI"), false, true),
  POMOĆNA_OGLEDALA(List.of("POMOĆNA OGLEDALA"), false, true),
  ORGANIZATORI_ZA_GEPEK(List.of("ORGANIZATORI ZA GEPEK"), false, true),
  UNIVERZALNO(List.of("UNIVERZALNO"), false, true),
  KROVNI_NOSAČI(List.of("KROVNI NOSAČI"), false, true),
  PUMPE_ZA_GUME(List.of(
      "ELEKTRIČNA PUMPA",
      "NOŽNA PUMPA"
  ), false, true),
  REPARACIJA_GUME(List.of("SET ZA REPARACIJU GUME"), false, true),
  ŠPANER_ZA_OSIGURAVANJE_TERETA(List.of("ŠPANERI ZA OSIGURANJE TERETA"), false, true),
  LEVAK(List.of("LEVAK"), false, true),
  KANTICA(List.of("KANTICE"), false, true),
  ADITIVI(List.of("ADITIV"), false, true),
  BRISAČI(List.of("BRISAČ"), false, true),
  KOZMETIKA(List.of("JELKICE", "KONZERVE", "IGRAČKE"), false, true),
  HEMIJA(List.of("HEMIJA"), false, true),
  MAZIVA(
      List.of("MOTORNO ULjE", "MENJAČKO ULjE", "KOČIONO ULjE",
          "ANTIFRIZ", "MOTO PROGRAM"
      ), false, true),
  FILTERI(List.of("FILTER"), false, true),
  ODRŽAVANJE_VOZILA(
      List.of("SAMPON", "PRESVLAKE", "PRESVLAKE",
          "OBLOGE", "POKRIVKA ZA AUTO"
      ), false, true),
  UNUTRAŠNJOST_VOZILA(
      List.of("PATOSNICE", "PRESVLAKE", "OBLOGE",
          "DRŽAČ", "PUNJAČI", "JASTUCI", "POMOĆNA OGLEDALA",
          "ORGANIZATORI ZA GEPEK", "UNIVERZALNO"
      ), false, true),
  AKUMULATORI(List.of("AKUMULATOR"), false, true),
  SIJALICE(List.of("SIJALICE"), false, true),
  JELKICE(List.of("JELKICE"), false, true),
  TRAKE_ZA_VUČU(List.of("TRAKE"), false, true),
  OBRADA_METALA(
      List.of("MOM"
      ), true, false);

  @NonNull
  final List<String> fieldName;
  @NonNull
  final boolean grupaPretraga;
  @NonNull
  final boolean podgrupaPretraga;

  private static final Map<String, RobaKategorije> map;

  static {
    map = new HashMap<>();
    for (RobaKategorije v : RobaKategorije.values()) {
      map.put(v.name(), v);
    }
  }

  public static RobaKategorije pronadjiPoNazivu(String naziv) {
    return map.get(naziv);
  }
}
