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