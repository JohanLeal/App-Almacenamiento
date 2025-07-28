package com.example.app_almacenamiento.infraestructure.in.controller;

import com.example.app_almacenamiento.application.port.in.CreateUserCase;
import com.example.app_almacenamiento.application.port.in.GetUserCase;
import com.example.app_almacenamiento.application.port.in.LoginUserCase;
import com.example.app_almacenamiento.domain.dto.response.AllUsers;
import com.example.app_almacenamiento.domain.dto.response.LoginResponse;
import com.example.app_almacenamiento.domain.dto.response.StatusResponse;
import com.example.app_almacenamiento.infraestructure.in.dto.request.UserLogin;
import com.example.app_almacenamiento.infraestructure.in.dto.request.UserRequest;
import com.example.app_almacenamiento.infraestructure.in.mapper.UserMapperIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User")
@RestController
@RequestMapping("/user")
public class UserController {

    private final CreateUserCase createUserCase;

    private final LoginUserCase loginUserCase;

    private final GetUserCase getUserCase;

    private final UserMapperIn  restMapper;

    public UserController(CreateUserCase createUserCase, LoginUserCase loginUserCase, GetUserCase getUserCase, UserMapperIn restMapper) {
        this.createUserCase = createUserCase;
        this.loginUserCase = loginUserCase;
        this.getUserCase = getUserCase;
        this.restMapper = restMapper;
    }

    @PostMapping
    public StatusResponse createUser(@RequestBody UserRequest userRequest) {
        return createUserCase.createUser(userRequest);
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody UserLogin userLogin) {
        return loginUserCase.loginUser(userLogin);
    }

    @GetMapping("/getAll")
    public List<AllUsers> getAllUsers() {
        return restMapper.getAllUsersMapper(getUserCase.getAllUsers());
    }
}
