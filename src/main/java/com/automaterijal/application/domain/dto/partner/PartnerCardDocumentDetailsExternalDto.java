package com.automaterijal.application.domain.dto.partner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PartnerCardDocumentDetailsExternalDto {

  @JsonProperty("ErrorCode")
  Integer errorCode;

  @JsonProperty("ErrorMessage")
  String errorMessage;

  @JsonProperty("stavke")
  List<PartnerCardDocumentExternalItemDto> stavke;
}
