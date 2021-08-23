package com.automaterijal.application.domain.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SlikaDto {

    byte[] slikeByte;
    String slikeUrl;
    boolean isUrl;

}
