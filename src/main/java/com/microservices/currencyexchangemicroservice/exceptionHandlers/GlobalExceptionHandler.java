package com.microservices.currencyexchangemicroservice.exceptionHandlers;

import com.microservices.currencyexchangemicroservice.dtos.ExceptionDto;
import com.microservices.currencyexchangemicroservice.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleResourceNotFound(ResourceNotFoundException ex) {
        ExceptionDto exceptionDto=new ExceptionDto();
        exceptionDto.setTimestamp(LocalDateTime.now());
        exceptionDto.setError("Not found");
        exceptionDto.setMessage(ex.getMessage());
        return new ResponseEntity<>(exceptionDto,HttpStatus.NOT_FOUND);
    }
}
