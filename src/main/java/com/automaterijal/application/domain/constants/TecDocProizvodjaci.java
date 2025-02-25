package com.automaterijal.application.domain.constants;

import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum TecDocProizvodjaci {
  ATE(3L, null, false),
  MANN(4L, null, false),
  PIERB(5L, null, false),
  LUK(6L, null, false),
  VR(9L, null, false),
  ELR(10L, null, false),
  BERU(11L, null, false),
  NGK(15L, null, false),
  BIL(16L, null, false),
  VALEO(21L, "-VAL", true),
  BOSCH(30L, null, false),
  CONTI(31L, null, false),
  SACHS(32L, null, false),
  GATES(33L, null, false),
  KNECH(34L, null, false),
  LEMF(35L, null, false),
  MNR(37L, "-MON", true),
  TEXT(39L, null, false),
  DAY(42L, null, false),
  CHAM(43L, null, false),
  JURID(48L, null, false),
  SKF(50L, null, false),
  BEHR(52L, null, false),
  LO(56L, null, false),
  QH(57L, null, false),
  GOET(60L, null, false),
  FER(62L, null, false),
  BRMB(65L, null, false),
  DENSO(66L, null, false),
  HENG(81L, null, false),
  KYB(85L, null, false),
  DEL(89L, null, false),
  METZ(94L, null, false),
  MAGNM(95L, null, false),
  FEBI(101L, null, false),
  SNR(110L, null, false),
  METEL(121L, null, false),
  NSN(123L, "-NISS", true),
  MOOG(134L, null, false),
  SID(135L, null, false),
  CORT(140L, null, false),
  MEYLE(144L, null, false),
  SWAG(151L, null, false),
  JP(156L, null, false),
  FA(159L, null, false),
  TRW(161L, null, false),
  VAI(162L, null, false),
  LES(175L, null, false),
  HPU(178L, null, false),
  FAG(192L, null, false),
  GLY(202L, null, false),
  INA(204L, null, false),
  NRF(205L, null, false),
  CAS(207L, null, false),
  TRA(209L, null, false),
  VER(215L, null, false),
  NU(216L, null, false),
  MD(244L, "MD", false),
  NIPA(248L, null, false),
  FILTR(256L, null, false),
  SASIC(260L, null, false),
  FAI(267L, null, false),
  JG(268L, null, false),
  MAHL(287L, null, false),
  HP(301L, null, false),
  GRAF(310L, null, false),
  CIF(311L, null, false),
  KWP(312L, "KWP", true),
  AKR(317L, null, false),
  WIX(324L, null, false),
  BLUE(350L, null, false),
  GSP(373L, "-GSP", true),
  COML(421L, null, false),
  KS(432L, null, false),
  FIAAM(437L, null, false),
  ENERG(443L, null, false),
  HIT(449L, null, false),
  NV(485L, null, false),
  SHELL(4314L, null, false),
  YEN(4402L, null, false),
  KI(4460L, null, false),
  THE(4466L, null, false),
  FTG(4581L, null, false),
  ABA(4657L, null, false),
  MTCH(4664L, "-MTCH", true),
  FEB(4674L, null, false),
  LKOIL(4748L, null, false),
  ASMET(4829L, null, false),
  DON(4868L, null, false),
  VA(6186L, null, false),
  HIQ(6265L, null, false),
  GKN(6306L, null, false),
  HIFI(6309L, null, false),
  AIC(6558L, null, false),
  TOTAL(6853L, null, false),
  NTY(6355L, null, false);

  @NonNull final Long tecDocId;
  final String dodatak;
  final boolean isDodatakNaKraju;

  private static final Map<String, TecDocProizvodjaci> map;
  private static final Map<Long, TecDocProizvodjaci> keyMap;
  private static final Map<String, TecDocProizvodjaci> nameMap;

  static {
    map = new HashMap<>();
    for (TecDocProizvodjaci v : TecDocProizvodjaci.values()) {
      map.put(v.name(), v);
    }
    keyMap = new HashMap<>();
    for (TecDocProizvodjaci v : TecDocProizvodjaci.values()) {
      keyMap.put(v.getTecDocId(), v);
    }
    nameMap = new HashMap<>();
    for (TecDocProizvodjaci manufacturer : values()) {
      nameMap.put(manufacturer.name(), manufacturer);
    }
  }

  public static TecDocProizvodjaci pronadjiPoNazivu(String proId) {
    return map.get(proId);
  }

  public static TecDocProizvodjaci pronadjiPoKljucu(Long brandId) {
    return keyMap.get(brandId);
  }

  public static TecDocProizvodjaci findByName(String name) {
    return name != null ? nameMap.get(name) : null;
  }

  // Start of: Generisanje kataloskog broja
  public static String generateAlternativeCatalogNumber(String katBr, String manufcacture) {
    TecDocProizvodjaci manufacturer = TecDocProizvodjaci.findByName(manufcacture);
    return applyDodatak(katBr, manufacturer);
  }

  public static String generateAlternativeCatalogNumber(String katBr, long brandId) {
    TecDocProizvodjaci manufacturer = TecDocProizvodjaci.pronadjiPoKljucu(brandId);
    return applyDodatak(katBr, manufacturer);
  }

  public static String generateAlternativeCatalogNumber(
      String katBr, TecDocProizvodjaci manufacturer) {
    return applyDodatak(katBr, manufacturer);
  }

  private static String applyDodatak(String katBr, TecDocProizvodjaci manufacturer) {
    if (manufacturer == null || manufacturer.dodatak == null) {
      return katBr.replaceAll("\\s+", "");
    }
    String result =
        manufacturer.isDodatakNaKraju ? katBr + manufacturer.dodatak : manufacturer.dodatak + katBr;
    return result.trim().replaceAll("\\s+", "");
  }

  // End of: Generisanje kataloskog broja
  public static String restoreOriginalCatalogNumber(String katBr, Long brandId) {
    TecDocProizvodjaci manufacturer = TecDocProizvodjaci.pronadjiPoKljucu(brandId);
    return removeDodatak(katBr, manufacturer);
  }

  public static String restoreOriginalCatalogNumber(String katBr, TecDocProizvodjaci manufacturer) {
    return removeDodatak(katBr, manufacturer);
  }

  private static String removeDodatak(String katBr, TecDocProizvodjaci manufacturer) {
    if (manufacturer != null && manufacturer.dodatak != null) {
      katBr = katBr.replace(manufacturer.dodatak, "");
    }

    // Remove special characters and extra spaces
    return katBr.replaceAll("[-,./]", "").replaceAll("\\s+", "").replace("-LUČ", "");
  }
}
