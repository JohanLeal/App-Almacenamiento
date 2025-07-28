package com.example.app_almacenamiento.application.service;

import com.example.app_almacenamiento.application.port.in.CreateUserCase;
import com.example.app_almacenamiento.application.port.in.GetUserCase;
import com.example.app_almacenamiento.application.port.in.LoginUserCase;
import com.example.app_almacenamiento.application.port.out.UserRepositoryPort;
import com.example.app_almacenamiento.domain.dto.response.AllUsers;
import com.example.app_almacenamiento.domain.dto.response.LoginResponse;
import com.example.app_almacenamiento.domain.dto.response.StatusResponse;
import com.example.app_almacenamiento.domain.model.User;
import com.example.app_almacenamiento.infraestructure.in.dto.request.UserLogin;
import com.example.app_almacenamiento.infraestructure.in.dto.request.UserRequest;
import com.example.app_almacenamiento.infraestructure.in.mapper.UserMapperIn;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements CreateUserCase, LoginUserCase, GetUserCase {

    private final UserRepositoryPort userRepositoryPort;

    private final UserMapperIn  userMapperIn;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepositoryPort userRepositoryPort, UserMapperIn userMapperIn, PasswordEncoder passwordEncoder) {
        this.userRepositoryPort = userRepositoryPort;
        this.userMapperIn = userMapperIn;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public StatusResponse createUser(UserRequest user) {
        User existingUser = userRepositoryPort.getUser(user.username());
        if (existingUser != null && existingUser.username() != null) {
            return StatusResponse.builder().code("409").message("This username already exists").build();
        }
        userRepositoryPort.saveUser(userMapperIn.createUserMapper(user));
        return StatusResponse.builder().code("200").message("User saved successfully!").build();
    }

    @Override
    public LoginResponse loginUser(UserLogin user) {
        User userModel = userRepositoryPort.getUser(user.username());
        Boolean password = passwordEncoder.matches(user.password(), userModel.password());
        if (userModel.equals(null)) {
            return LoginResponse.builder().code("404").message("User not found!").build();
        } else if(Boolean.FALSE.equals(password)) {
            return LoginResponse.builder().code("401").message("Wrong Password!").build();
        }
        return LoginResponse.builder().code("200").message("Welcome " + user.username() + "!").build();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositoryPort.getAllUsers();
    }
}
