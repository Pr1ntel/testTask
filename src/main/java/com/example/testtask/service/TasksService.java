package com.example.testtask.service;

import com.example.testtask.dto.TasksRequestDto;
import com.example.testtask.dto.TasksResponseDto;
import com.example.testtask.model.*;
import com.example.testtask.repository.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.config.Task;
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
    private final UsersRepository usersRepository;
    private final CommentsRepository commentsRepository;


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

    public void addNewTask(TasksRequestDto tasksRequestDto){

        StatusType findStatusType = statusTypeRepository.findById(tasksRequestDto.getStatusTypeId()).get();
        PriorityType findPriorityType = priorityTypeRepository.findById(tasksRequestDto.getStatusTypeId()).get();
        Users findAuthorId = usersRepository.findById(tasksRequestDto.getAuthorId()).get();
        Users findExecutorId = usersRepository.findById(tasksRequestDto.getExecutorId()).get();
        Comments findComments = commentsRepository.findById(tasksRequestDto.getComment()).get();

        Tasks insertNewTask = Tasks.builder()
                .header(tasksRequestDto.getHeader())
                .description(tasksRequestDto.getDescription())
                .statusTypeId(findStatusType)
                .priorityTypeId(findPriorityType)
                .authorId(findAuthorId)
                .executorId(findExecutorId)
                .commentId(findComments)
                .build();
        tasksRepository.save(insertNewTask);

    }
}
