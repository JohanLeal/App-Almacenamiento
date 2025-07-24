package com.example.app_almacenamiento.infraestructure.out.persistance.adapters;

import com.example.app_almacenamiento.application.port.out.UserRepositoryPort;
import com.example.app_almacenamiento.domain.dto.response.StatusResponse;
import com.example.app_almacenamiento.domain.model.User;
import com.example.app_almacenamiento.infraestructure.out.mapper.UserMapperOut;
import com.example.app_almacenamiento.infraestructure.out.persistance.adapters.repositories.SpringDataUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    private final SpringDataUserRepository springUserRepository;

    private final UserMapperOut userMapper;

    public JpaUserRepositoryAdapter(SpringDataUserRepository springUserRepository, UserMapperOut userMapper) {
        this.springUserRepository = springUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public StatusResponse saveUser(User user) {
        springUserRepository.save(userMapper.createUserMapper(user));
        return StatusResponse.builder().code("200").message("User saved successfully!").build();
    }

    @Override
    public User getUser(String username) {
        return userMapper.getUserByUsername(springUserRepository.findByUsername(username));
    }

}
