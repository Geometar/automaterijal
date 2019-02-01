package com.automaterijal.application.domain.dto.email;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PorukaDto {

    public static final String NASLOV = "Web Poruka";
    public static final String TEMPLATE = "porukaTemplate";
    String ime;
    String prezime;
    String firma;
    String telefon;
    String posta;
    String poruka;

}
