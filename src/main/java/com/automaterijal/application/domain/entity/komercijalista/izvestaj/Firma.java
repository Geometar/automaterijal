package com.automaterijal.application.domain.entity.komercijalista.izvestaj;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Firma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String mesto;
    @Column
    String ime;
    @Column
    String adresa;
    @Column
    String kontakt;
    @Column
    String sektor;
    @Column
    String osnovniAsortiman;
    @Column
    String konkurent;
    @Column
    Integer ppid;
}
