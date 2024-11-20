package com.example.project.controller;

import com.example.project.dto.projectDto;
import com.example.project.service.projectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class projectController {

    private final projectService projectService;

    public projectController(projectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<projectDto> save(@RequestBody projectDto projectDto) {
        projectDto savedProject = projectService.save(projectDto);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<projectDto>> findAllProjects() {
        List<projectDto> projects = projectService.findAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("{id}")
    public ResponseEntity<projectDto> findProjectById(@PathVariable("id") int projectId) {
        projectDto projectDto = projectService.findProjectById(projectId);
        return projectDto != null ? ResponseEntity.ok(projectDto) : ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<projectDto> update(@PathVariable("id") int projectId, @RequestBody projectDto projectDto) {
        projectDto updatedProject = projectService.update(projectId, projectDto);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int projectId) {
        projectService.delete(projectId);
        return ResponseEntity.ok("Project deleted successfully");
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "Project controller is working";
    }
}
