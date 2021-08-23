package com.automaterijal.application.domain.dto;

import com.automaterijal.application.domain.entity.Proizvodjac;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaDto {
    Long robaid;
    SlikaDto slika;
    String katbr;
    String katbrpro;
    String naziv;
    Proizvodjac proizvodjac;
    String grupa;
    String podGrupa;
    String podGrupaNaziv;
    BigDecimal cena;
    Double rabat;
    double stanje;
    boolean dozvoljenoZaAnonimusa;
    Set<RobaTehnickiOpisDto> tehnickiOpis;
}
