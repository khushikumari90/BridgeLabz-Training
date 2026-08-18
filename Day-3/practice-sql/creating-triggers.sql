-- TRIGGERS

-- BEFORE INSERT (validation)
DELIMITER //
CREATE TRIGGER before_appointment_insert
BEFORE INSERT ON appointments
FOR EACH ROW
BEGIN
 IF NEW.appointment_date < CURDATE() THEN
 SIGNAL SQLSTATE '45000'
 SET MESSAGE_TEXT = 'Cannot book an appointment in the past';
 END IF;
END //
DELIMITER ;

-- AFTER INSERT (audit log)
DELIMITER //
CREATE TRIGGER after_appointment_insert
AFTER INSERT ON appointments
FOR EACH ROW
BEGIN
 INSERT INTO AuditLog(action, table_name, record_id, action_time)
 VALUES ('INSERT', 'appointments', NEW.appointment_id, NOW());
END //
DELIMITER ;

-- BEFORE UPDATE(auto-populate a field)
DELIMITER //
CREATE TRIGGER before_billing_update
BEFORE UPDATE ON billing
FOR EACH ROW
BEGIN
 IF NEW.payment_status = 'Paid' AND OLD.payment_status != 'Paid' THEN
 SET NEW.billing_date = NOW();
 END IF;
END //
DELIMITER ;

-- AFTER UPDATE (sync visitHistory)
DELIMITER //

CREATE TRIGGER after_appointment_update
AFTER UPDATE ON appointments
FOR EACH ROW
BEGIN
    IF NEW.status = 'Completed'
       AND OLD.status <> 'Completed'
       AND NOT EXISTS (
            SELECT 1
            FROM visit_history
            WHERE appointment_id = NEW.appointment_id
       ) THEN

        INSERT INTO visit_history (appointment_id, visit_date)
        VALUES (NEW.appointment_id, NOW());

    END IF;
END //

DELIMITER ;

-- BEFORE DELETE (block deletion)
DELIMITER //
CREATE TRIGGER before_patient_delete
BEFORE DELETE ON patients
FOR EACH ROW
BEGIN
 IF EXISTS (SELECT 1 FROM appointments WHERE patient_id = OLD.patient_id AND
status='Comleted') THEN
 SIGNAL SQLSTATE '45000'
 SET MESSAGE_TEXT = 'Cannot delete a patient with active appointments';
 END IF;
END //
DELIMITER ;

-- AFTER DELETE (archive)
DELIMITER //
CREATE TRIGGER after_patient_delete
AFTER DELETE ON patients
FOR EACH ROW
BEGIN
 INSERT INTO deletedpatientsarchive(patient_id, name, deleted_at)
 VALUES (OLD.patient_id, OLD.name, NOW());
END //
DELIMITER ;