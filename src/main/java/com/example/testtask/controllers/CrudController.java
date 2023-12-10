package com.example.testtask.controllers;

import com.example.testtask.dto.CommentsRequestDto;
import com.example.testtask.dto.CommentsResponseDto;
import com.example.testtask.dto.TasksRequestDto;
import com.example.testtask.dto.TasksResponseDto;
import com.example.testtask.model.Tasks;
import com.example.testtask.service.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RequestMapping("/api/v1/crud")
public class CrudController {
    private final TasksService tasksService;

    @GetMapping(value = "/get-all")
    public List<TasksResponseDto> getAll() {
        return tasksService.getAll();
    }

    @GetMapping(value = "/get-all-comments")
    public List<CommentsResponseDto> getAllComments() {
        return tasksService.getAllComments();
    }

    @GetMapping(value = "get-task-by-id/{id}")
    public Tasks getTaskById(@PathVariable int id) {
        return tasksService.getTaskById(id);
    }

    @GetMapping(value = "get-task-by-author-id/{id}")
    public List<TasksResponseDto> getTaskByAuthorId(@PathVariable int id) {
        return tasksService.getAllByAuthorId(id);
    }
    @PostMapping(value = "/new-task")
    public void addNewTask(@RequestBody TasksRequestDto tasksRequestDto) {
        tasksService.addNewTask(tasksRequestDto);
    }

    @PostMapping(value = "/new-comment")
    public void addNewComment(@RequestBody CommentsRequestDto commentsRequestDto) {
        tasksService.addNewComment(commentsRequestDto);
    }


}
