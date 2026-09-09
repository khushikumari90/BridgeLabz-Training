package com.bridgelabz.fundoonotes.controller;

import com.bridgelabz.fundoonotes.dto.NoteLabelRequest;
import com.bridgelabz.fundoonotes.entity.NoteLabel;
import com.bridgelabz.fundoonotes.exception.DuplicateLabelException;
import com.bridgelabz.fundoonotes.exception.NoteLabelNotFoundException;
import com.bridgelabz.fundoonotes.service.NoteLabelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// UC6: Labels/Tags Management
@RestController
public class NoteLabelController {

    private final NoteLabelService noteLabelService;

    public NoteLabelController(NoteLabelService noteLabelService) {
        this.noteLabelService = noteLabelService;
    }

    @PostMapping("/noteLabels")
    public ResponseEntity<NoteLabel> createLabel(@Valid @RequestBody NoteLabelRequest request) {
        NoteLabel noteLabel = noteLabelService.createLabel(request);
        return new ResponseEntity<>(noteLabel, HttpStatus.CREATED);
    }

    @PatchMapping("/noteLabels/{id}")
    public ResponseEntity<NoteLabel> updateLabel(@PathVariable int id, @Valid @RequestBody NoteLabelRequest request) {
        return ResponseEntity.ok(noteLabelService.updateLabel(id, request));
    }

    @DeleteMapping("/noteLabels/{id}/deleteNoteLabel")
    public ResponseEntity<Void> deleteLabel(@PathVariable int id) {
        noteLabelService.deleteLabel(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/noteLabels/getNoteLabelList")
    public ResponseEntity<List<NoteLabel>> getNoteLabelList() {
        return ResponseEntity.ok(noteLabelService.getLabelList());
    }

    @PostMapping("/notes/{noteId}/addLabelToNotes/{labelId}/add")
    public ResponseEntity<?> addLabelToNote(@PathVariable int noteId, @PathVariable int labelId) {
        return ResponseEntity.ok(noteLabelService.addLabelToNote(noteId, labelId));
    }

    @PostMapping("/notes/{noteId}/addLabelToNotes/{labelId}/remove")
    public ResponseEntity<?> removeLabelFromNote(@PathVariable int noteId, @PathVariable int labelId) {
        return ResponseEntity.ok(noteLabelService.removeLabelFromNote(noteId, labelId));
    }

    // simple local handlers for now - a proper global one comes in UC14
    @ExceptionHandler(NoteLabelNotFoundException.class)
    public ResponseEntity<String> handleLabelNotFound(NoteLabelNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateLabelException.class)
    public ResponseEntity<String> handleDuplicateLabel(DuplicateLabelException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
