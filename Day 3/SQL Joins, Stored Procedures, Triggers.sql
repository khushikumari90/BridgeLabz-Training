USE health_clinic_db;
SHOW TABLES;
CREATE TABLE patients (
    patient_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    dob DATE,
    gender VARCHAR(10),
    phone VARCHAR(15),
    address VARCHAR(255)
);
INSERT INTO patients (patient_id, name, dob, gender, phone, address)
VALUES
(101, 'Khushi', '2001-10-16', 'Female', '9876543210', 'Agra'),
(102, 'Ravi Kumar', '1998-05-20', 'Male', '9876543211', 'Delhi'),
(103, 'Priya Sharma', '2000-08-15', 'Female', '9876543212', 'Mathura');
CREATE TABLE doctors (
    doctor_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(15),
    specialization_id INT
);
INSERT INTO doctors (doctor_id, name, phone, specialization_id)
VALUES
(201, 'Dr. Amit', '9876543220', 1),
(202, 'Dr. Neha', '9876543221', 2),
(203, 'Dr. Rahul', '9876543222', 3);
SELECT * FROM patients;

SELECT * FROM doctors;

SELECT * FROM appointments;
SELECT 
    p.name AS patient_name,
    a.appointment_date,
    d.name AS doctor_name
FROM appointments a
INNER JOIN patients p
    ON a.patient_id = p.patient_id
INNER JOIN doctors d
    ON a.doctor_id = d.doctor_id;
SELECT 
    p.name,
    a.appointment_date
FROM patients p
LEFT JOIN appointments a
    ON p.patient_id = a.patient_id;
SELECT 
    d.name AS doctor,
    a.appointment_date
FROM appointments a
RIGHT JOIN doctors d
    ON a.doctor_id = d.doctor_id;
SELECT 
    p.name,
    a.appointment_date
FROM patients p
LEFT JOIN appointments a
    ON p.patient_id = a.patient_id
UNION
SELECT 
    p.name,
    a.appointment_date
FROM patients p
RIGHT JOIN appointments a
    ON p.patient_id = a.patient_id;
ALTER TABLE doctors
ADD COLUMN mentor_id INT;
UPDATE doctors
SET mentor_id = 201
WHERE doctor_id = 202;
SELECT 
    d.name AS doctor,
    m.name AS mentor
FROM doctors d
JOIN doctors m
    ON d.mentor_id = m.doctor_id;
CREATE TABLE time_slots (
    slot_id INT AUTO_INCREMENT PRIMARY KEY,
    slot_time TIME
);
INSERT INTO time_slots (slot_time)
VALUES
('09:00:00'),
('10:00:00'),
('11:00:00');
SELECT 
    d.name,
    t.slot_time
FROM doctors d
CROSS JOIN time_slots t;

SELECT 
    p.name AS patient,
    d.name AS doctor,
    s.name AS specialization,
    a.appointment_date
FROM appointments a
JOIN patients p
    ON a.patient_id = p.patient_id
JOIN doctors d
    ON a.doctor_id = d.doctor_id
JOIN specializations s
    ON d.specialization_id = s.id;
    
DELIMITER //

CREATE PROCEDURE GetPatientAppointments(IN pid INT)
BEGIN
    SELECT 
        a.appointment_date,
        d.name AS doctor
    FROM appointments a
    JOIN doctors d
        ON a.doctor_id = d.doctor_id
    WHERE a.patient_id = pid;
END //

DELIMITER ;

CALL GetPatientAppointments(101);