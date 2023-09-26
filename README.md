# IMDB indexer
## DB migrations
To migrate the database you need to:
1. Add flyway migration files
2. run `mvn flyway:migrate jooq-codegen:generate`
3. stage changes in [jooq generated directory](src/main/java/org/jooq/generated) into git
