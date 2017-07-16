CREATE TABLE Account (
	account_id bigint(10) NOT NULL AUTO_INCREMENT,
	account_no bigint(10) NOT NULL,
	account_balance bigint(10) DEFAULT NULL,
	branch_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (account_id),
	CONSTRAINT FK_Account_Branch FOREIGN KEY (branch_id) REFERENCES Branch (branch_id) ON DELETE RESTRICT
) Engine=InnoDB DEFAULT CHARSET=utf8;