create table car(
    id serial primary key,
    name varchar(255)
);

create table vin(
    id serial primary key,
    number varchar(255)
);

create table car_vin(
    id serial primary key,
    car_id int references car(id) unique,
    vin_id int references vin(id) unique
);