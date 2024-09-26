package com.automaterijal.application.domain.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proizvodjac")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Proizvodjac {

    @Id
    @Column(name = "proid")
    String proid;

    @Column(name = "naziv")
    String naziv;

}
