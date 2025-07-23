package com.example.app_almacenamiento.infraestructure.persistance;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Builder
public final class UserEntity extends RegisterData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final String dni;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final LocalDate birthDate;
}
