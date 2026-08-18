-- b) ALTER 

-- Add a column
ALTER TABLE patients ADD COLUMN address VARCHAR(200);

-- Modify a column's datatype
ALTER TABLE patients MODIFY COLUMN phone_number VARCHAR(20);

-- Rename a column (MySQL 8+)
ALTER TABLE patients CHANGE COLUMN address home_address VARCHAR(200);

-- Drop a column
ALTER TABLE patients DROP COLUMN home_address;