package com.automaterijal.application.domain.dto.robadetalji;

import com.automaterijal.application.domain.dto.RobaLightDto;
import com.automaterijal.application.domain.dto.tecdoc.TecDocDokumentacija;
import com.automaterijal.application.domain.dto.tecdoc.TecDocLinkedManufacturerDto;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaExpandedDto extends RobaLightDto {
  String tekst;
  List<RobaBrojeviDto> tdBrojevi;
  Map<String, List<TecDocDokumentacija>> dokumentacija;
  List<TecDocLinkedManufacturerDto> linkedManufacturers;
}
