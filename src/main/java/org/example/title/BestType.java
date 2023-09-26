package org.example.title;

import org.jooq.TableField;
import org.jooq.generated.tables.records.TitleRatingsRecord;

import static org.jooq.generated.tables.TitleRatings.TITLE_RATINGS;

enum BestType {
    AVERAGE_RATING(TITLE_RATINGS.AVERAGE_RATING), NUM_VOTES(TITLE_RATINGS.NUM_VOTES);
    final TableField<TitleRatingsRecord, ?> field;

    BestType(TableField<TitleRatingsRecord, ?> field) {
        this.field = field;
    }
}
