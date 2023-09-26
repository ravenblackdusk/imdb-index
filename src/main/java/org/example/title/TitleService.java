package org.example.title;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.SelectConditionStep;
import org.jooq.TableField;
import org.jooq.generated.tables.records.TitlePrincipalsRecord;
import org.jooq.generated.tables.records.TitleRatingsRecord;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.requireNonNull;
import static java.util.Optional.ofNullable;
import static org.jooq.generated.tables.NameBasics.NAME_BASICS;
import static org.jooq.generated.tables.TitleBasics.TITLE_BASICS;
import static org.jooq.generated.tables.TitleCrew.TITLE_CREW;
import static org.jooq.generated.tables.TitlePrincipals.TITLE_PRINCIPALS;
import static org.jooq.generated.tables.TitleRatings.TITLE_RATINGS;

@Service
class TitleService {
    private final DSLContext dslContext;

    TitleService(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    List<String> getSameDirectorAndWriterAlive() {
        return dslContext.select(TITLE_CREW.TCONST)
                .from(TITLE_CREW.innerJoin(NAME_BASICS).on(TITLE_CREW.DIRECTORS.eq(NAME_BASICS.NCONST)))
                .where(TITLE_CREW.DIRECTORS.eq(TITLE_CREW.WRITERS).and(NAME_BASICS.DEATH_YEAR.isNull())).fetch()
                .stream().map(Record1::value1).toList();
    }

    private SelectConditionStep<TitlePrincipalsRecord> filterTitlePrincipalsByName(String name) {
        return dslContext.selectFrom(TITLE_PRINCIPALS).where(TITLE_PRINCIPALS.NCONST.eq(name));
    }

    List<String> getByTwoActors(String firstActor, String secondActor) {
        var first = filterTitlePrincipalsByName(firstActor).asTable();
        var second = filterTitlePrincipalsByName(secondActor);
        return dslContext.selectDistinct(TITLE_PRINCIPALS.TCONST).from(
                first.innerJoin(second).on(requireNonNull(first.field(TITLE_PRINCIPALS.TCONST))
                        .eq(second.field(TITLE_PRINCIPALS.TCONST)))
        ).fetch().stream().map(Record1::value1).toList();
    }

    String getBestInGenre(String genre, TableField<TitleRatingsRecord, ?> field) {
        return ofNullable(dslContext.select(TITLE_BASICS.TCONST)
                .from(TITLE_BASICS.innerJoin(TITLE_RATINGS).on(TITLE_BASICS.TCONST.eq(TITLE_RATINGS.TCONST)))
                .where(TITLE_BASICS.GENRES.contains(genre)).orderBy(field.desc()).limit(1).fetchOne()
        ).map(Record1::value1).orElse(null);
    }
}
