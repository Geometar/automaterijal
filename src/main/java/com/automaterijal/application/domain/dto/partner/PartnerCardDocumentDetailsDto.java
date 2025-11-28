package com.automaterijal.application.domain.dto.partner;

import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PartnerCardDocumentDetailsDto {

  Integer errorCode;
  String errorMessage;
  List<PartnerCardDocumentItemDto> stavke;
}
