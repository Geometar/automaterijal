package com.automaterijal.application.domain.entity.roba;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "td_teh_opis")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaOpis {

    @Id
    @Column(name = "teh_opis_id")
    Long opisId;

    @Column(name = "robaid")
    Long robaId;

    @Column(name = "oznaka")
    String oznaka;

    @Column(name = "vrednost")
    String vrednost;

    @Column(name = "jedinica")
    String jedinica;

    @Column(name = "cri_id")
    Integer criId;

    @Column(name = "sort")
    Integer sort;

    @Column(name = "cri_is_interval")
    Integer criIsInterval;

    @Column(name = "cri_successor")
    Integer criSeccesssor;

    @Column(name = "nazivid")
    Integer nazivId;
}
