CREATE TABLE Cab_Driver (
	cab_id bigint(10) NOT NULL,
	driver_id bigint(10) NOT NULL,
	start_date date NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	CONSTRAINT UC_Cab_Driver_Cab_Driver UNIQUE(cab_id,driver_id,start_date),
	CONSTRAINT FK_Cab_Driver_Cab_ID FOREIGN KEY (cab_id) REFERENCES Cab (cab_id) ON DELETE RESTRICT,
	CONSTRAINT FK_Cab_Driver_Driver_ID FOREIGN KEY (driver_id) REFERENCES Driver (driver_id) ON DELETE RESTRICT
) Engine=InnoDB DEFAULT CHARSET=utf8;