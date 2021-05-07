package com.automaterijal.application.domain.dto.izvestaj;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IzvestajDto {
    FirmaDto firmaDto;
    KomentarDto komentarDto;
}
