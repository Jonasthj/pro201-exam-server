create table minigame_scores
(
    minigame_id        bigserial primary key,
    minigame_amount    int    not null,
    minigame_time      float  not null,
    minigame_player_id bigint not null,
    constraint user_id
        foreign key (minigame_player_id)
            references players (player_id)
);