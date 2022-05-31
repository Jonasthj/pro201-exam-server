create table posts
(
    post_id     bigserial primary key,
    name        varchar(100) not null,
    latitude    float        not null,
    longitude   float        not null,
    quiz_id     bigint       not null,
    language_id bigint       not null,
    constraint quiz_id
        foreign key (quiz_id)
            references quiz (quiz_id),
    constraint language_id
        foreign key (language_id)
            references languages (language_id)
);

create table posts_info_images
(
    info_img_id bigserial primary key,
    img_uri     varchar(1000) not null
);

create table posts_info
(
    info_id       bigserial primary key,
    info_header   varchar(100),
    info_identify int,
    info_content  varchar(3000),
    model_uri     varchar(1000),
    post_id       bigint not null,
    info_img_id   bigint not null,
    constraint post_id
        foreign key (post_id)
            references posts (post_id),
    constraint info_img_id
        foreign key (info_img_id)
            references posts_info_images (info_img_id)
);

