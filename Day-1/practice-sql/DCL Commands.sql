-- DCL Commands
CREATE USER 'bhuvneshsingh292@gmail.com'@'%' IDENTIFIED BY 'Bhuvi@123';

-- Grant a user SELECT and INSERT permission on our database
GRANT SELECT, INSERT ON health_clinic_db.* TO 'bhuvneshsingh292@gmail.com'@'%';

-- Revoke a permission
REVOKE INSERT ON health_clinic_db.* FROM 'bhuvneshsingh292@gmail.com'@'%';