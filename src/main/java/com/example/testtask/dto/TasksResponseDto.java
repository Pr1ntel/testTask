package com.example.testtask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TasksResponseDto {

    private int id;
    private String header;
    private String description;
    private String statusTypeName;
    private String priorityTypeName;
    private String authorName;
    private String executorName;
    private int comment;
}
