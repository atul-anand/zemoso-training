-- IRCTC Database schema
-- Author: Atul Anand

-- Constraints
-- Ticket can be reserved or unreserved.
-- Each reserved ticket must correspond to a train and a customer.
-- Each unreserved ticket must correspond to a customer.
-- A customer cannot be in two trains at the same time.

-- Train: Strong entity
-- Customer: Strong entity
-- Ticket: Weak entity

DROP SCHEMA IF EXISTS IRCTC;
CREATE SCHEMA IRCTC;
use IRCTC;

-- 
-- Table Structure for table 'Train'
-- 

CREATE TABLE Train (
	train_id bigint(10) NOT NULL AUTO_INCREMENT,
	train_no bigint(10) NOT NULL,
	train_name varchar(20) NOT NULL,
	source_stn_code varchar(4) NOT NULL,
	dest_stn_code varchar(4) NOT NULL,
	source_time datetime NOT NULL,
	dest_time datetime NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL, 
	PRIMARY KEY (train_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Table Structure for table 'Customer'
-- 

CREATE TABLE Customer (
	cust_id bigint(10) NOT NULL AUTO_INCREMENT,
	first_name varchar(30) NOT NULL,
	last_name varchar(30) NOT NULL,
	contact_no bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (cust_id)
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Table Structure for table 'Ticket'
-- 

CREATE TABLE Ticket (
	ticket_id bigint(10) NOT NULL AUTO_INCREMENT,
	pnr_number bigint(10) NOT NULL,
	adult_count int(1) NOT NULL,
	child_count int(1) NOT NULL,
	booking_time datetime NOT NULL,
	boarding_time datetime NOT NULL,
	leaving_time datetime NOT NULL,
	reserved tinyint(1) DEFAULT NULL,
	train_id bigint(10) DEFAULT NULL,
	cust_id bigint(10) NOT NULL,
	created_tstamp datetime DEFAULT NULL, 
	created_by_id bigint(20) NOT NULL, 
	deleted_tstamp datetime DEFAULT NULL, 
	deleted_by_id bigint(20) DEFAULT NULL, 
	last_updated_tstamp datetime DEFAULT NULL, 
	last_updated_by_id bigint(20) NOT NULL,
	PRIMARY KEY (ticket_id),
	CONSTRAINT CHK_Ticket_Timings CHECK (leaving_time>boarding_time),
	CONSTRAINT CHK_Ticket_Reservation CHECK ((reserved=null AND train_id=null) OR (reserved!=null AND train_id!=null)),
	CONSTRAINT FK_Ticket_Train_Id FOREIGN KEY (train_id) REFERENCES Train(train_id) ON DELETE RESTRICT,
	CONSTRAINT FK_Ticket_Cust_Id FOREIGN KEY (cust_id) REFERENCES Customer(cust_id) ON DELETE RESTRICT
) Engine=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Trigger and Procedure for ensuring customer is not in two trains at the same time.
-- 

DELIMITER $$

CREATE PROCEDURE IRCTC.ensureTimings(btime datetime,cust_id bigint(10),train_id bigint(10), out book int)
	BEGIN
		DECLARE ltime datetime;
		SELECT t.leaving_time 
			FROM Ticket t 
			WHERE t.cust_id = cust_id
			ORDER BY ticket_id 
			DESC LIMIT 1 
			INTO ltime;
		IF btime<ltime THEN
			SELECT 'Customer travelling on a different train.';
			SET book = 0;
		END IF;
	END$$

DELIMITER ;;

CREATE TRIGGER IRCTC.trigger_time BEFORE INSERT ON Ticket FOR EACH ROW
	BEGIN
		DECLARE book int;
		SET book = 0;
		CALL ensureTimings(new.boarding_time,new.cust_id,new.train_id,book);
		IF(book=1) THEN
			INSERT INTO Ticket (ticket_id,pnr_number,adult_count,child_count,booking_time,boarding_time,
				leaving_time,reserved,train_id,cust_id,created_tstamp,created_by_id,deleted_tstamp,
				deleted_by_id,last_updated_tstamp,last_updated_by_id)
				VALUES(new.ticket_id,new.pnr_number,new.adult_count,new.child_count,new.booking_time,new.boarding_time,
				new.leaving_time,new.reserved,new.train_id,new.cust_id,new.created_tstamp,new.created_by_id,new.deleted_tstamp,
				new.deleted_by_id,new.last_updated_tstamp,new.last_updated_by_id);
		END IF;
	END;;

DELIMITER ;
