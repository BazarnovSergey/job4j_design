select * from product 
join type on product.type_id= type.id
where type.name = 'СЫР';

select * from product 
where name like '%мороженое%';

select * from product 
where expired_date < now();

select * from product order by price desc limit 1;

select t.name as имя_типа, count(*) as количество
from product as p
join type as t
on p.type_id=t.id
group by t.name;

select p.* from product as p
join type as t
on p.type_id = t.id
where t.name = 'СЫР' or t.name = 'МОЛОКО';

select t.name as type from product as p
join type as t
on p.type_id = t.id
group by t.name
having count(*) < 10;

select p.*, t.name from product as p
join type as t
on p.type_id = t.id