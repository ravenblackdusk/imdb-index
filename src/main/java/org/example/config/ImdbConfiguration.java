package org.example.config;

import jakarta.annotation.PostConstruct;
import org.jooq.DSLContext;
import org.jooq.generated.tables.records.TableNameRecord;
import org.springframework.context.annotation.Configuration;

import static org.jooq.generated.tables.TableName.TABLE_NAME;

@Configuration
class ImdbConfiguration {
    private final DSLContext dslContext;

    ImdbConfiguration(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @PostConstruct
    void init() {
        dslContext.insertInto(TABLE_NAME).set(new TableNameRecord(9897)).execute();
        var fetch = dslContext.selectFrom(TABLE_NAME).fetch().get(0);
        Integer columnName = fetch.getColumnName();
        int a = 0;
    }
}
