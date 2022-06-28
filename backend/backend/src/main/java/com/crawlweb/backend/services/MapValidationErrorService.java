package com.crawlweb.backend.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorService {
    public ResponseEntity<?> MapValidationService(BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errorList = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errorList.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
        } else return null;
    }
}
