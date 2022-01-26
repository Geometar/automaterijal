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
    SlikaDto slika;
    String katbr;
    String katbrpro;
    String naziv;
    Proizvodjac proizvodjac;
    byte[] proizvodjacLogo;
    String grupa;
    int podGrupa;
    String podGrupaNaziv;
    BigDecimal cena;
    Double rabat;
    String dokumentSlikaId;
    byte[] dokument;
    double stanje;
    boolean dozvoljenoZaAnonimusa;
    List<RobaTehnickiOpisDto> tehnickiOpis;
}
