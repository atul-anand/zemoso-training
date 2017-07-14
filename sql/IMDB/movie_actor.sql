CREATE TABLE Movie_Actor (
	movie_id bigint(10) NOT NULL,
	actor_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	CONSTRAINT FK_Movie_Actor_Movie_Id FOREIGN KEY (movie_id) REFERENCES Movie(movie_id) ON DELETE RESTRICT,
	CONSTRAINT FK_Movie_Actor_Actor_Id FOREIGN KEY (actor_id) REFERENCES Actor(actor_id) ON DELETE RESTRICT
) Engine=InnoDB DEFAULT CHARSET=utf8;