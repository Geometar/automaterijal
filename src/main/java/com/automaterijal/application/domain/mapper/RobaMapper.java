package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.roba.Roba;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class RobaMapper {

    public abstract RobaDto map(Roba roba);

}
