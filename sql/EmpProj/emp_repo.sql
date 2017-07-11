CREATE TABLE Emp_Repo(
	emp_repo_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	emp_id bigint(10) NOT NULL,
	repo_id bigint(10) NOT NULL,
	CONSTRAINT UC_Emp_Repo UNIQUE (emp_id,repo_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;