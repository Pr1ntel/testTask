package com.example.testtask.service;

import com.example.testtask.dto.TasksResponseDto;
import com.example.testtask.dto.UsersResponseDto;
import com.example.testtask.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public List<UsersResponseDto> getAll() {
        return usersRepository.findAll().stream().map(
                users -> UsersResponseDto.builder()
                        .firstName(users.getFirstName())
                        .lastName(users.getLastName())
                        .patronymicName(users.getPatronymicName())
                        .age(users.getAge())
                        .roleName(users.getRoleName().getRoleName())
                        .build()
        ).collect(Collectors.toList());
    }
}
