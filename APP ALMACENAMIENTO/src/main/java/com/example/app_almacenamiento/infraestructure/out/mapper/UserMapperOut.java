package com.example.app_almacenamiento.infraestructure.out.mapper;

import com.example.app_almacenamiento.domain.model.User;
import com.example.app_almacenamiento.infraestructure.out.persistance.entities.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapperOut {

    private final PasswordEncoder passwordEncoder;

    public UserMapperOut(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    public UserEntity createUserMapper(User user){
        return UserEntity.builder()
                .dni(user.dni())
                .firstName(user.firstName())
                .lastName(user.lastName())
                .email(user.email())
                .password(passwordEncoder.encode(user.password()))
                .birthDate(user.birthDate())
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }
}
