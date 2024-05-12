package com.java.api.exceptions;

import java.nio.file.AccessDeniedException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.java.api.models.ResponseModel;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ResponseModel<String>> accessDeniedExceptionHandler(AccessDeniedException ex) {
        ResponseModel<String> response = new ResponseModel<String>(
            new Date(),
            403,
            "Unathorized",
            ex.getMessage()
        );

        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseModel<String>> notFoundExceptionHandler(Exception ex, WebRequest webRequest){
        ResponseModel<String> response = new ResponseModel<String>(
            new Date(),
            404,
            "Not found",
            ex.getMessage()
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DeletedException.class)
    public ResponseEntity<ResponseModel<String>> deletedExceptionHandler(Exception ex, WebRequest webRequest){
        ResponseModel<String> response = new ResponseModel<String>(
            new Date(),
            404,
            "Element deleted",
            ex.getMessage()
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseModel<String>> exceptionHandler(Exception ex, WebRequest webRequest){
        ResponseModel<String> response = new ResponseModel<String>(
            new Date(),
            500,
            "Internal Server Error",
            ex.getMessage()
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
