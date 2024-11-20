package com.example.project.dto;

import com.example.project.model.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class clientDto {
    private int client_id;
    private String client_name;
    private String company_name;
    private String client_email;
    private String address;
    private String phone;
    private String industry;

}
