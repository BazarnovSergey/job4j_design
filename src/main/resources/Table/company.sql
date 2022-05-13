/*
1. В одном запросе получить
- имена всех person, которые не состоят в компании с id = 5;
- название компании для каждого человека.
*/
select p.name as person_name, c.name as company_name
from person as p
join company as c
on p.company_id = c.id
where company_id != 5;

/*
2. Необходимо выбрать название компании с максимальным количеством человек
+ количество человек в этой компании
(нужно учесть, что таких компаний может быть несколько).
*/
select c.name, count(p.company_id) from company as c
join person as p
on p.company_id = c.id
group by c.name
having count(p.company_id) =
(select count(company_id) from person
group by company_id
order by count(company_id) desc limit 1);