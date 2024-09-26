package com.automaterijal.application.domain.entity.roba;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "td_motori")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaMotor {

    @Id
    Integer id;

    @Column(name = "idtipa")
    Integer tip;

    @Column(name = "ideng")
    Integer eng;

    @Column(name = "motor")
    String motor;

    @Column(name = "braid")
    Integer braId;
}
