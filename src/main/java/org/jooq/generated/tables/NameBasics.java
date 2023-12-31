/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables;


import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function6;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.generated.Keys;
import org.jooq.generated.Public;
import org.jooq.generated.tables.records.NameBasicsRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class NameBasics extends TableImpl<NameBasicsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>PUBLIC.NAME_BASICS</code>
     */
    public static final NameBasics NAME_BASICS = new NameBasics();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<NameBasicsRecord> getRecordType() {
        return NameBasicsRecord.class;
    }

    /**
     * The column <code>PUBLIC.NAME_BASICS.NCONST</code>.
     */
    public final TableField<NameBasicsRecord, String> NCONST = createField(DSL.name("NCONST"), SQLDataType.VARCHAR(1000000000).nullable(false), this, "");

    /**
     * The column <code>PUBLIC.NAME_BASICS.PRIMARY_NAME</code>.
     */
    public final TableField<NameBasicsRecord, String> PRIMARY_NAME = createField(DSL.name("PRIMARY_NAME"), SQLDataType.VARCHAR(1000000000).nullable(false), this, "");

    /**
     * The column <code>PUBLIC.NAME_BASICS.BIRTH_YEAR</code>.
     */
    public final TableField<NameBasicsRecord, String> BIRTH_YEAR = createField(DSL.name("BIRTH_YEAR"), SQLDataType.CHAR(4).nullable(false), this, "");

    /**
     * The column <code>PUBLIC.NAME_BASICS.DEATH_YEAR</code>.
     */
    public final TableField<NameBasicsRecord, String> DEATH_YEAR = createField(DSL.name("DEATH_YEAR"), SQLDataType.CHAR(4), this, "");

    /**
     * The column <code>PUBLIC.NAME_BASICS.PRIMARY_PROFESSION</code>.
     */
    public final TableField<NameBasicsRecord, String> PRIMARY_PROFESSION = createField(DSL.name("PRIMARY_PROFESSION"), SQLDataType.VARCHAR(1000000000).nullable(false), this, "");

    /**
     * The column <code>PUBLIC.NAME_BASICS.KNOWN_FOR_TITLES</code>.
     */
    public final TableField<NameBasicsRecord, String> KNOWN_FOR_TITLES = createField(DSL.name("KNOWN_FOR_TITLES"), SQLDataType.VARCHAR(1000000000).nullable(false), this, "");

    private NameBasics(Name alias, Table<NameBasicsRecord> aliased) {
        this(alias, aliased, null);
    }

    private NameBasics(Name alias, Table<NameBasicsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>PUBLIC.NAME_BASICS</code> table reference
     */
    public NameBasics(String alias) {
        this(DSL.name(alias), NAME_BASICS);
    }

    /**
     * Create an aliased <code>PUBLIC.NAME_BASICS</code> table reference
     */
    public NameBasics(Name alias) {
        this(alias, NAME_BASICS);
    }

    /**
     * Create a <code>PUBLIC.NAME_BASICS</code> table reference
     */
    public NameBasics() {
        this(DSL.name("NAME_BASICS"), null);
    }

    public <O extends Record> NameBasics(Table<O> child, ForeignKey<O, NameBasicsRecord> key) {
        super(child, key, NAME_BASICS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<NameBasicsRecord> getPrimaryKey() {
        return Keys.NAME_BASICS_PK;
    }

    @Override
    public NameBasics as(String alias) {
        return new NameBasics(DSL.name(alias), this);
    }

    @Override
    public NameBasics as(Name alias) {
        return new NameBasics(alias, this);
    }

    @Override
    public NameBasics as(Table<?> alias) {
        return new NameBasics(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public NameBasics rename(String name) {
        return new NameBasics(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public NameBasics rename(Name name) {
        return new NameBasics(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public NameBasics rename(Table<?> name) {
        return new NameBasics(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<String, String, String, String, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function6<? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function6<? super String, ? super String, ? super String, ? super String, ? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
