package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.NoteRequest;
import com.bridgelabz.fundoonotes.entity.Note;
import com.bridgelabz.fundoonotes.entity.User;
import com.bridgelabz.fundoonotes.exception.NoteNotFoundException;
import com.bridgelabz.fundoonotes.repository.NoteRepository;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteService(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    // UC3: identity comes from SecurityContextHolder (set by JwtAuthFilter), never from a request param
    private User getCurrentUser() {
        int userId = (int) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Logged in user not found"));
    }

    public Note createNote(NoteRequest request) {
        User owner = getCurrentUser();

        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setDescription(request.getDescription());
        note.setColor(request.getColor());
        note.setTypeOfNote(request.getTypeOfNote());
        note.setImageUrl(request.getImageUrl());
        note.setLinkUrl(request.getLinkUrl());
        note.setOwner(owner);

        return noteRepository.save(note);
    }

    public List<Note> getNotesList() {
        User owner = getCurrentUser();
        return noteRepository.findByOwner(owner);
    }

    public Note getNoteDetail(int noteId) {
        User owner = getCurrentUser();
        return noteRepository.findByNoteIdAndOwner(noteId, owner)
                .orElseThrow(() -> new NoteNotFoundException(noteId));
    }

    public Note updateNote(int noteId, NoteRequest request) {
        Note note = getNoteDetail(noteId); // already scoped to the current owner

        note.setTitle(request.getTitle());
        note.setDescription(request.getDescription());
        note.setColor(request.getColor());
        note.setTypeOfNote(request.getTypeOfNote());
        note.setImageUrl(request.getImageUrl());
        note.setLinkUrl(request.getLinkUrl());

        return noteRepository.save(note);
    }

    public void deleteNote(int noteId) {
        Note note = getNoteDetail(noteId); // throws NoteNotFoundException if not owned by current user
        noteRepository.delete(note);
    }
}
