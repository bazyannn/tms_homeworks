create table persons(
    id int primary key,
    name varchar,
    sex varchar,
    birthday date
);

create table hobbies(
    id int primary key,
    title varchar,
    type varchar,
    type_hobby_id int,
    constraint type_hobby_fk foreign key (type_hobby_id) references type_hobby(id)
);

create table type_hobby(
    id int primary key,
    name_type varchar
);

create table persons_hobby(
    id int primary key,
    person_id int,
    hobby_id int,
    constraint persons_fk foreign key (person_id) references persons(id),
    constraint hobbies_fk foreign key (hobby_id) references hobbies(id)
);

insert into type_hobby (id, name_type)
VALUES (1,'active'),
       (2,'passive');

insert into hobbies (id, title, type, type_hobby_id)
VALUES (1,'football','a',1),
       (2,'volleyball','a',1),
       (3,'read','p',2),
       (4,'chess','p',2),
       (5,'motosport','a',1);

insert into persons (id, name, sex, birthday)
VALUES (1,'Ivan','man','2000-05-22'),
       (2,'Vlad','man','1999-05-04'),
       (3,'Andrey','man','1977-08-08'),
       (4,'Mariya','woman','2002-01-16'),
       (5,'Elena','woman','1984-04-25'),
       (6,'Olga','woman','1990-03-17'),
       (7,'Petya','man','1985-11-14'),
       (8,'Denis','man','1989-12-31'),
       (9,'Ignat','man','1991-12-04'),
       (10,'Tanya','woman','1979-09-03');

insert into persons_hobby (id, person_id, hobby_id)
VALUES (1,1,null),
       (2,2,1),
       (3,3,5),
       (4,3,3),
       (5,4,4),
       (6,5,2),
       (7,6,2),
       (8,7,4),
       (9,8,5),
       (10,9,2),
       (11,10,3),
       (12,10,4);

drop table persons_hobby;

drop table type_hobby;

drop table type_hobby;

drop table hobbies cascade;

drop table persons;

-- Вывести всех людей старше какого-либо возраста
select * from persons where birthday > '1990-01-01'; --  старше 1989(1 вариант)

select * from persons where date_part('year', birthday) > '1989'; --  старше 1989(2 вариант)

-- Вывести сколько людей каждого пола есть в бд
select sex,count(*) from persons group by sex;

--     Вывести информацию о людях и их хобби
select p.*, h.title from persons p left join persons_hobby ph on p.id = ph.person_id
                                   left join hobbies h on ph.hobby_id = h.id;           -- будет Ivan(null)

select p.name, h.title from persons p join persons_hobby ph on p.id = ph.person_id
                                      join hobbies h on ph.hobby_id = h.id;                -- не будет Ivan(null)

-- Вывести список людей у которых более одного хобби
select p.name,count(ph.hobby_id) from persons p join persons_hobby ph on p.id = ph.person_id
                                 group by p.name having count(ph.hobby_id) > 1;           -- имя + кол-во хобби более 1

select p.* from persons p left join persons_hobby ph on p.id = ph.person_id
           group by p.id having count(ph.hobby_id) > 1 order by p.id;      -- полная инфа о людях, у которых более одного хобби + сортировка по id

-- Вывести какое количество активных хобби и пассивных хобби есть в бд
select th.name_type,count(*) from hobbies h join type_hobby th on th.id = h.type_hobby_id group by th.name_type;

-- Вывести информацию какое хобби активное а какое пассивное
select h.title, th.name_type from hobbies h join type_hobby th on h.type_hobby_id = th.id;

/*
Создать таблицу для хранения данных о человеке:
	• Имя
	• Пол
	• Дата рождения
Создать вторую таблицу для хранения данных о хобби:
	• Название хобби
	• Тип хобби
Создать третью таблицу для хранения типа хобби
	• Имя типа
Создать четвертую таблицу для хранения данных о человеке и его хобби
	• Id человека
	• Id хобби

Создать 10 записей в таблице для хранения людей.
Создать 2 вида хобби (активное, спокойное)
Создать несколько хобби (футбол, хоккей, чтение и т.д)
Создать записи для хранения данных о хобби для каждого человека со следующими условиями
	• Есть как минимум один человек с несколькими хобби
	• Есть хобби которым увлекаются сразу несколько человек
	• Есть хобби как активные (несколько) так и пассивные (несколько)

Составить скрипты для:
	• Создания и заполнения всех таблиц (учитывать внешние ключи)
	• Удаление всех таблиц

	• Вывести всех людей старше какого-либо возраста
	• Вывести сколько людей каждого пола есть в бд
	• Вывести информацию о людях и их хобби
	• Вывести список людей у которых более одного хобби
	• Вывести какое количество активных хобби и пассивных хобби есть в бд
	• Вывести информацию какое хобби активное а какое пассивное*/
