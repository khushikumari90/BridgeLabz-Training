package com.app.fundoo.controller;

import com.app.fundoo.dto.LabelRequest;
import com.app.fundoo.dto.LabelResponse;
import com.app.fundoo.service.LabelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/labels")
@RequiredArgsConstructor
public class LabelController {

    private final LabelService labelService;

    @PostMapping
    public ResponseEntity<LabelResponse> createLabel(Authentication authentication, @RequestBody LabelRequest request) {
        Long userId = Long.valueOf((String) authentication.getPrincipal());
        return ResponseEntity.status(HttpStatus.CREATED).body(labelService.createLabel(userId, request));
    }

    @GetMapping
    public ResponseEntity<List<LabelResponse>> getAllLabels(Authentication authentication) {
        Long userId = Long.valueOf((String) authentication.getPrincipal());
        return ResponseEntity.ok(labelService.getAllLabels(userId));
    }

    @PostMapping("/{labelId}/notes/{noteId}")
    public ResponseEntity<Void> addLabelToNote(Authentication authentication, @PathVariable Long labelId, @PathVariable Long noteId) {
        Long userId = Long.valueOf((String) authentication.getPrincipal());
        labelService.addLabelToNote(userId, noteId, labelId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{labelId}/notes/{noteId}")
    public ResponseEntity<Void> removeLabelFromNote(Authentication authentication, @PathVariable Long labelId, @PathVariable Long noteId) {
        Long userId = Long.valueOf((String) authentication.getPrincipal());
        labelService.removeLabelFromNote(userId, noteId, labelId);
        return ResponseEntity.ok().build();
    }
}