package com.automaterijal.application.domain.dto.tecdoc;

import java.util.List;
import lombok.Value;

@Value
public class TecDocLinkedModelDto {
  Long modelId;
  String modelName;
  List<TecDocLinkedVariantDto> variants;
}
