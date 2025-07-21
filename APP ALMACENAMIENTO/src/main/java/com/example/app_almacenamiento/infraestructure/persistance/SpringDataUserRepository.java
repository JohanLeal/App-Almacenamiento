package com.example.app_almacenamiento.infraestructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> {
}
