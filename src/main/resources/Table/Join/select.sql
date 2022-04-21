/*Выполнить запросы с left, rigth, full, cross соединениями*/

select * from departments d
left join employees e
on d.id=e.department_id;

select * from departments d
right join employees e
on d.id=e.department_id;

select * from departments d
full join employees e
on d.id=e.department_id;

select * from departments d
cross join employees e;

/*Используя left join найти департаменты, у которых нет работников*/

select * from departments d
left join employees e
on d.id=e.department_id
where e.department_id is null;

/*Используя left и right join написать запросы, которые давали бы одинаковый результат
 (порядок вывода колонок в эти запросах также должен быть идентичный).*/

select d.id,d.name,e.id,e.name,e.department_id from departments d
left join employees e
on d.id=e.department_id;

select d.id,d.name,e.id,e.name,e.department_id from employees e
right join departments d
on e.department_id=d.id;