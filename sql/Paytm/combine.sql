CREATE TABLE Combine (
	account_id bigint(10) NOT NULL,
	cust_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	CONSTRAINT FK_Combine_Account_Id FOREIGN KEY (account_id) REFERENCES Account (account_id) ON DELETE RESTRICT,
	CONSTRAINT FK_Combine_Cust_Id FOREIGN KEY (cust_id) REFERENCES Customer (cust_id) ON DELETE RESTRICT 
) Engine=InnoDB DEFAULT CHARSET=utf8;