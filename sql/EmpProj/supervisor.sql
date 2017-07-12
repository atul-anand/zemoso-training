CREATE TABLE Supervisor ( 
	sup_id bigint(10) NOT NULL AUTO_INCREMENT, 
	emp_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL, 
	PRIMARY KEY (sup_id),
	CONSTRAINT FK_Sup_ID FOREIGN KEY (emp_id) REFERENCES Employee(emp_id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
