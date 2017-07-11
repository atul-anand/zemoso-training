CREATE TABLE Cab (
	cab_id bigint(10) NOT NULL,
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