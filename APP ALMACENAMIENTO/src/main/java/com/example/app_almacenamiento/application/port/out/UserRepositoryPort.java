package com.example.app_almacenamiento.application.port.out;

import com.example.app_almacenamiento.domain.dto.response.StatusResponse;
import com.example.app_almacenamiento.domain.model.User;

public interface UserRepositoryPort {

    StatusResponse saveUser(User user);
}
