package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.RobaDto;
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
  @Mapping(target = "robaId", source = "robaDto.robaid")
  @Mapping(target = "tecDocPpid", source = "tecDocPpid")
  @Mapping(target = "ppid", source = "robaDto.proizvodjac.proid")
  @Mapping(target = "katbr", source = "robaDto.katbr")
  @Mapping(target = "attrValue", source = "record.attrValue")
  @Mapping(target = "attrUnit", source = "record.attrUnit")
  @Mapping(target = "attrShortName", source = "record.attrShortName")
  @Mapping(target = "attrType", source = "record.attrType")
  TecDocAtributi map(
      AssignedArticleAttributs2Record record,
      RobaDto robaDto,
      Long tecDocArticleId,
      Integer tecDocPpid);

  @Mapping(target = "tecDocArticleId", source = "tecDocArticleId")
  @Mapping(target = "robaId", source = "robaDto.robaid")
  @Mapping(target = "tecDocPpid", source = "tecDocPpid")
  @Mapping(target = "ppid", source = "robaDto.proizvodjac.proid")
  @Mapping(target = "katbr", source = "robaDto.katbr")
  @Mapping(target = "dokumentId", source = "record.docId")
  TecDocAtributi map(
      ArticleDocuments2Record record, RobaDto robaDto, Long tecDocArticleId, Integer tecDocPpid);

  TecDocDokumentacija map(ArticleDocuments2Record record);

  @Mapping(target = "tecDocArticleId", source = "tecDocArticleId")
  @Mapping(target = "robaId", source = "robaDto.robaid")
  @Mapping(target = "tecDocPpid", source = "tecDocPpid")
  @Mapping(target = "ppid", source = "robaDto.proizvodjac.proid")
  @Mapping(target = "katbr", source = "robaDto.katbr")
  @Mapping(target = "dokumentId", source = "record.thumbDocId")
  TecDocAtributi map(
      ThumbnailByArticleIdRecord record, RobaDto robaDto, Long tecDocArticleId, Integer tecDocPpid);

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
}
