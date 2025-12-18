package com.automaterijal.application.domain.entity.weborder;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "web_order_headers")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WebOrderHeader {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  Integer id;

  @Column(name = "ppid")
  Integer ppid;

  @Column(name = "order_id")
  Integer orderId;

  @Column(name = "last_update")
  Timestamp lastUpdate;

  @Column(name = "date_sent")
  Timestamp dateSent;

  @Column(name = "status")
  Integer status;

  @Column(name = "nuid")
  Integer nuid;

  @Column(name = "niid")
  Integer niid;

  @Column(name = "prid")
  Integer prid;

  @Column(name = "back_order")
  Integer backOrder;

  @Column(name = "realizovati")
  Integer realizovati;

  @Column(name = "created_by_ppid")
  Integer createdByPpid;

  @Column(name = "mes_isporuke_ppid")
  Integer mestoIsporuke;

  @Column(name = "napomena")
  String napomena;

  @Column(name = "iznos_naruceno")
  Double iznosNaruceno;

  @Column(name = "iznos_potvrdjeno")
  Double iznosPotvrdjeno;

  @Column(name = "ext_order_id")
  String extOrderId;

  @Column(name = "erp_exported")
  Integer erpExported;

  @OneToMany(
      mappedBy = "header",
      fetch = FetchType.EAGER,
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  List<WebOrderItem> items;
}
