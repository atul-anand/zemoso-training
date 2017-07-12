CREATE TABLE Emp_Proj (
	-- emp_proj_id bigint(10) NOT NULL AUTO_INCREMENT,
	emp_id bigint(10) NOT NULL,
	proj_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	-- PRIMARY KEY (emp_proj_id),
	CONSTRAINT UC_Emp_Proj UNIQUE (emp_id,proj_id),
	-- KEY idx_fk_emp_id (emp_id),
	-- KEY idx_fk_proj_id (proj_id),
	CONSTRAINT FK_Emp_Id FOREIGN KEY (emp_id) REFERENCES Employee (emp_id) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT FK_Proj_ID FOREIGN KEY (proj_id) REFERENCES Project (proj_id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;