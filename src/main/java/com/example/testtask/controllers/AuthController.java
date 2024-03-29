package com.example.testtask.controllers;

import com.example.testtask.auth_service.AuthService;
import com.example.testtask.dto.AuthRequestDto;
import com.example.testtask.dto.AuthResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final Logger logger = LoggerFactory.getLogger(AuthController.class);


    @PostMapping("/authenticate")
    public AuthResponseDto auth(@RequestBody AuthRequestDto authRequestDto) {
        try {
            return authService.auth(authRequestDto);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("auth: " + authRequestDto);
        }
        return null;
    }

   /* @PostMapping("/register")
    public AuthResponseDto register(@RequestBody AuthRequestDto registerRequestDto) {
        return authService.register(registerRequestDto);
    }*/

}