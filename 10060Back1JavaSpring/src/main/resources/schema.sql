CREATE SCHEMA IF NOT EXISTS client;

create table IF NOT EXISTS client.users
(
    id           bigserial not null,
    created_date timestamp,
    password varchar(255),
    username varchar(255) unique not null,
    email    varchar(255),
    enabled  boolean,
    primary key (id)
);

create table IF NOT EXISTS client.refresh
(
    id           bigserial not null,
    created timestamp,
    token varchar(255) unique not null,
    primary key (id)
 );



