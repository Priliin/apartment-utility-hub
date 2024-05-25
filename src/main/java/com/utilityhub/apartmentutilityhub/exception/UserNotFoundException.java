package com.utilityhub.apartmentutilityhub.exception;


// Defines a custom exception if the user is not found
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
            super(message);
        }

}
