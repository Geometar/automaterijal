package com.automaterijal.application.domain.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "mesta_isporuke")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MestaIsporuke {

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

