package com.automaterijal.application.domain.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grupa_dozvoljena")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GrupaDozvoljena {
    @Id
    @Column(name = "grupaId")
    String grupaid;
    @Column
    String naziv;
}
