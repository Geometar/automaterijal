package com.automaterijal.application.domain.dto.tecdoc;

import lombok.Value;

@Value
public class TecDocLinkedVariantDto {
  Long articleLinkId;
  Long linkingTargetId;
  Long carId;
  String engine;
  String constructionType;
  Integer powerKwFrom;
  Integer powerKwTo;
  Integer powerHpFrom;
  Integer powerHpTo;
  Integer cylinderCapacity;
  Integer productionYearFrom;
  Integer productionYearTo;
}
