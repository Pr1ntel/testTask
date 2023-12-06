package com.example.testtask.controllers;

import com.example.testtask.dto.TasksRequestDto;
import com.example.testtask.dto.TasksResponseDto;
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

    @PostMapping(value = "/new-task")
    public void addNewTask(@RequestBody TasksRequestDto tasksRequestDto){
        tasksService.addNewTask(tasksRequestDto);
    }
}
