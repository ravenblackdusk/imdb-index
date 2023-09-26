package org.example.config;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;
import jakarta.annotation.PostConstruct;
import org.jooq.DSLContext;
import org.jooq.TableRecord;
import org.jooq.generated.tables.records.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

@Configuration
class ImdbConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImdbConfiguration.class);
    private static final int BATCH_SIZE = 100;
    private final ImdbProperties imdbProperties;
    private final DSLContext dslContext;

    ImdbConfiguration(ImdbProperties imdbProperties, DSLContext dslContext) {
        this.imdbProperties = imdbProperties;
        this.dslContext = dslContext;
    }

    interface RecordConverter {
        TableRecord<?> convert(Record record);
    }

    private void batchInsert(List<TableRecord<?>> batch) {
        dslContext.batchInsert(batch).execute();
        batch.clear();
    }

    private static String nullableString(Record record, int columnIndex) {
        var string = record.getString(columnIndex);
        return "\\N".equals(string) ? null : string;
    }

    record FileConverter(String file, RecordConverter recordConverter) {
    }

    @PostConstruct
    void init() {
        if (imdbProperties.fillDb()) {
            var tsvParserSettings = new TsvParserSettings();
            tsvParserSettings.setHeaderExtractionEnabled(true);
            tsvParserSettings.setMaxCharsPerColumn(13497);
            var batch = new ArrayList<TableRecord<?>>(BATCH_SIZE);
            for (var fileConverter : List.of(
                    new FileConverter("title.basics", record -> new TitleBasicsRecord(
                            record.getString(0), record.getString(1), record.getString(2), record.getString(3),
                            switch (record.getChar(4)) {
                                case '0' -> false;
                                case '1' -> true;
                                default -> throw new IllegalStateException();
                            }, nullableString(record, 5), nullableString(record, 6),
                            ofNullable(nullableString(record, 7)).map(Integer::parseInt).orElse(null),
                            nullableString(record, 8))),
                    new FileConverter("name.basics", record -> new NameBasicsRecord(record.getString(0),
                            record.getString(1), record.getString(2), nullableString(record, 3),
                            nullableString(record, 4), record.getString(5))),
                    new FileConverter("title.principals", record -> new TitlePrincipalsRecord(record.getString(0),
                            record.getInt(1), record.getString(2), record.getString(3), nullableString(record, 4),
                            nullableString(record, 5))),
                    new FileConverter("title.ratings", record ->
                            new TitleRatingsRecord(record.getString(0), record.getDouble(1), record.getInt(2))),
                    new FileConverter("title.crew", record -> new TitleCrewRecord(record.getString(0),
                            nullableString(record, 1), nullableString(record, 2)))
            )) {
                LOGGER.info("importing {}", fileConverter.file());
                var tsvParser = new TsvParser(tsvParserSettings);
                for (var record : tsvParser.iterateRecords(imdbProperties.datasetsDir()
                        .resolve("%s.tsv".formatted(fileConverter.file())).toFile())) {
                    batch.add(fileConverter.recordConverter().convert(record));
                    if (batch.size() == BATCH_SIZE) {
                        batchInsert(batch);
                    }
                }
                if (!batch.isEmpty()) {
                    batchInsert(batch);
                }
            }
            LOGGER.info("finished import");
        }
    }
}
