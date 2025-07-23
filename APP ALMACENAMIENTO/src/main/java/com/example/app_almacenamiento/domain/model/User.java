package com.example.app_almacenamiento.domain.model;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record User(
        Long id,
        String dni,
        String firstName,
        String lastName,
        String email,
        String password,
        LocalDate birthDate,
        LocalDateTime createDate,
        LocalDateTime updateDate
) {
}
