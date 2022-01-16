package com.automaterijal.application.domain.constants;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum TecDocProizvodjaci {

    ATE(3, null, false),
    PIERB(5, null, false),
    LUK(6, null, false),
    VR(9, null, false),
    ELR(10, null, false),
    BERU(11, null, false),
    NGK(15, null, false),
    BIL(16, null, false),
    VALEO(21, "-VAL", true),
    VAR(26, null, false),
    BOSCH(30, null, false),
    SACHS(32, null, false),
    GATES(33, null, false),
    KNECH(34, null, false),
    LEMF(35, null, false),
    MNR(37, "-MON", true),
    TEXT(39, null, false),
    DAY(42, null, false),
    JURID(48, null, false),
    SKF(50, null, false),
    BRMB(65, null, false),
    HENG(81, null, false),
    KYB(85, null, false), // CHECK
    FEBI(101, null, false),
    SNR(110, null, false),
    NSN(123, "-NISS", true),
    OPTI(129, "-OPT", true),
    MOOG(134, null, false),
    CORT(140, null, false),
    MEYLE(144, null, false),
    FA(159, null, false),
    TRW(161, null, false),
    HPU(178, null, false),
    DENCK(186, null, false),
    FAG(192, null, false),
    GLY(202, null, false),
    INA(204, null, false),
    VER(215, null, false),
    FILTR(256, null, false),
    MAHL(287, null, false),
    HP(301, null, false),
    GRAF(310, null, false),
    CIF(311, null, false),
    KWP(312, "KWP", true),
    WIX(324, null, false),
    BLUE(350, null, false),
    GSP(373, "-GSP", true),
    FR(380, "F", true),
    GOET(385, null, false),
    KS(432, null, false),
    ENERG(443, null, false),
    CONTI(4434, null, false),
    FTG(4581, null, false),
    DON(4868, null, false),
    HIFI(6309, null, false),
    NTY(6355, null, false);

    @NonNull
    final Integer tecDocId;
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
