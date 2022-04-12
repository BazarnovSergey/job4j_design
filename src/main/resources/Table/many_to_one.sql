create table stipend(
    id serial primary key,
    sum int
);

create table students(
    id serial primary key,
    name varchar(255),
    stipend_id int references stipend(id)
);


