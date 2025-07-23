package com.example.app_almacenamiento.infraestructure.in.mapper;

import com.example.app_almacenamiento.domain.model.User;
import com.example.app_almacenamiento.infraestructure.in.dto.request.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapperIn {

    public User createUserMapper(UserRequest userRequest) {
        return User.builder()
                .firstName(userRequest.firstname())
                .lastName(userRequest.lastName())
                .email(userRequest.email())
                .password(userRequest.password())
                .dni(userRequest.dni())
                .birthDate(userRequest.birthDate())
                .build();
    }
}
