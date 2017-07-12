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