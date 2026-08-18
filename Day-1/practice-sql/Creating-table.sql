-- Creating our first Health Clinic table:
    create table patients(
		patient_id int auto_increment primary key,
        first_name varchar(20) not null,
        last_name varchar(20) not null,
        date_of_birth date,
        gender enum('Male', 'Female', 'Other'),
        phone_number varchar(15) unique,
        email varchar(100),
        registered_on timestamp default current_timestamp
    );
    
    
    -- Show all attributes and fields of table
    Select * from patients;