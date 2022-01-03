package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.RobaDto;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.tecdoc.AssignedArticleAttributs2Record;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class TecDocMapper {

    @Mapping(target = "tecDocArticleId", source = "tecDocArticleId")
    @Mapping(target = "robaId", source = "robaDto.robaid")
    @Mapping(target = "tecDocPpid", source = "tecDocPpid")
    @Mapping(target = "ppid", source = "robaDto.proizvodjac.proid")
    @Mapping(target = "katbr", source = "robaDto.katbr")
    @Mapping(target = "attrValue", source = "record.attrValue")
    @Mapping(target = "attrUnit", source = "record.attrUnit")
    @Mapping(target = "attrShortName", source = "record.attrShortName")
    @Mapping(target = "attrType", source = "record.attrType")
    public abstract TecDocAtributi map(AssignedArticleAttributs2Record record, RobaDto robaDto, Long tecDocArticleId, Integer tecDocPpid);
}
