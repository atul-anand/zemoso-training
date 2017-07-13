CREATE TABLE Ticket (
	ticket_id bigint(10) NOT NULL AUTO_INCREMENT,
	pnr_number bigint(10) NOT NULL,
	adult_count int(1) NOT NULL,
	child_count int(1) NOT NULL,
	booking_time datetime NOT NULL,
	boarding_time datetime NOT NULL,
	leaving_time datetime NOT NULL,
	reserved tinyint(1) DEFAULT NULL,
	train_id bigint(10) DEFAULT NULL,
	cust_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (ticket_id),
	CONSTRAINT CHK_Ticket_Timings CHECK (leaving_time>boarding_time),
	CONSTRAINT CHK_Ticket_Reservation CHECK ((reserved=null AND train_id=null) OR (reserved!=null AND train_id!=null)),
	CONSTRAINT FK_Ticket_Train_Id FOREIGN KEY (train_id) REFERENCES Train(train_id) ON DELETE RESTRICT,
	CONSTRAINT FK_Ticket_Cust_Id FOREIGN KEY (cust_id) REFERENCES Customer(cust_id) ON DELETE RESTRICT
) Engine=InnoDB DEFAULT CHARSET=utf8;