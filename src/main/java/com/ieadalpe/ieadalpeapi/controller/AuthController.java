package com.ieadalpe.ieadalpeapi.controller;

import com.ieadalpe.ieadalpeapi.dto.request.AuthLoginRequest;
import com.ieadalpe.ieadalpeapi.dto.response.AuthTokenResponse;
import com.ieadalpe.ieadalpeapi.service.interfaces.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public AuthTokenResponse login(@Valid @RequestBody AuthLoginRequest request) {
        return authService.login(request);
    }
}
