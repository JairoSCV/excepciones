package com.application.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.application.entity.ErrorDTO;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runTimeException(RuntimeException ex){
        ErrorDTO errorDTO = ErrorDTO.builder()
                            .mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
