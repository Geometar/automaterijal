package com.automaterijal.application.domain.entity.roba;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artikal_slika")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaSlika {

    @Id
    @Column(name = "robaid")
    Long robaId;

    @Column(name = "slika")
    String slika;

}
