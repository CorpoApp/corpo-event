CREATE SCHEMA corpo_event_db;
set search_path TO corpo_event_db;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS citext;

CREATE TABLE event(
	event_id uuid DEFAULT uuid_generate_v4 () PRIMARY KEY NOT NULL,
	name VARCHAR(255),
	description CITEXT,
	user_slots INTEGER,
    interval DECIMAL,
    start_date DATE
);

CREATE TABLE users(
	mail VARCHAR(80) PRIMARY KEY NOT NULL,
	name VARCHAR(50)
);

CREATE TABLE registered(
    event_id uuid references event NOT NULL,
    mail VARCHAR(80)references users NOT NULL,
    date DATE,
    PRIMARY KEY(event_id, mail)
);

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA corpo_event_db TO postgres;
