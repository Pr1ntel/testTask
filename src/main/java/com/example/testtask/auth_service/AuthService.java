package com.example.testtask.auth_service;

import com.example.testtask.dto.AuthRequestDto;
import com.example.testtask.dto.AuthResponseDto;
import com.example.testtask.model.Users;
import com.example.testtask.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final UsersRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


/*    public AuthResponseDto register( AuthRequestDto registerRequestDto) {
        Users user = Users.builder()
                .username(registerRequestDto.getUsername())
                .password(passwordEncoder.encode(registerRequestDto.getPassword()))
                .build();
        repository.save(user);

        String jwtToken = jwtService.generateToken(user);

        return AuthResponseDto.builder()
                .token(jwtToken)
                .build();

    }*/


    public AuthResponseDto auth(AuthRequestDto authRequestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequestDto.getUsername(),
                        authRequestDto.getPassword()
                )
        );

        Users user = repository.findByUsername(authRequestDto.getUsername())
                .orElseThrow();

        String jwtToken = jwtService.generateToken(user);

        return AuthResponseDto.builder()
                .token(jwtToken)
                .build();

    }
}