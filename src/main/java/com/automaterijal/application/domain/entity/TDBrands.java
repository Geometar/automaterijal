package com.automaterijal.application.domain.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "brands")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TDBrands {

    @Id
    Integer braId;
    String braMfcCode;
    String braBrand;
    Integer braMfNr;
    String proid;
    String addSufix;
    String addPrefix;
    String removeChar;
    String removePrefix;
    String removeSufix;

}
