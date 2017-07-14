CREATE TABLE TV_Series (
	show_id bigint(10) NOT NULL AUTO_INCREMENT,
	show_name varchar(30) NOT NULL,
	broadcast_channel varchar(20) NOT NULL,
	air_year datetime NOT NULL,
	genre varchar(10) NOT NULL,
	actor_count bigint(10) NOT NULL,
	season_count bigint(10) NOT NULL,
	episode_count bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (show_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;