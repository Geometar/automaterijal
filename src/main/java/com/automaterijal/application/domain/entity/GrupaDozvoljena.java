package com.automaterijal.application.domain.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
