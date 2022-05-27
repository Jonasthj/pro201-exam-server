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
    answer_is_correct  boolean      not null,
    answer_question_id bigint       not null,
    constraint answer_question_id
        foreign key (answer_question_id)
            references questions (question_id)
);

create table players_has_answers
(
    id         bigserial primary key,
    player_id  bigint  not null,
    answer_id  bigint  not null,
    is_correct boolean not null,
    constraint player_id
        foreign key (player_id)
            references players (player_id),
    constraint answer_id
        foreign key (answer_id)
            references answers (answer_id)
);