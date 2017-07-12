-- Employee Projects Database schema
-- Author: Atul Anand

-- Employee - Project Relation
-- Employee: Strong entity
-- Project: Weak entity

-- Employee - Supervisor Relation
-- Employee: Strong entity
-- Supervisor: Strong entity

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
	sex ENUM('M','F') DEFAULT 'M' NOT NULL,
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

-- 
-- Table Structure for table 'Employee-Project'
-- 

CREATE TABLE Emp_Proj (
	emp_id bigint(10) NOT NULL,
	proj_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	CONSTRAINT UC_Emp UNIQUE (emp_id),
	CONSTRAINT UC_Emp_Proj UNIQUE (emp_id,proj_id),
	CONSTRAINT FK_Emp_Id FOREIGN KEY (emp_id) REFERENCES Employee (emp_id) ON DELETE RESTRICT,
	CONSTRAINT FK_Proj_ID FOREIGN KEY (proj_id) REFERENCES Project (proj_id) ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Table Structure for table 'Employee-Supervisor'
-- 

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
