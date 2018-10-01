package com.automaterijal.application.domain.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaDto {

    String kataloskiBr;
    String kataloskiBrProizvodjaca;
    String naziv;
    String proizvodjac;
    String grupa;
    double stanje;

}
