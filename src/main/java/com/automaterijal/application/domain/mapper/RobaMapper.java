package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.dto.RobaTehnickiOpisDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaAplikacijaDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaBrojeviDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaDetaljiDto;
import com.automaterijal.application.domain.entity.roba.Roba;
import com.automaterijal.application.domain.entity.roba.RobaAplikacija;
import com.automaterijal.application.domain.entity.roba.RobaBrojevi;
import com.automaterijal.application.domain.entity.roba.RobaOpis;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class RobaMapper {

    public abstract RobaDto map(Roba roba);

    public abstract List<RobaTehnickiOpisDto> map(List<RobaOpis> opisi);

    @Mapping(target = "robaId", source = "robaid")
    @Mapping(target = "grupa", source = "grupaid")
    @Mapping(target = "podGrupa", source = "podgrupaid")
    public abstract RobaDetaljiDto mapujDetaljno(Roba roba);

    public abstract List<RobaBrojeviDto> mapBorjeve(List<RobaBrojevi> brojevi);

    @Mapping(target = "fabrBroj", source = "id.broj")
    @Mapping(target = "proizvodjac", source = "proizvodjac")
    public abstract RobaBrojeviDto map(RobaBrojevi broj);

    @Mapping(target = "kw", source = "kw")
    public abstract RobaAplikacijaDto mapAplikacija(RobaAplikacija aplikacija);
}
