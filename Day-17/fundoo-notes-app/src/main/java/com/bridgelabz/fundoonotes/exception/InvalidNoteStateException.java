package com.bridgelabz.fundoonotes.exception;

// thrown when a requested state change doesn't make sense for a note's current state
// e.g. trying to pin a note that's already in the trash
public class InvalidNoteStateException extends RuntimeException {

    public InvalidNoteStateException(String message) {
        super(message);
    }
}
