insert into minigames
values (1, 'Memo game'),
       (2, 'Saw game'),
       (3, 'Word finder'),
       (4, 'History sorter');

insert into minigame_scores
values (nextval('minigame_scores_score_id_seq'), 4, 34.2, 1, 1),
       (nextval('minigame_scores_score_id_seq'), 2, 15, 2, 1),
       (nextval('minigame_scores_score_id_seq'), 1, 45, 3, 2),
       (nextval('minigame_scores_score_id_seq'), 6, 10, 2, 2),
       (nextval('minigame_scores_score_id_seq'), 10, 50.3, 2, 3);

insert into minigame_rounds
values (1, 1, 1, 1),
       (2, 3, 1, 2),
       (3, 4, 1, 1);

insert into memorycards
values (nextval('memorycards_memory_id_seq'), 'memory_card_1_uri', 1),
       (nextval('memorycards_memory_id_seq'), 'memory_card_1_uri', 1),
       (nextval('memorycards_memory_id_seq'), 'memory_card_2_uri', 1),
       (nextval('memorycards_memory_id_seq'), 'memory_card_2_uri', 1),
       (nextval('memorycards_memory_id_seq'), 'memory_card_3_uri', 1),
       (nextval('memorycards_memory_id_seq'), 'memory_card_3_uri', 1),
       (nextval('memorycards_memory_id_seq'), 'memory_card_4_uri', 1),
       (nextval('memorycards_memory_id_seq'), 'memory_card_4_uri', 1),
       (nextval('memorycards_memory_id_seq'), 'memory_card_5_uri_joker', 1);

insert into histories
values (nextval('histories_history_id_seq'), 'Brann i låven', 'Låven brant ned en trist tirsdags ettermiddag...', 1700,
        true, 3),
       (nextval('histories_history_id_seq'), 'Brann i låven', 'Låven brant ned en trist tirsdags ettermiddag...', 1700,
        true, 3);

insert into words
values (nextval('words_word_id_seq'), 'sag', 2),
       (nextval('words_word_id_seq'), 'test', 2),
       (nextval('words_word_id_seq'), 'tre', 2);
