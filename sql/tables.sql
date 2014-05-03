-- player
create table player (
	id int not null auto_increment,
	name varchar(255) not null unique,
	active bool not null default true,
	primary key (id)
);