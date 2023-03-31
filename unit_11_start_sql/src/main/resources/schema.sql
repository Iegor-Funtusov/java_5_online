# mysql
CREATE SCHEMA `java_5` DEFAULT CHARACTER SET utf8;

create table employees
(
    id bigint auto_increment primary key,
    first_name varchar(45),
    last_name varchar(45),
    age int
);
