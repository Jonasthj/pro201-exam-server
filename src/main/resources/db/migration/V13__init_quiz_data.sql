insert into quiz
values (1),
       (2),
       (3);

insert into questions
values (1, 'What is 2 + 2?', 1),
       (2, 'Where is Norway?', 1),
       (3, 'How far is one mile?', 2);

insert into answers
values (1, '3', 1),
       (2, '2', 1),
       (3, '4', 1),
       (4, 'In Africa', 2),
       (5, 'In Europe', 2),
       (6, 'In Asia', 2);

insert into correct_answers
values (nextval('correct_answers_correct_answer_id_seq'), 1, 3),
       (nextval('correct_answers_correct_answer_id_seq'), 2, 5);