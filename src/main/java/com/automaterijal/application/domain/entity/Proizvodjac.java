package com.automaterijal.application.domain.entity;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Proizvodjac {

    @Id
    @Column(name = "proid")
    String proid;

    @Column(name = "naziv")
    String naziv;

}
