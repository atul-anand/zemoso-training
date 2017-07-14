-- IMDB Database schema
-- Author: Atul Anand

-- Constraints
-- A TV series or a movie must have an actor. An actor can act in both.

-- Actor: Strong entity
-- Movie: Weak entity
-- TV_Series: Weak entity
-- Movie_Actor: Weak entity
-- TV_Series_Actor: Weak entity

DROP SCHEMA IF EXISTS IMDB;
CREATE SCHEMA IMDB;
use IMDB;

-- 
-- Table Structure for table 'Actor'
-- 

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

-- 
-- Table Structure for table 'Movie'
-- 

CREATE TABLE Movie (
	movie_id bigint(10) NOT NULL AUTO_INCREMENT,
	movie_name varchar(30) NOT NULL,
	studio varchar(20) NOT NULL,
	duration bigint(10) NOT NULL,
	release_year datetime NOT NULL,
	genre varchar(10) NOT NULL,
	actor_count bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (movie_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Table Structure for table 'Movie - Actor Relation'
-- 

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

-- 
-- Table Structure for table 'TV Series'
-- 

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

-- 
-- Table Structure for table 'TV Series - Actor Relation'
-- 

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

-- 
-- Trigger for ensuring movie and actor count.
-- 

DELIMITER ;;

CREATE TRIGGER IMDB.trigger_movie BEFORE INSERT ON IMDB.Movie_Actor FOR EACH ROW
	BEGIN
		UPDATE IMDB.Actor a
			SET a.movies_count = a.movies_count + 1
			WHERE a.actor_id = new.actor_id;
		UPDATE IMDB.Movie m
			SET m.actor_count = m.actor_count + 1
			WHERE m.movie_id = new.movie_id;
	END;;

DELIMITER ;

-- 
-- Trigger for ensuring tv series and actor count.
-- 

DELIMITER ;;

CREATE TRIGGER IMDB.trigger_series BEFORE INSERT ON IMDB.TV_Series_Actor FOR EACH ROW
	BEGIN
		UPDATE IMDB.Actor a
			SET a.shows_count = a.shows_count + 1
			WHERE a.actor_id = new.actor_id;
		UPDATE IMDB.TV_Series t
			SET t.actor_count = t.actor_count + 1
			WHERE t.show_id = new.show_id;
	END;;

DELIMITER ;
