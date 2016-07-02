
-- mysql_query("SET NAMES 'UTF8'"),
-- mysql_query("SET CHARACTER SET UTF8"),
-- mysql_query("SET CHARACTER_SET_RESULTS=UTF8'");customer

show variables like 'char%';
create table customer(
id int primary key auto_increment,
name  varchar(20) default NULL,
gender varchar(10) default NULL,
birthday date,
cellphone varchar(20) default NULL,
email varchar(40) default NULL,
preference varchar(100) default NULL,
type varchar(40) default NULL,
description varchar(255) default NULL
)ENGINE=InnoDB default charset=utf8;