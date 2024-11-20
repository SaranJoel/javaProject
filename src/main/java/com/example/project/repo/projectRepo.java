package com.example.project.repo;

import com.example.project.model.project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface projectRepo extends JpaRepository<project, Integer> {
}
