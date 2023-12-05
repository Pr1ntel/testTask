package com.example.testtask.repository;

import com.example.testtask.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {
    String deleteByHeader(String header);
    Tasks getByHeader(String header);

}