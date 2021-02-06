-- Create TABLES

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS citext;

CREATE TABLE event(
	id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
	name VARCHAR(255),
	description CITEXT,
	user_slots INTEGER,
    remaining_slots INTEGER,
    interval DECIMAL,
    start_date TIMESTAMP,
    duration DECIMAL
);

CREATE TABLE corpo_user(
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
	mail VARCHAR(80) UNIQUE,
	name VARCHAR(50)
);

CREATE TABLE registered(
    event_id uuid references event DEFAULT uuid_generate_v4 (),
    user_id uuid references corpo_user NOT NULL,
    date TIMESTAMP,
    PRIMARY KEY(event_id, user_id)
);

CREATE TABLE corporation(
    id uuid PRIMARY KEY DEFAULT uuid_generate_v4 (),
    name VARCHAR(80) UNIQUE,
	sport VARCHAR(80)
);

CREATE TABLE corporation_users(
  corporation_id uuid NOT NULL,
  corpo_user_id uuid NOT NULL,
  PRIMARY KEY (corporation_id,corpo_user_id),
  CONSTRAINT corporation_users_ibfk_1
   FOREIGN KEY (corporation_id) REFERENCES corporation (id),
  CONSTRAINT corporation_users_ibfk_2
   FOREIGN KEY (corpo_user_id) REFERENCES corpo_user (id)
);

-- Keycloak init sql

CREATE DATABASE keycloak;
CREATE USER keycloak WITH PASSWORD '8u8]?gDu(.S5U_Ky';
GRANT ALL PRIVILEGES ON DATABASE keycloak TO keycloak;

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
