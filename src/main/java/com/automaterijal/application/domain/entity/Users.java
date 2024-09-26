package com.automaterijal.application.domain.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users implements Serializable {

  @Id
  Integer ppid;
  @Column(name = "password")
  String password;
  @Column(name = "order_count")
  Integer orderCount;
  @Column(name = "accepted_orders")
  Integer acceptedOrders;
  @Column(name = "cancelled_orders")
  Integer cancelleOrders;
  @Column(name = "login_count")
  Integer loginCount;
  @Column(name = "last_login")
  Timestamp lastLogin;
  @Column(name = "user_status")
  Integer userStatus;
  @Column(name = "active")
  Integer active;
}
