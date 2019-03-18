package com.automaterijal.application.domain.dto.email;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpitDto {

    public static final String NASLOV = "Upit preko web aplikacije";
    public static final String TEMPLATE = "upitTemplate";

    String emailTelefon;
    String markaModel;
    String godiste;
    String kubikaza;
    String kilovati;
    List<String> gorivo;
    List<String> pogon;
    List<String> interesujeMe;
    String drugo;
}
