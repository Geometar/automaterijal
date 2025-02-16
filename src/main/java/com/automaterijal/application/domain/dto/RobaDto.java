package com.automaterijal.application.domain.dto;

import com.automaterijal.application.domain.entity.Proizvodjac;
import java.math.BigDecimal;
import java.util.List;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
  ProizvodjacDTO proizvodjac;
  byte[] proizvodjacLogo;
  String grupa;
  int podGrupa;
  String podGrupaNaziv;
  BigDecimal cena;
  Double rabat;
  String dokumentSlikaId;
  byte[] dokument;
  double stanje;
  List<RobaTehnickiOpisDto> tehnickiOpis;

  public void setProizvodjacDto(Proizvodjac proizvodjac) {
    ProizvodjacDTO proizvodjacDTO = new ProizvodjacDTO();
    proizvodjacDTO.setProizvodjac(proizvodjac);
    setProizvodjac(proizvodjacDTO);
  }
}
