package com.example.testtask.repository;

import com.example.testtask.model.PriorityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityTypeRepository extends JpaRepository<PriorityType, Integer> {

}
