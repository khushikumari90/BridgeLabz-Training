/*
	2. Write and run EXPLAIN on at least 3 different queries against the appointments table —
    one with no index, one using a single-column index, one using the composite index — and
    note the differences in the type and rows columns.
*/

-- Query A — no index (status, an ENUM column with no index):
EXPLAIN SELECT * FROM appointments WHERE status = 'Completed';

-- Query B — single-column index (idx_patient_id):
EXPLAIN SELECT * FROM appointments WHERE patient_id = 250;

-- Query C — composite index (idx_doctor_date):
EXPLAIN SELECT * FROM appointments
WHERE doctor_id = 5 AND appointment_date BETWEEN '2026-01-01' AND '2026-01-02';