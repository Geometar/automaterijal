package com.automaterijal.application.domain.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SlikaDto {

  byte[] slikeByte;
  String slikeUrl;
  boolean isUrl;
  String robaSlika;

  public SlikaDto(String robaSlika) {
    this.robaSlika = robaSlika;
  }

}
