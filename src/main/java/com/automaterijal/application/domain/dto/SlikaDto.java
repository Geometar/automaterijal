package com.automaterijal.application.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SlikaDto {

  String slikeUrl;

  @JsonProperty("isUrl")
  boolean isUrl;

  String robaSlika;

  public SlikaDto(String robaSlika) {
    this.robaSlika = robaSlika;
  }
}
