-- Paytm Database schema
-- Author: Atul Anand

-- Constraints
-- Each customer must have an account. Joint accounts are allowed.
-- A customer can have multiple accounts in different branch, but not in same branch.
-- A branch can have many accounts

-- Branch: Strong entity
-- Account: Weak entity
-- Customer: Weak entity
-- Combine: Weak entity

DROP SCHEMA IF EXISTS Paytm;
CREATE SCHEMA Paytm;
use Paytm;

-- 
-- Table Structure for table 'Branch'
-- 

source ./branch.sql;

-- 
-- Table Structure for table 'Account'
-- 

source ./account.sql;

-- 
-- Table Structure for table 'Customer'
-- 

source ./customer.sql;

-- 
-- Table Structure for table 'Combine Relation'
-- 

source ./combine.sql;

-- 
-- Trigger for ensuring single account in one branch
-- 

source ./trigger_branch.sql;

