package com.automaterijal.application.domain.mapper;


import com.automaterijal.application.domain.dto.PodgrupaDto;
import com.automaterijal.application.domain.entity.PodGrupa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class PodrgrupaMapper {

    @Mapping(target = "id", source = "podGrupaId")
    @Mapping(target = "naziv", source = "naziv")
    public abstract PodgrupaDto map(PodGrupa podgrupa);

}
