package com.automaterijal.application.domain.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResetovanjeSifreDto {
  Integer ppid;
  String staraSifra;
  String sifra;
  String ponovljenjaSifra;
}
