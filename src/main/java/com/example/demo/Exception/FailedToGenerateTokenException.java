package com.example.demo.Exception;

public class FailedToGenerateTokenException extends RuntimeException {
    public FailedToGenerateTokenException(String message) {
        super(message);
    }
}
