package com.bridgelabz.fundoonotes.exception;

public class NoteLabelNotFoundException extends RuntimeException {

    public NoteLabelNotFoundException(int labelId) {
        super("Label not found with id: " + labelId);
    }
}
