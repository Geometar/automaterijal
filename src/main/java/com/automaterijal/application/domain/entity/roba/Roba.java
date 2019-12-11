package com.automaterijal.application.domain.entity.roba;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Roba {

    @Id
    @Column(name = "robaid")
    Long robaid;
    @Column(name = "katbr")
    String katbr;
    @Column(name = "katbrpro")
    String katbrpro;
    @Column(name = "naziv")
    String naziv;
    @Column(name = "grupaid")
    String grupaid;
    @Column(name = "podgrupaid")
    int podgrupaid;
    @Column(name = "proid")
    String proid;
    @Column(name = "stanje")
    double stanje;
    @Column(name = "fabrcena")
    double fabrcena;
    @Column(name = "devnabcena")
    double devnabcena;
    @Column(name = "porez")
    double porez;
    @Column(name = "komentar")
    String komentar;
    @Column(name = "vpcid")
    int vpcid;

}
