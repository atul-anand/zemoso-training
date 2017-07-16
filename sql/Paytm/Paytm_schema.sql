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

CREATE TABLE Branch (
	branch_id bigint(10) NOT NULL AUTO_INCREMENT,
	branch_name varchar(30) NOT NULL,
	location varchar(20) NOT NULL,
	contact_no bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (branch_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Table Structure for table 'Account'
-- 

CREATE TABLE Account (
	account_id bigint(10) NOT NULL AUTO_INCREMENT,
	account_no bigint(10) NOT NULL,
	account_balance bigint(10) DEFAULT NULL,
	branch_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (account_id),
	CONSTRAINT FK_Account_Branch FOREIGN KEY (branch_id) REFERENCES Branch (branch_id) ON DELETE RESTRICT
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Table Structure for table 'Customer'
-- 

CREATE TABLE Customer (
	cust_id bigint(10) NOT NULL AUTO_INCREMENT,
	first_name varchar(30) NOT NULL,
	last_name varchar(30) NOT NULL,
	contact_no bigint(10) NOT NULL,
	primary_account_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (cust_id),
	CONSTRAINT FK_Customer_Primary_Account FOREIGN KEY (primary_account_id) REFERENCES Account (account_id) ON DELETE RESTRICT
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Table Structure for table 'Combine Relation'
-- 

CREATE TABLE Combine (
	account_id bigint(10) NOT NULL,
	cust_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	CONSTRAINT FK_Combine_Account_Id FOREIGN KEY (account_id) REFERENCES Account (account_id) ON DELETE RESTRICT,
	CONSTRAINT FK_Combine_Cust_Id FOREIGN KEY (cust_id) REFERENCES Customer (cust_id) ON DELETE RESTRICT 
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Trigger for ensuring single account in one branch
-- 

DELIMITER ;;

CREATE TRIGGER Paytm.trigger_branch BEFORE INSERT ON Paytm.Combine FOR EACH ROW
	BEGIN
		DECLARE branchId bigint;
		DECLARE accountId bigint;
		DECLARE newBranchId bigint;
		SELECT primary_account_id 
			FROM Customer c
			WHERE cust_id = new.cust_id
			INTO accountId;
		SELECT a.branch_id
			FROM Account a
			WHERE account_id = accountId
			INTO branchId;
		SELECT branch_id 
			FROM Account a
			WHERE account_id = new.account_id
			INTO newBranchId;
		IF(branchId!=newBranchId) THEN
			INSERT INTO Combine(account_id,cust_id,created_tstamp,created_by_id,deleted_tstamp,
				deleted_by_id,last_updated_tstamp,last_updated_by_id)
				VALUES (new.account_id,new.cust_id,new.created_tstamp,new.created_by_id,new.deleted_tstamp,
					new.deleted_by_id,new.last_updated_tstamp,new.last_updated_by_id);
			END IF;
	END;;

DELIMITER ;

