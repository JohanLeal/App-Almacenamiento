package com.example.app_almacenamiento.infraestructure.persistance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Builder
public class RegisterData {

    private final LocalDateTime createDate;
    private final LocalDateTime updateDate;
}
