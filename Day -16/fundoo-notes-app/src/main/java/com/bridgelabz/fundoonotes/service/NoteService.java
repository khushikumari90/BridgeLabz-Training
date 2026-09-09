package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.NoteRequest;
import com.bridgelabz.fundoonotes.entity.Note;
import com.bridgelabz.fundoonotes.entity.User;
import com.bridgelabz.fundoonotes.exception.InvalidNoteStateException;
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

    // UC5: Pin / Archive / Trash

    public Note pinUnpinNote(int noteId) {
        Note note = getNoteDetail(noteId);

        if (note.isDeleted()) {
            // pinning a trashed note is rejected, not silently allowed
            throw new InvalidNoteStateException("Cannot pin a trashed note");
        }

        note.setPined(!note.isPined());
        return noteRepository.save(note);
    }

    public Note archiveNote(int noteId) {
        Note note = getNoteDetail(noteId);

        if (note.isDeleted()) {
            throw new InvalidNoteStateException("Cannot archive a trashed note");
        }

        note.setArchived(!note.isArchived());
        return noteRepository.save(note);
    }

    public Note trashNote(int noteId) {
        Note note = getNoteDetail(noteId);

        note.setDeleted(true);
        note.setArchived(false);
        note.setPined(false); // trashing a note automatically un-pins it

        return noteRepository.save(note);
    }

    // genuine hard delete, distinct from trashNote's soft delete
    public void deleteForeverNote(int noteId) {
        Note note = getNoteDetail(noteId);
        noteRepository.delete(note);
    }

    public List<Note> getArchiveNotesList() {
        User owner = getCurrentUser();
        return noteRepository.findByOwnerAndIsArchivedTrueAndIsDeletedFalse(owner);
    }

    public List<Note> getTrashNotesList() {
        User owner = getCurrentUser();
        return noteRepository.findByOwnerAndIsDeletedTrue(owner);
    }
}
