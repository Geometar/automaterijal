package com.automaterijal.application.domain.entity.roba;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "robaumagacinu")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaCene {

    @Id
    @Column
    Long magacinid;
    @Column(name = "robaid")
    Long robaid;
    @Column
    String stanje;
    @Column(precision=15, scale=2)
    BigDecimal nabavnacena;
    @Column(precision=15, scale=2)
    BigDecimal prodajnacena;
    @Column(precision=15, scale=4)
    BigDecimal deviznacena;
    @Column(precision=15, scale=2)
    BigDecimal pdvstopa;
}
