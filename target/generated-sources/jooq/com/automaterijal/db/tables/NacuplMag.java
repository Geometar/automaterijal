/*
 * This file is generated by jOOQ.
 */
package com.automaterijal.db.tables;


import com.automaterijal.db.AutomateOrders;
import com.automaterijal.db.Indexes;
import com.automaterijal.db.Keys;
import com.automaterijal.db.tables.records.NacuplMagRecord;

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
public class NacuplMag extends TableImpl<NacuplMagRecord> {

    private static final long serialVersionUID = 1582505429;

    /**
     * The reference instance of <code>automate_orders.nacupl_mag</code>
     */
    public static final NacuplMag NACUPL_MAG = new NacuplMag();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<NacuplMagRecord> getRecordType() {
        return NacuplMagRecord.class;
    }

    /**
     * The column <code>automate_orders.nacupl_mag.magacinid</code>.
     */
    public final TableField<NacuplMagRecord, Integer> MAGACINID = createField(DSL.name("magacinid"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>automate_orders.nacupl_mag.nuid</code>.
     */
    public final TableField<NacuplMagRecord, Short> NUID = createField(DSL.name("nuid"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false), this, "");

    /**
     * Create a <code>automate_orders.nacupl_mag</code> table reference
     */
    public NacuplMag() {
        this(DSL.name("nacupl_mag"), null);
    }

    /**
     * Create an aliased <code>automate_orders.nacupl_mag</code> table reference
     */
    public NacuplMag(String alias) {
        this(DSL.name(alias), NACUPL_MAG);
    }

    /**
     * Create an aliased <code>automate_orders.nacupl_mag</code> table reference
     */
    public NacuplMag(Name alias) {
        this(alias, NACUPL_MAG);
    }

    private NacuplMag(Name alias, Table<NacuplMagRecord> aliased) {
        this(alias, aliased, null);
    }

    private NacuplMag(Name alias, Table<NacuplMagRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> NacuplMag(Table<O> child, ForeignKey<O, NacuplMagRecord> key) {
        super(child, key, NACUPL_MAG);
    }

    @Override
    public Schema getSchema() {
        return AutomateOrders.AUTOMATE_ORDERS;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.NACUPL_MAG_PRIMARY);
    }

    @Override
    public UniqueKey<NacuplMagRecord> getPrimaryKey() {
        return Keys.KEY_NACUPL_MAG_PRIMARY;
    }

    @Override
    public List<UniqueKey<NacuplMagRecord>> getKeys() {
        return Arrays.<UniqueKey<NacuplMagRecord>>asList(Keys.KEY_NACUPL_MAG_PRIMARY);
    }

    @Override
    public NacuplMag as(String alias) {
        return new NacuplMag(DSL.name(alias), this);
    }

    @Override
    public NacuplMag as(Name alias) {
        return new NacuplMag(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public NacuplMag rename(String name) {
        return new NacuplMag(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public NacuplMag rename(Name name) {
        return new NacuplMag(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, Short> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
