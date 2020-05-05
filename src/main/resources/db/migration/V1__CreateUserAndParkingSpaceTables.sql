create table user(
id BIGINT not null auto_increment,
version BIGINT not null DEFAULT 0,
name varchar(40) not null,
surname varchar(40) not null,
email varchar(60) not null,
login varchar(45) not null,
password varchar(45) not null,
active bit not null,
role varchar(45) not null,
primary key(id));

create table parking_space(
id BIGINT not null auto_increment,
version BIGINT not null DEFAULT 0,
space_number INTEGER,
floor INTEGER,
is_active BOOLEAN,
primary key(id));