package com.automaterijal.application.domain.dto.robadetalji;

import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.entity.Proizvodjac;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaDetaljiDto {
    Long robaId;
    String slika;
    String grupa;
    String podGrupa;
    String katbr;
    String naziv;
    double stanje;
    Double rabat;
    BigDecimal cena;
    Proizvodjac proizvodjac;
    List<RobaTehnickiOpisDto> tehnickiOpis;
    List<RobaBrojeviDto> tdBrojevi;
    Map<String, List<RobaAplikacijaDto>> aplikacije;
}
