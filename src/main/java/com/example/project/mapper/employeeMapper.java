package com.example.project.mapper;

import com.example.project.dto.employeeDto;
import com.example.project.model.employee;

public class employeeMapper {

    public static employeeDto mapToemployeeDto(employee employee) {
        return new employeeDto(
                employee.getEmployee_id(),
                employee.getFirst_name(),
                employee.getLast_name(),
                employee.getEmail(),
                employee.getRole(),
                employee.getDepartment()
        );
    }
    public static employee mapToEmployee(employeeDto dto) {
        return new employee(
                dto.getEmployee_id(),
                dto.getFirst_name(),
                dto.getLast_name(),
                dto.getEmail(),
                dto.getRole(),
                dto.getDepartment()
        );
    }
}
