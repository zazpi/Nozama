insert into productModel (name,description,weight,x,y,z) values ('A','desc',0,0,0,0);
insert into productModel (name,description,weight,x,y,z) values ('B','desc',0,0,0,0);
insert into productModel (name,description,weight,x,y,z) values ('C','desc',0,0,0,0);
insert into productModel (name,description,weight,x,y,z) values ('D','desc',0,0,0,0);

insert into orders (origin,destination,entryDate,departureDate) values (31810, 31800,current_timestamp,current_timestamp);
insert into ordersProducts values(1,1);
insert into ordersProducts values(1,2);
insert into ordersProducts values(1,4);
