CREATE TABLE Branch (
	branch_id bigint(10) NOT NULL AUTO_INCREMENT,
	branch_name varchar(30) NOT NULL,
	location varchar(20) NOT NULL,
	contact_no bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (branch_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;