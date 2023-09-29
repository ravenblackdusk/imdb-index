package org.example.title;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.generated.tables.records.TitleRatingsRecord;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.requireNonNull;
import static java.util.Optional.ofNullable;
import static org.jooq.generated.tables.NameBasics.NAME_BASICS;
import static org.jooq.generated.tables.TitleCrew.TITLE_CREW;
import static org.jooq.generated.tables.TitlePrincipals.TITLE_PRINCIPALS;
import static org.jooq.generated.tables.TitleRatings.TITLE_RATINGS;
import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

@Service
class TitleService {
    private final DSLContext dslContext;

    TitleService(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    List<String> getSameDirectorAndWriterAlive() {
        return dslContext.select(NAME_BASICS.NCONST)
                .from(NAME_BASICS.innerJoin(TITLE_CREW).on(NAME_BASICS.NCONST.eq(TITLE_CREW.WRITERS)))
                .where(NAME_BASICS.DEATH_YEAR.isNull().and(TITLE_CREW.DIRECTORS.eq(TITLE_CREW.WRITERS))).fetch()
                .stream().map(Record1::value1).toList();
    }

    private Table<Record1<String>> filterTitlePrincipalsByName(String name, String alias) {
        return dslContext.select(TITLE_PRINCIPALS.TCONST).from(TITLE_PRINCIPALS)
                .where(TITLE_PRINCIPALS.NCONST.eq(name).and(TITLE_PRINCIPALS.CATEGORY.eq("actor"))).asTable(alias);
    }

    List<String> getByTwoActors(String firstActor, String secondActor) {
        var first = filterTitlePrincipalsByName(firstActor, "first");
        var second = filterTitlePrincipalsByName(secondActor, "second");
        var firstTconst = requireNonNull(first.field(TITLE_PRINCIPALS.TCONST));
        return dslContext.selectDistinct(firstTconst)
                .from(first.innerJoin(second).on(firstTconst.eq(second.field(TITLE_PRINCIPALS.TCONST))))
                .fetch().stream().map(Record1::value1).toList();
    }

    String getBestInGenre(String genre, TableField<TitleRatingsRecord, ?> field) {
        return ofNullable(dslContext.select(TITLE_RATINGS.TCONST).from(
                TITLE_RATINGS.innerJoin(table("(select KEYS from FT_SEARCH_DATA(?, 0, 0))", genre).asTable("FT"))
                        .on(TITLE_RATINGS.TCONST.eq(field("FT.KEYS[1]", String.class)))
        ).orderBy(field.desc()).limit(1).fetchOne()).map(Record1::value1).orElse(null);
    }
}
