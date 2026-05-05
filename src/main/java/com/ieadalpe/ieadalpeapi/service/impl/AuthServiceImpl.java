package com.ieadalpe.ieadalpeapi.service.impl;

import com.ieadalpe.ieadalpeapi.dto.request.AuthLoginRequest;
import com.ieadalpe.ieadalpeapi.dto.response.AuthTokenResponse;
import com.ieadalpe.ieadalpeapi.exception.BusinessException;
import com.ieadalpe.ieadalpeapi.security.CustomUserDetailsService;
import com.ieadalpe.ieadalpeapi.security.JwtTokenService;
import com.ieadalpe.ieadalpeapi.service.interfaces.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final CustomUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;

    @Override
    public AuthTokenResponse login(AuthLoginRequest request) {
        var userDetails = userDetailsService.loadUserByUsername(request.email());

        if (!passwordEncoder.matches(request.password(), userDetails.getPassword())) {
            throw new BusinessException("Email ou senha inválidos.");
        }

        var tokenData = jwtTokenService.generateToken(userDetails);

        return new AuthTokenResponse(
                tokenData.accessToken(),
                "Bearer",
                tokenData.expiresIn(),
                tokenData.issuedAt(),
                tokenData.expiresAt()
        );
    }
}