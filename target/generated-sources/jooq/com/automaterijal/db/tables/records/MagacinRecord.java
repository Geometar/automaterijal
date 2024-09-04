/*
 * This file is generated by jOOQ.
 */
package com.automaterijal.db.tables.records;


import com.automaterijal.db.tables.Magacin;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
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
public class MagacinRecord extends UpdatableRecordImpl<MagacinRecord> implements Record4<Integer, String, Integer, Short> {

    private static final long serialVersionUID = 1684732425;

    /**
     * Setter for <code>automate_orders.magacin.magacinid</code>.
     */
    public void setMagacinid(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>automate_orders.magacin.magacinid</code>.
     */
    public Integer getMagacinid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>automate_orders.magacin.naziv</code>.
     */
    public void setNaziv(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>automate_orders.magacin.naziv</code>.
     */
    public String getNaziv() {
        return (String) get(1);
    }

    /**
     * Setter for <code>automate_orders.magacin.ekspid</code>.
     */
    public void setEkspid(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>automate_orders.magacin.ekspid</code>.
     */
    public Integer getEkspid() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>automate_orders.magacin.vrsta</code>.
     */
    public void setVrsta(Short value) {
        set(3, value);
    }

    /**
     * Getter for <code>automate_orders.magacin.vrsta</code>.
     */
    public Short getVrsta() {
        return (Short) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, Integer, Short> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, Integer, Short> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Magacin.MAGACIN.MAGACINID;
    }

    @Override
    public Field<String> field2() {
        return Magacin.MAGACIN.NAZIV;
    }

    @Override
    public Field<Integer> field3() {
        return Magacin.MAGACIN.EKSPID;
    }

    @Override
    public Field<Short> field4() {
        return Magacin.MAGACIN.VRSTA;
    }

    @Override
    public Integer component1() {
        return getMagacinid();
    }

    @Override
    public String component2() {
        return getNaziv();
    }

    @Override
    public Integer component3() {
        return getEkspid();
    }

    @Override
    public Short component4() {
        return getVrsta();
    }

    @Override
    public Integer value1() {
        return getMagacinid();
    }

    @Override
    public String value2() {
        return getNaziv();
    }

    @Override
    public Integer value3() {
        return getEkspid();
    }

    @Override
    public Short value4() {
        return getVrsta();
    }

    @Override
    public MagacinRecord value1(Integer value) {
        setMagacinid(value);
        return this;
    }

    @Override
    public MagacinRecord value2(String value) {
        setNaziv(value);
        return this;
    }

    @Override
    public MagacinRecord value3(Integer value) {
        setEkspid(value);
        return this;
    }

    @Override
    public MagacinRecord value4(Short value) {
        setVrsta(value);
        return this;
    }

    @Override
    public MagacinRecord values(Integer value1, String value2, Integer value3, Short value4) {
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
     * Create a detached MagacinRecord
     */
    public MagacinRecord() {
        super(Magacin.MAGACIN);
    }

    /**
     * Create a detached, initialised MagacinRecord
     */
    public MagacinRecord(Integer magacinid, String naziv, Integer ekspid, Short vrsta) {
        super(Magacin.MAGACIN);

        set(0, magacinid);
        set(1, naziv);
        set(2, ekspid);
        set(3, vrsta);
    }
}
