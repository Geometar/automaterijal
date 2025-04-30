package com.automaterijal.application.domain.dto.robadetalji;

import com.automaterijal.application.domain.dto.AbstractRobaBaseDto;
import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.dto.tecdoc.TecDocDokumentacija;
import com.automaterijal.application.domain.entity.Proizvodjac;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaDetaljiDto extends AbstractRobaBaseDto {
  Long robaid;
  SlikaDto slika;
  String grupa;
  String podGrupa;
  String katbr;
  String naziv;
  String tekst;
  double stanje;
  Double rabat;
  BigDecimal cena;
  Proizvodjac proizvodjac;
  String proizvodjacLogo;
  List<RobaTehnickiOpisDto> tehnickiOpis;
  List<RobaBrojeviDto> tdBrojevi;
  Map<String, List<RobaAplikacijaDto>> aplikacije;
  Map<String, List<TecDocDokumentacija>> dokumentacija;
  List<RobaDto> asociraniArtikli;
}
