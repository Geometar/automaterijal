package com.automaterijal.application.domain.dto.izvestaj;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FirmaDto {
    Long id;
    String mesto;
    String ime;
    String adresa;
    String kontakt;
    String sektor;
    String osnovniAsortiman;
    String konkurent;
    boolean izmena;
}
