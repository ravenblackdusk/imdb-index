# IMDB indexer
## DB migrations
To migrate the database you need to:
1. Add flyway migration files
2. run `mvn flyway:migrate jooq-codegen:generate`
3. stage changes in [jooq generated directory](src/main/java/org/jooq/generated) into git
## To do
1. Remove unneeded columns so that we won't go OOM if using in-memory h2
2. Move most comma separated columns to a one-to-many table so that we could use regular index instead of full text
 index
3. Add e2e tests
4. Benchmark Quarkus reactive and maybe R2DBC implementations to find which performs best
5. Since the DB is updated daily we could prefetch or change the tables so that queries are executed as fast as possible