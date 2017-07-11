CREATE TABLE Cab_Customer (
	cab_cust_id bigint(10) NOT NULL,
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
	PRIMARY KEY (cab_cust_id),
	CONSTRAINT UC_Cab_Customer UNIQUE(cab_id,cust_id,trip_start)
) Engine=InnoDB DEFAULT CHARSET=utf8;