package com.example.testtask.service;

import com.example.testtask.dto.CommentsRequestDto;
import com.example.testtask.dto.CommentsResponseDto;
import com.example.testtask.dto.TasksRequestDto;
import com.example.testtask.dto.TasksResponseDto;
import com.example.testtask.model.*;
import com.example.testtask.repository.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(TasksService.class);


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

    public Tasks getTaskById(int id){
        return tasksRepository.findTasksById(id);
    }



   /* public void getTaskByHeader(String header) {
        tasksRepository.getByHeader(header);
    }

    public void deleteTaskByHeader(int id) {
        getTaskByHeader(tasksRepository.deleteById(id));
    }*/

    public void addNewTask(TasksRequestDto tasksRequestDto) {

        StatusType findStatusType = statusTypeRepository.findById(tasksRequestDto.getStatusTypeId()).get();
        PriorityType findPriorityType = priorityTypeRepository.findById(tasksRequestDto.getStatusTypeId()).get();
        Users findAuthorId = usersRepository.findById(tasksRequestDto.getAuthorId()).get();
        Users findExecutorId = usersRepository.findById(tasksRequestDto.getExecutorId()).get();

        try {
            Tasks insertNewTask = Tasks.builder()
                    .header(tasksRequestDto.getHeader())
                    .description(tasksRequestDto.getDescription())
                    .statusTypeId(findStatusType)
                    .priorityTypeId(findPriorityType)
                    .authorId(findAuthorId)
                    .executorId(findExecutorId)
                    .build();
            tasksRepository.save(insertNewTask);

        } catch (Exception e) {
            e.printStackTrace();
            Tasks failedFilmsItem = Tasks.builder()
                    .header(tasksRequestDto.getHeader())
                    .description(tasksRequestDto.getDescription())
                    .statusTypeId(findStatusType)
                    .priorityTypeId(findPriorityType)
                    .authorId(findAuthorId)
                    .executorId(findExecutorId)
                    .build();

            logger.error("ошибка тут" + failedFilmsItem);
        }
    }
    public void addNewComment(CommentsRequestDto commentsRequestDto) {
        Comments insertNewComment = Comments.builder()
                .taskId(commentsRequestDto.getTaskId())
                .description(commentsRequestDto.getDescription())
                .build();
        commentsRepository.save(insertNewComment);
    }

    public List<CommentsResponseDto> getAllComments() {
        return commentsRepository.findAll().stream().map(
                comments -> CommentsResponseDto.builder()
                        .taskId(comments.getTaskId())
                        .description(comments.getDescription())
                        .build()
        ).collect(Collectors.toList());
    }

}