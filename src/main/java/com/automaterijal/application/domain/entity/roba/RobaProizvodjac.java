package com.automaterijal.application.domain.entity.roba;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "td_proizvodjaci")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaProizvodjac {

    @Id
    @Column(name = "proizvodjacid")
    Integer id;

    @Column(name = "proizvodjacnaziv")
    String naziv;

}
