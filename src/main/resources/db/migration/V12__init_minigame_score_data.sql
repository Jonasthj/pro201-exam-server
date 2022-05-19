insert into minigames
values (1, 'Memo game'),
       (2, 'Saw game'),
       (3, 'Word finder');

insert into minigame_scores
values (nextval('minigame_scores_score_id_seq'), 4, 34.2, 1, 1),
       (nextval('minigame_scores_score_id_seq'), 2, 15, 2, 1),
       (nextval('minigame_scores_score_id_seq'), 1, 45, 3, 2),
       (nextval('minigame_scores_score_id_seq'), 6, 10, 2, 2),
       (nextval('minigame_scores_score_id_seq'), 10, 50.3, 2, 3);