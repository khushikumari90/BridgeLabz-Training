-- 6. One UPDATE and one DELETE, each verified with SELECT before and after
 
-- --- UPDATE example ---
SELECT * FROM appointments WHERE id = 2;                 -- BEFORE
UPDATE appointments
SET appointment_date = '2026-08-05 14:00:00'
WHERE id = 2;
SELECT * FROM appointments WHERE id = 2;                 -- AFTER
 
-- --- DELETE example ---
SELECT * FROM appointments WHERE id = 3;                 -- BEFORE
DELETE FROM appointments WHERE id = 3;
SELECT * FROM appointments WHERE id = 3;                 -- AFTER (should return empty)