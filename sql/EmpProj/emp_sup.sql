CREATE TABLE Emp_Sup(
	-- emp_sup_id bigint(10) NOT NULL AUTO_INCREMENT,
	emp_id bigint(10) NOT NULL,
	sup_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	-- PRIMARY KEY (emp_sup_id),
	CONSTRAINT UC_Emp_Sup UNIQUE (emp_id,sup_id),
	-- KEY idx_fk_emp_id (emp_id),
	-- KEY idx_fk_sup_id (sup_id),
	CONSTRAINT FK_Emp_Id FOREIGN KEY (emp_id) REFERENCES Employee (emp_id) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT FK_Sup_Id FOREIGN KEY (sup_id) REFERENCES Employee (emp_id) ON DELETE RESTRICT ON UPDATE CASCADE
	-- CONSTRAINT FK_Sup_ID FOREIGN KEY (sup_id) REFERENCES Supervisor (sup_id) ON DELETE RESTRICT ON UPDATE CASCADE
) Engine=InnoDB DEFAULT CHARSET=utf8;