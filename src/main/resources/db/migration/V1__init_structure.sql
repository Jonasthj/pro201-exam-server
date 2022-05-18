create table quiz
(
    quiz_id bigserial primary key
);

create table questions
(
    question_id      bigserial primary key,
    question_name    varchar(255) not null,
    question_quiz_id bigint       not null,
    constraint quiz_id
        foreign key (question_quiz_id)
            references quiz (quiz_id)
);

create table answers
(
    answer_id          bigserial primary key,
    answer_name        varchar(255) not null,
    answer_question_id bigint       not null,
    constraint answer_question_id
        foreign key (answer_question_id)
            references questions (question_id)
);

create table correct_answers
(
    correct_answer_id bigserial primary key,
    question_id       bigint not null,
    answer_id         bigint not null,
    constraint question_id
        foreign key (question_id)
            references questions (question_id),
    constraint answer_id
        foreign key (answer_id)
            references answers (answer_id)
);

create table session
(
    session_id varchar(20) primary key not null
);

create table player
(
    player_id           bigserial primary key,
    player_name         varchar(12) not null,
    player_avatar_index int         not null,
    player_session_id   varchar(20) not null,
    constraint session_id
        foreign key (player_session_id)
            references session (session_id)
);

create table player_has_answer
(
    id         bigserial primary key,
    player_id  bigint  not null,
    answer_id  bigint  not null,
    is_correct boolean not null
);

create table minigames
(
    minigame_id        bigserial primary key,
    minigame_amount    int    not null,
    minigame_time      float  not null,
    minigame_player_id bigint not null,
    constraint user_id
        foreign key (minigame_player_id)
            references player (player_id)
);