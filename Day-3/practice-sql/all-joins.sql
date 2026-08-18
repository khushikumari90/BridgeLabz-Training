Use health_clinic_db;

-- INNER JOIN
Select p.name AS patient_name, a.appointment_date, d.name AS doctor_name
from appointments a
inner join patients p on a.patient_id = p.patient_id
inner join doctors d on a.doctor_id = d.doctor_id; 

-- LEFT JOIN 
SELECT p.name, a.appointment_date
FROM patients p
LEFT JOIN appointments a ON p.patient_id = a.patient_id;

--  Q: How do you find patients who have never had an appointment?
SELECT p.name FROM patients p
LEFT JOIN appointments a ON p.patient_id = a.patient_id
WHERE a.appointment_date IS NULL;

-- RIGHT JOIN 
SELECT d.name AS doctor, a.appointment_date
FROM appointments a
RIGHT JOIN doctors d ON a.doctor_id = d.doctor_id;

-- FULL OUTER JOIN
SELECT p.name, a.appointment_date
FROM patients p
LEFT JOIN appointments a ON p.patient_id = a.patient_id
UNION
SELECT p.name, a.appointment_date
FROM patients p
RIGHT JOIN appointments a ON p.patient_id = a.patient_id;

-- SELF JOIN
SELECT d.name AS doctor, m.name AS mentor
FROM doctors d
JOIN doctors m ON d.mentor_id = m.doctor_id;

-- CROSS JOIN
SELECT d.name AS doctor, r.room_number
FROM doctors d
CROSS JOIN rooms r
ORDER BY d.doctor_id, r.room_number;

-- MULTIPLE TABLE JOIN
SELECT p.name AS patient, d.name AS doctor, s.name AS specialization,
       a.appointment_date, b.amount, b.payment_status
FROM appointments a
JOIN patients p ON a.patient_id = p.patient_id
JOIN doctors d ON a.doctor_id = d.doctor_id
JOIN doctor_specializations ds ON d.doctor_id = ds.doctor_id
JOIN specializations s ON ds.specialization_id = s.specialization_id
LEFT JOIN billing b ON a.appointment_id = b.appointment_id;
