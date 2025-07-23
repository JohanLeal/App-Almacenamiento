package com.example.app_almacenamiento.application.service;

import com.example.app_almacenamiento.application.port.in.CreateUserCase;
import com.example.app_almacenamiento.application.port.out.UserRepositoryPort;
import com.example.app_almacenamiento.domain.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements CreateUserCase {

    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public void createUser(User user) {
        userRepositoryPort.saveUser(user);
    }
}
