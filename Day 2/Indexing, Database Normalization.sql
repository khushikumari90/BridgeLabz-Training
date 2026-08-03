USE health_clinic_db;
CREATE TABLE rooms (
    id INT AUTO_INCREMENT PRIMARY KEY,
    room_number VARCHAR(20) NOT NULL,
    room_type VARCHAR(50)
);
CREATE TABLE doctor_room (
    doctor_id INT NOT NULL,
    room_id INT NOT NULL,
    PRIMARY KEY (doctor_id, room_id)
);
INSERT INTO rooms (room_number, room_type)
VALUES
('R101', 'General Consultation'),
('R102', 'Cardiology'),
('R103', 'Dermatology');

INSERT INTO doctor_room (doctor_id, room_id)
VALUES
(201, 1),
(202, 2),
(203, 3);

SELECT * FROM rooms;
SELECT * FROM doctor_room;
SELECT * FROM appointments;

EXPLAIN
SELECT * FROM appointments
WHERE doctor_id = 201;

CREATE INDEX idx_appointments_doctor
ON appointments(doctor_id);

EXPLAIN
SELECT * FROM appointments
WHERE doctor_id = 201;

CREATE INDEX idx_appointments_doctor_date
ON appointments(doctor_id, appointment_date);

EXPLAIN
SELECT * FROM appointments
WHERE doctor_id = 201
AND appointment_date = '2026-08-01 10:00:00';

CREATE TABLE patient_phones (
    patient_id INT,
    phone_number VARCHAR(15),
    PRIMARY KEY (patient_id, phone_number)
);
ALTER TABLE appointments
ADD COLUMN status VARCHAR(20);

CREATE INDEX idx_appointments_covering
ON appointments(doctor_id, appointment_date, status);

EXPLAIN
SELECT doctor_id, appointment_date, status
FROM appointments
WHERE doctor_id = 201;