package com.automaterijal.application.domain.dto;

import com.automaterijal.application.domain.entity.Proizvodjac;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaDto {
    Long robaid;
    String slika;
    String katbr;
    String katbrpro;
    String naziv;
    Proizvodjac proizvodjac;
    String grupa;
    String podGrupa;
    BigDecimal cena;
    Double rabat;
    double stanje;
    List<RobaTehnickiOpisDto> tehnickiOpis;
}
