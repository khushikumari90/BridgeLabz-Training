package com.contacts.app.exception;

public class DuplicateEmailException extends RuntimeException{
    public DuplicateEmailException(String email){
        super("Contact already exists with email: "+email);
    }
}
