# Refresher Training — Daily Learning Progress 🚀

---

## Day 1 — DBMS Fundamentals & RDBMS Basics

- Covered the progression from **Data → Database → DBMS → RDBMS** and how each layer is related.
- Reviewed File System vs DBMS and identified the major benefits of using a DBMS.
- Studied different database models and compared SQL databases with NoSQL databases.
- Set up MySQL and explored its basic architecture and working.
- Practiced the major SQL command categories: DDL, DML, TCL, and DCL.
- Created the first version of the Health Clinic database with **Patients** and **Doctors** tables.
- Completed the related practice exercises and interview-based questions.

### ✅ Assignment

[Day 1 Assignment](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-1/assignment)

---

## Day 2 — ER Diagram, Indexing & Database Normalization

- Created the ER model for the Health Clinic application and mapped its entities and relationships.
- Explored Clustered, Non-Clustered, Composite, Covering, and Unique indexes, and used `EXPLAIN` to inspect query execution.
- Worked through normalization from 1NF to BCNF and understood when denormalization can be useful.
- Implemented a normalized Health Clinic schema and added appropriate indexes.
- Completed the related practice exercises and interview-based questions.

### ✅ Assignment

[Day 2 Assignment](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-2/assignment)

---

## Day 3 — SQL Joins, Stored Procedures & Triggers

- Worked with the main SQL JOIN types and practiced queries involving multiple tables.
- Created Stored Procedures using parameters, transaction handling, and error-management techniques.
- Implemented BEFORE and AFTER Triggers using the `NEW` and `OLD` values.
- Added procedures and triggers to support the Health Clinic database.
- Completed the related practice exercises and interview-based questions.

---

## Day 4 — JDBC, Transactions & Health Clinic Console Application

- Established a Java-to-MySQL connection using JDBC.
- Worked with DriverManager, PreparedStatement, ResultSet, and JDBC exception handling.
- Used PreparedStatement to understand and prevent common SQL Injection risks.
- Implemented transaction control with `commit`, `rollback`, and `savepoint`.
- Explored HikariCP connection pooling and compared it with direct DriverManager connections.
- Structured the Java application using a layered **DTO → DAO → Service → UI** design.
- Added CRUD functionality for **Patients, Doctors, Appointments, Billing, and Visit History**.
- Completed the **Health Clinic Console Application** with Java, JDBC, Maven, and MySQL.

### 🚀 Project

[Health Clinic Console Application](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-4/HealthClinicApp)

## Day 5 — Tomcat, Servlets & Spring Introduction

- Explored **Apache Tomcat** as a web and servlet container and learned how it runs Servlets.
- Studied the **Servlet Lifecycle** and traced the Browser → Tomcat → Servlet → Browser request-response cycle.
- Configured **Apache Tomcat** in IntelliJ IDEA with Smart Tomcat.
- Created and deployed the **First Servlet Application** successfully.
- Practiced URL mapping with `@WebServlet` and request processing through `doGet()`.
- Introduced the **Spring Framework** and discussed its purpose in Java application development.
- Studied the key ideas behind **Inversion of Control (IoC)** and **Dependency Injection (DI)**.
- Connected Spring's dependency injection approach with the manual object creation using `new` from earlier Java applications.
- Deployed a basic Servlet on Tomcat.
- Explored Spring's IoC container through a simple bean example.

### 📂 Practice Projects:

- [HelloWorldDemo](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-5/HelloWorldDemo) — Built a basic Spring Boot application and practiced Spring MVC/REST request handling.
- [SpringConcepts](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-5/Springconcepts) — Practiced Spring IoC, `ApplicationContext`, Dependency Injection, Spring annotations, and logging.
- [GreetingsApp](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-5/GreetingsApp) — Built a Spring Boot application using REST, JPA, H2, CRUD operations, validation, and custom JPA queries.
- [FirstSpringApp](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-5/firstspringapp) - Created a *basic Spring Boot application* and learned the fundamentals of Spring Boot application setup and execution.

### 📂 Assigned Project:

- [First Servlet App](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-5/FirstServletProject)

- Click above and check the code in "src/main" folder.  

## Day 6 — Spring MVC

### 📌 Done from (07-08-2026 to 09-08-2026)

- Studied **Spring MVC architecture** and the responsibility of `DispatcherServlet`.
- Explored the interaction between **Controllers and Views** in Spring MVC.
- Practiced request mapping and handling with `@Controller`, `@RequestMapping`, `@GetMapping`, and `@PostMapping`.
- Understood `DispatcherServlet` as the central entry point for incoming HTTP requests.
- Developed the required **My Greetings App** with Spring MVC.
- Learned how Spring MVC connects the **Controller → Service → DAO** layers.
- Converted the existing **HealthClinicApp** from `ConsoleMenu` to Spring MVC Controllers while retaining the Service and DAO layers.
- Tested the application's HTTP requests and responses through Spring MVC endpoints.
- Implemented the My Greetings App using Spring MVC.

### 📂 Assigned Project:

- [My Greetings App](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-6/MyGreetingsApp)

### 📂 Migrated Project:

-[HealthClinic](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-6/HealthClinicApp)

## Day 7 — Spring REST API & Request Handling
-  Applied REST conventions by using resource-oriented URLs and HTTP methods to represent operations.
- Used ResponseEntity to return appropriate HTTP status codes such as 200, 201, 204, and 404.
- Applied Bean Validation with @NotBlank, @Email, @Pattern, and @Valid so invalid input is handled before reaching business logic.
- Centralized exception handling through @ControllerAdvice and @ExceptionHandler instead of duplicating try/catch code across Controllers.
- Configured the H2 in-memory database for quick development and compared its advantages and limitations with MySQL.
- Got a conceptual grounding in Distributed Architectures — why systems split into services and what complexity
that introduces.
- Started the Contacts App with validated REST endpoints and suitable HTTP status codes.

