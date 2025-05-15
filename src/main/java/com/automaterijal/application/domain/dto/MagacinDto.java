package com.automaterijal.application.domain.dto;

import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MagacinDto {

  Page<RobaLightDto> robaDto;
  Map<String, List<PodgrupaDto>> categories;
  List<ProizvodjacDTO> proizvodjaci;
}
