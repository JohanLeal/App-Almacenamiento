package com.example.app_almacenamiento.application.port.in;

import com.example.app_almacenamiento.domain.dto.response.LoginResponse;
import com.example.app_almacenamiento.infraestructure.in.dto.request.UserLogin;

public interface LoginUserCase {

    LoginResponse loginUser(UserLogin userLogin);
}
