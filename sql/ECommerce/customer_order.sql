CREATE TABLE Customer_Order (
	cust_id bigint(10) NOT NULL,
	order_id bigint(10) NOT NULL,
	order_time datetime DEFAULT NULL,
	delivery_time datetime DEFAULT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	CONSTRAINT FK_Customer_Order_Cust_Id FOREIGN KEY (cust_id) REFERENCES Customer (cust_id) ON DELETE RESTRICT,
	CONSTRAINT FK_Customer_Order_Order_Id FOREIGN KEY (order_id) REFERENCES Orders (order_id) ON DELETE RESTRICT
) Engine=InnoDB DEFAULT CHARSET=utf8;