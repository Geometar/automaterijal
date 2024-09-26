package com.automaterijal.application.domain.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "grupa")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Grupa {

    @Id
    @Column(name = "grupaid")
    String grupaid;

    @Column(name = "naziv")
    String naziv;

    @Column(name = "nikadpopust")
    int nikadpopust;
}
