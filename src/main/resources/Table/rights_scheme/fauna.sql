create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(id,name,avg_age,discovery_date) values (1,'fish',1000000, '05.03.1900');
insert into fauna(id,name,avg_age,discovery_date) values (2,'dog',80000, '06.02.1754');
insert into fauna(id,name,avg_age,discovery_date) values (3,'pig',7000, '12.11.1693');
insert into fauna(id,name,avg_age,discovery_date) values (4,'sheep',14000, '07.09.1989');
insert into fauna(id,name,avg_age,discovery_date) values (5,'cow',90000, null);
insert into fauna(id,name,avg_age,discovery_date) values (6,'duck',25000, '03.07.1650');
insert into fauna(id,name,avg_age,discovery_date) values (7,'chicken',45000, '02.08.1737');

select * from fauna;
select id,name,avg_age,discovery_date from fauna where name like '%fish%';
select id,name,avg_age,discovery_date from fauna where avg_age > 10000 and avg_age < 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '01.01.1950';