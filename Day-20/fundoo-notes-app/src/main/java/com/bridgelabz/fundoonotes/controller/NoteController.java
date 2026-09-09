package com.bridgelabz.fundoonotes.controller;

import com.bridgelabz.fundoonotes.batch.NoteExportService;
import com.bridgelabz.fundoonotes.batch.NoteImportService;
import com.bridgelabz.fundoonotes.dto.ImportResult;
import com.bridgelabz.fundoonotes.dto.NoteRequest;
import com.bridgelabz.fundoonotes.dto.ReminderRequest;
import com.bridgelabz.fundoonotes.dto.ShareNoteRequest;
import com.bridgelabz.fundoonotes.entity.Note;
import com.bridgelabz.fundoonotes.exception.InvalidNoteStateException;
import com.bridgelabz.fundoonotes.exception.NoteNotFoundException;
import com.bridgelabz.fundoonotes.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

// UC4: Notes CRUD, scoped to the logged-in user (JwtAuthFilter/SecurityConfig from UC3 protects all of these)
@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;
    private final NoteImportService noteImportService;
    private final NoteExportService noteExportService;

    public NoteController(NoteService noteService, NoteImportService noteImportService,
                           NoteExportService noteExportService) {
        this.noteService = noteService;
        this.noteImportService = noteImportService;
        this.noteExportService = noteExportService;
    }

    @PostMapping("/addNotes")
    public ResponseEntity<Note> addNote(@Valid @RequestBody NoteRequest request) {
        Note note = noteService.createNote(request);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    @GetMapping("/getNotesList")
    public ResponseEntity<List<Note>> getNotesList() {
        return ResponseEntity.ok(noteService.getNotesList());
    }

    @GetMapping("/getNotesDetail/{noteId}")
    public ResponseEntity<Note> getNoteDetail(@PathVariable int noteId) {
        return ResponseEntity.ok(noteService.getNoteDetail(noteId));
    }

    @PostMapping("/updateNotes/{noteId}")
    public ResponseEntity<Note> updateNote(@PathVariable int noteId, @Valid @RequestBody NoteRequest request) {
        return ResponseEntity.ok(noteService.updateNote(noteId, request));
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<Void> deleteNote(@PathVariable int noteId) {
        noteService.deleteNote(noteId);
        return ResponseEntity.noContent().build();
    }

    // UC5: Pin / Archive / Trash

    @PostMapping("/pinUnpinNotes/{noteId}")
    public ResponseEntity<Note> pinUnpinNote(@PathVariable int noteId) {
        return ResponseEntity.ok(noteService.pinUnpinNote(noteId));
    }

    @PostMapping("/archiveNotes/{noteId}")
    public ResponseEntity<Note> archiveNote(@PathVariable int noteId) {
        return ResponseEntity.ok(noteService.archiveNote(noteId));
    }

    @PostMapping("/trashNotes/{noteId}")
    public ResponseEntity<Note> trashNote(@PathVariable int noteId) {
        return ResponseEntity.ok(noteService.trashNote(noteId));
    }

    @PostMapping("/deleteForeverNotes/{noteId}")
    public ResponseEntity<Void> deleteForeverNote(@PathVariable int noteId) {
        noteService.deleteForeverNote(noteId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getArchiveNotesList")
    public ResponseEntity<List<Note>> getArchiveNotesList() {
        return ResponseEntity.ok(noteService.getArchiveNotesList());
    }

    @GetMapping("/getTrashNotesList")
    public ResponseEntity<List<Note>> getTrashNotesList() {
        return ResponseEntity.ok(noteService.getTrashNotesList());
    }

    // UC7: Search & Filter with Specification

    @GetMapping("/search")
    public ResponseEntity<List<Note>> searchNotes(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String label) {
        return ResponseEntity.ok(noteService.searchNotes(title, state, label));
    }

    @GetMapping("/getNotesListByLabel/{labelName}")
    public ResponseEntity<List<Note>> getNotesListByLabel(@PathVariable String labelName) {
        return ResponseEntity.ok(noteService.getNotesListByLabel(labelName));
    }

    // UC8: Reminders via JMS

    @PostMapping("/addUpdateReminderNotes/{noteId}")
    public ResponseEntity<Note> addUpdateReminder(@PathVariable int noteId, @Valid @RequestBody ReminderRequest request) {
        return ResponseEntity.ok(noteService.addUpdateReminder(noteId, request.getReminderTime()));
    }

    @PostMapping("/removeReminderNotes/{noteId}")
    public ResponseEntity<Note> removeReminder(@PathVariable int noteId, @Valid @RequestBody ReminderRequest request) {
        return ResponseEntity.ok(noteService.removeReminder(noteId, request.getReminderTime()));
    }

    @GetMapping("/getReminderNotesList")
    public ResponseEntity<List<Note>> getReminderNotesList() {
        return ResponseEntity.ok(noteService.getReminderNotesList());
    }

    // UC10: RabbitMQ - a second messaging path (stub sharing trigger until UC13's real Collaborators exist)

    @PostMapping("/{noteId}/shareNotes")
    public ResponseEntity<Void> shareNote(@PathVariable int noteId, @Valid @RequestBody ShareNoteRequest request) {
        noteService.shareNote(noteId, request.getSharedWithEmail());
        return ResponseEntity.accepted().build();
    }

    // UC11: Spring Batch - Excel Import/Export

    @PostMapping("/import")
    public ResponseEntity<ImportResult> importNotes(@RequestParam("file") MultipartFile file) throws Exception {
        ImportResult result = noteImportService.importNotes(file, noteService.getCurrentUserEntity());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/export")
    public ResponseEntity<ByteArrayResource> exportNotes() throws Exception {
        List<Note> notes = noteService.getNotesList();
        byte[] fileBytes = noteExportService.exportNotesToExcel(notes);

        ByteArrayResource resource = new ByteArrayResource(fileBytes);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        ContentDisposition.attachment().filename("notes-export.xlsx").build().toString())
                .contentLength(fileBytes.length)
                .body(resource);
    }

    // simple local handlers for now - a proper global one comes in UC14
    @ExceptionHandler(NoteNotFoundException.class)
    public ResponseEntity<String> handleNoteNotFound(NoteNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidNoteStateException.class)
    public ResponseEntity<String> handleInvalidNoteState(InvalidNoteStateException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
