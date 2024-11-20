package com.example.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class projectDto {
    private int project_id;
    private clientDto client;
    private String project_name;
    private String start_date;
    private String end_date;
    private String status;
    private String project_type;
}
