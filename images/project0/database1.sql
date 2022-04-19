create table boba(
id serial primary key,
flavor_name varchar(20),
price_ integer
);

create table customer (
id serial primary key,
customer_name varchar(50)
);

create table customer_boba (
boba_id integer references boba(id),
customer_id integer references customer(id)
--primary key boba_id, customer_id 
);

alter table customer_boba  add primary key(boba_id,customer_id);

insert into boba (flavor_name, price_) values ('mango',10),('Mocha',12),('strawberry',8);

insert into customer (customer_name) values ('Allen'),('Hector'),('Dipesh'),('David'),('Keith'),('Chris')
;
insert into customer_boba values (1,1),(1,2),(1,3),(1,6),(2,3),(2,4),(2,5),(3,2);

select * from boba;

select flavor_name from boba where id = 2;

select * from customer_boba;

