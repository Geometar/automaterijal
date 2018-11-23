package com.automaterijal.application.domain.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users {

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
}
