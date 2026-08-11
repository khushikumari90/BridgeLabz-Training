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

## Day 6 - CRUD Operations with Spring MVC & JDBC

### Topics Covered

#### CRUD Fundamentals
- Create, Read, Update, Delete operations
- Mapping CRUD operations to HTTP methods
- RESTful-style URL design (`/greetings`, `/greetings/add`, `/greetings/edit/{id}`, `/greetings/delete/{id}`)

#### JDBC Integration in Spring MVC
- DriverManager-based Connection utility
- PreparedStatement for parameterized queries
- ResultSet handling for multi-row and single-row queries
- Try-with-Resources for automatic connection closing

#### DAO Pattern in Spring MVC
- DAO interface and implementation separation
- @Repository annotation
- @Autowired dependency injection into Controller
- Component scanning across multiple packages (controller, dao)

#### Spring MVC Path Variables & Redirects
- @PathVariable for dynamic URLs
- @ModelAttribute for form binding
- redirect: prefix for post-action navigation (Post-Redirect-Get pattern)

#### Database Setup
- Creating MySQL database and table via schema script
- JDBC URL, username, and password configuration

#### Debugging & Tooling
- Running Spring MVC apps via IntelliJ Community Edition using Smart Tomcat plugin
- Resolving `NoSuchBeanDefinitionException` caused by incomplete component-scan
- Resolving `No suitable driver found` error caused by missing dependency reload
- Reading and interpreting Tomcat console logs and stack traces

### Practical Tasks

- Extended the Greeting Application to support full CRUD operations
- Created Greeting entity with id, name, and message fields
- Built GreetingDao interface and GreetingDaoImpl using plain JDBC
- Implemented addGreeting(), getAllGreetings(), getGreetingById(), updateGreeting(), and deleteGreeting() methods
- Created DBConnection utility class using DriverManager
- Built GreetingCrudController with endpoints for list, add, edit, and delete
- Created greetings-list.jsp to display all records in a table with Edit and Delete links
- Created a shared greetings-form.jsp used for both Add and Edit operations
- Fixed a Spring bean creation failure by updating component-scan to cover the dao package
- Fixed a JDBC driver error by adding mysql-connector-java dependency and reloading Maven
- Ran and tested the CRUD application end-to-end on Apache Tomcat via IntelliJ (Smart Tomcat plugin)
- Verified Add, Edit, and Delete operations reflect correctly in the MySQL database

### Day 7 - Spring Boot REST API & Contact Management

## Topics Covered

* Spring Boot Fundamentals
* REST API & HTTP Methods
* `@RestController`, `@GetMapping`, `@PostMapping`, `@PatchMapping`, `@DeleteMapping`
* Spring Data JPA & Hibernate
* Entity, Repository, Service & Controller
* DTO Pattern
* MySQL Integration
* Lombok
* CRUD Operations
* API Testing with Postman

## Practical Tasks

* Built a **Contact Management REST API** using Spring Boot.
* Connected the application with **MySQL** using Spring Data JPA.
* Created `Contact` entity with validation and unique constraints.
* Implemented `ContactRepository` using `JpaRepository`.
* Created Service and Controller layers following layered architecture.
* Implemented CRUD APIs:

  * `GET /contacts` – Get all contacts
  * `GET /contact/{id}` – Get contact by ID
  * `POST /contact` – Add contact
  * `PATCH /contact/{id}` – Update contact
  * `DELETE /contact/{id}` – Delete contact
* Used DTOs for request and response handling.
* Tested REST APIs using Postman.
