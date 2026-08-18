-- 4. Insert at least 3 sample rows into each new table
 
INSERT INTO specializations (name, description)
VALUES
('Cardiology', 'Heart and cardiovascular system care'),
('Pediatrics', 'Medical care for infants, children, and adolescents'),
('Orthopedics', 'Bones, joints, ligaments, and muscles');
 
INSERT INTO appointments (patient_id, doctor_id, appointment_date)
VALUES
(1, 101, '2026-08-05 10:00:00'),
(2, 102, '2026-08-05 11:30:00'),
(1, 102, '2026-08-06 09:15:00');