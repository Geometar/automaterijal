package com.automaterijal.application.domain.constants;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum  StatusiKonstante {
    NARUCIVANJE_U_TOKU(1),
    NIJE_UZETA_U_OBRADU(2),
    OBRADA_U_TOKU(3),
    POTVRDJENA(4),
    ZAHTEVA_ZA_PONISTENJE(5),
    PONISTENA(6),
    KONACNA(7),
    ARHIVIRANA(8);

    @NonNull
    final Integer fieldValue;
}
