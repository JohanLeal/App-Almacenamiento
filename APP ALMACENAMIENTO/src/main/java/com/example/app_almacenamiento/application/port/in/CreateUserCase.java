package com.example.app_almacenamiento.application.port.in;

import com.example.app_almacenamiento.domain.model.User;

public interface CreateUserCase {

    User createUser(User user);
}
