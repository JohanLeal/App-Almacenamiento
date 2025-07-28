package com.example.app_almacenamiento.application.port.in;

import com.example.app_almacenamiento.domain.model.User;

import java.util.List;

public interface GetUserCase {

    List<User> getAllUsers();
}
