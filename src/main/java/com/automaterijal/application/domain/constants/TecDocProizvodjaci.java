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

    ATE(3),
    PIERB(5),
    LUK(6),
    VR(9),
    ELR(10),
    BERU(11),
    NGK(15),
    BIL(16),
    VALEO(21),
    VAR(26),
    BOSCH(30),
    SACHS(32),
    GATES(33),
    KNECH(34),
    LEMF(35),
    MNR(37),
    TEXT(39),
    DAY(42),
    JURID(48),
    SKF(50),
    BRMB(65),
    HENG(81),
    KYB(85),
    FEBI(101),
    SNR(110),
    NSN(123),
    OPTI(129),
    MOOG(134),
    CORTECO(140),
    MEYLE(144),
    FA(159),
    TRW(161),
    HPU(178),
    DENCK(186),
    FAG(192),
    GLY(202),
    INA(204),
    VER(215),
    FILTR(256),
    MAHL(287),
    HP(301),
    GRAF(310),
    CIF(311),
    KWP(312),
    WIX(324),
    BLUE(350),
    GSP(373),
    FR(380),
    GOET(385),
    KS(432),
    ENERG(443),
    CONTI(4434),
    FTG(4581),
    DON(4868),
    HIFI(6309),
    NTY(6355);

    @NonNull
    final Integer tecDocId;

    private static final Map<String, TecDocProizvodjaci> map;

    static {
        map = new HashMap<>();
        for (TecDocProizvodjaci v : TecDocProizvodjaci.values()) {
            map.put(v.name(), v);
        }
    }

    public static TecDocProizvodjaci pronadjiPoNazivu(String proId) {
        return map.get(proId);
    }
}
