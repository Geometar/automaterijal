package com.automaterijal.application.domain.entity.roba;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "td_aplikacija")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RobaAplikacija {

    @Id
    @Column(name = "aplikacijaid")
    Integer aplikacijaId;

    @Column(name = "robaid")
    Integer robaId;

    @Column(name = "fabrbroj")
    String fabrBroj;

    @Column(name = "opisvozila")
    String opisVozila;

    @Column(name = "tipvozila")
    String tipVozila;

    @Column(name = "proizod")
    String proizOd;

    @Column(name = "proizdo")
    String proizDo;

    @Column(name = "kw")
    String kw;

    @Column(name = "hp")
    String hp;

    @Column(name = "ccm")
    String ccm;

    @Column(name = "karoserija")
    String karoserija;

    @Column(name = "vesanje")
    String vesanje;

    @Column(name = "maxtezina")
    String maxTezina;

    @Column(name = "karoserijaid")
    Integer karoserijaId;

    @Column(name = "opismotoraid")
    Integer opisMotoraId;

    @Column(name = "modelid")
    Integer modelId;

    @Column(name = "tipvozilaid")
    Integer tipVozilaId;

    @Column(name = "flag_id")
    Integer flagId;

    @Column(name = "mod_pc")
    Integer modPc;

    @Column(name = "mod_cv")
    Integer modCv;

    @Column(name = "proizvodjacid")
    Integer proizvodjacId;

    @Column(name = "proizvodjacnaziv")
    String proizvodjacNaziv;

    @Column(name = "modelnaziv")
    String modelNaziv;
}
