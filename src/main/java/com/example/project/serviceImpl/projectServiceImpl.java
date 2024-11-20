package com.example.project.serviceImpl;

import com.example.project.mapper.projectMapper;
import com.example.project.dto.projectDto;
import com.example.project.model.project;
import com.example.project.repo.projectRepo;
import com.example.project.service.projectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class projectServiceImpl implements projectService {

    private final projectRepo projectRepo;

    public projectServiceImpl(projectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public projectDto save(projectDto projectDto) {
        project projectEntity = projectMapper.mapToproject(projectDto);
        project savedProject = projectRepo.save(projectEntity);
        return projectMapper.mapToprojectDto(savedProject);
    }

    @Override
    public List<projectDto> findAllProjects() {
        return projectRepo.findAll().stream()
                .map(projectMapper::mapToprojectDto)
                .collect(Collectors.toList());
    }

    @Override
    public projectDto findProjectById(int id) {
        project projectEntity = projectRepo.findById(id).orElse(null);
        return projectEntity != null ? projectMapper.mapToprojectDto(projectEntity) : null;
    }

    @Override
    public projectDto update(int projectId, projectDto projectDto) {
        project existingProject = projectRepo.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        existingProject.setProject_name(projectDto.getProject_name());
        existingProject.setStart_date(projectDto.getStart_date());
        existingProject.setEnd_date(projectDto.getEnd_date());
        existingProject.setStatus(projectDto.getStatus());
        existingProject.setProject_type(projectDto.getProject_type());

        project updatedProject = projectRepo.save(existingProject);
        return projectMapper.mapToprojectDto(updatedProject);
    }

    @Override
    public void delete(int projectId) {
        projectRepo.deleteById(projectId);
    }
}
