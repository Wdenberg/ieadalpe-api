package com.ieadalpe.ieadalpeapi.controller;

import com.ieadalpe.ieadalpeapi.dto.request.AuthLoginRequest;
import com.ieadalpe.ieadalpeapi.dto.request.UserRegisterRequest;
import com.ieadalpe.ieadalpeapi.dto.response.AuthTokenResponse;
import com.ieadalpe.ieadalpeapi.service.interfaces.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    /*
    // Novo endpoint para criação de conta
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody UserRegisterRequest request) {
        authService.register(request);
    }
    */
    @PostMapping("/login")
    public AuthTokenResponse login(@Valid @RequestBody AuthLoginRequest request) {
        return authService.login(request);
    }
}
