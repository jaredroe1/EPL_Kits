DROP TABLE IF EXISTS jerseys_numbers;
DROP TABLE IF EXISTS jerseys_names;
DROP TABLE IF EXISTS jerseys_sizes;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS sizes;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS teams;
DROP TABLE IF EXISTS names;
DROP TABLE IF EXISTS numbers;
DROP TABLE IF EXISTS shoes;
DROP TABLE IF EXISTS jerseys;
DROP TABLE IF EXISTS shorts;
DROP TABLE IF EXISTS trainers;
CREATE TABLE trainers
(
	trainers_pk int unsigned NOT NULL AUTO_INCREMENT,
	trainers_id varchar (30) NOT NULL,
	price decimal
	(
		5,
		2
	)
	NOT NULL,
	PRIMARY KEY (trainers_pk),
	unique key (trainers_id)
);
CREATE TABLE shorts
(
	shorts_pk int unsigned NOT NULL AUTO_INCREMENT,
	shorts_id varchar (30) NOT NULL,
	price decimal
	(
		5,
		2
	)
	NOT NULL,
	PRIMARY KEY (shorts_pk),
	UNIQUE KEY (shorts_id)
);
CREATE TABLE jerseys
(
	jerseys_pk int unsigned NOT NULL AUTO_INCREMENT,
	jerseys_id varchar (30) NOT NULL,
	numbers_fk int,
	names_fk varchar (30),
	price decimal
	(
		5,
		2
	)
	NOT NULL,
	PRIMARY KEY (jerseys_pk),
	UNIQUE KEY (jerseys_id)	
);
CREATE TABLE shoes
(
	shoes_pk int unsigned NOT NULL AUTO_INCREMENT,
	shoes_type varchar (20),
	shoes_id varchar (60) NOT NULL,
	price decimal
	(
		5,
		2
	)
	NOT NULL,
	PRIMARY KEY (shoes_pk),
	UNIQUE KEY (shoes_id)
);
CREATE TABLE numbers
(
	numbers_pk int unsigned NOT NULL AUTO_INCREMENT,
	numbers_position varchar (20),
	numbers_id int NOT NULL,
		price decimal
	(
		5,
		2
	)
	NOT NULL,
	PRIMARY KEY (numbers_pk),
	UNIQUE KEY (numbers_id)
);
CREATE TABLE names
(
	names_pk int unsigned NOT NULL AUTO_INCREMENT,
	names_league varchar (20),
	names_id varchar (30) NOT NULL,
		price decimal
	(
		5,
		2
	)
	NOT NULL,
	PRIMARY KEY (names_pk),
	UNIQUE KEY (names_id)
);
CREATE TABLE teams
(	
	teams_pk int unsigned NOT NULL AUTO_INCREMENT,
	teams_country varchar (30),
	teams_id varchar (30) NOT NULL,	
	PRIMARY KEY (teams_pk),
	UNIQUE KEY (teams_id)
);
CREATE TABLE users
(
	users_pk int unsigned NOT NULL AUTO_INCREMENT,
	users_id varchar (40) NOT NULL,
	first_name varchar (40) NOT NULL,
	last_name varchar (40) NOT NULL,
	phone varchar (20),
	PRIMARY KEY (users_pk),
	unique key (users_id)
);
CREATE TABLE sizes
(
	sizes_pk int unsigned NOT NULL AUTO_INCREMENT,
	sizes_id varchar (20) NOT NULL,
	price decimal
	(
		5,
		2
	)
	NOT NULL,
	PRIMARY KEY (sizes_pk),
	UNIQUE KEY (sizes_id)
);
CREATE TABLE orders
(
	orders_pk int unsigned NOT NULL AUTO_INCREMENT,
	users_fk varchar (40) NOT NULL,	
	teams_fk varchar (30) NOT NULL,	
	shoes_fk varchar (30) NOT NULL,
	jerseys_fk varchar (30) NOT NULL,
	shorts_fk varchar (30) NOT NULL,
	trainers_fk varchar (30) NOT NULL,	
	price decimal
	(
		6,
		2
	)
	,
	PRIMARY KEY (orders_pk),
	FOREIGN KEY (users_fk) REFERENCES users (users_id) ON DELETE CASCADE,	
	FOREIGN KEY (teams_fk) REFERENCES teams (teams_id) ON DELETE CASCADE,	
	FOREIGN KEY (shoes_fk) REFERENCES shoes (shoes_id) ON DELETE CASCADE,
	FOREIGN KEY (jerseys_fk) REFERENCES jerseys (jerseys_id) ON DELETE CASCADE,
	FOREIGN KEY (shorts_fk) REFERENCES shorts (shorts_id) ON DELETE CASCADE,
	FOREIGN KEY (trainers_fk) REFERENCES trainers (trainers_id) ON DELETE CASCADE	
);
CREATE TABLE jerseys_sizes
(
	sizes_fk int unsigned NOT NULL,
	jerseys_fk int unsigned NOT NULL,
	FOREIGN KEY (sizes_fk) REFERENCES sizes (sizes_pk) ON DELETE CASCADE,
	FOREIGN KEY (jerseys_fk) REFERENCES jerseys (jerseys_pk) ON DELETE CASCADE
);
CREATE TABLE jerseys_names
(
	jerseys_fk int unsigned NOT NULL,
	names_fk int unsigned NOT NULL,
	FOREIGN KEY (jerseys_fk) REFERENCES jerseys (jerseys_pk) ON DELETE CASCADE,
	FOREIGN KEY (names_fk) REFERENCES names (names_pk) ON DELETE CASCADE
);
CREATE TABLE jerseys_numbers
(
	jerseys_fk int unsigned NOT NULL,
	numbers_fk int unsigned NOT NULL,
	FOREIGN KEY (jerseys_fk) REFERENCES jerseys (jerseys_pk) ON DELETE CASCADE,
	FOREIGN KEY (numbers_fk) REFERENCES numbers (numbers_pk) ON DELETE CASCADE
);
