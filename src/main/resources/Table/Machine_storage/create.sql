create table bodyes(
	id serial primary key,
	type varchar(255)
);

create table engines(
	id serial primary key,
	type varchar(255)
);

create table transmissions(
	id serial primary key,
	type varchar(255)
);

create table cars(
	id serial primary key,
	name varchar(255),
	id_body int references bodyes(id),
	id_engine int references engines(id),
	id_transmission int references transmissions(id)
);