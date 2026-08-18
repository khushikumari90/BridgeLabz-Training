-- Create basic Doctors table
CREATE TABLE doctors (
 doctor_id INT AUTO_INCREMENT PRIMARY KEY,
 first_name VARCHAR(50) NOT NULL,
 last_name VARCHAR(50) NOT NULL,
 specialization VARCHAR(100),
 phone_number VARCHAR(15) UNIQUE,
 email VARCHAR(100)
);
-- Insert sample data
INSERT INTO doctors (first_name, last_name, specialization, phone_number, email)
VALUES
('Anjali', 'Rao', 'Cardiology', '9123456780', 'dr.rao@clinic.com'),
('Vikram', 'Iyer', 'Pediatrics', '9123456781', 'dr.iyer@clinic.com');

-- Verify
SELECT * FROM doctors;