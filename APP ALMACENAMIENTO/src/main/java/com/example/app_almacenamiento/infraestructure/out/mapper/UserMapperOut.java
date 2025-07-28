package com.example.app_almacenamiento.infraestructure.out.mapper;

import com.example.app_almacenamiento.domain.model.User;
import com.example.app_almacenamiento.infraestructure.out.persistance.entities.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

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
                .username(user.username())
                .password(passwordEncoder.encode(user.password()))
                .birthDate(user.birthDate())
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }

    public User getUserByUsername(UserEntity user){
        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    public List<User> getAllUsers(List<UserEntity> users){
        return users.stream()
                .map(user -> User.builder()
                        .firstName(user.getFirstName())
                        .email(user.getEmail())
                        .username(user.getUsername())
                        .build())
                .toList();
    }
}
