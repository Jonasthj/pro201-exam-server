create table quiz
(
    quiz_id bigserial primary key
);

create table questions
(
    questions_id   bigserial primary key,
    questions_name varchar(255) not null,
    quiz_id        bigint       not null,
    constraint quiz_id
        foreign key (quiz_id)
            references quiz (quiz_id)
);

create table answers
(
    answers_id   bigserial primary key,
    answers_name varchar(255) not null,
    question_id  bigint       not null,
    constraint question_id
        foreign key (question_id)
            references questions (questions_id)
);

create table correct_answers
(
    questions_id bigint primary key,
    answers_id   bigint primary key,
    constraint questions_id
        foreign key (questions_id)
            references questions (questions_id),
    constraint answers_id
        foreign key (answers_id)
            references answers (answers_id)
);

create table session
(
    session_id bigserial primary key
);

create table player
(
    player_id           bigserial primary key,
    player_name         varchar(12) not null,
    player_avatar_index int         not null,
    session_id          varchar(20) not null,
    constraint session_id
        foreign key (session_id)
            references session (session_id)
);

create table player_has_answer (
    id bigserial primary key ,
    player_id bigint not null ,
    answer_id bigint not null ,
    is_correct boolean
);

create table minigames
(
    minigame_id     bigserial primary key,
    minigame_amount int    not null,
    minigame_time   float  not null,
    player_id       bigint not null,
    constraint user_id
        foreign key (player_id)
            references player (player_id)
);