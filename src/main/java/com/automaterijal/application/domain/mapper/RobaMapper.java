package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Roba;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class RobaMapper {

    public static final RobaMapper INSTANCE = Mappers.getMapper(RobaMapper.class);

    public abstract RobaDto map(Roba roba);

}
