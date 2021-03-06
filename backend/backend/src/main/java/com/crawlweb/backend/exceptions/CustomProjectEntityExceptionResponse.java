package com.crawlweb.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomProjectEntityExceptionResponse extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public final ResponseEntity<Object> handleProjectIdentifierException(ProjectIdentifierException projectIdentifierException, WebRequest request){
        ProjectIdentifierResponse projectIdentifierResponse = new ProjectIdentifierResponse(projectIdentifierException.getMessage());
        return new ResponseEntity(projectIdentifierResponse, HttpStatus.BAD_REQUEST);
    }
}
