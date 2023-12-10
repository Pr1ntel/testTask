package com.example.testtask.repository;

import com.example.testtask.dto.TasksRequestDto;
import com.example.testtask.dto.TasksResponseDto;
import com.example.testtask.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {
    Tasks findTasksById(int id);





}
