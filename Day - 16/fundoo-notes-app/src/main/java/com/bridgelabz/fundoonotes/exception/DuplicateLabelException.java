package com.bridgelabz.fundoonotes.exception;

// thrown when a user tries to create a label they already have (per-user uniqueness)
public class DuplicateLabelException extends RuntimeException {

    public DuplicateLabelException(String label) {
        super("Label already exists: " + label);
    }
}
