insert into quiz
values (1, 1),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 1),
       (6, 1),
       (7, 1);

insert into questions
values (1, 'Hvor kan man finne andre hulveier?', 1),
       (2, 'Hva ble hulveiene brukt til?', 1),
       (3, 'Hva gjorde man hvis hulveien ble slitt?', 1),

       (4, 'Hva er et kvernhus?', 2),
       (5, 'Hva er en mølle?', 2),
       (6, 'Hvor er en mølle/kvernhus plassert?', 2),

       (7, 'Hvilken type sag lå her?', 3),
       (8, 'Hva betyr tuft?', 3),
       (9, 'Til øst for ruinen ligger det stokker under vann, hvorfor er disse her?', 3),

       (10, 'Her er alle spor etter det som var her forsvunnet. Klarer dere å gjette hva som lå her?', 4),
       (11, 'Hva heter bekken / elven som er rett ved deg?', 4),
       (12, 'Hvilken tidsperiode er ruinene fra?', 4),

       (13, 'Hva er disse murveggene rester etter?', 5),
       (14, 'Hvor lang tror du at steinveggen er på det lengste?', 5),
       (15, 'På muren er det et grønt belegg, hva heter dette? ', 5),

       (16, 'I hvilken himmelretning ser det ut som at ruinen har en åpning?', 6),
       (17, 'Hvorfor er de fleste steinene borte fra ruinen?', 6),
       (18, 'Hvor mange pilarer besto denne sagruinen av? ', 6),

       (19, 'Ved denne posten er det gjort mange løsfunn og blant de er et såkalt "bakhon", hva er dette?', 7),
       (20, 'Bøndene ga gradvis opp på sagbrukdrift på 1600- tallet, hvorfor det?', 7),
       (21, 'Hvor mange sager skal det til sammen ha vært langs byåa?', 7);

insert into answers
values (1, 'Hulveier er svært sjeldent, og det finnes kun to i Europa', false, 1),
       (2, 'Man finner kun hulveier i Norge', false, 1),
       (3, 'Hulveier er funnet over hele Europa', true, 1),
       (4, 'Hulveier finnes overalt i verden og brukes fremdeles i dag', false, 1),

       (5, 'Kjøring med bil', false, 2),
       (6, 'Frakt av last, gjerne med hund, hest eller slede', true, 2),
       (7, 'Til hesteløp', false, 2),
       (8, 'Til hundeløp', false, 2),

       (9, 'Man flyttet veien litt til siden for å unngå for bratt vei', true, 3),
       (10, 'Man lagde en annen vei et annet sted', false, 3),
       (11, 'Man gravde ut sidene for å gjøre veien mer stabil', false, 3),
       (12, 'Man måtte klare seg uten noen form for vei', false, 3),

       (13, 'Et hus der korn ble malt', true, 4),
       (14, 'Et hus der man kverner kjøtt', false, 4),
       (15, 'Et hus der man lagrer mat', false, 4),
       (16, 'Et hus der man sager treverk', false, 4),

       (17, 'Et sted der man kunne løpe og trene', false, 5),
       (18, 'Et sted der man samlet inn all mat for vinteren', false, 5),
       (19, 'Et sted der man lagde båter', false, 5),
       (20, 'Et sted der man kan finknuse noe, gjerne korn til mel', true, 5),

       (21, 'Et godt stykke unna vannet', false, 6),
       (22, 'Litt oppe i høyden for å få mer vind', false, 6),
       (23, 'Ved rennende vann', true, 6),
       (24, 'Ved stillestående vann', false, 6),

       (25, 'Vannsag', true, 7),
       (26, 'Vindsag', false, 7),
       (27, 'Steinsag', false, 7),
       (28, 'Diamantsag', false, 7),

       (29, 'En spesiell type sag', false, 8),
       (30, 'Et sagehus', false, 8),
       (31, 'Grunnmuren til et bygg', true, 8),
       (32, 'Taket til en vannsag', false, 8),

       (33, 'Stokker som har satt seg fast under vann', false, 9),
       (34, 'For å frakte treverk', true, 9),
       (35, 'Rester etter en gammel bro', false, 9),
       (36, 'Rester etter en gammel demning', false, 9),

       (37, 'Vannsag', true, 10),
       (38, 'Kvernhus', false, 10),
       (39, 'Mølle', false, 10),
       (40, 'Bolig', false, 10),

       (41, 'Kurlandsbekken', false, 11),
       (42, 'Gjellebekken', false, 11),
       (43, 'Ramstadbekken', false, 11),
       (44, 'Byåa', true, 11),

       (45, 'Middelalderen', false, 12),
       (46, 'Etterreformatorisk tid', true, 12),
       (47, 'Antikken', false, 12),
       (48, 'Renessansen', false, 12),

       (49, 'Sagbruk', true, 13),
       (50, 'Mølle', false, 13),
       (51, 'Kvernhus', false, 13),
       (52, 'Bolig', false, 13),

       (53, '14 meter', false, 13),
       (54, '16 meter', false, 13),
       (55, '13 meter', false, 13),
       (56, '15 meter', true, 13),

       (57, 'Mose', true, 14),
       (58, 'Gress', false, 14),
       (59, 'Lav', false, 14),
       (60, 'Never', false, 14),

       (61, 'Never', false, 15),
       (62, 'Never', false, 15),
       (63, 'Never', false, 15),
       (64, 'Never', false, 15),

       (65, 'Øst', false, 16),
       (66, 'Vest', false, 16),
       (67, 'Nord', true, 16),
       (68, 'Sør', false, 16),

       (69, 'Vær og vind har ført dem bort', false, 17),
       (70, 'Tyngden har ført dem under bakken', false, 17),
       (71, 'De har falt ut i elven', false, 17),
       (72, 'De har blitt gjenbrukt andre steder', true, 17),

       (73, 'Fem', false, 18),
       (74, 'Fire', true, 18),
       (75, 'Tre', false, 18),
       (76, 'Seks', false, 18),

       (77, 'Det ytterste stykket på trestokken, etter den er kuttet til plank', true, 19),
       (78, 'Et sagblad som var brukt i de gamle vannsagene', false, 19),
       (79, 'En gammel type skiftenøkkel', false, 19),
       (80, 'En gammel type hammer', false, 19),

       (81, 'Byfolket i Kristiania tok over driften og det ble strengere statlige regler.', true, 20),
       (82, 'Treprisen var lav, så de tjente mindre penger', false, 20),
       (83, 'Det ble dårligere vannføring i elvene', false, 20),
       (84, 'Veiene i området ble for dårlige til å frakte utstyr', false, 20),

       (85, '6', false, 21),
       (86, '8', false, 21),
       (87, '7', true, 21),
       (88, '5', false, 21);