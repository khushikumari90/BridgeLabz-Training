# HealthClinicApp

A console-based Health Clinic management app in layered Java (UI → Service → DAO → DTO → MySQL),
following the DAO/DTO/Service pattern with HikariCP connection pooling and transactional
appointment completion.

## What's included

- **database/health_clinic_schema.sql** — all 7 tables (patients, doctors, specializations,
  appointments, billing, visit_history, audit_log), the app's MySQL user, foreign keys, indexes,
  the UNIQUE constraint that blocks double-billing, two audit triggers on `billing`, and seed
  specializations.
- **Full CRUD DAOs** for all six entities (Patient, Doctor, Specialization, Appointment, Billing,
  VisitHistory) — not just the Patient example from the walkthrough.
- **AppointmentService** — the transactional safety net for "Complete Appointment": updates
  appointment status, inserts the bill, and inserts the visit record on ONE shared connection,
  committing all three or rolling back all three.
- **ConsoleMenu** — a full menu system covering every entity: register/view/update/delete for
  patients, doctors, specializations; book/view/complete/cancel/reschedule/delete for
  appointments; view/mark-paid/delete for billing; view/update/delete for visit history.
- **HikariConnectionPool** — the Step 8 hardening applied from the start, replacing the
  "new connection every call" version with a small pool (max 10, min idle 2).
- Basic input validation baked into the UI (bad numbers, bad dates, blank required fields,
  duplicate emails, completing an already-completed appointment) — this is the Step 7
  "fail safely instead of crashing" pass.

## Setup

1. **Create the database** — in MySQL:
   ```
   mysql -u root -p < database/health_clinic_schema.sql
   ```
   This creates the database, the `clinic_app_user` login, all tables, triggers, and seed
   specializations.

2. **Update credentials if needed** — `src/main/java/com/clinic/config/HikariConnectionPool.java`
   has the URL/user/password. Defaults match the schema script
   (`clinic_app_user` / `StrongPassword123!`), change both places together if you change one.

3. **Build and run** (requires a JDK + Maven locally):
   ```
   mvn clean package
   java -jar target/HealthClinicApp.jar
   ```
   The Maven Shade plugin bundles the MySQL driver and HikariCP into one runnable jar.

## Verifying the transaction (Step 7's real proof)

1. Book an appointment, then complete it — confirm all three land:
   ```sql
   SELECT status FROM appointments WHERE appointment_id = 1;   -- 'Completed'
   SELECT * FROM billing WHERE appointment_id = 1;              -- one row
   SELECT * FROM visit_history WHERE appointment_id = 1;        -- one row
   SELECT * FROM audit_log;                                     -- trigger fired
   ```
2. Try completing an appointment ID that doesn't exist — confirm the service reports failure
   and **no** row appears in `billing` or `visit_history`. That's the rollback actually working,
   not just the happy path.

## Notes on scope

- Deleting a patient/doctor cascades to their appointments (and from there to billing/visit
  history) via `ON DELETE CASCADE` — the UI asks for confirmation first since it's destructive.
- `cancelAppointment` lives in the Service layer next to `completeAppointment` since both are
  appointment-lifecycle actions, even though cancel is a single write with no transaction needed.
- Everything above the DAO layer only ever holds `Patient`/`Doctor`/`Appointment`/etc. objects —
  no raw `ResultSet` ever leaves `dao/`, and no SQL string appears outside it either.
