package com.example.register.demo.service;


import com.example.register.demo.dto.request.UserRequest;
import com.example.register.demo.dto.response.UserResponse;

public interface RegisterService {

    UserResponse registerUser(UserRequest userRequest) throws Exception;

}
