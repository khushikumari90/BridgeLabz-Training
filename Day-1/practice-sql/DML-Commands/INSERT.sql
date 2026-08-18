-- a) INSERT
INSERT INTO patients(first_name, last_name, date_of_birth, gender, phone_number, email)
VALUES('Bhuvnesh','Bhadauriya','2004-11-18','Male','7451099215','bhuvneshsingh292@gmail.com');

-- Multiple rows at once
INSERT INTO patients (first_name, last_name, date_of_birth, gender, phone_number, email)
VALUES
('Sita', 'Sharma', '1990-08-21', 'Female', '9876543211', 'sita@email.com'),
('Aman', 'Verma', '1990-08-21', 'Male', '9876543212', 'aman@email.com');