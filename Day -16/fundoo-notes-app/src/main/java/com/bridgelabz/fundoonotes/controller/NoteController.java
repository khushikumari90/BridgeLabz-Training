package com.bridgelabz.fundoonotes.controller;

import com.bridgelabz.fundoonotes.dto.NoteRequest;
import com.bridgelabz.fundoonotes.entity.Note;
import com.bridgelabz.fundoonotes.exception.InvalidNoteStateException;
import com.bridgelabz.fundoonotes.exception.NoteNotFoundException;
import com.bridgelabz.fundoonotes.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// UC4: Notes CRUD, scoped to the logged-in user (JwtAuthFilter/SecurityConfig from UC3 protects all of these)
@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
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
