package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.Roba;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class RobaMapper {

    public abstract RobaDto map(Roba roba);

}
