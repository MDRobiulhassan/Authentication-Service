package com.example.Authentication_Service.exception;

public class PasswordMismatchException extends ApiException {
    public PasswordMismatchException() {
        super("Passwords don't match");
    }
}