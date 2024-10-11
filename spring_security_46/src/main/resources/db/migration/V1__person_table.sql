create table persons (
    id uuid primary key,
    login varchar,
    password varchar,
    not_blocked boolean
);

create table perms(
    id uuid primary key ,
    name varchar,
    person_id uuid
);

alter table perms add constraint fk_perms_on_person foreign key (person_id) references persons(id);