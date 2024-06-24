package com.automaterijal.application.domain.entity.roba;

import com.automaterijal.application.domain.entity.Proizvodjac;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

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
  @Column(name = "stanje")
  double stanje;
  @Column(name = "slika")
  String slika;
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
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "proid", insertable = false, updatable = false)
  Proizvodjac proizvodjac;

}
