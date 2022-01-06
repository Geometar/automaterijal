package com.automaterijal.application.domain.dto.robadetalji;

import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.dto.SlikaDto;
import com.automaterijal.application.domain.dto.tecdoc.TecDocDokumentacija;
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
    Long robaid;
    SlikaDto slika;
    String grupa;
    String podGrupa;
    String katbr;
    String naziv;
    String tekst;
    double stanje;
    boolean dozvoljenoZaAnonimusa;
    Double rabat;
    BigDecimal cena;
    Proizvodjac proizvodjac;
    byte[] proizvodjacLogo;
    List<RobaTehnickiOpisDto> tehnickiOpis;
    Map<String, List<RobaBrojeviDto>> tdBrojevi;
    Map<String, List<RobaAplikacijaDto>> aplikacije;
    Map<String, List<TecDocDokumentacija>> dokumentacija;
}
