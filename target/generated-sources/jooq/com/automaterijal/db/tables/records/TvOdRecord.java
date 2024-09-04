/*
 * This file is generated by jOOQ.
 */
package com.automaterijal.db.tables.records;


import com.automaterijal.db.tables.TvOd;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class TvOdRecord extends UpdatableRecordImpl<TvOdRecord> implements Record3<Integer, Integer, String> {

    private static final long serialVersionUID = 1058673748;

    /**
     * Setter for <code>automate_orders.tv_od.odid</code>.
     */
    public void setOdid(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>automate_orders.tv_od.odid</code>.
     */
    public Integer getOdid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>automate_orders.tv_od.tipid</code>.
     */
    public void setTipid(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>automate_orders.tv_od.tipid</code>.
     */
    public Integer getTipid() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>automate_orders.tv_od.naziv</code>.
     */
    public void setNaziv(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>automate_orders.tv_od.naziv</code>.
     */
    public String getNaziv() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, Integer, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, Integer, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return TvOd.TV_OD.ODID;
    }

    @Override
    public Field<Integer> field2() {
        return TvOd.TV_OD.TIPID;
    }

    @Override
    public Field<String> field3() {
        return TvOd.TV_OD.NAZIV;
    }

    @Override
    public Integer component1() {
        return getOdid();
    }

    @Override
    public Integer component2() {
        return getTipid();
    }

    @Override
    public String component3() {
        return getNaziv();
    }

    @Override
    public Integer value1() {
        return getOdid();
    }

    @Override
    public Integer value2() {
        return getTipid();
    }

    @Override
    public String value3() {
        return getNaziv();
    }

    @Override
    public TvOdRecord value1(Integer value) {
        setOdid(value);
        return this;
    }

    @Override
    public TvOdRecord value2(Integer value) {
        setTipid(value);
        return this;
    }

    @Override
    public TvOdRecord value3(String value) {
        setNaziv(value);
        return this;
    }

    @Override
    public TvOdRecord values(Integer value1, Integer value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TvOdRecord
     */
    public TvOdRecord() {
        super(TvOd.TV_OD);
    }

    /**
     * Create a detached, initialised TvOdRecord
     */
    public TvOdRecord(Integer odid, Integer tipid, String naziv) {
        super(TvOd.TV_OD);

        set(0, odid);
        set(1, tipid);
        set(2, naziv);
    }
}
