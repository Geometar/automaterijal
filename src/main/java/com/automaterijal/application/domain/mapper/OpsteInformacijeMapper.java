package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.ValueHelpDto;
import com.automaterijal.application.domain.entity.valuehelp.NacinPlacanja;
import com.automaterijal.application.domain.entity.valuehelp.NacinPrevoza;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class OpsteInformacijeMapper {

    public abstract ValueHelpDto map(NacinPlacanja nacinPlacanja);
    public abstract ValueHelpDto map(NacinPrevoza nacinPrevoza);
}
