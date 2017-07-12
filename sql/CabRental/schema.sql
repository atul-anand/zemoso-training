-- Cab Rental Database schema
-- Version 1.0
-- Author: Atul Anand

DROP SCHEMA IF EXISTS CabRental;
CREATE SCHEMA CabRental;
use CabRental;

-- 
-- Table Structure for table 'Cab'
-- 

source ./cab.sql;
-- \! echo "Cab Table Created.\n"

-- 
-- Table Structure for table 'Driver'
-- 

source ./driver.sql;
-- \! echo "Driver Table Created.\n"

-- 
-- Table Structure for table 'Customer'
-- 

source ./customer.sql;
-- \! echo "Customer Table Created.\n"


-- 
-- Table Structure for table 'Cab-Driver'
-- 

source ./cab_driver.sql;
-- \! echo "Cab-Driver Relation Created.\n"


-- 
-- Table Structure for table 'Cab-Customer'
-- 

source ./cab_customer.sql;
-- \! echo "Cab-Customer Relation Created.\n"