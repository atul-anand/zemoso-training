-- IRCTC Database schema
-- Author: Atul Anand

-- Constraints
-- Ticket can be reserved or unreserved.
-- Each reserved ticket must correspond to a train and a customer.
-- Each unreserved ticket must correspond to a customer.
-- A customer cannot be in two trains at the same time.


DROP SCHEMA IF EXISTS IRCTC;
CREATE SCHEMA IRCTC;
use IRCTC;

-- 
-- Table Structure for table 'Train'
-- 

source ./train.sql;

-- 
-- Table Structure for table 'Customer'
-- 

source ./customer.sql;

-- 
-- Table Structure for table 'Ticket'
-- 

source ./ticket.sql;

-- 
-- Trigger and Procedure for ensuring customer is not in two trains at the same time.
-- 

source ./trigger_time.sql;
