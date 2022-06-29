package com.crawlweb.backend.exceptions;

public class ProjectIdentifierResponse {
    private String projectIdentifier;

    public ProjectIdentifierResponse(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}
