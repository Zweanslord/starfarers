-- user
CREATE TABLE User
(
	id			int NOT NULL AUTO_INCREMENT,
	username	VARCHAR(255) NOT NULL UNIQUE,
	password	VARCHAR(255) NOT NULL,
	enabled		bool NOT NULL DEFAULT TRUE,
	PRIMARY KEY(id)
);

-- user roles
CREATE TABLE UserRole
(
	id		int NOT NULL AUTO_INCREMENT,
	role	varchar(255) NOT NULL,
	fk_user	int NOT NULL,
	PRIMARY KEY(id),
	UNIQUE KEY role_user (role, fk_user),
	FOREIGN KEY(fk_user) REFERENCES User(id) ON DELETE CASCADE
);

-- player

CREATE TABLE Player
(
   id       int NOT NULL AUTO_INCREMENT,
   name     varchar(255) NOT NULL UNIQUE,
   active   bool NOT NULL DEFAULT TRUE,
   PRIMARY KEY(id)
);

-- galaxy

CREATE TABLE Galaxy
(
   id       int NOT NULL AUTO_INCREMENT,
   radius   int NOT NULL,
   PRIMARY KEY(id)
);

-- map sectors

CREATE TABLE Sector
(
   id           int NOT NULL AUTO_INCREMENT,
   x            int NOT NULL,
   y            int NOT NULL,
   terrain      varchar(255) NOT NULL,
   starsystem   bool NOT NULL DEFAULT FALSE,
   fk_galaxy    int NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(fk_galaxy) REFERENCES Galaxy(id) ON DELETE CASCADE
);

-- star

CREATE TABLE Star
(
   id          int NOT NULL AUTO_INCREMENT,
   fk_sector   int NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(fk_sector) REFERENCES Sector(id) ON DELETE CASCADE
);

-- planet

CREATE TABLE Planet
(
   id          int NOT NULL AUTO_INCREMENT,
   position    int NOT NULL,
   type        varchar(255) NOT NULL,
   ore         int NOT NULL,
   gas         int NOT NULL,
   fertility   int NOT NULL,
   fk_star     int NOT NULL,
   PRIMARY KEY(id),
   FOREIGN KEY(fk_star) REFERENCES Star(id) ON DELETE CASCADE
);