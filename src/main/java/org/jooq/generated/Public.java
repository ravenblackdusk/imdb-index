/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated;


import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.generated.tables.NameBasics;
import org.jooq.generated.tables.TitleBasics;
import org.jooq.generated.tables.TitleCrew;
import org.jooq.generated.tables.TitlePrincipals;
import org.jooq.generated.tables.TitleRatings;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>PUBLIC</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>PUBLIC.NAME_BASICS</code>.
     */
    public final NameBasics NAME_BASICS = NameBasics.NAME_BASICS;

    /**
     * The table <code>PUBLIC.TITLE_BASICS</code>.
     */
    public final TitleBasics TITLE_BASICS = TitleBasics.TITLE_BASICS;

    /**
     * The table <code>PUBLIC.TITLE_CREW</code>.
     */
    public final TitleCrew TITLE_CREW = TitleCrew.TITLE_CREW;

    /**
     * The table <code>PUBLIC.TITLE_PRINCIPALS</code>.
     */
    public final TitlePrincipals TITLE_PRINCIPALS = TitlePrincipals.TITLE_PRINCIPALS;

    /**
     * The table <code>PUBLIC.TITLE_RATINGS</code>.
     */
    public final TitleRatings TITLE_RATINGS = TitleRatings.TITLE_RATINGS;

    /**
     * No further instances allowed
     */
    private Public() {
        super("PUBLIC", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
            NameBasics.NAME_BASICS,
            TitleBasics.TITLE_BASICS,
            TitleCrew.TITLE_CREW,
            TitlePrincipals.TITLE_PRINCIPALS,
            TitleRatings.TITLE_RATINGS
        );
    }
}
