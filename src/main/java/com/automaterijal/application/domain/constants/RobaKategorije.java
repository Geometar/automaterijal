package com.automaterijal.application.domain.constants;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@RequiredArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum RobaKategorije {

    DVOTAKTOL(List.of("DVOTAKTOL"), false, true),
    MOTORNA_ULJA(List.of("MOTORNO ULjE"), false, true),
    MENJACKA_ULJA(List.of("MENJAČKO ULjE"), false, true),
    KOCIONO_ULJE(List.of("KOČIONO ULjE"), false, true),
    ANTIFRIZ(List.of("ANTIFRIZ"), false, true);

    @NonNull
    final List<String> fieldName;
    @NonNull
    final boolean grupaPretraga;
    @NonNull
    final boolean podgrupaPretraga;
}
