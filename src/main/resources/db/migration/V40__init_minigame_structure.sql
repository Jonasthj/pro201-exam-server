create table minigames
(
    minigame_id bigserial primary key,
    name        varchar(100) not null
);

create table minigame_rounds
(
    round_id    bigserial primary key,
    round_number int not null,
    minigame_id bigint not null,
    language_id bigint not null,
    post_id     bigint not null,
    constraint minigame_id
        foreign key (minigame_id)
            references minigames (minigame_id),
    constraint language_id
        foreign key (language_id)
            references languages (language_id),
    constraint post_id
        foreign key (post_id)
            references posts (post_id)
);

create table minigame_scores
(
    score_id     bigserial primary key,
    score_amount int    not null,
    score_time   float  not null,
    player_id    bigint not null,
    round_id  bigint not null,
    constraint player_id
        foreign key (player_id)
            references players (player_id),
    constraint round_id
        foreign key (round_id)
            references minigame_rounds (round_id)
);

create table memorycards
(
    memory_id bigserial primary key,
    image_uri varchar(1000) not null,
    round_id  bigint        not null,
    constraint round_id
        foreign key (round_id)
            references minigame_rounds (round_id)
);

create table histories
(
    history_id bigserial primary key,
    title      varchar(100)  not null,
    content    varchar(1000) not null,
    year       int           not null,
    is_before  boolean       not null,
    round_id   bigint        not null,
    constraint round_id
        foreign key (round_id)
            references minigame_rounds (round_id)
);

create table words
(
    word_id  bigserial primary key,
    word     varchar(20) not null,
    round_id bigint      not null,
    constraint round_id
        foreign key (round_id)
            references minigame_rounds (round_id)
);

