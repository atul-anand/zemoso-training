CREATE TABLE Emp_Proj (
	emp_proj_id bigint(10) NOT NULL,
	emp_id bigint(10) NOT NULL,
	proj_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (emp_proj_id),
	CONSTRAINT UC_Emp_Proj UNIQUE (emp_id,proj_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;