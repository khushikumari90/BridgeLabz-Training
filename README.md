# Welcome to the Daily Updates of Refresher Training 🚀

---

## Day 1 — DBMS Fundamentals & RDBMS Basics

### 📌 Done on (31-07-2026)

- Understood the hierarchy: **Data → Database → DBMS → RDBMS**
- Compared File System vs DBMS and explored the advantages of DBMS.
- Learned different DBMS models and SQL vs NoSQL.
- Installed MySQL and studied its internal architecture.
- Practiced DDL, DML, TCL, and DCL commands.
- Designed the initial Health Clinic database with **Patients** and **Doctors** tables.
- Solved all practice and interview questions.

### ✅ Assignment

[Day 1 Assignment](https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-1/assignment)

---

## Day 2 — ER Diagram, Indexing & Database Normalization

### 📌 Done on (03-08-2026)

- Designed a complete ER Diagram for the Health Clinic application.
- Learned Indexing (Clustered, Non-Clustered, Composite, Covering, Unique) and analyzed queries using `EXPLAIN`.
- Mastered Normalization (1NF → BCNF) and understood Denormalization.
- Built the fully normalized Health Clinic database schema with proper indexes.
- Solved all practice and interview questions.

### ✅ Assignment

[Day 2 Assignment](https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-2/assignment)

---

## Day 3 — SQL Joins, Stored Procedures & Triggers

### 📌 Done on (04-08-2026)

- Practiced all major SQL JOINs and complex multi-table queries.
- Learned Stored Procedures with parameters, transactions, and error handling.
- Implemented BEFORE/AFTER Triggers using `NEW` and `OLD`.
- Built procedures and triggers for the Health Clinic project.
- Solved all practice and interview questions.

---

## Day 4 — JDBC, Transactions & Health Clinic Console Application

### 📌 Done on (05-08-2026)

- Connected Java with MySQL using JDBC.
- Learned DriverManager, PreparedStatement, ResultSet, and Exception Handling.
- Understood SQL Injection prevention using PreparedStatement.
- Implemented Transaction Management (`commit`, `rollback`, `savepoint`).
- Learned HikariCP Connection Pooling and compared it with DriverManager.
- Built a layered Java application using **DTO → DAO → Service → UI** architecture.
- Implemented CRUD operations for **Patients, Doctors, Appointments, Billing, and Visit History**.
- Completed the **Health Clinic Console Application** using Java, JDBC, Maven, and MySQL.

### 🚀 Project

[Health Clinic Console Application](https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-4/HealthClinicApp)

## Day 5 — Tomcat, Servlets & Spring Introduction

### 📌 Done on (06-08-2026)

- Learned the role of **Apache Tomcat** as a Web/Servlet Container and how it executes Servlets.
- Understood the **Servlet Lifecycle** and the complete Browser → Tomcat → Servlet → Browser request-response flow.
- Configured **Apache Tomcat** with IntelliJ IDEA using Smart Tomcat.
- Built and successfully deployed the **First Servlet Application**.
- Learned URL mapping using `@WebServlet` and request handling through `doGet()`.
- Explored the basics of the **Spring Framework** and why it is used.
- Learned the core concepts of **Inversion of Control (IoC)** and **Dependency Injection (DI)**.
- Related Spring's dependency injection to manual object creation (`new`) used in previous Java console applications.
- Deployed basic servlet on tomcat
- Explore Spring's IoC container with a simple bean example

### 📂 Practice Projects:

- [HelloWorldDemo](https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-5/HelloWorldDemo) — Built a basic Spring Boot application and practiced Spring MVC/REST request handling.
- [SpringConcepts](https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-5/Springconcepts) — Practiced Spring IoC, `ApplicationContext`, Dependency Injection, Spring annotations, and logging.
- [GreetingsApp](https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-5/GreetingsApp) — Built a Spring Boot application using REST, JPA, H2, CRUD operations, validation, and custom JPA queries.
- [FirstSpringApp](https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-5/firstspringapp) - Created a *basic Spring Boot application* and learned the fundamentals of Spring Boot application setup and execution.

### 📂 Assigned Project:

- [First Servlet App](https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-5/FirstServletProject)

- Click above and check the code in "src/main" folder.  

## Day 6 — Spring MVC

### 📌 Done from (07-08-2026 to 09-08-2026)

- Understood **Spring MVC architecture** and the role of `DispatcherServlet`.
- Learned how **Controllers and Views** work in Spring MVC.
- Learned request mapping and request handling using `@Controller`, `@RequestMapping`, `@GetMapping`, and `@PostMapping`.
- Understood how `DispatcherServlet` acts as the single entry point for HTTP requests.
- Built the required **My Greetings App** using Spring MVC.
- Learned how Spring MVC connects the **Controller → Service → DAO** layers.
- Migrated the existing **HealthClinicApp** from `ConsoleMenu` to Spring MVC Controllers while keeping the existing Service and DAO layers.
- Tested HTTP requests and responses through Spring MVC endpoints.
- Build My Greetings App using Spring MVC

### 📂 Assigned Project:

- [My Greetings App](https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-6/MyGreetingsApp)

### 📂 Migrated Project:

-[HealthClinic](https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-6/HealthClinicApp)

## Day 7 — Spring REST API & Request Handling
### 📌 Done on (10-08-2026)

