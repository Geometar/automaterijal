package com.automaterijal.application.domain.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "podgrupa")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PodGrupa {

    @Id
    @Column(name = "podgrupaid")
    Integer podGrupaId;
    @Column(name = "grupaid")
    String grupaId;
    @Column(name = "naziv")
    String naziv;
}
