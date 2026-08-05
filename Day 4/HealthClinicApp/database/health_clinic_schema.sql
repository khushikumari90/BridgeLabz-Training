-- =====================================================================
-- HealthClinicApp — Database Schema (Step 1: The Basement)
-- Run this once, manually, in MySQL, before the Java app ever starts.
-- =====================================================================

CREATE DATABASE IF NOT EXISTS health_clinic_db;
USE health_clinic_db;

-- ---------------------------------------------------------------------
-- App user (least-privilege account the Java app connects with)
-- ---------------------------------------------------------------------
CREATE USER IF NOT EXISTS 'clinic_app_user'@'localhost' IDENTIFIED BY 'StrongPassword123!';
GRANT SELECT, INSERT, UPDATE, DELETE ON health_clinic_db.* TO 'clinic_app_user'@'localhost';
FLUSH PRIVILEGES;

-- ---------------------------------------------------------------------
-- patients
-- ---------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS patients (
    patient_id      INT AUTO_INCREMENT PRIMARY KEY,
    first_name      VARCHAR(50)  NOT NULL,
    last_name       VARCHAR(50)  NOT NULL,
    email           VARCHAR(100) NOT NULL UNIQUE,
    phone           VARCHAR(20),
    date_of_birth   DATE,
    address         VARCHAR(255),
    created_at      TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ---------------------------------------------------------------------
-- specializations
-- ---------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS specializations (
    specialization_id INT AUTO_INCREMENT PRIMARY KEY,
    name               VARCHAR(100) NOT NULL UNIQUE
);

-- ---------------------------------------------------------------------
-- doctors
-- ---------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS doctors (
    doctor_id          INT AUTO_INCREMENT PRIMARY KEY,
    first_name         VARCHAR(50)  NOT NULL,
    last_name          VARCHAR(50)  NOT NULL,
    email              VARCHAR(100) NOT NULL UNIQUE,
    phone              VARCHAR(20),
    specialization_id  INT,
    created_at         TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (specialization_id) REFERENCES specializations(specialization_id)
        ON DELETE SET NULL
);

-- ---------------------------------------------------------------------
-- appointments
-- ---------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS appointments (
    appointment_id   INT AUTO_INCREMENT PRIMARY KEY,
    patient_id       INT NOT NULL,
    doctor_id        INT NOT NULL,
    appointment_date DATETIME NOT NULL,
    status           ENUM('Scheduled','Completed','Cancelled') NOT NULL DEFAULT 'Scheduled',
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (patient_id) REFERENCES patients(patient_id) ON DELETE CASCADE,
    FOREIGN KEY (doctor_id)  REFERENCES doctors(doctor_id)   ON DELETE CASCADE,
    INDEX idx_appt_patient (patient_id),
    INDEX idx_appt_doctor  (doctor_id),
    INDEX idx_appt_date    (appointment_date)
);

-- ---------------------------------------------------------------------
-- billing
-- "every bill must point to a real appointment, and no two bills can
--  point to the same one" — the UNIQUE constraint blocks double-billing.
-- ---------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS billing (
    billing_id       INT AUTO_INCREMENT PRIMARY KEY,
    appointment_id   INT NOT NULL UNIQUE,
    amount           DECIMAL(10,2) NOT NULL,
    payment_status   ENUM('Pending','Paid') NOT NULL DEFAULT 'Pending',
    billing_date     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id) ON DELETE CASCADE
);

-- ---------------------------------------------------------------------
-- visit_history
-- ---------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS visit_history (
    visit_id         INT AUTO_INCREMENT PRIMARY KEY,
    appointment_id   INT NOT NULL,
    diagnosis        TEXT,
    notes            TEXT,
    visit_date       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id) ON DELETE CASCADE
);

-- ---------------------------------------------------------------------
-- audit_log — every billing insert/update gets recorded automatically.
-- This is the Day 3 "Triggers for the audit log" piece.
-- ---------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS audit_log (
    audit_id     INT AUTO_INCREMENT PRIMARY KEY,
    table_name   VARCHAR(50) NOT NULL,
    action       VARCHAR(20) NOT NULL,
    record_id    INT NOT NULL,
    action_time  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    details      VARCHAR(255)
);

DELIMITER //

CREATE TRIGGER IF NOT EXISTS trg_billing_after_insert
AFTER INSERT ON billing
FOR EACH ROW
BEGIN
    INSERT INTO audit_log (table_name, action, record_id, details)
    VALUES ('billing', 'INSERT', NEW.billing_id,
            CONCAT('New bill for appointment ', NEW.appointment_id, ' amount ', NEW.amount));
END//

CREATE TRIGGER IF NOT EXISTS trg_billing_after_update
AFTER UPDATE ON billing
FOR EACH ROW
BEGIN
    INSERT INTO audit_log (table_name, action, record_id, details)
    VALUES ('billing', 'UPDATE', NEW.billing_id,
            CONCAT('Status changed from ', OLD.payment_status, ' to ', NEW.payment_status));
END//

DELIMITER ;

-- ---------------------------------------------------------------------
-- Seed data — a couple of specializations to get started
-- ---------------------------------------------------------------------
INSERT IGNORE INTO specializations (name) VALUES
  ('General Medicine'), ('Cardiology'), ('Dermatology'), ('Pediatrics'), ('Orthopedics');

-- ---------------------------------------------------------------------
-- Verification query — run this after setup:
--   DESCRIBE billing;   -> confirm 'appointment_id' shows UNI under Key
-- ---------------------------------------------------------------------
