package com.automaterijal.application.domain.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
