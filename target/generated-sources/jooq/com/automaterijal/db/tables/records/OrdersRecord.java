/*
 * This file is generated by jOOQ.
 */
package com.automaterijal.db.tables.records;


import com.automaterijal.db.tables.Orders;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record15;
import org.jooq.Row15;
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
public class OrdersRecord extends UpdatableRecordImpl<OrdersRecord> implements Record15<Integer, Integer, Integer, Integer, BigDecimal, BigDecimal, BigDecimal, Short, Integer, Byte, BigDecimal, BigDecimal, Timestamp, String, Integer> {

    private static final long serialVersionUID = 1076465489;

    /**
     * Setter for <code>automate_orders.orders.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>automate_orders.orders.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>automate_orders.orders.ppid</code>.
     */
    public void setPpid(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>automate_orders.orders.ppid</code>.
     */
    public Integer getPpid() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>automate_orders.orders.robaid</code>.
     */
    public void setRobaid(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>automate_orders.orders.robaid</code>.
     */
    public Integer getRobaid() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>automate_orders.orders.magacinid</code>.
     */
    public void setMagacinid(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>automate_orders.orders.magacinid</code>.
     */
    public Integer getMagacinid() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>automate_orders.orders.kolicina</code>.
     */
    public void setKolicina(BigDecimal value) {
        set(4, value);
    }

    /**
     * Getter for <code>automate_orders.orders.kolicina</code>.
     */
    public BigDecimal getKolicina() {
        return (BigDecimal) get(4);
    }

    /**
     * Setter for <code>automate_orders.orders.potvrdjena_kolicina</code>.
     */
    public void setPotvrdjenaKolicina(BigDecimal value) {
        set(5, value);
    }

    /**
     * Getter for <code>automate_orders.orders.potvrdjena_kolicina</code>.
     */
    public BigDecimal getPotvrdjenaKolicina() {
        return (BigDecimal) get(5);
    }

    /**
     * Setter for <code>automate_orders.orders.cena</code>.
     */
    public void setCena(BigDecimal value) {
        set(6, value);
    }

    /**
     * Getter for <code>automate_orders.orders.cena</code>.
     */
    public BigDecimal getCena() {
        return (BigDecimal) get(6);
    }

    /**
     * Setter for <code>automate_orders.orders.status</code>.
     */
    public void setStatus(Short value) {
        set(7, value);
    }

    /**
     * Getter for <code>automate_orders.orders.status</code>.
     */
    public Short getStatus() {
        return (Short) get(7);
    }

    /**
     * Setter for <code>automate_orders.orders.order_id</code>.
     */
    public void setOrderId(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>automate_orders.orders.order_id</code>.
     */
    public Integer getOrderId() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>automate_orders.orders.kolicine</code>.
     */
    public void setKolicine(Byte value) {
        set(9, value);
    }

    /**
     * Getter for <code>automate_orders.orders.kolicine</code>.
     */
    public Byte getKolicine() {
        return (Byte) get(9);
    }

    /**
     * Setter for <code>automate_orders.orders.rabat</code>.
     */
    public void setRabat(BigDecimal value) {
        set(10, value);
    }

    /**
     * Getter for <code>automate_orders.orders.rabat</code>.
     */
    public BigDecimal getRabat() {
        return (BigDecimal) get(10);
    }

    /**
     * Setter for <code>automate_orders.orders.pdv</code>.
     */
    public void setPdv(BigDecimal value) {
        set(11, value);
    }

    /**
     * Getter for <code>automate_orders.orders.pdv</code>.
     */
    public BigDecimal getPdv() {
        return (BigDecimal) get(11);
    }

    /**
     * Setter for <code>automate_orders.orders.insert_datetime</code>.
     */
    public void setInsertDatetime(Timestamp value) {
        set(12, value);
    }

    /**
     * Getter for <code>automate_orders.orders.insert_datetime</code>.
     */
    public Timestamp getInsertDatetime() {
        return (Timestamp) get(12);
    }

    /**
     * Setter for <code>automate_orders.orders.napomena</code>.
     */
    public void setNapomena(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>automate_orders.orders.napomena</code>.
     */
    public String getNapomena() {
        return (String) get(13);
    }

    /**
     * Setter for <code>automate_orders.orders.from_ppid</code>.
     */
    public void setFromPpid(Integer value) {
        set(14, value);
    }

    /**
     * Getter for <code>automate_orders.orders.from_ppid</code>.
     */
    public Integer getFromPpid() {
        return (Integer) get(14);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record15 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row15<Integer, Integer, Integer, Integer, BigDecimal, BigDecimal, BigDecimal, Short, Integer, Byte, BigDecimal, BigDecimal, Timestamp, String, Integer> fieldsRow() {
        return (Row15) super.fieldsRow();
    }

    @Override
    public Row15<Integer, Integer, Integer, Integer, BigDecimal, BigDecimal, BigDecimal, Short, Integer, Byte, BigDecimal, BigDecimal, Timestamp, String, Integer> valuesRow() {
        return (Row15) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Orders.ORDERS.ID;
    }

    @Override
    public Field<Integer> field2() {
        return Orders.ORDERS.PPID;
    }

    @Override
    public Field<Integer> field3() {
        return Orders.ORDERS.ROBAID;
    }

    @Override
    public Field<Integer> field4() {
        return Orders.ORDERS.MAGACINID;
    }

    @Override
    public Field<BigDecimal> field5() {
        return Orders.ORDERS.KOLICINA;
    }

    @Override
    public Field<BigDecimal> field6() {
        return Orders.ORDERS.POTVRDJENA_KOLICINA;
    }

    @Override
    public Field<BigDecimal> field7() {
        return Orders.ORDERS.CENA;
    }

    @Override
    public Field<Short> field8() {
        return Orders.ORDERS.STATUS;
    }

    @Override
    public Field<Integer> field9() {
        return Orders.ORDERS.ORDER_ID;
    }

    @Override
    public Field<Byte> field10() {
        return Orders.ORDERS.KOLICINE;
    }

    @Override
    public Field<BigDecimal> field11() {
        return Orders.ORDERS.RABAT;
    }

    @Override
    public Field<BigDecimal> field12() {
        return Orders.ORDERS.PDV;
    }

    @Override
    public Field<Timestamp> field13() {
        return Orders.ORDERS.INSERT_DATETIME;
    }

    @Override
    public Field<String> field14() {
        return Orders.ORDERS.NAPOMENA;
    }

    @Override
    public Field<Integer> field15() {
        return Orders.ORDERS.FROM_PPID;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getPpid();
    }

    @Override
    public Integer component3() {
        return getRobaid();
    }

    @Override
    public Integer component4() {
        return getMagacinid();
    }

    @Override
    public BigDecimal component5() {
        return getKolicina();
    }

    @Override
    public BigDecimal component6() {
        return getPotvrdjenaKolicina();
    }

    @Override
    public BigDecimal component7() {
        return getCena();
    }

    @Override
    public Short component8() {
        return getStatus();
    }

    @Override
    public Integer component9() {
        return getOrderId();
    }

    @Override
    public Byte component10() {
        return getKolicine();
    }

    @Override
    public BigDecimal component11() {
        return getRabat();
    }

    @Override
    public BigDecimal component12() {
        return getPdv();
    }

    @Override
    public Timestamp component13() {
        return getInsertDatetime();
    }

    @Override
    public String component14() {
        return getNapomena();
    }

    @Override
    public Integer component15() {
        return getFromPpid();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getPpid();
    }

    @Override
    public Integer value3() {
        return getRobaid();
    }

    @Override
    public Integer value4() {
        return getMagacinid();
    }

    @Override
    public BigDecimal value5() {
        return getKolicina();
    }

    @Override
    public BigDecimal value6() {
        return getPotvrdjenaKolicina();
    }

    @Override
    public BigDecimal value7() {
        return getCena();
    }

    @Override
    public Short value8() {
        return getStatus();
    }

    @Override
    public Integer value9() {
        return getOrderId();
    }

    @Override
    public Byte value10() {
        return getKolicine();
    }

    @Override
    public BigDecimal value11() {
        return getRabat();
    }

    @Override
    public BigDecimal value12() {
        return getPdv();
    }

    @Override
    public Timestamp value13() {
        return getInsertDatetime();
    }

    @Override
    public String value14() {
        return getNapomena();
    }

    @Override
    public Integer value15() {
        return getFromPpid();
    }

    @Override
    public OrdersRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public OrdersRecord value2(Integer value) {
        setPpid(value);
        return this;
    }

    @Override
    public OrdersRecord value3(Integer value) {
        setRobaid(value);
        return this;
    }

    @Override
    public OrdersRecord value4(Integer value) {
        setMagacinid(value);
        return this;
    }

    @Override
    public OrdersRecord value5(BigDecimal value) {
        setKolicina(value);
        return this;
    }

    @Override
    public OrdersRecord value6(BigDecimal value) {
        setPotvrdjenaKolicina(value);
        return this;
    }

    @Override
    public OrdersRecord value7(BigDecimal value) {
        setCena(value);
        return this;
    }

    @Override
    public OrdersRecord value8(Short value) {
        setStatus(value);
        return this;
    }

    @Override
    public OrdersRecord value9(Integer value) {
        setOrderId(value);
        return this;
    }

    @Override
    public OrdersRecord value10(Byte value) {
        setKolicine(value);
        return this;
    }

    @Override
    public OrdersRecord value11(BigDecimal value) {
        setRabat(value);
        return this;
    }

    @Override
    public OrdersRecord value12(BigDecimal value) {
        setPdv(value);
        return this;
    }

    @Override
    public OrdersRecord value13(Timestamp value) {
        setInsertDatetime(value);
        return this;
    }

    @Override
    public OrdersRecord value14(String value) {
        setNapomena(value);
        return this;
    }

    @Override
    public OrdersRecord value15(Integer value) {
        setFromPpid(value);
        return this;
    }

    @Override
    public OrdersRecord values(Integer value1, Integer value2, Integer value3, Integer value4, BigDecimal value5, BigDecimal value6, BigDecimal value7, Short value8, Integer value9, Byte value10, BigDecimal value11, BigDecimal value12, Timestamp value13, String value14, Integer value15) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OrdersRecord
     */
    public OrdersRecord() {
        super(Orders.ORDERS);
    }

    /**
     * Create a detached, initialised OrdersRecord
     */
    public OrdersRecord(Integer id, Integer ppid, Integer robaid, Integer magacinid, BigDecimal kolicina, BigDecimal potvrdjenaKolicina, BigDecimal cena, Short status, Integer orderId, Byte kolicine, BigDecimal rabat, BigDecimal pdv, Timestamp insertDatetime, String napomena, Integer fromPpid) {
        super(Orders.ORDERS);

        set(0, id);
        set(1, ppid);
        set(2, robaid);
        set(3, magacinid);
        set(4, kolicina);
        set(5, potvrdjenaKolicina);
        set(6, cena);
        set(7, status);
        set(8, orderId);
        set(9, kolicine);
        set(10, rabat);
        set(11, pdv);
        set(12, insertDatetime);
        set(13, napomena);
        set(14, fromPpid);
    }
}
