package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.PartnerDto;
import com.automaterijal.application.domain.entity.Partner;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class PartnerMapper {

    public static final PartnerMapper INSTANCE = Mappers.getMapper(PartnerMapper.class);

    public abstract PartnerDto map(Partner partner);

}
