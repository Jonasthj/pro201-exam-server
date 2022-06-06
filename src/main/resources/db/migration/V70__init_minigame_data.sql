insert into minigames
values (1, 'Memo game'),
       (2, 'Saw game'),
       (3, 'Word finder'),
       (4, 'History sorter');

insert into minigame_rounds
values (1, 1, 1, 1, 1),
       (2, 2, 1, 1, 1),
       (3, 3, 1, 1, 1),
       (4, 1, 1, 1, 2),
       (5, 2, 1, 1, 2),
       (6, 3, 1, 1, 2);

insert into minigame_scores
values (nextval('minigame_scores_score_id_seq'), 2, 34.2, now(), 1, 1),
       (nextval('minigame_scores_score_id_seq'), 2, 15, now(), 2, 1),
       (nextval('minigame_scores_score_id_seq'), 1, 45, now(), 3, 1),
       (nextval('minigame_scores_score_id_seq'), 6, 10, now(), 2, 1),
       (nextval('minigame_scores_score_id_seq'), 10, 50.3, now(), 2, 1);

insert into memorycards
values (nextval('memorycards_memory_id_seq'), 'MiniGameSprites/Memory/image_01', 1),
       (nextval('memorycards_memory_id_seq'), 'MiniGameSprites/Memory/image_02', 1),
       (nextval('memorycards_memory_id_seq'), 'MiniGameSprites/Memory/image_03', 1),
       (nextval('memorycards_memory_id_seq'), 'MiniGameSprites/Memory/image_01', 2),
       (nextval('memorycards_memory_id_seq'), 'MiniGameSprites/Memory/image_02', 2),
       (nextval('memorycards_memory_id_seq'), 'MiniGameSprites/Memory/image_03', 2),
       (nextval('memorycards_memory_id_seq'), 'MiniGameSprites/Memory/image_01', 3),
       (nextval('memorycards_memory_id_seq'), 'MiniGameSprites/Memory/image_02', 3),
       (nextval('memorycards_memory_id_seq'), 'MiniGameSprites/Memory/image_03', 3),

       (nextval('memorycards_memory_id_seq'), 'MiniGameSprites/Memory/image_01', 4),
       (nextval('memorycards_memory_id_seq'), 'MiniGameSprites/Memory/image_02', 4),
       (nextval('memorycards_memory_id_seq'), 'MiniGameSprites/Memory/image_03', 4),
       (nextval('memorycards_memory_id_seq'), 'MiniGameSprites/Memory/image_01', 5),
       (nextval('memorycards_memory_id_seq'), 'MiniGameSprites/Memory/image_02', 5),
       (nextval('memorycards_memory_id_seq'), 'MiniGameSprites/Memory/image_03', 5),
       (nextval('memorycards_memory_id_seq'), 'MiniGameSprites/Memory/image_01', 6),
       (nextval('memorycards_memory_id_seq'), 'MiniGameSprites/Memory/image_02', 6),
       (nextval('memorycards_memory_id_seq'), 'MiniGameSprites/Memory/image_03', 6);
