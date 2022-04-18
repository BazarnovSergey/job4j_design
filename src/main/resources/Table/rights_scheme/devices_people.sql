create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name,price) values ('Sony',7000), ('Alcatel',3500), ('Nokia',9000),
('Samsung',8300), ('Motorola',3900), ('LG',4700);

insert into people(name) values ('Mary'), ('Jon'), ('Mike');

insert into devices_people(device_id, people_id) values (1,1),(4,1);
insert into devices_people(device_id, people_id) values (2,2),(5,2);
insert into devices_people(device_id, people_id) values (3,3),(6,3);

select avg(price) from devices;

select p.name, avg(d.price) from devices_people as dp
join devices as d on dp.device_id = d.id
join people as p on dp.people_id = p.id
group by p.name;

select p.name, avg(d.price) from devices_people as dp
join devices as d on dp.device_id = d.id
join people as p on dp.people_id = p.id
group by p.name
having avg(d.price) > 5000;