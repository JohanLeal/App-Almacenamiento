package com.example.app_almacenamiento.infraestructure.persistance;

import com.example.app_almacenamiento.application.port.out.UserRepositoryPort;
import com.example.app_almacenamiento.domain.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    private final SpringDataUserRepository springUserRepository;

    public JpaUserRepositoryAdapter(SpringDataUserRepository springUserRepository) {
        this.springUserRepository = springUserRepository;
    }

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = new UserEntity(user.id(), user.firstName(),  user.lastName());
        final UserEntity savedUser = springUserRepository.save(userEntity);
        return new User(savedUser.getId(),  savedUser.getFirstName(), savedUser.getLastName());
    }
}
