package com.automaterijal.application.domain.dto.robadetalji;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaBrojeviDto {
    String fabrBroj;
    String proizvodjac;
}
