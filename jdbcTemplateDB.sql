create database jdbcTemplateDB;

use jdbcTemplateDB;

CREATE TABLE categories(
id int(11) unsigned NOT NULL,
name varchar(50) NOT NULL,
description nvarchar(100),
PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE products(
id int(11) unsigned NOT NULL,
name varchar(50) NOT NULL,
price double NOT NULL,
unitsInStock int,
discontinued boolean,
PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

select * from categories;
select * from products;