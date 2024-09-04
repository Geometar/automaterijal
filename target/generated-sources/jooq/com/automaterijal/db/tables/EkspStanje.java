/*
 * This file is generated by jOOQ.
 */
package com.automaterijal.db.tables;


import com.automaterijal.db.AutomateOrders;
import com.automaterijal.db.Indexes;
import com.automaterijal.db.Keys;
import com.automaterijal.db.tables.records.EkspStanjeRecord;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class EkspStanje extends TableImpl<EkspStanjeRecord> {

    private static final long serialVersionUID = 313225696;

    /**
     * The reference instance of <code>automate_orders.eksp_stanje</code>
     */
    public static final EkspStanje EKSP_STANJE = new EkspStanje();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<EkspStanjeRecord> getRecordType() {
        return EkspStanjeRecord.class;
    }

    /**
     * The column <code>automate_orders.eksp_stanje.ekspid</code>.
     */
    public final TableField<EkspStanjeRecord, Integer> EKSPID = createField(DSL.name("ekspid"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>automate_orders.eksp_stanje.robaid</code>.
     */
    public final TableField<EkspStanjeRecord, Integer> ROBAID = createField(DSL.name("robaid"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>automate_orders.eksp_stanje.stanje</code>.
     */
    public final TableField<EkspStanjeRecord, BigDecimal> STANJE = createField(DSL.name("stanje"), org.jooq.impl.SQLDataType.DECIMAL(15, 3), this, "");

    /**
     * Create a <code>automate_orders.eksp_stanje</code> table reference
     */
    public EkspStanje() {
        this(DSL.name("eksp_stanje"), null);
    }

    /**
     * Create an aliased <code>automate_orders.eksp_stanje</code> table reference
     */
    public EkspStanje(String alias) {
        this(DSL.name(alias), EKSP_STANJE);
    }

    /**
     * Create an aliased <code>automate_orders.eksp_stanje</code> table reference
     */
    public EkspStanje(Name alias) {
        this(alias, EKSP_STANJE);
    }

    private EkspStanje(Name alias, Table<EkspStanjeRecord> aliased) {
        this(alias, aliased, null);
    }

    private EkspStanje(Name alias, Table<EkspStanjeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> EkspStanje(Table<O> child, ForeignKey<O, EkspStanjeRecord> key) {
        super(child, key, EKSP_STANJE);
    }

    @Override
    public Schema getSchema() {
        return AutomateOrders.AUTOMATE_ORDERS;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.EKSP_STANJE_PRIMARY);
    }

    @Override
    public UniqueKey<EkspStanjeRecord> getPrimaryKey() {
        return Keys.KEY_EKSP_STANJE_PRIMARY;
    }

    @Override
    public List<UniqueKey<EkspStanjeRecord>> getKeys() {
        return Arrays.<UniqueKey<EkspStanjeRecord>>asList(Keys.KEY_EKSP_STANJE_PRIMARY);
    }

    @Override
    public EkspStanje as(String alias) {
        return new EkspStanje(DSL.name(alias), this);
    }

    @Override
    public EkspStanje as(Name alias) {
        return new EkspStanje(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public EkspStanje rename(String name) {
        return new EkspStanje(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public EkspStanje rename(Name name) {
        return new EkspStanje(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, Integer, BigDecimal> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
