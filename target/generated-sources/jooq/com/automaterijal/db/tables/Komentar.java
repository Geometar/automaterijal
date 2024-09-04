/*
 * This file is generated by jOOQ.
 */
package com.automaterijal.db.tables;


import com.automaterijal.db.AutomateOrders;
import com.automaterijal.db.Indexes;
import com.automaterijal.db.Keys;
import com.automaterijal.db.tables.records.KomentarRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
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
public class Komentar extends TableImpl<KomentarRecord> {

    private static final long serialVersionUID = -311563452;

    /**
     * The reference instance of <code>automate_orders.komentar</code>
     */
    public static final Komentar KOMENTAR = new Komentar();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<KomentarRecord> getRecordType() {
        return KomentarRecord.class;
    }

    /**
     * The column <code>automate_orders.komentar.id</code>.
     */
    public final TableField<KomentarRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>automate_orders.komentar.komentar</code>.
     */
    public final TableField<KomentarRecord, String> KOMENTAR_ = createField(DSL.name("komentar"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>automate_orders.komentar.firma</code>.
     */
    public final TableField<KomentarRecord, Integer> FIRMA = createField(DSL.name("firma"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>automate_orders.komentar.datum_kreiranja</code>.
     */
    public final TableField<KomentarRecord, Timestamp> DATUM_KREIRANJA = createField(DSL.name("datum_kreiranja"), org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>automate_orders.komentar.podsetnik</code>.
     */
    public final TableField<KomentarRecord, Timestamp> PODSETNIK = createField(DSL.name("podsetnik"), org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>automate_orders.komentar.ppid</code>.
     */
    public final TableField<KomentarRecord, Integer> PPID = createField(DSL.name("ppid"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>automate_orders.komentar</code> table reference
     */
    public Komentar() {
        this(DSL.name("komentar"), null);
    }

    /**
     * Create an aliased <code>automate_orders.komentar</code> table reference
     */
    public Komentar(String alias) {
        this(DSL.name(alias), KOMENTAR);
    }

    /**
     * Create an aliased <code>automate_orders.komentar</code> table reference
     */
    public Komentar(Name alias) {
        this(alias, KOMENTAR);
    }

    private Komentar(Name alias, Table<KomentarRecord> aliased) {
        this(alias, aliased, null);
    }

    private Komentar(Name alias, Table<KomentarRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Komentar(Table<O> child, ForeignKey<O, KomentarRecord> key) {
        super(child, key, KOMENTAR);
    }

    @Override
    public Schema getSchema() {
        return AutomateOrders.AUTOMATE_ORDERS;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.KOMENTAR_PRIMARY);
    }

    @Override
    public Identity<KomentarRecord, Integer> getIdentity() {
        return Keys.IDENTITY_KOMENTAR;
    }

    @Override
    public UniqueKey<KomentarRecord> getPrimaryKey() {
        return Keys.KEY_KOMENTAR_PRIMARY;
    }

    @Override
    public List<UniqueKey<KomentarRecord>> getKeys() {
        return Arrays.<UniqueKey<KomentarRecord>>asList(Keys.KEY_KOMENTAR_PRIMARY);
    }

    @Override
    public Komentar as(String alias) {
        return new Komentar(DSL.name(alias), this);
    }

    @Override
    public Komentar as(Name alias) {
        return new Komentar(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Komentar rename(String name) {
        return new Komentar(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Komentar rename(Name name) {
        return new Komentar(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, Integer, Timestamp, Timestamp, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
