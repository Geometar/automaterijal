package com.automaterijal.application.domain.dto.tecdoc;

import java.util.List;
import lombok.Value;

@Value
public class TecDocLinkedManufacturerTargetsDto {
  Long manufacturerId;
  String manufacturerName;
  List<TecDocLinkedModelDto> models;
}
