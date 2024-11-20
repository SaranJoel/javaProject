package com.example.project.mapper;

import com.example.project.dto.projectDto;
import com.example.project.dto.clientDto;
import com.example.project.model.project;
import com.example.project.model.client;

import java.util.List;
import java.util.stream.Collectors;

public class projectMapper {

    // Method to map project entity to projectDto
    public static projectDto mapToprojectDto(project project) {
        clientDto clientDto = clientMapper.mapToclientDto(project.getClient());  // Map client to clientDto
        return new projectDto(
                project.getProject_id(),
                clientDto,  // Use the clientDto here
                project.getProject_name(),
                project.getStart_date(),
                project.getEnd_date(),
                project.getStatus(),
                project.getProject_type()
        );
    }

    // Method to map projectDto to project entity
    public static project mapToproject(projectDto dto) {
        // Map clientDto back to client entity
        client clientEntity = clientMapper.mapToclient(dto.getClient());

        return new project(
                dto.getProject_id(),
                clientEntity,  // Use the client entity here
                dto.getProject_name(),
                dto.getStart_date(),
                dto.getEnd_date(),
                dto.getStatus(),
                dto.getProject_type()
        );
    }
}
