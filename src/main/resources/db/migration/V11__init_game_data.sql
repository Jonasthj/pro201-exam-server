insert into sessions
values ('1234567'),
       ('1111111');

insert into players
values (nextval('players_player_id_seq'), 'Jonas', 0, '1234567'),
       (nextval('players_player_id_seq'), 'Martin', 2, '1234567'),
       (nextval('players_player_id_seq'), 'Alex', 6, '1111111');