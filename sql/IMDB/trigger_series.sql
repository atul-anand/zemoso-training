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
