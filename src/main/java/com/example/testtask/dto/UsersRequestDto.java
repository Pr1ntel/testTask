package com.example.testtask.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersRequestDto {
    private String firstName;
    private String lastName;
    private String patronymicName;
    private int age;
    private String roleName;
}
