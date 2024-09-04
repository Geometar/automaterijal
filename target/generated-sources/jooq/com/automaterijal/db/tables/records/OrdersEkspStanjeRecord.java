/*
 * This file is generated by jOOQ.
 */
package com.automaterijal.db.tables.records;


import com.automaterijal.db.tables.OrdersEkspStanje;

import java.math.BigDecimal;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OrdersEkspStanjeRecord extends UpdatableRecordImpl<OrdersEkspStanjeRecord> implements Record4<Integer, Integer, Integer, BigDecimal> {

    private static final long serialVersionUID = 1915231587;

    /**
     * Setter for <code>automate_orders.orders_eksp_stanje.orderid</code>.
     */
    public void setOrderid(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>automate_orders.orders_eksp_stanje.orderid</code>.
     */
    public Integer getOrderid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>automate_orders.orders_eksp_stanje.ekspid</code>.
     */
    public void setEkspid(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>automate_orders.orders_eksp_stanje.ekspid</code>.
     */
    public Integer getEkspid() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>automate_orders.orders_eksp_stanje.robaid</code>.
     */
    public void setRobaid(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>automate_orders.orders_eksp_stanje.robaid</code>.
     */
    public Integer getRobaid() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>automate_orders.orders_eksp_stanje.kolicina</code>.
     */
    public void setKolicina(BigDecimal value) {
        set(3, value);
    }

    /**
     * Getter for <code>automate_orders.orders_eksp_stanje.kolicina</code>.
     */
    public BigDecimal getKolicina() {
        return (BigDecimal) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<Integer, Integer> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, Integer, Integer, BigDecimal> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, Integer, Integer, BigDecimal> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return OrdersEkspStanje.ORDERS_EKSP_STANJE.ORDERID;
    }

    @Override
    public Field<Integer> field2() {
        return OrdersEkspStanje.ORDERS_EKSP_STANJE.EKSPID;
    }

    @Override
    public Field<Integer> field3() {
        return OrdersEkspStanje.ORDERS_EKSP_STANJE.ROBAID;
    }

    @Override
    public Field<BigDecimal> field4() {
        return OrdersEkspStanje.ORDERS_EKSP_STANJE.KOLICINA;
    }

    @Override
    public Integer component1() {
        return getOrderid();
    }

    @Override
    public Integer component2() {
        return getEkspid();
    }

    @Override
    public Integer component3() {
        return getRobaid();
    }

    @Override
    public BigDecimal component4() {
        return getKolicina();
    }

    @Override
    public Integer value1() {
        return getOrderid();
    }

    @Override
    public Integer value2() {
        return getEkspid();
    }

    @Override
    public Integer value3() {
        return getRobaid();
    }

    @Override
    public BigDecimal value4() {
        return getKolicina();
    }

    @Override
    public OrdersEkspStanjeRecord value1(Integer value) {
        setOrderid(value);
        return this;
    }

    @Override
    public OrdersEkspStanjeRecord value2(Integer value) {
        setEkspid(value);
        return this;
    }

    @Override
    public OrdersEkspStanjeRecord value3(Integer value) {
        setRobaid(value);
        return this;
    }

    @Override
    public OrdersEkspStanjeRecord value4(BigDecimal value) {
        setKolicina(value);
        return this;
    }

    @Override
    public OrdersEkspStanjeRecord values(Integer value1, Integer value2, Integer value3, BigDecimal value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OrdersEkspStanjeRecord
     */
    public OrdersEkspStanjeRecord() {
        super(OrdersEkspStanje.ORDERS_EKSP_STANJE);
    }

    /**
     * Create a detached, initialised OrdersEkspStanjeRecord
     */
    public OrdersEkspStanjeRecord(Integer orderid, Integer ekspid, Integer robaid, BigDecimal kolicina) {
        super(OrdersEkspStanje.ORDERS_EKSP_STANJE);

        set(0, orderid);
        set(1, ekspid);
        set(2, robaid);
        set(3, kolicina);
    }
}
