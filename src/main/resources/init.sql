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
