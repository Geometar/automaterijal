package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.PartnerDto;
import com.automaterijal.application.domain.dto.PartnerLogovanjeDto;
import com.automaterijal.application.domain.entity.Partner;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PartnerMapper {

  @Mapping(target = "noviPassword", ignore = true)
  @Mapping(target = "stariPassword", ignore = true)
  @Mapping(target = "privilegije", source = "privilegije")
  @Mapping(target = "naziv", source = "mestaIsporuke.naziv")
  @Mapping(target = "adresa", source = "mestaIsporuke.adresa")
  @Mapping(target = "loginCount", source = "users.loginCount", defaultValue = "0")
  PartnerDto map(Partner partner);
  List<PartnerDto> map(List<Partner> partner);


  @Mapping(target = "ppid", ignore = true)
  @Mapping(target = "stanje", ignore = true)
  @Mapping(target = "stanjeporoku", ignore = true)
  @Mapping(target = "mestaIsporuke.naziv", ignore = true)
  @Mapping(target = "mestaIsporuke.adresa", source = "adresa")
  @Mapping(target = "users.password", source = "noviPassword")
  void map(@MappingTarget Partner partner, PartnerDto partnerDto);

  @Mapping(target = "naziv", source = "mestaIsporuke.naziv")
  PartnerLogovanjeDto mapLogovanje(Partner partner);

  @AfterMapping
  default void afterMaper(@MappingTarget PartnerLogovanjeDto logovanjeDto, Partner partner) {
    if (partner.getUsers() != null && partner.getUsers().getLastLogin() != null) {
      logovanjeDto.setPoslednjeLogovanje(
          DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
              .format(partner.getUsers().getLastLogin().toLocalDateTime())
      );
    }
  }
}
