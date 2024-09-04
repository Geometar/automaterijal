/*
 * This file is generated by jOOQ.
 */
package com.automaterijal.db.tables;


import com.automaterijal.db.AutomateOrders;
import com.automaterijal.db.Indexes;
import com.automaterijal.db.Keys;
import com.automaterijal.db.tables.records.OrderHeadersRecord;

import java.math.BigDecimal;
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
import org.jooq.Row17;
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
public class OrderHeaders extends TableImpl<OrderHeadersRecord> {

    private static final long serialVersionUID = -1099980149;

    /**
     * The reference instance of <code>automate_orders.order_headers</code>
     */
    public static final OrderHeaders ORDER_HEADERS = new OrderHeaders();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OrderHeadersRecord> getRecordType() {
        return OrderHeadersRecord.class;
    }

    /**
     * The column <code>automate_orders.order_headers.id</code>.
     */
    public final TableField<OrderHeadersRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>automate_orders.order_headers.ppid</code>.
     */
    public final TableField<OrderHeadersRecord, Integer> PPID = createField(DSL.name("ppid"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>automate_orders.order_headers.order_id</code>.
     */
    public final TableField<OrderHeadersRecord, Integer> ORDER_ID = createField(DSL.name("order_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>automate_orders.order_headers.last_update</code>.
     */
    public final TableField<OrderHeadersRecord, Timestamp> LAST_UPDATE = createField(DSL.name("last_update"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>automate_orders.order_headers.date_sent</code>.
     */
    public final TableField<OrderHeadersRecord, Timestamp> DATE_SENT = createField(DSL.name("date_sent"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0000-00-00 00:00:00", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>automate_orders.order_headers.status</code>.
     */
    public final TableField<OrderHeadersRecord, Short> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.SMALLINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("1", org.jooq.impl.SQLDataType.SMALLINT)), this, "");

    /**
     * The column <code>automate_orders.order_headers.nuid</code>.
     */
    public final TableField<OrderHeadersRecord, Short> NUID = createField(DSL.name("nuid"), org.jooq.impl.SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>automate_orders.order_headers.niid</code>.
     */
    public final TableField<OrderHeadersRecord, Short> NIID = createField(DSL.name("niid"), org.jooq.impl.SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>automate_orders.order_headers.prid</code>.
     */
    public final TableField<OrderHeadersRecord, Short> PRID = createField(DSL.name("prid"), org.jooq.impl.SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>automate_orders.order_headers.back_order</code>.
     */
    public final TableField<OrderHeadersRecord, Byte> BACK_ORDER = createField(DSL.name("back_order"), org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * The column <code>automate_orders.order_headers.realizovati</code>.
     */
    public final TableField<OrderHeadersRecord, Byte> REALIZOVATI = createField(DSL.name("realizovati"), org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("1", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * The column <code>automate_orders.order_headers.created_by_ppid</code>.
     */
    public final TableField<OrderHeadersRecord, Integer> CREATED_BY_PPID = createField(DSL.name("created_by_ppid"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>automate_orders.order_headers.mes_isporuke_ppid</code>.
     */
    public final TableField<OrderHeadersRecord, Integer> MES_ISPORUKE_PPID = createField(DSL.name("mes_isporuke_ppid"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>automate_orders.order_headers.napomena</code>.
     */
    public final TableField<OrderHeadersRecord, String> NAPOMENA = createField(DSL.name("napomena"), org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    /**
     * The column <code>automate_orders.order_headers.iznos_naruceno</code>.
     */
    public final TableField<OrderHeadersRecord, BigDecimal> IZNOS_NARUCENO = createField(DSL.name("iznos_naruceno"), org.jooq.impl.SQLDataType.DECIMAL(15, 4).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.0000", org.jooq.impl.SQLDataType.DECIMAL)), this, "");

    /**
     * The column <code>automate_orders.order_headers.iznos_potvrdjeno</code>.
     */
    public final TableField<OrderHeadersRecord, BigDecimal> IZNOS_POTVRDJENO = createField(DSL.name("iznos_potvrdjeno"), org.jooq.impl.SQLDataType.DECIMAL(15, 4).nullable(false).defaultValue(org.jooq.impl.DSL.inline("0.0000", org.jooq.impl.SQLDataType.DECIMAL)), this, "");

    /**
     * The column <code>automate_orders.order_headers.ext_order_id</code>.
     */
    public final TableField<OrderHeadersRecord, String> EXT_ORDER_ID = createField(DSL.name("ext_order_id"), org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * Create a <code>automate_orders.order_headers</code> table reference
     */
    public OrderHeaders() {
        this(DSL.name("order_headers"), null);
    }

    /**
     * Create an aliased <code>automate_orders.order_headers</code> table reference
     */
    public OrderHeaders(String alias) {
        this(DSL.name(alias), ORDER_HEADERS);
    }

    /**
     * Create an aliased <code>automate_orders.order_headers</code> table reference
     */
    public OrderHeaders(Name alias) {
        this(alias, ORDER_HEADERS);
    }

    private OrderHeaders(Name alias, Table<OrderHeadersRecord> aliased) {
        this(alias, aliased, null);
    }

    private OrderHeaders(Name alias, Table<OrderHeadersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> OrderHeaders(Table<O> child, ForeignKey<O, OrderHeadersRecord> key) {
        super(child, key, ORDER_HEADERS);
    }

    @Override
    public Schema getSchema() {
        return AutomateOrders.AUTOMATE_ORDERS;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ORDER_HEADERS_IDXDATESENT, Indexes.ORDER_HEADERS_IDXPARTNER, Indexes.ORDER_HEADERS_PRIMARY);
    }

    @Override
    public Identity<OrderHeadersRecord, Integer> getIdentity() {
        return Keys.IDENTITY_ORDER_HEADERS;
    }

    @Override
    public UniqueKey<OrderHeadersRecord> getPrimaryKey() {
        return Keys.KEY_ORDER_HEADERS_PRIMARY;
    }

    @Override
    public List<UniqueKey<OrderHeadersRecord>> getKeys() {
        return Arrays.<UniqueKey<OrderHeadersRecord>>asList(Keys.KEY_ORDER_HEADERS_PRIMARY);
    }

    @Override
    public OrderHeaders as(String alias) {
        return new OrderHeaders(DSL.name(alias), this);
    }

    @Override
    public OrderHeaders as(Name alias) {
        return new OrderHeaders(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public OrderHeaders rename(String name) {
        return new OrderHeaders(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public OrderHeaders rename(Name name) {
        return new OrderHeaders(name, null);
    }

    // -------------------------------------------------------------------------
    // Row17 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row17<Integer, Integer, Integer, Timestamp, Timestamp, Short, Short, Short, Short, Byte, Byte, Integer, Integer, String, BigDecimal, BigDecimal, String> fieldsRow() {
        return (Row17) super.fieldsRow();
    }
}
