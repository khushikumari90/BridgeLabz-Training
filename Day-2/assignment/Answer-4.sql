/*
	4- Create a covering index for a query that reports doctor_id, appointment_date,
    status from the appointments table, and verify with EXPLAIN that Extra shows Using index.
*/

CREATE INDEX idx_covering_doctor_report
ON appointments (doctor_id, appointment_date, status);

EXPLAIN SELECT doctor_id, appointment_date, status
FROM appointments
WHERE doctor_id = 5
ORDER BY appointment_date;