package com.example.app_almacenamiento.infraestructure.in.dto.request;

import java.time.LocalDate;

public record UserRequest(
        String firstname,
        String lastName,
        String dni,
        String email,
        String username,
        String password,
        LocalDate birthDate

) {
}
