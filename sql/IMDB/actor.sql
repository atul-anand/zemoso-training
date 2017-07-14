CREATE TABLE Actor (
	actor_id bigint(10) NOT NULL AUTO_INCREMENT,
	first_name varchar(30) NOT NULL,
	last_name varchar(30) NOT NULL,
	movies_count bigint(10) DEFAULT NULL,
	shows_count bigint(10) DEFAULT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (actor_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;