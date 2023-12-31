/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function3;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.generated.Keys;
import org.jooq.generated.Public;
import org.jooq.generated.tables.records.TitleRatingsRecord;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TitleRatings extends TableImpl<TitleRatingsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>PUBLIC.TITLE_RATINGS</code>
     */
    public static final TitleRatings TITLE_RATINGS = new TitleRatings();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TitleRatingsRecord> getRecordType() {
        return TitleRatingsRecord.class;
    }

    /**
     * The column <code>PUBLIC.TITLE_RATINGS.TCONST</code>.
     */
    public final TableField<TitleRatingsRecord, String> TCONST = createField(DSL.name("TCONST"), SQLDataType.VARCHAR(1000000000).nullable(false), this, "");

    /**
     * The column <code>PUBLIC.TITLE_RATINGS.AVERAGE_RATING</code>.
     */
    public final TableField<TitleRatingsRecord, Double> AVERAGE_RATING = createField(DSL.name("AVERAGE_RATING"), SQLDataType.DOUBLE.nullable(false), this, "");

    /**
     * The column <code>PUBLIC.TITLE_RATINGS.NUM_VOTES</code>.
     */
    public final TableField<TitleRatingsRecord, Integer> NUM_VOTES = createField(DSL.name("NUM_VOTES"), SQLDataType.INTEGER.nullable(false), this, "");

    private TitleRatings(Name alias, Table<TitleRatingsRecord> aliased) {
        this(alias, aliased, null);
    }

    private TitleRatings(Name alias, Table<TitleRatingsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>PUBLIC.TITLE_RATINGS</code> table reference
     */
    public TitleRatings(String alias) {
        this(DSL.name(alias), TITLE_RATINGS);
    }

    /**
     * Create an aliased <code>PUBLIC.TITLE_RATINGS</code> table reference
     */
    public TitleRatings(Name alias) {
        this(alias, TITLE_RATINGS);
    }

    /**
     * Create a <code>PUBLIC.TITLE_RATINGS</code> table reference
     */
    public TitleRatings() {
        this(DSL.name("TITLE_RATINGS"), null);
    }

    public <O extends Record> TitleRatings(Table<O> child, ForeignKey<O, TitleRatingsRecord> key) {
        super(child, key, TITLE_RATINGS);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<TitleRatingsRecord> getPrimaryKey() {
        return Keys.TITLE_RATINGS_PK;
    }

    @Override
    public List<ForeignKey<TitleRatingsRecord, ?>> getReferences() {
        return Arrays.asList(Keys.CONSTRAINT_B);
    }

    private transient TitleBasics _titleBasics;

    /**
     * Get the implicit join path to the <code>PUBLIC.TITLE_BASICS</code> table.
     */
    public TitleBasics titleBasics() {
        if (_titleBasics == null)
            _titleBasics = new TitleBasics(this, Keys.CONSTRAINT_B);

        return _titleBasics;
    }

    @Override
    public TitleRatings as(String alias) {
        return new TitleRatings(DSL.name(alias), this);
    }

    @Override
    public TitleRatings as(Name alias) {
        return new TitleRatings(alias, this);
    }

    @Override
    public TitleRatings as(Table<?> alias) {
        return new TitleRatings(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public TitleRatings rename(String name) {
        return new TitleRatings(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TitleRatings rename(Name name) {
        return new TitleRatings(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public TitleRatings rename(Table<?> name) {
        return new TitleRatings(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, Double, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function3<? super String, ? super Double, ? super Integer, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function3<? super String, ? super Double, ? super Integer, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
