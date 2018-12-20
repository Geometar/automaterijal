package com.automaterijal.application.domain.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "partner")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Partner {

    @Id
    Integer ppid;
    @Column
    String naziv;
    @Column
    String email;
    @Column(name = "web_korisnik")
    String webKorisnik;
    @Column(name = "web_lozinka")
    String webLozinka;
    @Column
    Integer cenovnikid;
    @Column
    Integer vrstacenovnika;
    @Column
    Integer vpcid;
    @Column(name = "web_status")
    Integer webStatus;
    @Column
    Integer magacinid;
    @Column
    Integer niid;
    @Column
    Integer privilegije;
    @Column
    Integer gppid;
    @Column(name = "cene_od_grupe")
    Integer cene_od_grupe;
    @Column
    Integer nppid;
    @Column(name = "vpc_rabat")
    Integer vpc_rabat;
    @Column
    Integer imaugovor;
    @Column
    Integer pol;
    @Column
    Integer audit;
    @Column
    Double rabat;
    @Column
    Double procpc;
    @Column
    Double stanje;
    @Column
    Double stanjeporoku;
    @Column
    Double dozvoljeniminus;
    @Column(name = "dozvoljeniminus_rok")
    Double dozvoljeniminusRok;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ppid")
    List<Popusti> popustiList;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ppid")
    Users users;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ppid")
    MestaIsporuke mestaIsporuke;
}
