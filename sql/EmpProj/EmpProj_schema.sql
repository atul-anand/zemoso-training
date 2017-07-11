-- Employee Projects Database schema
-- Version 1.0
-- Author: Atul Anand

DROP SCHEMA IF EXISTS EmpProj;
CREATE SCHEMA EmpProj;
use EmpProj;

-- 
-- Table Structure for table 'cab'
-- 

CREATE TABLE Employee ( 
	emp_id bigint(10) NOT NULL, 
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
-- Table Structure for table 'cab'
-- 

CREATE TABLE Project(
	proj_id bigint(10) NOT NULL,
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
-- Table Structure for table 'cab'
-- 

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
\! echo "Employee-Project Relation Created.\n"

-- 
-- Table Structure for table 'cab'
-- 

CREATE TABLE Emp_Repo(
	emp_repo_id bigint(10) NOT NULL,
	emp_id bigint(10) NOT NULL,
	repo_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (emp_repo_id),
	CONSTRAINT UC_Emp_Repo UNIQUE (emp_id,repo_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;
\! echo "Employee-Reporting Relation Created.\n"
