package com.example.app_almacenamiento.infraestructure.controller;

import com.example.app_almacenamiento.application.port.in.CreateUserCase;
import com.example.app_almacenamiento.domain.model.User;
import com.example.app_almacenamiento.infraestructure.dto.request.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final CreateUserCase createUserCase;

    public UserController(CreateUserCase createUserCase) {
        this.createUserCase = createUserCase;
    }

    @PostMapping
    public void createUser(@RequestBody UserRequest userRequest) {
        final User user = new User(null, userRequest.firstname(), userRequest.lastName());
        createUserCase.createUser(user);
    }
}
