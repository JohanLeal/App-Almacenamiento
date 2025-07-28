package com.example.app_almacenamiento.infraestructure.in.mapper;

import com.example.app_almacenamiento.domain.dto.response.AllUsers;
import com.example.app_almacenamiento.domain.model.User;
import com.example.app_almacenamiento.infraestructure.in.dto.request.UserRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapperIn {

    public User createUserMapper(UserRequest userRequest) {
        return User.builder()
                .firstName(userRequest.firstname())
                .lastName(userRequest.lastName())
                .email(userRequest.email())
                .username(userRequest.username())
                .password(userRequest.password())
                .dni(userRequest.dni())
                .birthDate(userRequest.birthDate())
                .build();
    }

    public List<AllUsers> getAllUsersMapper(List<User> users){
        return users.stream()
                .map(user -> AllUsers.builder()
                        .username(user.username())
                        .firstName(user.firstName())
                        .email(user.email())
                        .build())
                .toList();
    }
}
