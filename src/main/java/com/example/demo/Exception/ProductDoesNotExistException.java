package com.example.demo.Exception;

public class ProductDoesNotExistException extends RuntimeException {
    public ProductDoesNotExistException(String message) {
        super(message);
    }
}
