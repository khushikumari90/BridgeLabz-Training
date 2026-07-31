SELECT VERSION();
CREATE DATABASE IF NOT EXISTS health_clinic_db;
USE health_clinic_db;
CREATE TABLE specializations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255)
);
CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    doctor_id INT NOT NULL,
    appointment_date DATETIME NOT NULL
);
INSERT INTO specializations (name, description)
VALUES
('Cardiology', 'Heart specialist'),
('Dermatology', 'Skin specialist'),
('Neurology', 'Brain and nervous system specialist');
INSERT INTO appointments (patient_id, doctor_id, appointment_date)
VALUES
(101, 201, '2026-08-01 10:00:00'),
(102, 202, '2026-08-02 11:30:00'),
(103, 203, '2026-08-03 09:15:00');
SELECT * FROM specializations;
SELECT * FROM appointments;
ALTER TABLE specializations
ADD COLUMN status VARCHAR(20);
DESC specializations;
ALTER TABLE specializations
DROP COLUMN status;
DESC specializations;
SELECT * FROM specializations;
UPDATE specializations
SET description = 'Heart and Blood Vessel Specialist'
WHERE id = 1;
SELECT * FROM specializations;
SELECT * FROM appointments;
DELETE FROM appointments
WHERE id = 3;
SELECT * FROM appointments;
CREATE USER 'clinic_app_user'@'localhost'
IDENTIFIED BY 'Clinic@123';
GRANT SELECT, INSERT, UPDATE, DELETE
ON health_clinic_db.*
TO 'clinic_app_user'@'localhost';
FLUSH PRIVILEGES;
SHOW GRANTS FOR 'clinic_app_user'@'localhost';