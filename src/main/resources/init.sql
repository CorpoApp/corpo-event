CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS citext;

CREATE TABLE event(
	id uuid PRIMARY KEY NOT NULL,
	name VARCHAR(255),
	description CITEXT,
	user_slots INTEGER,
    remaining_slots INTEGER,
    interval DECIMAL,
    start_date TIMESTAMP,
    duration DECIMAL
);

CREATE TABLE corpo_user(
    id uuid PRIMARY KEY NOT NULL,
	mail VARCHAR(80) UNIQUE,
	name VARCHAR(50)
);

CREATE TABLE registered(
    event_id uuid references event NOT NULL,
    user_id uuid references corpo_user NOT NULL,
    date TIMESTAMP,
    PRIMARY KEY(event_id, user_id)
);

CREATE TABLE corporation(
    id uuid PRIMARY KEY NOT NULL,
    name VARCHAR(80) UNIQUE,
	sport VARCHAR(80)
);
