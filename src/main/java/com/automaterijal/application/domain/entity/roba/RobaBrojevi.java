package com.automaterijal.application.domain.entity.roba;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

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
    String nazivPro;

    @Column(name = "vrsta")
    Integer vrsta;

    @Column(name = "nadjenpreko")
    String nadjenPreko;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idpro", referencedColumnName = "proizvodjacid", insertable = false, updatable = false)
    RobaProizvodjac robaProizvodjac;
}