-  Learned proper REST conventions — resource-based URLs, with HTTP methods carrying the action.
- Used ResponseEntity for explicit control over HTTP status codes such as 200, 201, 204, and 404.
- Learned Bean Validation with @NotBlank, @Email, @Pattern, and @Valid to reject bad input before business
logic.
- Centralized error handling with @ControllerAdvice and @ExceptionHandler instead of repeating try/catch logic in
every Controller.
- Set up H2 in-memory database for zero-install, fast-iteration development and understood its trade-off compared
with MySQL.
- Got a conceptual grounding in Distributed Architectures — why systems split into services and what complexity
that introduces.
- Started the Contacts App with working, validated, properly status-coded REST endpoints.

### 📂 Project:
- [ContactsApp](https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-7/ContactsApp)

## Day 8 - API Testing Tools & SDLC Exposure

### 📌 Done on (11-08-2026)

- Learned REST Assured's Given / When / Then structure for automated API testing instead of manual
Postman/curl checks.
- Covered happy-path and unhappy-path tests, connecting directly to Day 7 status-code and validation behavior.
- Learned JSON Server for mocking and enabling parallel frontend/backend development, and understood what it
is not for.
- Mapped Requirement, Design, Implementation, Testing, Deployment, and Maintenance to the course.
- Compared Waterfall and Agile and understood why Agile is more common for evolving requirements.
- Finished the Contacts App with a complete automated test suite, closing the Backend Basics phase of Days 5–8.

### 📂 Practice Project(Live Coding):

- [College App](https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-8/collegedb-app)
- [ContactsApp-withTests](https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-8/ContactsApp/src)

## Day 9 - Spring Boot Fundamentals

### 📌 Done on (12-08-2026)
- Spring Boot is built on top of Spring; it does not replace Spring Core or Spring MVC.
- Auto-configuration is conditional and depends heavily on the classpath and application properties.
- Spring Boot starters group commonly required dependencies into convenient Maven coordinates.
- Embedded Tomcat allows a Spring Boot application to run as an executable JAR without a separately
installedserver.
- @RestController and @GetMapping belong to Spring MVC; Spring Boot provides the surrounding infrastructure.
- Spring Initializr provides a practical way to create a correctly structured Spring Boot project.
- The Contacts App can be extended with a search-by-name endpoint using the same Controller → Service → DAO
flow learned earlier

### 📂 Projects:
- [ContactsApp-FullySpringBoot](https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-9/ContactsApp)
- [EmployeePayrollApp](https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-9/EmployeePayrollApp)

## Day 10 — Dependency Injection & H2 Database

### 📌 Done on (13-08-2026)

- Revisited Dependency Injection from Day 5 with real-world cases: multiple bean implementations, circular dependencies, and how Spring resolves constructor arguments.
- Learned how Spring resolves ambiguity between multiple beans of the same type using `@Primary` and `@Qualifier`.
- Demonstrated bean resolution hands-on: created two `ContactDAO` implementations, triggered `NoUniqueBeanDefinitionException`, resolved it with `@Primary`, then overrode that default at a specific injection point using `@Qualifier`.
- Studied circular dependencies — how to recognize them and redesign around them.
- Understood H2 configuration modes and the H2 Console, applying Day 9's auto-configuration concepts to database setup.
- Applied the same layered architecture to a second Spring Boot application (Employee Payroll App).

### 📂 Projects:
- [EmployeePayrollApp](https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-10/EmployeePayrollApp)

---

## Day 11 — Spring Services, Spring JPA & Spring JDBC

### 📌 Done on (14-08-2026)

- Formalized the three-layer architecture — clearly defined what belongs in a Controller, a Service, and a DAO/Repository.
- Practiced Spring REST API service-layer design.
- Learned Spring JPA — repositories and entity mapping, including writing a Spring Data JPA repository interface with full CRUD and no implementation class required.
- Learned Spring JDBC — template-based data access using `JdbcTemplate` for cases needing direct SQL control without hand-written JDBC boilerplate.
- Compared three approaches to relational data access: hand-written JDBC, `JdbcTemplate`, and Spring Data JPA — and when to choose each based on the actual requirement.
- Rebuilt the Employee Payroll App using Spring Data JPA, completing its CRUD endpoints (GET/PUT/DELETE by ID) with appropriate HTTP status codes and the Controller → Service → DAO separation intact.

### 📂 Projects:
- [EmployeePayrollApp](https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-11/EmployeePayrollApp)

Day 12 — Spring Bean Scopes, Logging, Maven & Postman
📌 Done on (17-MM-2026)

- Explained all four *Spring bean scopes* — `singleton`, `prototype`, `request`, `session` — and identified when each is appropriate.
- Replaced System.out/System.err debugging with SLF4J/Logback logging across the codebase.
- Understood Maven's dependency resolution and *build lifecycle* (validate → compile → test → package → verify → install → deploy) well enough to debug a broken build using dependency:tree.
- Learned *Postman fundamentals* — collections, environments, variables, request chaining, and test assertions.
- Built reusable Postman collections with environment variables, chained requests (e.g. passing a created id into subsequent Get/Update/Delete calls), and automated test assertions on status codes and response bodies.
- Completed and fully tested the *Employee Payroll App* and *Address Book App backends* end-to-end via Postman.

📂 Projects:

- [EmployeePayrollApp](https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-12/EmployeePayrollApp)
- [AddressBookApp](https://github.com/imbhuvi1/BridgeLabz-Training/tree/Refresher_Training/Day-12/AddressBookApp)