package com.example.app_almacenamiento.infraestructure.out.persistance.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Builder
public final class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final String dni;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final LocalDate birthDate;

    private final LocalDateTime createDate;
    private final LocalDateTime updateDate;
}
