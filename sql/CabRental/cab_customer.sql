CREATE TABLE Cab_Customer (
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
	CONSTRAINT UC_Cab_Customer UNIQUE(cab_id,cust_id,trip_start),
	CONSTRAINT FK_Cabs_ID FOREIGN KEY (cab_id) REFERENCES Cab (cab_id) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT FK_Cust_ID FOREIGN KEY (cust_id) REFERENCES Customer (cust_id) ON DELETE RESTRICT ON UPDATE CASCADE
) Engine=InnoDB DEFAULT CHARSET=utf8;