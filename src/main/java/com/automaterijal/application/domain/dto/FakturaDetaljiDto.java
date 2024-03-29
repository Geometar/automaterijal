package com.automaterijal.application.domain.dto;

import com.automaterijal.application.domain.entity.Proizvodjac;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FakturaDetaljiDto {

    Long robaId;
    SlikaDto slika;
    String kataloskiBroj;
    String kataloskiBrojProizvodjaca;
    String naziv;
    Proizvodjac proizvodjac;
    Double kolicina;
    Double potvrdjenaKolicina;
    Double cena;
    ValueHelpDto status;
    Double rabat;
    String vremePorucivanja;

}
