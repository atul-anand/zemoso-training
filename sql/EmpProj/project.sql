CREATE TABLE Project(
	proj_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	name varchar(30) NOT NULL,
	description varchar(100) NOT NULL,
	no_of_employees bigint(10) NOT NULL,
	PRIMARY KEY (proj_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;