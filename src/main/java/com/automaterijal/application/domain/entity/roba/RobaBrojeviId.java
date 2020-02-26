package com.automaterijal.application.domain.entity.roba;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaBrojeviId implements Serializable {

    @Column(name = "robaid")
    Long robaId;

    @Column(name = "fabrbroj")
    String fabrBroj;

    @Column(name = "broj")
    String broj;
}
