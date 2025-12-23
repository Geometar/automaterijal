package com.automaterijal.application.domain.entity.weborder;

import com.automaterijal.application.domain.constants.OrderItemSource;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "web_order_items")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WebOrderItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "web_order_id", nullable = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  WebOrderHeader header;

  @Column(name = "ppid")
  Integer ppid;

  @Column(name = "robaid")
  Long robaId;

  @Column(name = "tecdoc_article_id")
  Long tecDocArticleId;

  @Column(name = "brand")
  String brand;

  @Column(name = "brand_name")
  String brandName;

  @Column(name = "catalog_number")
  String catalogNumber;

  @Column(name = "article_name")
  String articleName;

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

  @Enumerated(EnumType.STRING)
  @Column(name = "item_source")
  OrderItemSource itemSource;

  @Column(name = "provider_code")
  String providerCode;

  // Provider snapshot (optional)
  @Column(name = "provider_key")
  String providerKey;

  @Column(name = "provider_article_number")
  String providerArticleNumber;

  @Column(name = "provider_available")
  Boolean providerAvailable;

  @Column(name = "provider_total_quantity")
  Integer providerTotalQuantity;

  @Column(name = "provider_warehouse")
  String providerWarehouse;

  @Column(name = "provider_warehouse_name")
  String providerWarehouseName;

  @Column(name = "provider_warehouse_quantity")
  Integer providerWarehouseQuantity;

  @Column(name = "provider_purchase_price")
  BigDecimal providerPurchasePrice;

  @Column(name = "provider_price")
  BigDecimal providerPrice;

  @Column(name = "provider_currency")
  String providerCurrency;

  @Column(name = "provider_lead_time_business_days")
  Integer providerLeadTimeBusinessDays;

  @Column(name = "provider_delivery_to_customer_days_min")
  Integer providerDeliveryToCustomerDaysMin;

  @Column(name = "provider_delivery_to_customer_days_max")
  Integer providerDeliveryToCustomerDaysMax;

  @Column(name = "provider_next_dispatch_cutoff")
  String providerNextDispatchCutoff;

  @Column(name = "provider_backorder")
  Boolean providerBackorder;

  @Column(name = "provider_message")
  String providerMessage;

  // Image snapshot (optional; especially useful for external-only items)
  @Column(name = "image_url")
  String imageUrl;

  @Column(name = "image_is_url")
  Boolean imageIsUrl;

  @Column(name = "image_roba_slika")
  String imageRobaSlika;
}
