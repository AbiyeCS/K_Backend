package com.example.demo.Exception;

public class FailedToLoginException extends RuntimeException {
    public FailedToLoginException(String message) {
        super(message);
    }
}