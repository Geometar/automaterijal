package com.automaterijal.application.domain.constants;

import java.util.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum TecDocProizvodjaci {
  ATE(3L, null, false, true),
  MANN(4L, null, false, false),
  PIERB(5L, null, false, false),
  LUK(6L, null, false, false),
  VR(9L, null, false, false),
  ELR(10L, null, false, false),
  BERU(11L, null, false, false),
  NGK(15L, "-NGK", true, false),
  BIL(16L, null, false, false),
  VALEO(21L, "-VAL", true, false),
  BOSCH(30L, null, false, false),
  CONTI(31L, "CT", true, false),
  SACHS(32L, null, false, false),
  GATES(33L, null, false, false),
  KNECH(34L, null, false, false),
  LEMF(35L, null, false, false),
  MNR(37L, "-MON", true, false),
  TEXT(39L, null, false, false),
  DAY(42L, null, false, false),
  CHAM(43L, null, false, false),
  JURID(48L, null, false, false),
  SKF(50L, null, false, false),
  BEHR(52L, null, false, false),
  LO(56L, null, false, false), // TODO: Check
  QH(57L, null, false, false), // TODO: Check
  GOET(60L, null, false, false),
  FER(62L, null, false, false),
  BRMB(65L, null, false, false),
  DENSO(66L, null, false, false),
  HENG(81L, null, false, false),
  CONTI_2(83L, "CT", true, false),
  KYB(85L, null, false, false),
  DEL(89L, null, false, false),
  METZ(94L, null, false, false),
  MAGNM(95L, null, false, true),
  FEBI(101L, null, false, false),
  SNR(110L, null, false, false),
  METEL(121L, null, false, false),
  NSN(123L, "-NISS", true, false), // TODO: Popravi - NISS mora biti svaki
  MOOG(134L, null, false, false), // TODO: Moramo da dodamo crtice
  SID(135L, "-SID", true, false),
  CORT(140L, null, false, false),
  MEYLE(144L, null, false, false),
  SWAG(151L, null, false, false),
  JP(156L, null, false, false),
  FA(159L, null, false, false),
  TRW(161L, null, false, false),
  VAI(162L, null, false, false),
  LES(175L, "-LES", true, false),
  HPU(178L, null, false, false),
  FAG(192L, null, false, false),
  GLY(202L, null, false, false),
  INA(204L, null, false, false),
  NRF(205L, "-NRF", true, false),
  CAS(207L, null, false, false),
  TRA(209L, null, false, false),
  VER(215L, null, false, false),
  NU(216L, null, false, false),
  MD(244L, "MD", false, false),
  NIPA(248L, null, false, false),
  FILTR(256L, null, false, false),
  SASIC(260L, "-SAS", true, false),
  FAI(267L, null, false, false),
  JG(268L, null, false, false), // TODO: Prebaci na njegove brojeve
  MAHL(287L, null, false, false),
  HP(301L, null, false, false), // TODO: Prebaci na njegove brojeve
  GRAF(310L, null, false, false),
  CIF(311L, null, false, false),
  KWP(312L, "KWP", true, false),
  AKR(317L, "AKR", true, false),
  WIX(324L, "-WIX", true, false),
  BLUE(350L, null, false, false),
  GSP(373L, "-GSP", true, false),
  COML(421L, null, false, false),
  KS(432L, null, false, false),
  FIAAM(437L, null, false, false),
  ENERG(443L, null, false, false), // TODO: Prebaciti td broj u alterntivni kat br
  HIT(449L, "-HIT", true, false),
  NV(485L, "NAR", false, false),
  SHELL(4314L, null, false, false),
  YEN(4402L, null, false, false),
  KI(4460L, null, false, false),
  THE(4466L, null, false, false),
  FTG(4581L, null, false, false),
  ABA(4657L, null, false, false),
  MTCH(4664L, "-MTCH", true, false),
  FEB(4674L, null, false, false),
  LKOIL(4748L, null, false, false),
  ASMET(4829L, null, false, false),
  DON(4868L, null, false, false),
  VA(6186L, null, false, false),
  HIQ(6265L, null, false, false),
  GKN(6306L, null, false, false),
  HIFI(6309L, null, false, false),
  AIC(6558L, "-AIC", true, false),
  TOTAL(6853L, null, false, false),
  NTY(6355L, null, false, false),
  BERU_2(6441L, null, false, false);

  @NonNull final Long tecDocId;
  final String dodatak;
  final boolean isDodatakNaKraju;
  final boolean useTradeNumber;

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

    String dodatak = manufacturer.dodatak.trim();
    String normalizedKatBr = katBr.replaceAll("\\s+", "");

    boolean alreadyHasDodatak = normalizedKatBr.contains(dodatak);

    if (alreadyHasDodatak) {
      return normalizedKatBr; // If dodatak is already in place, return as is
    }

    // Apply dodatak at the correct position
    return manufacturer.isDodatakNaKraju ? normalizedKatBr + dodatak : dodatak + normalizedKatBr;
  }

  // End of: Generisanje kataloskog broja

  public static String restoreOriginalCatalogNumber(String katBr, TecDocProizvodjaci manufacturer) {
    return removeDodatak(katBr, manufacturer);
  }

  private static String removeDodatak(String katBr, TecDocProizvodjaci manufacturer) {
    if (manufacturer != null && manufacturer.dodatak != null) {
      String dodatak = manufacturer.dodatak.trim();

      if (manufacturer.isDodatakNaKraju && katBr.endsWith(dodatak)) {
        // Remove dodatak from the end
        katBr = katBr.substring(0, katBr.length() - dodatak.length());
      } else if (!manufacturer.isDodatakNaKraju && katBr.startsWith(dodatak)) {
        // Remove dodatak from the beginning
        katBr = katBr.substring(dodatak.length());
      }
    }

    // Remove special characters and extra spaces
    return katBr.replaceAll("[-,./]", "").replaceAll("\\s+", "").replace("-LUČ", "");
  }

  // Use this when we want all ids since some manufacturer can have 2 td brands
  public static List<Long> getAllTecDocIdsByName(String manufacturerName) {
    if (manufacturerName == null || manufacturerName.isEmpty()) {
      return Collections.emptyList();
    }

    // Normalize input (ensure "_2" doesn't affect name matching)
    String cleanName = manufacturerName.replace("_2", "");

    // Store all matching TecDoc IDs
    List<Long> ids = new ArrayList<>();

    for (TecDocProizvodjaci manufacturer : values()) {
      if (manufacturer.getCleanName().equals(cleanName)) {
        ids.add(manufacturer.getTecDocId());
      }
    }

    return ids;
  }

  public String getCleanName() {
    return this.name().replace("_2", "");
  }
}
