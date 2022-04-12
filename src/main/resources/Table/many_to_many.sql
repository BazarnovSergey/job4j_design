create table books(
     id serial primary key,
     name varchar(255)
 );
 
create table readers(
     id serial primary key,
     name varchar(255)
 );
 
create table books_readers(
     id serial primary key,
     books_id int references books(id),
     readers_id int references readers(id)
 );