DELIMITER $$

CREATE PROCEDURE IRCTC.ensureTimings(btime datetime,cust_id bigint(10),train_id bigint(10), out book int)
	BEGIN
		DECLARE ltime datetime;
		SELECT t.leaving_time 
			FROM Ticket t 
			WHERE t.cust_id = cust_id
			ORDER BY ticket_id 
			DESC LIMIT 1 
			INTO ltime;
		IF btime<ltime THEN
			SELECT 'Customer travelling on a different train.';
			SET book = 0;
		END IF;
	END$$

DELIMITER ;;

CREATE TRIGGER IRCTC.trigger_time BEFORE INSERT ON Ticket FOR EACH ROW
	BEGIN
		DECLARE book int;
		SET book = 0;
		CALL ensureTimings(new.boarding_time,new.cust_id,new.train_id,book);
		IF(book=1) THEN
			INSERT INTO Ticket (ticket_id,pnr_number,adult_count,child_count,booking_time,boarding_time,
				leaving_time,reserved,train_id,cust_id,created_tstamp,created_by_id,deleted_tstamp,
				deleted_by_id,last_updated_tstamp,last_updated_by_id)
				VALUES(new.ticket_id,new.pnr_number,new.adult_count,new.child_count,new.booking_time,new.boarding_time,
				new.leaving_time,new.reserved,new.train_id,new.cust_id,new.created_tstamp,new.created_by_id,new.deleted_tstamp,
				new.deleted_by_id,new.last_updated_tstamp,new.last_updated_by_id);
		END IF;
	END;;

DELIMITER ;
