package com.ieadalpe.ieadalpeapi.service.interfaces;


import com.ieadalpe.ieadalpeapi.dto.request.AuthLoginRequest;
import com.ieadalpe.ieadalpeapi.dto.request.UserRegisterRequest;
import com.ieadalpe.ieadalpeapi.dto.response.AuthTokenResponse;
import com.ieadalpe.ieadalpeapi.dto.response.UserResponse;

public interface AuthService {
    AuthTokenResponse login(AuthLoginRequest request);

   // UserResponse register(UserRegisterRequest request);
}
