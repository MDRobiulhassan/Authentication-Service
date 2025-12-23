package com.example.Authentication_Service.exception;

public class InvalidCredentialsException extends ApiException {
    public InvalidCredentialsException() {
        super("Invalid credentials");
    }
}