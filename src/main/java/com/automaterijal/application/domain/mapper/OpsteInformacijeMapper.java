package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.ValueHelpDto;
import com.automaterijal.application.domain.entity.valuehelp.NacinPlacanja;
import com.automaterijal.application.domain.entity.valuehelp.NacinPrevoza;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = MapperUtil.class)
public abstract class OpsteInformacijeMapper {
    public static final OpsteInformacijeMapper INSTANCE = Mappers.getMapper(OpsteInformacijeMapper.class);

    public abstract ValueHelpDto map(NacinPlacanja nacinPlacanja);
    public abstract ValueHelpDto map(NacinPrevoza nacinPrevoza);
}
