package com.example.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project")
public class project {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private int project_id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private client client;

    @Column(name = "project_name", nullable = false)
    private String project_name;

    @Column(name = "start_date", nullable = false)
    private String start_date;

    @Column(name = "end_date")
    private String end_date;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "project_type", nullable = false)
    private String project_type;
}
