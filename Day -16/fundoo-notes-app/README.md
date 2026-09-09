# Fundoo Notes App

Spring Boot backend for the Fundoo Notes App, built use-case by use-case.

## Progress

### UC1 — Project & Database Setup
- Spring Boot project created with Web, JPA, MySQL, Validation, Lombok.
- Connected to MySQL (`fundoo_notes_db`) via `application.properties`.
- `spring.jpa.hibernate.ddl-auto=update`, `spring.jpa.show-sql=true`.

### UC2 — User Registration & Login with JWT
- `User` entity: firstName, lastName, email (unique), passwordHash.
- Passwords stored using `BCryptPasswordEncoder` — never plain text.
- `POST /user/userSignUp` — registers a user, returns `201` + JWT.
- `POST /user/login` — logs in a user, returns `200` + JWT.
- Duplicate email and wrong password are rejected with a clean `400`/`401`
  (via `ResponseStatusException`), not a stack trace.

### UC3 — Authorization Filter + Protecting Endpoints
- `JwtAuthFilter` reads the `Authorization: Bearer <token>` header, validates
  the token, and sets the logged-in user's id on the `SecurityContextHolder`.
- `SecurityConfig` permits only `/user/userSignUp` and `/user/login`; every
  other endpoint requires a valid JWT.
- No token or a tampered token → `401`.

### UC4 — Notes CRUD with Ownership
- `Note` entity: title, description, isPined, isArchived, isDeleted, color,
  typeOfNote, imageUrl, linkUrl, owner (`@ManyToOne` to `User`).
- `POST /notes/addNotes` — create a note for the logged-in user.
- `GET /notes/getNotesList` — list only the logged-in user's notes.
- `GET /notes/getNotesDetail/{noteId}` — get one note, scoped to owner.
- `POST /notes/updateNotes/{noteId}` — update a note, scoped to owner.
- `DELETE /notes/{noteId}` — delete a note, scoped to owner.
- Ownership is enforced in `NoteRepository.findByNoteIdAndOwner(...)`, so a
  user can never read/update/delete another user's note.
- Trying to access someone else's note (or a note that doesn't exist) returns
  `404`, not `403` — doesn't reveal whether the note exists at all.
- The current user is read from `SecurityContextHolder` (set by UC3's
  `JwtAuthFilter`), never from a request parameter.

### UC5 — Pin / Archive / Trash
- `POST /notes/pinUnpinNotes/{noteId}` — toggles pin; rejected with `400` if the note is trashed.
- `POST /notes/archiveNotes/{noteId}` — toggles archive; rejected with `400` if the note is trashed.
- `POST /notes/trashNotes/{noteId}` — moves a note to trash; automatically un-pins and un-archives it.
- `POST /notes/deleteForeverNotes/{noteId}` — genuine hard delete, separate from the soft-delete `trashNotes`.
- `GET /notes/getArchiveNotesList` — archived notes only (excludes trashed).
- `GET /notes/getTrashNotesList` — trashed notes only.
- Business rules live in `NoteService`, not the controller (`InvalidNoteStateException` → `400`).

### UC6 — Labels/Tags Management
- `NoteLabel` entity: label, isDeleted (soft-delete flag), owner.
- `Note` now has a `@ManyToMany` to `NoteLabel` via a `note_note_labels` join table.
- `POST /noteLabels` — create a label (rejected with `400` if the user already has that label).
- `PATCH /noteLabels/{id}` — rename a label.
- `DELETE /noteLabels/{id}/deleteNoteLabel` — soft-deletes a label (`isDeleted = true`).
- `GET /noteLabels/getNoteLabelList` — lists only the user's non-deleted labels.
- `POST /notes/{noteId}/addLabelToNotes/{labelId}/add` — attach a label to a note.
- `POST /notes/{noteId}/addLabelToNotes/{labelId}/remove` — detach a label from a note (label itself isn't deleted).
- Label uniqueness is per-user (two users can each have "Work"), enforced in `NoteLabelService` since a
  plain `@Column(unique)` can't express a per-user constraint.

## Tech Stack
Spring Boot 3, Spring Security, Spring Data JPA, MySQL, JWT (jjwt), Lombok.

## How to run
1. Create a MySQL database named `fundoo_notes_db`.
2. Update `spring.datasource.username` / `password` in `application.properties` if needed.
3. `mvn spring-boot:run`

## Testing (Postman)
- `POST /user/userSignUp` with `{ "firstName", "lastName", "email", "password" }` → `201` + token
- `POST /user/login` with `{ "email", "password" }` → `200` + token
- Any other endpoint without a token → `401`
- `POST /notes/addNotes` with a valid token → `201`
- `GET /notes/getNotesDetail/{id}` for a note you don't own → `404`
- `POST /notes/trashNotes/{id}` then check the note is un-pinned automatically
- `POST /notes/pinUnpinNotes/{id}` on a trashed note → `400`
- `POST /noteLabels` twice with the same label name → second call `400`
- Attach a label to a note, `deleteNoteLabel` it, confirm it's gone from `getNoteLabelList`
