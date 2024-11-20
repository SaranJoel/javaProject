package com.example.project.model;

import com.example.project.dto.projectDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private int client_id;

    @Column(name = "client_name", nullable = false)
    private String client_name;

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "client_email", nullable = false)
    private String client_email;

    @Column(name = "address")
    private String address;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "industry")
    private String industry;

}
