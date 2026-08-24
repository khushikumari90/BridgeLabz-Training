package com.app.fundoo.service.impl;

import com.app.fundoo.dto.NoteRequest;
import com.app.fundoo.dto.NoteResponse;
import com.app.fundoo.entity.Note;
import com.app.fundoo.repository.NoteRepository;
import com.app.fundoo.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public NoteResponse createNote(Long userId, NoteRequest request) {
        Note note = Note.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .color(request.getColor())
                .typeOfNote(request.getTypeOfNote())
                .imageUrl(request.getImageUrl())
                .linkUrl(request.getLinkUrl())
                .isPinned(false)
                .isArchived(false)
                .isDeleted(false)
                .userId(userId)
                .build();

        Note saved = noteRepository.save(note);
        return mapToResponse(saved);
    }

    @Override
    public List<NoteResponse> getAllNotes(Long userId) {
        return noteRepository.findByUserIdAndIsDeletedFalse(userId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public NoteResponse updateNote(Long userId, Long noteId, NoteRequest request) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new IllegalArgumentException("Note not found"));

        if (!note.getUserId().equals(userId)) {
            throw new SecurityException("Not authorized to update this note");
        }

        note.setTitle(request.getTitle());
        note.setDescription(request.getDescription());
        note.setColor(request.getColor());
        note.setTypeOfNote(request.getTypeOfNote());
        note.setImageUrl(request.getImageUrl());
        note.setLinkUrl(request.getLinkUrl());

        return mapToResponse(noteRepository.save(note));
    }

    @Override
    public void deleteNote(Long userId, Long noteId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new IllegalArgumentException("Note not found"));

        if (!note.getUserId().equals(userId)) {
            throw new SecurityException("Not authorized to delete this note");
        }

        note.setDeleted(true); // soft delete
        noteRepository.save(note);
    }

    @Override
    public NoteResponse togglePin(Long userId, Long noteId) {
        Note note = getOwnedNote(userId, noteId);
        note.setPinned(!note.isPinned());
        return mapToResponse(noteRepository.save(note));
    }

    @Override
    public NoteResponse toggleArchive(Long userId, Long noteId) {
        Note note = getOwnedNote(userId, noteId);
        note.setArchived(!note.isArchived());
        return mapToResponse(noteRepository.save(note));
    }

    @Override
    public NoteResponse restoreFromTrash(Long userId, Long noteId) {
        Note note = getOwnedNote(userId, noteId);
        note.setDeleted(false);
        return mapToResponse(noteRepository.save(note));
    }

    @Override
    public void permanentlyDeleteNote(Long userId, Long noteId) {
        Note note = getOwnedNote(userId, noteId);
        noteRepository.delete(note);
    }

    private Note getOwnedNote(Long userId, Long noteId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new IllegalArgumentException("Note not found"));
        if (!note.getUserId().equals(userId)) {
            throw new SecurityException("Not authorized for this note");
        }
        return note;
    }

    private NoteResponse mapToResponse(Note note) {
        return NoteResponse.builder()
                .noteId(note.getNoteId())
                .title(note.getTitle())
                .description(note.getDescription())
                .isPinned(note.isPinned())
                .isArchived(note.isArchived())
                .color(note.getColor())
                .typeOfNote(note.getTypeOfNote())
                .imageUrl(note.getImageUrl())
                .linkUrl(note.getLinkUrl())
                .build();
    }


}