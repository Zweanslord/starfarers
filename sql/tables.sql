-- player
create table player (
	id int not null auto_increment,
	name varchar(255) not null unique,
	active bool not null default true,
	primary key (id)
);

-- galaxy
create table galaxy (
	id int not null auto_increment,
	radius int not null,
	primary key (id)
);

-- map sectors
create table sector (
	id int not null auto_increment,
	x int not null,
	y int not null,
	terrain varchar(255) not null,
	starsystem bool not null default false,
	fk_galaxy int not null,
	primary key (id),
	foreign key (fk_galaxy) references galaxy (id) on delete cascade
);

-- star
create table star (
	id int not null auto_increment,
	fk_sector int not null,
	primary key (id),
	foreign key (fk_sector) references sector (id) on delete cascade
);

-- planet
create table planet (
	id int not null auto_increment,
	position int not null,
	type varchar(255) not null,
	ore int not null,
	gas int not null,
	fertility int not null,
	fk_star int not null,
	primary key (id),
	foreign key (fk_star) references star (id) on delete cascade
);