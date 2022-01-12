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

    ATE(3, null),
    PIERB(5, null),
    LUK(6, null),
    VR(9, null),
    ELR(10, null),
    BERU(11, null),
    NGK(15, null),
    BIL(16, null),
    VALEO(21, "-VAL"),
    VAR(26, null),
    BOSCH(30, null),
    SACHS(32, null),
    GATES(33, null),
    KNECH(34, null),
    LEMF(35, null),
    MNR(37, "-MON"),
    TEXT(39, null),
    DAY(42, null),
    JURID(48, null),
    SKF(50, null),
    BRMB(65, null),
    HENG(81, null),
    KYB(85, null), // CHECK
    FEBI(101, null),
    SNR(110, null),
    NSN(123, "-NISS"),
    OPTI(129, "-OPT"),
    MOOG(134, null),
    CORT(140, null),
    MEYLE(144, null),
    FA(159, null),
    TRW(161, null),
    HPU(178, null),
    DENCK(186, null),
    FAG(192, null),
    GLY(202, null),
    INA(204, null),
    VER(215, null),
    FILTR(256, null),
    MAHL(287, null),
    HP(301, null),
    GRAF(310, null),
    CIF(311, null),
    KWP(312, "KWP"),
    WIX(324, null),
    BLUE(350, null),
    GSP(373, "-GSP"),
    FR(380, "F"),
    GOET(385, null),
    KS(432, null),
    ENERG(443, null),
    CONTI(4434, "CT"),
    FTG(4581, null),
    DON(4868, null),
    HIFI(6309, null),
    NTY(6355, null);

    @NonNull
    final Integer tecDocId;
    final String dodatak;

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
