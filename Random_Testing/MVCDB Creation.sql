-- Creating MVCDB Table
use mvcdb; 
drop table csr;
drop table customers;
drop table orders;
drop table shoes;

-- 1.
DROP DATABASE IF EXISTS MVCDB;

-- 2.
CREATE DATABASE MVCDB;

USE MVCDB;

-- 3. 
CREATE TABLE CUSTOMERS (
	customerId INT NOT NULL AUTO_INCREMENT,
    userName VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    address VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    postalCode VARCHAR(50) NOT NULL,
	PRIMARY KEY (customerId)
);

CREATE TABLE CSR (
	employeeId INT NOT NULL AUTO_INCREMENT,
    userName VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
	PRIMARY KEY (employeeId)
);

CREATE TABLE SHOES (
	itemId INT NOT NULL AUTO_INCREMENT,
    itemName VARCHAR(50) NOT NULL,
    category VARCHAR(50) NOT NULL,
    shoeSize INT NOT NULL,
    price DECIMAL(7,2),
	PRIMARY KEY (itemId)
);


CREATE TABLE ORDERS (
	orderId INT NOT NULL AUTO_INCREMENT,
    customerId INT NOT NULL,
    itemId INT NOT NULL,
    orderDate DATE NOT NULL,
    quantity INT NOT NULL,
    status VARCHAR(50) NOT NULL,
	PRIMARY KEY (orderId)
);



INSERT INTO CSR(userName, password, firstName, lastName)
VALUES ('a', 'a', 'oleh', 'vytvitskyy');

INSERT INTO ORDERS(customerId, itemId, orderDate, quantity, status) VALUES (1, 1, '2000-1-1', 1, 'yes');

INSERT INTO SHOES(itemName, category, shoeSize, price) VALUES ('Cool Shoe', 'Mens', '10', '19.99'),
															  ('Nice Shoe', 'Womens', '6', '9.99'),
															  ('Okay Shoe', 'Kids', '4', '4.99');	
                                                              
                                                              select * from shoes;

