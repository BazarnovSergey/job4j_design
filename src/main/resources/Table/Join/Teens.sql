create table teens (
    id serial primary key,
    name varchar (255),
    gender varchar (10)
);

insert into teens(name,gender) values ('Андрей','male');
insert into teens(name,gender) values ('Дмитрий','male');
insert into teens(name,gender) values ('Мария','female');
insert into teens(name,gender) values ('Кристина','female');
insert into teens(name,gender) values ('Марина','female');

select t1.name, t2.name from teens t1
cross join teens t2
where t1.gender != t2.gender;