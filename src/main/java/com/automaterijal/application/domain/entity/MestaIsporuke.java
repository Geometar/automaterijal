package com.automaterijal.application.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "mesta_isporuke")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MestaIsporuke implements Serializable {

  @Id
  @GeneratedValue
  @Column(name = "ppid")
  Integer ppid;

  @Column(name = "nppid")
  String nppid;

  @Column
  String naziv;

  @Column
  String adresa;
}

