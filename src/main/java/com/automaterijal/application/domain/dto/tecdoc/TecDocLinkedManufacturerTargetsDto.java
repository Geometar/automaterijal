package com.automaterijal.application.domain.dto.tecdoc;

import com.automaterijal.application.tecdoc.ArticleLinkedAllLinkingTargetsByIds3Record;
import java.util.List;
import lombok.Value;

@Value
public class TecDocLinkedManufacturerTargetsDto {
  Long manufacturerId;
  String manufacturerName;
  List<ArticleLinkedAllLinkingTargetsByIds3Record> targets;
}
