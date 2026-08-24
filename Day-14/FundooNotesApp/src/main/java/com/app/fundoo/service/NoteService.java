package com.app.fundoo.service;

import com.app.fundoo.dto.NoteRequest;
import com.app.fundoo.dto.NoteResponse;

import java.util.List;

public interface NoteService {
    NoteResponse createNote(Long userId, NoteRequest request);
    List<NoteResponse> getAllNotes(Long userId);
    NoteResponse updateNote(Long userId, Long noteId, NoteRequest request);
    void deleteNote(Long userId, Long noteId);
}