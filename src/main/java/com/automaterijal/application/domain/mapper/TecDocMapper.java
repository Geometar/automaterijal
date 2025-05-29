package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.dto.robadetalji.RobaAtributesDto;
import com.automaterijal.application.domain.dto.tecdoc.Manufcatures;
import com.automaterijal.application.domain.dto.tecdoc.Model;
import com.automaterijal.application.domain.dto.tecdoc.TecDocDokumentacija;
import com.automaterijal.application.domain.entity.tecdoc.TecDocAtributi;
import com.automaterijal.application.tecdoc.*;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TecDocMapper {

  @Mapping(target = "tecDocArticleId", source = "tecDocArticleId")
  @Mapping(target = "robaId", source = "robaLightDto.robaid")
  @Mapping(target = "tecDocPpid", source = "tecDocPpid")
  @Mapping(target = "ppid", source = "robaLightDto.proizvodjac.proid")
  @Mapping(target = "katbr", source = "robaLightDto.katbr")
  @Mapping(target = "attrValue", source = "record.attrValue")
  @Mapping(target = "attrUnit", source = "record.attrUnit")
  @Mapping(target = "attrShortName", source = "record.attrShortName")
  @Mapping(target = "attrType", source = "record.attrType")
  TecDocAtributi map(
      AssignedArticleAttributs2Record record,
      RobaLightDto robaLightDto,
      Long tecDocArticleId,
      Long tecDocPpid);

  @Mapping(target = "tecDocArticleId", source = "tecDocArticleId")
  @Mapping(target = "robaId", source = "robaLightDto.robaid")
  @Mapping(target = "tecDocPpid", source = "tecDocPpid")
  @Mapping(target = "ppid", source = "robaLightDto.proizvodjac.proid")
  @Mapping(target = "katbr", source = "robaLightDto.katbr")
  @Mapping(target = "dokumentId", source = "record.docId")
  TecDocAtributi map(
      ArticleDocuments2Record record,
      RobaLightDto robaLightDto,
      Long tecDocArticleId,
      Long tecDocPpid);

  TecDocDokumentacija map(ArticleDocuments2Record record);

  @Mapping(target = "tecDocArticleId", source = "tecDocArticleId")
  @Mapping(target = "robaId", source = "robaLightDto.robaid")
  @Mapping(target = "tecDocPpid", source = "tecDocPpid")
  @Mapping(target = "ppid", source = "robaLightDto.proizvodjac.proid")
  @Mapping(target = "katbr", source = "robaLightDto.katbr")
  @Mapping(target = "dokumentId", source = "record.thumbDocId")
  TecDocAtributi map(
      ThumbnailByArticleIdRecord record,
      RobaLightDto robaLightDto,
      Long tecDocArticleId,
      Long tecDocPpid);

  @Mapping(target = "id", source = "manuId")
  @Mapping(target = "favoriteFlag", source = "favorFlag")
  @Mapping(target = "type", source = "linkingTargetTypes")
  @Mapping(target = "name", source = "manuName")
  Manufcatures map(Manufacturers2Record manufacturers2Record);

  List<Manufcatures> mapToManufcatures(List<Manufacturers2Record> manufacturers2Record);

  @Mapping(target = "modelId", source = "modelId")
  @Mapping(target = "favoriteFlag", source = "favorFlag")
  @Mapping(target = "name", source = "modelname")
  @Mapping(target = "constructedFrom", source = "yearOfConstrFrom")
  @Mapping(target = "constructedTo", source = "yearOfConstrTo")
  Model map(ModelSeries2Record modelSeries2Record);

  List<Model> mapToModel(List<ModelSeries2Record> modelSeries2Records);

  TecDocAtributi map(RobaAtributesDto dto);

  List<TecDocAtributi> map(List<RobaAtributesDto> dto);
}
