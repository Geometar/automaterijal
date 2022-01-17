package com.automaterijal.application.domain.dto.tecdoc;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Dokument {
    byte[] object;

    public Dokument(byte[] object) {
        this.object = object;
    }
}
