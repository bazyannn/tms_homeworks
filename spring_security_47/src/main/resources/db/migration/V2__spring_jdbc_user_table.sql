create table users(
    username varchar primary key,
    password varchar,
    enabled boolean
);

create table authorities(
    username varchar,
    authority varchar,
    foreign key (username) references users(username)
);