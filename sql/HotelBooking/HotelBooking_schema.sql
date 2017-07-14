-- Hotel Booking Database schema
-- Author: Atul Anand

-- Constraints
-- Customer can be first time user or loyal customer.
-- Customer can book from only only hotel at a time. A hotel can have many customers.

-- Hotel: Strong entity
-- Customer: Strong entity
-- Hotel_Customer: Weak entity

DROP SCHEMA IF EXISTS HotelBooking;
CREATE SCHEMA HotelBooking;
use HotelBooking;

-- 
-- Table Structure for table 'Hotel'
-- 

CREATE TABLE Hotel (
	hotel_id bigint(10) NOT NULL AUTO_INCREMENT,
	hotel_name varchar(30) NOT NULL,
	hotel_address varchar(30) NOT NULL,
	contact_no bigint(10) NOT NULL,
	no_of_rooms bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (hotel_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Table Structure for table 'Customer'
-- 

CREATE TABLE Customer (
	cust_id bigint(10) NOT NULL AUTO_INCREMENT,
	first_name varchar(30) NOT NULL,
	last_name varchar(30) NOT NULL,
	contact_no bigint(10) NOT NULL,
	first_time_user ENUM('T','F') DEFAULT 'T' NOT NULL, 
	loyal_customer ENUM('T','F') DEFAULT 'F' NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (cust_id),
	CONSTRAINT UC_Customer_Loyal CHECK (first_time_user!=loyal_customer)
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Table Structure for table 'Hotel-Customer Relation'
-- 

CREATE TABLE Hotel_Customer (
	hotel_id bigint(10) NOT NULL,
	cust_id bigint(10) NOT NULL,
	booking datetime DEFAULT NULL,
	check_in datetime DEFAULT NULL,
	check_out datetime DEFAULT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	CONSTRAINT CHK_Hotel_Customer_Timings CHECK (check_out>check_in),
	CONSTRAINT UC_Hotel_Customer_Bookings UNIQUE (hotel_id,cust_id,booking),
	CONSTRAINT FK_Hotel_Customer_Hotel_Id FOREIGN KEY (hotel_id) REFERENCES Hotel (hotel_id) ON DELETE RESTRICT,
	CONSTRAINT FK_Hotel_Customer_Cust_Id FOREIGN KEY (cust_id) REFERENCES Customer (cust_id) ON DELETE RESTRICT
) Engine=InnoDB DEFAULT CHARSET=utf8;
