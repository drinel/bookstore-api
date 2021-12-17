package com.spring.bookstore.resources.exceptions;

import com.spring.bookstore.services.exceptions.ObjectNotFoundException;
import org.hibernate.ObjectDeletedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@ControllerAdvice
public class ResourceExceptionHandler {


    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request){
        StandardError error = new StandardError(Instant.now(), HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
