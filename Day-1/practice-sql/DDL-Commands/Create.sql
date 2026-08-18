use health_clinic_db;

-- a) CREATE
CREATE TABLE patients (
 patient_id INT AUTO_INCREMENT PRIMARY KEY,
 first_name VARCHAR(50) NOT NULL,
 last_name VARCHAR(50) NOT NULL,
 date_of_birth DATE,
 gender ENUM('Male', 'Female', 'Other'),
 phone_number VARCHAR(15) UNIQUE,
 email VARCHAR(100),
 registered_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


