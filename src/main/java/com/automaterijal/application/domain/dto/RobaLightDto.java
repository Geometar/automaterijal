package com.automaterijal.application.domain.dto;

import com.automaterijal.application.domain.cache.RobaCache;
import com.automaterijal.application.domain.entity.Proizvodjac;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaLightDto extends RobaCache {
  SlikaDto slika;
  ProizvodjacDTO proizvodjac;
  String proizvodjacLogo;
  String grupa;
  int podGrupa;
  String podGrupaNaziv;
  BigDecimal cena;
  Double rabat;
  String dokumentSlikaId;
  byte[] dokument;
  double stanje;
  List<RobaTehnickiOpisDto> tehnickiOpis;
  List<RobaTehnickiOpisDto> tdLinkageCriteria = new ArrayList<>();

  public void setProizvodjacDto(Proizvodjac proizvodjac) {
    ProizvodjacDTO proizvodjacDTO = new ProizvodjacDTO();
    proizvodjacDTO.setProizvodjac(proizvodjac);
    setProizvodjac(proizvodjacDTO);
  }
}
