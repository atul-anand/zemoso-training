CREATE TABLE TV_Series_Actor (
	show_id bigint(10) NOT NULL,
	actor_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	CONSTRAINT FK_TV_Series_Actor_Show_Id FOREIGN KEY (show_id) REFERENCES TV_Series(show_id) ON DELETE RESTRICT,
	CONSTRAINT FK_TV_Series_Actor_Actor_Id FOREIGN KEY (actor_id) REFERENCES Actor(actor_id) ON DELETE RESTRICT
) Engine=InnoDB DEFAULT CHARSET=utf8;