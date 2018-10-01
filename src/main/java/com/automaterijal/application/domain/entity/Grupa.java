package com.automaterijal.application.domain.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Grupa {

    @Id
    @GeneratedValue
    @Column(name = "grupaid")
    String grupaid;

    @Column(name = "naziv")
    String naziv;

    @Column(name = "nikadpopust")
    int nikadpopust;
}
