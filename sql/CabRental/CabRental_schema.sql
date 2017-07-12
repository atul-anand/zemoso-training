-- Cab Rental Database schema
-- Version 1.0
-- Author: Atul Anand

DROP SCHEMA IF EXISTS CabRental;
CREATE SCHEMA CabRental;
use CabRental;

-- 
-- Table Structure for table 'Cab'
-- 

CREATE TABLE Cab (
	cab_id bigint(10) NOT NULL AUTO_INCREMENT,
	cab_number varchar(20) NOT NULL,
	cab_type varchar(20) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (cab_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;
\! echo "Cab Table Created.\n"

-- 
-- Table Structure for table 'Driver'
-- 

CREATE TABLE Driver (
	driver_id bigint(10) NOT NULL AUTO_INCREMENT,
	first_name varchar(30) NOT NULL,
	last_name varchar(30) NOT NULL,
	license_no varchar(10) NOT NULL,
	contact_no bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (driver_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;
\! echo "Driver Table Created.\n"

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
\! echo "Customer Table Created.\n"


-- 
-- Table Structure for table 'Cab-Driver'
-- 

CREATE TABLE Cab_Driver (
	-- cab_driver_id bigint(10) NOT NULL AUTO_INCREMENT,
	cab_id bigint(10) NOT NULL,
	driver_id bigint(10) NOT NULL,
	start_date date NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	-- PRIMARY KEY (cab_driver_id),
	CONSTRAINT UC_Cab_Driver UNIQUE(cab_id,driver_id,start_date),
	CONSTRAINT FK_Cab_ID FOREIGN KEY (cab_id) REFERENCES Cab (cab_id) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT FK_Driver_ID FOREIGN KEY (driver_id) REFERENCES Driver (driver_id) ON DELETE RESTRICT ON UPDATE CASCADE
) Engine=InnoDB DEFAULT CHARSET=utf8;
\! echo "Cab-Driver Relation Created.\n"


-- 
-- Table Structure for table 'Cab-Customer'
-- 

CREATE TABLE Cab_Customer (
	-- cab_cust_id bigint(10) NOT NULL AUTO_INCREMENT,
	cab_id bigint(10) NOT NULL,
	cust_id bigint(10) NOT NULL,
	trip_start datetime NOT NULL,
	trip_end datetime NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	-- PRIMARY KEY (cab_cust_id),
	CONSTRAINT UC_Cab_Customer UNIQUE(cab_id,cust_id,trip_start),
	CONSTRAINT FK_Cab_ID FOREIGN KEY (cab_id) REFERENCES Cab (cab_id) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT FK_Cust_ID FOREIGN KEY (cust_id) REFERENCES Customer (cust_id) ON DELETE RESTRICT ON UPDATE CASCADE
) Engine=InnoDB DEFAULT CHARSET=utf8;
\! echo "Cab-Customer Relation Created.\n"
