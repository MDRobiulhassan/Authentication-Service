package com.example.Authentication_Service.exception;

public class EmailAlreadyExistsException extends ApiException {
    public EmailAlreadyExistsException() {
        super("Email already exists");
    }
}