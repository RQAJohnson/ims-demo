create database if not exists ims_test;
drop table if exists ims_test.customers;
create table ims_test.customers(id int primary key auto_increment, firstName varchar(40), surName varchar(40));
