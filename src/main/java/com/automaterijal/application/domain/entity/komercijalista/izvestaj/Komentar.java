package com.automaterijal.application.domain.entity.komercijalista.izvestaj;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Komentar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String komentar;

    @Column
    Long firma;

    @Column
    Timestamp datumKreiranja;

    @Column
    Timestamp podsetnik;

    @Column
    Integer ppid;
}

