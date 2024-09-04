/*
 * This file is generated by jOOQ.
 */
package com.automaterijal.db.tables;


import com.automaterijal.db.AutomateOrders;
import com.automaterijal.db.Indexes;
import com.automaterijal.db.Keys;
import com.automaterijal.db.tables.records.StatusRecord;

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
public class Status extends TableImpl<StatusRecord> {

    private static final long serialVersionUID = 877138540;

    /**
     * The reference instance of <code>automate_orders.status</code>
     */
    public static final Status STATUS = new Status();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StatusRecord> getRecordType() {
        return StatusRecord.class;
    }

    /**
     * The column <code>automate_orders.status.id</code>.
     */
    public final TableField<StatusRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>automate_orders.status.opis</code>.
     */
    public final TableField<StatusRecord, String> OPIS = createField(DSL.name("opis"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    /**
     * Create a <code>automate_orders.status</code> table reference
     */
    public Status() {
        this(DSL.name("status"), null);
    }

    /**
     * Create an aliased <code>automate_orders.status</code> table reference
     */
    public Status(String alias) {
        this(DSL.name(alias), STATUS);
    }

    /**
     * Create an aliased <code>automate_orders.status</code> table reference
     */
    public Status(Name alias) {
        this(alias, STATUS);
    }

    private Status(Name alias, Table<StatusRecord> aliased) {
        this(alias, aliased, null);
    }

    private Status(Name alias, Table<StatusRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Status(Table<O> child, ForeignKey<O, StatusRecord> key) {
        super(child, key, STATUS);
    }

    @Override
    public Schema getSchema() {
        return AutomateOrders.AUTOMATE_ORDERS;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.STATUS_PRIMARY);
    }

    @Override
    public UniqueKey<StatusRecord> getPrimaryKey() {
        return Keys.KEY_STATUS_PRIMARY;
    }

    @Override
    public List<UniqueKey<StatusRecord>> getKeys() {
        return Arrays.<UniqueKey<StatusRecord>>asList(Keys.KEY_STATUS_PRIMARY);
    }

    @Override
    public Status as(String alias) {
        return new Status(DSL.name(alias), this);
    }

    @Override
    public Status as(Name alias) {
        return new Status(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Status rename(String name) {
        return new Status(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Status rename(Name name) {
        return new Status(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
