package com.automaterijal.application.domain.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FakturaDetalji {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Integer id;
    @Column(name = "ppid")
    Integer ppid;
    @Column(name = "robaid")
    Long robaId;
    @Column(name = "magacinid")
    Integer magacinId;
    @Column(name = "kolicina")
    Double kolicina;
    @Column(name = "potvrdjena_kolicina")
    Double potvrdjenaKolicina;
    @Column(name = "cena")
    Double cena;
    @Column(name = "status")
    Integer status;
    @Column(name = "order_id")
    Integer orderId;
    @Column(name = "kolicine")
    Integer kolicine;
    @Column(name = "rabat")
    Double rabat;
    @Column(name = "pdv")
    Double pdv;
    @Column(name = "insert_datetime")
    Timestamp insertDatetime;
    @Column(name = "napomena")
    String napomena;

}
