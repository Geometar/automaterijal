package com.automaterijal.application.domain.entity;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "ppgrupavpc")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Popusti implements Serializable {

  @Id
  Integer ppgvpcid;
  Integer ppid;
  Integer magacinid;
  String grupaid;
  String proid;
  String vpcid;
  Double procenat;
  Integer izmagacinid;
  Integer robaid;
}
