-- E-Commerce Database schema
-- Author: Atul Anand

-- Constraints
-- Every item should correspond to a supplier.
-- One supplier can have more than one items.
-- A customer can have one order at the same time. 
-- One order can have multiple items from multiple brands.

-- Customer: Strong entity
-- Item: Strong entity
-- Supplier: Strong entity
-- Order: Strong entity 
-- Supplier-Item: Strong entity
-- Order-Item: Strong entity
-- Customer-Order: Strong entity

DROP SCHEMA IF EXISTS ECommerce;
CREATE SCHEMA ECommerce;
use ECommerce;

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
-- Table Structure for table 'Item'
-- 

CREATE TABLE Item (
	item_id bigint(10) NOT NULL AUTO_INCREMENT,
	brand varchar(20) NOT NULL,
	price bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (item_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Table Structure for table 'Supplier'
-- 

CREATE TABLE Supplier (
	supp_id bigint(10) NOT NULL AUTO_INCREMENT,
	first_name varchar(30) NOT NULL,
	last_name varchar(30) NOT NULL,
	contact_no bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (supp_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Table Structure for table 'Order'
-- 

CREATE TABLE Orders (
	order_id bigint(10) NOT NULL AUTO_INCREMENT,
	no_of_items bigint(10) NOT NULL,
	price bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (order_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Table Structure for table 'Supplier-Item Relation'
-- 

CREATE TABLE Supplier_Item (
	supp_id bigint(10) NOT NULL,
	item_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	CONSTRAINT FK_Supplier_Item_Supp_Id FOREIGN KEY (supp_id) REFERENCES Supplier (supp_id) ON DELETE RESTRICT,
	CONSTRAINT FK_Supplier_Item_Item_Id FOREIGN KEY (item_id) REFERENCES Item (item_id) ON DELETE RESTRICT
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Table Structure for table 'Order-Item Relation'
-- 

CREATE TABLE Order_Item (
	item_id bigint(10) NOT NULL,
	order_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	CONSTRAINT FK_Order_Item_Item_Id FOREIGN KEY (item_id) REFERENCES Item (item_id) ON DELETE RESTRICT,
	CONSTRAINT FK_Order_Item_Order_Id FOREIGN KEY (order_id) REFERENCES Orders (order_id) ON DELETE RESTRICT
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Table Structure for table 'Customer-Order Relation'
-- 

CREATE TABLE Customer_Order (
	cust_id bigint(10) NOT NULL,
	order_id bigint(10) NOT NULL,
	order_time datetime DEFAULT NULL,
	delivery_time datetime DEFAULT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	CONSTRAINT FK_Customer_Order_Cust_Id FOREIGN KEY (cust_id) REFERENCES Customer (cust_id) ON DELETE RESTRICT,
	CONSTRAINT FK_Customer_Order_Order_Id FOREIGN KEY (order_id) REFERENCES Orders (order_id) ON DELETE RESTRICT
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Trigger for ensuring order price while adding item to the order.
-- 

DELIMITER ;;

CREATE TRIGGER ECommerce.trigger_item BEFORE INSERT ON ECommerce.Order_Item FOR EACH ROW
	BEGIN
		DECLARE item_price bigint;
		SELECT i.price
			FROM Item i
			WHERE item_id = new.item_id
			INTO item_price;
		UPDATE ECommerce.Orders o
			SET o.price = o.price + item_price
			WHERE o.order_id = new.order_id;	
	END;;

DELIMITER ;

-- 
-- Trigger for ensuring order time for a customer.
-- 

DELIMITER ;;

CREATE TRIGGER ECommerce.trigger_time BEFORE INSERT ON ECommerce.Customer_Order FOR EACH ROW
	BEGIN
		DECLARE dtime datetime;
		SET dtime = 0;
		SELECT o.delivery_time
			FROM Customer_Order o
			WHERE o.cust_id = new.cust_id
			ORDER BY o.order_time
			DESC LIMIT 1
			INTO dtime;
		IF(dtime<new.order_time) THEN
			INSERT INTO Customer_Order (cust_id,order_id,order_time,delivery_time,created_tstamp,created_by_id,deleted_tstamp,
					deleted_by_id,last_updated_tstamp,last_updated_by_id)
				VALUES (new.cust_id,new.order_id,new.order_time,new.delivery_time,new.created_tstamp,new.created_by_id,new.deleted_tstamp,
					new.deleted_by_id,new.last_updated_tstamp,new.last_updated_by_id);
		END IF;
	END;;

DELIMITER ;
