create table tools(
                      id int primary key,
                      title varchar,
                      date date,
                      count int,
                      price integer,
                      need_delivery boolean
);

alter table tools ALTER COLUMN price TYPE money;

insert into tools(id, title, date, count, price, need_delivery)
VALUES(1,'milk','19-05-2024',1,2.2,false),
      (2,'meat','19-05-2024',3,15,true),
      (3,'cheese','19-05-2024',2,18.5,null);


drop table tools;