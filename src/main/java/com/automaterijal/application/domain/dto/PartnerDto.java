package com.automaterijal.application.domain.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PartnerDto {

    Integer ppid;
    String naziv;
    String email;
    String adresa;
    String webKorisnik;
    String noviPassword;
    String stariPassword;
    Double stanje;
    Double stanjeporoku;

}
