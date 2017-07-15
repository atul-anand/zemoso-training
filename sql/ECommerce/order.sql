CREATE TABLE Orders (
	order_id bigint(10) NOT NULL AUTO_INCREMENT,
	no_of_items bigint(10) NOT NULL,
	price bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (order_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;