package com.example.app_almacenamiento.infraestructure.out.persistance.adapters.repositories;

import com.example.app_almacenamiento.infraestructure.out.persistance.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}
