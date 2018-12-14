package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.FakturaDetaljiDto;
import com.automaterijal.application.domain.dto.FakturaDto;
import com.automaterijal.application.domain.entity.*;
import com.automaterijal.application.domain.entity.valuehelp.NacinPlacanja;
import com.automaterijal.application.domain.entity.valuehelp.NacinPrevoza;
import com.automaterijal.application.domain.entity.valuehelp.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(uses = MapperUtil.class)
public abstract class FakturaMapper {

    public static final FakturaMapper INSTANCE = Mappers.getMapper(FakturaMapper.class);

    @Mapping(target = "vremePorucivanja", source = "dataSent")
    @Mapping(target = "iznos", source = "iznosNarucen")
    @Mapping(target = "status.id", source = "status")
    @Mapping(target = "nacinPlacanja.id", source = "nuid")
    @Mapping(target = "nacinPrevoza.id", source = "niid")
    @Mapping(target = "adresa.id", source = "mestoIsporuke")
    public abstract FakturaDto map(Faktura faktura);

    @Mapping(target = "nacinPlacanja.id", source = "id")
    @Mapping(target = "nacinPlacanja.naziv", source = "naziv")
    @Mapping(target = "id", ignore = true)
    public abstract FakturaDto map(@MappingTarget FakturaDto fakturaDto, NacinPlacanja nacinPlacanja);

    @Mapping(target = "nacinPrevoza.id", source = "id")
    @Mapping(target = "nacinPrevoza.naziv", source = "naziv")
    @Mapping(target = "id", ignore = true)
    public abstract FakturaDto map(@MappingTarget FakturaDto fakturaDto, NacinPrevoza nacinPrevoza);

    @Mapping(target = "adresa.id", source = "ppid")
    @Mapping(target = "adresa.naziv", source = "adresa")
    @Mapping(target = "id", ignore = true)
    public abstract FakturaDto map(@MappingTarget FakturaDto fakturaDto, MestaIsporuke mestaIsporuke);

    @Mapping(target = "status.id", source = "id")
    @Mapping(target = "status.naziv", source = "opis")
    @Mapping(target = "id", ignore = true)
    public abstract FakturaDto map(@MappingTarget FakturaDto fakturaDto, Status status);

    @Mapping(target = "vremePorucivanja", source = "insertDatetime")
    @Mapping(target = "status.id", source = "status")
    public abstract FakturaDetaljiDto map(final FakturaDetalji fakturaDetalji);

    @Mapping(target = "status.id", source = "id")
    @Mapping(target = "status.naziv", source = "opis")
    public abstract void map(@MappingTarget FakturaDetaljiDto fakturaDto, Status status);

    @Mapping(target = "kataloskiBroj", source = "katbr")
    public abstract void map(@MappingTarget FakturaDetaljiDto fakturaDto, Roba roba);

    @Mapping(target = "proizvodjac", source = "naziv")
    public abstract void map(@MappingTarget FakturaDetaljiDto fakturaDto, Proizvodjac proizvodjac);

}
