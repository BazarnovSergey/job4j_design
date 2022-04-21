insert into bodyes(type) values ('truck');
insert into bodyes(type) values ('minivan');
insert into bodyes(type) values ('cabriolet');
insert into bodyes(type) values ('limousine');
insert into bodyes(type) values ('coupe');
insert into bodyes(type) values ('crossover');

insert into engines (type) values ('1.6');
insert into engines (type) values ('2.4');
insert into engines (type) values ('V6');
insert into engines (type) values ('V12');

insert into transmissions (type) values ('manual');
insert into transmissions (type) values ('automatic');
insert into transmissions (type) values ('CVT');
insert into transmissions (type) values ('DCT');
insert into transmissions (type) values ('IVT');

insert into cars (name,id_body,id_engine,id_transmission) 
values ('Volvo',1,4,2);
insert into cars (name,id_body,id_engine,id_transmission) 
values ('Audi',2,2,2);
insert into cars (name,id_body,id_engine,id_transmission) 
values ('Chevrolet',3,1,null);
insert into cars (name,id_body,id_engine,id_transmission) 
values ('BMW',4,3,3);
insert into cars (name,id_body,id_engine,id_transmission) 
values ('Cadillac',5,null,4);
insert into cars (name,id_body,id_engine,id_transmission) 
values ('Ford',6,1,1);