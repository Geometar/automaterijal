package com.automaterijal.application.domain.dto.izvestaj;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KomentarDto {
    Long id;
    LocalDate podsetnik;
    Date datumKreiranja;
    String komentar;
    Long firma;
    Integer ppid;
    String komercijalista;
}
