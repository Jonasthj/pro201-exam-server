insert into quiz
values (1),
       (2),
       (3);

insert into questions
values (1, 'Hva er 2 + 2?', 1),
       (2, 'Hvor er Norge?', 1),
       (3, 'Hvor lang er en mil?', 2);

insert into answers
values (1, '3', false, 1),
       (2, '2', false, 1),
       (3, '4', true, 1),
       (4, '5', false, 1),
       (5, 'I Afrika', false, 2),
       (6, 'I Europa', true, 2),
       (7, 'I Oceania', false, 2),
       (8, 'I Asia', false, 2),
       (9, '1km', false, 3),
       (10, '2km', false, 3),
       (11, '3km', false, 3),
       (12, '1.6km', true, 3);