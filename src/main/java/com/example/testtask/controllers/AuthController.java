package com.example.testtask.controllers;

import com.example.testtask.auth_service.AuthService;
import com.example.testtask.dto.AuthRequestDto;
import com.example.testtask.dto.AuthResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;


    @PostMapping("/authenticate")
    public AuthResponseDto auth(@RequestBody AuthRequestDto authRequestDto) {
        try {
            return authService.auth(authRequestDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

   /* @PostMapping("/register")
    public AuthResponseDto register(@RequestBody AuthRequestDto registerRequestDto) {
        return authService.register(registerRequestDto);
    }*/

}