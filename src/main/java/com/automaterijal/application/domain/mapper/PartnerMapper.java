package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.PartnerDto;
import com.automaterijal.application.domain.entity.Partner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class PartnerMapper {

    public static final PartnerMapper INSTANCE = Mappers.getMapper(PartnerMapper.class);

    @Mapping(target = "noviPassword", ignore = true)
    @Mapping(target = "stariPassword", ignore = true)
    @Mapping(target = "naziv", source = "mestaIsporuke.naziv")
    @Mapping(target = "adresa", source = "mestaIsporuke.adresa")
    @Mapping(target = "loginCount", source = "users.loginCount")
    public abstract PartnerDto map(Partner partner);


    @Mapping(target = "ppid", ignore = true)
    @Mapping(target = "stanje", ignore = true)
    @Mapping(target = "stanjeporoku", ignore = true)
    @Mapping(target = "mestaIsporuke.naziv", ignore = true)
    @Mapping(target = "mestaIsporuke.adresa", source = "adresa")
    @Mapping(target = "users.password", source = "noviPassword")
    public abstract void map(@MappingTarget Partner partner, PartnerDto partnerDto);
}
