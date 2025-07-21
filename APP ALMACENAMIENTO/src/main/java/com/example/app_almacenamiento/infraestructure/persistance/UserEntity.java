package com.example.app_almacenamiento.infraestructure.persistance;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private final String firstName;
    private final String lastName;
}
