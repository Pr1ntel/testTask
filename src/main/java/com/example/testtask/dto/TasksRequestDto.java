package com.example.testtask.dto;


import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TasksRequestDto {

    private String header;
    private String description;
    private int statusTypeId;
    private int priorityTypeId;
    private int authorId;
    private int executorId;
}
