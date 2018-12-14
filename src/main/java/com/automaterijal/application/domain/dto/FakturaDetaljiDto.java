package com.automaterijal.application.domain.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FakturaDetaljiDto {

    Long robaId;
    String kataloskiBroj;
    String proizvodjac;
    Double kolicina;
    Double potvrdjenaKolicina;
    Double cena;
    ValueHelpDto status;
    Double rabat;
    String vremePorucivanja;

}
