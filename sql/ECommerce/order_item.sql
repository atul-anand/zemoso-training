CREATE TABLE Order_Item (
	item_id bigint(10) NOT NULL,
	order_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	CONSTRAINT FK_Order_Item_Item_Id FOREIGN KEY (item_id) REFERENCES Item (item_id) ON DELETE RESTRICT,
	CONSTRAINT FK_Order_Item_Order_Id FOREIGN KEY (order_id) REFERENCES Orders (order_id) ON DELETE RESTRICT
) Engine=InnoDB DEFAULT CHARSET=utf8;