package com.example.project.service;

import com.example.project.dto.projectDto;
import com.example.project.model.project;

import java.util.List;

public interface projectService {

    projectDto save(projectDto projectDto);
    List<projectDto> findAllProjects();
    projectDto findProjectById(int id);
    projectDto update(int project_id, projectDto projectDto);
    void delete(int id);

}
