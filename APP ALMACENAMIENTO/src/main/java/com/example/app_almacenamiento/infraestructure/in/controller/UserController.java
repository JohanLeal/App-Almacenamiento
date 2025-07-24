package com.example.app_almacenamiento.infraestructure.in.controller;

import com.example.app_almacenamiento.application.port.in.CreateUserCase;
import com.example.app_almacenamiento.application.port.in.LoginUserCase;
import com.example.app_almacenamiento.domain.dto.response.LoginResponse;
import com.example.app_almacenamiento.domain.dto.response.StatusResponse;
import com.example.app_almacenamiento.infraestructure.in.dto.request.UserLogin;
import com.example.app_almacenamiento.infraestructure.in.dto.request.UserRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final CreateUserCase createUserCase;

    private final LoginUserCase loginUserCase;

    public UserController(CreateUserCase createUserCase, LoginUserCase loginUserCase) {
        this.createUserCase = createUserCase;
        this.loginUserCase = loginUserCase;
    }

    @PostMapping
    public StatusResponse createUser(@RequestBody UserRequest userRequest) {
        return createUserCase.createUser(userRequest);
    }

    @GetMapping("/login")
    public LoginResponse loginUser(@RequestBody UserLogin userLogin) {
        return loginUserCase.loginUser(userLogin);
    }
}
