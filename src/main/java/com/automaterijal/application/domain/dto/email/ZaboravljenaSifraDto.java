package com.automaterijal.application.domain.dto.email;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ZaboravljenaSifraDto {
    public static final String NASLOV = "Promena sifre";
    public static final String TEMPLATE = "zaboravljenaSifraTemplate";
    String email;
}
