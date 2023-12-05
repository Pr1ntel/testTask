package com.example.testtask.service;

import com.example.testtask.dto.TasksResponseDto;
import com.example.testtask.repository.PriorityTypeRepository;
import com.example.testtask.repository.StatusTypeRepository;
import com.example.testtask.repository.TasksRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class TasksService {
    private final PriorityTypeRepository priorityTypeRepository;
    private final StatusTypeRepository statusTypeRepository;
    private final TasksRepository tasksRepository;


    public List<TasksResponseDto> getAll() {
        return tasksRepository.findAll().stream().map(
                tasks -> TasksResponseDto.builder()
                        .id(tasks.getId())
                        .header(tasks.getHeader())
                        .description(tasks.getDescription())
                        .statusTypeName(tasks.getStatusTypeId().getStatusType())
                        .priorityTypeName(tasks.getPriorityTypeId().getPriorityType())
                        .authorName(tasks.getAuthorId().getUsername())
                        .executorName(tasks.getExecutorId().getUsername())
                        .build()
        ).collect(Collectors.toList());
    }


    public void getByHeader(String header) {
        tasksRepository.getByHeader(header);
    }

    public void deleteByHeader(String header) {
        getByHeader(tasksRepository.deleteByHeader(header));
    }
}
