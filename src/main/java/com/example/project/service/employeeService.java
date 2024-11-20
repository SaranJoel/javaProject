package com.example.project.service;

import com.example.project.dto.employeeDto;
import com.example.project.model.employee;
import com.example.project.repo.employeeRepo;

import java.util.List;

public interface employeeService {

    employeeDto save(employeeDto emplDto);
    List<employeeDto> findAllEmployees();
    employeeDto findEmployeeById(int id);
    employeeDto update(int employee_id, employeeDto emplDto);
    void delete(int employee_id);

}
