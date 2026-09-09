package com.bridgelabz.fundoonotes.exception;

// thrown when a note doesn't exist OR doesn't belong to the requesting user
// (returning 404 in both cases so we don't leak whether the note exists - Day 14 reasoning)
public class NoteNotFoundException extends RuntimeException {

    public NoteNotFoundException(int noteId) {
        super("Note not found with id: " + noteId);
    }
}
