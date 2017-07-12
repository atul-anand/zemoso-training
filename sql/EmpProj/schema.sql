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

-- 
-- Table Structure for table 'Supervisor'
-- 

-- source ./supervisor.sql;

-- 
-- Table Structure for table 'Project'
-- 

source ./project.sql;

-- 
-- Table Structure for table 'Employee-Project'
-- 

source ./emp_proj.sql;

-- 
-- Table Structure for table 'Employee-Supervisor'
-- 

source ./emp_sup.sql;