package com.automaterijal.application.domain.entity.tecdoc;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tecdoc_brands")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TecDocBrands {

    @Id
    String proid;
    Long brandId;
    @Column(name = "brand_logo_id")
    String brandLogoID;
    byte[] brand;

}
