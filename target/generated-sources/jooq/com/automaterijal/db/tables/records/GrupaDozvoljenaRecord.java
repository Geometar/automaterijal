/*
 * This file is generated by jOOQ.
 */
package com.automaterijal.db.tables.records;


import com.automaterijal.db.tables.GrupaDozvoljena;

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
public class GrupaDozvoljenaRecord extends UpdatableRecordImpl<GrupaDozvoljenaRecord> implements Record2<String, String> {

    private static final long serialVersionUID = -615577693;

    /**
     * Setter for <code>automate_orders.grupa_dozvoljena.grupa_id</code>.
     */
    public void setGrupaId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>automate_orders.grupa_dozvoljena.grupa_id</code>.
     */
    public String getGrupaId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>automate_orders.grupa_dozvoljena.naziv</code>.
     */
    public void setNaziv(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>automate_orders.grupa_dozvoljena.naziv</code>.
     */
    public String getNaziv() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return GrupaDozvoljena.GRUPA_DOZVOLJENA.GRUPA_ID;
    }

    @Override
    public Field<String> field2() {
        return GrupaDozvoljena.GRUPA_DOZVOLJENA.NAZIV;
    }

    @Override
    public String component1() {
        return getGrupaId();
    }

    @Override
    public String component2() {
        return getNaziv();
    }

    @Override
    public String value1() {
        return getGrupaId();
    }

    @Override
    public String value2() {
        return getNaziv();
    }

    @Override
    public GrupaDozvoljenaRecord value1(String value) {
        setGrupaId(value);
        return this;
    }

    @Override
    public GrupaDozvoljenaRecord value2(String value) {
        setNaziv(value);
        return this;
    }

    @Override
    public GrupaDozvoljenaRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached GrupaDozvoljenaRecord
     */
    public GrupaDozvoljenaRecord() {
        super(GrupaDozvoljena.GRUPA_DOZVOLJENA);
    }

    /**
     * Create a detached, initialised GrupaDozvoljenaRecord
     */
    public GrupaDozvoljenaRecord(String grupaId, String naziv) {
        super(GrupaDozvoljena.GRUPA_DOZVOLJENA);

        set(0, grupaId);
        set(1, naziv);
    }
}
