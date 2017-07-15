DELIMITER ;;

CREATE TRIGGER ECommerce.trigger_item BEFORE INSERT ON ECommerce.Order_Item FOR EACH ROW
	BEGIN
		DECLARE item_price bigint;
		SELECT i.price
			FROM Item i
			WHERE item_id = new.item_id
			INTO item_price;
		UPDATE ECommerce.Orders o
			SET o.price = o.price + item_price
			WHERE o.order_id = new.order_id;	
	END;;

DELIMITER ;
