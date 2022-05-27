insert into posts
values (1, 'post_01', 0, 0, 1, 1),
       (2, 'post_01', 0.45, 43.2, 1, 2),
       (3, 'post_02', 0, 1, 2, 1),
       (4, 'post_02', 9.2, 43.4, 2, 2);

insert into posts_info_images
values (1, 'test_1_img_uri'),
       (2, 'test_2_img_uri');

insert into posts_info
values (nextval('posts_info_info_id_seq'), 'Hei, velkommen til oss', 'Sagruin', 12322,
        'Dette er info om denne flotte ruinen!', 'sagruin_uri', 1, 1),
       (nextval('posts_info_info_id_seq'), 'Hei, velkommen til oss', 'Vannmølle', 24681,
        'Her kan du se den store vannmøllen på over 15 meter!', 'vannmølle_uri', 3, 2);