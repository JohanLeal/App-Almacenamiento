package com.example.app_almacenamiento.infraestructure.in.controller;

import com.example.app_almacenamiento.application.port.in.CreateUserCase;
import com.example.app_almacenamiento.domain.dto.response.StatusResponse;
import com.example.app_almacenamiento.infraestructure.in.dto.request.UserRequest;
import com.example.app_almacenamiento.infraestructure.in.mapper.UserMapperIn;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final CreateUserCase createUserCase;

    private final UserMapperIn userMapper;

    public UserController(CreateUserCase createUserCase, UserMapperIn userMapper) {
        this.createUserCase = createUserCase;
        this.userMapper = userMapper;
    }

    @PostMapping
    public StatusResponse createUser(@RequestBody UserRequest userRequest) {
        createUserCase.createUser(userMapper.createUserMapper(userRequest));
        return StatusResponse.builder().code("200").message("New user created").build();
    }
}
