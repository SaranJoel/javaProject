package com.example.project.repo;

import com.example.project.model.client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clientRepo extends JpaRepository<client, Integer> {
}
