package com.automaterijal.application.domain.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaDto {

    String katbr;
    String katbrpro;
    String naziv;
    String proizvodjac;
    String grupa;
    String podGrupa;
    double stanje;

}
