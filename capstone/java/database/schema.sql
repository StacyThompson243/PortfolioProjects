BEGIN TRANSACTION;

DROP TABLE IF EXISTS volunteers, users, adopter, pets;

CREATE TABLE volunteers  (
application_id SERIAL,
name varchar(100) NOT NULL,
email varchar(50) NOT NULL,
over_18 boolean NOT NULL,
role varchar(20),
status varchar(15) NOT NULL,
CONSTRAINT PK_volunteers PRIMARY KEY (application_id)
);

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(10) NOT NULL,
	application_id int,
	CONSTRAINT PK_user PRIMARY KEY (user_id),
	CONSTRAINT FK_user FOREIGN KEY (application_id) REFERENCES volunteers (application_id)
);

CREATE TABLE adopter (
adopter_id SERIAL,
adopter_name varchar(100) NOT NULL,
CONSTRAINT PK_adopter PRIMARY KEY (adopter_id)
);

CREATE TABLE pets (
pet_id SERIAL,
pet_image varchar(500),
name varchar(70) NOT NULL,
type varchar(70) NOT NULL,
age int NOT NULL,
gender varchar(70) NOT NULL,
weight int NOT NULL,
breed varchar(70) NOT NULL,
description varchar(1000) NOT NULL,
adopted boolean NOT NULL,
adopter_id int,
CONSTRAINT PK_pets PRIMARY KEY (pet_id),
CONSTRAINT FK_pets FOREIGN KEY (adopter_id) REFERENCES adopter (adopter_id)
);

COMMIT TRANSACTION;
