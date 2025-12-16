package com.automaterijal.application.domain.dto;

import com.automaterijal.application.domain.cache.RobaCache;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaLightDto extends RobaCache {
  SlikaDto slika;
  String proizvodjacLogo;
  String grupa;
  String grupaNaziv;
  int podGrupa;
  String podGrupaNaziv;
  BigDecimal cena;
  Double rabat;
  String dokumentSlikaId;
  byte[] dokument;
  double stanje;
  List<RobaTehnickiOpisDto> tehnickiOpis;
  List<RobaTehnickiOpisDto> tdLinkageCriteria = new ArrayList<>();
  ProviderAvailabilityDto providerAvailability;
  ArticleAvailabilityStatus availabilityStatus;
}
