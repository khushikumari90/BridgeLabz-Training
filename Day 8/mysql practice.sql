create database GLA;
use  GLA; Create Table student (
student_id INT PRIMARY KEY auto_increment,
roll_number VARCHAR(20) UNIQUE NOT Null,
first_name VARCHAR (50) NOT NULL,
last_name VARCHAR(50),
gender VARCHAR(10),
email VARCHAR(50) UNIQUE,
address VARCHAR(100) ,
city VARCHAR(50),
state VARCHAR(50),
course VARCHAR (100),
department VARCHAR(100),
admission_year Year,
created_at Timestamp
);

INSERT INTO student(roll_number, first_name,last_name,gender,email,address,city,state,course,
department,admission_year) values(
'GLA0101','Dipanshu','Sharma','Male','ds460893@gmail.com','ABC Colony','Alahabad',
'Uttarpradesh','btech','CSE','2022'
);

select * from student;

create table faculty (
faculty_id int primary key auto_increment,
first_name varchar(50) not null,
last_name varchar(50) not null,
gender varchar(10) not null,
email varchar(50) unique,
address varchar(100),
city varchar(20),
state varchar(20),
department varchar(50),
designation varchar(100),
joining_year year,
created_at timestamp default current_timestamp
);

desc faculty;

insert into faculty
(faculty_id, first_name, last_name, gender, email, address, city, state, department, designation, joining_year)
values
('101', 'bruce', 'banner', 'Male', 'bruce@gla.ac.in', 'lucknow UP', 'lucknow', 'UP', 'CS', 'Professor', 2024);

INSERT INTO faculty (first_name, last_name, gender, email, address, city, state, department, designation, joining_year) VALUES
('Tony', 'Stark', 'Male', 'tony@gla.ac.in', 'Malibu Point', 'Malibu', 'CA', 'ME', 'HOD', 2018),
('Natasha', 'Romanoff', 'Female', 'natasha@gla.ac.in', 'Red Room Lane', 'Moscow', 'MH', 'CS', 'Associate Professor', 2020),
('Steve', 'Rogers', 'Male', 'steve@gla.ac.in', 'Brooklyn Heights', 'Mathura', 'UP', 'EC', 'Assistant Professor', 2022),
('Wanda', 'Maximoff', 'Female', 'wanda@gla.ac.in', 'Westview Colony', 'Agra', 'UP', 'IT', 'Professor', 2019),
('Peter', 'Parker', 'Male', 'peter@gla.ac.in', 'Queens Street', 'Noida', 'UP', 'CS', 'Assistant Professor', 2023);

-- Additional Student records
INSERT INTO student (roll_number, first_name, last_name, gender, email, address, city, state, course, department, admission_year) VALUES
('GLA0102', 'Steve', 'Rogers', 'Male', 'steve.s@gmail.com', 'Sector 15', 'Noida', 'Uttarpradesh', 'btech', 'ME', 2022),
('GLA0103', 'Wanda', 'Maximoff', 'Female', 'wanda.m@gmail.com', 'Civil Lines', 'Mathura', 'Uttarpradesh', 'btech', 'CSE', 2023),
('GLA0104', 'Peter', 'Parker', 'Male', 'peter.p@gmail.com', 'MG Road', 'Agra', 'Uttarpradesh', 'btech', 'IT', 2021),
('GLA0105', 'Carol', 'Danvers', 'Female', 'carol.d@gmail.com', 'Air Force Colony', 'Lucknow', 'Uttarpradesh', 'btech', 'EC', 2022),
('GLA0106', 'Scott', 'Lang', 'Male', 'scott.l@gmail.com', 'Quantum Street', 'Kanpur', 'Uttarpradesh', 'btech', 'ME', 2023);

ALTER TABLE faculty
ADD COLUMN salary DECIMAL(10,2);
SET SQL_SAFE_UPDATES = 0;
DESC faculty;
UPDATE faculty SET salary = 95000.00 WHERE first_name = 'bruce' AND last_name = 'banner';
UPDATE faculty SET salary = 150000.00 WHERE first_name = 'Tony' AND last_name = 'Stark';
UPDATE faculty SET salary = 110000.00 WHERE first_name = 'Natasha' AND last_name = 'Romanoff';
UPDATE faculty SET salary = 75000.00 WHERE first_name = 'Steve' AND last_name = 'Rogers';
UPDATE faculty SET salary = 105000.00 WHERE first_name = 'Wanda' AND last_name = 'Maximoff';
UPDATE faculty
SET salary = 85000.00
WHERE first_name = 'Peter'
  AND last_name = 'Parker';
select department,max(salary)
as max_salary
from faculty
group by department;

select  faculty_id,first_name,last_name,department,salary
from faculty f
where salary>(
select avg(salary)
from faculty
where department =f.department
);

SELECT * FROM faculty;
SELECT * FROM student;