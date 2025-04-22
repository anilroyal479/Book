package com.akr.BookApplication.Controller;

import com.akr.BookApplication.Entity.ErrorRespo;
import com.akr.BookApplication.Exceptions.ProductNotFoundException;
import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException exception){
    ErrorRespo productNotFound = new ErrorRespo(LocalDateTime.now(),exception.getMessage(),"product not found exception");
    return new ResponseEntity<>(productNotFound, HttpStatusCode.valueOf(HttpStatus.SC_NOT_FOUND));
    }
}
