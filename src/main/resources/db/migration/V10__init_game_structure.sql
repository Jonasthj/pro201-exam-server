create table sessions
(
    session_id varchar(20) primary key not null
);

create table players
(
    player_id           bigserial primary key,
    player_name         varchar(12) not null,
    player_avatar_index int         not null,
    player_session_id   varchar(20) not null,
    constraint session_id
        foreign key (player_session_id)
            references sessions (session_id)
);

create table languages
(
    language_id bigserial primary key,
    name        varchar(100) not null,
    flag_uri    varchar(1000)
)