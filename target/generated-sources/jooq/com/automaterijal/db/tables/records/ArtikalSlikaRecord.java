/*
 * This file is generated by jOOQ.
 */
package com.automaterijal.db.tables.records;


import com.automaterijal.db.tables.ArtikalSlika;

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
public class ArtikalSlikaRecord extends UpdatableRecordImpl<ArtikalSlikaRecord> implements Record4<Integer, Integer, String, String> {

    private static final long serialVersionUID = -829563451;

    /**
     * Setter for <code>automate_orders.artikal_slika.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>automate_orders.artikal_slika.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>automate_orders.artikal_slika.robaid</code>.
     */
    public void setRobaid(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>automate_orders.artikal_slika.robaid</code>.
     */
    public Integer getRobaid() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>automate_orders.artikal_slika.slika</code>.
     */
    public void setSlika(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>automate_orders.artikal_slika.slika</code>.
     */
    public String getSlika() {
        return (String) get(2);
    }

    /**
     * Setter for <code>automate_orders.artikal_slika.ord</code>.
     */
    public void setOrd(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>automate_orders.artikal_slika.ord</code>.
     */
    public String getOrd() {
        return (String) get(3);
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
    public Row4<Integer, Integer, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, Integer, String, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return ArtikalSlika.ARTIKAL_SLIKA.ID;
    }

    @Override
    public Field<Integer> field2() {
        return ArtikalSlika.ARTIKAL_SLIKA.ROBAID;
    }

    @Override
    public Field<String> field3() {
        return ArtikalSlika.ARTIKAL_SLIKA.SLIKA;
    }

    @Override
    public Field<String> field4() {
        return ArtikalSlika.ARTIKAL_SLIKA.ORD;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getRobaid();
    }

    @Override
    public String component3() {
        return getSlika();
    }

    @Override
    public String component4() {
        return getOrd();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getRobaid();
    }

    @Override
    public String value3() {
        return getSlika();
    }

    @Override
    public String value4() {
        return getOrd();
    }

    @Override
    public ArtikalSlikaRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public ArtikalSlikaRecord value2(Integer value) {
        setRobaid(value);
        return this;
    }

    @Override
    public ArtikalSlikaRecord value3(String value) {
        setSlika(value);
        return this;
    }

    @Override
    public ArtikalSlikaRecord value4(String value) {
        setOrd(value);
        return this;
    }

    @Override
    public ArtikalSlikaRecord values(Integer value1, Integer value2, String value3, String value4) {
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
     * Create a detached ArtikalSlikaRecord
     */
    public ArtikalSlikaRecord() {
        super(ArtikalSlika.ARTIKAL_SLIKA);
    }

    /**
     * Create a detached, initialised ArtikalSlikaRecord
     */
    public ArtikalSlikaRecord(Integer id, Integer robaid, String slika, String ord) {
        super(ArtikalSlika.ARTIKAL_SLIKA);

        set(0, id);
        set(1, robaid);
        set(2, slika);
        set(3, ord);
    }
}
