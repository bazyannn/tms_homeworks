create table films(
    id uuid primary key,
    title varchar,
    description varchar,
    genre varchar,
    year int,
    is_viewed boolean

);

insert into films(id, title, description, genre, year, is_Viewed) VALUES (?,?,?,?,?,?);

select * from films;

select * from films where title ILIKE ?;