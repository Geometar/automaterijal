package com.automaterijal.application.domain.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

