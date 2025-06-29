package com.motorph.payroll.exception;

/**
 * Exception thrown when data validation fails
 */
public class ValidationException extends RuntimeException {
    
    public ValidationException(String message) {
        super(message);
    }
}