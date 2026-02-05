package com.automaterijal.application.integration.providers.febi.price;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "febi_pricelist_items")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FebiPriceListItem {

  @Id
  @Column(name = "normalized_article")
  String normalizedArticleNumber;

  @Column(name = "normalized_article_no_zeros")
  String normalizedArticleNumberNoLeadingZeros;

  @Column(name = "raw_article")
  String rawArticleNumber;

  @Column(name = "brand")
  String brand;

  @Column(name = "level3")
  String level3;

  @Column(name = "net_price")
  BigDecimal netPrice;

  @Column(name = "currency")
  String currency;

  @Column(name = "packaging_unit")
  Integer packagingUnit;

  @Column(name = "updated_at")
  Timestamp updatedAt;
}
