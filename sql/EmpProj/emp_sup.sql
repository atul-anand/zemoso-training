CREATE TABLE Emp_Sup(
	emp_id bigint(10) NOT NULL,
	sup_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	CONSTRAINT UC_Emp_ID UNIQUE (emp_id),
	CONSTRAINT UC_Emp_Sup UNIQUE (emp_id,sup_id),
	CONSTRAINT CHK_Emp_Not_Sup CHECK (emp_id!=sup_id),
	CONSTRAINT FK_Emps_Id FOREIGN KEY (emp_id) REFERENCES Employee (emp_id) ON DELETE RESTRICT,
	CONSTRAINT FK_Sup_Id FOREIGN KEY (sup_id) REFERENCES Employee (emp_id) ON DELETE RESTRICT
) Engine=InnoDB DEFAULT CHARSET=utf8;