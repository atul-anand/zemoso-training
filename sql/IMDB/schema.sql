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

source ./actor.sql;

-- 
-- Table Structure for table 'Movie'
-- 

source ./movie.sql;

-- 
-- Table Structure for table 'Movie - Actor Relation'
-- 

source ./movie_actor.sql;

-- 
-- Table Structure for table 'TV Series'
-- 

source ./tv_series.sql;

-- 
-- Table Structure for table 'TV Series - Actor Relation'
-- 

source ./tv_series_actor.sql;

-- 
-- Trigger for ensuring movie and actor count.
-- 

source ./trigger_movie.sql;

-- 
-- Trigger for ensuring tv series and actor count.
-- 

source ./trigger_series.sql;