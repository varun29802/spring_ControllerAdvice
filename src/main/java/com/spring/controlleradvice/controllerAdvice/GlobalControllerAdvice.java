package com.spring.controlleradvice.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    /**
     * Handles IllegalArgumentException globally for invalid inputs such as invalid userId.
     *
     * @param exception - the exception thrown when an invalid userId is provided.
     * @return ResponseEntity with a custom error message and HTTP status BAD_REQUEST (400).
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException exception) {
        return new ResponseEntity<>("Error: " + exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * A generic exception handler to catch any unhandled exceptions globally.
     *
     * @param exception - the exception thrown during any operation.
     * @return ResponseEntity with a custom error message and HTTP status INTERNAL_SERVER_ERROR (500).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception exception) {
        return new ResponseEntity<>("Handled by Global Exception Handler: " + exception.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
