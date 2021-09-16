CREATE SCHEMA IF NOT EXISTS client;

create table IF NOT EXISTS chat2.book
(
    id bigint not null auto_increment,
    b1 bigint,
    primary key (id)
) engine = InnoDB;

REPLACE INTO chat2.book (id, b1) VALUES (2, 2);

create table IF NOT EXISTS client.users
(
    id           bigint              not null auto_increment,
    created_date datetime(6),
    password     varchar(255),
    username     varchar(255) unique not null,
    email        varchar(255),
    enabled      bit,
    primary key (id)
) engine = InnoDB;

create table IF NOT EXISTS client.refresh
(
    id      bigint              not null auto_increment,
    created datetime(6),
    token   varchar(255) unique not null,
    primary key (id)
) engine = InnoDB;


