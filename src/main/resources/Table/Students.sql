create table students(
	id serial primary key, 
	name varchar(255), 
	course int,
	rating real
);
insert into students(name, course, rating)
values('Иванов Андрей', 4, 8.5);
select * from students;
update students set course = 5;
select * from students;
delete from students;
select * from students;
