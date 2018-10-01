package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Grupa;
import com.automaterijal.application.domain.entity.Proizvodjac;
import com.automaterijal.application.domain.entity.Roba;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class RobaMapper {

    public static final RobaMapper INSTANCE = Mappers.getMapper(RobaMapper.class);

    public abstract RobaDto map(Roba roba, Proizvodjac proizvodjac, Grupa grupa);

    @Mapping(target = "kataloskiBr", source = "katbr")
    @Mapping(target = "kataloskiBrProizvodjaca", source = "katbrpro")
    @Mapping(target = "naziv", expression = "java(roba.geNaziv())")
    @Mapping(target = "stanje", source = "stanje")
    public abstract RobaDto map(Roba roba);

    @Mapping(target = "proizvodjac", expression = "java(proizvodjac.getNaziv())")
    public abstract RobaDto map(Proizvodjac proizvodjac);

    @Mapping(target = "grupa", expression = "java(grupa.getNaziv())")
    public abstract RobaDto map(Grupa grupa);

}
