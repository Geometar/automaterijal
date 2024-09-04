/*
 * This file is generated by jOOQ.
 */
package com.automaterijal.db.tables;


import com.automaterijal.db.AutomateOrders;
import com.automaterijal.db.Indexes;
import com.automaterijal.db.Keys;
import com.automaterijal.db.tables.records.GrupaDozvoljenaRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
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
public class GrupaDozvoljena extends TableImpl<GrupaDozvoljenaRecord> {

    private static final long serialVersionUID = -1026249325;

    /**
     * The reference instance of <code>automate_orders.grupa_dozvoljena</code>
     */
    public static final GrupaDozvoljena GRUPA_DOZVOLJENA = new GrupaDozvoljena();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GrupaDozvoljenaRecord> getRecordType() {
        return GrupaDozvoljenaRecord.class;
    }

    /**
     * The column <code>automate_orders.grupa_dozvoljena.grupa_id</code>.
     */
    public final TableField<GrupaDozvoljenaRecord, String> GRUPA_ID = createField(DSL.name("grupa_id"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>automate_orders.grupa_dozvoljena.naziv</code>.
     */
    public final TableField<GrupaDozvoljenaRecord, String> NAZIV = createField(DSL.name("naziv"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * Create a <code>automate_orders.grupa_dozvoljena</code> table reference
     */
    public GrupaDozvoljena() {
        this(DSL.name("grupa_dozvoljena"), null);
    }

    /**
     * Create an aliased <code>automate_orders.grupa_dozvoljena</code> table reference
     */
    public GrupaDozvoljena(String alias) {
        this(DSL.name(alias), GRUPA_DOZVOLJENA);
    }

    /**
     * Create an aliased <code>automate_orders.grupa_dozvoljena</code> table reference
     */
    public GrupaDozvoljena(Name alias) {
        this(alias, GRUPA_DOZVOLJENA);
    }

    private GrupaDozvoljena(Name alias, Table<GrupaDozvoljenaRecord> aliased) {
        this(alias, aliased, null);
    }

    private GrupaDozvoljena(Name alias, Table<GrupaDozvoljenaRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> GrupaDozvoljena(Table<O> child, ForeignKey<O, GrupaDozvoljenaRecord> key) {
        super(child, key, GRUPA_DOZVOLJENA);
    }

    @Override
    public Schema getSchema() {
        return AutomateOrders.AUTOMATE_ORDERS;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.GRUPA_DOZVOLJENA_PRIMARY);
    }

    @Override
    public UniqueKey<GrupaDozvoljenaRecord> getPrimaryKey() {
        return Keys.KEY_GRUPA_DOZVOLJENA_PRIMARY;
    }

    @Override
    public List<UniqueKey<GrupaDozvoljenaRecord>> getKeys() {
        return Arrays.<UniqueKey<GrupaDozvoljenaRecord>>asList(Keys.KEY_GRUPA_DOZVOLJENA_PRIMARY);
    }

    @Override
    public GrupaDozvoljena as(String alias) {
        return new GrupaDozvoljena(DSL.name(alias), this);
    }

    @Override
    public GrupaDozvoljena as(Name alias) {
        return new GrupaDozvoljena(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public GrupaDozvoljena rename(String name) {
        return new GrupaDozvoljena(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public GrupaDozvoljena rename(Name name) {
        return new GrupaDozvoljena(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
