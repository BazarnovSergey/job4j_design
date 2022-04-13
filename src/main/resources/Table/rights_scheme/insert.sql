insert into roles(name) values('administrator');
insert into roles(name) values('user');
insert into roles(name) values('operator');

insert into users(name,email,phone,role_id) values ('Jon', 'jon@gmail.com','+7376235678',1);
insert into users(name,email,phone,role_id) values ('Bob', 'bob@gmail.com','+7365432678',2);
insert into users(name,email,phone,role_id) values ('Mike', 'mik@gmail.com','+7113321345',3);

insert into rules (name) values ('create');
insert into rules (name) values ('read');
insert into rules (name) values ('update');
insert into rules (name) values ('delete');

insert into roles_rules (role_id, rule_id) values (1, 1);
insert into roles_rules (role_id, rule_id) values (1, 2);
insert into roles_rules (role_id, rule_id) values (1, 3);
insert into roles_rules (role_id, rule_id) values (1, 4);
insert into roles_rules (role_id, rule_id) values (2, 1);
insert into roles_rules (role_id, rule_id) values (2, 2);
insert into roles_rules (role_id, rule_id) values (2, 3);
insert into roles_rules (role_id, rule_id) values (3, 3);

insert into states(name) values ('Done');
insert into states(name) values ('Waiting');

insert into categories(name) values('Red');
insert into categories(name) values('Yellow');
insert into categories(name) values('Green');

insert into items(items_name,description text,user_id,category_id,state_id)
values('question','Why is the Internet not working?',1,3,1);

insert into items(items_name,description text,user_id,category_id,state_id)
values('complaint','Low loading speed',2,2,2);

insert into items(items_name,description text,user_id,category_id,state_id)
values('question','How much does the service cost?',3,3,1);

insert into comments(comments_text, item_id)values('application accepted',2);

insert into attaches(path, item_id)values('item.jpeg',1);