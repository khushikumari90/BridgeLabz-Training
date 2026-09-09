package com.bridgelabz.fundoonotes.controller;

import com.bridgelabz.fundoonotes.dto.NoteCheckListRequest;
import com.bridgelabz.fundoonotes.entity.NoteCheckList;
import com.bridgelabz.fundoonotes.exception.NoteCheckListNotFoundException;
import com.bridgelabz.fundoonotes.service.NoteCheckListService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// UC12: Checklist Items on Notes
@RestController
@RequestMapping("/notes/{noteId}/noteCheckLists")
public class NoteCheckListController {

    private final NoteCheckListService noteCheckListService;

    public NoteCheckListController(NoteCheckListService noteCheckListService) {
        this.noteCheckListService = noteCheckListService;
    }

    @GetMapping
    public ResponseEntity<List<NoteCheckList>> getChecklistItems(@PathVariable int noteId) {
        return ResponseEntity.ok(noteCheckListService.getChecklistItems(noteId));
    }

    @PostMapping
    public ResponseEntity<NoteCheckList> addChecklistItem(@PathVariable int noteId,
                                                            @Valid @RequestBody NoteCheckListRequest request) {
        NoteCheckList item = noteCheckListService.addChecklistItem(noteId, request);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PutMapping("/{fk}")
    public ResponseEntity<NoteCheckList> updateChecklistItem(@PathVariable int noteId, @PathVariable int fk,
                                                               @Valid @RequestBody NoteCheckListRequest request) {
        return ResponseEntity.ok(noteCheckListService.updateChecklistItem(noteId, fk, request));
    }

    @DeleteMapping("/{fk}")
    public ResponseEntity<Void> deleteChecklistItem(@PathVariable int noteId, @PathVariable int fk) {
        noteCheckListService.deleteChecklistItem(noteId, fk);
        return ResponseEntity.noContent().build();
    }

    // "mark all complete" - bulk update, one transaction, mentioned as a worth-adding-next in the guide
    @PostMapping("/markAllComplete")
    public ResponseEntity<List<NoteCheckList>> markAllComplete(@PathVariable int noteId) {
        return ResponseEntity.ok(noteCheckListService.markAllComplete(noteId));
    }

    // simple local handler for now - a proper global one comes in UC14
    @ExceptionHandler(NoteCheckListNotFoundException.class)
    public ResponseEntity<String> handleChecklistNotFound(NoteCheckListNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
