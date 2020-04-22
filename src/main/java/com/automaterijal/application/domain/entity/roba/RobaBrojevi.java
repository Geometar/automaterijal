package com.automaterijal.application.domain.entity.roba;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "td_brojevi")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaBrojevi {

    @EmbeddedId
    RobaBrojeviId id;

    @Column(name = "opis")
    String opis;

    @Column(name = "brojsrch")
    String brojSrch;

    @Column(name = "naziv")
    String naziv;

    @Column(name = "nazivpro")
    String proizvodjac;

    @Column(name = "vrsta")
    Integer vrsta;

    @Column(name = "nadjenpreko")
    String nadjenPreko;
}
