-- Employee Projects Database schema
-- Author: Atul Anand

-- Constraints
-- One employee will report to only one person. One person can be reported by many people.
-- One employee will be part of only one project. One project may have multiple employees.
-- Each project must have an employee. There cannot be a project with no employees.

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

source ./employee.sql;

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
