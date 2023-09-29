create alias if not exists FT_INIT for "org.h2.fulltext.FullText.init";
call FT_INIT();

create table title_basics
(
    tconst          VARCHAR not null
        primary key,
    title_type      VARCHAR not null,
    primary_title   VARCHAR not null,
    original_title  VARCHAR not null,
    is_adult        BIT     not null,
    start_year      CHAR(4),
    end_year        CHAR(4),
    runtime_minutes INTEGER,
    genres          VARCHAR
);
call FT_CREATE_INDEX('PUBLIC', 'TITLE_BASICS', 'GENRES');

create table name_basics
(
    nconst             VARCHAR not null
        primary key,
    primary_name       VARCHAR not null,
    birth_year         CHAR(4) not null,
    death_year         CHAR(4),
    primary_profession VARCHAR,
    known_for_titles   VARCHAR not null
);
create index on name_basics (death_year);

create table title_principals
(
    tconst     VARCHAR not null,
    ordering   INTEGER not null,
    nconst     VARCHAR not null,
    category   VARCHAR not null,
    job        VARCHAR,
    characters VARCHAR,
    primary key (tconst, ordering)
);
create index on title_principals (nconst);

create table title_ratings
(
    tconst         VARCHAR not null
        primary key
        references title_basics,
    average_rating FLOAT   not null,
    num_votes      INTEGER not null
);

create table title_crew
(
    tconst    VARCHAR not null
        primary key,
    directors VARCHAR,
    writers   VARCHAR
);
create index on title_crew (directors);
