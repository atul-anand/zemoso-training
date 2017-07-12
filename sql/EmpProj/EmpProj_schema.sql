-- Employee Projects Database schema
-- Version 1.0
-- Author: Atul Anand

DROP SCHEMA IF EXISTS EmpProj;
CREATE SCHEMA EmpProj;
use EmpProj;

-- 
-- Table Structure for table 'Employee'
-- 

CREATE TABLE Employee ( 
	emp_id bigint(10) NOT NULL AUTO_INCREMENT, 
	first_name varchar(30) NOT NULL, 
	last_name varchar(30) NOT NULL, 
	birth_date datetime DEFAULT NULL,
	sex char(1) NOT NULL,
	job_profile varchar(10) NOT NULL,
	contact_no bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL, 
	PRIMARY KEY (emp_id) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
\! echo "Employee Table Created.\n"

-- 
-- Table Structure for table 'Supervisor'
-- 

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
\! echo "Supervisor Table Created.\n"

-- 
-- Table Structure for table 'Project'
-- 

CREATE TABLE Project(
	proj_id bigint(10) NOT NULL AUTO_INCREMENT,
	name varchar(30) NOT NULL,
	description varchar(100) NOT NULL,
	no_of_employees bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (proj_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
\! echo "Project Table Created.\n"

-- 
-- Table Structure for table 'Employee-Project'
-- 

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
	CONSTRAINT FK_Emp_Id FOREIGN KEY (emp_id) REFERENCES Employee (emp_id) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT FK_Proj_ID FOREIGN KEY (proj_id) REFERENCES Project (proj_id) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
\! echo "Employee-Project Relation Created.\n"

-- 
-- Table Structure for table 'Employee-Supervisor'
-- 

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
	CONSTRAINT FK_Emp_Id FOREIGN KEY (emp_id) REFERENCES Employee (emp_id) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT FK_Sup_Id FOREIGN KEY (sup_id) REFERENCES Employee (emp_id) ON DELETE RESTRICT ON UPDATE CASCADE
	-- CONSTRAINT FK_Sup_ID FOREIGN KEY (sup_id) REFERENCES Supervisor (sup_id) ON DELETE RESTRICT ON UPDATE CASCADE
) Engine=InnoDB DEFAULT CHARSET=utf8;
\! echo "Employee-Supervisor Relation Created.\n"
