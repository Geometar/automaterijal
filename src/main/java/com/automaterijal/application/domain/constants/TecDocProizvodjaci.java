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
  ATE(3, null, false),
  MANN(4, null, false),
  PIERB(5, null, false),
  LUK(6, null, false),
  VR(9, null, false),
  ELR(10, null, false),
  BERU(11, null, false),
  NGK(15, null, false),
  BIL(16, null, false),
  VALEO(21, "-VAL", true),
  BOSCH(30, null, false),
  CONTI(31, null, false),
  SACHS(32, null, false),
  GATES(33, null, false),
  KNECH(34, null, false),
  LEMF(35, null, false),
  MNR(37, "-MON", true),
  TEXT(39, null, false),
  DAY(42, null, false),
  CHAM(43, null, false),
  JURID(48, null, false),
  SKF(50, null, false),
  BEHR(52, null, false),
  LO(56, null, false),
  QH(57, null, false),
  GOET(60, null, false),
  FER(62, null, false),
  BRMB(65, null, false),
  DENSO(66, null, false),
  HENG(81, null, false),
  KYB(85, null, false),
  DEL(89, null, false),
  METZ(94, null, false),
  MAGNM(95, null, false),
  FEBI(101, null, false),
  SNR(110, null, false),
  METEL(121, null, false),
  NSN(123, "-NISS", true),
  MOOG(134, null, false),
  SID(135, null, false),
  CORT(140, null, false),
  MEYLE(144, null, false),
  SWAG(151, null, false),
  JP(156, null, false),
  FA(159, null, false),
  TRW(161, null, false),
  VAI(162, null, false),
  LES(175, null, false),
  HPU(178, null, false),
  FAG(192, null, false),
  GLY(202, null, false),
  INA(204, null, false),
  NRF(205, null, false),
  CAS(207, null, false),
  TRA(209, null, false),
  VER(215, null, false),
  NU(216, null, false),
  MD(244, null, false),
  NIPA(248, null, false),
  FILTR(256, null, false),
  SASIC(260, null, false),
  FAI(267, null, false),
  JG(268, null, false),
  MAHL(287, null, false),
  HP(301, null, false),
  GRAF(310, null, false),
  CIF(311, null, false),
  KWP(312, "KWP", true),
  AKR(317, null, false),
  WIX(324, null, false),
  BLUE(350, null, false),
  GSP(373, "-GSP", true),
  COML(421, null, false),
  KS(432, null, false),
  FIAAM(437, null, false),
  ENERG(443, null, false),
  HIT(449, null, false),
  NV(485, null, false),
  SHELL(4314, null, false),
  YEN(4402, null, false),
  KI(4460, null, false),
  THE(4466, null, false),
  FTG(4581, null, false),
  ABA(4657, null, false),
  MTCH(4664, null, false),
  FEB(4674, null, false),
  LKOIL(4748, null, false),
  ASMET(4829, null, false),
  DON(4868, null, false),
  VA(6186, null, false),
  HIQ(6265, null, false),
  GKN(6306, null, false),
  HIFI(6309, null, false),
  AIC(6558, null, false),
  TOTAL(6853, null, false),
  NTY(6355, null, false);

  @NonNull final Integer tecDocId;
  final String dodatak;
  final boolean isDodatakNaKraju;

  private static final Map<String, TecDocProizvodjaci> map;
  private static final Map<Integer, TecDocProizvodjaci> keyMap;

  static {
    map = new HashMap<>();
    for (TecDocProizvodjaci v : TecDocProizvodjaci.values()) {
      map.put(v.name(), v);
    }
    keyMap = new HashMap<>();
    for (TecDocProizvodjaci v : TecDocProizvodjaci.values()) {
      keyMap.put(v.getTecDocId(), v);
    }
  }

  public static TecDocProizvodjaci pronadjiPoNazivu(String proId) {
    return map.get(proId);
  }

  public static TecDocProizvodjaci pronadjiPoKljucu(Integer brandId) {
    return keyMap.get(brandId);
  }
}
