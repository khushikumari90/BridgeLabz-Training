/*
	 3. Take the patient_phones design and verify it satisfies 1NF, 2NF, and 3NF — 
     write a short justification for each.
*/

DROP TABLE IF EXISTS patient_phones;

CREATE TABLE patient_phones (
 phone_id INT AUTO_INCREMENT PRIMARY KEY,
 patient_id INT NOT NULL,
 phone_number VARCHAR(15) NOT NULL,
 FOREIGN KEY (patient_id) REFERENCES patients(patient_id) ON DELETE CASCADE,
 INDEX idx_patient_id (patient_id)
);

/*
Justification :
 - 1NF (atomic values, no repeating groups): Each row holds exactly one phone_number, not a comma-separated list. 
 A patient with multiple numbers gets multiple rows instead of one row with a multi-valued field. 
 Every column holds a single atomic value → satisfies 1NF.
 
- 2NF (no partial dependency on part of the key): The primary key is phone_id alone — a single-column key, not composite — 
so there's no possibility of a partial dependency (partial dependencies only arise with composite keys). 
patient_id and phone_number each depend on the whole key. → satisfies 2NF.

- 3NF (no transitive dependency on non-key columns): patient_id and phone_number both depend directly on phone_id; neither depends on the other. 
There's no non-key column determining another non-key column (e.g. phone_number doesn't determine anything else in the row). → satisfies 3NF.
*/