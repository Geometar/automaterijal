package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaAplikacijaDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaDetaljiDto;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.entity.roba.RobaAplikacija;
import com.automaterijal.application.domain.entity.roba.RobaOpis;
import com.automaterijal.db.tables.records.RobaRecord;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RobaMapper {

  @Mapping(target = "podGrupa", source = "podgrupaid")
  @Mapping(target = "grupa", source = "grupaid")
  @Mapping(target = "slika.robaSlika", source = "slika")
  RobaDto map(Roba roba);

  List<RobaTehnickiOpisDto> map(List<RobaOpis> opisi);

  @Mapping(target = "grupa", source = "grupaid")
  @Mapping(target = "podGrupa", source = "podgrupaid")
  @Mapping(target = "slika.robaSlika", source = "slika")
  RobaDetaljiDto mapujDetaljno(Roba roba);

  @Mapping(target = "kw", source = "kw")
  RobaAplikacijaDto mapAplikacija(RobaAplikacija aplikacija);

  @Mapping(target = "proizvodjac.proid", source = "proid")
  Roba map(RobaRecord robaRecord);
}
