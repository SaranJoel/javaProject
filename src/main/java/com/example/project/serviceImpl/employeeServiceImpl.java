package com.example.project.serviceImpl;

import com.example.project.dto.employeeDto;
import com.example.project.mapper.employeeMapper;
import com.example.project.model.employee;
import com.example.project.repo.employeeRepo;
import com.example.project.service.employeeService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class employeeServiceImpl implements employeeService {

    private final employeeRepo EmployeeRepo;

    public employeeServiceImpl(employeeRepo EmployeeRepo) {
        this.EmployeeRepo = EmployeeRepo;
    }

    @Override
    public employeeDto save(employeeDto emplDto) {
        employee empl =  employeeMapper.mapToEmployee(emplDto);
        employee savedempl = EmployeeRepo.save(empl);
        return employeeMapper.mapToemployeeDto(savedempl);
    }

    @Override
    public List<employeeDto> findAllEmployees(){
        return EmployeeRepo.findAll().stream()
                .map(employeeMapper::mapToemployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public employeeDto findEmployeeById(int id) {
        employee employee = EmployeeRepo.findById(id).orElse(null);
        return employee != null ? employeeMapper.mapToemployeeDto(employee) : null;

    }

    @Override
    public employeeDto update(int employee_id,employeeDto emplDto) {
        employee existingEmployee = EmployeeRepo.findById(emplDto.getEmployee_id())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existingEmployee.setFirst_name(emplDto.getFirst_name());
        existingEmployee.setLast_name(emplDto.getLast_name());
        existingEmployee.setEmail(emplDto.getEmail());
        existingEmployee.setRole(emplDto.getRole());
        existingEmployee.setDepartment(emplDto.getDepartment());

        employee updatedEmployee = EmployeeRepo.save(existingEmployee);
        return employeeMapper.mapToemployeeDto(updatedEmployee);
    }

    @Override
    public void delete(int employee_id) {
        EmployeeRepo.deleteById(employee_id);
    }




}
