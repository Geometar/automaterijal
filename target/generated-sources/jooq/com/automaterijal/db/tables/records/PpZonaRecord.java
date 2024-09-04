/*
 * This file is generated by jOOQ.
 */
package com.automaterijal.db.tables.records;


import com.automaterijal.db.tables.PpZona;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
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
public class PpZonaRecord extends UpdatableRecordImpl<PpZonaRecord> implements Record2<Short, String> {

    private static final long serialVersionUID = 223169477;

    /**
     * Setter for <code>automate_orders.pp_zona.zid</code>.
     */
    public void setZid(Short value) {
        set(0, value);
    }

    /**
     * Getter for <code>automate_orders.pp_zona.zid</code>.
     */
    public Short getZid() {
        return (Short) get(0);
    }

    /**
     * Setter for <code>automate_orders.pp_zona.naziv</code>.
     */
    public void setNaziv(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>automate_orders.pp_zona.naziv</code>.
     */
    public String getNaziv() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Short> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Short, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Short, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Short> field1() {
        return PpZona.PP_ZONA.ZID;
    }

    @Override
    public Field<String> field2() {
        return PpZona.PP_ZONA.NAZIV;
    }

    @Override
    public Short component1() {
        return getZid();
    }

    @Override
    public String component2() {
        return getNaziv();
    }

    @Override
    public Short value1() {
        return getZid();
    }

    @Override
    public String value2() {
        return getNaziv();
    }

    @Override
    public PpZonaRecord value1(Short value) {
        setZid(value);
        return this;
    }

    @Override
    public PpZonaRecord value2(String value) {
        setNaziv(value);
        return this;
    }

    @Override
    public PpZonaRecord values(Short value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PpZonaRecord
     */
    public PpZonaRecord() {
        super(PpZona.PP_ZONA);
    }

    /**
     * Create a detached, initialised PpZonaRecord
     */
    public PpZonaRecord(Short zid, String naziv) {
        super(PpZona.PP_ZONA);

        set(0, zid);
        set(1, naziv);
    }
}
