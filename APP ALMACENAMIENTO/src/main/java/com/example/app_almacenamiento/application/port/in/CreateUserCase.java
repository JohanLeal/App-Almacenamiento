package com.example.app_almacenamiento.application.port.in;

import com.example.app_almacenamiento.domain.dto.response.StatusResponse;
import com.example.app_almacenamiento.infraestructure.in.dto.request.UserRequest;

public interface CreateUserCase {

    StatusResponse createUser(UserRequest userRequest);
}
