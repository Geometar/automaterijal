package com.automaterijal.application.domain.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roba_katbr_old")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaKatBrPro {

    @Id
    @Column(name = "robaid")
    Long robaid;
    @Column(name = "katbr")
    String katbr;
    @Column(name = "katbrpro")
    String katbrpro;

}
