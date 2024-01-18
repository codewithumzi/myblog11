package com.myblog.myblog11.exception;

public class ResourceNotFoundException extends RuntimeException{
    //generate constructor here
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
