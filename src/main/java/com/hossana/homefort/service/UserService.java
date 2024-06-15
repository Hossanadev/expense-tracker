package com.hossana.homefort.service;

import com.hossana.homefort.dto.UserRequest;
import com.hossana.homefort.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    String createUser(UserRequest userRequest);
    String updateUser(UserRequest userRequest, Long id);
    String deleteUser(Long id);
}
