package com.automaterijal.application.domain.entity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "partner")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Partner implements Serializable {

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
