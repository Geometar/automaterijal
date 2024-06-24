package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.ValueHelpDto;
import com.automaterijal.application.domain.entity.valuehelp.NacinPlacanja;
import com.automaterijal.application.domain.entity.valuehelp.NacinPrevoza;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface OpsteInformacijeMapper {

  ValueHelpDto map(NacinPlacanja nacinPlacanja);

  ValueHelpDto map(NacinPrevoza nacinPrevoza);
}
