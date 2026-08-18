-- TRIGGER TESTING SCRIPT

-- 1. BEFORE INSERT & AFTER INSERT

-- Valid appointment (Should Succeed)
INSERT INTO appointments
(patient_id, doctor_id, appointment_date, status)
VALUES
(4, 2, DATE_ADD(CURDATE(), INTERVAL 2 DAY), 'Completed');

-- Verify Audit Log
SELECT * FROM AuditLog;


-- Uncomment this to test validation error
/*
INSERT INTO appointments
(patient_id, doctor_id, appointment_date,status)
VALUES
(1, 1, DATE_SUB(CURDATE(), INTERVAL 1 DAY),'Confirmed');
*/

-- 2. BEFORE UPDATE (Billing)
-- Check Billing Record Before Update
SELECT * FROM Billing WHERE bill_id = 1;

-- Update Payment Status
UPDATE Billing
SET payment_status = 'Paid'
WHERE bill_id = 1;

-- Verify bill_date was automatically updated
SELECT * FROM Billing WHERE bill_id = 1;

-- 3. AFTER UPDATE (Appointment)
-- Check Appointment Before Update
SELECT * FROM appointments WHERE appointment_id = 1;

-- Mark Appointment Completed
UPDATE appointments SET status = 'Completed' WHERE appointment_id = 3;

-- Verify Audit Log
SELECT * FROM auditlog;

-- 4. BEFORE DELETE
-- This should FAIL if patient has Confirmed appointments
-- Uncomment to test
/*
DELETE FROM patients
WHERE patient_id = 1;
*/

-- Cancel appointments first
UPDATE appointments SET status = 'Cancelled' WHERE patient_id = 1;

-- 5. AFTER DELETE
-- Delete patient
DELETE FROM patients
WHERE patient_id = 1;
-- Verify Archive Table
SELECT * FROM DeletedPatientsArchive;

-- 6. VERIFY ALL TABLES
SELECT * FROM Appointments;
SELECT * FROM Billing;
SELECT * FROM visit_history;
SELECT * FROM AuditLog;
SELECT * FROM DeletedPatientsArchive;
SELECT * FROM Patients;