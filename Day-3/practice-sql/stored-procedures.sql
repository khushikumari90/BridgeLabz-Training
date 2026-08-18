-- STORED PROCEDURE

-- Creating Procedures
DELIMITER //
CREATE PROCEDURE GetPatientAppointments(IN pid INT)
BEGIN
 SELECT a.appointment_date, d.name AS doctor
 FROM appointments a
 JOIN doctors d ON a.doctor_id = d.doctor_id
 WHERE a.patient_id = pid;
END //
DELIMITER ;

-- Calling Procedure
CALL GetPatientAppointments(1);

-- Using IN Parameter
DELIMITER //
CREATE PROCEDURE AddPatient(IN p_name VARCHAR(100), IN p_gender varchar(10))
BEGIN
 INSERT INTO patients(name, email) VALUES (p_name, p_gender);
END //
DELIMITER ;

CALL AddPatient('Ravi Kumar', 'Male');

-- Using OUT Parameter
DELIMITER //
CREATE PROCEDURE GetPatientCount(OUT total INT)
BEGIN
 SELECT COUNT(*) INTO total FROM patients;
END //
DELIMITER ;

CALL GetPatientCount(@count);
SELECT @count;

-- Using INOUT Parameter
DELIMITER //
CREATE PROCEDURE ApplyDiscount(INOUT amount DECIMAL(10,2))
BEGIN
 SET amount = amount - (amount * 0.10);
END //
DELIMITER ;

SET @bill = 1000;
CALL ApplyDiscount(@bill);
SELECT @bill; -- 900

-- Exception handling 
DELIMITER //
CREATE PROCEDURE SafeInsertPatient(IN p_name VARCHAR(100), IN p_phone VARCHAR(15))
BEGIN
 DECLARE EXIT HANDLER FOR SQLEXCEPTION
 BEGIN
 ROLLBACK;
 SELECT 'Error: Could not insert patient' AS message;
 END;
 START TRANSACTION;
 INSERT INTO Patients(name, phone) VALUES (p_name, p_phone);
 COMMIT;
END //
DELIMITER ;




