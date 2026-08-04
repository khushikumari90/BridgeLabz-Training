# Refresher Training

## Day 1 - DBMS Fundamentals & RDBMS Basics

### Topics Covered

- What is Data
- Database
- DBMS (Database Management System)
- File System vs DBMS
- Advantages of DBMS
- Types of DBMS
- RDBMS (Relational Database Management System)
- Features of RDBMS
- Relational Database vs Non-Relational Database
- SQL vs NoSQL
- When to Use SQL
- When to Use NoSQL
- Introduction to MySQL
- MySQL Architecture
- Installing MySQL
- Creating a Database
- Creating Tables
- DDL Commands (CREATE, ALTER, DROP, TRUNCATE, RENAME)
- DML Commands (INSERT, UPDATE, DELETE)
- TCL Commands (COMMIT, ROLLBACK, SAVEPOINT)
- DCL Commands (GRANT, REVOKE)

### Practical Tasks

- Installed and verified MySQL using `SELECT VERSION();`
- Created the `health_clinic_db` database
- Created `specializations` and `appointments` tables
- Inserted sample records into both tables
- Performed `ALTER TABLE` (ADD and DROP COLUMN)
- Executed `UPDATE` and `DELETE` queries with `WHERE` clause
- Verified changes using `SELECT` statements
- Created a new MySQL user (`clinic_app_user`)
- Granted `SELECT`, `INSERT`, `UPDATE`, and `DELETE` privileges on `health_clinic_db`

## Day 2 - Database Design, Relationships & Indexing

### Topics Covered

* ER Diagram
* Database Relationships
* One-to-One (1:1)
* One-to-Many (1:M)
* Many-to-Many (M:M)
* Primary Key & Foreign Key
* Relationship Tables
* Database Normalization
* 1NF, 2NF & 3NF
* Indexing
* Single-Column Index
* Composite Index
* Covering Index
* EXPLAIN Query
* Query Optimization

### Practical Tasks

* Extended `health_clinic_db` schema
* Created `rooms` table
* Created `doctor_room` relationship table
* Created and tested single-column and composite indexes
* Used `EXPLAIN` to analyze query performance
* Verified `patient_phones` design for 1NF, 2NF and 3NF
* Created and verified a covering index using `EXPLAIN`
* Created ER Diagram for the Health Clinic database

## Day 3 - SQL Joins, Stored Procedures & Triggers

### Topics Covered

#### SQL Joins
- INNER JOIN
- LEFT JOIN
- RIGHT JOIN
- FULL OUTER JOIN
- SELF JOIN
- CROSS JOIN
- Multiple Table JOIN

#### Stored Procedures
- Why Stored Procedures
- Creating Procedures
- Calling Procedures
- IN Parameter
- OUT Parameter
- INOUT Parameter
- Error Handling

#### Triggers
- BEFORE INSERT
- AFTER INSERT
- BEFORE UPDATE
- AFTER UPDATE
- BEFORE DELETE
- AFTER DELETE

### Practical Tasks

- Performed different types of SQL JOINs
- Created and called Stored Procedures
- Practiced IN, OUT and INOUT parameters
- Implemented Error Handling
- Created BEFORE and AFTER Triggers
- Used NEW and OLD values in Triggers
- Implemented validation and audit logging
- Worked with the Health Clinic database schema

