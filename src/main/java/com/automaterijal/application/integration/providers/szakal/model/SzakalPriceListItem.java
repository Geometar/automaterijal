package com.automaterijal.application.integration.providers.szakal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "szakal_pricelist_items")
@IdClass(SzakalPriceListItemId.class)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SzakalPriceListItem {

  @Id
  @Column(name = "list_no")
  Integer listNo;

  @Id
  @Column(name = "glid")
  String glid;

  @Column(name = "stock")
  Integer stock;

  @Column(name = "unit_price")
  BigDecimal unitPrice;

  @Column(name = "not_returnable")
  Boolean notReturnable;

  @Column(name = "quantum")
  Integer quantum;

  @Column(name = "order_deadline")
  String orderDeadline;

  @Column(name = "token")
  String token;

  @Column(name = "updated_at")
  Timestamp updatedAt;
}
