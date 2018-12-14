package com.automaterijal.application.domain.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ppgrupavpc")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Popusti {

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
