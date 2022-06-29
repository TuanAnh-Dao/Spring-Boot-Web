package com.crawlweb.backend.controllers;

import com.crawlweb.backend.entites.ProjectEntity;
import com.crawlweb.backend.services.MapValidationErrorService;
import com.crawlweb.backend.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody ProjectEntity project, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!= null) return errorMap;

        ProjectEntity project1 = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<?> findProjectByProjectIdentifier(@PathVariable String identifier){
        ProjectEntity project = projectService.findProjectByProjectIdentifier(identifier);
        return new ResponseEntity<ProjectEntity>(project, HttpStatus.OK);
    }
}
