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