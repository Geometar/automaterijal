package com.automaterijal.application.domain.entity.roba;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
