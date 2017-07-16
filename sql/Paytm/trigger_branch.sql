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
