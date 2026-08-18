package com.college.collegedb.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Integer id){
        super("Cannot find faculty by id: "+id);
    }
}
