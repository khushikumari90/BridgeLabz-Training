package com.app.fundoo.controller;

import com.app.fundoo.dto.NoteRequest;
import com.app.fundoo.dto.NoteResponse;
import com.app.fundoo.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public ResponseEntity<NoteResponse> createNote(Authentication authentication, @RequestBody NoteRequest request) {
        Long userId = Long.valueOf((String) authentication.getPrincipal());
        return ResponseEntity.status(HttpStatus.CREATED).body(noteService.createNote(userId, request));
    }

    @GetMapping
    public ResponseEntity<List<NoteResponse>> getAllNotes(Authentication authentication) {
        Long userId = Long.valueOf((String) authentication.getPrincipal());
        return ResponseEntity.ok(noteService.getAllNotes(userId));
    }

    @PutMapping("/{noteId}")
    public ResponseEntity<NoteResponse> updateNote(Authentication authentication, @PathVariable Long noteId, @RequestBody NoteRequest request) {
        Long userId = Long.valueOf((String) authentication.getPrincipal());
        return ResponseEntity.ok(noteService.updateNote(userId, noteId, request));
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<Void> deleteNote(Authentication authentication, @PathVariable Long noteId) {
        Long userId = Long.valueOf((String) authentication.getPrincipal());
        noteService.deleteNote(userId, noteId);
        return ResponseEntity.noContent().build();
    }
}