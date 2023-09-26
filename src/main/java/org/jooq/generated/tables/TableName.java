/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables;


import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function1;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row1;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.generated.Keys;
import org.jooq.generated.Public;
import org.jooq.generated.tables.records.TableNameRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TableName extends TableImpl<TableNameRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>PUBLIC.TABLE_NAME</code>
     */
    public static final TableName TABLE_NAME = new TableName();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TableNameRecord> getRecordType() {
        return TableNameRecord.class;
    }

    /**
     * The column <code>PUBLIC.TABLE_NAME.COLUMN_NAME</code>.
     */
    public final TableField<TableNameRecord, Integer> COLUMN_NAME = createField(DSL.name("COLUMN_NAME"), SQLDataType.INTEGER.nullable(false), this, "");

    private TableName(Name alias, Table<TableNameRecord> aliased) {
        this(alias, aliased, null);
    }

    private TableName(Name alias, Table<TableNameRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>PUBLIC.TABLE_NAME</code> table reference
     */
    public TableName(String alias) {
        this(DSL.name(alias), TABLE_NAME);
    }

    /**
     * Create an aliased <code>PUBLIC.TABLE_NAME</code> table reference
     */
    public TableName(Name alias) {
        this(alias, TABLE_NAME);
    }

    /**
     * Create a <code>PUBLIC.TABLE_NAME</code> table reference
     */
    public TableName() {
        this(DSL.name("TABLE_NAME"), null);
    }

    public <O extends Record> TableName(Table<O> child, ForeignKey<O, TableNameRecord> key) {
        super(child, key, TABLE_NAME);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<TableNameRecord> getPrimaryKey() {
        return Keys.TABLE_NAME_PK;
    }

    @Override
    public TableName as(String alias) {
        return new TableName(DSL.name(alias), this);
    }

    @Override
    public TableName as(Name alias) {
        return new TableName(alias, this);
    }

    @Override
    public TableName as(Table<?> alias) {
        return new TableName(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public TableName rename(String name) {
        return new TableName(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TableName rename(Name name) {
        return new TableName(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public TableName rename(Table<?> name) {
        return new TableName(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row1 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row1<Integer> fieldsRow() {
        return (Row1) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function1<? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function1<? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}