### 📂 Project:
- [ContactsApp](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-7/ContactsApp)

## Day 8 - API Testing Tools & SDLC Exposure

- Learned the REST Assured Given / When / Then pattern for automated API testing rather than relying only on manual Postman or curl checks.
- Practiced both successful and failure scenarios based on the validation and status-code behavior from Day 7.
- Explored JSON Server for API mocking and parallel frontend/backend development, including its limitations and intended use.
- Connected the stages Requirement, Design, Implementation, Testing, Deployment, and Maintenance with the training workflow.
- Compared Waterfall and Agile and understood why Agile works well when requirements change frequently.
- Completed the Contacts App with an automated test suite, wrapping up the Backend Basics phase for Days 5–8.

### 📂 Practice Project(Live Coding):

- [College App](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-8/collegedb-app)
- [ContactsApp-withTests](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-8/ContactsApp/src)

## Day 9 - Spring Boot Fundamentals

### 📌 Done on (12-08-2026)
- Clarified that Spring Boot builds on the Spring ecosystem rather than replacing Spring Core or Spring MVC.
- Understood that auto-configuration is conditional and is influenced by the classpath and application properties.
- Learned how Spring Boot starters bundle commonly used dependencies into convenient Maven coordinates.
- Used Embedded Tomcat to run a Spring Boot application as an executable JAR without installing a separate server.
- Clarified that @RestController and @GetMapping are Spring MVC features supported by Spring Boot's surrounding infrastructure.
- Used Spring Initializr as a convenient way to generate the standard Spring Boot project structure.
- Extended the Contacts App with a search-by-name endpoint while following the existing Controller → Service → DAO flow.

### 📂 Projects:
- [ContactsApp-FullySpringBoot](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-9/ContactsApp)
- [EmployeePayrollApp](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-9/EmployeePayrollApp)

## Day 10 — Dependency Injection & H2 Database

- Revisited Dependency Injection using practical cases involving multiple bean implementations, circular dependencies, and constructor resolution.
- Learned to handle multiple beans of the same type with `@Primary` and `@Qualifier`.
- Practiced bean selection by creating two `ContactDAO` implementations, observing `NoUniqueBeanDefinitionException`, fixing it with `@Primary`, and overriding the default at a specific injection point with `@Qualifier`.
- Studied how circular dependencies occur, how to identify them, and how to redesign components to avoid them.
- Explored H2 configuration modes and the H2 Console while applying the auto-configuration concepts from Day 9.
- Applied the same layered design to another Spring Boot project, the Employee Payroll App.

### 📂 Projects:
- [EmployeePayrollApp](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-10/EmployeePayrollApp)

---

## Day 11 — Spring Services, Spring JPA & Spring JDBC

- Strengthened the three-layer architecture by defining the responsibilities of the Controller, Service, and DAO/Repository.
- Practiced designing the service layer for Spring REST APIs.
- Worked with Spring JPA, entity mapping, and Spring Data JPA repositories that provide CRUD operations without writing an implementation class.
- Explored Spring JDBC and `JdbcTemplate` for situations where direct SQL control is needed without the usual JDBC boilerplate.
- Compared hand-written JDBC, `JdbcTemplate`, and Spring Data JPA, focusing on when each approach is appropriate.
- Updated the Employee Payroll App with Spring Data JPA and completed GET/PUT/DELETE-by-ID endpoints while maintaining proper status codes and Controller → Service → DAO separation.

### 📂 Projects:
- [EmployeePayrollApp](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-11/EmployeePayrollApp)

## Day 12 — Spring Bean Scopes, Logging, Maven & Postman

- Reviewed the four main *Spring bean scopes* — `singleton`, `prototype`, `request`, and `session` — and discussed their suitable use cases.
- Replaced System.out/System.err debugging with SLF4J/Logback-based logging throughout the application.
- Studied Maven dependency resolution and the *build lifecycle* (validate → compile → test → package → verify → install → deploy), including troubleshooting with dependency:tree.
- Covered *Postman fundamentals* including collections, environments, variables, request chaining, and test assertions.
- Created reusable Postman collections using environment variables, request chaining, and automated assertions for status codes and response bodies.
- Completed end-to-end Postman testing for the *Employee Payroll App* and *Address Book App backends*.

📂 Projects:

- [EmployeePayrollApp](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-12/EmployeePayrollApp)
- [AddressBookApp](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-12/AddressBookApp)

## Day 13 — Spring Security & JWT Authentication (Fundoo Notes App)

- Reviewed Spring Boot basics and understood *Spring Security* as a filter chain that processes requests before they reach Controllers.
- Understood why an API without security controls can be accessed without credentials.
- Clearly differentiated `authentication` ("who are you?") from `authorization` ("what are you allowed to do?").
- Configured a `SecurityFilterChain` to secure protected endpoints while keeping /auth/register and /auth/login publicly accessible.
- Studied the `JWT structure` — header, payload, and signature — and implemented JWT creation and validation.
- Understood why `stateless` *JWT authentication* fits REST APIs by avoiding server-side session storage.
- Used `BCrypt` hashing to store passwords more securely.
- Developed the `Fundoo Notes App` user-management module with registration and login protected through BCrypt and JWT.

📂 Projects:

- [FundooNotesApp](https://github.com/khushikumari90/BridgeLabz-Training/tree/Refresher-Training/Day-13/FundooNotesApp)
