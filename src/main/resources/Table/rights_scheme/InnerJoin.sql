create table sick_list(
    id serial primary key,
    insurance_number varchar(20),
	job varchar(255)
);

create table patient(
    id serial primary key,
    name varchar(255),
    sick_list_id int references sick_list(id) unique
);

insert into sick_list(insurance_number, job) values ('2345687654', 'Leroy Merlin');
insert into sick_list(insurance_number, job) values ('1247563421', 'Auchan');
insert into sick_list(insurance_number, job) values ('3248546434', 'PepsiCo');
insert into sick_list(insurance_number, job) values ('7654213125', 'IKEA');

insert into patient(name, sick_list_id) values ('Andrey', 1);
insert into patient(name, sick_list_id) values ('Maria', 2);
insert into patient(name, sick_list_id) values ('Vladimir', 3);
insert into patient(name, sick_list_id) values ('Ivan', 4);
insert into patient(name) values ('Arseniy');
insert into patient(name) values ('Svetlana');

select pc.name as Имя, sl.insurance_number as Страховой_номер, 
sl.job as Работа from patient as pc 
join sick_list as sl 
on pc.sick_list_id = sl.id;

select pc.name as Имя, sl.insurance_number as Страховой_номер, 
sl.job as Работа from patient as pc 
join sick_list as sl 
on pc.sick_list_id = sl.id
where sl.insurance_number like '%4';

select pc.name as Имя, sl.insurance_number as Страховой_номер, 
sl.job as Работа from patient as pc 
join sick_list as sl 
on pc.sick_list_id = sl.id
where sl.job like '%Auchan%';