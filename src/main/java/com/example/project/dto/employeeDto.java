package com.example.project.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class employeeDto {
    private int employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String role;
    private String department;

}
