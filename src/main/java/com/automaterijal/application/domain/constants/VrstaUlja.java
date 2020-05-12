package com.automaterijal.application.domain.constants;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum VrstaUlja {

    MOTORNA("motorna"),
    MENJACKA("menjacka"),
    KOCIONA("kociona"),
    ANTIFRIZ("antifriz"),
    HIDRAULICNA("hidraulicna"),
    KOMPRESORSKA("kompresorska"),
    REDUTKORSKA("redutktorska"),
    TRANSFORMATORSKA("transformatorska"),
    TURBINSKA("turbinska"),
    PNEUMATSKA("pneumatska"),
    KLIZNA("klizna"),
    PREONOSNA("prenosna"),
    INDUSTRIJA("industrija");

    @NonNull
    final String fieldName;
}
