-- TCL Commands
START TRANSACTION;

UPDATE patients SET phone_number = '8954133470' WHERE patient_id = 1;
DELETE FROM patients WHERE patient_id = 99; -- suppose this is a mistake

ROLLBACK; -- undoes both operations above since they were in this transaction

-- OR, if everything is correct:
COMMIT; -- makes changes permanent

/*
# COMMIT — saves all changes made in the current transaction permanently
# ROLLBACK — undoes all changes made in the current transaction
# SAVEPOINT — sets a point within a transaction to roll back to partially
*/
