package com.automaterijal.application.domain.constants;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum RobaSortiranjePolja {

    KATBR("katbr"),
    KATBRPRO("katbrpro");

    @NonNull
    final String fieldName;

}
