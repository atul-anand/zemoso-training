-- Cab Rental Database schema
-- Author: Atul Anand

-- Constraints
-- One driver can drive one cab. One cab can be driven by one driver.
-- One cab can have more than one customer. One customer cannot be in more than one cab at the same time.
-- Each cab must have a driver. 

-- Cab - Driver Relation
-- Cab: Weak entity
-- Driver: Strong entity

-- Cab - Customer Relation
-- Cab: Strong entity
-- Customer: Strong entity

DROP SCHEMA IF EXISTS CabRental;
CREATE SCHEMA CabRental;
use CabRental;

-- 
-- Table Structure for table 'Cab'
-- 

source ./cab.sql;

-- 
-- Table Structure for table 'Driver'
-- 

source ./driver.sql;

-- 
-- Table Structure for table 'Customer'
-- 

source ./customer.sql;


-- 
-- Table Structure for table 'Cab-Driver'
-- 

source ./cab_driver.sql;


-- 
-- Table Structure for table 'Cab-Customer'
-- 

source ./cab_customer.sql;
