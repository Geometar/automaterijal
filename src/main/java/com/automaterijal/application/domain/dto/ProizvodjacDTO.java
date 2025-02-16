package com.automaterijal.application.domain.dto;

import com.automaterijal.application.domain.entity.Proizvodjac;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProizvodjacDTO {
  String proid;
  String naziv;

  public void setProizvodjac(Proizvodjac proizvodjac) {
    setNaziv(proizvodjac.getNaziv());
    setProid(proizvodjac.getProid());
  }
}
