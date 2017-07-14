-- Food Delivery Database schema
-- Author: Atul Anand

-- Constraints
-- Delivery person must have an order. He can have more than one orders at the same time.
-- Customer can book from only only restaurant at a time.
-- An order can have items from only one restaurant. A restaurant can have multiple orders from different customers at the same time.

-- Customer: Strong entity
-- Restaurant: Strong entity
-- Delivery_Boy: Weak entity
-- Order: Weak entity

DROP SCHEMA IF EXISTS Delivery;
CREATE SCHEMA Delivery;
use Delivery;

-- 
-- Table Structure for table 'Customer'
-- 

CREATE TABLE Customer (
	cust_id bigint(10) NOT NULL AUTO_INCREMENT,
	first_name varchar(30) NOT NULL,
	last_name varchar(30) NOT NULL,
	contact_no bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (cust_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Table Structure for table 'Restaurant'
-- 

CREATE TABLE Restaurant (
	rest_id bigint(10) NOT NULL AUTO_INCREMENT,
	rest_name varchar(30) NOT NULL,
	rest_address varchar(30) NOT NULL,
	contact_no bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (rest_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Table Structure for table 'Delivery Boy'
-- 

CREATE TABLE Delivery_Boy (
	del_id bigint(10) NOT NULL AUTO_INCREMENT,
	first_name varchar(30) NOT NULL,
	last_name varchar(30) NOT NULL,
	contact_no bigint(10) NOT NULL,
	no_of_orders bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (del_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Table Structure for table 'Order'
-- 

CREATE TABLE Orders (
	order_id bigint(10) NOT NULL AUTO_INCREMENT,
	cust_id bigint(10) NOT NULL,
	rest_id bigint(10) NOT NULL,
	del_id bigint(10) NOT NULL,
	no_of_items bigint(10) NOT NULL,
	price bigint(10) NOT NULL,
	order_time datetime DEFAULT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (order_id),
	CONSTRAINT UC_Order_Time UNIQUE (cust_id,rest_id,order_time),
	CONSTRAINT FK_Order_Cust_Id FOREIGN KEY (cust_id) REFERENCES Customer (cust_id) ON DELETE RESTRICT,
	CONSTRAINT FK_Order_Rest_Id FOREIGN KEY (rest_id) REFERENCES Restaurant (rest_id) ON DELETE RESTRICT,
	CONSTRAINT FK_Order_Del_Id FOREIGN KEY (del_id) REFERENCES Delivery_Boy (del_id) ON DELETE RESTRICT
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Trigger for ensuring order count for the delivery boy.
-- 

DELIMITER ;;

CREATE TRIGGER Delivery.trigger_time BEFORE INSERT ON Delivery.Orders FOR EACH ROW
	BEGIN
		UPDATE Delivery.Delivery_Boy d
			SET d.no_of_orders = d.no_of_orders + 1
			WHERE d.del_id = new.del_id;	
	END;;

DELIMITER ;

