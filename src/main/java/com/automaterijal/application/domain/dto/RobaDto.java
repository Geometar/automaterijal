package com.automaterijal.application.domain.dto;

import com.automaterijal.application.domain.entity.Proizvodjac;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaDto {

    Long robaid;
    String katbr;
    String katbrpro;
    String naziv;
    Proizvodjac proizvodjac;
    String grupa;
    String podGrupa;
    BigDecimal cena;
    Double rabat;
    double stanje;

}
