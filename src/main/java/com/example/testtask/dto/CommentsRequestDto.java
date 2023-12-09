package com.example.testtask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CommentsRequestDto {
    private int taskId;
    private String description;
}
