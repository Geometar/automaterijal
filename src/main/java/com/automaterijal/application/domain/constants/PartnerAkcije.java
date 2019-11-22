package com.automaterijal.application.domain.constants;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Sve akcije koje partner moze da
 * Sve akcije koje partner moze da
 * iskoristi da promeni informacije o sebi
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
public enum PartnerAkcije {
    PROMENA_ADRESE("Promena adrese"),
    PROMENA_MEJLA("Promena poste"),
    PROMENA_IMENA("Promena korisnickog imena"),
    PROMENA_SIFRE("Promena sifre");

    final String opis;
}
