create table minigames (
    minigame_id bigserial primary key ,
    name varchar(100) not null
);

create table minigame_scores
(
    score_id        bigserial primary key,
    score_amount    int    not null,
    score_time      float  not null,
    player_id bigint not null,
    minigame_id bigint not null ,
    constraint player_id
        foreign key (player_id)
            references players (player_id),
    constraint minigame_id
        foreign key (minigame_id)
            references minigames (minigame_id)
);