-- Create dummy data

INSERT INTO event (name, description, user_slots, remaining_slots, interval, start_date, duration)
VALUES ('Le jeudi c''est padel !', 'Padel hebdo !', 8, 4, 20.0, '2021-02-25 18:00:00', 2.0),
       ('Evenement spécial', 'Tournoi de la mort qui tue', 30, 0, 1.0, '2021-02-27 10:00:00', 6.0),
       ('Tournoi de la mifa', 'Petit tournoi entre gens sympas', 12, 12, 1.0, '2021-03-03 10:00:00', 4.0);

INSERT INTO corpo_user (mail, name)
VALUES ('titi.lolilol@gprout.com', 'Tib'),
       ('max.pgm@superman.live', 'Max'),
       ('theo.sports@itsinthe.game', 'Théo');

INSERT INTO corporation (name, sport)
VALUES ('Décathlon Padel', 'Padel');
