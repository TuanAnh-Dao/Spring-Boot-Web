package com.crawlweb.backend.services;

import com.crawlweb.backend.entites.ProjectEntity;
import com.crawlweb.backend.exceptions.ProjectIdentifierException;
import com.crawlweb.backend.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public ProjectEntity saveOrUpdateProject(ProjectEntity projectEntity) {
        try {
            projectEntity.setProjectIdentifier(projectEntity.getProjectIdentifier().toUpperCase());
            return projectRepository.save(projectEntity);
        } catch (Exception e) {
            throw new ProjectIdentifierException("Project '" + projectEntity.getProjectIdentifier().toUpperCase() + "' already exists!");
        }
    }

    public ProjectEntity findProjectByProjectIdentifier(String projectIdentifier) {
        ProjectEntity project = projectRepository.findProjectEntityByProjectIdentifier(projectIdentifier);
        if (project == null)
            throw new ProjectIdentifierException("Project '" + projectIdentifier + "' does not exist!");
        return project;
    }

    public Iterable<ProjectEntity> findAllProject() {
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String identifier) {
        ProjectEntity project = projectRepository.findProjectEntityByProjectIdentifier(identifier);
        if (project == null) throw new ProjectIdentifierException("Project '" + identifier + "' does not exist!");

        projectRepository.delete(project);
    }

}
