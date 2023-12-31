package com.kipas.miniprojectrestapi.exceptions;

import com.kipas.miniprojectrestapi.dtos.response.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

// Global Exception Handler
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ EntityNotFoundException.class, OutOfStockException.class })
    public ResponseEntity<ResponseDTO<Object>> handleNotFoundException(RuntimeException ex) {
        return new ResponseEntity<>(
                ResponseDTO.builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .message("Bad Request")
                        .data(ex.getMessage())
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("Unexpected error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

