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
    private Long id;
    private String dni;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    @Column(nullable = false)
    private String role;
    private LocalDate birthDate;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
