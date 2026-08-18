-- e) RENAME 
RENAME TABLE patients TO clinic_patients;

-- rename back for consistency with our plan
RENAME TABLE clinic_patients TO patients;