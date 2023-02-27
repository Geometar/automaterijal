package com.automaterijal.application.domain.entity.roba;


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "robaumagacinu")
@IdClass(RobaCeneId.class)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaCene {

  @Id
  @Column
  Long magacinid;
  @Id
  @Column(name = "robaid")
  Long robaid;
  @Column
  String stanje;
  @Column(precision = 15, scale = 2)
  BigDecimal nabavnacena;
  @Column(precision = 15, scale = 2)
  BigDecimal prodajnacena;
  @Column(precision = 15, scale = 4)
  BigDecimal deviznacena;
  @Column(precision = 15, scale = 2)
  BigDecimal pdvstopa;
}
