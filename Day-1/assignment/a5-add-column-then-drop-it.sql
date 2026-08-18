-- 5. Practice ALTER TABLE: add a column, then drop it
 
ALTER TABLE specializations ADD COLUMN department_head VARCHAR(100);

-- verify it's there
DESCRIBE specializations;

-- now drop it
ALTER TABLE specializations DROP COLUMN department_head;