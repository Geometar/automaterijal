package com.automaterijal.application.domain.entity.komercijalista.izvestaj;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KreirajIzvestaj {
    Long firmaId;
    String ime;
    String mesto;
    String adresa;
    String kontakt;
    String sektor;
    String osnovniAsortiman;
    String konkurent;
    String komentar;
    Long datumKreiranja;
    Long podsetnik;
}
