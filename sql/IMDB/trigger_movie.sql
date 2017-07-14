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
