create database if not exists ims;
create table if not exists ims.customers(id int primary key auto_increment, firstName varchar(40), surName varchar(40));
create table if not exists ims.items(itemID int primary key auto_increment, title varchar(45), price decimal(6,2) not null);
create table if not exists ims.orders(orderID int primary key auto_increment, customerID int not null, dateOrdered datetime not null default now(), FOREIGN KEY (customerID) REFERENCES customers(id));
create table if not exists ims.orderline(orderlineID int primary key auto_increment, ol_orderID int not null, ol_itemID int not null, FOREIGN KEY (ol_orderID) REFERENCES orders(orderID), FOREIGN KEY (ol_itemID) REFERENCES items(itemID));
