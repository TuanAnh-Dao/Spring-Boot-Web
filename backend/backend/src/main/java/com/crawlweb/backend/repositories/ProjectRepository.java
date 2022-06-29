package com.crawlweb.backend.repositories;

import com.crawlweb.backend.entites.ProjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {

    @Override
    Iterable<ProjectEntity> findAllById(Iterable<Long> longs);

    ProjectEntity findProjectEntityByProjectIdentifier(String projectIdentifier);
}
