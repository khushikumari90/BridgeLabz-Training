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

## Day 4 - JDBC, Layered Architecture & Transaction Management

### Topics Covered

**JDBC Fundamentals**
* JDBC Architecture & Drivers
* Connection URL, DriverManager
* Statement vs PreparedStatement
* ResultSet Handling
* PreparedStatement & SQL Injection Prevention
* Try-with-Resources

**Design Patterns**
* DTO (Data Transfer Object) Pattern
* DAO (Data Access Object) Pattern
* Interface vs Implementation separation
* Layered Architecture (UI → Service → DAO → DTO → Database)

**Transaction Management**
* ACID Properties (Atomicity, Consistency, Isolation, Durability)
* Auto-commit vs Manual commit
* COMMIT and ROLLBACK in Java
* Multi-step transactions across multiple tables
* Connection Pooling with HikariCP

**Application Development**
* Console-based UI design
* Maven project structure & dependency management
* Building a runnable JAR (Maven Shade Plugin)

### Practical Tasks

* Designed and built **HealthClinicApp** — a full console-based Health Clinic Management System
* Implemented layered architecture: `UI (ConsoleMenu)` → `Service (AppointmentService)` → `DAO` → `DTO` → `MySQL`
* Created 6 DTOs: `Patient`, `Doctor`, `Specialization`, `Appointment`, `Billing`, `VisitHistory`
* Built full CRUD DAOs (interface + implementation) for all 6 entities
* Implemented `HikariConnectionPool` for connection pooling instead of opening a new connection per query
* Built `AppointmentService.completeAppointment()` — a transactional method that:
  * Updates appointment status to `Completed`
  * Inserts a `billing` record
  * Inserts a `visit_history` record
  * Commits all three writes together, or rolls back all three on failure
* Verified transaction safety by intentionally passing an invalid appointment ID and confirming no partial data was saved
* Built a full console menu (`ConsoleMenu`) covering registration, booking, completion, cancellation, rescheduling, and viewing for every entity
* Added input validation for bad input, duplicate emails, and invalid dates
* Packaged the project using Maven (`pom.xml`) with MySQL Connector/J and HikariCP dependencies
* Verified end-to-end data flow: Console input → Service → DAO → MySQL → back to Console output

### Project Structure

```
HealthClinicApp/
├── pom.xml
├── database/health_clinic_schema.sql
└── src/main/java/com/clinic/
    ├── Main.java
    ├── dto/         (Patient, Doctor, Specialization, Appointment, Billing, VisitHistory)
    ├── config/      (HikariConnectionPool)
    ├── dao/         (6 DAO interfaces + 6 implementations)
    ├── service/     (AppointmentService)
    └── ui/          (ConsoleMenu)
```

# Day 5 - Servlets & Spring MVC Architecture

## Topics Covered

### Servlet Fundamentals
- What is a Servlet
- Servlet Life Cycle (init, service, destroy)
- Servlet Container (Tomcat)
- web.xml Configuration
- doGet() vs doPost()
- Request and Response Objects

### Introduction to Spring MVC
- Why Spring MVC over plain Servlets
- Front Controller Pattern
- DispatcherServlet
- Spring MVC Request Flow

### MVC Architecture
- Model
- View
- Controller
- Separation of Concerns

### Spring MVC Configuration
- Component Scanning (@Controller)
- InternalResourceViewResolver
- Mapping Views with JSP
- @GetMapping and @PostMapping
- @RequestParam
- Model and ModelAttribute

### Building & Deployment
- Maven WAR Packaging
- Deploying WAR on Apache Tomcat
- Running Spring MVC App via IntelliJ (Smart Tomcat Plugin)

## Practical Tasks

- Built a Greeting Application using Spring MVC following MVC architecture
- Created GreetingController with one GET method (`/greeting`) to display the form
- Created one POST method (`/greeting`) to process form input and return a greeting message
- Configured DispatcherServlet in web.xml as the front controller
- Set up greeting-servlet.xml with component-scan and InternalResourceViewResolver
- Built GreetingModel as the Model layer
- Created greeting.jsp as the View layer using JSTL
- Verified GET request renders the form on first page load
- Verified POST request correctly binds
