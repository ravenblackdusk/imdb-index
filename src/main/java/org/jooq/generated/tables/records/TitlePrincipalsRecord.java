/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.generated.tables.TitlePrincipals;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TitlePrincipalsRecord extends UpdatableRecordImpl<TitlePrincipalsRecord> implements Record6<String, Integer, String, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>PUBLIC.TITLE_PRINCIPALS.TCONST</code>.
     */
    public void setTconst(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>PUBLIC.TITLE_PRINCIPALS.TCONST</code>.
     */
    public String getTconst() {
        return (String) get(0);
    }

    /**
     * Setter for <code>PUBLIC.TITLE_PRINCIPALS.ORDERING</code>.
     */
    public void setOrdering(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>PUBLIC.TITLE_PRINCIPALS.ORDERING</code>.
     */
    public Integer getOrdering() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>PUBLIC.TITLE_PRINCIPALS.NCONST</code>.
     */
    public void setNconst(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>PUBLIC.TITLE_PRINCIPALS.NCONST</code>.
     */
    public String getNconst() {
        return (String) get(2);
    }

    /**
     * Setter for <code>PUBLIC.TITLE_PRINCIPALS.CATEGORY</code>.
     */
    public void setCategory(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>PUBLIC.TITLE_PRINCIPALS.CATEGORY</code>.
     */
    public String getCategory() {
        return (String) get(3);
    }

    /**
     * Setter for <code>PUBLIC.TITLE_PRINCIPALS.JOB</code>.
     */
    public void setJob(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>PUBLIC.TITLE_PRINCIPALS.JOB</code>.
     */
    public String getJob() {
        return (String) get(4);
    }

    /**
     * Setter for <code>PUBLIC.TITLE_PRINCIPALS.CHARACTERS</code>.
     */
    public void setCharacters(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>PUBLIC.TITLE_PRINCIPALS.CHARACTERS</code>.
     */
    public String getCharacters() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<String, Integer, String, String, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<String, Integer, String, String, String, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return TitlePrincipals.TITLE_PRINCIPALS.TCONST;
    }

    @Override
    public Field<Integer> field2() {
        return TitlePrincipals.TITLE_PRINCIPALS.ORDERING;
    }

    @Override
    public Field<String> field3() {
        return TitlePrincipals.TITLE_PRINCIPALS.NCONST;
    }

    @Override
    public Field<String> field4() {
        return TitlePrincipals.TITLE_PRINCIPALS.CATEGORY;
    }

    @Override
    public Field<String> field5() {
        return TitlePrincipals.TITLE_PRINCIPALS.JOB;
    }

    @Override
    public Field<String> field6() {
        return TitlePrincipals.TITLE_PRINCIPALS.CHARACTERS;
    }

    @Override
    public String component1() {
        return getTconst();
    }

    @Override
    public Integer component2() {
        return getOrdering();
    }

    @Override
    public String component3() {
        return getNconst();
    }

    @Override
    public String component4() {
        return getCategory();
    }

    @Override
    public String component5() {
        return getJob();
    }

    @Override
    public String component6() {
        return getCharacters();
    }

    @Override
    public String value1() {
        return getTconst();
    }

    @Override
    public Integer value2() {
        return getOrdering();
    }

    @Override
    public String value3() {
        return getNconst();
    }

    @Override
    public String value4() {
        return getCategory();
    }

    @Override
    public String value5() {
        return getJob();
    }

    @Override
    public String value6() {
        return getCharacters();
    }

    @Override
    public TitlePrincipalsRecord value1(String value) {
        setTconst(value);
        return this;
    }

    @Override
    public TitlePrincipalsRecord value2(Integer value) {
        setOrdering(value);
        return this;
    }

    @Override
    public TitlePrincipalsRecord value3(String value) {
        setNconst(value);
        return this;
    }

    @Override
    public TitlePrincipalsRecord value4(String value) {
        setCategory(value);
        return this;
    }

    @Override
    public TitlePrincipalsRecord value5(String value) {
        setJob(value);
        return this;
    }

    @Override
    public TitlePrincipalsRecord value6(String value) {
        setCharacters(value);
        return this;
    }

    @Override
    public TitlePrincipalsRecord values(String value1, Integer value2, String value3, String value4, String value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TitlePrincipalsRecord
     */
    public TitlePrincipalsRecord() {
        super(TitlePrincipals.TITLE_PRINCIPALS);
    }

    /**
     * Create a detached, initialised TitlePrincipalsRecord
     */
    public TitlePrincipalsRecord(String tconst, Integer ordering, String nconst, String category, String job, String characters) {
        super(TitlePrincipals.TITLE_PRINCIPALS);

        setTconst(tconst);
        setOrdering(ordering);
        setNconst(nconst);
        setCategory(category);
        setJob(job);
        setCharacters(characters);
        resetChangedOnNotNull();
    }
}
