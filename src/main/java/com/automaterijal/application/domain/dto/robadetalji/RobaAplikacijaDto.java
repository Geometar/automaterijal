package com.automaterijal.application.domain.dto.robadetalji;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaAplikacijaDto {
    String proizvodjacNaziv;
    String modelNaziv;
    String tipVozila;
    String proizOd;
    String proizDo;
    String kw;
    String hp;
    String ccm;
}
