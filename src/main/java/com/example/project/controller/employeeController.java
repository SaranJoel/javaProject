package com.example.project.controller;

import com.example.project.dto.employeeDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.project.service.employeeService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class employeeController {
    private final employeeService employeeService;



    @PostMapping
    public ResponseEntity<employeeDto> save(@RequestBody employeeDto employeeDto){
        employeeDto savedempl = employeeService.save(employeeDto);
        return new ResponseEntity<>(savedempl, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<employeeDto>> findAllEmployees(){
        List<employeeDto> employees = employeeService.findAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("{id}")
    public ResponseEntity<employeeDto> findEmployeeById(@PathVariable("id") int employee_id){
        employeeDto employeeDto = employeeService.findEmployeeById(employee_id);
        return  employeeDto != null ? ResponseEntity.ok(employeeDto) : ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<employeeDto> update(@PathVariable("id") int employee_id, @RequestBody employeeDto employeeDto){
        employeeDto updatedempl = employeeService.update(employee_id, employeeDto) ;
        return ResponseEntity.ok(updatedempl);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int employee_id){
        employeeService.delete(employee_id);
        return ResponseEntity.ok("Employee deleted successfully");
    }

    @GetMapping("/a")
    public String myf(){return "ok";}
}
