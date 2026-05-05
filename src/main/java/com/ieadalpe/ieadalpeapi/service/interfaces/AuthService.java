package com.ieadalpe.ieadalpeapi.service.interfaces;


import com.ieadalpe.ieadalpeapi.dto.request.AuthLoginRequest;
import com.ieadalpe.ieadalpeapi.dto.response.AuthTokenResponse;

public interface AuthService {
    AuthTokenResponse login(AuthLoginRequest request);
}
