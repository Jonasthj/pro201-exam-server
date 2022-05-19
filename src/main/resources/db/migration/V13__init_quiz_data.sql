insert into quiz
values (1),
       (2),
       (3);

insert into questions
values (1, 'What is 2 + 2?', 1),
       (2, 'Where is Norway?', 1),
       (3, 'How far is one mile?', 2);

insert into answers
values (1, '3', false, 1),
       (2, '2', false, 1),
       (3, '4', true, 1),
       (4, 'In Africa', false, 2),
       (5, 'In Europe', true, 2),
       (6, 'In Asia', false, 2);