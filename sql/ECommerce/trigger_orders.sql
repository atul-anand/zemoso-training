DELIMITER ;;

CREATE TRIGGER ECommerce.trigger_time BEFORE INSERT ON ECommerce.Customer_Order FOR EACH ROW
	BEGIN
		DECLARE dtime datetime;
		SET dtime = 0;
		SELECT o.delivery_time
			FROM Customer_Order o
			WHERE o.cust_id = new.cust_id
			ORDER BY o.order_time
			DESC LIMIT 1
			INTO dtime;
		IF(dtime<new.order_time) THEN
			INSERT INTO Customer_Order (cust_id,order_id,order_time,delivery_time,created_tstamp,created_by_id,deleted_tstamp,
					deleted_by_id,last_updated_tstamp,last_updated_by_id)
				VALUES (new.cust_id,new.order_id,new.order_time,new.delivery_time,new.created_tstamp,new.created_by_id,new.deleted_tstamp,
					new.deleted_by_id,new.last_updated_tstamp,new.last_updated_by_id);
		END IF;
	END;;

DELIMITER ;
