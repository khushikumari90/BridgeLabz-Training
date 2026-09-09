package com.bridgelabz.fundoonotes.exception;

public class NoteCheckListNotFoundException extends RuntimeException {

    public NoteCheckListNotFoundException(int checklistId) {
        super("Checklist item not found with id: " + checklistId);
    }
}
