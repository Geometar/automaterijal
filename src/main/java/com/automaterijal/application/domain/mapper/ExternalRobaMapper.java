package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.ExternalRobaDto;
import com.automaterijal.application.domain.entity.roba.Roba;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class ExternalRobaMapper {

    @Mapping(target = "itemNo", source = "roba.katbr")
    @Mapping(target = "description", source = "roba.naziv")
    @Mapping(target = "price", source = "cena")
    @Mapping(target = "quantity", source = "roba.stanje")
    @Mapping(target = "sucess", constant = "true")
    public abstract ExternalRobaDto map(Roba roba, Double cena);

}
