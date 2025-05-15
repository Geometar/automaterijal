package com.automaterijal.application.domain.mapper;

import com.automaterijal.application.domain.dto.ProizvodjacDTO;
import com.automaterijal.application.domain.entity.Proizvodjac;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ManufacturerMapper {
  ProizvodjacDTO map(Proizvodjac manufacture);

  List<ProizvodjacDTO> map(List<Proizvodjac> manufactures);
}
