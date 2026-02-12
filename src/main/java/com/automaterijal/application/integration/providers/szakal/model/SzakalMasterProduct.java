package com.automaterijal.application.integration.providers.szakal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "szakal_master_products")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SzakalMasterProduct {

  @Id
  @Column(name = "glid")
  String glid;

  @Column(name = "tecdoc_dlnr")
  Long tecdocDlnr;

  @Column(name = "tecdoc_artnr_norm")
  String tecdocArtnrNorm;

  @Column(name = "article_code_norm")
  String articleCodeNorm;

  @Column(name = "size_norm")
  String sizeNorm;

  @Column(name = "unit")
  String unit;

  @Column(name = "brand_name")
  String brandName;

  @Column(name = "name_rs")
  String nameRs;

  @Column(name = "name_en")
  String nameEn;

  @Column(name = "weight_grams")
  Integer weightGrams;

  @Column(name = "customtariff")
  String customtariff;

  @Column(name = "deposit_glid")
  String depositGlid;

  @Column(name = "barcode")
  String barcode;

  @Column(name = "updated_at")
  Timestamp updatedAt;
}
