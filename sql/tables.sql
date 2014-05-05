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
	fk_galaxy int not null,
	primary key (id),
	foreign key (fk_galaxy) references galaxy (id) on delete cascade
);