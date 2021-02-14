package com.example.demo.exceptions.runtimeExceptions;


/**
 * Created By : arshia on 06/02/21
 **/
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
