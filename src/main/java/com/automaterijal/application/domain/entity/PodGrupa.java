package com.automaterijal.application.domain.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
