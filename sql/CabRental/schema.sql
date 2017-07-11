-- Cab Rental Database schema
-- Version 1.0
-- Author: Atul Anand

DROP SCHEMA IF EXISTS CabRental;
CREATE SCHEMA CabRental;
use CabRental;

-- 
-- Table Structure for table 'cab'
-- 

source ./cab.sql;
\! echo "Cab Table Created.\n"

-- 
-- Table Structure for table 'cab'
-- 

source ./driver.sql;
\! echo "Driver Table Created.\n"

-- 
-- Table Structure for table 'cab'
-- 

source ./customer.sql;
\! echo "Customer Table Created.\n"


-- 
-- Table Structure for table 'cab'
-- 

source ./cab_driver.sql;
\! echo "Cab-Driver Relation Created.\n"


-- 
-- Table Structure for table 'cab'
-- 

source ./cab_customer.sql;
\! echo "Cab-Customer Relation Created.\n"