DELIMITER ;;

CREATE TRIGGER Delivery.trigger_time BEFORE INSERT ON Delivery.Orders FOR EACH ROW
	BEGIN
		UPDATE Delivery.Delivery_Boy d
			SET d.no_of_orders = d.no_of_orders + 1
			WHERE d.del_id = new.del_id;	
	END;;

DELIMITER ;
