package com.automaterijal.application.domain.entity.roba;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
