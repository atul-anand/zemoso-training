-- Employee Projects Database schema
-- Version 1.0
-- Author: Atul Anand

DROP SCHEMA IF EXISTS EmpProj;
CREATE SCHEMA EmpProj;
use EmpProj;

-- 
-- Table Structure for table 'Employee'
-- 

source ./employee.sql;
\! echo "Employee Table Created.\n"

-- 
-- Table Structure for table 'Supervisor'
-- 

source ./supervisor.sql;
\! echo "Supervisor Table Created.\n"

-- 
-- Table Structure for table 'Project'
-- 

source ./project.sql;
\! echo "Project Table Created.\n"

-- 
-- Table Structure for table 'Employee-Project'
-- 

source ./emp_proj.sql;
\! echo "Employee-Project Relation Created.\n"

-- 
-- Table Structure for table 'Employee-Supervisor'
-- 

source ./emp_sup.sql;
\! echo "Employee-Supervisor Relation Created.\n"