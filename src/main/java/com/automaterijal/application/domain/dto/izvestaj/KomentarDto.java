package com.automaterijal.application.domain.dto.izvestaj;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KomentarDto {
    Long id;
    LocalDate podsetnik;
    LocalDate datumKreiranja;
    String komentar;
    Long firma;
    Integer ppid;
    String komercijalista;
}
