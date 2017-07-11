CREATE TABLE Cab_Driver (
	cab_driver_id bigint(10) NOT NULL,
	cab_id bigint(10) NOT NULL,
	driver_id bigint(10) NOT NULL,
	start_date date NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (cab_driver_id),
	CONSTRAINT UC_Cab_Driver UNIQUE(cab_id,driver_id,start_date)
) Engine=InnoDB DEFAULT CHARSET=utf8;