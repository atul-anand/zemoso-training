-- Employee Projects Database schema
-- Version 1.0
-- Author: Atul Anand

DROP SCHEMA IF EXISTS EmpProj;
CREATE SCHEMA EmpProj;
use EmpProj;

-- 
-- Table Structure for table 'cab'
-- 

source ./employee.sql;
\! echo "Employee Table Created.\n"

-- 
-- Table Structure for table 'cab'
-- 

source ./project.sql;
\! echo "Project Table Created.\n"

-- 
-- Table Structure for table 'cab'
-- 

source ./emp_proj.sql;
\! echo "Employee-Project Relation Created.\n"

-- 
-- Table Structure for table 'cab'
-- 

source ./emp_repo.sql;
\! echo "Employee-Reporting Relation Created.\n"