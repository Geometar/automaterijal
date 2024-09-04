/*
 * This file is generated by jOOQ.
 */
package com.automaterijal.db.tables;


import com.automaterijal.db.AutomateOrders;
import com.automaterijal.db.Indexes;
import com.automaterijal.db.Keys;
import com.automaterijal.db.tables.records.EkspozituraRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
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
public class Ekspozitura extends TableImpl<EkspozituraRecord> {

    private static final long serialVersionUID = 1930169169;

    /**
     * The reference instance of <code>automate_orders.ekspozitura</code>
     */
    public static final Ekspozitura EKSPOZITURA = new Ekspozitura();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<EkspozituraRecord> getRecordType() {
        return EkspozituraRecord.class;
    }

    /**
     * The column <code>automate_orders.ekspozitura.ekspid</code>.
     */
    public final TableField<EkspozituraRecord, Integer> EKSPID = createField(DSL.name("ekspid"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>automate_orders.ekspozitura.naziv</code>.
     */
    public final TableField<EkspozituraRecord, String> NAZIV = createField(DSL.name("naziv"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>automate_orders.ekspozitura.email</code>.
     */
    public final TableField<EkspozituraRecord, String> EMAIL = createField(DSL.name("email"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>automate_orders.ekspozitura.ppid_od</code>.
     */
    public final TableField<EkspozituraRecord, Integer> PPID_OD = createField(DSL.name("ppid_od"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>automate_orders.ekspozitura.ppid_do</code>.
     */
    public final TableField<EkspozituraRecord, Integer> PPID_DO = createField(DSL.name("ppid_do"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>automate_orders.ekspozitura.sn</code>.
     */
    public final TableField<EkspozituraRecord, String> SN = createField(DSL.name("sn"), org.jooq.impl.SQLDataType.VARCHAR(3), this, "");

    /**
     * Create a <code>automate_orders.ekspozitura</code> table reference
     */
    public Ekspozitura() {
        this(DSL.name("ekspozitura"), null);
    }

    /**
     * Create an aliased <code>automate_orders.ekspozitura</code> table reference
     */
    public Ekspozitura(String alias) {
        this(DSL.name(alias), EKSPOZITURA);
    }

    /**
     * Create an aliased <code>automate_orders.ekspozitura</code> table reference
     */
    public Ekspozitura(Name alias) {
        this(alias, EKSPOZITURA);
    }

    private Ekspozitura(Name alias, Table<EkspozituraRecord> aliased) {
        this(alias, aliased, null);
    }

    private Ekspozitura(Name alias, Table<EkspozituraRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Ekspozitura(Table<O> child, ForeignKey<O, EkspozituraRecord> key) {
        super(child, key, EKSPOZITURA);
    }

    @Override
    public Schema getSchema() {
        return AutomateOrders.AUTOMATE_ORDERS;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.EKSPOZITURA_IDXNAZIV, Indexes.EKSPOZITURA_IDXPPID, Indexes.EKSPOZITURA_PRIMARY);
    }

    @Override
    public UniqueKey<EkspozituraRecord> getPrimaryKey() {
        return Keys.KEY_EKSPOZITURA_PRIMARY;
    }

    @Override
    public List<UniqueKey<EkspozituraRecord>> getKeys() {
        return Arrays.<UniqueKey<EkspozituraRecord>>asList(Keys.KEY_EKSPOZITURA_PRIMARY);
    }

    @Override
    public Ekspozitura as(String alias) {
        return new Ekspozitura(DSL.name(alias), this);
    }

    @Override
    public Ekspozitura as(Name alias) {
        return new Ekspozitura(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Ekspozitura rename(String name) {
        return new Ekspozitura(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Ekspozitura rename(Name name) {
        return new Ekspozitura(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, String, Integer, Integer, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
