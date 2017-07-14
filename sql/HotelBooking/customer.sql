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