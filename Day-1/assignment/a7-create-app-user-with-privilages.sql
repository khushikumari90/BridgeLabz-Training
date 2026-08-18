-- 7. Create a dedicated app user with only the privileges it needs
 
CREATE USER IF NOT EXISTS 'clinic_app_user'@'localhost' IDENTIFIED BY 'StrongPassword123!';
GRANT SELECT, INSERT, UPDATE, DELETE ON health_clinic_db.* TO 'clinic_app_user'@'localhost';
FLUSH PRIVILEGES;
 
-- verify the grant
SHOW GRANTS FOR 'clinic_app_user'@'localhost';