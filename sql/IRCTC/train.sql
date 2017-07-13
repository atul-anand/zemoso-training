CREATE TABLE Train (
	train_id bigint(10) NOT NULL AUTO_INCREMENT,
	train_no bigint(10) NOT NULL,
	train_name varchar(20) NOT NULL,
	source_stn_code varchar(4) NOT NULL,
	dest_stn_code varchar(4) NOT NULL,
	source_time datetime NOT NULL,
	dest_time datetime NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL, 
	PRIMARY KEY (train_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;