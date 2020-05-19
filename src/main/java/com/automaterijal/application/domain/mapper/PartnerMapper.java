package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.PartnerDto;
import com.automaterijal.application.domain.entity.Partner;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class PartnerMapper {

    @Mapping(target = "noviPassword", ignore = true)
    @Mapping(target = "stariPassword", ignore = true)
    @Mapping(target = "privilegije", source = "privilegije")
    @Mapping(target = "naziv", source = "mestaIsporuke.naziv")
    @Mapping(target = "adresa", source = "mestaIsporuke.adresa")
    @Mapping(target = "loginCount", source = "users.loginCount", defaultValue = "0")
    public abstract PartnerDto map(Partner partner);


    @Mapping(target = "ppid", ignore = true)
    @Mapping(target = "stanje", ignore = true)
    @Mapping(target = "stanjeporoku", ignore = true)
    @Mapping(target = "mestaIsporuke.naziv", ignore = true)
    @Mapping(target = "mestaIsporuke.adresa", source = "adresa")
    @Mapping(target = "users.password", source = "noviPassword")
    public abstract void map(@MappingTarget Partner partner, PartnerDto partnerDto);
}
