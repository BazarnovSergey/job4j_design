select c.name name, b.type body, e.type engine, t.type transmission
from cars c  
left join bodyes b on c.id_body = b.id
left join engines e on c.id_engine = e.id
left join transmissions t on c.id_transmission = t.id; 

select type, c.name name
from bodyes b 
left join cars c on c.id_body = b.id
where c.id_body is null;

select type, c.name name
from transmissions t 
left join cars c on c.id_transmission = t.id
where c.id_transmission is null;

select type, c.name name
from engines e  
left join cars c on c.id_engine = e.id
where c.id_engine is null;